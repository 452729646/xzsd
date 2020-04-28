package com.xzsd.pc.order.entity;

import java.util.List;

public class GoodsListInfo {
    private String goodsId;
    private String goodsCnt;
    private List<GoodsListInfo> goodsList;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsCnt() {
        return goodsCnt;
    }

    public void setGoodsCnt(String goodsCnt) {
        this.goodsCnt = goodsCnt;
    }

    public List<GoodsListInfo> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsListInfo> goodsList) {
        this.goodsList = goodsList;
    }
}
