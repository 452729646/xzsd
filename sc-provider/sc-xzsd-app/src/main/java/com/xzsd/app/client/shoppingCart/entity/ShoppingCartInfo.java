package com.xzsd.app.client.shoppingCart.entity;

import java.math.BigDecimal;

public class ShoppingCartInfo {
    /**
     * 购物车编码
     */
    private String shopCartId;
    /**
     * 商品编码
     */
    private String goodsId;
    /**
     * 商品名称
     */
    private String goodsName;



    /**
     * 商品图片
     */
    private String goodsImagePath;
    /**
     * 商品数量
     */
    private int cartGoodsCount;

    /**
     * 售价
     */
    private String goodsPrice;
    /**
     * 用户编码
     */
    private String userCode;
    private int isDeleted;
    /**
     * 版本号
     */
    private int version;

    public String getShopCartId() {
        return shopCartId;
    }

    public void setShopCartId(String shopCartId) {
        this.shopCartId = shopCartId;
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

    public String getGoodsImagePath() {
        return goodsImagePath;
    }

    public void setGoodsImagePath(String goodsImagePath) {
        this.goodsImagePath = goodsImagePath;
    }

    public int getCartGoodsCount() {
        return cartGoodsCount;
    }

    public void setCartGoodsCount(int cartGoodsCount) {
        this.cartGoodsCount = cartGoodsCount;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
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
