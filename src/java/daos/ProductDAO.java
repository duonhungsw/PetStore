package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Product;
import model.Product_Detail;

public class ProductDAO extends DBContext {

    public Product getProductbyID(int id) {
        String sql = "SELECT Product.cate_Id, Product.nameP, Product.imageProduct, Product.thumnail, "
                + "Product_Detail.product_detail_id, Product_Detail.price, Product_Detail.amount "
                + "FROM Product "
                + "INNER JOIN Product_Detail ON Product.product_id = Product_Detail.product_id "
                + "WHERE Product.product_id = ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    Product product = new Product();
                    product.setProdId(id);
                    Category category = getCategorybyID(rs.getString("cate_Id"));
                    product.setCateId(category);
                    product.setNameP(rs.getString("nameP"));
                    product.setImageProduct(rs.getString("imageProduct"));
                    product.setThumnail(rs.getString("thumnail"));

                    Product_Detail detail = new Product_Detail();
                    detail.setProduct_detail_id(rs.getInt("product_detail_id"));
                    detail.setProduct_id(product); // Set the product reference
                    detail.setPrice(rs.getInt("price"));
                    detail.setAmount(rs.getInt("amount"));

                    product.setProductDetail(detail);
                    return product;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception
        }
        return null; // Return null if no product is found or in case of an error
    }
public List<Product> getProductByCID(String cid) {
    List<Product> productz = new ArrayList<>();
  String sql = "SELECT Product.product_id, Product.nameP, Product.imageProduct, Product.thumnail, "
      + "Product_Detail.product_detail_id, Product_Detail.price, Product_Detail.amount "
      + "FROM Product "
      + "INNER JOIN Product_Detail ON Product.product_id = Product_Detail.product_id "
      + "WHERE Product.cate_Id = ?";
  try (PreparedStatement st = connection.prepareStatement(sql)) {
    st.setString(1, cid);
    try (ResultSet rs = st.executeQuery()) {
      if (rs.next()) {
        Product product = new Product();
        product.setProdId(rs.getInt("product_id")); // Assuming product_id is the primary key

        Category category = getCategorybyID(cid); // Assuming getCategorybyID exists
        product.setCateId(category);

        product.setNameP(rs.getString("nameP"));
        product.setImageProduct(rs.getString("imageProduct"));
        product.setThumnail(rs.getString("thumnail"));

        Product_Detail detail = new Product_Detail();
        detail.setProduct_detail_id(rs.getInt("product_detail_id"));
        detail.setProduct_id(product); // Set the product reference
        detail.setPrice(rs.getInt("price"));
        detail.setAmount(rs.getInt("amount"));

        product.setProductDetail(detail);
        productz.add(product);
      }
    }
  } catch (SQLException e) {
    e.printStackTrace(); // Log the exception
  }
  return productz; // Return null if no product is found or in case of an error
}
    public Category getCategorybyID(String id) {
        String sql = "SELECT [category_id], [name] FROM [dbo].[Category] WHERE category_id = ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    Category category = new Category();
                    category.setCategory_id(rs.getInt(1));
                    category.setName(rs.getString(2));
                    return category;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception
        }
        return null; // Return null if no category is found or in case of an error
    }
public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT [category_id], [name] FROM [dbo].[Category]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("category_id"), rs.getString("name"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT Product.product_id, Product.cate_Id, Product.nameP, Product.imageProduct, Product.thumnail, "
                + "Product_Detail.product_detail_id, Product_Detail.price, Product_Detail.amount "
                + "FROM Product "
                + "INNER JOIN Product_Detail ON Product.product_id = Product_Detail.product_id";
        try (PreparedStatement st = connection.prepareStatement(sql); ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                Product product = new Product();
                product.setProdId(rs.getInt("product_id"));
                Category category = getCategorybyID(rs.getString("cate_Id"));
                product.setCateId(category);
                product.setNameP(rs.getString("nameP"));
                product.setImageProduct(rs.getString("imageProduct"));
                product.setThumnail(rs.getString("thumnail"));

                Product_Detail detail = new Product_Detail();
                detail.setProduct_detail_id(rs.getInt("product_detail_id"));
                detail.setProduct_id(product); // Set the product reference
                detail.setPrice(rs.getInt("price"));
                detail.setAmount(rs.getInt("amount"));

                product.setProductDetail(detail);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception
        }
        return products; // Return the list of products
    }

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();

        // Test getAllProducts method
        Product products = productDAO.getProductbyID(2);
        System.out.println(products.toString());
    }
}
