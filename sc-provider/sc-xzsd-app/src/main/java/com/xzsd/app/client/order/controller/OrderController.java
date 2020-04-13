package com.xzsd.app.client.order.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.client.order.entity.OrderInfo;
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

//    /**
//     * 查询订单列表
//     * @return App
//     * @author housum
//     * @date 2020-4-10
//     */
//    @PostMapping("listOrder")
//    public AppResponse listOrder(OrderInfo orderInfo){
//        try{
//            return orderService.listOrder(orderInfo);
//        }catch (Exception e){
//            logger.error("查询订单列表异常",e);
//            System.out.println(e.toString());
//            throw e;
//        }
//
//    }

}
