package com.xzsd.pc.hotgoods.entity;

import java.math.BigDecimal;

/**
 * 传给前端  热门商品
 */
public class HotGoodsVo {

    /**
     * 热门商品编号
     */
    private String hotGoodsId;
    /**
     * 排序
     */
    private int hotGoodsNum;
    /**
     * 商品编号
     */
    private String goodsId;
    private String goodsName;
    /**
     * 售价
     */
    private String goodsPrice;
    /**
     * 介绍
     */
    private String goodsDescribe;
    /**
     *
     * 展示数量
     */
    private int hotGoodsShowNum;
    /**
     * 版本号
     */
    private String version;


    public int getHotGoodsShowNum() {
        return hotGoodsShowNum;
    }

    public void setHotGoodsShowNum(int hotGoodsShowNum) {
        this.hotGoodsShowNum = hotGoodsShowNum;
    }

    public String getHotGoodsId() {
        return hotGoodsId;
    }

    public void setHotGoodsId(String hotGoodsId) {
        this.hotGoodsId = hotGoodsId;
    }

    public int getHotGoodsNum() {
        return hotGoodsNum;
    }

    public void setHotGoodsNum(int hotGoodsNum) {
        this.hotGoodsNum = hotGoodsNum;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
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

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
