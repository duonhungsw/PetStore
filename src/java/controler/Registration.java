package controler;

import daos.AccountDAO;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.Account;
import model.Coin;
import model.Role;
import util.Email;
import util.Tools;

@WebServlet(name = "Registration", urlPatterns = {"/signup"})
@MultipartConfig
public class Registration extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = request.getParameter("user-name");
        String emailRegister = request.getParameter("user-email");
        String password = request.getParameter("user-pass");
        String repeatPassword = request.getParameter("user-repeatpass");

        if (name == null || name.isEmpty()
                || emailRegister == null || emailRegister.isEmpty()
                || password == null || password.isEmpty()
                || repeatPassword == null || repeatPassword.isEmpty()) {
            request.setAttribute("error", "Not enough information");
            request.getRequestDispatcher("registration.jsp").forward(request, response);
            return;
        }

        AccountDAO accountDAO = new AccountDAO();
        if (accountDAO.getAccountByEmail(emailRegister)) {
            request.setAttribute("email", "The email was already registered!");
            request.getRequestDispatcher("registration.jsp").forward(request, response);
            return;
        }

        String token = Tools.generateNewToken();
        Cookie cookie = new Cookie("registerToken", token);
        cookie.setMaxAge(60);
        response.addCookie(cookie);

        session.setAttribute("username", name);
        session.setAttribute("email", emailRegister);
        session.setAttribute("password", password);

        String emailContent = String.format(
                "<html><body><h1>Hello, here is your verification code: %s</h1></body></html>",
                token
        );
        Email email = new Email();
        boolean sendSuccess = email.sendMail(emailRegister, "PetStore Verification Code", emailContent);

        response.sendRedirect("validTokenControl");
    }
}
