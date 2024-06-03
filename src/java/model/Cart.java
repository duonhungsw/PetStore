package model;

public class Cart {
    private int cart_id;
    private Account acoount_id;

    public Cart() {
    }

    public Cart(int cart_id, Account acoount_id) {
        this.cart_id = cart_id;
        this.acoount_id = acoount_id;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public Account getAcoount_id() {
        return acoount_id;
    }

    public void setAcoount_id(Account acoount_id) {
        this.acoount_id = acoount_id;
    }

    @Override
    public String toString() {
        return "Cart{" + "cart_id=" + cart_id + ", acoount_id=" + acoount_id + '}';
    }
    
    
}
