<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Management</title>
        <style>

            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f9;
                margin: 0;
                padding: 20px;
            }
            .order-table th {
                background-color: #333;
                color: #fff;
                padding: 10px;
                text-align: center;
            }

            .order-table th:nth-child(1) { /* Order ID */
                width: 10%;
            }

            .order-table th:nth-child(2) { /* Address */
                width: 20%;
            }

            .order-table th:nth-child(3) {
                width: 10%;
            }

            .order-table th:nth-child(4) {
                width: 20%;
            }

            .order-table th:nth-child(5) {
                width: 15%;
            }

            .order-table th:nth-child(6) {
                width: 15%;
            }

            .order-table th:nth-child(7) {
                width: 10%;
            }

            .container {
                width: 90%;
                margin: auto;
            }

            h2 {
                color: #333;
                text-align: center;
                margin-bottom: 20px;
            }

            .order-table {
                width: 100%;
                border-collapse: collapse;
                margin-bottom: 20px;
            }

            .order-table thead {
                background-color: #333;
                color: #fff;
            }

            .order-table th, .order-table td {
                border: 1px solid #ccc;
                padding: 10px;
                text-align: center;
            }

            .order-table tr:nth-child(even) {
                background-color: #f9f9f9;
            }

            .order-table tr:nth-child(odd) {
                background-color: #fff;
            }

            .order-table .status {
                font-weight: bold;
                padding: 5px 10px;
                border-radius: 4px;
            }

            .status-warning {
                color: #ffa500;
            }

            .status-completed {
                color: #28a745;
            }

            .status-cancel {
                color: #dc3545;
            }

            .btn-success {
                background-color: #28a745;
                color: white;
                border: none;
                padding: 5px 10px;
                cursor: pointer;
                border-radius: 4px;
            }

            .btn-danger {
                background-color: #dc3545;
                color: white;
                border: none;
                padding: 5px 10px;
                cursor: pointer;
                border-radius: 4px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <!-- Section for Unconfirmed Orders -->
            <h2>Order confirmation</h2>
            <table class="order-table">
                <thead>
                    <tr>
                        <th>Order ID</th>
                        <th>Address</th>
                        <th>Phone</th>
                        <th>Note</th>
                        <th>Total Money</th>
                        <th>Payment</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listO}" var="order">

                        <c:if test="${order.status_id.status_id == 4}">
                            <tr>
                                <td>${order.order_id}</td>
                                <td>${order.provinces}, ${order.district}, ${order.ward}</td>
                                <td>${order.phone}</td>
                                <td>${order.note}</td>
                                <td>${order.total_money}</td>
                                <td>${order.pay_id.name_pay}</td>
                                <td>
                                    <span class="status status-warning">To Ship</span>
                                </td>
                                <td>
                                    <a href="updateStatus?id=${order.order_id}">
                                        <button type="button" class="btn-success">Confirm</button>
                                    </a>
                                    &nbsp;

                                    <a href="#" onclick="doDelete('${order.order_id}')">
                                        <button type="button" class="btn-danger">Delete</button>
                                    </a>
                                </td>
                            </tr>
                        </c:if>


                    </c:forEach>
                </tbody>
            </table>


            <h2>Confirmed Orders</h2>
            <table class="order-table">
                <thead>
                    <tr>
                        <th>Order ID</th>
                        <th>Address</th>
                        <th>Phone</th>
                        <th>Note</th>
                        <th>Total Money</th>
                        <th>Payment</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listO}" var="order">
                        <c:if test="${order.status_id.status_id == 5}">
                            <tr>
                                <td>${order.order_id}</td>
                                <td>${order.provinces}, ${order.district}, ${order.ward}</td>
                                <td>${order.phone}</td>
                                <td>${order.note}</td>
                                <td>${order.total_money}</td>
                                <td>${order.pay_id.name_pay}</td>
                                <td>
                                    <span class="status status-completed">Completed</span>
                                </td>
                                <td>
                                    <a href="#" onclick="doDelete('${order.order_id}')">
                                        <button type="button" class="btn-danger">Delete</button>
                                    </a>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table>


            <h2>Deleted Orders</h2>
            <table class="order-table">
                <thead>
                    <tr>
                        <th>Order ID</th>
                        <th>Address</th>
                        <th>Phone</th>
                        <th>Note</th>
                        <th>Total Money</th>
                        <th>Payment</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listO}" var="order">
                        <c:if test="${order.status_id.status_id == 6}">
                            <tr>
                                <td>${order.order_id}</td>
                                <td>${order.provinces}, ${order.district}, ${order.ward}</td>
                                <td>${order.phone}</td>
                                <td>${order.note}</td>
                                <td>${order.total_money}</td>
                                <td>${order.pay_id.name_pay}</td>
                                <td>
                                    <span class="status status-cancel">Cancelled</span>
                                </td>


                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
    <script>
        function doDelete(id) {
            var option = confirm('Are you sure to delete');
            if (option === true) {
                window.location.href = 'delete?id=' + id;
            }
        }
    </script>
</html>
