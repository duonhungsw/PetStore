/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class ProductDetail {
    
    private int productDetailId;
    private Product product;
    private double price;
    private int amount;

    public ProductDetail() {
    }

    public ProductDetail(int productDetailId, Product product, double price, int amount) {
        this.productDetailId = productDetailId;
        this.product = product;
        this.price = price;
        this.amount = amount;
    }

    public int getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(int productDetailId) {
        this.productDetailId = productDetailId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
        return "ProductDetail{" + "productDetailId=" + productDetailId + ", product=" + product + ", price=" + price + ", amount=" + amount + '}';
    }
    
    
}
