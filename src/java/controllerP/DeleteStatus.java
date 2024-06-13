/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controllerP;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import daos.ConfiOrdersDAO;

/**
 *
 * @author Phuc
 */
@WebServlet(name="DeleteStatus", urlPatterns={"/delete"})
public class DeleteStatus extends HttpServlet {
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
       int id = Integer.parseInt(request.getParameter("id"));
       ConfiOrdersDAO  dao = new ConfiOrdersDAO();
       dao.deleteStatus(id);
       response.sendRedirect("loadorders");
       
    } 


}
