package com.xzsd.app.client.order.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.app.client.order.entity.*;
import com.xzsd.app.client.order.dao.OrderDao;
import com.xzsd.app.client.shoppingCart.dao.ShoppingCartDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
     * @param
     * @return
     * @author housum
     * @date 2020-4-9
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveOrder(ShopInfo shopInfo) {
       //把goodsCnt skuN2 sellingMoney放进对应的list
//        return AppResponse.success("新增订单成功",shopInfo);
        String userCode = shopInfo.getUserCode();
        List<String> listGoodsCnt = Arrays.asList(shopInfo.getClientGoodsNum().split(","));
        List<String> listSellingMoney = Arrays.asList(shopInfo.getGoodsPrice().split(","));
        List<String> listSkuNo = Arrays.asList(shopInfo.getGoodsId().split(","));
        //算出这个订单的总价
        if (listGoodsCnt.size() == listSellingMoney.size() &&listSellingMoney.size() == listSkuNo.size()) {
            BigDecimal sum = new BigDecimal("0");
//        用于计算该订单的物品总数量
            int total = 0;
            for (int i = 0; i < listSkuNo.size(); i++) {
                BigDecimal a = new BigDecimal(listGoodsCnt.get(i)).multiply(new BigDecimal(listSellingMoney.get(i)));
                total = total + Integer.valueOf(listGoodsCnt.get(i));
                sum = sum.add(a);
            }
//        //通过userCode拿出storeNo
//        String storeNo = orderDao.selectStoreNo(orderInfo.getUserCode());
            String storeId = shopInfo.getStoreId();
            if (null == storeId || "".equals(storeId)) {
                return AppResponse.bizError("您还没有绑定门店邀请码");
            }
            //生成订单id
            String orderId = StringUtil.getCommonCode(6);
            List<Map> mapList = new ArrayList<>();
            for (int i = 0; i < listSkuNo.size(); i++) {
                Map map = new HashMap();
                BigDecimal totalPrice = new BigDecimal(listGoodsCnt.get(i)).multiply(new BigDecimal(listSellingMoney.get(i)));
                map.put("orderId", orderId);
                map.put("skuNo", listSkuNo.get(i));
                map.put("goodsCnt2", listGoodsCnt.get(i));
                map.put("sellingPrice", listSellingMoney.get(i));
                map.put("totalPrice", totalPrice.toString());
                map.put("userCode", userCode);
                mapList.add(map);
            }
            System.out.println(mapList);
            //检查查询库存充足
            List<String> countCheckStock = orderDao.countCheckStock(listSkuNo);
            for (int i = 0; i < listSkuNo.size(); i++) {
                if (0 > Integer.valueOf(countCheckStock.get(i)) - Integer.valueOf(listGoodsCnt.get(i))) {
                    return AppResponse.bizError("库存不足");
                }
                if (0 == Integer.valueOf(countCheckStock.get(i)) - Integer.valueOf(listGoodsCnt.get(i))){
                    //修改商品状态 售罄
                    int countUpdateSellOut = orderDao.updateSellout(listSkuNo.get(i));
                    if (0 == countUpdateSellOut){
                        return AppResponse.bizError("修改售罄失败");
                    }
                }
            }
            //减少库存
            int countStock = orderDao.countStock(mapList);
            if (0 == countStock) {
                return AppResponse.bizError("删除库存，请重试！");
            }
            //生成父类订单
            int count = orderDao.saveOrderFather(orderId, sum.toString(), userCode, total, storeId);
            if (0 == count) {
                return AppResponse.bizError("新增失败，请重试！");
            }
            //生成子订单
            int count2 = orderDao.saveOrderSon(mapList);
            if (count2 == 0) {
                return AppResponse.bizError("新增失败，请重试！");
            }
            //删除购物车
            if (!"0".equals(shopInfo.getShopCartId())){
                List<String> listShopCartId = Arrays.asList(shopInfo.getShopCartId().split(","));
                int count3 = orderDao.deletedShoppingCart(listShopCartId,userCode);
                if (0 == count3){
                    return AppResponse.bizError("购物车删除失败");
                }
            }
            return AppResponse.success("新增订单成功");
        }
        return AppResponse.bizError("新增失败");
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
     * 评价页面的商品列表
     * @param orderId
     * @return
     */
    public AppResponse appraiseGoodsList(String orderId){
        List<GoodsListVO> goodsListVOS = orderDao.goodsList(orderId);
        GoodListInfo goodListInfo = new GoodListInfo();
        goodListInfo.setGoodsList(goodsListVOS);
        return AppResponse.success("查询成功",goodListInfo);
    }

    /**
     * 评价订单
     * @param
     * @author housum
     * @date 2020-4-14
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse appraiseByOrderId(EvaluateInfo evaluateInfo){
        List<GoodsListVO> goodsListVOS = orderDao.goodsList(evaluateInfo.getOrderId());
        //把传过来的json拆分 封装成一个实体类list
        List<EvaluateDO> evaluateDOS = new ArrayList<>();
        for (int i = 0;i < goodsListVOS.size();i++){
            EvaluateDO evaluateDO = new EvaluateDO();
            evaluateDO.setEvaluateId(StringUtil.getCommonCode(4));
            evaluateDO.setSkuNo(evaluateInfo.getEvaluateList().get(i).getGoodsId());
            evaluateDO.setAppraiseInfo(evaluateInfo.getEvaluateList().get(i).getEvaluateContent());
//            evaluateDO.setImage(evaluateInfo.getEvaluateInfoList().get(i).getPhotoUrl());
            if (0 == evaluateInfo.getEvaluateList().get(i).getEvaluateScore()){
                return AppResponse.bizError("评价星级不能为空");
            }
            evaluateDO.setStarLevel(evaluateInfo.getEvaluateList().get(i).getEvaluateScore());
            evaluateDO.setOrderId(evaluateInfo.getOrderId());
            evaluateDO.setUserCode(SecurityUtils.getCurrentUserId());
            evaluateDOS.add(evaluateDO);
        }
        //完成评价 增加销量  把对应goodsId的购买数量放进mapGoodsList
        List<Map> mapGoodsSaleList = new ArrayList<>();
        for(int j = 0;j < goodsListVOS.size(); j++) {
            Map mapSaleGoods = new HashMap();
            mapSaleGoods.put("goodsId", goodsListVOS.get(j).getGoodsId());
            mapSaleGoods.put("goodsCnt", goodsListVOS.get(j).getCartGoodsCount());
            mapGoodsSaleList.add(mapSaleGoods);
        }
        //更新销量
        int countUpdateSaleCnt = orderDao.updateSaleCnt(mapGoodsSaleList);
        if (0 == countUpdateSaleCnt){
            return AppResponse.bizError("更新销量失败");
        }
        // 完成评价 修改订单状态
        int countUpdateOrderComplete = orderDao.updateOrderComplete(evaluateInfo);
        if (0 == countUpdateOrderComplete){
            return  AppResponse.bizError("修改订单已完成失败");
        }
        //新增评价
        int count = orderDao.appraiseByOrderId(evaluateDOS);
        if (0 == count){
            return AppResponse.bizError("评价商品失败，请重试！");
        }
        List<String> goodsIdList = new ArrayList<String>();
        for (int i = 0;i < goodsListVOS.size(); i++){
            goodsIdList.add(evaluateInfo.getEvaluateList().get(i).getGoodsId());
        }
        //先拿出评价的总星级数和评价总数
        List<EvaluateInfo> evaluateTotal = orderDao.evaluateTotal(goodsIdList);
        //把总星级数 总评价数 商品评分放进mapList
        List<Map> mapList = new ArrayList<>();
        for(int i = 0;i < goodsListVOS.size(); i++){
            Map map = new HashMap();
            map.put("evaluateTotal",evaluateTotal.get(i).getEvaluateTotal()+1);
            map.put("starTotal",evaluateTotal.get(i).getStarTotal()+evaluateInfo.getEvaluateList().get(i).getEvaluateScore());
            map.put("starLevel",new BigDecimal(evaluateTotal.get(i).getStarTotal()+evaluateInfo.getEvaluateList().get(i).getEvaluateScore())
                    .divide(new BigDecimal(evaluateTotal.get(i).getEvaluateTotal()+1), 1, RoundingMode.HALF_UP));
            map.put("goodsId",evaluateInfo.getEvaluateList().get(i).getGoodsId());
            mapList.add(map);
        }
        //修改商品评分
        int countUpdateStar = orderDao.UpdateStar(mapList);
        if (0 == countUpdateStar){
            return AppResponse.bizError("修改商品评分失败");
        }
        return AppResponse.success("评价商品成功！");
    }

    /**
     * 修改订单状态
     * @param
     * @param
     * @param
     * @author housum
     * @date 2020-4-10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderState(StateInfo stateInfo) {
        String orderStateId = stateInfo.getOrderStateId();
        if ("1".equals(orderStateId)){
            //订单取消时 商品数量返回库存
            List<GoodsListVO> goodsListInfos = orderDao.goodsList(stateInfo.getOrderId());
            List<Map> mapGoodsList = new ArrayList<>();
            for (int i = 0;i < goodsListInfos.size();i++ ){
                Map mapGoods = new HashMap();
                mapGoods.put("goodsId",goodsListInfos.get(i).getGoodsId());
                mapGoods.put("goodsCnt",goodsListInfos.get(i).getCartGoodsCount());
                mapGoodsList.add(mapGoods);
            }
            int countUpdateStock = orderDao.updateStock(mapGoodsList);
            if (0 == countUpdateStock){
                return AppResponse.bizError("返回库存失败");
            }
        }
        AppResponse appResponse = AppResponse.success("修改订单状态成功！");
        int count = orderDao.updateOrderState(stateInfo);
        if (0 == count){
            appResponse = AppResponse.bizError("数据有更新，请重试！");
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
        AppResponse appResponse = AppResponse.success("修改订单取消订单成功！");
        int count = orderDao.orderCancel(orderId,version,userCode);
        if (0 == count){
            appResponse = AppResponse.bizError("数据有更新，请重试！");
        }
        return appResponse;
    }




}
