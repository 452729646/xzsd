package com.xzsd.app.shopowner.driver.entity;

public class DriverShopownerInfo {
    /**
     * 用户编码
     */
    private String userCode;
    /**
     * 门店编码
     */
    private String storeNo;
    /**
     * 司机名称
     */
    private String driverName;
    /**
     * 司机电话
     */
    private String driverPhone;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }
}
