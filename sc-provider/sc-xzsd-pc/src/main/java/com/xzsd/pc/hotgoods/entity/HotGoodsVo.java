package com.xzsd.pc.hotgoods.entity;

import java.math.BigDecimal;

/**
 * 传给前端  热门商品
 */
public class HotGoodsVo {

    /**
     * 热门商品编号
     */
    private String hotGoodsCode;
    /**
     * 排序
     */
    private int sortNo;
    /**
     * 商品编号
     */
    private String skuNo;
    private String skuName;
    /**
     * 售价
     */
    private BigDecimal sellingPrice;
    /**
     * 介绍
     */
    private String detail;

    /**
     * 版本号
     */
    private String version;



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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
