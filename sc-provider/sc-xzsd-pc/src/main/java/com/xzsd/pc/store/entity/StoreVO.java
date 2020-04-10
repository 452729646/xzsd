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
    private String storeNo;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 门店电话
     */
    private String storePhone;
    /**
     * 详细地址
     */
    private String storeAddress;
    /**
     * 店长名称
     */
    private String managerName;
    /**
     * 邀请码
     */
    private String invitationCode;
    private int version;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    /**
     * 门店账号
     */
//    private String storeAcct;

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

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

//    public String getStoreAcct() {
////        return storeAcct;
////    }
////
////    public void setStoreAcct(String storeAcct) {
////        this.storeAcct = storeAcct;
////    }
}