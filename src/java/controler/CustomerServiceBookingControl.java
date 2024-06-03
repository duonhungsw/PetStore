package controler;

import com.sun.javafx.css.SizeUnits;
import daos.ServiceDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Account;
import model.BookedPetGroomerSchedule;
import model.CustomerServiceBookings;

@WebServlet(name = "CustomerServiceBookingControl", urlPatterns = {"/customerServiceBooking"})
public class CustomerServiceBookingControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int register_service_id = Integer.parseInt(request.getParameter("service_id"));
        int register_service_price = Integer.parseInt(request.getParameter("service_price"));
        String register_name = request.getParameter("register_name");
        String register_phone = request.getParameter("register_phone");
        int selected_groomer = Integer.parseInt(request.getParameter("groomerSelector"));
        String selected_dateStr = request.getParameter("dateSelector");
        int selected_time = Integer.parseInt(request.getParameter("timeSelector"));
        
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("LOGIN_USER");
        int accid = acc.getAccId();
        System.out.println(accid);

        try {
            //Save CustomerServiceBooking data
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date selected_date = dateFormat.parse(selected_dateStr);

            CustomerServiceBookings csb = new CustomerServiceBookings();
            csb.setService_id(register_service_id);
            csb.setService_price(register_service_price);
            csb.setCustomer_id(accid);
            csb.setGroomer_id(selected_groomer);
            csb.setCustomer_name(register_name);
            csb.setCustomer_phone(register_phone);
            csb.setBooking_date(selected_date);
            csb.setBooking_time(selected_time);

            ServiceDao csbDao = new ServiceDao();
            csbDao.insertToCSB(csb);

            //Save BookedPetGroomerScheduleDao data
            BookedPetGroomerSchedule bps = new BookedPetGroomerSchedule();
            bps.setGroomer_id(selected_groomer);
            bps.setBooking_date(selected_date);
            bps.setBooking_time(selected_time);

            ServiceDao bpsDao = new ServiceDao();
            bpsDao.insertToBookedPetGroomerSchedule(bps);

            //notification
            request.setAttribute("userId", accid);
            request.setAttribute("1", register_service_id);
            request.setAttribute("2", register_name);
            request.getRequestDispatcher("pet_service_booking_success.jsp").forward(request, response);
//            response.sendRedirect("pet_service_booking_success.jsp");
        } catch (Exception e) {
            response.sendRedirect("pet_service_booking_failure.jsp");
        }
    }

}
