package model;

public class Product {
    private int prodId;
    private Category cateId;
    private String nameP;
    private String imageProduct;
    private String thumnail;
    private int quantity;
    private String createdAt;
    private String updatedAt;
    private int delete;
    private Product_Detail productDetail; // Chỉ là một đối tượng, không phải danh sách

    public Product() {
    }

    public Product(int prodId, Category cateId, String nameP, String imageProduct, String thumnail, String createdAt, String updatedAt, int delete) {
        this.prodId = prodId;
        this.cateId = cateId;
        this.nameP = nameP;
        this.imageProduct = imageProduct;
        this.thumnail = thumnail;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.delete = delete;
    }
    
    
    
    public Product(int prodId, Category cateId, String nameP, String imageProduct, String thumnail, int quantity, String createdAt, String updatedAt, int delete, Product_Detail productDetail) {
        this.prodId = prodId;
        this.cateId = cateId;
        this.nameP = nameP;
        this.imageProduct = imageProduct;
        this.thumnail = thumnail;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.delete = delete;
        this.productDetail = productDetail;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public Category getCateId() {
        return cateId;
    }

    public void setCateId(Category cateId) {
        this.cateId = cateId;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public String getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(String imageProduct) {
        this.imageProduct = imageProduct;
    }

    public String getThumnail() {
        return thumnail;
    }

    public void setThumnail(String thumnail) {
        this.thumnail = thumnail;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    public Product_Detail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(Product_Detail productDetail) {
        this.productDetail = productDetail;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prodId=" + prodId +
                ", cateId=" + cateId +
                ", nameP='" + nameP + '\'' +
                ", imageProduct='" + imageProduct + '\'' +
                ", thumnail='" + thumnail + '\'' +
                ", quantity=" + quantity +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", delete=" + delete +
                ", productDetail=" + productDetail +
                '}';
    }
}
