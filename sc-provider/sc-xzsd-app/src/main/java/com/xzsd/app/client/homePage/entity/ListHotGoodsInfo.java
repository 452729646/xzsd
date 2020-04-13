package com.xzsd.app.client.homePage.entity;

import java.math.BigDecimal;

/**
 * 主页 查询热门商品列表
 */
public class ListHotGoodsInfo {
    /**
     * 热门商品编号
     */
    private String hotGoodsCode;
    /**
     * 排序
     */
    private int sortNo;
    /**
     * 商品编码
     */
    private String skuNo;
    /**
     * 商品照片url
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

    public String getHotGoodsCode() {
        return hotGoodsCode;
    }

    public void setHotGoodsCode(String hotGoodsCode) {
        this.hotGoodsCode = hotGoodsCode;
    }

    public int getSortNo() {
        return sortNo;
    }

    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
    }

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
