package com.xzsd.app.driver.store.entity;

public class StoreInfo {
    /**
     * 门店编码
     */
    private String storeNo;
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
    private String shopOwnerName;
    /**
     *
     */
    private String phone;
    /**
     * 用户编码
     */
    private String userCode;

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
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

    public String getShopOwnerName() {
        return shopOwnerName;
    }

    public void setShopOwnerName(String shopOwnerName) {
        this.shopOwnerName = shopOwnerName;
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
