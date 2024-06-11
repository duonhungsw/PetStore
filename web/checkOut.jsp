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
        <script src="js/jquery-1.11.3.min.js"></script>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f7f7f7;
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }

            .container {
                display: flex;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                border-radius: 8px;
                overflow: hidden;
                margin-top: 300px;
            }

            .order-form, .order-summary {
                padding: 20px;
            }

            .order-form {
                flex: 1;
                border-right: 1px solid #eee;
            }

            .order-summary {
                width: 900px;
            }

            h2, h3 {
                margin-top: 0;
            }

            .input-group {
                margin-bottom: 15px;
            }

            .input-group label {
                display: block;
                margin-bottom: 5px;
            }

            .input-group input, .input-group select, .input-group textarea {
                width: 100%;
                padding: 8px;
                border: 1px solid #ddd;
                border-radius: 4px;
            }

            .input-group textarea {
                resize: vertical;
            }

            .shipping, .payment {
                margin-top: 20px;
            }

            .payment-option {
                display: flex;
                align-items: center;
            }

            .payment-option input {
                margin-right: 10px;
            }

            .order-summary .product {
                display: flex;
                align-items: center;
                justify-content: space-between;
                margin-bottom: 10px;
            }

            .order-summary .product img {
                width: 50px;
                height: 50px;
                margin-right: 10px;
            }

            .discount {
                display: flex;
                margin-bottom: 20px;
            }

            .discount input {
                flex: 1;
                padding: 8px;
                border: 1px solid #ddd;
                border-radius: 4px;
                margin-right: 10px;
            }

            .discount button {
                padding: 8px 12px;
                border: none;
                background-color: #007bff;
                color: #fff;
                border-radius: 4px;
                cursor: pointer;
            }

            .discount button:hover {
                background-color: #0056b3;
            }

            .totals p {
                display: flex;
                justify-content: space-between;
                margin: 10px 0;
            }

            .order-button {
                width: 100%;
                padding: 10px;
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 16px;
            }

            .order-button:hover {
                background-color: #0056b3;
            }

            .back-to-cart {
                display: block;
                text-align: center;
                margin-top: 10px;
                color: #007bff;
                text-decoration: none;
            }

            .back-to-cart:hover {
                text-decoration: underline;
            }

            .coupon-item {
                display: flex;
                justify-content: space-between;
                align-items: center;
            }
            .coupon-item .coupon {
                margin-left: auto;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <form action="deliveryOrderControl" id="frmCreateOrder" method="post">

                <div class="order-form">
                    <h2>CheckOut PetStore</h2>
                    <div class="input-group">
                        <label>Email</label>
                        <input type="email" readOnly id="email" name="email" placeholder="Email" value="${requestScope.user.email}">
                    </div>
                    <div class="input-group">
                        <label>Name</label>
                        <input type="text" readOnly id="name" name="name" placeholder="Họ và tên" value="${requestScope.user.username}">
                    </div>
                    <div class="input-group">
                        <label>Phone</label>
                        <input type="text"  id="phone" name="phone" placeholder="Số điện thoại" value="${requestScope.user.phone}">
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
                        <textarea name="note" id="note" placeholder="Ghi chú"></textarea>
                    </div>
                </div>

                <div class="payment">
                    <h3>Thanh toán</h3>
                    <div class="payment-option">
                        <c:forEach var="listP" items="${requestScope.listP}">
                            <input type="radio" id="payment_cod" name="payment" value="${listP.pay_id}">
                            <label for="payment_cod">${listP.name_pay}</label><br>
                        </c:forEach>
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
                        <button type="button" onclick="findCoupon()">Find Coupon</button>
                    </div>

                    <div class="totals">
                        <p>Tạm tính: <span id="subtotal">${requestScope.totalM}đ</span></p>
                        <p >Shipping fee: <span class="shipping">0đ</span></p>
                        <label for="coin">Coin</label>
                        <input type="checkbox" id="coin" name="coin" value="${requestScope.coin.coin_id}">${requestScope.coin.coinNumber}đ
                        <div class="results" id="discount"></div>
                        <input type="hidden" name="total_money" id="total_money_field" value="${requestScope.totalM}">
                        <p>Tổng cộng: <span name="totalMoney" id="total">${requestScope.totalM}đ</span></p>
                    </div>

                    <button type="submit" id="order-button" class="order-button">ĐẶT HÀNG</button>
                    <a href="cart" class="back-to-cart">Quay về giỏ hàng</a>
                </div>
            </form>
        </div>


        <link href="https://pay.vnpay.vn/lib/vnpay/vnpay.css" rel="stylesheet" />
        <script src="https://pay.vnpay.vn/lib/vnpay/vnpay.min.js"></script>
        <script src="js/order.js"></script>
        <script>
                            let discountValue = 0;
                            let coinValue = parseFloat($('#coin').next().text().replace(/[^0-9.-]+/g, "")) || 0;

                            function updateTotal() {
                                let subtotal = parseFloat($('#subtotal').text().replace(/[^0-9.-]+/g, ""));
                                let shippingFee = parseFloat($('.shipping').text().replace(/[^0-9.-]+/g, ""));
                                let discount = discountValue || 0;
                                let coin = $('#coin').is(':checked') ? coinValue : 0;

                                let total = subtotal - shippingFee - discount - coin;
                                $('#total').text(total.toFixed() + 'đ');
                                $('#total_money_field').val(total.toFixed(2));
                            }

                            function applyCoupon(discount) {
                                discountValue = discount;
                                $('#discount').text(discount + 'đ');
                                updateTotal();
                            }

                            $('#coin').change(function () {
                                updateTotal();
                            });

                            $(document).ready(function () {
                                updateTotal();
                            });
                            function findCoupon() {
                                keyword = document.getElementById("keyword").value;
                                fetch("/PetStore/coupon-rest-control?keyWord=" + keyword)
                                        .then(response => response.json())
                                        .then(data => {
                                            const resultsDiv = document.querySelector(".results");
                                            resultsDiv.innerHTML = "";
                                            data.forEach(coupon => {
                                                const couponElement = document.createElement("div");
                                                couponElement.id = "coupon-item";
                                                couponElement.textContent = "Coupon: " + coupon.discount + "đ";

                                                couponElement.addEventListener("click", function () {
                                                    document.querySelector(".coupon").textContent = coupon.discount + "%";
                                                    couponId = coupon.id;
                                                    console.log(couponId);
                                                });
                                                resultsDiv.appendChild(couponElement);
                                            });
                                        })
                                        .catch(error => console.error('Error:', error));
                            }

                            document.getElementById('order-button').addEventListener('click', function (event) {
                                event.preventDefault();
                                let couponId = document.getElementById("discount").value || null;
                                let coinId = document.getElementById("coin").checked ? document.getElementById("coin").value : 0;


                                const formData = {
                                    email: document.getElementById('email').value,
                                    name: document.getElementById('name').value,
                                    phone: document.getElementById('phone').value,
                                    province: document.getElementById('province').value,
                                    district: document.getElementById('districts').value,
                                    ward: document.getElementById('wards').value,
                                    note: document.getElementById('note').value,
                                    payment: document.querySelector('input[name="payment"]:checked').value,
                                    total_money: document.getElementById('total').innerText.replace('đ', '').trim(),
                                    couponId: couponId,
                                    coinId: coinId
                                };

                                console.log('Form Data:', formData); // For debugging purposes

                                var selectedPaymentMethod = formData.payment;

                                var ajaxUrl = '';
                                if (selectedPaymentMethod == '1') {
                                    ajaxUrl = 'deliveryOrderControl';
                                } else if (selectedPaymentMethod == '2') {
                                    ajaxUrl = 'payment';
                                } else {
                                    ajaxUrl = 'error.jsp';
                                }

                                $.ajax({
                                    type: 'POST',
                                    url: ajaxUrl,
                                    contentType: 'application/json; charset=utf-8',
                                    data: JSON.stringify(formData),
                                    success: function (response) {
                                        if (ajaxUrl === 'deliveryOrderControl') {
                                            window.location.href = 'thankyou.jsp';
                                        } else if (ajaxUrl === 'payment') {
                                            if (response.code === '00') {
                                                if (window.vnpay) {
                                                    vnpay.open({width: 768, height: 600, url: response.data});
                                                } else {
                                                    location.href = response.data;
                                                }
                                                return false;
                                            } else {
                                                alert('Payment failed. Please try again.');
                                            }
                                        } else {
                                            alert('An error occurred. Please try again.');
                                        }
                                    },
                                    error: function (error) {
                                        console.error('Error:', error);
                                        alert('Error occurred while placing the order.');
                                    }
                                });
                            });
        </script>
    </body>
</html>
