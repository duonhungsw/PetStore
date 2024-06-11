<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List"%>
<%@ page import="model.Product"%>
<%@ page import="model.Product_Detail"%>
<%@ page import="model.Category"%>
<%@ page import="model.Comment"%>
<%@ page import="daos.CommentDAO"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Products Page</title>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
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
    <link rel="stylesheet" href="css/detail.css"/>
    <jsp:useBean id="a" class="daos.ProductDAO" scope="request"></jsp:useBean>
    <jsp:useBean id="commentDAO" class="daos.CommentDAO" scope="request"></jsp:useBean>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
    <!--header-->
    <%@ include file="layout/UI/header_product.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <div class="container py-5">
        <div class="row">
            <div class="col-lg-6">
                <img src="${detail.imageProduct}" class="img-fluid fixed-ratio-image" alt="Product Image">
            </div>
            <div class="col-lg-6">
                <h2 class="fw-bold">${detail.nameP}</h2>
                <p class="text-muted">${detail.cateId.name}</p>
                <h3 class="my-4">${detail.productDetail.price}</h3>
                <p class="mb-4">${detail.cateId.name}</p>
                <div class="d-flex gap-3 mb-4">
                    <input type="number" class="form-control" value="1" style="max-width: 80px;" min="1">
                    <button class="btn btn-primary" type="button">Add to Cart</button>
                </div>
            </div>
        </div>
        <ul class="nav nav-tabs mt-5" id="productTab" role="tablist">
            <li class="nav-item" role="presentation">
                <button class="nav-link active" id="description-tab" data-bs-toggle="tab" data-bs-target="#description" type="button" role="tab" aria-controls="description" aria-selected="true">Description</button>
            </li>
            <li class="nav-item" role="presentation">
                <button class="nav-link" id="specs-tab" data-bs-toggle="tab" data-bs-target="#specs" type="button" role="tab" aria-controls="specs" aria-selected="false">Specifications</button>
            </li>
            <li class="nav-item" role="presentation">
                <button class="nav-link" id="reviews-tab" data-bs-toggle="tab" data-bs-target="#reviews" type="button" role="tab" aria-controls="reviews" aria-selected="false">Reviews</button>
            </li>
        </ul>
        <div class="tab-content" id="productTabContent">
            <div class="tab-pane fade show active" id="description" role="tabpanel" aria-labelledby="description-tab">
                <p class="mt-3">
                    Here's where you'd include detailed information about the product. This could be a long-form text that
                    goes into depth about the product's features, the problems it solves, and any other relevant details a
                    potential customer might want to know before making a purchase.
                </p>
            </div>
            <div class="tab-pane fade" id="specs" role="tabpanel" aria-labelledby="specs-tab">
                <table class="table mt-3">
                    <tr>
                        <th>Weight</th>
                        <td>1kg</td>
                    </tr>
                    <tr>
                        <th>Dimensions</th>
                        <td>10 x 20 x 5 cm</td>
                    </tr>
                </table>
            </div>
            <div class="tab-pane fade" id="reviews" role="tabpanel" aria-labelledby="reviews-tab">
                <div class="mt-3">
                    <c:forEach var="review" items="${commentDAO.getCommentsByProductId(detail.id)}">
                        <div class="mb-3">
                            <h5>User: ${review.acc_id}</h5>
                            <p>${review.description}</p>
                        </div>
                    </c:forEach>
                </div>
                <div class="mt-4">
                    <h5>Add a Review</h5>
                    <form action="submitReview" method="post">
                        <div class="mb-3">
                            <label for="acc_id" class="form-label">User ID</label>
                            <input type="text" class="form-control" id="acc_id" name="acc_id" required>
                        </div>
                        <div class="mb-3">
                            <label for="description" class="form-label">Comment</label>
                            <textarea class="form-control" id="description" name="description" rows="3" required></textarea>
                        </div>
                        <input type="hidden" name="prod_Id" value="${detail.id}">
                        <button type="submit" class="btn btn-primary">Submit Review</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
