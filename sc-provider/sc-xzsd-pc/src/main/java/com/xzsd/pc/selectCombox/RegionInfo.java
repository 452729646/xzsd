package com.xzsd.pc.selectCombox;

import java.util.List;

public class RegionInfo {
    /**
     * id
     */
    private String areaId;
    /**
     * 名称
     */
    private String areaName;


    private List<RegionInfo> cityList;

    public List<RegionInfo> getCityList() {
        return cityList;
    }

    public void setCityList(List<RegionInfo> cityList) {
        this.cityList = cityList;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }


}
