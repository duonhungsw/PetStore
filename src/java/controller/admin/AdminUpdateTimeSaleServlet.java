/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dao.AdminDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TimeSale;
import util.GoldenHour;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "UpdateTimeSaleServlet", urlPatterns = {"/updatetimesale"})
public class AdminUpdateTimeSaleServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateTimeSaleServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateTimeSaleServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String status_raw = request.getParameter("status");
        String type = request.getParameter("type");
        AdminDao ad = new AdminDao();
        TimeSale ts = ad.getTimeSale();
        if (type == null) {
            int status = Integer.parseInt(status_raw);
            if (status == 1) {
                request.setAttribute("error", "Please deactive before update");
                request.getRequestDispatcher("timesale").forward(request, response);
            } else {
                request.setAttribute("ts", ts);

                request.getRequestDispatcher("ad_updatetimesale.jsp").forward(request, response);
            }
        } else {
            int status = Integer.parseInt(status_raw) == 1 ? 0 : 1;
            if (status == 1) {
                GoldenHour.setGoldenHour(ts.getStartHour(), ts.getStartMinute(), ts.getEndHour(), ts.getEndMinute());
            } else {
                GoldenHour.unsetGoldenHour();
            }
            ad.updateStatusTimeSale(status);
            request.getRequestDispatcher("timesale").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String startHour_raw = request.getParameter("startHour");
        String startMinute_raw = request.getParameter("startMinute");
        String endHour_raw = request.getParameter("endHour");
        String endMinute_raw = request.getParameter("endMinute");
        String discount_raw = request.getParameter("discount");

        AdminDao ad = new AdminDao();
        int startHour = Integer.parseInt(startHour_raw);
        int startMinute = Integer.parseInt(startMinute_raw);
        int endHour = Integer.parseInt(endHour_raw);
        int endMinute = Integer.parseInt(endMinute_raw);
        int discount = Integer.parseInt(discount_raw);
        TimeSale ts = new TimeSale();
        ts.setStartHour(startHour);
        ts.setStartMinute(startMinute);
        ts.setEndHour(endHour);
        ts.setEndMinute(endMinute);
        ts.setDiscount(discount);
        ad.updateTimeSale(ts);

        request.getRequestDispatcher("timesale").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
