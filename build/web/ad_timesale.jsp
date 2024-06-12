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
        <link href="./css/style.css" rel="stylesheet">
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
                                <h4 class="card-title">Order Service</h4>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-xl-12 col-lg-8">
                                        <c:set var="ts" value="${requestScope.ts}"/>
                                        <table border="1px" witdth="" height="100%">
                                            <tr>
                                                <th>Start Hour</th>
                                                <th>Start Minute</th>
                                                <th>End Hour</th>
                                                <th>End minute</th>
                                                <th>Discount</th>
                                                <th>Status</th>
                                                <th>Action</th>
                                            </tr>
                                            <tr>
                                                <td>${ts.startHour}</td>
                                                <td>${ts.startMinute}</td>
                                                <td>${ts.endHour}</td>
                                                <td>${ts.endMinute}</td>
                                                <td>${ts.discount}</td>
                                                <td>
                                                    <c:set var="status" scope="session" value="${ts.status}" />
                                                    <c:if test="${status == 1}">
                                                        Active
                                                    </c:if>
                                                    <c:if test="${status == 0}">
                                                        Not Active
                                                    </c:if>
                                                </td>
                                                <td>
                                                    <a href="updatetimesale?status=${ts.status}&type=${1}" style="color: blue; text-decoration: none">Change</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                                    <a href="updatetimesale?status=${ts.status}" style="color: blue; text-decoration: none">Update</a>
                                                </td>
                                            </tr>

                                        </table>
                                        <h5 style="color: red">${requestScope.error}</h5>
                                    </div>
                                </div>
                            </div>
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