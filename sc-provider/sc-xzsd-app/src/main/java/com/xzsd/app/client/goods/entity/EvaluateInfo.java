package com.xzsd.app.client.goods.entity;

import java.util.List;

public class EvaluateInfo {
    /**
     * 商品编码
     */
    private String goodsId;
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
    /**
     * 评价内容
     */
    private String evaluateContent;
    /**
     * 评价时间
     */
    private String createTime;
    /**
     * 评价等级  1：好评 星级4~5 2：中评 星级3 3：差评 星级1~@
     */
    private String evaluateScore;
    /**
     * 评价列表
     */
    private List<EvaluateInfo> evaluateInfoList;

    public List<EvaluateInfo> getEvaluateInfoList() {
        return evaluateInfoList;
    }

    public void setEvaluateInfoList(List<EvaluateInfo> evaluateInfoList) {
        this.evaluateInfoList = evaluateInfoList;
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



    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }

    public String getEvaluateScore() {
        return evaluateScore;
    }

    public void setEvaluateScore(String evaluateScore) {
        this.evaluateScore = evaluateScore;
    }
}
