package controllerP;

import daos.ConfiOrdersDAO;
import daos.PurchaseDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Order_items;
import model.Orders;

@WebServlet(name = "ListPurchase", urlPatterns = {"/listpurchase"})
public class ListPurchase extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idd = request.getParameter("id");
        List<Order_items> list = new ArrayList<>();
       
        PurchaseDAO dao = new PurchaseDAO();

        if (idd == null || idd.equals("0")) {
            list = dao.getAllPurchases();
        } else {
            try {
                int id = Integer.parseInt(idd);
                list = dao.getPurchaseByStatusID(id);
                for (Order_items order_items : list) {
                    System.out.println(list.toArray());
                }
            } catch (Exception e) {
            }
        }

        request.setAttribute("listPur", list);
        request.getRequestDispatcher("Purchase.jsp").forward(request, response);
    }
}
