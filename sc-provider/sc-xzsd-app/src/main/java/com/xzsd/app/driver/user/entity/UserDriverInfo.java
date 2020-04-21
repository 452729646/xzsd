package com.xzsd.app.driver.user.entity;

public class UserDriverInfo {
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
     * 电话
     */
    private String phone;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
