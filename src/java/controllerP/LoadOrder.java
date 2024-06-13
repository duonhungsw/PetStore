
package controllerP;

import daos.ConfiOrdersDAO;
import daos.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Orders;

@WebServlet(name="LoadOrder", urlPatterns={"/loadorders"})
public class LoadOrder extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ConfiOrdersDAO dao = new ConfiOrdersDAO();
        List<Orders> list = dao.getAllOrders();
        /*        for (Orders orders : list) {
            System.out.println(orders.toString());
        }
        System.out.println("ok");
        */
        request.setAttribute("listO", list);
        request.getRequestDispatcher("LoadOrders.jsp").forward(request, response);
    } 
}
