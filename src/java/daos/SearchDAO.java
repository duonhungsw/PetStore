/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Product;
import model.Product_Detail;

/**
 *
 * @author Admin
 */
public class SearchDAO extends DBContext {

    public Category getCategoryById(int id) {
        String sql = "SELECT [category_id]\n"
                + "      ,[name]\n"
                + "  FROM [dbo].[Category]\n"
                + "  where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Category(rs.getInt(1),
                        rs.getString(2));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Product> searchProductByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT Product.product_id, Product.cate_Id, Product.nameP, Product.imageProduct, Product.thumnail, "
                + " Product_Detail.product_detail_id, Product_Detail.price, Product_Detail.amount "
                + " FROM Product "
                + " INNER JOIN Product_Detail ON Product.product_id = Product_Detail.product_id "
                + " WHERE Product.nameP like ? ";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + txtSearch + "%"); // Đặt giá trị cho tham số
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                    product.setProdId(rs.getInt("product_id"));
                    Category category = getCategoryById(rs.getInt("cate_Id"));
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
                    list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

//    public List<Product> search(String txt, int index, int size) {
//        List<Product> list = new ArrayList<>();
//        String sql = "with x as (select ROW_NUMBER() over(order by id asc) as r,\n"
//                + "                * from Product where [title] like ?)\n"
//                + "                select * from x WHERE r BETWEEN (? * ? - 7) AND (? * ?)"; 
//
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setString(1, "%" + txt + "%");  // Bind search text
//            st.setInt(2, index);  // Bind page index
//            st.setInt(3, size);   // Bind page size
//            st.setInt(4, index);  // Bind page index again
//            st.setInt(5, size);   // Bind page size again
//
//            ResultSet rs = st.executeQuery();
//
//            while (rs.next()) {
//                Product p = new Product();
//                p.setId(rs.getInt("id"));
//                p.setTitle(rs.getString("title"));
//                p.setSize(rs.getString("size"));
//                p.setPrice(rs.getString("price"));
//                p.setDescription(rs.getString("description"));
//                p.setThumbnail(rs.getString("thumbnail"));
//                Category c = getCategoryById(rs.getInt("Category_id"));
//                p.setCategory(c);
//                list.add(p);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }

    public static void main(String[] args) {
        SearchDAO sdao = new SearchDAO();
        String txtSearch = "cho";  
//        int pageIndex = 1;            
//        int pageSize = 3;             

        List<Product> list = sdao.searchProductByName(txtSearch);

        for (Product product : list) {
            System.out.println(product.toString());
        }
    }

}
