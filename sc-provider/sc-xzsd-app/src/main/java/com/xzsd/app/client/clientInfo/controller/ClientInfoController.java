package com.xzsd.app.client.clientInfo.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.client.clientInfo.entity.ClientInfo;
import com.xzsd.app.client.clientInfo.service.ClientInfoService;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * 修改邀请码
 * @author housum
 * @date 2020-4-27
 */
@RestController
@RequestMapping("/clientInformation")
public class ClientInfoController {
    private static final Logger logger = LoggerFactory.getLogger(ClientInfoController.class);

    @Resource
    ClientInfoService clientInfoService;

    /**
     * 修改邀请码
     * @param clientInfo
     * @return
     */
    @PostMapping("updateClientInvite")
    public AppResponse updateClientInvite(ClientInfo clientInfo){
        try{
            String userCode = SecurityUtils.getCurrentUserId();
            clientInfo.setUserCode(userCode);
            return clientInfoService.updateClientInvite(clientInfo);
        }catch (Exception e){
            logger.error("修改邀请码异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
