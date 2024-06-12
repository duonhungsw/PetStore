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
import model.Account;
import util.Email;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "AdminAddStaffServlet", urlPatterns = {"/addstaff"})
public class AdminAddStaffServlet extends HttpServlet {

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
            out.println("<title>Servlet AdminAddStaffServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminAddStaffServlet at " + request.getContextPath() + "</h1>");
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

        request.getRequestDispatcher("ad_addstaff.jsp").forward(request, response);
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
        String recipient = request.getParameter("recipient");
        String username = recipient.substring(0, recipient.lastIndexOf("@")) + "staff";
        String password = "123";
        String htmlContent = "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<style>"
                + "body {font-family: Arial, sans-serif; line-height: 1.6;}"
                + ".container {max-width: 600px; margin: auto; padding: 20px; border: 1px solid #dcdcdc; border-radius: 10px;}"
                + ".header {background-color: #f4f4f4; padding: 10px; text-align: center; border-bottom: 1px solid #dcdcdc;}"
                + ".content {padding: 20px;}"
                + ".content p {margin: 0 0 10px;}"
                + ".footer {padding: 10px; text-align: center; color: #999999; font-size: 12px; border-top: 1px solid #dcdcdc;}"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<div class='container'>"
                + "<div class='header'>"
                + "<h2>Account Information</h2>"
                + "</div>"
                + "<div class='content'>"
                + "<p><strong>Username:</strong> " + username + "</p>"
                + "<p><strong>Password:</strong> " + password +"</p>"
                + "<p>Please log in, then change your password and update your profile.</p>"
                + "<p>Thank you for your cooperation!</p>"
                + "</div>"
                + "<div class='footer'>"
                + "<p>&copy; 2024 Your Company. All rights reserved.</p>"
                + "</div>"
                + "</div>"
                + "</body>"
                + "</html>";
        String subject = "Pet store - Welcomes new staff";
        AdminDao ad = new AdminDao();
        Account a = ad.getAccountByEmail(recipient);
        if (a == null) {
            ad.insertAccount(2, recipient, username, password);
            boolean sendSuccess = Email.sendMail(recipient, subject, htmlContent);
            if (sendSuccess) {
                request.setAttribute("success", "Send successfully !");
            } else {
                request.setAttribute("error", "Send not successfully !");
            }
            request.getRequestDispatcher("ad_addstaff.jsp").forward(request, response);
        } else {
            request.setAttribute("exist", "Email is exist, please change email to create staff !");
            request.getRequestDispatcher("ad_addstaff.jsp").forward(request, response);
        }

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
