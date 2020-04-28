package com.xzsd.pc.store.entity;

public class StoreVO {
//    /**
//     * 页码
//     */
//    private int pageSize;
//    /**
//     * 页数
//     */
//    private int pageNum;

//    public int getPageSize() {
//        return pageSize;
//    }
//
//    public void setPageSize(int pageSize) {
//        this.pageSize = pageSize;
//    }
//
//    public int getPageNum() {
//        return pageNum;
//    }
//
//    public void setPageNum(int pageNum) {
//        this.pageNum = pageNum;
//    }

    /**
     * 门店编号
     */
    private String storeId;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 门店电话
     */
    private String phone;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 店长名称
     */
    private String userName;
    private String userAcct;
    /**
     * 邀请码
     */
    private String inviteCode;
    private String version;

    public String getVersion() {
        return version;
    }

    /**
     * 门店账号
     */
//    private String storeAcct;

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public void setVersion(String version) {
        this.version = version;
    }


//    public String getStoreAcct() {
////        return storeAcct;
////    }
////
////    public void setStoreAcct(String storeAcct) {
////        this.storeAcct = storeAcct;
////    }
}