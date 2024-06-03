<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SERVICES DETAIL</title>
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

    </head>

    <body>
        <!--header-->
        <%@include file="layout/UI/header_service.jsp" %>

        <section class="ftco-section bg-light">
            <div class="container">
                <div class="row justify-content-center pb-5 mb-3">
                    <div class="col-md-7 heading-section text-center ftco-animate">
                        <h2>Affordable Packages</h2>
                    </div>
                </div>
                <div class="row">
                    <c:forEach items="${services}" var="ser">
                        <div class="col-md-3 ftco-animate">
                            <div class="block-7">
                                <div class="img" style="background-image: url(${ser.service_img});"></div>
                                <div class="text-center p-4">
                                    <span class="excerpt d-block">Package ${ser.service_id}</span>
                                    <span class="price"><sup>$</sup><span class="number">${ser.service_price}</span></span>

                                    <ul class="pricing-text mb-5">
                                        <li>${ser.service_name}</li>
                                    </ul>

                                        <a href="petServiceBookingControl?serviceId=${ser.service_id}&serviceName=${ser.service_name}&servicePrice=${ser.service_price}" class="btn btn-primary d-block px-2 py-3">Get Started</a>
                                </div>
                            </div>
                        </div>  
                    </c:forEach>
                </div>
            </div>
        </section>

        <!--footer-->
        <%@include file="layout/UI/footer.jsp" %>
    </body>
</html>
