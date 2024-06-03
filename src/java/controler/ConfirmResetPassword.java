
package controler;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name="ConfirmResetPassword", urlPatterns={"/confirmResetPassword"})
public class ConfirmResetPassword extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        String token = request.getParameter("token");
        String sessionToken = (String) session.getAttribute("confirmationToken");

        if (token != null && token.equals(sessionToken)) {
            session.removeAttribute("confirmationToken");
            request.getRequestDispatcher("new_password.jsp").forward(request, response);
        } else {
            response.sendRedirect("login");
        }
    } 

}
