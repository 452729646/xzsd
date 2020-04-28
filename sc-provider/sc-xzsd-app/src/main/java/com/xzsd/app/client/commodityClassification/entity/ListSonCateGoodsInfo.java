package com.xzsd.app.client.commodityClassification.entity;

import java.util.List;

public class ListSonCateGoodsInfo {
    /**
     * 父分类编码
     */
    private String classifyId;
    /**
     * 子分类编码
     */
    private String classifyName;
    /**
     * 子分类名称
     */
    private String cateNameSon;
    /**
     * 对应子分类商品list
     */
    private List<ListSonGoods> goodsList;


    public String getCateNameSon() {
        return cateNameSon;
    }

    public void setCateNameSon(String cateNameSon) {
        this.cateNameSon = cateNameSon;
    }

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public List<ListSonGoods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<ListSonGoods> goodsList) {
        this.goodsList = goodsList;
    }
}
