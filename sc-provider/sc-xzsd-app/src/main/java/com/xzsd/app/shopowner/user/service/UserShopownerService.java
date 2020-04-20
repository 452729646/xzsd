package com.xzsd.app.shopowner.user.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.client.user.dao.UserDao;
import com.xzsd.app.client.user.utils.PasswordUtils;
import com.xzsd.app.shopowner.driver.dao.DriverShopownerDao;
import com.xzsd.app.shopowner.user.dao.UserShopownerDao;
import com.xzsd.app.shopowner.user.entity.UserInfo;
import com.xzsd.app.shopowner.user.entity.UserShopownerInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 *  实现类
 * @Author housum
 * @Date 2020-04-9
 */
@Service
public class UserShopownerService {
    @Resource
    UserShopownerDao userShopownerDao;
    @Resource
    DriverShopownerDao driverShopownerDao;



    /**
     * 查询店长个人信息
     * @param userShopownerInfo
     * @return
     */
    public AppResponse userDetail(UserShopownerInfo userShopownerInfo){
        //通过店长的userCode查询storeNo
        String storeNo = driverShopownerDao.selectStoreNo(userShopownerInfo.getUserCode());
        userShopownerInfo.setStoreNo(storeNo);
        UserShopownerInfo data = userShopownerDao.userDetail(userShopownerInfo);
        return AppResponse.success("查询成功",data);
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
            String password = userShopownerDao.getPwdById(userInfo.getUserCode());
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
        int count = userShopownerDao.updateUserPwd(userInfo);
        if(0 == count) {
            appResponse = AppResponse.bizError("修改密码失败，请重试！");
        }
        return appResponse;
    }
}
