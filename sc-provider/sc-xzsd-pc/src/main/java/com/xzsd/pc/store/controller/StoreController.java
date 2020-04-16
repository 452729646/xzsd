package com.xzsd.pc.store.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;

import com.xzsd.pc.store.entity.RegionInfo;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/store")
public class StoreController {
    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);

    @Resource
    private StoreService storeService;

    /**
     * 新增商品
     * @return App
     * @author housum
     * @date 2020-4-2
     */

    @PostMapping("saveStore")
    public AppResponse saveStore(StoreInfo storeInfo){
        try{
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            storeInfo.setCreateBy(userCode);
            AppResponse appResponse = storeService.saveStore(storeInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("新增商店失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 门店列表
     * @param storeInfo
     * @author housum
     * @Date 2020-04-2
     */
    @RequestMapping(value = "listStore")
    public AppResponse listStore(StoreInfo storeInfo){
        try{
            return  storeService.listStore(storeInfo);
        }catch (Exception e){
            logger.error("查询门店列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *查询门店详情
     * @param storeNo
     * @author housum
     * @date 2020-4-3
     */
    @RequestMapping("storeDetail")
    public AppResponse storeDetail(String storeNo ){
        try{
            return storeService.storeDetail(storeNo);
        }catch (Exception e) {
            logger.error("查询门店详情异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改门店信息
     * @author housum
     * @date 2020-4-3
     */
    @RequestMapping("updateStore")
    public  AppResponse updateStore(StoreInfo storeInfo){
        try{
            String userCode = SecurityUtils.getCurrentUserId();
            storeInfo.setLastModifiedBy(userCode);
            return storeService.updateStore(storeInfo);
        }catch (Exception e) {
            logger.error("修改门店信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除门店信息
     * @author housum
     * @date 2020-4-7
     */
    @RequestMapping("deleteStore")
    public AppResponse deleteStore(String storeNo){
        try{
            String userCode = SecurityUtils.getCurrentUserId();
            return storeService.deleteStore(storeNo,userCode);
        }catch (Exception e){
            logger.error("删除门店信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 地区 省的下拉框
     * @author housum
     * @date 2020-4-13
     */
    @RequestMapping("province")
    public AppResponse province(RegionInfo regionInfo){
        try{
            return storeService.province(regionInfo);
        }catch (Exception e){
            logger.error("查询地区信息错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 地区 市区下拉框
     * @author housum
     * @date 2020-4-13
     */
    @RequestMapping("city")
    public AppResponse city(RegionInfo regionInfo){
        try{
            return storeService.city(regionInfo);
        }catch (Exception e){
            logger.error("查询地区信息错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
