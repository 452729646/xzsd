package com.xzsd.app.shopowner.driver.entity;

import java.util.List;

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
    private String userName;
    /**
     * 司机电话
     */
    private String phone;
    private List<DriverShopownerInfo> list;

    public List<DriverShopownerInfo> getList() {
        return list;
    }

    public void setList(List<DriverShopownerInfo> list) {
        this.list = list;
    }

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
}
