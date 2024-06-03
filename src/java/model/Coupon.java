
package model;

import java.util.Date;

public class Coupon {
    private int id;
    private String code;
    private int discount;
    private String time;

    public Coupon() {
    }

    public Coupon(int id, String code, int discount, String time) {
        this.id = id;
        this.code = code;
        this.discount = discount;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Coupon{" + "id=" + id + ", code=" + code + ", discount=" + discount + ", time=" + time + '}';
    }

    
}
