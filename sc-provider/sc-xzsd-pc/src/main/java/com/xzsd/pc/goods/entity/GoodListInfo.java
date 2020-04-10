package com.xzsd.pc.goods.entity;

/**
 * 新增热门商品位的商品列表
 */
public class GoodListInfo {
    /**
     * 商品编号
     */
    private String skuNo;
    /**
     *
     */
    private String skuName;
    /**
     * 商品状态  0为未售 1为在售 初始为0
     */
    private int skuState;
    /**
     * 父级分类名称
     */
    private String cateParentName;
    /**
     * 子级分类名称
     */
    private String cateSonName;
    /**
     * 版本号
     */
    private String version;

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

    public int getSkuState() {
        return skuState;
    }

    public void setSkuState(int skuState) {
        this.skuState = skuState;
    }

    public String getCateParentName() {
        return cateParentName;
    }

    public void setCateParentName(String cateParentName) {
        this.cateParentName = cateParentName;
    }

    public String getCateSonName() {
        return cateSonName;
    }

    public void setCateSonName(String cateSonName) {
        this.cateSonName = cateSonName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
