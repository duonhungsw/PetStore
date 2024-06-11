package controler.client;

import daos.AccountDAO;
import daos.CartDAO;
import daos.OrderDAO;
import daos.ProvincesVNDAO;
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
import model.Coin;
import model.Pays;
import model.Provinces;

@WebServlet(name = "CheckOutControl", urlPatterns = {"/checkout"})
public class CheckOutControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("LOGIN_USER");
        CartDAO cartDAO = new CartDAO();
        Cart cart = cartDAO.getCartByUserId(acc.getAccId());
        

        List<Cart_Item> list = cartDAO.getOrderCart_Items(cart.getCart_id());


        OrderDAO orderDAO = new OrderDAO();
        int totalMoney = orderDAO.getTotalMoneyOrders(cart.getCart_id());

        Coin coin = orderDAO.getCoin(acc.getCoin_id().getCoin_id());
        
        List<Pays> listPayses = orderDAO.listPay();

        
        ProvincesVNDAO dao = new ProvincesVNDAO();
        List<Provinces> listProvinces = dao.getAllProvinces();
        
        request.setAttribute("user", acc);

        request.setAttribute("provinces", listProvinces);
        request.setAttribute("listP", listPayses);
        request.setAttribute("listO", list);
        request.setAttribute("totalM", totalMoney);
        request.setAttribute("coin", coin);
        
        request.getRequestDispatcher("checkOut.jsp").forward(request, response);

    }

}
