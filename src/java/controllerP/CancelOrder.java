/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllerP;

import daos.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Phuc
 */
@WebServlet(name = "CancelOrder", urlPatterns = {"/cancelorder"})
public class CancelOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
            String idParam = request.getParameter("id");
            try {
               int id = Integer.parseInt(request.getParameter("idParam"));
            OrderDAO dao = new OrderDAO();
            dao.DeleteOrder(id);
            
        
        
        } catch (Exception e) {
        }
         response.sendRedirect("listpurchase");
    }

}
