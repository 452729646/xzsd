package com.xzsd.pc.store.entity;

public class StoreDetailVo {
    /**
     * 店长账号
     */
    private String managerAcct;
    /**
     * 营业执照
     *
     */
    private String businessLicense;
    /**
     * 省名称
     */
    private String provinceName;
    /**
     * 市名称
     */
    private String cityName;
    /**
     * 区名称
     */
    private String areaName;
    /**
     * 详细地址
     */
    private String storeAddress;
    /**
     * 版本号
     */
    private int version;

    public String getManagerAcct() {
        return managerAcct;
    }

    public void setManagerAcct(String managerAcct) {
        this.managerAcct = managerAcct;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }
}
