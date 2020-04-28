package com.xzsd.app.shopowner.driver.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.shopowner.driver.entity.DriverShopownerInfo;
import com.xzsd.app.shopowner.driver.service.DriverShopownerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * APP店长端查看相同地区的司机列表
 * @author housum
 * @date 2020-4-20
 */
@RestController
@RequestMapping("/managerInformation")
public class DriverShopownerController {
    private static final Logger logger = LoggerFactory.getLogger(DriverShopownerController.class);

    @Resource
    DriverShopownerService driverShopownerService;

    @PostMapping("listManagerDrivers")
    public AppResponse listDriver(DriverShopownerInfo driverShopownerInfo){
        try{
            //获取userCode
            String userCode = SecurityUtils.getCurrentUserId();
            driverShopownerInfo.setUserCode(userCode);
            return driverShopownerService.listDriver(driverShopownerInfo);
        }catch(Exception e){
            logger.error("查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
