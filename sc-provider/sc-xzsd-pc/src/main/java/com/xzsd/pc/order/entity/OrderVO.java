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
    private String orderAllCost;
    /**
     * 订单状态
     */
    private String orderStateId;
    /**
     * 支付状态
     */
    private int payStatus;
    /**
     * 门店编号
     */
    private String storeId;
    /**
     * 下单人姓名
     */
    private String userName;
    /**
     * 下单人电话
     */
    private String phone;
//    /**
//     * 付款时间
//     */
//    private String payTime;

    /**
     * 下单时间
     */
    private String payTime;


    /**
     * 版本号
     */

    private int version;
    /**
     * 查询开始日期
     */
    private String payTimeStart;
    private String payTimeEnd;

    private String role;
    private String storeNo2;



    public String getStoreNo2() {
        return storeNo2;
    }

    public void setStoreNo2(String storeNo2) {
        this.storeNo2 = storeNo2;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }



    public int getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(int payStatus) {
        this.payStatus = payStatus;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getOrderAllCost() {
        return orderAllCost;
    }

    public void setOrderAllCost(String orderAllCost) {
        this.orderAllCost = orderAllCost;
    }

    public String getOrderStateId() {
        return orderStateId;
    }

    public void setOrderStateId(String orderStateId) {
        this.orderStateId = orderStateId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getPayTimeStart() {
        return payTimeStart;
    }

    public void setPayTimeStart(String payTimeStart) {
        this.payTimeStart = payTimeStart;
    }

    public String getPayTimeEnd() {
        return payTimeEnd;
    }

    public void setPayTimeEnd(String payTimeEnd) {
        this.payTimeEnd = payTimeEnd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
