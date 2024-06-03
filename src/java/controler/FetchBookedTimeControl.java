
package controler;

import daos.ServiceDao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@WebServlet(name="FetchBookedTimeControl", urlPatterns={"/fetchBookedTimeControl"})
public class FetchBookedTimeControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int groomerId = Integer.parseInt(request.getParameter("groomerId"));
        String dateSelector = request.getParameter("dateSelector");

        try {
            ServiceDao dao = new ServiceDao();
            ArrayList<Integer> schedules = dao.getBookedTime(groomerId, dateSelector);
            //return ajax
            response.getWriter().print(schedules);
        } catch (IOException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    } 
}
