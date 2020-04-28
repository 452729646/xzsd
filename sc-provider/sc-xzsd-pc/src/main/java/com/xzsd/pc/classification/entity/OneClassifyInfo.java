package com.xzsd.pc.classification.entity;

import java.util.List;

public class OneClassifyInfo {
    private String classifyId;
    private String classifyName;
    private String version;
    private List<TwoClassifyListInfo> twoClassifyList;

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<TwoClassifyListInfo> getTwoClassifyList() {
        return twoClassifyList;
    }

    public void setTwoClassifyList(List<TwoClassifyListInfo> twoClassifyList) {
        this.twoClassifyList = twoClassifyList;
    }
}
