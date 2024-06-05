package daos;

import java.util.List;
import model.Cart_Item;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cart;
import model.Coupon;
import model.Order_items;
import model.Orders;
import model.Pays;
import model.Product;
import model.Status;

public class OrderDAO extends DBContext {

    public int getTotalMoneyOrders(int id) {
        String sql = "  select sum(total_money)as total from Cart_Item where cart_Id = ? and sta_Id = 1";
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

    public int getCoin(int id) {
        String sql = "select numberCoin from Coin where coin_id  = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
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
        String sql = "Select * from Coupon where [status_id] = ?";
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

    public Orders getBillOrders() {
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
                + "  where order_id =  (Select max(order_id) from Orders)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Orders orders = new Orders();
                CartDAO cartDAO = new CartDAO();
                Cart cart = cartDAO.getCartByUserId(rs.getInt(1));
                orders.setCart_id(cart);

                OrderDAO dao = new OrderDAO();
                Coupon coupons = dao.findCoupon(rs.getString(2));
                orders.setCoup_id(coupons);

                Pays pay = dao.getPayById(rs.getInt(3));
                orders.setPay_id(pay);

                Status status = new Status();
                status.setStatus_id(rs.getInt(4));
                orders.setStatus_id(status);

                orders.setProvinces(rs.getString(5));
                orders.setDistrict(rs.getString(6));
                orders.setWard(rs.getString(7));
                orders.setPhone(rs.getString(8));
                orders.setNote(rs.getString(9));
                orders.setDate(rs.getString(10));
                orders.setTotal_money(rs.getInt(11));

                return orders;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<Order_items> getBillDetail(){
        List<Order_items> list = new ArrayList<>();
        String sql = "";
        try {
            
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        OrderDAO orderDAO = new OrderDAO();

        // Tạo các đối tượng liên quan
        Cart cart = new Cart();
        cart.setCart_id(1); // Giả sử ID của Cart là 1

        Coupon coupon = new Coupon();
        coupon.setId(1); // Giả sử ID của Coupon là 1

        Pays pay = new Pays();
        pay.setPay_id(1); // Giả sử ID của Payment là 1

        Status status = new Status();
        status.setStatus_id(4); // Giả sử ID của Status là 1

        // Tạo đối tượng Orders với dữ liệu giả định
        Orders order = new Orders();
        order.setCart_id(cart);
        order.setCoup_id(coupon);
        order.setPay_id(pay);
        order.setStatus_id(status);
        order.setProvinces("Hà Nội");
        order.setDistrict("Đống Đa");
        order.setWard("Phường Trung Liệt");
        order.setPhone("0123456789");
        order.setNote("Giao hàng vào buổi sáng");
        order.setDate("2023-06-05 10:00:00"); // Định dạng yyyy-MM-dd HH:mm:ss
        order.setTotal_money(500000);

        // Gọi phương thức insertOrder
        orderDAO.insertOrder(order);

        System.out.println("Order inserted successfully");

    }
}
