
package model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderDTO {
    @JsonProperty("email")
    private String email;
    @JsonProperty("name")
    private String name;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("province")
    private String province;
    @JsonProperty("district")
    private String district;
    @JsonProperty("ward")
    private String ward;
    @JsonProperty("note")
    private String note;
    @JsonProperty("payment")
    private String payment;
    @JsonProperty("total_money")
    private String total_money;
    @JsonProperty("couponId")
    private String couponId;

    public OrderDTO() {
    }

    public OrderDTO(String email, String name, String phone, String province, String district, String ward, String note, String payment, String total_money, String couponId) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.province = province;
        this.district = district;
        this.ward = ward;
        this.note = note;
        this.payment = payment;
        this.total_money = total_money;
        this.couponId = couponId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getTotal_money() {
        return total_money;
    }

    public void setTotal_money(String total_money) {
        this.total_money = total_money;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    @Override
    public String toString() {
        return "OrderDTO{" + "email=" + email + ", name=" + name + ", phone=" + phone + ", province=" + province + ", district=" + district + ", ward=" + ward + ", note=" + note + ", payment=" + payment + ", total_money=" + total_money + ", couponId=" + couponId + '}';
    }
}
