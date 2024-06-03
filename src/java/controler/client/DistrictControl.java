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
import model.Districts;

@WebServlet(name="DistrictControl", urlPatterns={"/districts"})
public class DistrictControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String province_code = request.getParameter("province_code");
        ProvincesVNDAO dao = new ProvincesVNDAO();
        List<Districts> list = dao.getDistrictsByProvincesId(province_code);

        StringBuilder options = new StringBuilder();
        for (Districts district : list) {
            options.append("<option class=\"ok\" value=\"").append(district.getCode()).append("\">")
       .append(district.getName()).append("</option>");

        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(options.toString());
    } 
}
