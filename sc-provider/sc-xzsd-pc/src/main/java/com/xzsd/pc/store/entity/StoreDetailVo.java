package com.xzsd.pc.store.entity;

public class StoreDetailVo {
    /**
     * 店长账号
     */
    private String managerAcct;
    private String userId;
    /**
     * 营业执照
     *
     */
    private String businessCode;
    /**
     * 省名称
     */
    private String provinceName;
    private String provinceId;
    /**
     * 市名称
     */
    private String cityName;
    private String cityId;
    /**
     * 区名称
     */
    private String areaName;
    private String areaId;
    /**
     * 详细地址
     */
    private String address;
    private String storeId;
    private String phone;
    private String storeName;
    /**
     * 版本号
     */
    private String version;

    public String getManagerAcct() {
        return managerAcct;
    }

    public void setManagerAcct(String managerAcct) {
        this.managerAcct = managerAcct;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
