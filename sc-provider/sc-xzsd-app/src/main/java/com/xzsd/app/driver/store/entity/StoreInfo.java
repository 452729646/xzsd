package com.xzsd.app.driver.store.entity;

import java.util.List;

public class StoreInfo {
    /**
     * 门店编码
     */
    private String storeId;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 地址
     */
    private String address;
    /**
     * 店长名称
     */
    private String userName;
    /**
     *
     */
    private String phone;
    /**
     * 用户编码
     */
    private String userCode;

    private List<StoreInfo> list;

    public List<StoreInfo> getList() {
        return list;
    }

    public void setList(List<StoreInfo> list) {
        this.list = list;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
