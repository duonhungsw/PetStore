/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controler.client;

import daos.ProvincesVNDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Wards;

@WebServlet(name="WardsControl", urlPatterns={"/wards"})
public class WardsControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String district_code  = request.getParameter("district_code");
        ProvincesVNDAO dao = new ProvincesVNDAO();
        List<Wards> list = dao.getWardsBydistrictId(district_code);

        StringBuilder options = new StringBuilder();
        for (Wards wards : list) {
            options.append("<option value=\"").append(wards.getCode()).append("\">")
                    .append(wards.getName()).append("</option>");
        }
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(options.toString());

    } 
}
