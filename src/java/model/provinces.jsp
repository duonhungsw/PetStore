<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="untree_co-section">
            <div class="container">

                <div class="row">
                    <div class="col-md-6 mb-5 mb-md-0">
                        <h2 class="h3 mb-3 text-black">Viet Nam</h2>
                        <div class="p-3 p-lg-5 border bg-white">
                            <div class="form-group">
                                <label for="c_country" class="text-black">Provinces <span class="text-danger">*</span></label>
                                <select id="province" class="form-control" name="province_code">
                                    <c:forEach var="province" items="${requestScope.provinces}">
                                        <option  value="${province.code}">${province.name}</option>  
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="districts" class="text-black">Districts <span class="text-danger">*</span></label>
                                <select id="districts" class="form-control" name="district_code">
                                    <option >Select</option>  
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="wards" class="text-black">Wards <span class="text-danger">*</span></label>
                                <select id="wards" class="form-control" name="ward_code">
                                    <option >Select</option> 
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <button id="calculateDistanceButton" class="btn btn-primary">Calculate Distance to My Location</button>

            </div>
        </div>
        <script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#province').change(function () {
                    var province_code = $(this).val();

                    // Reset the district and ward dropdowns
                    $('#districts').html('<option>Select</option>');
                    $('#wards').html('<option>Select</option>');

                    $.ajax({
                        type: 'get',
                        url: 'districts',
                        data: {province_code: province_code},
                        success: function (data) {
                            $('#districts').html(data);
                            // Automatically trigger change to load wards for the first district
                            $('#districts').change();
                        },
                        error: function () {
                            alert('Error occurred while fetching districts.');
                        }
                    });
                });

                $('#districts').change(function () {
                    var district_code = $(this).val();

                    // Reset the ward dropdown
                    $('#wards').html('<option>Select</option>');

                    $.ajax({
                        type: 'get',
                        url: 'wards',
                        data: {district_code: district_code},
                        success: function (data) {
                            $('#wards').html(data);
                        },
                        error: function () {
                            alert('Error occurred while fetching wards.');
                        }
                    });
                });

                // Trigger the province change event if a province is preselected
                $('#province').change();
            });


            $(document).ready(function () {
                // Hàm tính toán khoảng cách từ tọa độ đã nhập đến vị trí cụ thể
                function calculateDistance(lat1, lon1, lat2, lon2) {
                    var R = 6371; // Bán kính trái đất trong kilômét
                    var dLat = (lat2 - lat1) * Math.PI / 180;
                    var dLon = (lon2 - lon1) * Math.PI / 180;
                    var a =
                            Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                            Math.cos(lat1 * Math.PI / 180) * Math.cos(lat2 * Math.PI / 180) *
                            Math.sin(dLon / 2) * Math.sin(dLon / 2);
                    var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
                    var distance = R * c; // Khoảng cách giữa hai điểm
                    return distance;
                }

                // Hàm gửi yêu cầu lấy tọa độ của địa chỉ thông qua OpenStreetMap Nominatim API
                function getCoordinates(address, callback) {
                    var apiUrl = 'https://nominatim.openstreetmap.org/search?format=json&q=' + encodeURIComponent(address);

                    $.getJSON(apiUrl, function (data) {
                        if (data.length > 0) {
                            var latitude = parseFloat(data[0].lat);
                            var longitude = parseFloat(data[0].lon);
                            callback(latitude, longitude);
                        } else {
                            alert('Không thể tìm thấy địa chỉ');
                        }
                    });
                }

                // Hàm tính toán khoảng cách từ địa chỉ được chọn đến vị trí cụ thể
                function calculateDistanceToMyLocation() {
                    // Lấy tọa độ của địa chỉ được chọn từ các trường select
                    var province_code = $('#province').val();
                    var district_code = $('#districts').val();
                    var ward_code = $('#wards').val();

                    // Xây dựng địa chỉ từ các mã code của các trường select
                    var address = province_code + ', ' + district_code + ', ' + ward_code;

                    // Gửi yêu cầu lấy tọa độ của địa chỉ
                    getCoordinates(address, function (latitude, longitude) {
                        // Tọa độ của Mỹ An, Ngũ Hành Sơn, Đà Nẵng
                        var myAnLocation = {
                            lat: 15.968591, // Vĩ độ
                            lon: 108.260788 // Kinh độ

                        };

                        // Tính toán khoảng cách
                        var distance = calculateDistance(latitude, longitude, myAnLocation.lat, myAnLocation.lon);

                        // Hiển thị kết quả
                        alert('Khoảng cách đến Mỹ An, Ngũ Hành Sơn, Đà Nẵng là: ' + distance.toFixed() + ' km');
                    });
                }

                // Xử lý sự kiện khi nhấn nút tính toán khoảng cách
                $('#calculateDistanceButton').click(function () {
                    calculateDistanceToMyLocation();
                });
            });

        </script>
    </body>
</html>
