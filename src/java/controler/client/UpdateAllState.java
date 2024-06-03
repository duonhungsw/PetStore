
package controler.client;

import daos.CartDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="UpdateAllState", urlPatterns={"/updateAllState"})
public class UpdateAllState extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int state = Integer.parseInt(request.getParameter("state"));
        
        CartDAO cartDAO = new CartDAO();
        cartDAO.updateAllAtateCI(state);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("{\"success\": true}");
    }
}
