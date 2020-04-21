package com.xzsd.app.driver.user.controller;

import com.neusoft.core.exception.ScServerException;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.driver.user.entity.UserDriverInfo;
import com.xzsd.app.driver.user.service.UserDriverService;
import com.xzsd.app.shopowner.user.entity.UserInfo;
import com.xzsd.app.shopowner.user.service.UserShopownerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * app司机端个人信息管理
 * @author housum
 * @date 2020-4-21
 */
@RestController
@RequestMapping("/userDriver")
public class UserDriverController {
    private static final Logger logger = LoggerFactory.getLogger(UserDriverController.class);

    @Resource
    UserDriverService userDriverService;

    @Resource
    UserShopownerService userShopownerService;

    /**
     * 查询司机个人信息
     * @param userDriverInfo
     * @return
     */
    @PostMapping("userDetail")
    public AppResponse userDetail(UserDriverInfo userDriverInfo){
        try{
            //获取用户userCode
            String userCode = SecurityUtils.getCurrentUserId();
            userDriverInfo.setUserCode(userCode);
            return userDriverService.userDetail(userDriverInfo);
        }catch (Exception e){
            logger.error("查询个人信息异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 部门：南京软件研发中心
     * 功能：修改密码
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/30
     */
    @PostMapping("updatePwd")
    public AppResponse updatePwd(UserInfo userInfo) {
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            userInfo.setUserCode(userId);
            userInfo.setLastModifiedBy(userId);
            return userShopownerService.updatePwd(userInfo);
        } catch (Exception e) {
            logger.error("修改异常", e);
            throw new ScServerException("修改密码失败，请重试");
        }
    }
}
