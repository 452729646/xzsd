package com.xzsd.app.client.user.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;


import com.xzsd.app.client.user.dao.UserDao;
import com.xzsd.app.client.user.entity.UserInfo;
import com.xzsd.app.client.user.entity.UserVO;
import com.xzsd.app.client.user.utils.PasswordUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @DescriptionDemo 实现类
 * @Author housum
 * @Date 2020-04-13
 */
@Service
public class UserService {

    @Resource
    UserDao userDao;


    /**
     * 注册用户
     * @param userInfo
     * @return
     * @author housum
     * @date 2020-4-13
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse registerUser(UserInfo userInfo){
        //检验账号是否存在
        int countUserAcct = userDao.countUserAcct(userInfo);
        if (0 != countUserAcct){
            return AppResponse.bizError("此账号已存在,请重新输入");
        }
        if (!userInfo.getUserPwd().equals(userInfo.getUserPwd2())){
            return AppResponse.bizError("输入的密码不一致,请重新输入");
        }
        userInfo.setUserCode(StringUtil.getCommonCode(2));
        String password = PasswordUtils.generatePassword(userInfo.getUserPwd());
        userInfo.setUserPwd(password);
        userInfo.setIsDeleted(0);
//        在用户表注册用户
        int count = userDao.registerUser(userInfo);
        if (0 == count){
            return AppResponse.bizError("注册失败，请重试！");
        }
//        在客户表增加客户
        int count2 = userDao.saveClient(userInfo);
        if (0 == count2){
            return AppResponse.bizError("注册失败，请重试！");
        }
        return AppResponse.success("注册成功");
    }


    /**
     * 部门：南京软件研发中心
     * 功能：修改密码
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/30
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updatePwd(UserInfo userInfo) {
        AppResponse appResponse = AppResponse.success("修改密码成功！请重新登录");
        // 需要校验原密码是否正确
        if(null != userInfo.getUserPwd() && !"".equals(userInfo.getUserPwd())) {
            String oldPwd = PasswordUtils.generatePassword(userInfo.getUserPwd());
            System.out.println(oldPwd);
            // 获取用户信息
            String password = userDao.getPwdById(userInfo.getUserCode());
            System.out.println(password);
            if(null == password){
                return AppResponse.bizError("用户不存在或已被删除！");
            } else {
                if(!oldPwd.equals(password)){
                    return AppResponse.bizError("原密码不匹配，请重新输入！");
                }
            }
        }
        // 修改密码
        userInfo.setNewPwd(PasswordUtils.generatePassword(userInfo.getNewPwd()));
        int count = userDao.updateUserPwd(userInfo);
        if(0 == count) {
            appResponse = AppResponse.bizError("修改密码失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 修改邀请码
     * @param userInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateInviteCode(UserInfo userInfo){
        int countInviteCode = userDao.countInviteCode(userInfo.getInviteCode());
        if (0 == countInviteCode){
            return AppResponse.bizError("不存在此邀请码");
        }
        //修改邀请码
        int count = userDao.updateInviteCode(userInfo);
        if (0 == count){
            return AppResponse.bizError("修改失败");
        }
        return AppResponse.success("修改成功");
    }

    /**
     * 查询名称和头像
     * @param userInfo
     * @return
     */
    public AppResponse selectUserName(UserInfo userInfo){
        UserVO data = userDao.selectUserName(userInfo);
        return AppResponse.success("查询成功",data);
    }

    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateHeadPicture (UserInfo userInfo){
        int count = userDao.updateHeadPicture(userInfo);
        if(0 == count){
            return AppResponse.bizError("修改失败");
        }
        return AppResponse.success("修改成功");
    }

}
