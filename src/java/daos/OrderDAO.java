
package daos;

import java.util.List;
import model.Cart_Item;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Coupon;

public class OrderDAO extends DBContext{
    public int getTotalMoneyOrders(int id){
        String sql = "  select sum(total_money)as total from Cart_Item where cart_Id = ? and sta_Id = 1";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    public int getCoin(int id){
        String sql = "select numberCoin from Coin where coin_id  = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    public List<Coupon> findCouponsByKeyword(String code){
        List<Coupon> list = new ArrayList<>();
        String sql  ="select * from Coupon where code like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,"%"+ code+ "%");
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
    
    public static void main(String[] args) {
        OrderDAO orderDAO = new OrderDAO();
        List<Coupon> total = orderDAO.findCouponsByKeyword("31bd74cd");
        for (Coupon coupon : total) {
            System.out.println(coupon.toString());
        }
    }
}
