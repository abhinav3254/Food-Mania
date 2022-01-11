package com.example.foodmania.Models;

public class OrderModels {

    int oderImage;
    String soldItemName,price,orderNumber;


    public OrderModels() {
        this.oderImage = oderImage;
        this.soldItemName = soldItemName;
        this.price = price;
        this.orderNumber = orderNumber;
    }



    public int getOderImage() {
        return oderImage;
    }

    public void setOderImage(int oderImage) {
        this.oderImage = oderImage;
    }

    public String getSoldItemName() {
        return soldItemName;
    }

    public void setSoldItemName(String soldItemName) {
        this.soldItemName = soldItemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
