/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class OrderItem {

    private int orderItemId;
    private Order order;
    private Product product;
    private double price;
    private int amount;
    private double totalOfMoney;

    public OrderItem() {
    }

    public OrderItem(int orderItemId, Order order, Product product, double price, int amount, double totalOfMoney) {
        this.orderItemId = orderItemId;
        this.order = order;
        this.product = product;
        this.price = price;
        this.amount = amount;
        this.totalOfMoney = totalOfMoney;
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotalOfMoney() {
        return totalOfMoney;
    }

    public void setTotalOfMoney(double totalOfMoney) {
        this.totalOfMoney = totalOfMoney;
    }

    @Override
    public String toString() {
        return "OrderItem{" + "orderItemId=" + orderItemId + ", order=" + order + ", product=" + product + ", price=" + price + ", amount=" + amount + ", totalOfMoney=" + totalOfMoney + '}';
    }

}
