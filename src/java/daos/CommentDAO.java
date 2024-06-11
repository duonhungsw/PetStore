package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Comment;

public class CommentDAO {
    
    private final DBContext dbContext;

    public CommentDAO() {
        dbContext = new DBContext();
    }

    public void saveComment(Comment comment) {
        String sql = "INSERT INTO Comment (prod_Id, acc_id, description) VALUES (?, ?, ?)";
        try (Connection conn = dbContext.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, comment.getProd_Id());
            stmt.setString(2, comment.getAcc_id());
            stmt.setString(3, comment.getDescription());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbContext.closeConnection();
        }
    }

    public List<Comment> getCommentsByProductId(int prod_Id) {
        List<Comment> comments = new ArrayList<>();
        String sql = "SELECT comment_id, prod_Id, acc_id, description FROM Comment WHERE prod_Id = ?";
        try (Connection conn = dbContext.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, prod_Id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Comment comment = new Comment();
                    comment.setComment_id(rs.getInt("comment_id"));
                    comment.setProd_Id(rs.getInt("prod_Id"));
                    comment.setAcc_id(rs.getString("acc_id"));
                    comment.setDescription(rs.getString("description"));
                    comments.add(comment);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbContext.closeConnection();
        }
        return comments;
    }
}
