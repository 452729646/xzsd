package com.xzsd.app.shopowner.order.service;

import com.neusoft.core.restful.AppResponse;


import com.xzsd.app.shopowner.order.dao.OrderShopownerDao;

import com.xzsd.app.shopowner.order.entity.OrderShopownerInfo;
import com.xzsd.app.shopowner.order.entity.OrderShopownerVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
        String storeNo = orderShopownerDao.selectStoreNo(orderShopownerInfo.getUserCode());
        orderShopownerInfo.setStoreNo(storeNo);
        List<OrderShopownerVO> listInfoOrder = orderShopownerDao.listOrderByStoreNoByPage(orderShopownerInfo);
        return AppResponse.success("查询成功", getPageInfo(listInfoOrder));
    }

    /**
     * 通过OrderId查询该订单详情
     * @param orderShopownerInfo
     * @author housum
     * @date 2020-4-20
     */
    public AppResponse orderDetailByOrderId(OrderShopownerInfo orderShopownerInfo){
        OrderShopownerVO orderDetail = orderShopownerDao.orderDetailByOrderId(orderShopownerInfo);
        return AppResponse.success("查询成功",orderDetail);
    }
}
