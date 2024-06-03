
package controler;

import daos.ServiceDao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.Account;
import model.ViewBookedScheduleOfPetGroomer;

@WebServlet(name="PetServiceManageControl", urlPatterns={"/petServiceManageControl"})
public class PetServiceManageControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ServiceDao vbsOPGDAO = new ServiceDao();
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("LOGIN_USER");
        int accid = acc.getAccId();
        ArrayList<ViewBookedScheduleOfPetGroomer> vbsOPG = vbsOPGDAO.getBookedScheduleOPG(accid);
        request.setAttribute("vbsOPG", vbsOPG);
        request.getRequestDispatcher("pet_service_manage.jsp").forward(request, response);
    } 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int bookingId = Integer.parseInt(request.getParameter("bookingId"));
        int status = Integer.parseInt(request.getParameter("status"));
        ServiceDao vbsOPGDAO = new ServiceDao();
        vbsOPGDAO.updateStatus(status, bookingId);
    } 
}
