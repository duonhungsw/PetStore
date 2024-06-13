    package controllerN;

import daos.CategoryDAO;
//import daos.PaginationDAO;
import daos.ProductDAO;
import daos.SearchDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Category;
import model.Product;

@WebServlet(name = "SearchControl", urlPatterns = {"/search"})
public class SearchControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String txtSearch = request.getParameter("txt");
//        String indexString  = request.getParameter("index");
//        int index = Integer.parseInt(indexString);
        System.out.println(txtSearch);
        SearchDAO dao = new SearchDAO();
        CategoryDAO daos = new CategoryDAO();
//        PaginationDAO paginationDAO = new PaginationDAO();        
//int count = paginationDAO.count(txtSearch);        
//int pagesize = 8;
//       int endPage = 0;
//        endPage = count / pagesize;
//        if (count / pagesize != 0) {
//           endPage++;
//       }
        List<Product> list = dao.searchProductByName(txtSearch);
        List<Category> listC = daos.getAllCategory();
        request.setAttribute("listP", list);
         request.setAttribute("txtS", txtSearch);
//        request.setAttribute("end", endPage);
//        request.setAttribute("save", txtSearch);
request.setAttribute("listC", listC);
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String txtSearch = request.getParameter("txt");
        System.out.println(txtSearch);
        SearchDAO dao = new SearchDAO();
        List<Product> list = dao.searchProductByName(txtSearch);
        request.setAttribute("listP", list);
        request.setAttribute("txtS", txtSearch);
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }
    

}
