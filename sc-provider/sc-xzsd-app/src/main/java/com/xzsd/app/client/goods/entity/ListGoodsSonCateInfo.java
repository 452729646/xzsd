package com.xzsd.app.client.goods.entity;

import com.xzsd.app.client.commodityClassification.entity.ListSonCateGoodsInfo;

import java.util.List;

public class ListGoodsSonCateInfo {
    private List<ListSonCateGoodsInfo> twoClassifyList;

    public List<ListSonCateGoodsInfo> getTwoClassifyList() {
        return twoClassifyList;
    }

    public void setTwoClassifyList(List<ListSonCateGoodsInfo> twoClassifyList) {
        this.twoClassifyList = twoClassifyList;
    }
}
