
package model;

public class Orders {
    private int order_id;
    private Cart cart_id;
    private Coupon coup_id;
    private Pays pay_id;
    private Status status_id;
    private String provinces, district,ward,phone,note, date;
    private int total_money;

    public Orders() {
    }

    public Orders(int order_id, Cart cart_id, Coupon coup_id, Pays pay_id, Status status_id, String provinces, String district, String ward, String phone, String note, String date, int total_money) {
        this.order_id = order_id;
        this.cart_id = cart_id;
        this.coup_id = coup_id;
        this.pay_id = pay_id;
        this.status_id = status_id;
        this.provinces = provinces;
        this.district = district;
        this.ward = ward;
        this.phone = phone;
        this.note = note;
        this.date = date;
        this.total_money = total_money;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Cart getCart_id() {
        return cart_id;
    }

    public void setCart_id(Cart cart_id) {
        this.cart_id = cart_id;
    }

    public Coupon getCoup_id() {
        return coup_id;
    }

    public void setCoup_id(Coupon coup_id) {
        this.coup_id = coup_id;
    }

    public Pays getPay_id() {
        return pay_id;
    }

    public void setPay_id(Pays pay_id) {
        this.pay_id = pay_id;
    }

    public Status getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Status status_id) {
        this.status_id = status_id;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotal_money() {
        return total_money;
    }

    public void setTotal_money(int total_money) {
        this.total_money = total_money;
    }

    @Override
    public String toString() {
        return "Orders{" + "order_id=" + order_id + ", cart_id=" + cart_id + ", coup_id=" + coup_id + ", pay_id=" + pay_id + ", status_id=" + status_id + ", provinces=" + provinces + ", district=" + district + ", ward=" + ward + ", phone=" + phone + ", note=" + note + ", date=" + date + ", total_money=" + total_money + '}';
    }
    
    
}
