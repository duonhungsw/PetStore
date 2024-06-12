/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class ServiceBooking {

    private int bookingId;
    private Service service;
    private Account customer;
    private PetGroomerInfo groomer;
    private String customerName;
    private String customerPhone;
    private Date bookingDate;
    private int bookingTime;
    private int price;
    private int status;

    public ServiceBooking() {
    }

    public ServiceBooking(int bookingId, Service service, Account customer, PetGroomerInfo groomer, String customerName, String customerPhone, Date bookingDate, int bookingTime, int price, int status) {
        this.bookingId = bookingId;
        this.service = service;
        this.customer = customer;
        this.groomer = groomer;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.price = price;
        this.status = status;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Account getCustomer() {
        return customer;
    }

    public void setCustomer(Account customer) {
        this.customer = customer;
    }

    public PetGroomerInfo getGroomer() {
        return groomer;
    }

    public void setGroomer(PetGroomerInfo groomer) {
        this.groomer = groomer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(int bookingTime) {
        this.bookingTime = bookingTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ServiceBooking{" + "bookingId=" + bookingId + ", service=" + service + ", customer=" + customer + ", groomer=" + groomer + ", customerName=" + customerName + ", customerPhone=" + customerPhone + ", bookingDate=" + bookingDate + ", bookingTime=" + bookingTime + ", price=" + price + ", status=" + status + '}';
    }
    
}
