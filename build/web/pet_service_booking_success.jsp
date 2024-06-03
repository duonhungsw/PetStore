<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notification Service Registered</title>
        <link rel="stylesheet" href="assets/Customer/fontawesome/css/all.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:200,300,400,500,600,700,800&display=swap">
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
        <%@include file="layout/UI/header_services_booking.jsp"%>

        <section class="ftco-appointment ftco-section ftco-no-pt ftco-no-pb img"
                 style="background-image: url(assets/Customer/images/booking.jpg);">
            <div class="overlay"></div>
            <div class="container">
                <div class="row d-md-flex justify-content-end">
                    <div class="col-md-12 col-lg-6 half p-3 py-5 pl-lg-5 ftco-animate">
                        <div style="padding-top: 177px;">
                            <h5 style="margin-bottom: 0;">
                                <a href="home.jsp" class="mr-3">Home</a>
                                <a href="service">Service</a>
                            </h5>
                        </div>
                        <h2 style="padding-bottom: 177px; color: whitesmoke">
                            Service Registered Successful
                        </h2>
                    </div>
                </div>
            </div>
        </section>
 

        <!--footer-->
        <%@include file="layout/UI/footer.jsp" %>
    </body>
</html>
