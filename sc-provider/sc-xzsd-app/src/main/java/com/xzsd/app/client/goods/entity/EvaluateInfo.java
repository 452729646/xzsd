package com.xzsd.app.client.goods.entity;

public class EvaluateInfo {
    /**
     * 商品编码
     */
    private String skuNo;
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 用户账号
     */
    private String userAcct;
    /**
     * 星级
     */
    private int starLevel;
    /**
     * 评价内容
     */
    private String appraiseInfo;
    /**
     * 评价时间
     */
    private String createTime;
    /**
     * 评价等级  1：好评 星级4~5 2：中评 星级3 3：差评 星级1~@
     */
    private int evaluateLevel;

    public int getEvaluateLevel() {
        return evaluateLevel;
    }

    public void setEvaluateLevel(int evaluateLevel) {
        this.evaluateLevel = evaluateLevel;
    }

    public String getSkuNo() {
        return skuNo;
    }

    public void setSkuNo(String skuNo) {
        this.skuNo = skuNo;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public int getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(int starLevel) {
        this.starLevel = starLevel;
    }

    public String getAppraiseInfo() {
        return appraiseInfo;
    }

    public void setAppraiseInfo(String appraiseInfo) {
        this.appraiseInfo = appraiseInfo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
