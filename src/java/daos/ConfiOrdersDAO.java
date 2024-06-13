package daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Cart;
import model.Coupon;
import model.Order_items;
import model.Orders;
import model.Pays;
import model.Product;
import model.Status;
import model.Account;

public class ConfiOrdersDAO extends DBContext {

  
    public List<Orders> getAllOrders() {
        List<Orders> list = new ArrayList<>();
        String sql = "SELECT [order_id]\n"
                + "      ,[cart_Id]\n"
                + "      ,[coup_Id]\n"
                + "      ,[pay_id]\n"
                + "      ,[status_id]\n"
                + "      ,[provinces]\n"
                + "      ,[district]\n"
                + "      ,[ward]\n"
                + "      ,[phone]\n"
                + "      ,[note]\n"
                + "      ,[date_time]\n"
                + "      ,[total_money]\n"
                + "  FROM [dbo].[Orders]\n";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Orders orders = new Orders();

                orders.setOrder_id(rs.getInt(1));
                CartDAO cartDAO = new CartDAO();
                Cart cart = cartDAO.getCartByUserId(rs.getInt(2));
                orders.setCart_id(cart);

                OrderDAO dao = new OrderDAO();
                Coupon coupons = dao.findCoupon(rs.getString(3));
                orders.setCoup_id(coupons);

                Pays pay = dao.getPayById(rs.getInt(4));
                orders.setPay_id(pay);

                Status status = dao.getStatusById(rs.getInt(5));
                orders.setStatus_id(status);

                // status.setStatus_id(rs.getInt(5));
                //orders.setStatus_id(status);
                orders.setProvinces(rs.getString(6));
                orders.setDistrict(rs.getString(7));
                orders.setWard(rs.getString(8));
                orders.setPhone(rs.getString(9));
                orders.setNote(rs.getString(10));
                orders.setDate(rs.getString(11));
                orders.setTotal_money(rs.getInt(12));

                list.add(orders);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void updateStatus(int id) {
        String sql = "update Orders\n "
                + "set status_id = 5\n"
                + "where order_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception e) {
        }

    }

    public void deleteStatus(int id) {
        String sql = "update Orders "
                + "set status_id = 6\n"
                + "where order_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
       /* OrderDAO orderDAO = new OrderDAO();
        ConfiOrdersDAO cDAO = new ConfiOrdersDAO();
       // Tạo các đối tượng liên quan
        Cart cart = new Cart();
        cart.setCart_id(1); // Giả sử ID của Cart là 1

        Coupon coupon = new Coupon();
        coupon.setId(1); // Giả sử ID của Coupon là 1

        Pays pay = new Pays();
        pay.setPay_id(1); // Giả sử ID của Payment là 1

        Status status = new Status();
        status.setStatus_id(4); // Giả sử ID của Status là 1

        List<Orders> list  = orderDAO.getStatusById(status);;        
        for (Orders orders : list) {
            System.out.println(list.toString());
       }
       List<Order_items> list = cDAO.getBillOI();
       for(Order_items o: list){
           System.out.println(list.toString());
        }
        Status status = orderDAO.getStatusById(1);
        System.out.println(status.toString());
*/
    }
}
