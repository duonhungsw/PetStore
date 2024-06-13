/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Order_items;
import model.Product;
import model.Cart;
import model.Coupon;
import model.Orders;
import model.Pays;
import model.Status;

/**
 *
 * @author Phuc
 */
public class PurchaseDAO extends DBContext {

    public List<Order_items> getAllPurchases() {
        List<Order_items> list = new ArrayList<>();
        String sql = "  select *from Order_items";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Order_items oi = new Order_items();
                oi.setPrice(rs.getInt("price"));

                CartDAO cdao = new CartDAO();
                Product p = cdao.getProductbyID(rs.getInt("product_id"));
                oi.setProduct_id(p);
                oi.setQuantity(rs.getInt("quantity"));
                oi.setTotal_money(rs.getInt("total_money"));

                list.add(oi);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Order_items> getPurchaseByStatusID(int id) {
        List<Order_items> list = new ArrayList<>();
        String sql = "select oi.price, oi.product_id, oi.quantity, oi.total_money\n"
                + "from Order_items oi\n"
                + "join Orders o on oi.order_id = o.order_id\n"
                + "where o.status_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Order_items oi = new Order_items();              
                oi.setPrice(rs.getInt("price"));

                CartDAO cdao = new CartDAO();
                Product p = cdao.getProductbyID(rs.getInt("product_id"));
                oi.setProduct_id(p);
                oi.setQuantity(rs.getInt("quantity"));
                oi.setTotal_money(rs.getInt("total_money"));

                list.add(oi);

            }
        } catch (SQLException e) {
        }
        return list;
    }

    public static void main(String[] args) {
        List<Order_items> list = new PurchaseDAO().getAllPurchases();
        for (Order_items order_items : list) {
            System.out.println(order_items.toString());
        }
    }
}
