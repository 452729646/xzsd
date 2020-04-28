package com.xzsd.app.client.order.entity;

import java.math.BigDecimal;

public class GoodsListVO {
    /**
     * 商品编号
     */
    private String goodsId;
    /**
     * 图片url
     */
    private String goodsImagePath;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 介绍
     */
    private String goodsDescribe;
    /**
     * 售价
     */
    private String goodsPrice;
    /**
     * 购买数量
     */
    private int cartGoodsCount;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsImagePath() {
        return goodsImagePath;
    }

    public void setGoodsImagePath(String goodsImagePath) {
        this.goodsImagePath = goodsImagePath;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getCartGoodsCount() {
        return cartGoodsCount;
    }

    public void setCartGoodsCount(int cartGoodsCount) {
        this.cartGoodsCount = cartGoodsCount;
    }
}
