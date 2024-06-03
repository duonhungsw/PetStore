package controler.client;

import daos.CartDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cart_Item;
import org.json.JSONObject;

@WebServlet(name = "UpdateCartItemQuantity", urlPatterns = {"/updateCartItemQuantity"})
public class UpdateCartItemQuantity extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cartItemId = Integer.parseInt(request.getParameter("cartItemId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        CartDAO cartdao = new CartDAO();
        boolean update = cartdao.updateCartItemQuantity(quantity, cartItemId);
        
        Cart_Item cart_Item = cartdao.getCartItembyId(cartItemId);
        int total = cart_Item.getTotal_money();
        
        request.setAttribute("money", total);

        JSONObject jsonResponse = new JSONObject();
        if (update) {
            Cart_Item updatedCartItem = cartdao.getCartItembyId(cartItemId);
            jsonResponse.put("success", true);
            jsonResponse.put("totalMoney", updatedCartItem.getTotal_money());
        } else {
            jsonResponse.put("success", false);
        }

        response.setContentType("application/json");
        response.getWriter().write(jsonResponse.toString());

    }

}
