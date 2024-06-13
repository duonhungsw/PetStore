package controllerP;

import daos.CartDAO;
import daos.ConfiOrdersDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import util.Email;

@WebServlet(name = "UpdateStatusOrder", urlPatterns = {"/updateStatus"})
public class UpdateStatusOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ConfiOrdersDAO cDAO = new ConfiOrdersDAO();

        try {

            int id = Integer.parseInt(request.getParameter("id"));
            cDAO.updateStatus(id);
            response.sendRedirect("loadorders");

            HttpSession session = request.getSession();
            CartDAO cdao = new CartDAO();
            Cart cart = cdao.getCartbyUserID(id);

            String tieude = "Don Hang PetStore";
            String noidung = "<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "<head>\n"
                    + "<title>Page Title</title>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "\n"
                    + "<h1>Đơn hàng của bạn đang trên đường vận chuyển</h1>\n"
                    + "<p>Cảm ơn Qúy Khách đã mua hàng.</p>\n"
                    + "\n"
                    + "</body>\n"
                    + "</html>";
            Email email = new Email();
            boolean sendSuccess = email.sendMail(cart.getAcoount_id().getEmail(), tieude, noidung);
        } catch (Exception e) {
        }

    }
}
