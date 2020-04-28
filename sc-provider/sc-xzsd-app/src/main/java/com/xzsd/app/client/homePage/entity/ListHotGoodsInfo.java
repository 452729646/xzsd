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
    private String goodsId;
    /**
     * 商品照片url
     */
    private String goodsImagePath;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品售价
     */
    private String goodsPrice;

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

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
}
