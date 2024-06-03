
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>pet_service_booking</title>
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
                        <h2 class="mb-4">APPOINTMENT SCHEDULING</h2>
                        <form action="customerServiceBooking" method="POST">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <input type="hidden" class="form-control" name="service_id" value="${serviceId}" readonly>
                                        <input type="hidden" class="form-control" name="service_price" value="${servicePrice}" readonly>
                                        <input type="text" class="form-control" name="service_name" value="${serviceName}" readonly>
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="register_name" placeholder="Your name" required>
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="register_phone" placeholder="Phone number" required>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <div class="form-group">
                                        <div class="form-field">
                                            <div class="select-wrap">
                                                <select name="groomerSelector" id="groomerSelector" onchange="checkSchedule()" class="form-control" required>
                                                    <option disabled selected>Select pet groomer</option>
                                                    <c:forEach var="pgi" items="${pgInfo}">
                                                        <option  value="${pgi.groomer_id}">${pgi.groomer_name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <div class="form-group">
                                        <div class="input-wrap">
                                            <input type="date" id="dateSelector" name="dateSelector" onchange="checkSchedule()" class="form-control" required min="<%= java.time.LocalDate.now() %>">
                                        </div>
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <div class="form-group">
                                        <div class="input-wrap">  
                                            <select id="timeSelector" name="timeSelector" class="form-control" required>
                                                <option disabled selected>Time</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <div class="form-group">
                                        <input type="submit" id="confirmInfo" value="Send message" class="btn btn-primary" style="width: 100%">
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>

                                        
        <!--Ajax code-->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script>
            function checkSchedule() {
                var groomerSelector = $("#groomerSelector").val();
                var dateSelector = $("#dateSelector").val();

                if (groomerSelector && dateSelector) {
                    $.ajax({
                        type: "GET",
                        url: "fetchBookedTimeControl",
                        data: {
                            groomerId: groomerSelector,
                            dateSelector: dateSelector
                        },
                        success: function (response) {
                            var timeSelector = $("#timeSelector");
                            timeSelector.empty(); // Delete all existing options after each date selection
                            // option default
                            var defaultOption = $("<option>").text("Time").prop('disabled', true).prop('selected', true);
                            timeSelector.append(defaultOption);
                            // Create 'select time'
                            var workHours = [7, 8, 9, 10, 14, 15, 16, 17];
                            //Create time options from the workHours
                            for (var i = 0; i < workHours.length; i++) {
                                var hour = workHours[i];
                                var option = $("<option>").text(hour + ":00").val(hour);
                                //handles date and time logic
                                var currentDate = new Date();
                                var selectedDate = new Date($('#dateSelector').val());
                                var selectDateTime = new Date(selectedDate.getFullYear(), selectedDate.getMonth(), selectedDate.getDate(), hour);
                                if (selectDateTime < currentDate) {
                                    option.prop('disabled', true).text(hour + ':00 (unavailable)');
                                }
                                timeSelector.append(option);
                            }

                            // Processing of booked hours
                            for (var j = 0; j < response.length; j++) {
                                var bookedHour = response[j];
                                timeSelector.find('option[value="' + bookedHour + '"]').prop('disabled', true)
                                        .text(bookedHour + ':00 (reserved)');
                                //timeSelector.find('option[value="' + bookedHour + '"]').remove();
                            }
                        },
                        error: function (error) {
                            console.error("Error: " + error);
                        }
                    });
                }
            }
        </script>
        
        <!--footer-->
        <%@include file="layout/UI/footer.jsp" %>
    </body>
</html>
