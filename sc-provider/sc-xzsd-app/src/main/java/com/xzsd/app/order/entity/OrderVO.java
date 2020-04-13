package com.xzsd.app.order.entity;

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
    /**
     * 付款时间
     */
    private Date payTime;
    /**
     * 版本号
     */
    private int version;

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

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}