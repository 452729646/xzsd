package com.xzsd.app.shopowner.user.entity;

public class UserShopownerInfo {
    /**
     * 用户编码
     */
    private String userCode;
    /**
     * 头像url
     */
    private String pictureUrl;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 门店编码
     */
    private String storeNo;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 邀请码
     */
    private String inviteCode;
    /**
     *详细地址
     */
    private String address;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
