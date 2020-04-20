package com.xzsd.app.client.order.dao;

import com.xzsd.app.client.order.entity.EvaluateInfo;
import com.xzsd.app.client.order.entity.OrderInfo;
import com.xzsd.app.client.order.entity.OrderVO;
import com.xzsd.app.client.order.entity.StockInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrderDao {
    /**
     * 新增订单
     * @param
     */
    int saveOrderSon(List<Map> mapList);

    /**
     * 新增主表订单
     * @param orderInfo
     * @param orderId 订单编号
     * @param sum 总价
     * @param total
     */
    int saveOrderFather(@Param("orderInfo") OrderInfo orderInfo, @Param("orderId")String orderId, @Param("sum")BigDecimal sum, @Param("userCode") String userCode,@Param("total") BigDecimal total,@Param("storeNo") String storeNo);


    /**
     * 新增订单时减少库存
     * @param mapList
     * @param
     * @return
     */
    int countStock(List<Map> mapList);

    /**
     * 检查是否库存充足
     * @param mapList
     * @return
     */
    List<String> countCheckStock(List<Map> mapList);

    /**
     * 查询该用户的订单
     * @param orderVO
     *
     */
    List<OrderVO> listOrderByUserCodeByPage(OrderVO orderVO);

    /**
     * 通过orderId查询订单详情
     * @param
     */
    OrderVO orderDetailByOrderId(OrderInfo orderInfo);

    /**
     * 评价商品
     * @param evaluateInfo
     * @return
     */
    int appraiseByOrderId(EvaluateInfo evaluateInfo);

    /**
     * 修改订单已完成
     * @param evaluateInfo
     * @return
     */
    int updateOrderComplete(EvaluateInfo evaluateInfo);

    /**
     * 通过userCode查出storeNo
     * @param userCode
     * @return
     */
    String selectStoreNo(@Param("userCode") String userCode);


}
