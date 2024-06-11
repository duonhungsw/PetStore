<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
        <link href="https://fonts.googleapis.com/css?family=Montserrat:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="assets/Customer/fontawesome/css/all.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/Customer/css/animate.css">
        <link rel="stylesheet" href="assets/Customer/css/owl.carousel.min.css">
        <link rel="stylesheet" href="assets/Customer/css/owl.theme.default.min.css">
        <link rel="stylesheet" href="assets/Customer/css/magnific-popup.css">
        <link rel="stylesheet" href="assets/Customer/css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="assets/Customer/css/jquery.timepicker.css">
        <link rel="stylesheet" href="assets/Customer/css/flaticon.css">
        <link rel="stylesheet" href="assets/Customer/css/style.css">
        <link rel="stylesheet" href="css/cart.css">
    </head>
    <body>
        <!--header-->
        <%@include file="layout/UI/header_cart.jsp" %>

        <div class="untree_co-section before-footer-section">
            <div class="container">
                <div class="row mb-5">
                    <form class="col-md-12" method="post">
                        <div class="site-blocks-table">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <td><input type="checkbox" name="checks"></td>
                                        <th class="product-thumbnail">Image</th>
                                        <th class="product-name">Product</th>
                                        <th class="product-price">Price</th>
                                        <th class="product-quantity">Quantity</th>
                                        <th class="product-total">Total</th>
                                        <th class="product-remove">Remove</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="listCart" items="${requestScope.CI}">
                                        <tr id="productRow-${listCart.id}">
                                            <td>
                                                <input type="checkbox" name="check" id="checkk-${listCart.id}"
                                                       <c:if test="${listCart.sta_id.id == 1}">checked</c:if>
                                                       onclick="updateCheckedState(${listCart.id})">
                                            </td>
                                            <td class="product-thumbnail">
                                                <img src="${listCart.prod_id.imageProduct}" alt="Image" class="img-fluid" style="width: 100px; height: auto;">
                                            </td>
                                            <td class="product-name">${listCart.prod_id.nameP}</td>
                                            <td class="product-price">${listCart.prod_id.productDetail.price}</td>
                                            <td>
                                                <div class="input-group mb-3 d-flex align-items-center quantity-container" style="max-width: 120px;">
                                                    <div class="input-group-prepend">
                                                        <button class="btn btn-outline-black decrease" type="button">&minus;</button>
                                                    </div>
                                                    <input type="text" class="form-control text-center quantity-amount" value="${listCart.quantity}" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
                                                    <div class="input-group-append">
                                                        <button class="btn btn-outline-black increase" type="button">&plus;</button>
                                                    </div>
                                                </div>
                                            </td>
                                            <td class="total-price" id="total-price">${listCart.total_money}</td>
                                            <td><a href="#" onclick="deleteCartItem(${listCart.id}, event)" class="btn btn-black btn-sm">X</a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </form>
                </div>
                <section id="cart-add" class="section-p1">


                    <div id="subtotal">
                        <h3>Cart Totals</h3>
                        <table>
                            <tr>
                                <td>Cart Subtotal</td>
                            </tr>

                            <tr>
                                <td>Total :${requestScope.TMCI} đ<span id="totalMoney"></span></td>
                            </tr>
                        </table>
                        <a href="checkout" class="normal checkout-btn">Proceed to checkout</a>
                    </div>

                </section>
            </div>
        </div>


        <!--footer-->
        <%@include file="layout/UI/footer.jsp" %>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="js/cart.js"></script>
    </body>
</html>
