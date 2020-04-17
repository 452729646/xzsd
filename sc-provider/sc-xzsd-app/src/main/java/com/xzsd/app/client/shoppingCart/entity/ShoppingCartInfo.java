package com.xzsd.app.client.shoppingCart.entity;

import java.math.BigDecimal;

public class ShoppingCartInfo {
    /**
     * 购物车编码
     */
    private String shoppingCartCode;
    /**
     * 商品编码
     */
    private String skuNo;
    /**
     * 商品图片
     */
    private String pictureUrl;
    /**
     * 商品数量
     */
    private int goodsCnt;
    /**
     * 售价
     */
    private BigDecimal sellingPrice;
    /**
     * 用户编码
     */
    private String userCode;
    private int isDeleted;
    /**
     * 版本号
     */
    private int version;

    public String getShoppingCartCode() {
        return shoppingCartCode;
    }

    public void setShoppingCartCode(String shoppingCartCode) {
        this.shoppingCartCode = shoppingCartCode;
    }

    public String getSkuNo() {
        return skuNo;
    }

    public void setSkuNo(String skuNo) {
        this.skuNo = skuNo;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public int getGoodsCnt() {
        return goodsCnt;
    }

    public void setGoodsCnt(int goodsCnt) {
        this.goodsCnt = goodsCnt;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
