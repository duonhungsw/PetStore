package controler;

import daos.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

@WebServlet(name="ProfileControl", urlPatterns={"/profile"})
public class ProfileControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account user = (Account) session.getAttribute("LOGIN_USER");
        AccountDAO acc = new AccountDAO();
        Account u = acc.getAccountbyID(user.getAccId());
        System.out.println(user.getAccId());
        request.setAttribute("account", u);
        request.getRequestDispatcher("userProfile.jsp").forward(request, response);
    } 
}
