package daos;

import model.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Cart;
import model.Cart_Item;
import model.Product;
import model.Product_Detail;
import model.State;

public class CartDAO extends DBContext {

    AccountDAO accountDAO = new AccountDAO();

    public Cart getCartbyUserID(int id) {
        String sql = "SELECT [cart_id]\n"
                + "      ,[acc_Id]\n"
                + "  FROM [dbo].[Cart]\n"
                + "  where acc_Id  =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Cart cart = new Cart();
                cart.setCart_id(rs.getInt(1));
                Account acc = accountDAO.getAccountbyID(id);
                cart.setAcoount_id(acc);
                return cart;
            }

        } catch (Exception e) {
        }
        return null;
    }

    public void insertCartofUser(int id) {
        String sql = "INSERT INTO [dbo].[Cart]\n"
                + "           ([acc_Id])\n"
                + "     VALUES\n"
                + "           (?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);

            st.executeUpdate();

        } catch (Exception e) {
        }
    }

    public Cart getCartByCartId(int id) {
        String sql = "select cart_id, acc_Id from Cart where cart_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Cart cart = new Cart();
                cart.setCart_id(rs.getInt(1));

                //
                AccountDAO accountDAO = new AccountDAO();
                Account account = accountDAO.getAccountbyID(rs.getInt(2));
                cart.setAcoount_id(account);
                return cart;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Cart getCartByUserId(int id) {
        String sql = "select cart_id, acc_Id from Cart where acc_Id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Cart cart = new Cart();
                cart.setCart_id(rs.getInt(1));

                //
                AccountDAO accountDAO = new AccountDAO();
                Account account = accountDAO.getAccountbyID(rs.getInt(2));
                cart.setAcoount_id(account);
                return cart;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public int getCartMaxById(int id) {
        String sql = "Select max(cart_id) as cart_id from cart";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(("cart_id"));
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void addtoCartItem(int prod_id, int cartID, int stateID, int total_money, int quantity) {
        String sql = "INSERT INTO [dbo].[Cart_Item]\n"
                + "           ([prod_Id]\n"
                + "           ,[cart_Id]\n"
                + "           ,[sta_Id]\n"
                + "           ,[total_money]\n"
                + "           ,[quanity])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, prod_id);
            st.setInt(2, cartID);
            st.setInt(3, stateID);
            st.setInt(4, total_money);
            st.setInt(5, quantity);

            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Category getCategorybyID(int id) {
        String sql = "SELECT [category_id]\n"
                + "      ,[name]\n"
                + "  FROM [dbo].[Category]\n"
                + "  where category_id  = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Category category = new Category();
                category.setCategory_id(rs.getInt(1));
                category.setName(rs.getString(2));

                return category;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public State getState(int id) {
        String sql = "SELECT * FROM State WHERE state_id = ?";
        try ( PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, id);
            try ( ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    State state = new State();
                    state.setId(rs.getInt(1));
                    state.setNamestate(rs.getString(2));

                    return state;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Product_Detail getDetailOfProduct(int id) {
        String sql = "Select * from Product_Detail as p\n"
                + "where p.product_id =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product_Detail product_Detail = new Product_Detail();
                product_Detail.setProduct_detail_id(rs.getInt(1));
                product_Detail.setPrice(rs.getInt(3));
                product_Detail.setAmount(rs.getInt(4));

                return product_Detail;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Product getProductbyID(int id) {
        String sql = "SELECT Product.cate_Id, Product.nameP, Product.imageProduct, Product.thumnail, "
                + "Product_Detail.product_detail_id, Product_Detail.price, Product_Detail.amount "
                + "FROM Product "
                + "INNER JOIN Product_Detail ON Product.product_id = Product_Detail.product_id "
                + "WHERE Product.product_id = ?";
        try ( PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, id);
            try ( ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    Product product = new Product();
                    product.setProdId(id);
                    Category category = getCategorybyID(rs.getInt("cate_Id"));
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
            e.printStackTrace(); 
        }
        return null; 
    }
    
    

    public boolean updateCartItemQuantity(int quantity, int cartIteam_id) {
        String sql = "UPDATE Cart_Item SET quanity = ?, total_money = ? WHERE cartItem_id = ?";
        String sql1 = "";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, quantity);
            Cart_Item cart_Item = getCartItembyId(cartIteam_id);
            int totalMoney = cart_Item.getProd_id().getProductDetail().getPrice() * quantity;

            st.setInt(2, totalMoney);
            st.setInt(3, cartIteam_id);

            st.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public void deleteCartIteam(int id) {
        String sql = "delete from Cart_Item where cartItem_id  = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateStateCI(int id, int CIID) {
        String sql1 = "Update Cart_Item set sta_Id = ? where cartItem_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql1);
            st.setInt(1, id);
            st.setInt(2, CIID);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateAllAtateCI(int id) {
        String sql1 = "Update Cart_Item set sta_Id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql1);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Cart_Item getCartItemofUser(int id) {
        String sql = "SELECT [cartItem_id], [prod_Id], [cart_Id], [sta_Id], [total_money], [quanity] "
                + "FROM [dbo].[Cart_Item] WHERE [cart_Id] = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Cart_Item cart_Item = new Cart_Item();
                cart_Item.setId(rs.getInt("cartItem_id"));

                Product p = getProductbyID(rs.getInt("prod_Id"));
                cart_Item.setProd_id(p);

                Cart cart = getCartByCartId(rs.getInt("cart_Id"));
                cart_Item.setCart_id(cart);

                State state = getState(rs.getInt("sta_Id"));
                cart_Item.setSta_id(state);

                cart_Item.setTotal_money(rs.getInt("total_money"));
                cart_Item.setQuantity(rs.getInt("quanity"));

                return cart_Item;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception for debugging purposes
        }

        return null; // Return null if no cart item is found or in case of an error
    }

    public Cart_Item getCartItembyId(int id) {
        String sql = "SELECT [cartItem_id]\n"
                + "      ,[prod_Id]\n"
                + "      ,[cart_Id]\n"
                + "      ,[sta_Id]\n"
                + "      ,[total_money]\n"
                + "      ,[quanity]\n"
                + "  FROM [dbo].[Cart_Item] where cartItem_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Cart_Item cart_Item = new Cart_Item();
                cart_Item.setId(rs.getInt(1));
                Product p = getProductbyID(2);
                cart_Item.setProd_id(p);

                Cart cart = getCartByCartId(rs.getInt(3));
                cart_Item.setCart_id(cart);

                State state = getState(4);
                cart_Item.setSta_id(state);

                cart_Item.setTotal_money(rs.getInt(5));
                cart_Item.setQuantity(rs.getInt(6));

                return cart_Item;

            }
        } catch (Exception e) {
        }

        return null;
    }

    public List<Cart_Item> getListCartItem(int id) {
        List<Cart_Item> list = new ArrayList<>();
        String sql = "SELECT [cartItem_id]\n"
                + "      ,[prod_Id]\n"
                + "      ,[cart_Id]\n"
                + "      ,[sta_Id]\n"
                + "      ,[total_money]\n"
                + "      ,[quanity]\n"
                + "  FROM [dbo].[Cart_Item] where cart_Id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Cart_Item cart_Item = new Cart_Item();
                cart_Item.setId(rs.getInt(1));
                Product p = getProductbyID(2);
                cart_Item.setProd_id(p);

                Cart cart = getCartByCartId(rs.getInt(3));
                cart_Item.setCart_id(cart);

                State state = getState(rs.getInt(4));
                cart_Item.setSta_id(state);

                cart_Item.setTotal_money(rs.getInt(5));
                cart_Item.setQuantity(rs.getInt(6));

                list.add(cart_Item);

            }
        } catch (Exception e) {
        }

        return list;
    }

    public List<Cart_Item> getOrderCart_Items(int id) {
        List<Cart_Item> list = new ArrayList<>();
        String sql = "SELECT [cartItem_id]\n"
                + "      ,[prod_Id]\n"
                + "      ,[cart_Id]\n"
                + "      ,[sta_Id]\n"
                + "      ,[total_money]\n"
                + "      ,[quanity]\n"
                + "  FROM [dbo].[Cart_Item]\n"
                + "  where cart_Id  = ? and sta_Id = 1";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Cart_Item cart_Item = new Cart_Item();
                cart_Item.setId(rs.getInt(1));
                Product p = getProductbyID(2);
                cart_Item.setProd_id(p);

                Cart cart = getCartByCartId(rs.getInt(3));
                cart_Item.setCart_id(cart);

                State state = getState(rs.getInt(4));
                cart_Item.setSta_id(state);

                cart_Item.setTotal_money(rs.getInt(5));
                cart_Item.setQuantity(rs.getInt(6));

                list.add(cart_Item);

            }
        } catch (Exception e) {
        }

        return list;
    }
    
    public void insertCart(int id) {
        String sql = "INSERT INTO [dbo].[Cart] ([acc_Id]) VALUES(?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

        } catch (Exception e) {
        }

    }

    public static void main(String[] args) {
        CartDAO cartDAO = new CartDAO();

        State s = cartDAO.getState(1);
        System.out.println(s.toString());

        List<Cart_Item> list = cartDAO.getListCartItem(1);
        for (Cart_Item cart_Item : list) {
            System.out.println(cart_Item.toString());
        }
    }
}
