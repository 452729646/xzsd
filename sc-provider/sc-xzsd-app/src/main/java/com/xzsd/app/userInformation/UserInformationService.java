package com.xzsd.app.userInformation;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.client.user.dao.UserDao;
import com.xzsd.app.client.user.utils.PasswordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.annotation.Resource;

/**
 * 登录获取个人信息
 * @author housum
 * @date 2020-4-26
 */
@Service
public class UserInformationService {
    @Resource UserInformationDao userInformationDao;
    @Resource UserDao userDao;

    public AppResponse getUser(UserInformationInfo userInformationInfo){
        String role = userDao.roleByUserCode(userInformationInfo.getUserCode());
        //店长
        if ("2".equals(role)){
            UserInformationInfo data = userInformationDao.getUserManager(userInformationInfo);
            return AppResponse.success("查询成功",data);
        }
        //司机
        if ("3".equals(role)){
            UserInformationInfo data = userInformationDao.getUserDriver(userInformationInfo);
            return AppResponse.success("查询成功",data);
        }
        //客户
        if ("4".equals(role)){
            UserInformationInfo data = userInformationDao.getUserClient(userInformationInfo);
            return AppResponse.success("查询成功",data);
        }
        return AppResponse.bizError("管理员无法登录");
    }

    /**
     *
     * 功能：修改密码
     * 描述：略
     *
     *
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updatePwd(UserInformationInfo userInformationInfo) {
        AppResponse appResponse = AppResponse.success("修改密码成功！请重新登录");
        // 需要校验原密码是否正确
        if(null != userInformationInfo.getUserPassword() && !"".equals(userInformationInfo.getUserPassword())) {
            String oldPwd = PasswordUtils.generatePassword(userInformationInfo.getUserPassword());
            System.out.println(oldPwd);
            // 获取用户信息
            String password = userDao.getPwdById(userInformationInfo.getUserCode());
            System.out.println(password);
            if(null == password){
                return AppResponse.bizError("用户不存在或已被删除！");
            } else {
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                //判断密码是否一致
                if(false == bCryptPasswordEncoder.matches(userInformationInfo.getUserPassword(),password)){
                    return AppResponse.bizError("原密码不匹配，请重新输入！");
                }
            }
        }
        // 修改密码
        userInformationInfo.setUserNewPassword(PasswordUtils.generatePassword(userInformationInfo.getUserNewPassword()));
        int count = userInformationDao.updateUserPwd(userInformationInfo);
        if(0 == count) {
            appResponse = AppResponse.bizError("修改密码失败，请重试！");
        }
        return appResponse;
    }
}
