
package controler.client;

import daos.CartDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Account;
import model.Cart;
import model.Cart_Item;

@WebServlet(name="CartControl", urlPatterns={"/cart"})
public class CartControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("LOGIN_USER");
        CartDAO cartDAO  =new CartDAO();
        Cart cart = cartDAO.getCartByUserId(acc.getAccId());
        List<Cart_Item> list = cartDAO.getListCartItem(cart.getCart_id());
//        
//        for (Cart_Item cart_Item : list) {
//            System.out.println(cart_Item.toString());
//            
//        }
        request.setAttribute("CI", list);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    } 

    
}
