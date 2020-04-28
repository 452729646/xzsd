package com.xzsd.app.client.order.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderVO {
    /**
     * 订单id
     */
    private String orderId;
    private String orderStateId;

    public String getOrderStateId() {
        return orderStateId;
    }

    public void setOrderStateId(String orderStateId) {
        this.orderStateId = orderStateId;
    }

    /**
     * 商品列表
     */
    List<GoodsListVO> goodsList;

    public List<GoodsListVO> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsListVO> goodsList) {
        this.goodsList = goodsList;
    }

    /**
     * 订单物品总数
     */
    private int orderAllGoodsCount;
    /**
     * 订单总价
     */
    private String orderAllCost;

//    /**
////     * 支付状态
////     */
////    private int payStatus;
    /**
     * 门店编号
     */
    private String storeNo;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 门店地址
     */
    private String address;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 下单人用户编号
     */
    private String userCode;
    /**
     * 下单人电话
     */
    private String userPhone;
    /**
     * 付款时间
     */

    private String crateTime;
    private String payTime;
    /**
     * 版本号
     */
    private String version;


    public String getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(String crateTime) {
        this.crateTime = crateTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }


//    public int getPayStatus() {
//        return payStatus;
//    }
//
//    public void setPayStatus(int payStatus) {
//        this.payStatus = payStatus;
//    }

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public int getOrderAllGoodsCount() {
        return orderAllGoodsCount;
    }

    public void setOrderAllGoodsCount(int orderAllGoodsCount) {
        this.orderAllGoodsCount = orderAllGoodsCount;
    }

    public String getOrderAllCost() {
        return orderAllCost;
    }

    public void setOrderAllCost(String orderAllCost) {
        this.orderAllCost = orderAllCost;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
