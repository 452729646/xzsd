package com.xzsd.pc.client.controller;


import com.neusoft.core.restful.AppResponse;

import com.xzsd.pc.client.entity.ClientInfo;
import com.xzsd.pc.client.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 客户查
 * @Author housum
 * @Date 2020-03-24
 */
@RestController
@RequestMapping("/client")
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Resource
    private ClientService clientService;
    /**
     * demo 客户列表(分页)
     * @param clientInfo
     * @return AppResponse
     * @author housum
     * @Date 2020-03-25
     */
    @RequestMapping(value = "listClients")
    public AppResponse listClient(ClientInfo clientInfo) {
        try {
            return clientService.listClient(clientInfo);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
