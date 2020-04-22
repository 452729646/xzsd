package com.xzsd.app.client.order.entity;

public class EvaluateDO {
    /**
     * 评价编码
     */
    private String evaluateId;
    /**
     * 商品编码
     */
    private String skuNo;
    /**
     * 评价内容
     */
    private String appraiseInfo;
    /**
     * 图片url
     */
    private String image;
    /**
     * 星级评价
     */
    private String starLevel;
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 用户编码
     */
    private String userCode;
    private String storeNo;

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }

    public String getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(String evaluateId) {
        this.evaluateId = evaluateId;
    }

    public String getSkuNo() {
        return skuNo;
    }

    public void setSkuNo(String skuNo) {
        this.skuNo = skuNo;
    }

    public String getAppraiseInfo() {
        return appraiseInfo;
    }

    public void setAppraiseInfo(String appraiseInfo) {
        this.appraiseInfo = appraiseInfo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(String starLevel) {
        this.starLevel = starLevel;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
