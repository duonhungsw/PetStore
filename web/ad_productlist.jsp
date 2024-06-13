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
                                <h4 class="card-title">List Product</h4>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-xl-12 col-lg-8">
                                        <table border="1px" witdth="" height="100%">
                                            <tr>
                                                <th>Product Id</th>
                                                <th>Product Name</th>
                                                <th>Image</th>
                                                <th>Price</th>
                                                <th>Amount</th>
                                                <th>Status</th>
                                                <th>Action</th>
                                            </tr>
                                            <!-- Iterate over the list of books -->
                                            <c:forEach var="p" items="${requestScope.list}">
                                                <tr>
                                                    <td>${p.product.prodId}</td>
                                                    <td>${p.product.nameP}</td>
                                                    <td><img src="${p.product.imageProduct}" width="80px" height="80px"/></td>
                                                    <td>${p.price}</td>
                                                    <td>${p.amount}</td>
                                                    <td>
                                                        <c:set var="status" scope="session" value="${p.product.delete}" />
                                                        <c:if test="${status == 1}">
                                                            Active
                                                        </c:if>
                                                        <c:if test="${status == 0}">
                                                            Not Active
                                                        </c:if>
                                                    </td>
                                                    <td>
                                                        <a href="updateproduct?id=${p.product.prodId}&status=${p.product.delete}" style="color: blue; text-decoration: none">Change</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <a href="updateproduct?id=${p.product.prodId}" style="color: blue; text-decoration: none">Update</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>

                                        </table>
                                        <nav aria-label="Page navigation example" class="d-flex justify-content-center mt-3">
                                            <c:set var="page" value="${requestScope.page}" />

                                            <c:set var="numberPage" value="${requestScope.numberPage}" />
                                            <div class="pagination">
                                                <a href="adproduct?page=${1}&cid=${cid}" style="color: black; float: left; padding: 8px 16px; text-decoration: none; transition: background-color .3s;">&laquo;</a>&nbsp;
                                                <a href="adproduct?page=${page-1 == 0 ? 1 : page-1}&cid=${cid}" style="color: black; float: left; padding: 8px 16px; text-decoration: none; transition: background-color .3s;">&lsaquo;</a>&nbsp;&nbsp;
                                                <span style="float: left; padding: 8px 16px; background-color: #ddd; color: black;">${page}</span>&nbsp;&nbsp;
                                                <a href="adproduct?page=${page+1 > numberPage ? numberPage : page+1}&cid=${cid}" style="color: black; float: left; padding: 8px 16px; text-decoration: none; transition: background-color .3s;">&rsaquo;</a>&nbsp;
                                                <a href="adproduct?page=${numberPage}&cid=${cid}" style="color: black; float: left; padding: 8px 16px; text-decoration: none; transition: background-color .3s;">&raquo;</a>&nbsp;
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
                                <form action="adproduct">
                                    <div >
                                        <input class="form-control" type="search" placeholder="Search product name..." aria-label="Search" name="name">
                                    </div>

                                </form>

                            </div>


                        </div>
                        <div class="card">
                            <div class="card-body">
                                <ul>
                                    <li>
                                        <a href="adproduct?cid=${0}"> 0. All</a>
                                    </li>
                                    <c:set value="${requestScope.categories}" var="c"/>
                                    <c:forEach items="${c}" var="c">
                                        <li>
                                            <a href="adproduct?cid=${c.category_id}">${c.category_id}. ${c.name}</a>
                                        </li>
                                    </c:forEach>

                                </ul>
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