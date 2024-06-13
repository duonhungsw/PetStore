<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Purchase List</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f5f5f5;
                margin: 0;
                padding: 0;
            }
            nav {
                background-color: #ff4d4f;
            }
            nav ul {
                list-style: none;
                padding: 0;
                margin: 0;
                display: flex;
                justify-content: center;
            }
            nav ul li {
                margin: 0 10px;
            }
            nav ul li a {
                color: white;
                text-decoration: none;
                padding: 15px 20px;
                display: block;
            }
            nav ul li a:hover {
                background-color: #e43e3e;
                border-radius: 4px;
            }
            h1 {
                text-align: center;
                color: #333;
                margin: 20px 0;
            }
            table {
                width: 90%;
                margin: 0 auto;
                border-collapse: collapse;
                background-color: white;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            table thead {
                background-color: #ff4d4f;
                color: white;
            }
            table th, table td {
                padding: 10px;
                border: 1px solid #ddd;
                text-align: center;
            }
            table tbody tr:nth-child(even) {
                background-color: #f9f9f9;
            }
            table tbody tr:hover {
                background-color: #f1f1f1;
            }
            table img {
                width: 80px;
                height: 80px;
                object-fit: cover;
                border-radius: 8px;
            }
        </style>
    </head>
    <body>
        
        <nav>
            <ul>
                <li><a href="home">Home</a></li>
                <li><a href="listpurchase?id=0">All</a></li>
                <li><a href="listpurchase?id=4">Wait confirmation</a></li>
                <li><a href="listpurchase?id=5">Completed</a></li>
                <li><a href="listpurchase?id=6">Cancelled</a></li>
            </ul>
        </nav>
        <div>
            <h1>Purchased List</h1>
            <table>
                <thead>
                    <tr>
                        <th>Image</th>
                        <th>Name Product</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Total Money</th>
                        <c:if test="${param.id == '4'}">
                            <th>Cancel</th>
                        </c:if>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listPur}" var="item">
                        <tr>
                            
                            <td><img src="${item.product_id.imageProduct}" width="50px" height="50px"/></td>
                            <td>${item.product_id.nameP}</td>
                            <td>${item.price} $</td>
                            <td>${item.quantity}</td>
                            <td>${item.total_money} $</td>
                            <c:if test="${param.id == '4'}">
                                <td>
                                    <a href="#" onclick="doDelete('${item.order_id.order_id}')">
                                        <button type="button" class="btn-danger">Delete</button>
                                    </a>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
    <script>
     function doDelete(id) {
            var option = confirm('Are you sure to delete');
            if (option === true) {
                window.location.href = 'cancelorder?id=' + id;
            }
        }
    </script>
</html>
