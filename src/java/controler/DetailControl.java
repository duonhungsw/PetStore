/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controler;

import daos.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Product;


/**
 *
 * @author Admin
 */
@WebServlet(name="Details", urlPatterns={"/detail"})
public class DetailControl extends HttpServlet {
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("pid"));
        ProductDAO dao = new ProductDAO();
        Product p = dao.getProductbyID(id); 
        System.out.println(p.toString());
        request.setAttribute("detail", p);
        request.getRequestDispatcher("detail.jsp").forward(request, response);
    } 
}
