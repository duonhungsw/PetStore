package controler.client;

import daos.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Coupon;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet(name="CouponRestControl", urlPatterns={"/coupon-rest-control"})
public class CouponRestControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String keyword = request.getParameter("keyWord");
        OrderDAO dao = new OrderDAO();
        List<Coupon> coupons  = dao.findCouponsByKeyword(keyword);
        request.setAttribute("coupon", coupons);
        ObjectMapper  mapper  = new ObjectMapper ();
        String json = mapper.writeValueAsString(coupons);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    } 

}
