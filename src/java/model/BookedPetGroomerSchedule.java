package model;

import java.util.Date;

public class BookedPetGroomerSchedule {
    private int schedule_id;
    private int groomer_id;
    private Date booking_date;
    private int booking_time;
    private int is_available;

    public BookedPetGroomerSchedule(int schedule_id, int groomer_id, Date booking_date, int booking_time, int is_available) {
        this.schedule_id = schedule_id;
        this.groomer_id = groomer_id;
        this.booking_date = booking_date;
        this.booking_time = booking_time;
        this.is_available = is_available;
    }

    public BookedPetGroomerSchedule() {
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public int getGroomer_id() {
        return groomer_id;
    }

    public void setGroomer_id(int groomer_id) {
        this.groomer_id = groomer_id;
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

    public int getIs_available() {
        return is_available;
    }

    public void setIs_available(int is_available) {
        this.is_available = is_available;
    }

    
}
