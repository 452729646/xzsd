package com.xzsd.pc.order.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

import static com.neusoft.core.page.PageUtils.getPageInfo;
/**
 * @DescriptionDemo 实现类
 * @Author housum
 * @Date 2020-04-9
 */
@Service
public class OrderService {
    @Resource OrderDao orderDao;
    /**
     * 查询订单列表
     * @param orderVO
     * @author housum
     * @date 2020-4-10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse listOrder(OrderVO orderVO){
        //没有登录 获取的userCode是测试用户  会报错
        String userCode = SecurityUtils.getCurrentUserId();
        String role = orderVO.getRole();
        if ("2".equals(role)){
            //拿出该店长的门店编号
            String storeNo = orderDao.storeNoByUserCode(userCode);
            orderVO.setStoreNo2(storeNo);
        }
        List<OrderVO> listInfoOrder = orderDao.listOrderByPage(orderVO);
        return AppResponse.success("查询成功",getPageInfo(listInfoOrder));

    }

    /**
     * 查询订单详情
     * @param orderId
     * @param
     * @author housum
     * @date 2020-4-10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse orderDetail(OrderDetailVO orderDetailVO,String orderId){
        List<OrderDetailVO> listOrderDetail = orderDao.listOrderDetailByPage(orderDetailVO,orderId);
        OrderDeepenList orderDeepenList = new OrderDeepenList();
        orderDeepenList.setOrderDeepenList(listOrderDetail);
        return AppResponse.success("查询成功",orderDeepenList);

    }


    /**
     * 修改订单状态（订单到货）
     * @param
     * @param
     * @param
     * @author housum
     * @date 2020-4-10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderState(OrderInfo orderInfo){
        List<String> listOrderId = Arrays.asList(orderInfo.getOrderId().split(","));
        List<String> listVersion = Arrays.asList(orderInfo.getVersion().split(","));
        List<Map> mapList = new ArrayList<>();
        //把orderId对应的version 放进map  然后在mybaits用foreacn遍历
        for(int i =0 ;i<listOrderId.size(); i++){
            Map map = new HashMap();
            map.put("orderId",listOrderId.get(i));
            map.put("version",listVersion.get(i));
            map.put("orderStateId",orderInfo.getOrderStateId());
            map.put("userCode",orderInfo.getUserCode());
            mapList.add(map);
        }
        String orderStateId = orderInfo.getOrderStateId();
        if ("2".equals(orderStateId)){
            int count = orderDao.countPlaceOrTake(listOrderId);
            if (listOrderId.size() != count ){
                return AppResponse.bizError("订单状态未处于已下单或者已取货");
            }
        }
        if ("3".equals(orderStateId)){
            int count = orderDao.countArrivalOr(listOrderId);
            if (listOrderId.size() != count){
                return AppResponse.bizError("订单状态未处于已到货或者已完成未评价");
            }
        }
        if("0".equals(orderStateId)){
            int count = orderDao.countArrival(listOrderId);
            if (listOrderId.size() != count){
                return AppResponse.bizError("订单状态未处于已到货");
            }

        }
        if ("1".equals(orderStateId)){
            //订单取消时 商品数量返回库存
            List<GoodsListInfo> goodsListInfos = orderDao.goodsList(mapList);
            List<Map> mapGoodsList = new ArrayList<>();
                for (int i = 0;i < goodsListInfos.size();i++ ){
                    Map mapGoods = new HashMap();
                    mapGoods.put("goodsId",goodsListInfos.get(i).getGoodsId());
                    mapGoods.put("goodsCnt",goodsListInfos.get(i).getGoodsCnt());
                    mapGoodsList.add(mapGoods);
                }
            int countUpdateStock = orderDao.updateStock(mapGoodsList);
            if (0 == countUpdateStock){
                return AppResponse.bizError("返回库存失败");
            }
        }
        //更新订单状态
        int count = orderDao.updateOrderState(mapList);
        if (0 == count){
            return AppResponse.bizError("数据有更新，请重试！");
        }
        return AppResponse.success("修改订单状态成功！");
    }


    /**
     * 修改订单状态（取消订单到货）
     * @param orderId
     * @param version
     * @param userCode
     * @author housum
     * @date 2020-4-10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse orderCancelArrival(String orderId,String version,String userCode){
        List<String> listOrderId = Arrays.asList(orderId.split(","));
        List<String> listVersion = Arrays.asList(version.split(","));
        List<Map> mapList = new ArrayList<>();
        //把orderId对应的version 放进map  然后在mybaits用foreacn遍历
        for(int i =0 ;i<listOrderId.size(); i++){
            Map map = new HashMap();
            map.put("orderId",listOrderId.get(i));
            map.put("version",Integer.parseInt(listVersion.get(i)));
            map.put("userCode",userCode);
            mapList.add(map);
        }
        AppResponse appResponse = AppResponse.success("修改取消订单到货成功！");
        int count = orderDao.orderCancelArrival(mapList);
        if (0 == count){
            appResponse = AppResponse.bizError("数据有更新或者处于未到货状态，请重试！");
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
        List<String> listOrderId = Arrays.asList(orderId.split(","));
        List<String> listVersion = Arrays.asList(version.split(","));
        List<Map> mapList = new ArrayList<>();
        //把orderId对应的version 放进map  然后在mybaits用foreacn遍历
        for(int i =0 ;i<listOrderId.size(); i++){
            Map map = new HashMap();
            map.put("orderId",listOrderId.get(i));
            map.put("version",Integer.parseInt(listVersion.get(i)));
            map.put("userCode",userCode);
            mapList.add(map);
        }
        AppResponse appResponse = AppResponse.success("修改订单已取货成功！");
        int count = orderDao.orderTake(mapList);
        if (0 == count){
            appResponse = AppResponse.bizError("数据有更新或者处于已下单未到货状态，请重试！");
        }
        return appResponse;
    }

    /**
     * 修改订单状态（取消订单已取货）
     * @param orderId
     * @param version
     * @param userCode
     * @author housum
     * @date 2020-4-10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse orderCancelTake(String orderId,String version,String userCode){
        List<String> listOrderId = Arrays.asList(orderId.split(","));
        List<String> listVersion = Arrays.asList(version.split(","));
        List<Map> mapList = new ArrayList<>();
        //把orderId对应的version 放进map  然后在mybaits用foreacn遍历
        for(int i =0 ;i<listOrderId.size(); i++){
            Map map = new HashMap();
            map.put("orderId",listOrderId.get(i));
            map.put("version",Integer.parseInt(listVersion.get(i)));
            map.put("userCode",userCode);
            mapList.add(map);
        }
        AppResponse appResponse = AppResponse.success("修改取消订单已取货成功！");
        int count = orderDao.orderCancelTake(mapList);
        if (0 == count){
            appResponse = AppResponse.bizError("数据有更新或者未处于已取货状态，请重试！");
        }
        return appResponse;
    }

    /**
     * 修改订单状态（取消订单）
     * @param orderId
     * @param version
     * @param userCode
     * @author housum
     * @date 2020-4-10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse orderCancel(String orderId,String version,String userCode){
        List<String> listOrderId = Arrays.asList(orderId.split(","));
        List<String> listVersion = Arrays.asList(version.split(","));
        List<Map> mapList = new ArrayList<>();
        //把orderId对应的version 放进map  然后在mybaits用foreacn遍历
        for(int i =0 ;i<listOrderId.size(); i++){
            Map map = new HashMap();
            map.put("orderId",listOrderId.get(i));
            map.put("version",Integer.parseInt(listVersion.get(i)));
            map.put("userCode",userCode);
            mapList.add(map);
        }
        AppResponse appResponse = AppResponse.success("修改取消订单已取货成功！");
        int count = orderDao.orderCancel(mapList);
        if (0 == count){
            appResponse = AppResponse.bizError("数据有更新，请重试！");
        }
        return appResponse;
    }

}
