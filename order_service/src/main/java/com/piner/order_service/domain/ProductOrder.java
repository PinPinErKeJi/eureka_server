package com.piner.order_service.domain;

import java.io.Serializable;
import java.util.Date;

public class ProductOrder implements Serializable {
    private int id;
    private String productName;
    private String serialNumber; //流水号
    private int price;
    private Date createTime;

    private int userId;
    private String userName;

    public ProductOrder(){}

    public ProductOrder(int id, String productName, String serialNumber, int price, Date createTime, int userId, String userName) {
        this.id = id;
        this.productName = productName;
        this.serialNumber = serialNumber;
        this.price = price;
        this.createTime = createTime;
        this.userId = userId;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "ProductOrder{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", price=" + price +
                ", createTime=" + createTime +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
