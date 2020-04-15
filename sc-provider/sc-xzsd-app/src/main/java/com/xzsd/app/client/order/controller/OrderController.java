package com.xzsd.app.client.order.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.client.order.entity.EvaluateInfo;
import com.xzsd.app.client.order.entity.OrderInfo;
import com.xzsd.app.client.order.entity.OrderVO;
import com.xzsd.app.client.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/orderClient")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private OrderService orderService;

    /**
     * 新增订单
     * @return App
     * @author housum
     * @date 2020-4-9
     */
    @PostMapping("saveOrder")
    public AppResponse saveOrder(OrderInfo orderInfo, String skuNo2, String goodsCnt, String sellingMoney){
        try{
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            orderInfo.setCreateBy(userCode);
            orderInfo.setUserCode(userCode);
            orderInfo.setIsDeleted(0);
            AppResponse appResponse = orderService.saveOrder(orderInfo,skuNo2,goodsCnt,sellingMoney);
            return appResponse;
        }catch (Exception e){
            logger.error("新增订单失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询该用户订单列表
     * @return App
     * @author housum
     * @date 2020-4-10
     */
    @PostMapping("listOrder")
    public AppResponse listOrderByUserCode(OrderVO orderVO){
        try{
            String userCode = SecurityUtils.getCurrentUserId();
            orderVO.setUserCode(userCode);
            return orderService.listOrderByUserCode(orderVO);
        }catch (Exception e){
            logger.error("查询订单列表异常",e);
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
    public AppResponse orderDetailByOrderId(OrderInfo orderInfo){
        try{
            String userCode = SecurityUtils.getCurrentUserId();
            orderInfo.setUserCode(userCode);
            return orderService.orderDetailByOrderId(orderInfo);
        }catch (Exception e){
            logger.error("查询订单详情异常",e);
            System.out.println(e.toString());
            throw e;
        }

    }

    /**
     * 对已完成未评价的订单评价
     * @return App
     * @author housum
     * @date 2020-4-14
     */
    @PostMapping("appraiseByOrderId")
    public AppResponse appraiseByOrderId(EvaluateInfo evaluateInfo){
        try{
            String userCode = SecurityUtils.getCurrentUserId();
            evaluateInfo.setUserCode(userCode);

            AppResponse appResponse = orderService.appraiseByOrderId(evaluateInfo);;
            return appResponse;
        }catch (Exception e){
            logger.error("评价订单详情异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }






}
