package controler;

import daos.AccountDAO;
import jakarta.mail.MessagingException;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import util.Email;
import util.Tools;

@WebServlet(name = "ForgotPassController", urlPatterns = {"/forgotPassword"})
public class ForgotPassController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("forgot_password.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        AccountDAO accountDAO = new AccountDAO();
        boolean CheckAccount = accountDAO.getAccountByEmail(email);
        if (CheckAccount == true) {
            Account acc = accountDAO.getAccountInfoByEmail(email);
            session.setAttribute("emailAccount", acc.getEmail());

            String token = Tools.generateNewToken();
            session.setAttribute("confirmationToken", token);
            String URL = "http://localhost:9999/PetStore/confirmResetPassword?token=" + token;

            String url = "\n"
                    + "\n"
                    + "<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                    + "        <title>JSP Page</title>\n"
                    + "\n"
                    + "        <style>\n"
                    + "            .styled-url {\n"
                    + "                display: inline-block;\n"
                    + "                padding: 10px 20px;\n"
                    + "                background-color: #007bff;\n"
                    + "                color: white;\n"
                    + "                text-decoration: none;\n"
                    + "                border-radius: 5px;\n"
                    + "                font-size: 16px;\n"
                    + "                font-weight: bold;\n"
                    + "                transition: background-color 0.3s ease;\n"
                    + "            }\n"
                    + "\n"
                    + "            .styled-url:hover {\n"
                    + "                background-color: #0056b3;\n"
                    + "            }\n"
                    + "        </style>\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        <p style=\"text-align: center; margin-top: 20px;\">\n"
                    + "            <a href=\"" + URL + "\" class=\"styled-url\">Confirm Reset Password</a>\n"
                    + "        </p>\n"
                    + "    </body>\n"
                    + "</html>\n"
                    + "";
            String subject = "Password Reset Confirmation";
            String message = "Click the link below to confirm your password reset:\n" + url;

            try {
                Email.sendMail(email, subject, message);
                request.setAttribute("message", "A confirmation email has been sent to " + email);
                request.getRequestDispatcher("forgot_password.jsp").forward(request, response);

            } catch (Exception e) {
                throw new ServletException("Failed to send email", e);
            }
            request.getRequestDispatcher("forgot_password.jsp").forward(request, response);

//            request.getRequestDispatcher("new_password.jsp").forward(request, response);
        } else {
            request.setAttribute("errorEmail", "Email does not exist");
            request.getRequestDispatcher("forgot_password.jsp").forward(request, response);
        }
    }
}
