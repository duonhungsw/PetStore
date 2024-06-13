package daos;

import java.util.List;
import model.Cart_Item;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cart;
import model.Coin;
import model.Coupon;
import model.Order_items;
import model.Orders;
import model.Pays;
import model.Product;
import model.Status;

public class OrderDAO extends DBContext {

    public int getTotalMoneyOrders(int id) {
        String sql = "select sum(total_money)as total from Cart_Item where cart_Id = ? and sta_Id = 1";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public Coin getCoin(int id) {
        String sql = "select * from Coin where coin_id  = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Coin coin = new Coin();
                coin.setCoin_id(rs.getInt(1));
                coin.setCoinNumber(rs.getInt(2));
                return  coin;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public void resetCoinAccountById(int id){
        String sql = "update Coin set numberCoin = 0 where coin_id  = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Coupon getCouponById(int id) {
        String sql = "Select * from Coupon where [coupon_id] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Coupon coupon = new Coupon();
                coupon.setId(rs.getInt(1));
                coupon.setCode(rs.getString(2));
                coupon.setDiscount(rs.getInt(3));
                coupon.setTime(rs.getString(4));

                return coupon;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Pays getPayById(int id) {
        String sql = "Select * from Pays where [pay_id] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Pays pay = new Pays();
                pay.setPay_id(rs.getInt(1));
                pay.setName_pay(rs.getString(2));

                return pay;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Status getStatusById(int id) {
        String sql = "Select * from Status where [status_id] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Status status = new Status();
                status.setStatus_id(rs.getInt(1));
                status.setName(rs.getString(2));

                return status;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Status> listStatus() {
        List<Status> list = new ArrayList<>();
        String sql = "SELECT [status_id], [name] FROM [dbo].[Status]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Status status = new Status();
                status.setStatus_id(rs.getInt(1));
                status.setName(rs.getString(2));

                list.add(status);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Pays> listPay() {
        List<Pays> list = new ArrayList<>();
        String sql = "Select pay_id, name_pay From Pays";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Pays pay = new Pays();
                pay.setPay_id(rs.getInt(1));
                pay.setName_pay(rs.getString(2));

                list.add(pay);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Coupon> findCouponsByKeyword(String code) {
        List<Coupon> list = new ArrayList<>();
        String sql = "select * from Coupon where code like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + code + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Coupon coupon = new Coupon();
                coupon.setId(rs.getInt("coupon_id"));
                coupon.setCode(rs.getString("code"));
                coupon.setDiscount(rs.getInt("discount"));
                coupon.setTime(rs.getString("time"));

                list.add(coupon);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Coupon findCoupon(String code) {
        String sql = "select * from Coupon where code like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + code + "%");
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Coupon coupon = new Coupon();
                coupon.setId(rs.getInt("coupon_id"));
                coupon.setCode(rs.getString("code"));
                coupon.setDiscount(rs.getInt("discount"));
                coupon.setTime(rs.getString("time"));

                return coupon;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void insertOrder(Orders order) {
        String sql = "INSERT INTO [dbo].[Orders]\n"
                + "           ([cart_Id]\n"
                + "           ,[coup_Id]\n"
                + "           ,[pay_id]\n"
                + "           ,[status_id]\n"
                + "           ,[provinces]\n"
                + "           ,[district]\n"
                + "           ,[ward]\n"
                + "           ,[phone]\n"
                + "           ,[note]\n"
                + "           ,[date_time]\n"
                + "           ,[total_money])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, order.getCart_id().getCart_id());
            st.setInt(2, order.getCoup_id().getId());
            st.setInt(3, order.getPay_id().getPay_id());
            st.setInt(4, order.getStatus_id().getStatus_id());
            st.setString(5, order.getProvinces());
            st.setString(6, order.getDistrict());
            st.setString(7, order.getWard());
            st.setString(8, order.getPhone());
            st.setString(9, order.getNote());
            st.setString(10, order.getDate());
            st.setInt(11, order.getTotal_money());

            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getLastOrderId() {
        String sql = "Select Max(order_id) as MaxId from Orders";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("MaxId");
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void insertOrderItems(Order_items oi) {
        String sql = "INSERT INTO [dbo].[Order_items]\n"
                + "           ([order_id]\n"
                + "           ,[product_id]\n"
                + "           ,[price]\n"
                + "           ,[total_money]\n"
                + "           ,[quantity])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, oi.getOrder_id().getOrder_id());
            st.setInt(2, oi.getProduct_id().getProdId());
            st.setInt(3, oi.getPrice());
            st.setInt(4, oi.getTotal_money());
            st.setInt(5, oi.getQuantity());

            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    public Orders getOrderById(int id) {
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
                + "  FROM [dbo].[Orders]\n"
                + "  where order_id =  ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Orders orders = new Orders();
                orders.setOrder_id(rs.getInt(1));
                
                CartDAO cartDAO = new CartDAO();
                Cart cart = cartDAO.getCartByCartId(rs.getInt(2));
                orders.setCart_id(cart);

                OrderDAO dao = new OrderDAO();
                Coupon coupons = dao.findCoupon(rs.getString(3));
                orders.setCoup_id(coupons);

                Pays pay = dao.getPayById(rs.getInt(4));
                orders.setPay_id(pay);

                Status status = dao.getStatusById(rs.getInt(5));
                orders.setStatus_id(status);

                orders.setProvinces(rs.getString(6));
                orders.setDistrict(rs.getString(7));
                orders.setWard(rs.getString(8));
                orders.setPhone(rs.getString(9));
                orders.setNote(rs.getString(10));
                orders.setDate(rs.getString(11));
                orders.setTotal_money(rs.getInt(12));

                return orders;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Order_items> getBillDetailOrder(int id){
        List<Order_items> list = new ArrayList<>();
        String sql = "select * from Order_items where order_id = ?";
        try {
            PreparedStatement st  = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs  = st.executeQuery();
            while (rs.next()) {                
                Order_items oi = new Order_items();
                oi.setOrderItem_id(rs.getInt(1));
                
                Orders o = new OrderDAO().getOrderById(rs.getInt(2));
                oi.setOrder_id(o);
                
                Product p = new CartDAO().getProductbyID(rs.getInt(3));
                oi.setProduct_id(p);
                
                oi.setPrice(rs.getInt(4));
                oi.setTotal_money(rs.getInt(5));
                oi.setQuantity(rs.getInt(6));
                
                list.add(oi);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public void DeleteOrder(int id){
        String sql = "update Orders\n "
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
        OrderDAO orderDAO = new OrderDAO();
        List<Order_items> list = orderDAO.getBillDetailOrder(36);
        for (Order_items order_items : list) {
            System.out.println(order_items.toString());
        }
        
        Orders  o  = orderDAO.getOrderById(36);
        System.out.println(o.toString());
    }
}
