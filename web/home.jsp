<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="https://fonts.googleapis.com/css?family=Montserrat:200,300,400,500,600,700,800&display=swap"
              rel="stylesheet">
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
        <link rel="icon" type="image/png" href="images/dog.png"">

    </head>
    <body>
        <!--header-->
        <%@include file="layout/UI/header_index.jsp" %>

        <!--pet_service-->
        <section class="ftco-section bg-light ftco-no-pt ftco-intro">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 d-flex align-self-stretch px-4 ftco-animate">
                        <div class="d-block services text-center">
                            <div class="icon d-flex align-items-center justify-content-center">
                                <span class="flaticon-blind"></span>
                            </div>
                            <div class="media-body">
                                <h3 class="heading">Relaxation</h3>
                                <p>Pet spa therapies often include a massage element, helping pets relax and reduce stress.
                                    This is particularly beneficial for pets with anxious or stressful personalities.</p>
                                <a href="#" class="btn-custom d-flex align-items-center justify-content-center"><span
                                        class="fa fa-chevron-right"></span><i class="sr-only">Read more</i></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 d-flex align-self-stretch px-4 ftco-animate">
                        <div class="d-block services text-center">
                            <div class="icon d-flex align-items-center justify-content-center">
                                <span class="flaticon-dog-eating"></span>
                            </div>
                            <div class="media-body">
                                <h3 class="heading">Health Booster</h3>
                                <p>Pet spa services not only help clean the surface of the pet but can also clean the fur and skin underneath.
                                    This removes dirt, bacteria, and dead skin cells, improving the pet's health and reducing the risk of skin infections.</p>
                                <a href="#" class="btn-custom d-flex align-items-center justify-content-center"><span
                                        class="fa fa-chevron-right"></span><i class="sr-only">Read more</i></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 d-flex align-self-stretch px-4 ftco-animate">
                        <div class="d-block services text-center">
                            <div class="icon d-flex align-items-center justify-content-center">
                                <span class="flaticon-grooming"></span>
                            </div>
                            <div class="media-body">
                                <h3 class="heading">Enhances Relationship</h3>
                                <p>Caring for pets through spa treatments also creates opportunities to enhance the bond between you and
                                    your pet. This intimate and thorough contact helps strengthen emotional connection and trust.</p>
                                <a href="#" class="btn-custom d-flex align-items-center justify-content-center"><span
                                        class="fa fa-chevron-right"></span><i class="sr-only">Read more</i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!--why choose us-->
        <section class="ftco-section ftco-no-pt ftco-no-pb">
            <div class="container">
                <div class="row d-flex no-gutters">
                    <div class="col-md-5 d-flex">
                        <div class="img img-video d-flex align-self-stretch align-items-center justify-content-center justify-content-md-center mb-4 mb-sm-0"
                             style="background-image:url(assets/Customer/images/about-1.jpg);">
                        </div>
                    </div>
                    <div class="col-md-7 pl-md-5 py-md-5">
                        <div class="heading-section pt-md-5">
                            <h2 class="mb-4">Why Choose Us?</h2>
                        </div>
                        <div class="row">
                            <div class="col-md-6 services-2 w-100 d-flex">
                                <div class="icon d-flex align-items-center justify-content-center"><span
                                        class="flaticon-stethoscope"></span></div>
                                <div class="text pl-3">
                                    <h4>Care Advices</h4>
                                    <p>Personalized care advice board offering insights on nutrition, behavior, and living environment for your pets.</p>
                                </div>
                            </div>
                            <div class="col-md-6 services-2 w-100 d-flex">
                                <div class="icon d-flex align-items-center justify-content-center"><span
                                        class="flaticon-customer-service"></span></div>
                                <div class="text pl-3">
                                    <h4>Customer Supports</h4>
                                    <p>Friendly and helpful staff ready to assist and address any inquiries, ensuring a smooth and comfortable shopping experience.</p>
                                </div>
                            </div>
                            <div class="col-md-6 services-2 w-100 d-flex">
                                <div class="icon d-flex align-items-center justify-content-center"><span
                                        class="flaticon-emergency-call"></span></div>
                                <div class="text pl-3">
                                    <h4>Emergency Services</h4>
                                    <p>Emergency services available to provide assistance in urgent situations such as pet injuries or emergencies.</p>
                                </div>
                            </div>
                            <div class="col-md-6 services-2 w-100 d-flex">
                                <div class="icon d-flex align-items-center justify-content-center"><span
                                        class="flaticon-veterinarian"></span></div>
                                <div class="text pl-3">
                                    <h4>Veterinary Help</h4>
                                    <p>Experienced veterinarians and attentive veterinary staff providing healthcare services for your pets.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!--feedback-->
        <section class="ftco-section testimony-section" style="background-image: url('assets/Customer/images/bg_2.jpg');">
            <div class="overlay"></div>
            <div class="container">
                <div class="row justify-content-center pb-5 mb-3">
                    <div class="col-md-7 heading-section text-center ftco-animate">
                        <h2>Happy Clients &amp; Feedbacks</h2>
                    </div>
                </div>
                <div class="row ftco-animate">
                    <div class="col-md-12">
                        <div class="carousel-testimony owl-carousel ftco-owl">
                            <div class="item">
                                <div class="testimony-wrap py-4">
                                    <div class="icon d-flex align-items-center justify-content-center"><span
                                            class="fa fa-quote-left"></span></div>
                                    <div class="text">
                                        <p class="mb-4">Far far away, behind the word mountains, far from the countries
                                            Vokalia and Consonantia, there live the blind texts.</p>
                                        <div class="d-flex align-items-center">
                                            <div class="user-img" style="background-image: url(assets/Customer/images/person_1.jpg)"></div>
                                            <div class="pl-3">
                                                <p class="name">Roger Scott</p>
                                                <span class="position">Marketing Manager</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="testimony-wrap py-4">
                                    <div class="icon d-flex align-items-center justify-content-center"><span
                                            class="fa fa-quote-left"></span></div>
                                    <div class="text">
                                        <p class="mb-4">Far far away, behind the word mountains, far from the countries
                                            Vokalia and Consonantia, there live the blind texts.</p>
                                        <div class="d-flex align-items-center">
                                            <div class="user-img" style="background-image: url(assets/Customer/images/person_2.jpg)"></div>
                                            <div class="pl-3">
                                                <p class="name">Roger Scott</p>
                                                <span class="position">Marketing Manager</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="testimony-wrap py-4">
                                    <div class="icon d-flex align-items-center justify-content-center"><span
                                            class="fa fa-quote-left"></span></div>
                                    <div class="text">
                                        <p class="mb-4">Far far away, behind the word mountains, far from the countries
                                            Vokalia and Consonantia, there live the blind texts.</p>
                                        <div class="d-flex align-items-center">
                                            <div class="user-img" style="background-image: url(assets/Customer/images/person_3.jpg)"></div>
                                            <div class="pl-3">
                                                <p class="name">Roger Scott</p>
                                                <span class="position">Marketing Manager</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="testimony-wrap py-4">
                                    <div class="icon d-flex align-items-center justify-content-center"><span
                                            class="fa fa-quote-left"></span></div>
                                    <div class="text">
                                        <p class="mb-4">Far far away, behind the word mountains, far from the countries
                                            Vokalia and Consonantia, there live the blind texts.</p>
                                        <div class="d-flex align-items-center">
                                            <div class="user-img" style="background-image: url(assets/Customer/images/person_1.jpg)"></div>
                                            <div class="pl-3">
                                                <p class="name">Roger Scott</p>
                                                <span class="position">Marketing Manager</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="testimony-wrap py-4">
                                    <div class="icon d-flex align-items-center justify-content-center"><span
                                            class="fa fa-quote-left"></span></div>
                                    <div class="text">
                                        <p class="mb-4">Far far away, behind the word mountains, far from the countries
                                            Vokalia and Consonantia, there live the blind texts.</p>
                                        <div class="d-flex align-items-center">
                                            <div class="user-img" style="background-image: url(assets/Customer/images/person_2.jpg)"></div>
                                            <div class="pl-3">
                                                <p class="name">Roger Scott</p>
                                                <span class="position">Marketing Manager</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!--News-->
        <section class="ftco-section bg-light">
            <div class="container">
                <div class="row justify-content-center pb-5 mb-3">
                    <div class="col-md-7 heading-section text-center ftco-animate">
                        <h2>News</h2>
                    </div>
                </div>
                <div class="row d-flex">
                    <div class="col-md-4 d-flex ftco-animate">
                        <div class="blog-entry align-self-stretch">
                            <a href="#" class="block-20 rounded" style="background-image: url('assets/Customer/images/image_1.jpg');">
                            </a>
                            <div class="text p-4">
                                <div class="meta mb-2">
                                    <div><a href="#">April 07, 2020</a></div>
                                    <div><a href="#">Admin</a></div>
                                    <div><a href="#" class="meta-chat"><span class="fa fa-comment"></span> 3</a></div>
                                </div>
                                <h3 class="heading"><a href="#">Even the all-powerful Pointing has no control about the blind texts</a>
                                </h3>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 d-flex ftco-animate">
                        <div class="blog-entry align-self-stretch">
                            <a href="#" class="block-20 rounded" style="background-image: url('assets/Customer/images/image_2.jpg');">
                            </a>
                            <div class="text p-4">
                                <div class="meta mb-2">
                                    <div><a href="#">April 07, 2020</a></div>
                                    <div><a href="#">Admin</a></div>
                                    <div><a href="#" class="meta-chat"><span class="fa fa-comment"></span> 3</a></div>
                                </div>
                                <h3 class="heading"><a href="#">Even the all-powerful Pointing has no control about the blind texts</a>
                                </h3>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 d-flex ftco-animate">
                        <div class="blog-entry align-self-stretch">
                            <a href="#" class="block-20 rounded" style="background-image: url('assets/Customer/images/image_3.jpg');">
                            </a>
                            <div class="text p-4">
                                <div class="meta mb-2">
                                    <div><a href="#">April 07, 2020</a></div>
                                    <div><a href="#">Admin</a></div>
                                    <div><a href="#" class="meta-chat"><span class="fa fa-comment"></span> 3</a></div>
                                </div>
                                <h3 class="heading"><a href="#">Even the all-powerful Pointing has no control about the blind texts</a>
                                </h3>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 d-flex ftco-animate">
                        <div class="blog-entry align-self-stretch">
                            <a href="#" class="block-20 rounded" style="background-image: url('assets/Customer/images/image_4.jpg');">
                            </a>
                            <div class="text p-4">
                                <div class="meta mb-2">
                                    <div><a href="#">April 07, 2020</a></div>
                                    <div><a href="#">Admin</a></div>
                                    <div><a href="#" class="meta-chat"><span class="fa fa-comment"></span> 3</a></div>
                                </div>
                                <h3 class="heading"><a href="#">Even the all-powerful Pointing has no control about the blind texts</a>
                                </h3>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 d-flex ftco-animate">
                        <div class="blog-entry align-self-stretch">
                            <a href="#" class="block-20 rounded" style="background-image: url('assets/Customer/images/image_5.jpg');">
                            </a>
                            <div class="text p-4">
                                <div class="meta mb-2">
                                    <div><a href="#">April 07, 2020</a></div>
                                    <div><a href="#">Admin</a></div>
                                    <div><a href="#" class="meta-chat"><span class="fa fa-comment"></span> 3</a></div>
                                </div>
                                <h3 class="heading"><a href="#">Even the all-powerful Pointing has no control about the blind texts</a>
                                </h3>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 d-flex ftco-animate">
                        <div class="blog-entry align-self-stretch">
                            <a href="#" class="block-20 rounded" style="background-image: url('assets/Customer/images/image_6.jpg');">
                            </a>
                            <div class="text p-4">
                                <div class="meta mb-2">
                                    <div><a href="#">April 07, 2020</a></div>
                                    <div><a href="#">Admin</a></div>
                                    <div><a href="#" class="meta-chat"><span class="fa fa-comment"></span> 3</a></div>
                                </div>
                                <h3 class="heading"><a href="#">Even the all-powerful Pointing has no control about the blind texts</a>
                                </h3>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!--Pets Gallery-->
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center pb-5 mb-3">
                    <div class="col-md-7 heading-section text-center ftco-animate">
                        <h2>Pets Gallery</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 ftco-animate">
                        <div class="work mb-4 img d-flex align-items-end"
                             style="background-image: url(assets/Customer/images/gallery-1.jpg);">
                            <a href="images/gallery-1.jpg"
                               class="icon image-popup d-flex justify-content-center align-items-center">
                                <span class="fa fa-expand"></span>
                            </a>
                            <div class="desc w-100 px-4">
                                <div class="text w-100 mb-3">
                                    <span>Cat</span>
                                    <h2><a href="work-single.html">Persian Cat</a></h2>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 ftco-animate">
                        <div class="work mb-4 img d-flex align-items-end"
                             style="background-image: url(assets/Customer/images/gallery-2.jpg);">
                            <a href="images/gallery-2.jpg"
                               class="icon image-popup d-flex justify-content-center align-items-center">
                                <span class="fa fa-expand"></span>
                            </a>
                            <div class="desc w-100 px-4">
                                <div class="text w-100 mb-3">
                                    <span>Dog</span>
                                    <h2><a href="work-single.html">Pomeranian</a></h2>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 ftco-animate">
                        <div class="work mb-4 img d-flex align-items-end"
                             style="background-image: url(assets/Customer/images/gallery-3.jpg);">
                            <a href="images/gallery-3.jpg"
                               class="icon image-popup d-flex justify-content-center align-items-center">
                                <span class="fa fa-expand"></span>
                            </a>
                            <div class="desc w-100 px-4">
                                <div class="text w-100 mb-3">
                                    <span>Cat</span>
                                    <h2><a href="work-single.html">Sphynx Cat</a></h2>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 ftco-animate">
                        <div class="work mb-4 img d-flex align-items-end"
                             style="background-image: url(assets/Customer/images/gallery-4.jpg);">
                            <a href="images/gallery-4.jpg"
                               class="icon image-popup d-flex justify-content-center align-items-center">
                                <span class="fa fa-expand"></span>
                            </a>
                            <div class="desc w-100 px-4">
                                <div class="text w-100 mb-3">
                                    <span>Cat</span>
                                    <h2><a href="work-single.html">British Shorthair</a></h2>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 ftco-animate">
                        <div class="work mb-4 img d-flex align-items-end"
                             style="background-image: url(assets/Customer/images/gallery-5.jpg);">
                            <a href="images/gallery-5.jpg"
                               class="icon image-popup d-flex justify-content-center align-items-center">
                                <span class="fa fa-expand"></span>
                            </a>
                            <div class="desc w-100 px-4">
                                <div class="text w-100 mb-3">
                                    <span>Dog</span>
                                    <h2><a href="work-single.html">Beagle</a></h2>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 ftco-animate">
                        <div class="work mb-4 img d-flex align-items-end"
                             style="background-image: url(assets/Customer/images/gallery-6.jpg);">
                            <a href="images/gallery-6.jpg"
                               class="icon image-popup d-flex justify-content-center align-items-center">
                                <span class="fa fa-expand"></span>
                            </a>
                            <div class="desc w-100 px-4">
                                <div class="text w-100 mb-3">
                                    <span>Dog</span>
                                    <h2><a href="work-single.html">Pug</a></h2>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!--footer-->
        <%@include file="layout/UI/footer.jsp" %>
    </body>
</html>
