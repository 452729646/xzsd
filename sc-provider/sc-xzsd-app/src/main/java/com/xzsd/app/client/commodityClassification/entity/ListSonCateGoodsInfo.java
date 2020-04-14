package com.xzsd.app.client.commodityClassification.entity;

import java.util.List;

public class ListSonCateGoodsInfo {
    /**
     * 父分类编码
     */
    private String cateCode;
    /**
     * 子分类编码
     */
    private String cateCodeSon;
    /**
     * 子分类名称
     */
    private String cateNameSon;
    /**
     * 对应子分类商品list
     */
    private List<ListSonGoods> listSonGoods;

    public String getCateCode() {
        return cateCode;
    }

    public void setCateCode(String cateCode) {
        this.cateCode = cateCode;
    }

    public String getCateCodeSon() {
        return cateCodeSon;
    }

    public void setCateCodeSon(String cateCodeSon) {
        this.cateCodeSon = cateCodeSon;
    }

    public String getCateNameSon() {
        return cateNameSon;
    }

    public void setCateNameSon(String cateNameSon) {
        this.cateNameSon = cateNameSon;
    }

    public List<ListSonGoods> getListSonGoods() {
        return listSonGoods;
    }

    public void setListSonGoods(List<ListSonGoods> listSonGoods) {
        this.listSonGoods = listSonGoods;
    }
}
