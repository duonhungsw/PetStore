package controler.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import daos.CartDAO;
import daos.OrderDAO;
import daos.ProvincesVNDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import model.Account;
import model.Cart;
import model.Cart_Item;
import model.Coupon;
import model.Districts;
import model.Order_items;
import model.Orders;
import model.Pays;
import model.Provinces;
import model.Status;
import model.Wards;
import model.dtos.OrderDTO;
import util.Email;

@WebServlet(name = "DeliveryOrderController", urlPatterns = {"/deliveryOrderControl"})
public class DeliveryOrderController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Đọc dữ liệu JSON thô từ request
        StringBuilder jsonBuffer = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonBuffer.append(line);
        }
        String rawJson = jsonBuffer.toString();

        // In ra JSON thô để kiểm tra
        System.out.println("Received raw JSON data: " + rawJson);

        // Chuyển đổi JSON thô sang đối tượng OrderDTO
        ObjectMapper mapper = new ObjectMapper();
        try {
            OrderDTO orderData = mapper.readValue(rawJson, OrderDTO.class);

            System.out.println("Received order data: " + orderData);

            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("LOGIN_USER");

            if (acc == null) {
                response.sendRedirect("login.jsp");
                return;
            }
            //cart
            CartDAO cartDAO = new CartDAO();
            Cart cart = cartDAO.getCartByUserId(acc.getAccId());

            List<Cart_Item> list = cartDAO.getOrderCart_Items(cart.getCart_id());
            //order
            OrderDAO dao = new OrderDAO();
            Coupon coupons = dao.findCoupon(orderData.getCouponId());
            //pay
            int paymentId = Integer.parseInt(orderData.getPayment());
            Pays pay = dao.getPayById(paymentId);
            //status
            Status status = new Status();
            status.setStatus_id(4);
            //address
            ProvincesVNDAO provincesVNDAO = new ProvincesVNDAO();

            Provinces province = provincesVNDAO.getProvincesById(orderData.getProvince());
            Districts districts = provincesVNDAO.getDistrict(orderData.getDistrict());
            Wards ward = provincesVNDAO.getWard(orderData.getWard());

            // Chuyển đổi OrderDTO sang Orders
            Orders order = new Orders();
            order.setCart_id(cart);
            order.setCoup_id(coupons);
            order.setPay_id(pay);
            order.setStatus_id(status);
            order.setProvinces(province.getFull_name());
            order.setDistrict(districts.getFull_name());
            order.setWard(ward.getFull_name());
            order.setPhone(orderData.getPhone());
            order.setNote(orderData.getNote());
            //datetime
            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedTime = currentTime.format(formatter);

            order.setDate(formattedTime);

            int money = Integer.parseInt(orderData.getTotal_money());
            order.setTotal_money(money);

            dao.insertOrder(order);

            int MaxId = dao.getLastOrderId();
            order.setOrder_id(MaxId);

            for (Cart_Item cart_Item : list) {
                Order_items order_items = new Order_items();
                order_items.setOrder_id(order);
                order_items.setProduct_id(cart_Item.getProd_id());
                order_items.setPrice(cart_Item.getProd_id().getProductDetail().getPrice());
                order_items.setTotal_money(cart_Item.getTotal_money());
                order_items.setQuantity(cart_Item.getQuantity());

                dao.insertOrderItems(order_items);

                Orders billOrder = dao.getBillOrders();
                List<Order_items> listBillDetailses = dao.getBillDetail();

//                    LocalDateTime currentTime = LocalDateTime.now();
                String tieude = "Cam on quy khach";
                // Gửi email với nội dung tệp JSP và thời gian hiện tại
                String noidung = "<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "<head>\n"
                        + "    <title>Email</title>\n"
                        + "    <style>\n"
                        + "        body {\n"
                        + "            background-color: #f5f5f5; \n"
                        + "            font-family: Arial, sans-serif;\n"
                        + "        }\n"
                        + "        .container {\n"
                        + "            width: 80%; \n"
                        + "            margin: 0 auto;\n"
                        + "            padding: 20px;\n"
                        + "            background-color: #fff;\n"
                        + "            border: 1px solid #ddd; \n"
                        + "            border-radius: 5px; \n"
                        + "            box-shadow: 0 0 10px rgba(0,0,0,0.1); \n"
                        + "        }\n"
                        + "        h1, h2, h3, h4, h5 {\n"
                        + "            color: #333;\n"
                        + "        }\n"
                        + "        .important {\n"
                        + "            color: #ff0000; \n"
                        + "        }\n"
                        + "        .no-reply {\n"
                        + "            background-color: var(--green); \n"
                        + "            color: #fff; \n"
                        + "            padding: 10px;\n"
                        + "            border-radius: 5px;\n"
                        + "            margin-bottom: 20px;\n"
                        + "        }\n"
                        + "    </style>\n"
                        + "</head>\n"
                        + "<body>\n"
                        + "    <div class=\"container\">\n"
                        + "        <div class=\"no-reply\">\n"
                        + "            <h1>Đây là email tự động, Quý khách vui lòng không trả lời email này</h1>\n"
                        + "        </div>\n"
                        + "        <h1>HeroShop</h1>\n"
                        + "        <h1>Chào bạn :" + billOrder.getUser().getFullname() + "</h1>\n"
                        + "        <h1>Bạn hoặc ai đó đã đăng ký dịch vụ của shop với thông tin sau:</h1>\n"
                        + "        <h2 class=\"important\">Thông tin đơn hàng</h2>\n"
                        + "        <h2>Mã đơn hàng: " + billOrder.getId() + "</h2>\n"
                        + "        <h3>Mã khuyến mãi áp dụng: Không có</h3>\n"
                        + "        <h3>Phí vận chuyển: 0 đồng</h3>\n"
                        + "        <h3>Dịch vụ: Đặt hàng trực tuyến</h3>\n"
                        + "        <h1>Thông tin người nhận</h1>\n"
                        + "        <h2>Địa chỉ nhận hàng: " + billOrder.getAddress() + "</h2>\n"
                        + "        <h2>Số điện thoại: " + billOrder.getPhone_number() + "</h2>\n"
                        + "        <h3>Ghi chú đơn hàng: " + billOrder.getNote() + "</h3>\n"
                        + "        <h3>Hình thức thanh toán: Khi nhận hàng</h3>\n"
                        + "        <h4>Sản phẩm đã đặt</h4>\n"
                        + "        <table>\n"
                        + "            <tr>\n"
                        + "                <th>San pham</th>\n"
                        + "                <th>Gía tien</th>\n"
                        + "                <th>So luong dat</th>\n"
                        + "                <th>Thanh tien</th>\n"
                        + "            </tr>\n";
                if (listBillDetailses == null) {
                    noidung += "<h1>Khong ton tai</1>/n";
                } else {
                    for (OrderDetails listBillDetailse : listBillDetailses) {
                        noidung
                                += "                <tr>\n"
                                + "                    <td>" + listBillDetailse.getProduct_id().getTitle() + "</td>\n"
                                + "                    <td>" + listBillDetailse.getPrice() + "$</td>\n"
                                + "                    <td>" + listBillDetailse.getQuantity() + "</td>\n"
                                + "                    <td>" + listBillDetailse.getTotal_money() + "</td>\n"
                                + "                </tr>\n";
                    }

                    noidung += "        </table>\n"
                            + "        <h5>Tổng tiền thanh toán: \n" + billOrder.getTotal_money() + "$</h5>"
                            + "    </div>"
                            + "</body>"
                            + "</html>";
                }
                String nguoinhan = acc.getEmail();
                Email email = new Email();
                boolean sendSuccess = email.sendMail(nguoinhan, tieude, noidung);
                System.out.println("done");
            }

        } catch (Exception e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
            e.printStackTrace();
            // Xử lý lỗi và trả về thông báo lỗi cho client
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"status\":\"error\",\"message\":\"Error occurred while placing the order.\"}");
        }
    }
}
