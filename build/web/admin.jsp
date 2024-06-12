<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js">
        </script>


    </head>

    <body>

        <%@include file="ad_header.jsp"%>

        <div class="content-body">
            <!-- row -->
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-3 col-sm-6">
                        <div class="card">
                            <div class="stat-widget-two card-body">
                                <div class="stat-content">
                                    <div class="stat-text">Today Expenses </div>
                                    <div class="stat-digit"> <i class="fa fa-usd"></i>${requestScope.today}</div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="card">
                            <div class="stat-widget-two card-body">
                                <div class="stat-content">
                                    <div class="stat-text">Income Detail</div>
                                    <div class="stat-digit"> <i class="fa fa-usd"></i>${requestScope.total}</div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="card">
                            <div class="stat-widget-two card-body">
                                <div class="stat-content">
                                    <div class="stat-text">New user</div>
                                    <div class="stat-digit">${requestScope.newuser}</div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="card">
                            <div class="stat-widget-two card-body">
                                <div class="stat-content">
                                    <div class="stat-text">Total User</div>
                                    <div class="stat-digit"> ${requestScope.user}</div>
                                </div>

                            </div>
                        </div>
                        <!-- /# card -->
                    </div>
                    <!-- /# column -->
                </div>
                <div class="row">
                    <div class="col-xl-10 col-lg-10 col-md-10">
                        <div class="card">
                            <c:set var="c" scope="session" value="${requestScope.chart}"/>
                            <div class="card-header">
                                <h4 class="card-title">Sales Overview</h4>
                                <select name="chart" id="chartSelect">
                                    <option value="0" ${c == 0 ? 'selected' : ''}>By Year</option>
                                    <option value="1" ${c == 1 ? 'selected' : ''}>By Month</option>
                                </select>
                            </div>
                            <div class="card-body">

                                <c:if test="${c == 0}">
                                    <canvas id="myChart" style="width:100%;"></canvas>
                                    </c:if>
                                    <c:if test="${c == 1}">
                                    <canvas id="myChart111" style="width:100%;"></canvas>
                                    </c:if>
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

    <script>
        document.getElementById('chartSelect').addEventListener('change', function () {
            var selectedValue = this.value;
            window.location.href = 'admin?chart=' + selectedValue;
        });
    </script>
    <script>
        const xValues = [2018, 2019, 2020, 2021, 2022, 2023, 2024];
        const yValues = [${requestScope.year18}, ${requestScope.year19}, ${requestScope.year20}, ${requestScope.year21}, ${requestScope.year22}, ${requestScope.year23}, ${requestScope.year24}];

        new Chart("myChart", {
            type: "line",
            data: {
                labels: xValues,
                datasets: [{
                        fill: false,
                        lineTension: 0,
                        backgroundColor: "rgba(0,0,255,1.0)",
                        borderColor: "rgba(0,0,255,0.1)",
                        data: yValues
                    }]
            },
            options: {
                legend: {display: false},
                scales: {
                    yAxes: [{ticks: {min: 10000, max: 100000}}],
                }
            }
        });
    </script>
    <script>
        const xValuess = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];
        const yValuess = [${requestScope.month1}, ${requestScope.month2}, ${requestScope.month3}, ${requestScope.month4}, ${requestScope.month5}, ${requestScope.month6},
        ${requestScope.month7}, ${requestScope.month8}, ${requestScope.month9}, ${requestScope.month10}, ${requestScope.month11}, ${requestScope.month12}];

        new Chart("myChart111", {
            type: "line",
            data: {
                labels: xValuess,
                datasets: [{
                        fill: false,
                        lineTension: 0,
                        backgroundColor: "rgba(0,0,255,1.0)",
                        borderColor: "rgba(0,0,255,0.1)",
                        data: yValuess
                    }]
            },
            options: {
                legend: {display: false},
                scales: {
                    yAxes: [{ticks: {min: 1000, max: 10000}}],
                }
            }
        });
    </script>


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