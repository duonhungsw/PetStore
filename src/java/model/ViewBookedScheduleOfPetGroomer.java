package model;

import java.util.Date;

public class ViewBookedScheduleOfPetGroomer {

    private int booking_id;
    private int service_id;
    private int service_price;
    private String service_name;
    private int customer_id;
    private Date booking_date;
    private int booking_time;
    private int isCompleted;

    public ViewBookedScheduleOfPetGroomer(int booking_id, int service_id, int service_price, String service_name, int customer_id, Date booking_date, int booking_time, int isCompleted) {
        this.booking_id = booking_id;
        this.service_id = service_id;
        this.service_price = service_price;
        this.service_name = service_name;
        this.customer_id = customer_id;
        this.booking_date = booking_date;
        this.booking_time = booking_time;
        this.isCompleted = isCompleted;
    }

    public ViewBookedScheduleOfPetGroomer() {
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

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
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

    public int getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(int isCompleted) {
        this.isCompleted = isCompleted;
    }

    

}
