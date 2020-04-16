package com.xzsd.app.client.goods.entity;

import java.math.BigDecimal;

public class GoodsVO {
    /**
     * 商品编号
     */
    private String skuNo;
    /**
     * 商品图片url
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
     * 门店名称
     */
    private String storeName;

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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
