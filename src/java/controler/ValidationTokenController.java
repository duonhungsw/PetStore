package controler;

import daos.AccountDAO;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Coin;
import model.Role;

@WebServlet(name = "ValidationTokenController", urlPatterns = {"/validTokenControl"})
@MultipartConfig
public class ValidationTokenController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("enterToken.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userToken = request.getParameter("token");
        String cookieToken = null;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("registerToken")) {
                    cookieToken = cookie.getValue();
                    break;
                }
            }
        }

        if (cookieToken != null && cookieToken.equals(userToken)) {
            String email = (String) session.getAttribute("email");
            String username = (String) session.getAttribute("username");
            String password = (String) session.getAttribute("password");

            AccountDAO accountDAO = new AccountDAO();
            accountDAO.insertCoinOfAccount();
            int coinId = accountDAO.getLastCoinId();

            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedTime = currentTime.format(formatter);

            Account acc = new Account();
            Role role = new Role();
            Coin coin = new Coin();
            coin.setCoin_id(coinId);
            role.setRole_id(4);
            acc.setRole_id(role);
            acc.setCoin_id(coin);
            acc.setEmail(email);
            acc.setUsername(username);
            acc.setPass(password);
            acc.setName(null);
            acc.setPhone(null);
            acc.setAddress(null);
            acc.setImage("images/user-male.jpg");
            acc.setCreation_datetime(formattedTime);
            acc.setStatus(1);
            acc.setToken(null);

            accountDAO.insertAccount(acc);

            session.removeAttribute("email");
            session.removeAttribute("username");
            session.removeAttribute("password");
            response.sendRedirect("login");
        } else {
            request.setAttribute("error", "Invalid file type. Please upload an image.");
            request.getRequestDispatcher("enterToken.jsp").forward(request, response);
        }
    }
}
