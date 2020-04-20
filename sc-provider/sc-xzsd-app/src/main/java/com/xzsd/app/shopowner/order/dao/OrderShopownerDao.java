package com.xzsd.app.shopowner.order.dao;


import com.xzsd.app.client.order.entity.OrderVO;
import com.xzsd.app.shopowner.order.entity.OrderShopownerInfo;
import com.xzsd.app.shopowner.order.entity.OrderShopownerVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * OrderShopownerDao
 * @author 45272
 */
@Mapper
public interface OrderShopownerDao {
    /**
     * 通过userCode查出storeNo
     * @param userCode
     * @return
     */
    String selectStoreNo(@Param("userCode")String userCode);
    /**
     * 通过StoreNo查询订单
     * @param orderShopownerInfo
     * @return
     */
    List<OrderShopownerVO> listOrderByStoreNoByPage(OrderShopownerInfo orderShopownerInfo);

    /**
     * 通过orderId查询订单详情
     * @param
     */
    OrderShopownerVO orderDetailByOrderId(OrderShopownerInfo orderShopownerInfo);
}
