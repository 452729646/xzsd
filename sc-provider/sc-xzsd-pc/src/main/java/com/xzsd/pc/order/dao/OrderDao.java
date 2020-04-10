package com.xzsd.pc.order.dao;

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
    int orderArrival (List<Map> mapList);

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
}
