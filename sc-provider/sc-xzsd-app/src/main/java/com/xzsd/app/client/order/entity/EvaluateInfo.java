package com.xzsd.app.client.order.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class EvaluateInfo {
    /**
     * 评价id
     */
    private int id;
    /**
     * 用户编号
     */
    private String userCode;
    private String goodsId;
    /**
     * 订单号
     */
    private String orderId;

    /**
     * 门店编码
     */
    private String storeNo;
    /**
     * 评价的星级
     */
    private int evaluateScore;
    /**
     * 评价的内容
     */
    private String evaluateContent;
    /**
     * 评价的图片
     */
    private String photoUrl;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDeleted;

    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 更新时间
     */
    private Date gmtModified;
    /**
     * 更新者
     */
    private String lastModifiedBy;
    /**
     * 版本号
     */
    private String version;

    private List<String> listSkuNo;
    private List<String> listStarLevel;
    private List<String> listAppraiseInfo;
    private List<String> listPictureUrl;
    private List<Map> mapList;
    /**
     * 总评价数
     */
    private int evaluateTotal;
    /**
     * 总评价星级
     */
    private int starTotal;

    public int getEvaluateTotal() {
        return evaluateTotal;
    }

    public void setEvaluateTotal(int evaluateTotal) {
        this.evaluateTotal = evaluateTotal;
    }

    public int getStarTotal() {
        return starTotal;
    }

    public void setStarTotal(int starTotal) {
        this.starTotal = starTotal;
    }

    /**
     * 评价列表
     */
    private List<EvaluateInfo> evaluateList;

    public List<EvaluateInfo> getEvaluateList() {
        return evaluateList;
    }

    public void setEvaluateList(List<EvaluateInfo> evaluateList) {
        this.evaluateList = evaluateList;
    }

    public List<Map> getMapList() {
        return mapList;
    }

    public void setMapList(List<Map> mapList) {
        this.mapList = mapList;
    }

    public List<String> getListSkuNo() {
        return listSkuNo;
    }

    public void setListSkuNo(List<String> listSkuNo) {
        this.listSkuNo = listSkuNo;
    }

    public List<String> getListStarLevel() {
        return listStarLevel;
    }

    public void setListStarLevel(List<String> listStarLevel) {
        this.listStarLevel = listStarLevel;
    }

    public List<String> getListAppraiseInfo() {
        return listAppraiseInfo;
    }

    public void setListAppraiseInfo(List<String> listAppraiseInfo) {
        this.listAppraiseInfo = listAppraiseInfo;
    }

    public List<String> getListPictureUrl() {
        return listPictureUrl;
    }

    public void setListPictureUrl(List<String> listPictureUrl) {
        this.listPictureUrl = listPictureUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }

    public int getEvaluateScore() {
        return evaluateScore;
    }

    public void setEvaluateScore(int evaluateScore) {
        this.evaluateScore = evaluateScore;
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
