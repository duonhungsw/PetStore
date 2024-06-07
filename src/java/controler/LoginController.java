package controler;

import daos.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Account;
import util.Tools;

@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        HttpSession session = request.getSession();
        int timeoutInSeconds = 1800;
        session.setMaxInactiveInterval(timeoutInSeconds);
        AccountDAO accountDAO = new AccountDAO();
        try {
            Account account = accountDAO.login(email, pass);
            if(account.getStatus() == 0){
                request.setAttribute("accounterror", "Your account was blocked!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            if (account == null ) {
                request.setAttribute("exist", "Wrong login again");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } 
            else {
                session.setAttribute("LOGIN_USER", account);
                int roleId = account.getRole_id().getRole_id();
                System.out.println(roleId);
                switch (roleId) {
                    case 1:
                        response.sendRedirect("admin");
                        break;
                    case 2:
                        response.sendRedirect("pageForRole2"); 
                        break;
                    case 3:
                        response.sendRedirect("petServiceManageControl"); 
                        break;
                    case 4:
                        response.sendRedirect("home");
                        break;
                    default:
                        response.sendRedirect("defaultPage"); 
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error while logging in");
        }
    }
}
