package controler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import daos.AccountDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Account;
import model.Coin;
import model.UserGoogle;
import model.Constans;
import model.Role;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import util.Tools;

@WebServlet(name = "LoginGoogleControl", urlPatterns = {"/loginGoogleControl"})
public class LoginGoogleControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String code = request.getParameter("code");
            String accessToken = getToken(code);
            UserGoogle user = getUserInfo(accessToken);
            String email = user.getEmail();
            String nameEmail = user.getName();

            System.out.println(user);

            AccountDAO accDAO = new AccountDAO();
            boolean check = accDAO.getAccountByEmail(email);
            System.out.println(check);
            HttpSession session = request.getSession();
            if (check) {
                Account account = accDAO.getAccountInfoByEmail(email);
                session.setAttribute("LOGIN_USER", account);
                System.out.println(account.toString());
                redirectUserBasedOnRole(account.getRole_id().getRole_id(), response);
            } else {
                LocalDateTime currentTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedTime = currentTime.format(formatter);

                accDAO.insertCoinOfAccount();
                int coinId = accDAO.getLastCoinId();
                Account acc = new Account();
                Role role = new Role();
                Coin coin = new Coin();
                coin.setCoin_id(coinId);
                role.setRole_id(4);
                acc.setRole_id(role);
                acc.setCoin_id(coin);
                acc.setEmail(email);
                acc.setUsername(user.getName());
                acc.setPass(email);
                acc.setName(null);
                acc.setPhone(null);
                acc.setAddress(null);
                acc.setImage("images/user-male.jpg");
                acc.setCreation_datetime(formattedTime);
                acc.setStatus(1);
                acc.setToken(null);

                accDAO.insertAccount(acc);
                Account account = accDAO.getAccountInfoByEmail(email);
                session.setAttribute("LOGIN_USER", account);
                response.sendRedirect("home");
                System.out.println("success");
            }
        } catch (Exception e) {
        }
    }
    
    private void redirectUserBasedOnRole(int roleId, HttpServletResponse response) throws IOException {
        switch (roleId) {
            case 1:
                response.sendRedirect("admin");
                break;
            case 2:
                response.sendRedirect("pageForRole2");
                break;
            case 3:
                response.sendRedirect("pageForRole3");
                break;
            case 4:
                response.sendRedirect("home");
                break;
            default:
                response.sendRedirect("defaultPage"); 
                break;
        }
    }

    public static String getToken(String code) throws ClientProtocolException, IOException {
        // call api to get token
        Constans Constants = new Constans();
        String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
                        .add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();

        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return accessToken;
    }

    public static UserGoogle getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        Constans Constants = new Constans();
        String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();

        UserGoogle googlePojo = new Gson().fromJson(response, UserGoogle.class);

        return googlePojo;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
