<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Schedule</title>
        <link rel="stylesheet" href="assets/PetGroomer/css/main.css">
        <!--<link href="assets/Employee_Service/img/favicon.png" rel="icon">-->
        <link href="assets/PetGroomer/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/PetGroomer/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/PetGroomer/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="assets/PetGroomer/css/style.css" rel="stylesheet">
        <style>
            .column100{
                text-align: center;
            }
        </style>
    </head>

    <body>

        <header id="header" class="fixed-top d-flex align-items-center">
            <div class="container d-flex justify-content-between">
                <div class="logo">
                    <h1><a href="index.html"><span>my</span>Schedule</a></h1>
                </div>
                <nav id="navbar" class="navbar">
                    <ul>
                        <li><a class="nav-link scrollto active" href="#home">Home</a></li>
                        <li><a class="nav-link scrollto" href="#profile">Profile</a></li>     
                    </ul>
                    <i class="bi bi-list mobile-nav-toggle"></i>
                </nav>
            </div>
        </header>
        
        <section id="hero">
            <div class="hero-container">
                <div id="heroCarousel" class="carousel slide carousel-fade" data-bs-ride="carousel" data-bs-interval="5000">
                    <div class="carousel-inner" role="listbox">
                        <div class="carousel-item active" style="background-image: url(assets/PetGroomer/img/hero-carousel/1.jpg)">
                            <div class="carousel-container">

                                <div class="limiter">
                                    <div class="container-table100">
                                        <div class="wrap-table100">
                                            <div class="table100 ver1 m-b-110">
                                                <table data-vertable="ver1">
                                                    <thead>
                                                        <tr class="row100 head">
                                                            <th class="column100 column2" data-column="column1">PACKAGE</th>
                                                            <th class="column100 column2" data-column="column2">Service Name</th>
                                                            <th class="column100 column2" data-column="column2">Service Price</th>
                                                            <th class="column100 column3" data-column="column3">CUSTOMER ID</th>
                                                            <th class="column100 column4" data-column="column4">DATE</th>
                                                            <th class="column100 column6" data-column="column6">TIME</th>
                                                            <th class="column100 column6" data-column="column6">STATUS</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="i" items="${vbsOPG}">
                                                            <tr class="row100">
                                                                <td class="column100 column2" data-column="column1">${i.service_id}</td>
                                                                <td class="column100 column2" data-column="column2">${i.service_name}</td>
                                                                <td class="column100 column4" data-column="column4">${i.service_price}</td>
                                                                <td class="column100 column3" data-column="column3">${i.customer_id}</td>
                                                                <td class="column100 column5" data-column="column5">${i.booking_date}</td>
                                                                <td class="column100 column6" data-column="column6">${i.booking_time}:00</td>
                                                                <td class="column100 column6" data-column="column6">
                                                                    <c:choose>
                                                                        <c:when test="${i.isCompleted == 1}">
                                                                            COMPLETED
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <button onclick="updateStatus(this, ${i.booking_id}, 1)" class="btn btn-body btn-info">IN PROCESS</button>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
        </section>
        
        <!--Ajax code-->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script>
            function updateStatus(btn, bookingId, status) {
                var text = "COMPLETED";
                btn.parentElement.innerHTML = text;
                $.ajax({
                    type: "POST",
                    url: "petServiceManageControl",
                    data: {
                        bookingId: bookingId,
                        status: status
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
        
        <%@include file="assets/PetGroomer/layout/footer.jsp" %> 
    </body>
</html>
