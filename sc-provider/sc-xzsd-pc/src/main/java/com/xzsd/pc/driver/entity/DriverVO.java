package com.xzsd.pc.driver.entity;

public class DriverVO {
    /**
     * 司机编号
     */
    private String driverId;
    /**
     * 司机名称
     *
     */
    private String userName;
    /**
     * 司机手机号
     */
    private String phone;
    /**
     * 身份证
     */
    private String idCard;
    /**
     * 用户账号
     */
    private String userAcct;
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 版本号
     */
    private String version;

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
