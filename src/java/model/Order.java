/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Order {

    private int orderId;
    private Cart cart;
    private Coupon coupon;
    private Payment payment;
    private Status status;
    private String provinces;
    private String district;
    private String ward;
    private String phone;
    private String note;
    private Date date;
    private BigDecimal totalMoney;

    public Order() {
    }

    public Order(int orderId, Cart cart, Coupon coupon, Payment payment, Status status, String provinces, String district, String ward, String phone, String note, Date date, BigDecimal totalMoney) {
        this.orderId = orderId;
        this.cart = cart;
        this.coupon = coupon;
        this.payment = payment;
        this.status = status;
        this.provinces = provinces;
        this.district = district;
        this.ward = ward;
        this.phone = phone;
        this.note = note;
        this.date = date;
        this.totalMoney = totalMoney;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getProvinces() {
        return provinces;
    }

    public void setProvinces(String provinces) {
        this.provinces = provinces;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", cart=" + cart + ", coupon=" + coupon + ", payment=" + payment + ", status=" + status + ", provinces=" + provinces + ", district=" + district + ", ward=" + ward + ", phone=" + phone + ", note=" + note + ", date=" + date + ", totalMoney=" + totalMoney + '}';
    }

}
