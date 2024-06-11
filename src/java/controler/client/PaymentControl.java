package controler.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import daos.CartDAO;
import daos.OrderDAO;
import daos.ProvincesVNDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
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
import util.Config;

@WebServlet(name = "PaymentControl", urlPatterns = {"/payment"})
public class PaymentControl extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

            String vnp_Version = "2.1.0";
            String vnp_Command = "pay";
            String orderType = "other";

            long amount = Integer.parseInt(orderData.getTotal_money()) * 100;
            String bankCode = "VNBANK";

            String vnp_TxnRef = Config.getRandomNumber(8);
            String vnp_IpAddr = Config.getIpAddress(request);

            String vnp_TmnCode = Config.vnp_TmnCode;

            Map<String, String> vnp_Params = new HashMap<>();
            vnp_Params.put("vnp_Version", vnp_Version);
            vnp_Params.put("vnp_Command", vnp_Command);
            vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
            vnp_Params.put("vnp_Amount", String.valueOf(amount));
            vnp_Params.put("vnp_CurrCode", "VND");

            if (bankCode != null && !bankCode.isEmpty()) {
                vnp_Params.put("vnp_BankCode", bankCode);
            }

            vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
            vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);
            vnp_Params.put("vnp_OrderType", orderType);

            String locate = "vn";
            vnp_Params.put("vnp_Locale", locate);

            vnp_Params.put("vnp_ReturnUrl", Config.vnp_ReturnUrl);
            vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

            Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
            String vnp_CreateDate = formatter.format(cld.getTime());
            vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

            cld.add(Calendar.MINUTE, 15);
            String vnp_ExpireDate = formatter.format(cld.getTime());
            vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

            List<String> fieldNames = new ArrayList<>(vnp_Params.keySet());
            Collections.sort(fieldNames);
            StringBuilder hashData = new StringBuilder();
            StringBuilder query = new StringBuilder();
            Iterator<String> itr = fieldNames.iterator();
            while (itr.hasNext()) {
                String fieldName = itr.next();
                String fieldValue = vnp_Params.get(fieldName);
                if ((fieldValue != null) && (fieldValue.length() > 0)) {
                    //Build hash data
                    hashData.append(fieldName);
                    hashData.append("=");
                    hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                    //Build query
                    query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                    query.append("=");
                    query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                    if (itr.hasNext()) {
                        query.append('&');
                        hashData.append('&');
                    }
                }
            }
            String queryUrl = query.toString();
            String vnp_SecureHash = Config.hmacSHA512(Config.secretKey, hashData.toString());
            queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
            String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;

            JsonObject job = new JsonObject();
            job.addProperty("code", "00");
            job.addProperty("message", "success");
            job.addProperty("data", paymentUrl);
            
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
            System.out.println("-------------");
            int coinid = Integer.parseInt(orderData.getCoinId());
            System.out.println(coinid);
            dao.resetCoinAccountById(coinid);
            
            // Chuyển đổi OrderDTO sang Orders
            Orders order = new Orders();
            order.setCart_id(cart);
            order.setCoup_id(coupons);
            order.setPay_id(pay);
            order.setStatus_id(status);
            order.setProvinces(province.getName_en());
            order.setDistrict(districts.getName_en());
            order.setWard(ward.getName_en());
            order.setPhone(orderData.getPhone());
            order.setNote(orderData.getNote());
            //datetime
            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter formatterd = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedTime = currentTime.format(formatterd);

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
                System.out.println("done");
            }
            
            
            Gson gson = new Gson();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(gson.toJson(job));
            System.out.println("Payment URL: " + paymentUrl);
        } catch (Exception e) {
            e.printStackTrace();
            JsonObject job = new JsonObject();
            job.addProperty("code", "99");
            job.addProperty("message", "error");
            Gson gson = new Gson();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(gson.toJson(job));
        }
    }
}
