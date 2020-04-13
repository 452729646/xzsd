package com.xzsd.app.order.dao;

import com.xzsd.app.order.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
@Mapper
public interface OrderDao {
    /**
     * 新增订单
     * @param orderInfo
     */
    int saveOrderSon(@Param("orderId")String orderId,@Param("skuNo")String skuNo,@Param("goodsCnt2") String goodsCnt2,@Param("sellingPrice")String sellingPrice,@Param("totalPrice")BigDecimal totalPrice,@Param("userCode") String userCode);

    /**
     * 新增主表订单
     * @param orderInfo
     * @param orderId 订单编号
     * @param sum 总价
     */
    int saveOrderFather(@Param("orderInfo") OrderInfo orderInfo, @Param("orderId")String orderId, @Param("sum")BigDecimal sum,@Param("userCode") String userCode);
}