package com.xzsd.pc.driver.entity;

public class DriverVO {
    /**
     * 司机编号
     */
    private String driverNo;
    /**
     * 司机名称
     *
     */
    private String driverName;
    /**
     * 司机手机号
     */
    private String driverPhone;
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
    private int version;

    public String getDriverNo() {
        return driverNo;
    }

    public void setDriverNo(String driverNo) {
        this.driverNo = driverNo;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
