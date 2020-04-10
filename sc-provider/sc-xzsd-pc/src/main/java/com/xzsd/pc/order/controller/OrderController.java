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
    @PostMapping("listOrder")
    public AppResponse listOrder(OrderVO orderVO){
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
    @PostMapping("orderDetail")
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
    @PostMapping("orderArrival")
    public AppResponse orderArrival (String orderId,String version){
        try {
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            return orderService.orderArrival(orderId,version,userCode);
        } catch (Exception e) {
            logger.error("商品上架错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
