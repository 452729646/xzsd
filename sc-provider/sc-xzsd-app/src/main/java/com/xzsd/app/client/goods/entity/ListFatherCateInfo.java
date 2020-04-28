package com.xzsd.app.client.goods.entity;

import com.xzsd.app.client.commodityClassification.entity.CommodityClassificationInfo;

import java.util.List;

public class ListFatherCateInfo {
    private List<CommodityClassificationInfo> oneClassifyList;

    public List<CommodityClassificationInfo> getOneClassifyList() {
        return oneClassifyList;
    }

    public void setOneClassifyList(List<CommodityClassificationInfo> oneClassifyList) {
        this.oneClassifyList = oneClassifyList;
    }
}
