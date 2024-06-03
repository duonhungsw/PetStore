package model;

import java.util.Date;

public class CustomerServiceBookings {

    private int booking_id;
    private int service_id;
    private int service_price;
    private int customer_id;
    private int groomer_id;
    private String customer_name;
    private String customer_phone;
    private Date booking_date;
    private int booking_time;

    public CustomerServiceBookings(int booking_id, int service_id, int service_price, int customer_id, int groomer_id, String customer_name, String customer_phone, Date booking_date, int booking_time) {
        this.booking_id = booking_id;
        this.service_id = service_id;
        this.service_price = service_price;
        this.customer_id = customer_id;
        this.groomer_id = groomer_id;
        this.customer_name = customer_name;
        this.customer_phone = customer_phone;
        this.booking_date = booking_date;
        this.booking_time = booking_time;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public int getService_price() {
        return service_price;
    }

    public void setService_price(int service_price) {
        this.service_price = service_price;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getGroomer_id() {
        return groomer_id;
    }

    public void setGroomer_id(int groomer_id) {
        this.groomer_id = groomer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public Date getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    public int getBooking_time() {
        return booking_time;
    }

    public void setBooking_time(int booking_time) {
        this.booking_time = booking_time;
    }

    public CustomerServiceBookings() {
    }

    

}
