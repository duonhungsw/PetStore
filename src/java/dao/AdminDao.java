/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import daos.DBContext;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Cart;
import model.Category;
import model.Coin;
import model.Coupon;
import model.Order;
import model.OrderItem;
import model.Payment;
import model.PetGroomerInfo;
import model.Product;
import model.ProductDetail;
import model.Role;
import model.Service;
import model.ServiceBooking;
import model.Status;
import model.TimeSale;

/**
 *
 * @author ADMIN
 */
public class AdminDao extends DBContext {

    // Function: Get Account By Role
    public List<Account> getAllAccountByRole(int role) {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT * FROM ACCOUNT WHERE role_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, role);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getInt(1), getRoleById(rs.getInt(2)), getCoinById(rs.getInt(3)), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13));
                list.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public Role getRoleById(int id) {
        String sql = "SELECT [role_id]\n"
                + "      ,[role_name]\n"
                + "  FROM [dbo].[Role] where role_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Role role = new Role(rs.getInt(1), rs.getString(2));
                return role;
            }
        } catch (Exception e) {
        }

        return null;
    }

    public Coin getCoinById(int id) {
        String sql = "SELECT [coin_id]\n"
                + "      ,[numberCoin]\n"
                + "  FROM [dbo].[Coin] where coin_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Coin coin = new Coin(rs.getInt(1), rs.getInt(2));
                return coin;
            }
        } catch (Exception e) {
        }

        return null;
    }

    public Account getAccountByEmail(String email) {
        String sql = "SELECT * FROM ACCOUNT WHERE email = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account a = new Account(rs.getInt(1), getRoleById(rs.getInt(2)), getCoinById(rs.getInt(3)), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13));
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Account getAccountBId(int id) {
        String sql = "SELECT * FROM ACCOUNT WHERE account_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account a = new Account(rs.getInt(1), getRoleById(rs.getInt(2)), getCoinById(rs.getInt(3)), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13));
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Account> getNewAccountByRole(int role) {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT * FROM ACCOUNT WHERE role_id = ? and YEAR(creation_datetime) = YEAR(GETDATE()) and MONTH(creation_datetime) = MONTH(GETDATE()) and DAY(creation_datetime) = DAY(GETDATE())";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, role);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getInt(1), getRoleById(rs.getInt(2)), getCoinById(rs.getInt(3)), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13));
                list.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void insertAccount(int role, String email, String username, String pass) {
        String sql = "INSERT INTO Account(role_id, email, username, pass, creation_datetime, status)\n"
                + "values(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, role);
            st.setString(2, email);
            st.setString(3, username);
            st.setString(4, pass);
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDate = now.format(dateFormatter);
            st.setString(5, formattedDate);
            st.setInt(6, 1);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStatusAccount(int id, int status) {
        String sql = "UPDATE Account SET status = ? WHERE account_id = ?";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setInt(1, status);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ProductDetail getProductDetailById(int id) {
        String sql = "SELECT * FROM Product_Detail WHERE product_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                ProductDetail p = new ProductDetail();
                p.setProductDetailId(rs.getInt(1));
                p.setProduct(getProductById(rs.getInt(2)));
                p.setPrice(rs.getInt(3));
                p.setAmount(rs.getInt(4));
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    // Funtion: Get Product By Id
    public Product getProductById(int id) {
        String sql = "SELECT * FROM PRODUCT where product_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product p = new Product(rs.getInt("product_id"), getCategoryById(rs.getInt("cate_id")),
                        rs.getString("nameP"), rs.getString("imageProduct"), rs.getString("thumnail"),
                        rs.getString("created_at"), rs.getString("updated_at"), rs.getInt("deleted"));
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void insertProduct(Product p) {
        String sql = "INSERT INTO Product(cate_id, nameP, imageProduct, deleted)\n"
                + "values(?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, p.getCateId().getCategory_id());
            st.setString(2, p.getNameP());
            st.setString(3, p.getImageProduct());
            st.setInt(4, 1);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertProductDetail(ProductDetail pd, Product p) {
        String sql = "INSERT INTO Product_Detail\n"
                + "values(?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, getProductByName(p).getProdId());
            st.setDouble(2, pd.getPrice());
            st.setInt(3, pd.getAmount());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(int id, String name, String img, double price, int amount) {
        String sql = "update Product set nameP=?, imageProduct=? where product_id=? \n"
                + "update Product_Detail set price = ?, amount = ? where product_id =?";
        try {
            PreparedStatement st = connection.prepareCall(sql);

            st.setString(1, name);
            st.setString(2, img);
            st.setInt(3, id);
            st.setDouble(4, price);
            st.setInt(5, amount);
            st.setInt(6, id);

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void discount(double amount) {
        String sql = "update Product_Detail set price = price * ?\n"
                + "update ServicePrice set service_price = service_price * ?";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setDouble(1, amount);
            st.setDouble(2, amount);

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void increase(double amount) {
        String sql = "update Product_Detail set price = price / ?\n"
                + "update ServicePrice set service_price = service_price / ?";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setDouble(1, amount);
            st.setDouble(2, amount);

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public TimeSale getTimeSale() {
        String sql = "SELECT * FROM TimeSale";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                TimeSale ts = new TimeSale();
                ts.setId(rs.getInt(1));
                ts.setStartHour(rs.getInt(2));
                ts.setStartMinute(rs.getInt(3));
                ts.setEndHour(rs.getInt(4));
                ts.setEndMinute(rs.getInt(5));
                ts.setDiscount(rs.getInt(6));
                ts.setStatus(rs.getInt(7));

                return ts;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void updateTimeSale(TimeSale ts) {
        String sql = "UPDATE TimeSale SET start_hour = ?, start_minute = ?, end_hour = ?, end_minute = ?, discount = ?";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setInt(1, ts.getStartHour());
            st.setInt(2, ts.getStartMinute());
            st.setInt(3, ts.getEndHour());
            st.setInt(4, ts.getEndMinute());
            st.setInt(5, ts.getDiscount());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateStatusTimeSale(int status) {
        String sql = "UPDATE TimeSale SET status = ?";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setInt(1, status);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateStatusProduct(int id, int status) {
        String sql = "UPDATE Product SET deleted = ? WHERE product_id = ?";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setInt(1, status);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Product getProductByName(Product p) {
        String sql = "SELECT TOP 1 * FROM PRODUCT where nameP = ?\n"
                + "ORDER BY product_id DESC";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, p.getNameP());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product product = new Product(rs.getInt("product_id"), getCategoryById(rs.getInt("cate_id")),
                        rs.getString("nameP"), rs.getString("imageProduct"), rs.getString("thumnail"),
                        rs.getString("created_at"), rs.getString("updated_at"), rs.getInt("deleted"));
                return product;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void insertService(Service s) {
        String sql = "INSERT INTO ServiceDetail\n"
                + "values(?, ?, ?)\n"
                + "INSERT INTO ServicePrice\n"
                + "values(?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, s.getService_name());
            st.setString(2, s.getService_img());
            st.setInt(3, 1);
            st.setInt(4, getLatestIdFromServiceDetail().getService_id() + 1);
            st.setInt(5, s.getService_price());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Service getServiceById(int id) {

        String sql = "SELECT sd.service_id, sd.service_name, sp.service_price, sd.service_img, sd.status \n"
                + "FROM ServiceDetail sd INNER JOIN ServicePrice sp ON sd.service_id = sp.service_id\n"
                + "WHERE sd.service_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Service s = new Service();
                s.setService_id(rs.getInt(1));
                s.setService_name(rs.getString(2));
                s.setService_price(rs.getInt(3));
                s.setService_img(rs.getString(4));
                s.setStatus(rs.getInt(5));
                return s;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void updateService(int id, String name, String img, double price) {
        String sql = "update ServiceDetail set service_name=?, service_img=? where service_id=? \n"
                + "update ServicePrice set service_price = ? where service_id =?";
        try {
            PreparedStatement st = connection.prepareCall(sql);

            st.setString(1, name);
            st.setString(2, img);
            st.setInt(3, id);
            st.setDouble(4, price);
            st.setInt(5, id);

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void updateStatusService(int id, int status) {
        String sql = "UPDATE ServiceDetail SET status = ? WHERE service_id = ?";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setInt(1, status);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public PetGroomerInfo getGroomerById(int id) {

        String sql = "SELECT * FROM PetGroomerInfo WHERE groomer_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                PetGroomerInfo pgi = new PetGroomerInfo();
                pgi.setGroomer_id(rs.getByte(2));
                pgi.setGroomer_name(rs.getString(3));
                return pgi;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Service getLatestIdFromServiceDetail() {
        String sql = "  SELECT TOP 1 * \n"
                + "  FROM ServiceDetail\n"
                + "  ORDER BY service_id DESC";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Service service = new Service();
                service.setService_id(rs.getInt(1));
                service.setService_name(rs.getString(2));
                service.setService_img(rs.getString(3));
                return service;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    // Function: Get All Coupon
    public List<Coupon> getAllCoupon() {
        List<Coupon> list = new ArrayList<>();
        String sql = "SELECT * FROM Coupon";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Coupon c = new Coupon();
                c.setId(rs.getInt(1));
                c.setCode(rs.getString(2));
                c.setDiscount(rs.getInt(3));
                c.setTime(rs.getString(4));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Coupon getCouponById(int id) {
        String sql = "SELECT * FROM Coupon where coupon_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Coupon c = new Coupon();
                c.setId(rs.getInt(1));
                c.setCode(rs.getString(2));
                c.setDiscount(rs.getInt(3));
                c.setTime(rs.getString(4));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void insertCoupon(String code, int discount) {
        String sql = "INSERT INTO Coupon(code, discount)\n"
                + "values(?, ?)\n";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, code);
            st.setInt(2, discount);
//            st.setString(3, time);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM Category";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt(1), rs.getString(2));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Category getCategoryById(int id) {
        String sql = "SELECT * FROM Category where category_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Category c = new Category(rs.getInt(1), rs.getString(2));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public BigDecimal getTotalMoneyOrderByYear(int year) {
        String sql = "SELECT SUM(total_money) FROM Orders WHERE YEAR(date_time) = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, year);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getBigDecimal(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public BigDecimal getTotalMoneyOrderByMonth(int month) {
        String sql = "SELECT SUM(total_money) FROM Orders WHERE MONTH(date_time) = ? and YEAR(date_time) = YEAR(GETDATE())";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, month);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getBigDecimal(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public BigDecimal getTotalMoneyOrderToday() {
        String sql = "SELECT SUM(total_money) FROM Orders WHERE YEAR(date_time) = YEAR(GETDATE()) and MONTH(date_time) = MONTH(GETDATE()) and DAY(date_time) = DAY(GETDATE())";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getBigDecimal(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public BigDecimal getTotalMoneyOrder() {
        String sql = "SELECT SUM(total_money) FROM Orders";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getBigDecimal(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Order getOrderById(int id) {
        String sql = "SELECT * FROM Orders where order_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Order o = new Order();
                o.setOrderId(rs.getInt(1));
                o.setCart(getCartById(rs.getInt(2)));
                o.setCoupon(getCouponById(rs.getInt(3)));
                o.setPayment(getPaymentById(rs.getInt(4)));
                o.setStatus(getStatusById(rs.getInt(5)));
                o.setProvinces(rs.getString(6));
                o.setDistrict(rs.getString(7));
                o.setWard(rs.getString(8));
                o.setPhone(rs.getString(9));
                o.setNote(rs.getString(10));
                o.setDate(rs.getDate(11));
                o.setTotalMoney(rs.getBigDecimal(12));
                return o;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Cart getCartById(int id) {
        String sql = "SELECT * FROM Cart where cart_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Cart c = new Cart();
                c.setCart_id(rs.getInt(1));
                c.setAcoount_id(getAccountBId(rs.getInt(2)));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Payment getPaymentById(int id) {
        String sql = "SELECT * FROM Pays where pay_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Payment p = new Payment();
                p.setPayId(rs.getInt(1));
                p.setPayName(rs.getString(2));
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Status getStatusById(int id) {
        String sql = "SELECT * FROM Status where status_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Status s = new Status();
                s.setStatus_id(rs.getInt(1));
                s.setName(rs.getString(2));
                return s;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<ProductDetail> searchProduct(String key, int cid) {
        List<ProductDetail> list = new ArrayList<>();
        String sql = "select p.product_id, pd.price, pd.amount\n"
                + "  from Product p\n"
                + "  join Product_Detail pd on p.product_id = pd.product_id\n"
                + "  where 1 = 1\n";
        if (key != null && !key.equals("")) {
            sql += " and p.nameP like N'%" + key + "%'";
        }

        if (cid != 0) {
            sql += " and p.cate_Id = " + cid;
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductDetail pd = new ProductDetail();
                pd.setProduct(getProductById(rs.getInt(1)));
                pd.setPrice(rs.getDouble(2));
                pd.setAmount(rs.getInt(3));
                list.add(pd);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public <E> List<E> getListByPage(List<E> list, int start, int end) {
        List<E> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public List<Service> searchService(String key) {
        List<Service> list = new ArrayList<>();
        String sql = "SELECT sd.service_id, sd.service_name, sp.service_price, sd.service_img, sd.status\n"
                + " FROM ServiceDetail sd INNER JOIN ServicePrice sp ON sd.service_id = sp.service_id\n"
                + " WHERE 1 = 1";
        if (key != null && !key.equals("")) {
            sql += " and sd.service_name like N'%" + key + "%'";
        }

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Service s = new Service();
                s.setService_id(rs.getInt(1));
                s.setService_name(rs.getString(2));
                s.setService_price(rs.getInt(3));
                s.setService_img(rs.getString(4));
                s.setStatus(rs.getInt(5));
                list.add(s);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<OrderItem> searchOrderProduct(String key) {
        List<OrderItem> list = new ArrayList<>();
        String sql = "SELECT oi.* \n"
                + " FROM Order_items oi\n"
                + " JOIN Orders o ON oi.order_id = o.order_id\n"
                + " JOIN Product p ON oi.product_id = p.product_id\n"
                + " WHERE o.status_id = 1\n";
        if (key != null && !key.equals("")) {
            sql += " and p.nameP like N'%" + key + "%'";
        }

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                OrderItem oi = new OrderItem();
                oi.setOrderItemId(rs.getInt(1));
                oi.setOrder(getOrderById(rs.getInt(2)));
                oi.setProduct(getProductById(rs.getInt(3)));
                oi.setPrice(rs.getDouble(4));
                oi.setTotalOfMoney(rs.getDouble(5));
                oi.setAmount(rs.getByte(6));
                list.add(oi);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<ServiceBooking> searchOrderService(String key) {
        List<ServiceBooking> list = new ArrayList<>();
        String sql = "SELECT c.* \n"
                + " FROM CustomerServiceBookings c\n"
                + " JOIN ServiceDetail s ON c.service_id = s.service_id\n"
                + " WHERE c.status = 1\n";
        if (key != null && !key.equals("")) {
            sql += " and s.service_name like N'%" + key + "%'";
        }

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ServiceBooking sb = new ServiceBooking();
                sb.setBookingId(rs.getInt(1));
                sb.setService(getServiceById(rs.getInt(2)));
                sb.setCustomer(getAccountBId(rs.getInt(3)));
                sb.setGroomer(getGroomerById(rs.getInt(4)));
                sb.setCustomerName(rs.getString(5));
                sb.setCustomerPhone(rs.getString(6));
                sb.setBookingDate(rs.getDate(7));
                sb.setBookingTime(rs.getInt(8));
                sb.setPrice(rs.getInt(9));
                sb.setStatus(rs.getInt(10));
                list.add(sb);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Account> searchAccount(String key, int role) {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT * \n"
                + " FROM Account WHERE role_id = ?\n";
        if (key != null && !key.equals("")) {
            sql += " and name like N'%" + key + "%'";
        }

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, role);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getInt(1), getRoleById(rs.getInt(2)), getCoinById(rs.getInt(3)), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13));
                list.add(a);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public static void main(String[] args) {
        AdminDao ad = new AdminDao();
        TimeSale ts = ad.getTimeSale();
        double amount = 1 - (double) ts.getDiscount() / 100;
        System.out.println(amount);
//        ad.discount(amount);
        System.out.println("Finish");
    }

}
