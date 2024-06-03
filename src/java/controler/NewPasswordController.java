
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

@WebServlet(name="NewPasswordController", urlPatterns={"/newpassword"})
public class NewPasswordController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("new_password.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
                HttpSession session = request.getSession();

        String newpass = request.getParameter("password");
        if(newpass == null || newpass.isEmpty()){
            request.setAttribute("errorPass", "Enter password!");
            request.getRequestDispatcher("new_password.jsp").forward(request, response);
        }
        String email =  (String) session.getAttribute("emailAccount");
        request.removeAttribute("emailAccount");
        AccountDAO accountDAO  = new AccountDAO();
        accountDAO.updatePassOfAccount(newpass, email);
        response.sendRedirect("login");
    }
}
