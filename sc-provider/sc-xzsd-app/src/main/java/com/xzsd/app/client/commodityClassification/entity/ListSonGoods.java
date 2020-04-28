package com.xzsd.app.client.commodityClassification.entity;

import java.math.BigDecimal;

public class ListSonGoods {
    /**
     * 商品编码
     */
    private String goodsId;
    /**
     * 商品图片
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
