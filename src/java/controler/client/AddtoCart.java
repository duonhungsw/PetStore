
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
import model.Account;
import model.Cart;
import model.Product;


@WebServlet(name="AddtoCart", urlPatterns={"/addtoCart"})
public class AddtoCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account user = (Account) session.getAttribute("LOGIN_USER");
        
        String productId = request.getParameter("productId");
        String quantityString = request.getParameter("quantity");
        
        CartDAO cartdao = new CartDAO();
        Cart cart  = cartdao.getCartbyUserID(user.getAccId());
        if(productId != null && quantityString !=null){
            try {
                int pid = Integer.parseInt(productId);
                int quantity = Integer.parseInt(quantityString);
                
                Product product =cartdao.getProductbyID(pid);
                if(product!=null){
                    
                }
            } catch (Exception e) {
            }
        }
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    }


}
