
package model;

public class Pays {
    private int pay_id;
    private String name_pay;

    public Pays() {
    }

    public Pays(int pay_id, String name_pay) {
        this.pay_id = pay_id;
        this.name_pay = name_pay;
    }

    public int getPay_id() {
        return pay_id;
    }

    public void setPay_id(int pay_id) {
        this.pay_id = pay_id;
    }

    public String getName_pay() {
        return name_pay;
    }

    public void setName_pay(String name_pay) {
        this.name_pay = name_pay;
    }

    @Override
    public String toString() {
        return "Pays{" + "pay_id=" + pay_id + ", name_pay=" + name_pay + '}';
    }
    
    
}
