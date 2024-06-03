package model;

public class Product_Detail {
    private int product_detail_id;
    private Product product_id;
    private int price;
    private int amount;

    public Product_Detail() {
    }

    public Product_Detail(int product_detail_id, Product product_id, int price, int amount) {
        this.product_detail_id = product_detail_id;
        this.product_id = product_id;
        this.price = price;
        this.amount = amount;
    }

    public int getProduct_detail_id() {
        return product_detail_id;
    }

    public void setProduct_detail_id(int product_detail_id) {
        this.product_detail_id = product_detail_id;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Product_Detail{" +
                "product_detail_id=" + product_detail_id +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
