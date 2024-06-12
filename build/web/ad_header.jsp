 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <title>Focus - Bootstrap Admin Dashboard </title>
        <!-- Favicon icon -->

    </style>


</head>

<body>

    <!--*******************
        Preloader start
    ********************-->
    <div id="preloader">
        <div class="sk-three-bounce">
            <div class="sk-child sk-bounce1"></div>
            <div class="sk-child sk-bounce2"></div>
            <div class="sk-child sk-bounce3"></div>
        </div>
    </div>
    <!--*******************
        Preloader end
    ********************-->


    <!--**********************************
        Main wrapper start
    ***********************************-->
    <div id="main-wrapper">

        <!--**********************************
            Nav header start
        ***********************************-->
        <div class="nav-header">
            <a href="admin" class="brand-logo">
                <img class="logo-abbr" src="./images/logo1.png" alt="">
                <span class="nav-text">Pet Shop</span>
            </a>

            
        </div>
        <!--**********************************
            Nav header end
        ***********************************-->

        <!--**********************************
            Header start
        ***********************************-->
        <div class="header">
            <div class="header-content">
                <nav class="navbar navbar-expand">
                    <div class="collapse navbar-collapse justify-content-between">
                        <div class="header-left">
                           
                        </div>

                        <ul class="navbar-nav header-right">

                            <li class="nav-item dropdown header-profile">
                                <a class="nav-link" href="#" role="button" data-toggle="dropdown">
                                    <i class="mdi mdi-account"></i>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right">
                                    <a href="./app-profile.html" class="dropdown-item">
                                        <i class="icon-user"></i>
                                        <span class="ml-2">Profile </span>
                                    </a>
                                    <a href="./email-inbox.html" class="dropdown-item">
                                        <i class="icon-envelope-open"></i>
                                        <span class="ml-2">Inbox </span>
                                    </a>
                                    <a href="adlogout" class="dropdown-item">
                                        <i class="icon-key"></i>
                                        <span class="ml-2">Logout </span>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
        <!--**********************************
            Header end ti-comment-alt
        ***********************************-->
        <div class="quixnav">
            <div class="quixnav-scroll">
                <ul class="metismenu" id="menu">
                    <li class="nav-label first">Revenue Statistic</li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false"><i
                                class="icon icon-single-04"></i><span class="nav-text">Revenue Statistic</span></a>
                        <ul aria-expanded="false">
                            <li><a href="admin">Revenue Statistic</a></li>
                        </ul>
                    </li>
                    <li class="nav-label">Account Management</li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false"><i
                                class="icon icon-single-04"></i><span class="nav-text">Staff</span></a>
                        <ul aria-expanded="false">
                            <li><a href="${pageContext.request.contextPath}/adstaff">List Staff</a></li>
                            <li><a href="${pageContext.request.contextPath}/addstaff">Create Staff</a></li>
                        </ul>
                    </li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false"><i
                                class="icon icon-app-store"></i><span class="nav-text">Customer</span></a>
                        <ul aria-expanded="false">
                            <li><a href="${pageContext.request.contextPath}/adcustomer">List Customer</a</li>
                            <li><a href="${pageContext.request.contextPath}/sendemail">Send Email</a></li>
                        </ul>
                    </li>
                    <li class="nav-label">Product Management</li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false"><i
                                class="icon icon-world-2"></i><span class="nav-text">Product</span></a>
                        <ul aria-expanded="false">
                            <li><a href="${pageContext.request.contextPath}/adproduct">List Product</a></li>
                            <li><a href="${pageContext.request.contextPath}/addproduct">Create Product</a></li>
                        </ul>
                    </li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false"><i
                                class="icon icon-plug"></i><span class="nav-text">Coupon</span></a>
                        <ul aria-expanded="false">
                            <li><a href="${pageContext.request.contextPath}/adcoupon">List Coupon</a></li>
                            <li><a href="${pageContext.request.contextPath}/addcoupon">Add Coupon</a></li>

                        </ul>
                    </li>
                    <li class="nav-label">Service Management</li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false"><i
                                class="icon icon-form"></i><span class="nav-text">Service</span></a>
                        <ul aria-expanded="false">
                            <li><a href="${pageContext.request.contextPath}/adservice">List Service</a></li>
                            <li><a href="${pageContext.request.contextPath}/addservice">Create Service</a></li>    
                        </ul>
                    </li>
                    <li class="nav-label">Order</li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false"><i
                                class="icon icon-layout-25"></i><span class="nav-text">Order Product</span></a>
                        <ul aria-expanded="false">
                            <li><a href="orderproduct">Order History</a></li>
                        </ul>
                    </li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false"><i
                                class="icon icon-layout-25"></i><span class="nav-text">Order Service</span></a>
                        <ul aria-expanded="false">
                            <li><a href="orderservice">Order History</a></li>
                        </ul>
                    </li>
                    <li class="nav-label">Time Sale</li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false"><i
                                class="icon icon-layout-25"></i><span class="nav-text">Time sale</span></a>
                        <ul aria-expanded="false">
                            <li><a href="timesale">Edit time</a></li>
                        </ul>
                    </li>
                    
                </ul>
            </div>
        </div>
    </div>



</body>

</html>