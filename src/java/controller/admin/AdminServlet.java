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
import java.math.BigDecimal;
import java.util.List;
import model.Account;
import model.TimeSale;
import util.GoldenHour;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void init()
            throws ServletException {
        AdminDao ad = new AdminDao();
        TimeSale ts = ad.getTimeSale();
        if (ts.getStatus() == 1) {
            GoldenHour.setGoldenHour(ts.getStartHour(), ts.getStartMinute(), ts.getEndHour(), ts.getEndMinute());
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminServlet at " + request.getContextPath() + "</h1>");
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
        String chart_raw = request.getParameter("chart");
        AdminDao sd = new AdminDao();

        int chart = chart_raw == null ? 0 : Integer.parseInt(chart_raw);
        if (chart == 0) {
            BigDecimal year18 = sd.getTotalMoneyOrderByYear(2018);
            BigDecimal year19 = sd.getTotalMoneyOrderByYear(2019);
            BigDecimal year20 = sd.getTotalMoneyOrderByYear(2020);
            BigDecimal year21 = sd.getTotalMoneyOrderByYear(2021);
            BigDecimal year22 = sd.getTotalMoneyOrderByYear(2022);
            BigDecimal year23 = sd.getTotalMoneyOrderByYear(2023);
            BigDecimal year24 = sd.getTotalMoneyOrderByYear(2024);

            request.setAttribute("year18", year18);
            request.setAttribute("year19", year19);
            request.setAttribute("year20", year20);
            request.setAttribute("year21", year21);
            request.setAttribute("year22", year22);
            request.setAttribute("year23", year23);
            request.setAttribute("year24", year24);
            request.setAttribute("chart", chart);
        } else {
            BigDecimal month1 = sd.getTotalMoneyOrderByMonth(1);
            BigDecimal month2 = sd.getTotalMoneyOrderByMonth(2);
            BigDecimal month3 = sd.getTotalMoneyOrderByMonth(3);
            BigDecimal month4 = sd.getTotalMoneyOrderByMonth(4);
            BigDecimal month5 = sd.getTotalMoneyOrderByMonth(5);
            BigDecimal month6 = sd.getTotalMoneyOrderByMonth(6);
            BigDecimal month7 = sd.getTotalMoneyOrderByMonth(7);
            BigDecimal month8 = sd.getTotalMoneyOrderByMonth(8);
            BigDecimal month9 = sd.getTotalMoneyOrderByMonth(9);
            BigDecimal month10 = sd.getTotalMoneyOrderByMonth(10);
            BigDecimal month11 = sd.getTotalMoneyOrderByMonth(11);
            BigDecimal month12 = sd.getTotalMoneyOrderByMonth(12);

            request.setAttribute("month1", month1);
            request.setAttribute("month2", month2);
            request.setAttribute("month3", month3);
            request.setAttribute("month4", month4);
            request.setAttribute("month5", month5);
            request.setAttribute("month6", month6);
            request.setAttribute("month7", month7);
            request.setAttribute("month8", month8);
            request.setAttribute("month9", month9);
            request.setAttribute("month10", month10);
            request.setAttribute("month11", month11);
            request.setAttribute("month12", month12);
            request.setAttribute("chart", chart);
        }
        List<Account> accounts = sd.getAllAccountByRole(4);
        List<Account> newAccounts = sd.getNewAccountByRole(4);
        BigDecimal today = sd.getTotalMoneyOrderToday();
        BigDecimal total = sd.getTotalMoneyOrder();
        request.setAttribute("user", accounts.size());
        request.setAttribute("newuser", newAccounts.size());
        request.setAttribute("today", today);
        request.setAttribute("total", total);
        request.getRequestDispatcher("admin.jsp").forward(request, response);

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
        request.getRequestDispatcher("admin.jsp").forward(request, response);
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
