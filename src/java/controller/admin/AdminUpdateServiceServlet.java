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
import model.Service;

/**
 *
 * @author ADMIN
 */
@MultipartConfig
@WebServlet(name = "AdminUpdateServiceServlet", urlPatterns = {"/updateservice"})
public class AdminUpdateServiceServlet extends HttpServlet {

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
            out.println("<title>Servlet AdminUpdateServiceServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminUpdateServiceServlet at " + request.getContextPath() + "</h1>");
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
        String id_raw = request.getParameter("id");
        String status_raw = request.getParameter("status");
        int id = Integer.parseInt(id_raw);
        AdminDao ad = new AdminDao();
        
        if (status_raw == null) {
            Service service = ad.getServiceById(id);
            request.setAttribute("service", service);
            request.getRequestDispatcher("ad_updateservice.jsp").forward(request, response);
        } else {
            int status = Integer.parseInt(status_raw) == 1 ? 0 : 1;

            ad.updateStatusService(id, status);
            request.getRequestDispatcher("adservice").forward(request, response);
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
        String id_raw = request.getParameter("id");
        String name = request.getParameter("name");
        String oldimg = request.getParameter("oldimg");
        String price_raw = request.getParameter("price");
        Part imagePart = request.getPart("image");
        AdminDao ad = new AdminDao();
        if (imagePart != null) {

            String realPath = request.getServletContext().getRealPath("/SavedImages");
            String filename = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
            String image = realPath + "/" + filename;

            if (!Files.exists(Paths.get(realPath))) {
                Files.createDirectory(Paths.get(realPath));
            }
            if (isImageFile(image)) {
                imagePart.write(image);
                int id = Integer.parseInt(id_raw);
                int price = Integer.parseInt(price_raw);
                String imageProduct = "SavedImages/" + filename;

                ad.updateService(id, name, imageProduct, price);

                response.sendRedirect("adservice");
            } else {
                // Handle invalid file type
                response.setContentType("text/plain");
                response.getWriter().write("Invalid file type. Please upload an image.");
            }
        } else {
            int id = Integer.parseInt(id_raw);
            int price = Integer.parseInt(price_raw);

            ad.updateService(id, name, oldimg, price);

            response.sendRedirect("adservice");
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
