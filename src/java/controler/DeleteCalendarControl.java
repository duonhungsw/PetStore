
package controler;


import daos.ServiceDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;


@WebServlet(name="DeleteCalendarControl", urlPatterns={"/deleteCalendar"})
public class DeleteCalendarControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int booking_id = Integer.parseInt(request.getParameter("bookingId"));
        
        //DELETE IN TABLE BookedPetGroomerSchedule
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("LOGIN_USER");
        int accid = acc.getAccId();
        
        ServiceDao fes = new ServiceDao();
        fes.deleteBookedSchedule(accid, booking_id);
        
        //DELETE IN TABLE CustomerServiceBookings
        ServiceDao csb = new ServiceDao();
        csb.deleteCSB(booking_id);
    } 

}
