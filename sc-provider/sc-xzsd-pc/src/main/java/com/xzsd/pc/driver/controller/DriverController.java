package com.xzsd.pc.driver.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.driver.dao.DriverDao;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/driver")
public class DriverController {
    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);

    @Resource
    private DriverService driverService;

    /**
     * 新增司机
     * @return app
     * @author housum
     * @date 2020-4-8
     */
    @PostMapping("saveDriver")
    public AppResponse saveDriver (DriverInfo driverInfo){
        try{
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            driverInfo.setCreateBy(userCode);
            AppResponse appResponse = driverService.saveDriver(driverInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("新增商店失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询司机列表
     * @return app
     * @author housum
     * @date 2020-4-8
     */
    @PostMapping("listDriver")
    public AppResponse driverList(DriverInfo driverInfo){
        try {
            return driverService.listDriver(driverInfo);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查看该司机详情信息
     * @return app
     * @author housum
     * @date 2020-4-8
     */
    @PostMapping("driverDetail")
    public AppResponse driverDetail(String driverNo,int version){
        try{
            return driverService.driverDetail(driverNo,version);

        }catch (Exception e){
            logger.error("查询该司机详情异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改司机信息
     * @return app
     * @author housum
     * @date 2020-4-8
     */
    @PostMapping("updateDriver")
    public AppResponse updateDriver(DriverInfo driverInfo){
        try{
            String userCode = SecurityUtils.getCurrentUserId();
            driverInfo.setLastModifiedBy(userCode);
            return driverService.updateDriver(driverInfo);
        }catch(Exception e){
            logger.error("修改司机信息错误");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除司机信息
     */
    @PostMapping("deleteDriver")
    public AppResponse deleteDriver(String driverNo){
        try{
            String userCode = SecurityUtils.getCurrentUserId();
            return driverService.deleteDriver(driverNo,userCode);

        }catch (Exception e){
            logger.error("删除司机信息失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }





}