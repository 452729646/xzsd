package com.xzsd.app.shopowner.order.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.shopowner.order.entity.OrderShopownerInfo;
import com.xzsd.app.shopowner.order.service.OrderShopownerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * APP店长端查看订单
 * @author housum
 * @date 2020-4-13
 */
@RestController
@RequestMapping("/orderShopowner")
public class OrderShopownerController {
    @Resource
    OrderShopownerService orderShopownerService;
    private static final Logger logger = LoggerFactory.getLogger(OrderShopownerController.class);

    /**
     * 查看该店长的订单列表
     * @param orderShopownerInfo
     * @return
     */
    @PostMapping("listOrder")
    public AppResponse listOrder(OrderShopownerInfo orderShopownerInfo){
        try {
            String userCode = SecurityUtils.getCurrentUserId();
            orderShopownerInfo.setUserCode(userCode);
            return orderShopownerService.listOrder(orderShopownerInfo);
        }catch (Exception e){
            logger.error("查询该店长订单异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 通过orderId来查询订单详情
     * @return App
     * @author housum
     * @date 2020-4-14
     */
    @PostMapping("orderDetailByOrderId")
    public AppResponse orderDetailByOrderId(OrderShopownerInfo orderShopownerInfo){
        try{
            String userCode = SecurityUtils.getCurrentUserId();
            orderShopownerInfo.setUserCode(userCode);
            return orderShopownerService.orderDetailByOrderId(orderShopownerInfo);
        }catch (Exception e){
            logger.error("查询该订单详情异常",e);
            System.out.println(e.toString());
            throw e;
        }

    }

    /**
     * 修改订单状态（订单到货）
     * @return App
     * @date 2020-4-10
     */
    @PostMapping("orderArrival")
    public AppResponse orderArrival (String orderId,String version){
        try {
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            return orderShopownerService.orderArrival(orderId,version,userCode);
        } catch (Exception e) {
            logger.error("修改订单到货错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改订单状态（订单已取货）
     * @return App
     * @date 2020-4-10
     */
    @PostMapping("orderTake")
    public AppResponse orderTake (String orderId,String version){
        try {
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            return orderShopownerService.orderTake(orderId,version,userCode);
        } catch (Exception e) {
            logger.error("修改订单已取货错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
