package controler.client;

import daos.CartDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateStateCartItemControl", urlPatterns = {"/updateState"})
public class UpdateStateCartItemControl extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int state = Integer.parseInt(request.getParameter("state"));
            int cartItemId = Integer.parseInt(request.getParameter("cartItemId"));

            CartDAO cartdao = new CartDAO();
            cartdao.updateStateCI(state, cartItemId);
            
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
