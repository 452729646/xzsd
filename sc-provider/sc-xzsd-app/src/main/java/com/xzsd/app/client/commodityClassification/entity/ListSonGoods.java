package com.xzsd.app.client.commodityClassification.entity;

import java.math.BigDecimal;

public class ListSonGoods {
    /**
     * 商品编码
     */
    private String skuNo;
    /**
     * 商品图片
     */
    private String pictureUrl;
    /**
     * 商品名称
     */
    private String skuName;
    /**
     * 商品售价
     */
    private BigDecimal sellingPrice;

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

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
