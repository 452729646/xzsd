package com.xzsd.app.client.order.entity;

import java.math.BigDecimal;

public class GoodsListVO {
    /**
     * 商品编号
     */
    private String skuNo;
    /**
     * 图片url
     */
    private String pictureUrl;
    /**
     * 商品名称
     */
    private String skuName;
    /**
     * 介绍
     */
    private String detail;
    /**
     * 售价
     */
    private BigDecimal sellingPrice;
    /**
     * 购买数量
     */
    private int goodsCnt;

    public String getSkuNo() {
        return skuNo;
    }

    public void setSkuNo(String skuNo) {
        this.skuNo = skuNo;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getGoodsCnt() {
        return goodsCnt;
    }

    public void setGoodsCnt(int goodsCnt) {
        this.goodsCnt = goodsCnt;
    }
}
