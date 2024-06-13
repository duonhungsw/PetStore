<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <title>Focus - Bootstrap Admin Dashboard </title>
        <!-- Favicon icon -->
        <link rel="icon" type="image/png" sizes="16x16" href="./images/favicon.png">
        <link rel="stylesheet" href="./vendor/owl-carousel/css/owl.carousel.min.css">
        <link rel="stylesheet" href="./vendor/owl-carousel/css/owl.theme.default.min.css">
        <link href="./vendor/jqvmap/css/jqvmap.min.css" rel="stylesheet">
        <link href="./css/style_1.css" rel="stylesheet">
        <style>
            .card {
                width: 100%;
                margin: 20px auto;
                border: 1px solid #ccc;
                border-radius: 8px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            }
            .card-header {
                background-color: #f8f9fa;
                padding: 10px;
                border-bottom: 1px solid #e9ecef;
                border-top-left-radius: 8px;
                border-top-right-radius: 8px;
            }
            .card-title {
                margin: 0;
                font-size: 1.5em;
            }
            .card-body {
                padding: 20px;
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin: 20px 0;
                font-weight: bold;
            }
            th, td {
                border: 1px solid #ccc;
                padding: 10px;
                text-align: left;
            }
            th {
                background-color: #f8f9fa;
            }
            tr:nth-child(even) {
                background-color: #f2f2f2;
            }
            .actions a {
                text-decoration: none;
                color: #007bff;
                margin-right: 10px;
            }
            .actions a.delete {
                color: red;
            }
        </style>


    </head>

    <body>

        <%@include file="ad_header.jsp"%>
        <!--**********************************
            Header end ti-comment-alt
        ***********************************-->

        <!--**********************************
            Sidebar start
        ***********************************-->

        <!--**********************************
            Sidebar end
        ***********************************-->

        <!--**********************************
            Content body start
        ***********************************-->
        <div class="content-body">
            <!-- row -->
            <div class="container-fluid">

                <div class="row">
                    <div class="col-xl-10 col-lg-10 col-md-10">
                        <div class="card">
                            <div class="card-header">
                                <h4 class="card-title">Order Product</h4>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-xl-12 col-lg-8">
                                        <table border="1px" witdth="" height="100%">
                                            <tr>
                                                <th>Order Id</th>
                                                <th>Customer Name</th>
                                                <th>Customer Phone</th>
                                                <th>Product Name</th>
                                                <th>Address</th>
                                                <th>Price</th>
                                                <th>Amount</th>
                                                <th>Total Of Money</th>
                                                <th>Date</th>
                                            </tr>
                                            <!-- Iterate over the list of books -->
                                            <c:forEach var="o" items="${requestScope.list}">
                                                <tr>
                                                    <td>${o.order.orderId}</td>
                                                    <td>${o.order.cart.account.name}</td>
                                                    <td>${o.order.phone}</td>
                                                    <td>${o.product.nameP}</td>
                                                    <td>${o.order.ward}, ${o.order.district}, ${o.order.provinces}</td>
                                                    <td>${o.price}$</td>
                                                    <td>${o.amount}</td>
                                                    <td>${o.totalOfMoney}</td>
                                                    <td>${o.order.date}</td>
                                                </tr>
                                            </c:forEach>

                                        </table>
                                        <nav aria-label="Page navigation example" class="d-flex justify-content-center mt-3">
                                            <c:set var="page" value="${requestScope.page}" />

                                            <c:set var="numberPage" value="${requestScope.numberPage}" />
                                            <div class="pagination">
                                                <a href="orderproduct?page=${1}" style="color: black; float: left; padding: 8px 16px; text-decoration: none; transition: background-color .3s;">&laquo;</a>&nbsp;
                                                <a href="orderproduct?page=${page-1 == 0 ? 1 : page-1}" style="color: black; float: left; padding: 8px 16px; text-decoration: none; transition: background-color .3s;">&lsaquo;</a>&nbsp;&nbsp;
                                                <span style="float: left; padding: 8px 16px; background-color: #ddd; color: black;">${page}</span>&nbsp;&nbsp;
                                                <a href="orderproduct?page=${page+1 > numberPage ? numberPage : page+1}" style="color: black; float: left; padding: 8px 16px; text-decoration: none; transition: background-color .3s;">&rsaquo;</a>&nbsp;
                                                <a href="orderproduct?page=${numberPage}" style="color: black; float: left; padding: 8px 16px; text-decoration: none; transition: background-color .3s;">&raquo;</a>&nbsp;
                                            </div>
                                        </nav>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-2 col-lg-2 col-md-2">
                        <div class="card">
                            <div class="card-body">
                                <form action="orderproduct">
                                    <div >
                                        <input class="form-control" type="search" placeholder="Search product name..." aria-label="Search" name="name">
                                    </div>

                                </form>
                            </div>
                        </div>
                    </div>

                </div>
               

            </div>
        </div>

    </div>
    <!--**********************************
        Main wrapper end
    ***********************************-->

    <!--**********************************
        Scripts
    ***********************************-->
    <!-- Required vendors -->
    <script src="./vendor/global/global.min.js"></script>
    <script src="./js/quixnav-init.js"></script>
    <script src="./js/custom.min.js"></script>


    <!-- Vectormap -->
    <script src="./vendor/raphael/raphael.min.js"></script>
    <script src="./vendor/morris/morris.min.js"></script>


    <script src="./vendor/circle-progress/circle-progress.min.js"></script>
    <script src="./vendor/chart.js/Chart.bundle.min.js"></script>

    <script src="./vendor/gaugeJS/dist/gauge.min.js"></script>

    <!--  flot-chart js -->
    <script src="./vendor/flot/jquery.flot.js"></script>
    <script src="./vendor/flot/jquery.flot.resize.js"></script>

    <!-- Owl Carousel -->
    <script src="./vendor/owl-carousel/js/owl.carousel.min.js"></script>

    <!-- Counter Up -->
    <script src="./vendor/jqvmap/js/jquery.vmap.min.js"></script>
    <script src="./vendor/jqvmap/js/jquery.vmap.usa.js"></script>
    <script src="./vendor/jquery.counterup/jquery.counterup.min.js"></script>


    <script src="./js/dashboard/dashboard-1.js"></script>

</body>

</html>