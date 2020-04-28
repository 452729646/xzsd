package com.xzsd.app.client.order.dao;

import com.xzsd.app.client.order.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;

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
     * @param
     * @param orderId 订单编号
     * @param sum 总价
     * @param total
     */
    int saveOrderFather( @Param("orderId")String orderId, @Param("sum")String sum, @Param("userCode") String userCode,@Param("total") int total,@Param("storeId") String storeId);


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
    List<String> countCheckStock(@Param("listSkuNo") List<String>listSkuNo);

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
    int appraiseByOrderId(List<EvaluateDO> evaluateDOS);

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
    /**
     * 修改订单状态
     * @param
     * @param
     * @author housum
     */
    int updateOrderState (StateInfo stateInfo);

    /**
     * 修改订单状态 取消订单
     * @param
     * @param
     * @author housum
     */
    int orderCancel (@Param("orderId")String orderId,@Param("version")String version,@Param("userCode")String userCode);

    List<GoodsListVO> goodsList(@Param("orderId") String orderId);

    int deletedShoppingCart(@Param("listShopCartId")List<String> listShopCartId,@Param("userCode")String userCode);

    List<EvaluateInfo> evaluateTotal(@Param("goodsIdList") List<String> goodsIdList);

    /**
     * 更新商品评分
     * @param mapList
     * @return
     */
    int UpdateStar(List<Map> mapList);

    /**
     * 更新状态为售罄
     * @param goodsId
     * @return
     */
    int updateSellout(@Param("goodsId") String goodsId);

    /**
     * 更新库存
     * @param mapGoodsList
     * @return
     */
    int updateStock(List<Map> mapGoodsList);

    /**
     * 更新销量
     * @param mapGoodsSaleList
     * @return
     */
    int updateSaleCnt(List<Map> mapGoodsSaleList);
}
