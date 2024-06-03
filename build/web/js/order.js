var globalProvinceName, globalDistrictName, globalWardstName;

$(document).ready(function () {
    $('#province').change(function () {
        var province_code = $(this).val();
        globalProvinceName = $(this).children("option:selected").text();
        
        $('#districts').html('<option>Select</option>');
        $('#wards').html('<option>Select</option>');

        $.ajax({
            type: 'get',
            url: 'districts',
            data: {province_code: province_code},
            success: function (data) {
                $('#districts').html(data);
                $('#districts').change();
            },
            error: function () {
                alert('Error occurred while fetching districts.');
            }
        });
    });

    $('#districts').change(function () {
        var district_code = $(this).val();

        $('#wards').html('<option>Select</option>');

        $.ajax({
            type: 'get',
            url: 'wards',
            data: {district_code: district_code},
            success: function (data) {
                $('#wards').html(data);
                globalDistrictName = $('#districts option:selected').text();
                globalWardstName = $('#wards option:selected').text();
                
                handleLocationData(globalProvinceName, globalDistrictName, globalWardstName);
                calculateDistance(globalProvinceName, globalDistrictName, globalWardstName);
            },
            error: function () {
                alert('Error occurred while fetching wards.');
            }
        });
    });

    $('#province').change();
});

function handleLocationData(provinceName, districtName, wardstName) {
    console.log("Tên tỉnh/thành phố: " + provinceName);
    console.log("Tên quận/huyện: " + districtName);
    console.log("Tên xã/phường: " + wardstName);
}

function calculateDistance(provinceName, districtName, wardstName) {
    var adminAddress = 'Mỹ An, Phan Tứ, Đà Nẵng';
    var address = districtName + ', ' + wardstName + ', ' + provinceName;

    $.getJSON('https://nominatim.openstreetmap.org/search?format=json&q=' + adminAddress, function (data1) {
        if (data1.length > 0) {
            var adminLat = data1[0].lat;
            var adminLon = data1[0].lon;

            $.getJSON('https://nominatim.openstreetmap.org/search?format=json&q=' + address, function (data2) {
                if (data2.length > 0) {
                    var destLat = data2[0].lat;
                    var destLon = data2[0].lon;

                    var distance = calculateHaversine(adminLat, adminLon, destLat, destLon);
                    console.log('Distance: ' + distance.toFixed(2) + ' km');

                    var shipping = 0;
                    if (distance < 200) {
                        shipping = 10;
                    } else if (distance < 400) {
                        shipping = 20;
                    } else if (distance < 600) {
                        shipping = 30;
                    } else if (distance < 800) {
                        shipping = 40;
                    } else if (distance < 1000) {
                        shipping = 50;
                    } else {
                        shipping = 70;
                    }
                    $('.shipping').text(shipping +'đ' );

                    console.log('Shipping Fee: ' + shipping + 'đ');
                    console.log('---------------');
                } else {
                    alert('Destination address not found');
                }
            }).fail(function () {
                alert('Error retrieving destination address.');
            });
        } else {
            alert('Admin address not found');
        }
    }).fail(function () {
        alert('Error retrieving admin address.');
    });
}

function calculateHaversine(lat1, lon1, lat2, lon2) {
    var R = 6371; // Radius of the earth in km
    var dLat = deg2rad(lat2 - lat1);
    var dLon = deg2rad(lon2 - lon1);
    var a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
            Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
            Math.sin(dLon / 2) * Math.sin(dLon / 2);
    var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    var d = R * c; // Distance in km
    return d;
}

function deg2rad(deg) {
    return deg * (Math.PI / 180);
}
