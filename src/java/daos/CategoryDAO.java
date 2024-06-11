package daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Product;

public class CategoryDAO extends DBContext {

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

    public void insert_Category(Category c) {
        String sql = "INSERT INTO [dbo].[Category] ([category_id], [name]) VALUES (?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getCategory_id());
            
            st.setString(2, c.getName());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Category check_Category_By_Id(int id) {
        String sql = "SELECT [category_id],[name] FROM [dbo].[Category] WHERE category_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("category_id"), rs.getString("name"));
                return c;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void update_Category(Category c) {
        String sql = "UPDATE [dbo].[Category] SET [name] = ? WHERE [category_id] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
          
            st.setString(1, c.getName());
            st.setInt(2, c.getCategory_id());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete_Category(int id) {
        String sql = "DELETE FROM [dbo].[Category] WHERE [category_id] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
//        int id = 4;
//        CategoryDAO categoryDAO = new CategoryDAO();
//        Category c = categoryDAO.check_Category_By_Id(id);
//        if (c != null) {
//            System.out.println(c.toString());
//        } else {
//            System.out.println("Category not found");
//        }
    CategoryDAO categoryDAO = new CategoryDAO();
    List<Category> listC = categoryDAO.getAllCategory();
    for(Category o : listC){
        System.out.println(o);
    }
    }
}
