package model;

import java.util.Date;

public class ViewBookedService {
    
    private int booking_id;
    private int service_id;
    private String service_name;
    private int groomer_id;
    private String groomer_name;
    private Date booking_date;
    private int booking_time;
    private int isCompleted;

    public ViewBookedService(int booking_id, int service_id, String service_name, int groomer_id, String groomer_name, Date booking_date, int booking_time, int isCompleted) {
        this.booking_id = booking_id;
        this.service_id = service_id;
        this.service_name = service_name;
        this.groomer_id = groomer_id;
        this.groomer_name = groomer_name;
        this.booking_date = booking_date;
        this.booking_time = booking_time;
        this.isCompleted = isCompleted;
    }

    public ViewBookedService() {
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

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public int getGroomer_id() {
        return groomer_id;
    }

    public void setGroomer_id(int groomer_id) {
        this.groomer_id = groomer_id;
    }

    public String getGroomer_name() {
        return groomer_name;
    }

    public void setGroomer_name(String groomer_name) {
        this.groomer_name = groomer_name;
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
