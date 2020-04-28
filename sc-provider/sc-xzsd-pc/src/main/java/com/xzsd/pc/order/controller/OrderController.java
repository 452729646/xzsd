package com.xzsd.pc.order.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.order.entity.OrderDetailVO;
import com.xzsd.pc.order.entity.OrderVO;
import com.xzsd.pc.order.service.OrderService;
import com.xzsd.pc.order.entity.OrderInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
/**
 * @Description 订单删改查
 * @Author housum
 * @Date 2020-4-10
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private OrderService orderService;

    /**
     * 查询订单列表
     * @return App
     * @author housum
     * @date 2020-4-10
     */
    @PostMapping("listOrders")
    public AppResponse listOrder(OrderVO orderVO ){
        try{

            return orderService.listOrder(orderVO);
        }catch (Exception e){
            logger.error("查询订单列表异常",e);
            System.out.println(e.toString());
            throw e;
        }

    }

    /**
     * 查询该订单的详情
     * @retrun App
     * @author housum
     * @date 2020-4-10
     */
    @PostMapping("getListOrder")
    public AppResponse orderDetail(OrderDetailVO orderDetailVO,String orderId ){
        try{
            return orderService.orderDetail(orderDetailVO,orderId);
        }catch (Exception e){
            logger.error("查询订单详情异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改订单状态（订单到货）
     * @return App
     * @date 2020-4-10
     */
    @PostMapping("updateOrderState")
    public AppResponse updateOrderState (OrderInfo orderInfo){
        try {
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            orderInfo.setUserCode(userCode);
            return orderService.updateOrderState(orderInfo);
        } catch (Exception e) {
            logger.error("修改订单到货错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 修改订单状态（取消订单到货）
     * @return App
     * @date 2020-4-10
     */
    @PostMapping("orderCancelArrival")
    public AppResponse orderCancelArrival (String orderId,String version){
        try {
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            return orderService.orderCancelArrival(orderId,version,userCode);
        } catch (Exception e) {
            logger.error("修改取消订单到货错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改订单状态（订单已到货）
     * @return App
     * @date 2020-4-10
     */
    @PostMapping("orderTake")
    public AppResponse ordeTake (String orderId,String version){
        try {
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            return orderService.orderTake(orderId,version,userCode);
        } catch (Exception e) {
            logger.error("修改订单已取货错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改订单状态（取消订单已取货）
     * @return App
     * @date 2020-4-10
     */
    @PostMapping("orderCancelTake")
    public AppResponse orderCancelTake (String orderId,String version){
        try {
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            return orderService.orderCancelTake(orderId,version,userCode);
        } catch (Exception e) {
            logger.error("修改取消订单已取货错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改订单状态（取消订单）
     * @return App
     * @date 2020-4-10
     */
    @PostMapping("orderCancel")
    public AppResponse orderCancel (String orderId,String version){
        try {
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            return orderService.orderCancel(orderId,version,userCode);
        } catch (Exception e) {
            logger.error("修改取消订单错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }


}
