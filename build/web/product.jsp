<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.Product"%>
<%@page import="model.Product_Detail"%>
<%@page import="model.Category"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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


    </head>
    <body>
        <!--header-->
        <%@ include file="layout/UI/header_product.jsp" %>
        <form action="search" method="post" class="form-inline my-2 my-lg-0">
            <div class="input-group input-group-sm" style="margin-left: 1200px;padding-top:30px; margin-bottom: -250px  ">
                <input oninput="searchByName(this)" value="${txtS}" name="txt" type="text" class="form-control" aria-label="Search" aria-describedby="search-addon" value="${save}">
                <div class="input-group-append">
                    <button type="submit" class="btn btn-secondary btn-number">
                        <i class="fa fa-search"></i>
                    </button>
                </div>
            </div>
        </form>
        <!-- Page header with Products title -->




        <div class="container mydiv">
            <div class="row">
                <div class="content col-md-2">
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
                        <ul class="list-group category_block">
                            <c:forEach  var="c" items="${listCC}"   >
                                <li class="list-group-item text-white ${tag == c.category_id ? "active":""}"><a href="category?cid=${c.category_id}">${c.name}</a></li>
                                </c:forEach>
                        </ul>
                    </div>

                </div>
                <div class="sidebar col-md-10">
                    <div class="row">
                        <c:forEach var="p" items="${listP}">
                            <div class="col-md-4 mb-4">
                                <div class="bbb_deals">
                                    <div class="ribbon ribbon-top-right"><span><small class="cross">x </small>${p.quantity}</span></div>
                                    <div class="bbb_deals_title">Today's Combo Offer</div>
                                    <div class="bbb_deals_slider_container">
                                        <div class="bbb_deals_item">
                                            <div class="bbb_deals_image">
                                                <a href="detail?pid=${p.prodId}">
                                                    <img src="${p.imageProduct}" alt="" class="product-img">
                                                </a>
                                            </div>
                                            <div class="bbb_deals_content">
                                                <div class="bbb_deals_info_line d-flex flex-row justify-content-start">
                                                    <div class="bbb_deals_item_category"><a href="#">${p.cateId.name}</a></div>
                                                    <div class="bbb_deals_item_price_a ml-auto"><strike>${p.productDetail.price}</strike></div>
                                                </div>
                                                <div class="bbb_deals_info_line d-flex flex-row justify-content-start">
                                                    <div class="bbb_deals_item_name"><a href="detail?pid=${p.prodId}">${p.nameP}</a></div>
                                                    <div class="bbb_deals_item_price ml-auto">${p.productDetail.price}  </div>
                                                </div>

                                            </div>
                                            <div class="available">
                                                <div class="available_line d-flex flex-row justify-content-start">

                                                    <a href="detail?pid=${p.prodId}" class="btn btn-primary btn-equal">View Detail</a>
                                                </div>
                                                <div class="available_bar"><span style="width:13%"></span></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <style>
            .mydiv {
                display: flex;
                flex-wrap: wrap;
                margin-top: 20%;
                margin-bottom: 50px;
            }
            .cross {
                font-size: 10px;
            }
            .padding-0 {
                padding-right: 5px;
                padding-left: 5px;
            }
            .img-style {
                margin-left: -11px;
                box-shadow: 1px 1px 5px 1px rgba(0, 0, 0, 0.1);
                border-radius: 5px;
                max-width: 104% !important;
            }
            .m-t-20 {
                margin-top: 20px;
            }
            .bbb_background {
                background-color: #E0E0E0 !important;
            }
            .ribbon {
                width: 150px;
                height: 150px;
                overflow: hidden;
                position: absolute;
            }
            .ribbon span {
                position: absolute;
                display: block;
                width: 34px;
                border-radius: 50%;
                padding: 8px 0;
                background-color: #3498db;
                box-shadow: 0 5px 10px rgba(0, 0, 0, .1);
                color: #fff;
                font: 100 18px/1 'Lato', sans-serif;
                text-shadow: 0 1px 1px rgba(0, 0, 0, .2);
                text-transform: uppercase;
                text-align: center;
            }
            .ribbon-top-right {
                top: -10px;
                right: -10px;
            }
            .ribbon-top-right::before,
            .ribbon-top-right::after {
                border-top-color: transparent;
                border-right-color: transparent;
            }
            .ribbon-top-right::before {
                top: 0;
                left: 17px;
            }
            .ribbon-top-right::after {
                bottom: 17px;
                right: 0;
            }
            .sold_stars i {
                color: orange;
            }
            .ribbon-top-right span {
                right: 17px;
                top: 17px;
            }
            div {
                display: block;
                position: relative;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                box-sizing: border-box;
            }
            .bbb_deals_featured {
                width: 100%;
            }
            .bbb_deals {
                width: 300px;
                height: 500px;
                margin-right: 1000px;
                padding-top: 80px;
                padding-left: 25px;
                padding-right: 25px;
                padding-bottom: 34px;
                box-shadow: 1px 1px 5px 1px rgba(0, 0, 0, 0.1);
                border-radius: 5px;
                margin-top: 0;
                margin-bottom: 15px;
                position: relative;
                overflow: hidden;
            }
            .bbb_deals_title {
                position: absolute;
                top: 10px;
                left: 22px;
                font-size: 18px;
                font-weight: 500;
                color: #000000;
            }
            .bbb_deals_slider_container {
                width: 100%;
            }
            .bbb_deals_item {
                width: 100%;
                background: #FFFFFF;
                border-radius: 5px;
                padding-top: 23px;
                padding-left: 23px;
                padding-right: 23px;
                padding-bottom: 25px;
                box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.1);
                position: relative;
            }
            .bbb_deals_image {
                width: 150px;
                height: 150px;
            }
            .product-img {
                width: 100%;
                height: 100%;
                object-fit: contain;
            }
            .bbb_deals_content {
                margin-top: 33px;
            }
            .bbb_deals_item_category a {
                font-size: 14px;
                font-weight: 400;
                color: rgba(0, 0, 0, 0.5);
            }
            .bbb_deals_item_price_a {
                font-size: 14px;
                font-weight: 400;
                color: rgba(0, 0, 0, 0.6);
            }
            .bbb_deals_item_price_a strike {
                color: red;
            }
            .bbb_deals_item_name {
                font-size: 19px;
                font-weight: 400;
                color: #000000;
            }
            .bbb_deals_item_price {
                font-size: 24px;
                font-weight: 500;
                color: #6d6e73;
            }
            .available {
                margin-top: 10px;
                font-size: 8px;
            }
            .available_title {
                font-size: 14px;
                color: rgba(0, 0, 0, 0.5);
                font-weight: 400;
            }
            .available_title span {
                font-weight: 700;
            }
            .available_line {
                display: flex;
                flex-wrap: wrap; /* Allow buttons to wrap if they don't fit in a single line */
                justify-content: space-between; /* Distribute buttons evenly within the available space */
            }
            @media only screen and (max-width: 991px) {
                .bbb_deals {
                    width: 100%;
                    margin-right: 0px;
                }
            }
            @media only screen and (max-width: 575px) {
                .bbb_deals {
                    padding-left: 15px;
                    padding-right: 15px;
                }
                .bbb_deals_title {
                    left: 15px;
                    font-size: 16px;
                }
                .bbb_deals_slider_nav_container {
                    right: 5px;
                }
                .bbb_deals_item_name,
                .bbb_deals_item_price {
                    font-size: 20px;
                }
            }
            .btn {
                display: inline-block;
                padding: 0.375rem 0.75rem;
                font-size: 1rem;
                font-weight: 400;
                line-height: 1.5;
                text-align: center;
                white-space: nowrap;
                vertical-align: middle;
                user-select: none;
                border: 1px solid transparent;
                border-radius: 0.25rem;
                transition: color 0.15s ease-in-out, background-color 0.15s ease-in-out, border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
            }
            .btn-primary {
                color: #fff;
                background-color: #007bff;
                border-color: #007bff;
            }
            .btn-primary:hover {
                color: #fff;
                background-color: #0069d9;
                border-color: #0062cc;
            }
            .btn-danger {
                color: #fff;
                background-color: #dc3545;
                border-color: #dc3545;
            }
            .btn-danger:hover {
                color: #fff;
                background-color: #c82333;
                border-color: #bd2130;
            }
            .mr-1 {
                margin-right: 5px;
            }
            .search-bar {
                display: flex;
                align-items: center;
                margin-bottom: 20px;
            }
            .search-input {
                padding: 8px;
                border: 1px solid #ccc;
                border-radius: 4px;
                margin-right: 5px;
            }
            .search-btn {
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 4px;
                padding: 8px 12px;
                cursor: pointer;
            }
            .search-btn i {
                font-size: 16px;
            }
            .btn-equal {
                width: 100%; /* Adjust as needed to fit within container */
                height: 30px; /* Adjust height if needed */
                padding: 5px 8px; /* Adjust padding to accommodate text */
                font-size: 12px; /* Reduce font size for better fit */
                text-align: center; /* Center text within buttons */
                margin-top: 15px
            }
        </style>
    </body>
</html>