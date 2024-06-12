/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dao.AdminDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import model.Category;
import model.Product;
import model.ProductDetail;

/**
 *
 * @author ADMIN
 */
@MultipartConfig
@WebServlet(name = "AdminAddProductServlet", urlPatterns = {"/addproduct"})
public class AdminAddProductServlet extends HttpServlet {

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
            out.println("<title>Servlet AdminAddProductServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminAddProductServlet at " + request.getContextPath() + "</h1>");
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
        AdminDao ad = new AdminDao();
        List<Category> categories = ad.getAllCategory();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("ad_addproduct.jsp").forward(request, response);
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
        String name = request.getParameter("name");
        Part imagePart = request.getPart("image");
        String price = request.getParameter("price");
        String amount_raw = request.getParameter("amount");
        String categortId_draw = request.getParameter("cateId");

        String realPath = request.getServletContext().getRealPath("/SavedImages");
        String filename = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
        String image = realPath + "/" + filename;
        AdminDao ad = new AdminDao();

        if (!Files.exists(Paths.get(realPath))) {
            Files.createDirectory(Paths.get(realPath));
        }
        if (isImageFile(image)) {
            imagePart.write(image);
            int amount = Integer.parseInt(amount_raw);
            int cid = Integer.parseInt(categortId_draw);
            Category category = new Category();
            category.setCategory_id(cid);

            Product product = new Product();
            product.setCateId(category);
            product.setNameP(name);
            product.setImageProduct("SavedImages/" + filename);
            ad.insertProduct(product);

            ProductDetail pd = new ProductDetail();
            pd.setPrice(Double.parseDouble(price));
            pd.setAmount(amount);
            ad.insertProductDetail(pd, product);

            response.sendRedirect("ad_addproduct.jsp");
        } else {
            // Handle invalid file type
            response.setContentType("text/plain");
            response.getWriter().write("Invalid file type. Please upload an image.");
        }

    }

    private boolean isImageFile(String filename) {
        // Validate if the file is an image (you can enhance this validation)
        String[] allowedExtensions = {".jpg", ".jpeg", ".png", ".gif", ".webp"};
        for (String extension : allowedExtensions) {
            if (filename.toLowerCase().endsWith(extension)) {
                return true;
            }
        }
        return false;
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
