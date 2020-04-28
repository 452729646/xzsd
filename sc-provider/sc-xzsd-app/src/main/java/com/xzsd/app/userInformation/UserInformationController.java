package com.xzsd.app.userInformation;

import com.neusoft.core.exception.ScServerException;
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
 * 登录获取个人信息
 * @author housum
 * @date 2020-4-26
 */
@RestController
@RequestMapping("/userInformation")
public class UserInformationController {
    private static final Logger logger = LoggerFactory.getLogger(UserInformationController.class);

    @Resource UserInformationService userInformationService;
    @Resource UserService userService;

    @PostMapping("/getUser")
    public AppResponse getUser(UserInformationInfo userInformationInfo){
        try{
            String userCode = SecurityUtils.getCurrentUserId();
            userInformationInfo.setUserCode(userCode);
            return userInformationService.getUser(userInformationInfo);
        }catch (Exception e){
            logger.error("查询个人信息失败");
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
    @PostMapping("updateUserPassword")
    public AppResponse updatePwd(UserInformationInfo userInformationInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            userInformationInfo.setUserCode(userId);
            return userInformationService.updatePwd(userInformationInfo);
        } catch (Exception e) {
            logger.error("修改异常", e);
            throw new ScServerException("修改密码失败，请重试");
        }
    }
}
