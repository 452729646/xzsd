package com.xzsd.app.shopowner.user.controller;

import com.neusoft.core.exception.ScServerException;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;

import com.xzsd.app.client.user.service.UserService;
import com.xzsd.app.shopowner.user.entity.UserInfo;
import com.xzsd.app.shopowner.user.entity.UserShopownerInfo;
import com.xzsd.app.shopowner.user.service.UserShopownerService;
import org.apache.catalina.security.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * app店长端个人信息
 * @Author housum
 * @Date 2020-4-10
 */
@RestController
@RequestMapping("/userShopowner")
public class UserShopownerController {

    private static final Logger logger = LoggerFactory.getLogger(UserShopownerController.class);

    @Resource
    UserShopownerService userShopownerService;
    @Resource
    UserService userService;

    /**
     * 查询店长个人信息
     * @param userShopownerInfo
     * @return
     */
    @PostMapping("userDetail")
    private AppResponse userDetail(UserShopownerInfo userShopownerInfo){
        try{
            String userCode = SecurityUtils.getCurrentUserId();
            userShopownerInfo.setUserCode(userCode);
            return userShopownerService.userDetail(userShopownerInfo);
        }catch (Exception e){
            logger.error("查询用户详情异常",e);
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
        try {
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
