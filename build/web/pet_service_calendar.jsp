<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registered service calendar</title>
        <link href="https://fonts.googleapis.com/css?family=Montserrat:200,300,400,500,600,700,800&display=swap"
              rel="stylesheet">
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
        <link rel="stylesheet" href="assets/PetGroomer/css/main.css">
        <style>
            .column100{
                text-align: center;
            }
        </style>
    </head>

    <body>
        <!--header-->
        <%@include file="layout/UI/header_calendar.jsp" %>

        <div>
            <div class="row justify-content-center pb-5 mb-0 mt-5"">
                <div class="col-md-7 heading-section text-center ftco-animate">
                    <h2>Registered service calendar</h2>
                </div>
            </div>

            <div class="limiter" style="margin-top: -80px;">
                <div class="container-table100">
                    <div class="wrap-table100">
                        <div class="table100 ver1 m-b-110">
                            <table data-vertable="ver1">
                                <thead>
                                    <tr class="row100 head">
                                        <th class="column100 column2" data-column="column1">PACKAGE</th>
                                        <th class="column100 column2" data-column="column2">Service Name</th>
                                        <th class="column100 column3" data-column="column3">EMPLOYEE ID</th>
                                        <th class="column100 column4" data-column="column4">EMPLOYEE NAME</th>
                                        <th class="column100 column5" data-column="column5">DATE</th>
                                        <th class="column100 column6" data-column="column6">TIME</th>
                                        <th class="column100 column6" data-column="column7" colspan="1">ACTION</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="i" items="${vbs}">
                                        <tr class="row100">
                                            <td class="column100 column2" data-column="column1">${i.service_id}</td>
                                            <td class="column100 column2" data-column="column2">${i.service_name}</td>
                                            <td class="column100 column3" data-column="column3">${i.groomer_id}</td>
                                            <td class="column100 column4" data-column="column4">${i.groomer_name}</td>
                                            <td class="column100 column5" data-column="column5">${i.booking_date}</td>
                                            <td class="column100 column6" data-column="column6">${i.booking_time}:00</td>
                                            <c:choose>
                                                <c:when test="${i.isCompleted == 0}">
                                                    <td class="column100 column6" data-column="column6">   
                                                        <button onclick="cancelService(this, ${i.booking_id})" class="btn btn-body btn-sm">CANCEL</button>
                                                    </td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td class="column100 column6" data-column="column6">
                                                        <a class="btn btn-body btn-sm" 
                                                           href="#?booking_id=${i.booking_id}"">COMPLETED</a>
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--Ajax code-->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script>
            function cancelService(btn, bookingId) {
                var text = "CANCELLED";
                btn.parentElement.innerHTML = text;
                $.ajax({
                    type: "GET",
                    url: "deleteCalendar",
                    data: {
                        bookingId: bookingId
                    },
                    success: function (response) {
                        //
                    },
                    error: function (error) {
                        console.error("Error: " + error);
                    }
                });
            }
        </script>

        <!--footer-->
        <%@include file="layout/UI/footer.jsp" %>
    </body>
</html>