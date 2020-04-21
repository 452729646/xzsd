package com.xzsd.app.client.order.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.client.order.entity.EvaluateInfo;
import com.xzsd.app.client.order.entity.OrderInfo;
import com.xzsd.app.client.order.dao.OrderDao;
import com.xzsd.app.client.order.entity.OrderVO;
import com.xzsd.app.client.order.entity.StockInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @DescriptionDemo 实现类
 * @Author housum
 * @Date 2020-04-9
 */
@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;






    /**
     * 新增订单
     * @param orderInfo
     * @return
     * @author housum
     * @date 2020-4-9
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveOrder(OrderInfo orderInfo, String skuNo2, String goodsCnt, String sellingMoney) {
       //把goodsCnt skuN2 sellingMoney放进对应的list
        List<String> listGoodsCnt = Arrays.asList(goodsCnt.split(","));
        List<String> listSellingMoney = Arrays.asList(sellingMoney.split(","));
        List<String> listSkuNo = Arrays.asList(skuNo2.split(","));
        //算出这个订单的总价
        BigDecimal sum = new BigDecimal("0");
//        用于计算该订单的物品总数量
        BigDecimal total = new BigDecimal("0");
        for (int i = 0; i < listSkuNo.size(); i++) {
            BigDecimal a = new BigDecimal(listGoodsCnt.get(i)).multiply(new BigDecimal(listSellingMoney.get(i)));
            total = total.add(new BigDecimal(listGoodsCnt.get(i)));
            sum = sum.add(a);
        }
        //通过userCode拿出storeNo
        String storeNo = orderDao.selectStoreNo(orderInfo.getUserCode());
        if (null == storeNo ||"".equals(storeNo)){
            return AppResponse.bizError("您还没有绑定门店邀请码");
        }
        //生成订单id
        String orderId = StringUtil.getCommonCode(6);
        String userCode = orderInfo.getUserCode();
        List<Map> mapList = new ArrayList<>();
        for (int i = 0; i < listSkuNo.size(); i++){
            Map map = new HashMap();
            BigDecimal totalPrice = new BigDecimal(listGoodsCnt.get(i)).multiply(new BigDecimal(listSellingMoney.get(i)));
            map.put("orderId",orderId);
            map.put("skuNo",listSkuNo.get(i));
            map.put("goodsCnt2",listGoodsCnt.get(i));
            map.put("sellingPrice",listSellingMoney.get(i));
            map.put("totalPrice",totalPrice);
            map.put("userCode",userCode);
            mapList.add(map);
        }
        System.out.println(mapList);
        //检查查询库存充足
        List<String> countCheckStock = orderDao.countCheckStock(mapList);
        for(int i = 0; i<listSkuNo.size(); i++){
            if (0 > Integer.valueOf(countCheckStock.get(i)) - Integer.valueOf(listGoodsCnt.get(i))){
                return AppResponse.bizError("库存不足");
            }
        }
        //减少库存
        int countStock = orderDao.countStock(mapList);
        if (0 == countStock){
            return  AppResponse.bizError("删除库存，请重试！");
        }
        //生成父类订单
        int count = orderDao.saveOrderFather(orderInfo, orderId, sum, userCode,total,storeNo);
        if (0 == count ){
            return AppResponse.bizError("新增失败，请重试！");
        }
        //生成子订单
        int count2 = orderDao.saveOrderSon(mapList);
        if (count2 == 0) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增订单成功");

    }

    /**
     * 查询该用户的订单列表
     * @param orderVO
     * @author housum
     * @date 2020-4-14
     */

    public AppResponse listOrderByUserCode(OrderVO orderVO) {
        List<OrderVO> listInfoOrder = orderDao.listOrderByUserCodeByPage(orderVO);
        return AppResponse.success("查询成功", getPageInfo(listInfoOrder));
    }


    /**
     * 通过OrderId查询该订单详情
     * @param orderInfo
     * @author housum
     * @date 2020-4-14
     */
    public AppResponse orderDetailByOrderId(OrderInfo orderInfo){
        OrderVO orderDetail = orderDao.orderDetailByOrderId(orderInfo);
        return AppResponse.success("查询成功",orderDetail);
    }


    /**
     * 评价订单
     * @param
     * @author housum
     * @date 2020-4-14
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse appraiseByOrderId(EvaluateInfo evaluateInfo){
        //        完成评价 修改订单状态
        int count2 = orderDao.updateOrderComplete(evaluateInfo);
        if (0 == count2){
            return  AppResponse.bizError("修改订单已完成失败");
        }
        evaluateInfo.setListSkuNo(Arrays.asList(evaluateInfo.getSkuNo().split(",")));
        evaluateInfo.setListStarLevel(Arrays.asList(evaluateInfo.getStarLevel().split(",")));
        evaluateInfo.setListAppraiseInfo(Arrays.asList(evaluateInfo.getAppraiseInfo().split("&&&")));
        evaluateInfo.setListPictureUrl(Arrays.asList(evaluateInfo.getPhotoUrl().split("&&&")));
        List<Map> mapList = new ArrayList<>();
        //把对应的属性 放进map  然后在mybaits用foreacn遍历
        for(int i =0 ;i<evaluateInfo.getListSkuNo().size(); i++){
            Map map = new HashMap();
            map.put("skuNo",evaluateInfo.getListSkuNo().get(i));
            map.put("starLevel",Integer.parseInt(evaluateInfo.getListStarLevel().get(i)));
            map.put("appraiseInfo",evaluateInfo.getListAppraiseInfo().get(i));
            map.put("photoUrl",evaluateInfo.getListPictureUrl().get(i));
            mapList.add(map);
        }
        evaluateInfo.setMapList(mapList);
        evaluateInfo.setIsDeleted(0);
//        AppResponse appResponse = AppResponse.success("评价商品成功！");
        int count = orderDao.appraiseByOrderId(evaluateInfo);
        if (0 == count){
            return AppResponse.bizError("评价商品失败，请重试！");
        }
        return AppResponse.success("评价商品成功！");
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
        int count = orderDao.orderTake(orderId,version,userCode);
        if (0 == count){
            appResponse = AppResponse.bizError("数据有更新，请重试！");
        }
        return appResponse;
    }




}
