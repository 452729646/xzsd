package com.xzsd.pc.top.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.top.entity.TopInfo;
import com.xzsd.pc.top.service.TopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/topOfColumn")
public class TopController {
    private static final Logger logger = LoggerFactory.getLogger(TopController.class);
    @Resource
    TopService topService;

    @PostMapping("getTopOfColumn")
    public AppResponse getTopOfColumn(TopInfo topInfo){
        try{
            String userId = SecurityUtils.getCurrentUserId();
            topInfo.setUserId(userId);
            return topService.getTopOfColumn(topInfo);
        }catch (Exception e){
            logger.error("查询顶部栏异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
