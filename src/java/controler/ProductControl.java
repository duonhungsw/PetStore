/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controler;

import daos.CategoryDAO;
import daos.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Category;
import model.Product;

/**
 *
 * @author thngu
 */
@WebServlet(name="ProductController", urlPatterns={"/product"})
public class ProductControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      
       HttpSession session = request.getSession();
        ProductDAO dao = new ProductDAO();
     
        List<Product> listP = dao.getAllProducts();  
        request.setAttribute("listP", listP);
        // gui tu user session cateList: de ma sau khi login hien het cate
        List<Category> listC = dao.getAllCategory();
        session.setAttribute("listCC", listC);
        
        request.getRequestDispatcher("product.jsp").forward(request, response);
    } 

}
