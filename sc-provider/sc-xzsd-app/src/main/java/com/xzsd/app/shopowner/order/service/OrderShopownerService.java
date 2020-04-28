package com.xzsd.app.shopowner.order.service;

import com.neusoft.core.restful.AppResponse;


import com.xzsd.app.shopowner.order.dao.OrderShopownerDao;

import com.xzsd.app.shopowner.order.entity.OrderShopownerInfo;
import com.xzsd.app.shopowner.order.entity.OrderShopownerVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @DescriptionDemo 实现类
 * @Author housum
 * @Date 2020-04-20
 */
@Service
public class OrderShopownerService {
    @Resource
    private OrderShopownerDao orderShopownerDao;

    /**
     * 查询该店长的订单列表
     * @param orderShopownerInfo
     * @return
     */
    public AppResponse listOrder(OrderShopownerInfo orderShopownerInfo){
        //通过店长userCode 查询到storeNo
        String storeNo = orderShopownerDao.selectStoreNo(orderShopownerInfo.getUserId());
//        return AppResponse.success("sda",storeNo);
        orderShopownerInfo.setStoreNo(storeNo);
        List<OrderShopownerInfo> listInfoOrder = orderShopownerDao.listOrderByStoreNoByPage(orderShopownerInfo);
        return AppResponse.success("查询成功", getPageInfo(listInfoOrder));
    }

    /**
     * 通过OrderId查询该订单详情
     * @param orderShopownerInfo
     * @author housum
     * @date 2020-4-20
     */
    public AppResponse orderDetailByOrderId(OrderShopownerInfo orderShopownerInfo){
        OrderShopownerInfo orderDetail = orderShopownerDao.orderDetailByOrderId(orderShopownerInfo);
        return AppResponse.success("查询成功",orderDetail);
    }

    /**
     * 修改订单状态
     * @param orderShopownerInfo
     * @author housum
     * @date 2020-4-10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderState(OrderShopownerInfo orderShopownerInfo){
        AppResponse appResponse = AppResponse.success("修改订单状态成功！");
        int count = orderShopownerDao.updateOrderState(orderShopownerInfo);
        if (0 == count){
            appResponse = AppResponse.bizError("数据有更新，请重试！");
        }
        return appResponse;
    }

    /**
     * 修改订单状态（订单已取货）
     * @param orderId
     * @param version
     * @param userCode
     * @author housum
     * @date 2020-4-10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse orderTake(String orderId,String version,String userCode){
        AppResponse appResponse = AppResponse.success("修改订单已取货成功！");
        int count = orderShopownerDao.orderTake(orderId,version,userCode);
        if (0 == count){
            appResponse = AppResponse.bizError("数据有更新，请重试！");
        }
        return appResponse;
    }

    /**
     * 修改订单状态（订单取消）
     * @param orderId
     * @param version
     * @param userCode
     * @author housum
     * @date 2020-4-10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse orderCancel(String orderId,String version,String userCode){
        AppResponse appResponse = AppResponse.success("修改取消订单成功！");
        int count = orderShopownerDao.orderCancel(orderId,version,userCode);
        if (0 == count){
            appResponse = AppResponse.bizError("数据有更新，请重试！");
        }
        return appResponse;
    }
}
