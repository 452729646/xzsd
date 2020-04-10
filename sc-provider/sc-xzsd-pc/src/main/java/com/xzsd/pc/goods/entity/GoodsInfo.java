package com.xzsd.pc.goods.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GoodsInfo implements Serializable {
//    /**
//     * 页码
//     */
//    private int pageSize;
//    /**
//     * 页数
//     */
//    private int pageNum;

//    public int getPageSize() {
//        return pageSize;
//    }
//
//    public void setPageSize(int pageSize) {
//        this.pageSize = pageSize;
//    }
//
//    public int getPageNum() {
//        return pageNum;
//    }
//
//    public void setPageNum(int pageNum) {
//        this.pageNum = pageNum;
//    }

    /**
     * 商品编号
     */
    private String skuNo;
    /**
     *
     */
    private String skuName;
    /**
     *
     */
    private String bookNumber;
    /**
     *分类编号
     */
    private String cateCode;
    /**
     * 成本价
     */
    private BigDecimal costPrice;
    /**
     * 售价
     */
    private BigDecimal sellingPrice;
    /**
     * 广告词
     */
    private String advWords;
    /**
     * 商品介绍
     */
    private String detail;
    /**
     * 商家名称
     */
    private String businessName;
    /**
     * 作者
     */
    private String author;
    /**
     * 库存
     */
    private int stock;
    /**
     * 销售数量
     */
    private int saleCnt;
    /**
     * 图片
     */
    private String pictureUrl;
    /**
     * 商品状态  0为未售 1为在售 初始为0
     */
    private int skuState;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDeleted;
    /**
     * 序号
     */
    private int sortNo;
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

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getCateCode() {
        return cateCode;
    }

    public void setCateCode(String cateCode) {
        this.cateCode = cateCode;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getAdvWords() {
        return advWords;
    }

    public void setAdvWords(String advWords) {
        this.advWords = advWords;
    }

    public String getDetail() {
        return detail;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSaleCnt() {
        return saleCnt;
    }

    public void setSaleCnt(int saleCnt) {
        this.saleCnt = saleCnt;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public int getSkuState() {
        return skuState;
    }

    public void setSkuState(int skuState) {
        this.skuState = skuState;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getSortNo() {
        return sortNo;
    }

    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
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

    @Override
    public String toString() {
        return "GoodsInfo{" +
//                "pageSize=" + pageSize +
//                ", pageNum=" + pageNum +
                ", skuNo='" + skuNo + '\'' +
                ", skuName='" + skuName + '\'' +
                ", bookNumber='" + bookNumber + '\'' +
                ", cateCode='" + cateCode + '\'' +
                ", costPrice=" + costPrice +
                ", sellingPrice=" + sellingPrice +
                ", advWords='" + advWords + '\'' +
                ", detail='" + detail + '\'' +
                ", businessName='" + businessName + '\'' +
                ", author='" + author + '\'' +
                ", stock=" + stock +
                ", saleCnt=" + saleCnt +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", skuState=" + skuState +
                ", isDeleted=" + isDeleted +
                ", sortNo=" + sortNo +
                ", gmtCreate=" + gmtCreate +
                ", createBy='" + createBy + '\'' +
                ", gmtModified=" + gmtModified +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
