package com.xzsd.pc.order.entity;

import java.math.BigDecimal;

public class OrderDetailVO {
//    /**
//     * id
//     */
//    private int id;
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 商品编码
     */
    private String skuNo;
    /**
     * 商品名称
     */
    private String skuName;
    /**
     * 购买数量
     */
    private int goodsCnt;
    /**
     * 总金额
     */
    private BigDecimal orderMoney;
    /**
     * 售价
     */
    private BigDecimal sellingMoney;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSkuNo() {
        return skuNo;
    }

    public void setSkuNo(String skuNo) {
        this.skuNo = skuNo;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public int getGoodsCnt() {
        return goodsCnt;
    }

    public void setGoodsCnt(int goodsCnt) {
        this.goodsCnt = goodsCnt;
    }

    public BigDecimal getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(BigDecimal orderMoney) {
        this.orderMoney = orderMoney;
    }

    public BigDecimal getSellingMoney() {
        return sellingMoney;
    }

    public void setSellingMoney(BigDecimal sellingMoney) {
        this.sellingMoney = sellingMoney;
    }
}
