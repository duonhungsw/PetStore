/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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
import java.util.ArrayList;
import model.Account;
import model.ViewBookedService;

@WebServlet(name = "PetServiceCalendarControl", urlPatterns = {"/petServiceCalendar"})
public class PetServiceCalendarControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("LOGIN_USER");
        int accid = acc.getAccId();

        ServiceDao vbsDAO = new ServiceDao();
        ArrayList<ViewBookedService> vbs = vbsDAO.getBookedService(accid);
        request.setAttribute("vbs", vbs);
        request.getRequestDispatcher("pet_service_calendar.jsp").forward(request, response);
//        response.sendRedirect("petServiceCalendar");
    }

}
