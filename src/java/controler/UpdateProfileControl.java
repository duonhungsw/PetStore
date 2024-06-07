package controler;

import daos.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.nio.file.Files;
import java.nio.file.Paths;
import model.Account;

@WebServlet(name = "UpdateProfileControl", urlPatterns = {"/updateProfileControl"})
@MultipartConfig

public class UpdateProfileControl extends HttpServlet {

    private static final String[] ALLOWED_EXTENSIONS = {".jpg", ".jpeg", ".png", ".gif", ".webp"};
    private static final String UPLOAD_DIRECTORY = "/SavedImages";

    private boolean isImageFile(String filename) {
        for (String extension : ALLOWED_EXTENSIONS) {
            if (filename.toLowerCase().endsWith(extension)) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account user = (Account) session.getAttribute("LOGIN_USER");
        int account_id = user.getAccId();
        String pass = request.getParameter("pass");
        String name = request.getParameter("name"); 
        String phone = request.getParameter("phone");
        Part imagePart = request.getPart("avatar");
        
        String realPath = request.getServletContext().getRealPath(UPLOAD_DIRECTORY);
        String filename = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
        String imagePath = realPath + "/" + filename;

        try {
            if (!Files.exists(Paths.get(realPath))) {
                Files.createDirectory(Paths.get(realPath));
            }
            if (isImageFile(filename)) {
                imagePart.write(imagePath);
                AccountDAO accountDAO = new AccountDAO();
                System.out.println("accountid"+account_id);
                Account account = new Account();
                account.setPass(pass);
                account.setName(name);
                account.setPhone(phone);
                account.setImage( "SavedImages/"+ filename);
                account.setAccId(account_id);
                accountDAO.updateProfile(account, account_id);
                
                response.sendRedirect("profile");
                System.out.println("4");
            }
        } catch (Exception e) {
            response.sendRedirect("home");
        }

    }
}
