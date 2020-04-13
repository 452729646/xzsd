package com.xzsd.pc.store.entity;

import java.util.List;

public class RegionInfo {
    /**
     * id
     */
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 父id
     */
    private String pid;

    private List<RegionInfo> cityList;

    public List<RegionInfo> getCityList() {
        return cityList;
    }

    public void setCityList(List<RegionInfo> cityList) {
        this.cityList = cityList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
