package com.xzsd.pc.order.dao;

import com.xzsd.pc.order.entity.GoodsListInfo;
import com.xzsd.pc.order.entity.OrderDetailVO;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.entity.OrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName OrderDao
 * @Description
 * @Author housum
 * @Date 2020-04-10
 */
@Mapper
public interface OrderDao {
    /**
     * 查询订单列表
     * @param orderVO
//     * @param role 角色权限
//     * @param storeNo
     * @author housum
     */
    List<OrderVO> listOrderByPage (OrderVO orderVO);

    /**
     * 查询订单详细
     * @param orderId
     * @param
     * @author housum
     */
    List<OrderDetailVO> listOrderDetailByPage(OrderDetailVO orderDetailVO,@Param("orderId") String orderId);

    /**
     * 修改订单状态 订单到货
     * @param mapList
     * @param
     * @author housum
     */
    int updateOrderState (List<Map> mapList);

    /**
     * 修改订单状态 取消订单到货
     * @param mapList
     * @param
     * @author housum
     */
    int orderCancelArrival (List<Map> mapList);

    /**
     * 修改订单状态 订单已取货
     * @param mapList
     * @param
     * @author housum
     */
    int orderTake (List<Map> mapList);

    /**
     * 修改订单状态 取消订单已取货
     * @param mapList
     * @param
     * @author housum
     */
    int orderCancelTake (List<Map> mapList);

    /**
     * 修改订单状态 取消订单
     * @param mapList
     * @param
     * @author housum
     */
    int orderCancel (List<Map> mapList);

    /**
     * 通过userCode找到角色
     * @param userCode
     * @author housum
     */
    int roleByUserCode(@Param("userCode") String userCode);

    /**
     * 通过店长的userCode找到storeNo
     *
     */
    String storeNoByUserCode(@Param("userCode") String userCode);

    /**
     * 查询是否存在下单或者取货状态
     * @param listOrderId
     * @return
     */
    int countPlaceOrTake(@Param("listOrderId")List<String> listOrderId);

    /**
     * 查询是否存在已到货或者已完成未评价状态
     * @param listOrderId
     * @return
     */
    int countArrivalOr(@Param("listOrderId")List<String> listOrderId);

    /**
     * 查询是否存在已到货
     * @param listOrderId
     * @return
     */
    int countArrival(@Param("listOrderId")List<String> listOrderId);

    List<GoodsListInfo> goodsList(List<Map> mapList);

    int updateStock(List<Map> mapGoodsList);
}
