package com.xzsd.app.driver.store.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.driver.store.entity.StoreInfo;
import com.xzsd.app.driver.store.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 查询与司机相同地区的门店列表
 * @author housum
 * @date 2020-4-21
 */
@RestController
@RequestMapping("/driverHome")
public class StoreController {
    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);

    @Resource
    StoreService storeService;

    /**
     * 门店列表
     * @param storeInfo
     * @return
     */
    @PostMapping("listDriverStores")
    private AppResponse listStore(StoreInfo storeInfo){
        try{
            String userCode = SecurityUtils.getCurrentUserId();
            storeInfo.setUserCode(userCode);
            return storeService.listStore(storeInfo);
        }catch (Exception e){
            logger.error("查询门店列表信息异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
