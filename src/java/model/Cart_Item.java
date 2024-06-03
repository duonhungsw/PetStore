
package model;


public class Cart_Item {
    private int id;
    private Product prod_id;
    private Cart cart_id;
    private State sta_id;
    private int total_money;
    private int quantity;

    public Cart_Item() {
    }

    public Cart_Item(int id, Product prod_id, Cart cart_id, State sta_id, int total_money, int quantity) {
        this.id = id;
        this.prod_id = prod_id;
        this.cart_id = cart_id;
        this.sta_id = sta_id;
        this.total_money = total_money;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProd_id() {
        return prod_id;
    }

    public void setProd_id(Product prod_id) {
        this.prod_id = prod_id;
    }

    public Cart getCart_id() {
        return cart_id;
    }

    public void setCart_id(Cart cart_id) {
        this.cart_id = cart_id;
    }

    public State getSta_id() {
        return sta_id;
    }

    public void setSta_id(State sta_id) {
        this.sta_id = sta_id;
    }

    public int getTotal_money() {
        return total_money;
    }

    public void setTotal_money(int total_money) {
        this.total_money = total_money;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart_Item{" + "id=" + id + ", prod_id=" + prod_id + ", cart_id=" + cart_id + ", sta_id=" + sta_id + ", total_money=" + total_money + ", quantity=" + quantity + '}';
    }
    
    
}
