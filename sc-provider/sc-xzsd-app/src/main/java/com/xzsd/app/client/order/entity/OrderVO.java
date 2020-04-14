package com.xzsd.app.client.order.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderVO {
    /**
     * 订单id
     */
    private String orderId;

    /**
     * 商品列表
     */
    List<GoodsListVO> goodsListVOList;

    public List<GoodsListVO> getGoodsListVOList() {
        return goodsListVOList;
    }

    public void setGoodsListVOList(List<GoodsListVO> goodsListVOList) {
        this.goodsListVOList = goodsListVOList;
    }

    public int getGoodsTotal() {
        return goodsTotal;
    }

    public void setGoodsTotal(int goodsTotal) {
        this.goodsTotal = goodsTotal;
    }

    /**
     * 订单物品总数
     */
    private int goodsTotal;
    /**
     * 订单总价
     */
    private BigDecimal paymentMoney;
    /**
     * 订单状态
     */
    private int orderStatus;
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
    private String storeAddress;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
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

    private String createTime;
    private String payTime;
    /**
     * 版本号
     */
    private int version;



    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getPaymentMoney() {
        return paymentMoney;
    }

    public void setPaymentMoney(BigDecimal paymentMoney) {
        this.paymentMoney = paymentMoney;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
