package com.xzsd.app.client.user.controller;

import com.neusoft.core.exception.ScServerException;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.client.user.dao.UserDao;
import com.xzsd.app.client.user.entity.UserInfo;
import com.xzsd.app.client.user.entity.UserVO;
import com.xzsd.app.client.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * APP客户端
 * @author housum
 * @date 2020-4-13
 */
@RestController
@RequestMapping("/userClient")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource UserService userService;


    /**
     * 用户注册
     * @return App
     * @author housum
     * @date 2020-4-13
     */
    @PostMapping("registerUser")
    public AppResponse registerUser(UserInfo userInfo){
        try{
            AppResponse appResponse = userService.registerUser(userInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("注册失败",e);
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
            return userService.updatePwd(userInfo);
        } catch (Exception e) {
            logger.error("修改异常", e);
            throw new ScServerException("修改密码失败，请重试");
        }
    }

    /**
     * 修改邀请码
     * @param userInfo
     * @return
     */
    @PostMapping("updateInviteCode")
    public AppResponse updateInviteCode(UserInfo userInfo){
        try{
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            userInfo.setUserCode(userCode);
            return userService.updateInviteCode(userInfo);
        }catch (Exception e){
            logger.error("修改邀请码失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询名称 和头像图片
     * @param userInfo
     * @return
     */
    @PostMapping("selectUserName")
    public AppResponse selectUserName(UserInfo userInfo){
        try{
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            userInfo.setUserCode(userCode);
            return userService.selectUserName(userInfo);
        }catch (Exception e){
            logger.error("查询名称失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @PostMapping("updateHeadPicture")
    public AppResponse updateHeadPicture(UserInfo userInfo){
        try{
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            userInfo.setUserCode(userCode);
            return userService.updateHeadPicture(userInfo);
        }catch (Exception e){
            logger.error("修改头像失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }


}
