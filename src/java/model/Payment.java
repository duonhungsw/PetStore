/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Payment {

    private int payId;
    private String payName;

    public Payment() {
    }

    public Payment(int payId, String payName) {
        this.payId = payId;
        this.payName = payName;
    }

    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    @Override
    public String toString() {
        return "Payment{" + "payId=" + payId + ", payName=" + payName + '}';
    }

}
