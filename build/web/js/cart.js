function calculateTotal() {
    let total = 0;
    $('.quantity-container').each(function() {
        let $row = $(this).closest('tr');
        let stateId = $row.find('input[type="checkbox"]').attr('id').split('-')[1];
        if (stateId == 1) {
            let price = parseFloat($row.find('.product-price').text());
            let quantity = parseInt($row.find('.quantity-amount').val(), 10);
            total += price * quantity;
        }
    });
    $('#totalMoney').text(total.toFixed(2));
}

function updateTotalPrice(row) {
    let price = parseFloat($(row).find('.product-price').text());
    let quantity = parseInt($(row).find('.quantity-amount').val(), 10);
    let totalPrice = price * quantity;
    $(row).find('.total-price').text(totalPrice.toFixed(2) + "đ"); // Update total price for the product
}

$(document).ready(function () {
    $('.quantity-container').on('click', '.decrease, .increase', function () {
        let $input = $(this).closest('.quantity-container').find('.quantity-amount');
        let currentValue = parseInt($input.val(), 10);
        let newValue = currentValue;
        if ($(this).hasClass('decrease') && currentValue > 1) {
            newValue = currentValue - 1;
        } else if ($(this).hasClass('increase')) {
            newValue = currentValue + 1;
        }

        $input.val(newValue);

        // Lấy hàng chứa sản phẩm hiện tại
        let $row = $(this).closest('tr');

        // Cập nhật giá trị tổng tiền ngay lập tức
        updateTotalPrice($row[0]);

        // Tính toán lại tổng tiền cho tất cả các sản phẩm có sta_id = 1
        calculateTotal();

        // Gửi yêu cầu AJAX để cập nhật số lượng trong cơ sở dữ liệu
        let cartItemId = $row.attr('id').split('-')[1];
        $.ajax({
            url: 'updateCartItemQuantity', // Script xử lý trên server để cập nhật số lượng
            type: 'POST',
            data: {
                cartItemId: cartItemId,
                quantity: newValue
            },
            success: function (response) {
                if (response.success) {
                    console.log("Quantity updated successfully");
                } else {
                    console.error("Error updating quantity");
                }
            },
            error: function (error) {
                console.error("AJAX error: ", error);
            }
        });
    });
});


function deleteCartItem(productId, event) {
    event.preventDefault();
    $.ajax({
        url: "deleteCartItem?id=" + productId,
        type: "GET",
        success: function (response) {
            $("#productRow-" + productId).remove();
            console.log("Product removed from cart.");
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Error: ", textStatus);
        }
    });
}
function updateCheckedState(id) {
    var state = document.getElementById("checkk-" + id).checked ? 1 : 2;
    console.log(state);
    $.ajax({
        url: "updateState",
        type: "POST",
        data: {
            state: state,
            cartItemId: id
        },
        success: function (data, textStatus, jqXHR) {
            console.log("State update success");
            // Tính toán lại tổng tiền sau khi cập nhật trạng thái
            calculateTotal();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("State update failed");
        }
    });
}






