<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Template Catchy Pet</title>
        <link rel="stylesheet" href="css/checkout.css">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <style>
            .coupon-item {
                display: flex;
                justify-content: space-between; /* căn chỉnh các phần tử con theo chiều ngang, đẩy phần tử con thứ hai về phía bên phải */
                align-items: center; /* căn chỉnh các phần tử con theo chiều dọc */
            }

            .coupon-item .coupon {
                margin-left: auto; /* đẩy phần tử con này về phía bên phải */
            }

        </style>
    </head>
    <body>
        <div class="container">
            <div class="order-form">
                <h2>Template Catchy Pet</h2>
                <form>
                    <div class="input-group">
                        <label>Email</label>
                        <input type="email" placeholder="Email" value="${requestScope.user.email}">
                    </div>
                    <div class="input-group">
                        <label>Name</label>
                        <input type="text" placeholder="Họ và tên" value="${requestScope.user.username}">
                    </div>
                    <div class="input-group">
                        <label>Phone</label>
                        <input type="tel" placeholder="Số điện thoại" value="${requestScope.user.phone}">
                    </div>
                    <div class="input-group">
                        <label>Province</label>
                        <select id="province" class="form-control" name="province_code">
                            <c:forEach var="province" items="${requestScope.provinces}">
                                <option value="${province.code}">${province.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="input-group">
                        <label>District</label>
                        <select id="districts" class="form-control" name="district_code">
                            <option value="">Select</option>
                        </select>
                    </div>
                    <div class="input-group">
                        <label>Ward</label>
                        <select id="wards" class="form-control" name="ward_code">
                            <option value="">Select</option>
                        </select>
                    </div>
                    <div class="input-group">
                        <label>Note</label>
                        <textarea placeholder="Ghi chú"></textarea>
                    </div>
                </form>
            </div>

            <div class="payment">
                <h3>Thanh toán</h3>
                <div class="payment-option">
                    <input type="radio" id="cod" name="payment"><br>
                    <label for="cod">Thanh toán khi giao hàng (COD)</label><br>
                    <input type="radio" id="cod" name="payment">
                    <label for="cod">VNPay</label>
                </div>
            </div>
            <div class="order-summary">
                <%
                    List listO = (List) request.getAttribute("listO");
                    int count = (listO != null) ? listO.size() : 0;
                %>

                <h3>Đơn hàng (<%= count%> sản phẩm)</h3>
                <c:forEach var="list" items="${requestScope.listO}">
                    <div class="product">
                        <img src="${list.prod_id.imageProduct}" alt="Bát inox chống trượt cho chó mèo">
                        <p>${list.prod_id.nameP} x ${list.quantity}</p>
                        <span>${list.total_money}đ</span>
                    </div>
                </c:forEach>
                <div class="discount">
                    <input type="text" id="keyword" placeholder="Enter keyword">
                    <button onclick="findCoupon()">Find Coupon</button>
                </div>
                <div class="totals">
                    <p>Tạm tính: <span>${requestScope.totalM}đ</span></p>
                    <p>Shipping fee: <span class="shipping">-</span></p>
                    <label for="cod">Coin</label><input type="checkbox" id="cod" name="payment">${requestScope.coin}đ
                    <div class="results"></div>
                    <p>Tổng cộng: <span>${requestScope.totalM}đ</span></p>
                </div>
                <button class="order-button">ĐẶT HÀNG</button>
                <a href="cart" class="back-to-cart">Quay về giỏ hàng</a>
            </div>
        </div>
        <script src="js/order.js"></script>
        <script>
            function findCoupon() {
                const keyword = document.getElementById("keyword").value;
                fetch("/PetStore/coupon-rest-control?keyWord=" + keyword)
                        .then(response => response.json())
                        .then(data => {
                            const resultsDiv = document.querySelector(".results");
                            resultsDiv.innerHTML = "";

                            data.forEach(coupon => {
                                const couponElement = document.createElement("div");
                                couponElement.className = "coupon-item";
                                couponElement.textContent = "Coupon: " + "               " + coupon.discount + "đ";

                                couponElement.addEventListener("click", function () {
                                    document.querySelector(".coupon").textContent = coupon.discount + "%";
                                });

                                resultsDiv.appendChild(couponElement);
                            });
                        })
                        .catch(error => console.error('Error:', error));
            }
        </script>
    </body>
</html>
