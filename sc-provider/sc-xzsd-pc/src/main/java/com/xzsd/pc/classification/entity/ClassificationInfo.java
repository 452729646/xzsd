package com.xzsd.pc.classification.entity;

import java.util.Date;
import java.util.List;

public class ClassificationInfo  {
//    /**
//     * 页码
//     */
//    private int pageSize;
//    /**
//     * 页数
//     */
//    private int pageNum;
//
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

//    public void setPageNum(int pageNum) {
//        this.pageNum = pageNum;
//    }
    /**
     * 分类编号
     */
    private String cateCode;
    /**
     * 分类名称
     */
    private String cateName;
    /**
     * 父类编号
     */
    private String cateCodeParent;
    /**
     * 父级名称
     */
    private String cateNameParent;
    /**
     * 是否父类 0为父级 1为子级
     */
    private int  isParent;
    /**
     * 备注
     */
    private String remark;
    /**
     * 子类类别集合
     */
     private List<ClassificationInfo> classificationSonList;

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
    private  int version;





    public String getCateCode() {
        return cateCode;
    }

    public void setCateCode(String cateCode) {
        this.cateCode = cateCode;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCateCodeParent() {
        return cateCodeParent;
    }

    public void setCateCodeParent(String cateCodeParent) {
        this.cateCodeParent = cateCodeParent;
    }

    public String getCateNameParent() {
        return cateNameParent;
    }

    public void setCateNameParent(String cateNameParent) {
        this.cateNameParent = cateNameParent;
    }

    public int getIsParent() {
        return isParent;
    }

    public void setIsParent(int isParent) {
        this.isParent = isParent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<ClassificationInfo> getClassificationSonList() {
        return classificationSonList;
    }

    public void setClassificationSonList(List<ClassificationInfo> classificationSonList) {
        this.classificationSonList = classificationSonList;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
