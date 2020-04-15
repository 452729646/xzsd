package com.xzsd.pc.order.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderVO {
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 订单总价
     */
    private BigDecimal paymentMoney;
    /**
     * 订单状态
     */
    private int orderStatus;
    /**
     * 支付状态
     */
    private int payStatus;
    /**
     * 门店编号
     */
    private String storeNo;
    /**
     * 下单人姓名
     */
    private String userName;
    /**
     * 下单人电话
     */
    private String userPhone;
//    /**
//     * 付款时间
//     */
//    private String payTime;

    /**
     * 下单时间
     */
    private String createTime;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 版本号
     */

    private int version;
    /**
     * 查询开始日期
     */
    private String startTime;
    private String endTime;

    private int role;
    private String storeNo2;

    public String getStoreNo2() {
        return storeNo2;
    }

    public void setStoreNo2(String storeNo2) {
        this.storeNo2 = storeNo2;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getPaymentMoney() {
        return paymentMoney;
    }

    public void setPaymentMoney(BigDecimal paymentMoney) {
        this.paymentMoney = paymentMoney;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(int payStatus) {
        this.payStatus = payStatus;
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

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

//    public String getPayTime() {
//        return payTime;
//    }
//
//    public void setPayTime(String payTime) {
//        this.payTime = payTime;
//    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
