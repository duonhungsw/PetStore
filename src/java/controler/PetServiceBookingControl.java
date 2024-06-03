
package controler;
import daos.ServiceDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.PetGroomerInfo;

@WebServlet(name="PetServiceBookingControl", urlPatterns={"/petServiceBookingControl"})
public class PetServiceBookingControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));
        int servicePrice = Integer.parseInt(request.getParameter("servicePrice"));
        String serviceName = request.getParameter("serviceName");
        
        ServiceDao pgiDao = new ServiceDao();
        ArrayList<PetGroomerInfo> pgInfo = pgiDao.getPetGroomerInfo();
        
        request.setAttribute("pgInfo", pgInfo);
        request.setAttribute("serviceId", serviceId);
        request.setAttribute("servicePrice", servicePrice);
        request.setAttribute("serviceName", serviceName);
        request.getRequestDispatcher("pet_service_booking.jsp").forward(request, response);
    } 
}
