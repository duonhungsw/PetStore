
package model;

public class Order_items {
    private int orderItem_id;
    private Orders order_id;
    private Product product_id;
    private int price;
    private int total_money;
    private int quantity;

    public Order_items() {
    }

    public Order_items(int orderItem_id, Orders order_id, Product product_id, int price, int total_money, int quantity) {
        this.orderItem_id = orderItem_id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.price = price;
        this.total_money = total_money;
        this.quantity = quantity;
    }

    public int getOrderItem_id() {
        return orderItem_id;
    }

    public void setOrderItem_id(int orderItem_id) {
        this.orderItem_id = orderItem_id;
    }

    public Orders getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Orders order_id) {
        this.order_id = order_id;
    }

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
        return "Order_items{" + "orderItem_id=" + orderItem_id + ", order_id=" + order_id + ", product_id=" + product_id + ", price=" + price + ", total_money=" + total_money + ", quantity=" + quantity + '}';
    }
}
