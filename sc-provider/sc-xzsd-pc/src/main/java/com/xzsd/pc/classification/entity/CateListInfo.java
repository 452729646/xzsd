package com.xzsd.pc.classification.entity;

import java.util.List;

public class CateListInfo {
    /**
     * 分类编号
     */
    private String cateCode;
    /**
     * 分类名称
     */
    private String cateName;

    /**
     * 版本号
     */
    private String version;
    /**
     * 子类类别集合
     */
    private List<ClassificationInfo> classificationSonList;

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



    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<ClassificationInfo> getClassificationSonList() {
        return classificationSonList;
    }

    public void setClassificationSonList(List<ClassificationInfo> classificationSonList) {
        this.classificationSonList = classificationSonList;
    }
}
