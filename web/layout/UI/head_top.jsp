<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TOP HEAD</title>
    </head>
    <body>
        <div class="wrap">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 d-flex align-items-center">
                        <p class="mb-0 phone pl-md-2">
                            <a href="#" class="mr-2"><span class="fa fa-phone mr-1"></span> +00 1234 567</a>
                            <a href="#"><span class="fa fa-paper-plane mr-1"></span> petshop@email.com</a>
                        </p>
                    </div>
                    <div class="col-md-6 d-flex justify-content-md-end">
                        <div class="social-media">
                            <p class="mb-0 d-flex">
                                <a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-facebook"><i
                                            class="sr-only">Facebook</i></span></a>
                                <a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-twitter"><i
                                            class="sr-only">Twitter</i></span></a>
                                <a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-instagram"><i
                                            class="sr-only">Instagram</i></span></a>
                                <a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-dribbble"><i
                                            class="sr-only">Dribble</i></span></a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
            <div class="container">
                <a class="navbar-brand" href="home.jsp"><span class="flaticon-pawprint-1 mr-2"></span>PetShop</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav"
                        aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="fa fa-bars"></span>
                </button>
                <div class="collapse navbar-collapse" id="ftco-nav">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item"><a href="home" class="nav-link">Home</a></li>
                        <li class="nav-item"><a href="about.jsp" class="nav-link">About</a></li>
                        <li class="nav-item"><a href="product" class="nav-link">Product</a></li>
                        <li class="nav-item"><a href="petservice" class="nav-link">Service</a></li>
                        <li class="nav-item"><a href="blog.jsp" class="nav-link">Blog</a></li>
                        <li class="nav-item"><a href="contact.jsp" class="nav-link">Contact</a></li>
                        <li class="nav-item" style="margin-left: 100px">
                            <a  href="petServiceCalendar" class="nav-link">
                                <i class="fa-solid fa-calendar-days" ></i>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a  href="cart" class="nav-link">
                                <i class="fa-solid fa-cart-shopping"></i>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a  href="profile" class="nav-link">
                                <i class="fa-solid fa-user"></i>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


        <script>
            // JavaScript to set the active class based on the current URL
            document.addEventListener("DOMContentLoaded", function () {
                var currentPage = window.location.pathname.split("/").pop();
                var navLinks = document.querySelectorAll(".navbar-nav .nav-item");

                navLinks.forEach(function (navItem) {
                    var link = navItem.querySelector("a");
                    navItem.classList.remove("active");
                    if (link.getAttribute("href") === currentPage) {
                        navItem.classList.add("active");
                    }
                });

            });
        </script>
    </body>
</html>
