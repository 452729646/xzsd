package com.xzsd.app.client.user.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.client.user.entity.UserInfo;
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
            //获取用户code
            String userCode = SecurityUtils.getCurrentUserId();
            userInfo.setCreateBy(userCode);

            AppResponse appResponse = userService.registerUser(userInfo);

            return appResponse;
        }catch (Exception e){
            logger.error("注册失败",e);
            System.out.println(e.toString());
            throw e;
        }

    }


}
