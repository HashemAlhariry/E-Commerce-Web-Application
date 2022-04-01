<!DOCTYPE html>
<html lang="en" dir="ltr">


<!-- molla/about.html  22 Nov 2019 10:03:51 GMT -->
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Molla - Bootstrap eCommerce Template</title>
    <meta name="keywords" content="HTML5 Template">
    <meta name="description" content="Molla - Bootstrap eCommerce Template">
    <meta name="author" content="p-themes">
    <!-- Favicon -->
    <link rel="apple-touch-icon" sizes="180x180" href="assets/images/icons/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="assets/images/icons/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="assets/images/icons/favicon-16x16.png">
    <link rel="manifest" href="assets/images/icons/site.html">
    <link rel="mask-icon" href="assets/images/icons/safari-pinned-tab.svg" color="#666666">
    <link rel="shortcut icon" href="assets/images/icons/favicon.ico">
    <meta name="apple-mobile-web-app-title" content="Molla">
    <meta name="application-name" content="Molla">
    <meta name="msapplication-TileColor" content="#cc9966">
    <meta name="msapplication-config" content="assets/images/icons/browserconfig.xml">
    <meta name="theme-color" content="#ffffff">
    <!-- Plugins CSS File -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/plugins/owl-carousel/owl.carousel.css">
    <link rel="stylesheet" href="assets/css/plugins/magnific-popup/magnific-popup.css">
    <link rel="stylesheet" href="assets/css/plugins/jquery.countdown.css">
    <!-- Main CSS File -->
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/skins/skin-demo-4.css">
    <link rel="stylesheet" href="assets/css/demos/demo-4.css">

    <script src="assets/js/amazonya/cookie-checker.js"></script>
</head>

<body>
<div class="page-wrapper">
    <%@ include file="includes/header.jsp" %>

    <main class="main">
        <nav aria-label="breadcrumb" class="breadcrumb-nav border-0 mb-0">
            <div class="container">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                    <li class="breadcrumb-item"><a href="#">Pages</a></li>
                    <li class="breadcrumb-item active" aria-current="page">About us</li>
                </ol>
            </div><!-- End .container -->
        </nav><!-- End .breadcrumb-nav -->
        <div class="container">
            <div class="page-header page-header-big text-center" style="background-image: url('data:image/jpeg;base64,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')">
                <h1 class="page-title text-white">QS<span class="text-white"></span></h1>
            </div><!-- End .page-header -->
        </div><!-- End .container -->

        <div class="page-content pb-0">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 mb-3 mb-lg-0">
<%--                        <h2 class="title">QA part </h2><!-- End .title -->--%>
                        <br>
                        <p>How can i get data set regarding smart home and green house gas emssion from smart homes?</p>
                        <p>I strongly recommend you use secondary data and, after that, justify why you opted for secondary research. Ojo Ademola, on one of his questions on Secondary Research, made such a justification. Kindly check it out!</p>
                        </br>

                        <br>
                        <p>Why does my laptop fan turn on?</p>
                        <p>Laptops are designed to be compact. Their sleek design makes them easily portable but also creates challenges when managing heat. Because the components inside a laptop are tightly packed together, they can heat up easily. Airflow inside the laptop is essential to keep the components from overheating.</p>
                        </br>

                        <br>
                        <p>Why has my laptop gotten slower?</p>
                        <p>It seems inevitable. Over time, computers get slower. Sometimes it just feels that way since other devices get faster, but it is also possible that your laptop has actually gotten slower since you first started using it. Below are a few reasons why the slowdown may have occurred, along with possible solutions.</p>
                        </br>

                        <br>
                        <p>What Is A Smartwatch?</p>
                        <p>Smartwatch of today is basically a smartphone that you wear on your wrist like a normal watch. While early models could perform basic tasks, 2010s smartwatches have more general functionality closer to smartphones, including mobile apps, a mobile operating system and WiFi/Bluetooth connectivity.</p>
                   </br>

                        <br>
                        <p>Do You Really Need A Smartwatch?</p>
                        <p>If you have survived this long without one, then no, you don’t need one. The same question can apply to a normal watch. Do you need to wear a watch that only tells the time in the age when we are surrounded by screens ranging from monitors to mobile phones and you can know what the time is in a second. Still, plenty of people wear watches as status symbols, as fashion accessories or just because they look great. All of these are valid reasons for a person to wear a watch.</p>
                     </br>
                    </div>
                </div>
            </div><!-- End .col-lg-6 -->

        </div><!-- End .container -->

        <%--            <div class="bg-light-2 pt-6 pb-5 mb-6 mb-lg-8">--%>
        <%--                <div class="container">--%>
        <%--                    <div class="row">--%>
        <%--                        <div class="col-lg-5 mb-3 mb-lg-0">--%>
        <%--                            <h2 class="title">Who We Are</h2><!-- End .title -->--%>
        <%--                            <p class="lead text-primary mb-3">Pellentesque odio nisi, euismod pharetra a ultricies <br>in diam. Sed arcu. Cras consequat</p><!-- End .lead text-primary -->--%>
        <%--                            <p class="mb-2">Sed pretium, ligula sollicitudin laoreet viverra, tortor libero sodales leo, eget blandit nunc tortor eu nibh. Suspendisse potenti. Sed egestas, ante et vulputate volutpat, uctus metus libero eu augue. </p>--%>

        <%--                            <a href="blog.html" class="btn btn-sm btn-minwidth btn-outline-primary-2">--%>
        <%--                                <span>VIEW OUR NEWS</span>--%>
        <%--                                <i class="icon-long-arrow-right"></i>--%>
        <%--                            </a>--%>
        <%--                        </div><!-- End .col-lg-5 -->--%>

        <%--                        <div class="col-lg-6 offset-lg-1">--%>
        <%--                            <div class="about-images">--%>
        <%--                                <img src="assets/images/about/img-1.jpg" alt="" class="about-img-front">--%>
        <%--                                <img src="assets/images/about/img-2.jpg" alt="" class="about-img-back">--%>
        <%--                            </div><!-- End .about-images -->--%>
        <%--                        </div><!-- End .col-lg-6 -->--%>
        <%--                    </div><!-- End .row -->--%>
        <%--                </div><!-- End .container -->--%>
</div><!-- End .bg-light-2 pt-6 pb-6 -->

<%--            <div class="container">--%>
<%--                <div class="row">--%>
<%--                    <div class="col-lg-5">--%>
<%--                        <div class="brands-text">--%>
<%--                            <h2 class="title">The world's premium design brands in one destination.</h2><!-- End .title -->--%>
<%--                            <p>Phasellus hendrerit. Pellentesque aliquet nibh nec urna. In nisi neque, aliquet vel, dapibus id, mattis vel, nis</p>--%>
<%--                        </div><!-- End .brands-text -->--%>
<%--                    </div><!-- End .col-lg-5 -->--%>
<%--                    <div class="col-lg-7">--%>
<%--                        <div class="brands-display">--%>
<%--                            <div class="row justify-content-center">--%>
<%--                                <div class="col-6 col-sm-4">--%>
<%--                                    <a href="#" class="brand">--%>
<%--                                        <img src="assets/images/brands/1.png" alt="Brand Name">--%>
<%--                                    </a>--%>
<%--                                </div><!-- End .col-sm-4 -->--%>

<%--                                <div class="col-6 col-sm-4">--%>
<%--                                    <a href="#" class="brand">--%>
<%--                                        <img src="assets/images/brands/2.png" alt="Brand Name">--%>
<%--                                    </a>--%>
<%--                                </div><!-- End .col-sm-4 -->--%>

<%--                                <div class="col-6 col-sm-4">--%>
<%--                                    <a href="#" class="brand">--%>
<%--                                        <img src="assets/images/brands/3.png" alt="Brand Name">--%>
<%--                                    </a>--%>
<%--                                </div><!-- End .col-sm-4 -->--%>

<%--                                <div class="col-6 col-sm-4">--%>
<%--                                    <a href="#" class="brand">--%>
<%--                                        <img src="assets/images/brands/4.png" alt="Brand Name">--%>
<%--                                    </a>--%>
<%--                                </div><!-- End .col-sm-4 -->--%>

<%--                                <div class="col-6 col-sm-4">--%>
<%--                                    <a href="#" class="brand">--%>
<%--                                        <img src="assets/images/brands/5.png" alt="Brand Name">--%>
<%--                                    </a>--%>
<%--                                </div><!-- End .col-sm-4 -->--%>

<%--                                <div class="col-6 col-sm-4">--%>
<%--                                    <a href="#" class="brand">--%>
<%--                                        <img src="assets/images/brands/6.png" alt="Brand Name">--%>
<%--                                    </a>--%>
<%--                                </div><!-- End .col-sm-4 -->--%>

<%--                                <div class="col-6 col-sm-4">--%>
<%--                                    <a href="#" class="brand">--%>
<%--                                        <img src="assets/images/brands/7.png" alt="Brand Name">--%>
<%--                                    </a>--%>
<%--                                </div><!-- End .col-sm-4 -->--%>

<%--                                <div class="col-6 col-sm-4">--%>
<%--                                    <a href="#" class="brand">--%>
<%--                                        <img src="assets/images/brands/8.png" alt="Brand Name">--%>
<%--                                    </a>--%>
<%--                                </div><!-- End .col-sm-4 -->--%>

<%--                                <div class="col-6 col-sm-4">--%>
<%--                                    <a href="#" class="brand">--%>
<%--                                        <img src="assets/images/brands/9.png" alt="Brand Name">--%>
<%--                                    </a>--%>
<%--                                </div><!-- End .col-sm-4 -->--%>
<%--                            </div><!-- End .row -->--%>
<%--                        </div><!-- End .brands-display -->--%>
<%--                    </div><!-- End .col-lg-7 -->--%>
<%--                </div><!-- End .row -->--%>

<%--<hr class="mt-4 mb-6">--%>

<%--<h2 class="title text-center mb-4">Meet Our Team</h2><!-- End .title text-center mb-2 -->--%>

<%--<div class="row">--%>
<%--    <div class="col-md-4">--%>
<%--        <div class="member member-anim text-center">--%>
<%--            <figure class="member-media">--%>
<%--                <img src="assets/images/team/member-1.jpg" alt="member photo">--%>

<%--                <figcaption class="member-overlay">--%>
<%--                    <div class="member-overlay-content">--%>
<%--                        <h3 class="member-title">Samanta Grey<span>Founder & CEO</span></h3><!-- End .member-title -->--%>
<%--                        <p>Sed pretium, ligula sollicitudin viverra, tortor libero sodales leo, eget blandit nunc.</p>--%>
<%--                        <div class="social-icons social-icons-simple">--%>
<%--                            <a href="#" class="social-icon" title="Facebook" target="_blank"><i class="icon-facebook-f"></i></a>--%>
<%--                            <a href="#" class="social-icon" title="Twitter" target="_blank"><i class="icon-twitter"></i></a>--%>
<%--                            <a href="#" class="social-icon" title="Instagram" target="_blank"><i class="icon-instagram"></i></a>--%>
<%--                        </div><!-- End .soial-icons -->--%>
<%--                    </div><!-- End .member-overlay-content -->--%>
<%--                </figcaption><!-- End .member-overlay -->--%>
<%--            </figure><!-- End .member-media -->--%>
<%--            <div class="member-content">--%>
<%--                <h3 class="member-title">Samanta Grey<span>Founder & CEO</span></h3><!-- End .member-title -->--%>
<%--            </div><!-- End .member-content -->--%>
<%--        </div><!-- End .member -->--%>
<%--    </div><!-- End .col-md-4 -->--%>

<%--    <div class="col-md-4">--%>
<%--        <div class="member member-anim text-center">--%>
<%--            <figure class="member-media">--%>
<%--                <img src="assets/images/team/member-2.jpg" alt="member photo">--%>

<%--                <figcaption class="member-overlay">--%>
<%--                    <div class="member-overlay-content">--%>
<%--                        <h3 class="member-title">Bruce Sutton<span>Sales & Marketing Manager</span></h3><!-- End .member-title -->--%>
<%--                        <p>Sed pretium, ligula sollicitudin viverra, tortor libero sodales leo, eget blandit nunc.</p>--%>
<%--                        <div class="social-icons social-icons-simple">--%>
<%--                            <a href="#" class="social-icon" title="Facebook" target="_blank"><i class="icon-facebook-f"></i></a>--%>
<%--                            <a href="#" class="social-icon" title="Twitter" target="_blank"><i class="icon-twitter"></i></a>--%>
<%--                            <a href="#" class="social-icon" title="Instagram" target="_blank"><i class="icon-instagram"></i></a>--%>
<%--                        </div><!-- End .soial-icons -->--%>
<%--                    </div><!-- End .member-overlay-content -->--%>
<%--                </figcaption><!-- End .member-overlay -->--%>
<%--            </figure><!-- End .member-media -->--%>
<%--            <div class="member-content">--%>
<%--                <h3 class="member-title">Bruce Sutton<span>Sales & Marketing Manager</span></h3><!-- End .member-title -->--%>
<%--            </div><!-- End .member-content -->--%>
<%--        </div><!-- End .member -->--%>
<%--    </div><!-- End .col-md-4 -->--%>

<%--    <div class="col-md-4">--%>
<%--        <div class="member member-anim text-center">--%>
<%--            <figure class="member-media">--%>
<%--                <img src="assets/images/team/member-3.jpg" alt="member photo">--%>

<%--                <figcaption class="member-overlay">--%>
<%--                    <div class="member-overlay-content">--%>
<%--                        <h3 class="member-title">Janet Joy<span>Product Manager</span></h3><!-- End .member-title -->--%>
<%--                        <p>Sed pretium, ligula sollicitudin viverra, tortor libero sodales leo, eget blandit nunc.</p>--%>
<%--                        <div class="social-icons social-icons-simple">--%>
<%--                            <a href="#" class="social-icon" title="Facebook" target="_blank"><i class="icon-facebook-f"></i></a>--%>
<%--                            <a href="#" class="social-icon" title="Twitter" target="_blank"><i class="icon-twitter"></i></a>--%>
<%--                            <a href="#" class="social-icon" title="Instagram" target="_blank"><i class="icon-instagram"></i></a>--%>
<%--                        </div><!-- End .soial-icons -->--%>
<%--                    </div><!-- End .member-overlay-content -->--%>
<%--                </figcaption><!-- End .member-overlay -->--%>
<%--            </figure><!-- End .member-media -->--%>
<%--            <div class="member-content">--%>
<%--                <h3 class="member-title">Janet Joy<span>Product Manager</span></h3><!-- End .member-title -->--%>
<%--            </div><!-- End .member-content -->--%>
<%--        </div><!-- End .member -->--%>
<%--    </div><!-- End .col-md-4 -->--%>
<%--</div><!-- End .row -->--%>
<%--</div><!-- End .container -->--%>

<%--<div class="mb-2"></div><!-- End .mb-2 -->--%>

<%--<div class="about-testimonials bg-light-2 pt-6 pb-6">--%>
<%--    <div class="container">--%>
<%--        <h2 class="title text-center mb-3">What Customer Say About Us</h2><!-- End .title text-center -->--%>

<%--        <div class="owl-carousel owl-simple owl-testimonials-photo" data-toggle="owl"--%>
<%--             data-owl-options='{--%>
<%--                                "nav": false,--%>
<%--                                "dots": true,--%>
<%--                                "margin": 20,--%>
<%--                                "loop": false,--%>
<%--                                "responsive": {--%>
<%--                                    "1200": {--%>
<%--                                        "nav": true--%>
<%--                                    }--%>
<%--                                }--%>
<%--                            }'>--%>
<%--            <blockquote class="testimonial text-center">--%>
<%--                &lt;%&ndash;                            <img src="assets/images/testimonials/user-1.jpg" alt="user">&ndash;%&gt;--%>
<%--                <p>“ Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Pellentesque aliquet nibh nec urna. <br>In nisi neque, aliquet vel, dapibus id, mattis vel, nisi. Sed pretium, ligula sollicitudin laoreet viverra, tortor libero sodales leo, eget blandit nunc tortor eu nibh. Nullam mollis. Ut justo. Suspendisse potenti. ”</p>--%>
<%--                <cite>--%>
<%--                    Jenson Gregory--%>
<%--                    <span>Customer</span>--%>
<%--                </cite>--%>
<%--            </blockquote><!-- End .testimonial -->--%>

<%--            <blockquote class="testimonial text-center">--%>
<%--                <img src="assets/images/testimonials/user-2.jpg" alt="user">--%>
<%--                <p>“ Impedit, ratione sequi, sunt incidunt magnam et. Delectus obcaecati optio eius error libero perferendis nesciunt atque dolores magni recusandae! Doloremque quidem error eum quis similique doloribus natus qui ut ipsum.Velit quos ipsa exercitationem, vel unde obcaecati impedit eveniet non. ”</p>--%>

<%--                <cite>--%>
<%--                    Victoria Ventura--%>
<%--                    <span>Customer</span>--%>
<%--                </cite>--%>
<%--            </blockquote><!-- End .testimonial -->--%>
<%--        </div><!-- End .testimonials-slider owl-carousel -->--%>
<%--    </div><!-- End .container -->--%>
<%--</div><!-- End .bg-light-2 pt-5 pb-6 -->--%>
<%--</div><!-- End .page-content -->--%>
<%--</main><!-- End .main -->--%>

<%@ include file="includes/footer.jsp" %><!-- End .footer -->
</div><!-- End .page-wrapper -->
<button id="scroll-top" title="Back to Top"><i class="icon-arrow-up"></i></button>

<!-- Mobile Menu -->
<div class="mobile-menu-overlay"></div><!-- End .mobil-menu-overlay -->

<div class="mobile-menu-container">
    <div class="mobile-menu-wrapper">
        <span class="mobile-menu-close"><i class="icon-close"></i></span>

        <form action="#" method="get" class="mobile-search">
            <label for="mobile-search" class="sr-only">Search</label>
            <input type="search" class="form-control" name="mobile-search" id="mobile-search" placeholder="Search in..." required>
            <button class="btn btn-primary" type="submit"><i class="icon-search"></i></button>
        </form>

        <nav class="mobile-nav">
            <ul class="mobile-menu">
                <li class="active">
                    <a href="index.html">Home</a>

                    <ul>
                        <li><a href="index-1.html">01 - furniture store</a></li>
                        <li><a href="index-2.html">02 - furniture store</a></li>
                        <li><a href="index-3.html">03 - electronic store</a></li>
                        <li><a href="index-4.html">04 - electronic store</a></li>
                        <li><a href="index-5.html">05 - fashion store</a></li>
                        <li><a href="index-6.html">06 - fashion store</a></li>
                        <li><a href="index-7.html">07 - fashion store</a></li>
                        <li><a href="index-8.html">08 - fashion store</a></li>
                        <li><a href="index-9.html">09 - fashion store</a></li>
                        <li><a href="index-10.html">10 - shoes store</a></li>
                        <li><a href="index-11.html">11 - furniture simple store</a></li>
                        <li><a href="index-12.html">12 - fashion simple store</a></li>
                        <li><a href="index-13.html">13 - market</a></li>
                        <li><a href="index-14.html">14 - market fullwidth</a></li>
                        <li><a href="index-15.html">15 - lookbook 1</a></li>
                        <li><a href="index-16.html">16 - lookbook 2</a></li>
                        <li><a href="index-17.html">17 - fashion store</a></li>
                        <li><a href="index-18.html">18 - fashion store (with sidebar)</a></li>
                        <li><a href="index-19.html">19 - games store</a></li>
                        <li><a href="index-20.html">20 - book store</a></li>
                        <li><a href="index-21.html">21 - sport store</a></li>
                        <li><a href="index-22.html">22 - tools store</a></li>
                        <li><a href="index-23.html">23 - fashion left navigation store</a></li>
                        <li><a href="index-24.html">24 - extreme sport store</a></li>
                    </ul>
                </li>
                <li>
                    <a href="category.html">Shop</a>
                    <ul>
                        <li><a href="category-list.html">Shop List</a></li>
                        <li><a href="category-2cols.html">Shop Grid 2 Columns</a></li>
                        <li><a href="category.html">Shop Grid 3 Columns</a></li>
                        <li><a href="category-4cols.html">Shop Grid 4 Columns</a></li>
                        <li><a href="category-boxed.html"><span>Shop Boxed No Sidebar<span class="tip tip-hot">Hot</span></span></a></li>
                        <li><a href="category-fullwidth.html">Shop Fullwidth No Sidebar</a></li>
                        <li><a href="product-category-boxed.html">Product Category Boxed</a></li>
                        <li><a href="product-category-fullwidth.html"><span>Product Category Fullwidth<span class="tip tip-new">New</span></span></a></li>
                        <li><a href="cart.html">Cart</a></li>
                        <li><a href="checkout.html">Checkout</a></li>
                        <li><a href="wishlist.html">Wishlist</a></li>
                        <li><a href="#">Lookbook</a></li>
                    </ul>
                </li>
                <li>
                    <a href="product.html" class="sf-with-ul">Product</a>
                    <ul>
                        <li><a href="product.html">Default</a></li>
                        <li><a href="product-centered.html">Centered</a></li>
                        <li><a href="product-extended.html"><span>Extended Info<span class="tip tip-new">New</span></span></a></li>
                        <li><a href="product-gallery.html">Gallery</a></li>
                        <li><a href="product-sticky.html">Sticky Info</a></li>
                        <li><a href="product-sidebar.html">Boxed With Sidebar</a></li>
                        <li><a href="product-fullwidth.html">Full Width</a></li>
                        <li><a href="product-masonry.html">Masonry Sticky Info</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">Pages</a>
                    <ul>
                        <li>
                            <a href="about.html">About</a>

                            <ul>
                                <li><a href="about.html">About 01</a></li>
                                <li><a href="about-2.html">About 02</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="contact.html">Contact</a>

                            <ul>
                                <li><a href="contact.html">Contact 01</a></li>
                                <li><a href="contact-2.html">Contact 02</a></li>
                            </ul>
                        </li>
                        <li><a href="login.html">Login</a></li>
                        <li><a href="faq.html">FAQs</a></li>
                        <li><a href="404.html">Error 404</a></li>
                        <li><a href="coming-soon.html">Coming Soon</a></li>
                    </ul>
                </li>
                <li>
                    <a href="blog.html">Blog</a>

                    <ul>
                        <li><a href="blog.html">Classic</a></li>
                        <li><a href="blog-listing.html">Listing</a></li>
                        <li>
                            <a href="#">Grid</a>
                            <ul>
                                <li><a href="blog-grid-2cols.html">Grid 2 columns</a></li>
                                <li><a href="blog-grid-3cols.html">Grid 3 columns</a></li>
                                <li><a href="blog-grid-4cols.html">Grid 4 columns</a></li>
                                <li><a href="blog-grid-sidebar.html">Grid sidebar</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#">Masonry</a>
                            <ul>
                                <li><a href="blog-masonry-2cols.html">Masonry 2 columns</a></li>
                                <li><a href="blog-masonry-3cols.html">Masonry 3 columns</a></li>
                                <li><a href="blog-masonry-4cols.html">Masonry 4 columns</a></li>
                                <li><a href="blog-masonry-sidebar.html">Masonry sidebar</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#">Mask</a>
                            <ul>
                                <li><a href="blog-mask-grid.html">Blog mask grid</a></li>
                                <li><a href="blog-mask-masonry.html">Blog mask masonry</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#">Single Post</a>
                            <ul>
                                <li><a href="single.html">Default with sidebar</a></li>
                                <li><a href="single-fullwidth.html">Fullwidth no sidebar</a></li>
                                <li><a href="single-fullwidth-sidebar.html">Fullwidth with sidebar</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="elements-list.html">Elements</a>
                    <ul>
                        <li><a href="elements-products.html">Products</a></li>
                        <li><a href="elements-typography.html">Typography</a></li>
                        <li><a href="elements-titles.html">Titles</a></li>
                        <li><a href="elements-banners.html">Banners</a></li>
                        <li><a href="elements-product-category.html">Product Category</a></li>
                        <li><a href="elements-video-banners.html">Video Banners</a></li>
                        <li><a href="elements-buttons.html">Buttons</a></li>
                        <li><a href="elements-accordions.html">Accordions</a></li>
                        <li><a href="elements-tabs.html">Tabs</a></li>
                        <li><a href="elements-testimonials.html">Testimonials</a></li>
                        <li><a href="elements-blog-posts.html">Blog Posts</a></li>
                        <li><a href="elements-portfolio.html">Portfolio</a></li>
                        <li><a href="elements-cta.html">Call to Action</a></li>
                        <li><a href="elements-icon-boxes.html">Icon Boxes</a></li>
                    </ul>
                </li>
            </ul>
        </nav><!-- End .mobile-nav -->

        <div class="social-icons">
            <a href="#" class="social-icon" target="_blank" title="Facebook"><i class="icon-facebook-f"></i></a>
            <a href="#" class="social-icon" target="_blank" title="Twitter"><i class="icon-twitter"></i></a>
            <a href="#" class="social-icon" target="_blank" title="Instagram"><i class="icon-instagram"></i></a>
            <a href="#" class="social-icon" target="_blank" title="Youtube"><i class="icon-youtube"></i></a>
        </div><!-- End .social-icons -->
    </div><!-- End .mobile-menu-wrapper -->
</div><!-- End .mobile-menu-container -->

<!-- Sign in / Register Modal -->
<div class="modal fade" id="signin-modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true"><i class="icon-close"></i></span>
                </button>

                <div class="form-box">
                    <div class="form-tab">
                        <ul class="nav nav-pills nav-fill" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" id="signin-tab" data-toggle="tab" href="#signin" role="tab" aria-controls="signin" aria-selected="true">Sign In</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="register-tab" data-toggle="tab" href="#register" role="tab" aria-controls="register" aria-selected="false">Register</a>
                            </li>
                        </ul>
                        <div class="tab-content" id="tab-content-5">
                            <div class="tab-pane fade show active" id="signin" role="tabpanel" aria-labelledby="signin-tab">
                                <form action="#">
                                    <div class="form-group">
                                        <label for="singin-email">Username or email address *</label>
                                        <input type="text" class="form-control" id="singin-email" name="singin-email" required>
                                    </div><!-- End .form-group -->

                                    <div class="form-group">
                                        <label for="singin-password">Password *</label>
                                        <input type="password" class="form-control" id="singin-password" name="singin-password" required>
                                    </div><!-- End .form-group -->

                                    <div class="form-footer">
                                        <button type="submit" class="btn btn-outline-primary-2">
                                            <span>LOG IN</span>
                                            <i class="icon-long-arrow-right"></i>
                                        </button>

                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="signin-remember">
                                            <label class="custom-control-label" for="signin-remember">Remember Me</label>
                                        </div><!-- End .custom-checkbox -->

                                        <a href="#" class="forgot-link">Forgot Your Password?</a>
                                    </div><!-- End .form-footer -->
                                </form>
                                <div class="form-choice">
                                    <p class="text-center">or sign in with</p>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <a href="#" class="btn btn-login btn-g">
                                                <i class="icon-google"></i>
                                                Login With Google
                                            </a>
                                        </div><!-- End .col-6 -->
                                        <div class="col-sm-6">
                                            <a href="#" class="btn btn-login btn-f">
                                                <i class="icon-facebook-f"></i>
                                                Login With Facebook
                                            </a>
                                        </div><!-- End .col-6 -->
                                    </div><!-- End .row -->
                                </div><!-- End .form-choice -->
                            </div><!-- .End .tab-pane -->
<%--                            <div class="tab-pane fade" id="register" role="tabpanel" aria-labelledby="register-tab">--%>
<%--                                <form action="#">--%>
<%--                                    <div class="form-group">--%>
<%--                                        <label for="register-email">Your email address *</label>--%>
<%--                                        <input type="email" class="form-control" id="register-email" name="register-email" required>--%>
<%--                                    </div><!-- End .form-group -->--%>

<%--                                    <div class="form-group">--%>
<%--                                        <label for="register-password">Password *</label>--%>
<%--                                        <input type="password" class="form-control" id="register-password" name="register-password" required>--%>
<%--                                    </div><!-- End .form-group -->--%>

<%--                                    <div class="form-footer">--%>
<%--                                        <button type="submit" class="btn btn-outline-primary-2">--%>
<%--                                            <span>SIGN UP</span>--%>
<%--                                            <i class="icon-long-arrow-right"></i>--%>
<%--                                        </button>--%>

<%--                                        <div class="custom-control custom-checkbox">--%>
<%--                                            <input type="checkbox" class="custom-control-input" id="register-policy" required>--%>
<%--                                            <label class="custom-control-label" for="register-policy">I agree to the <a href="#">privacy policy</a> *</label>--%>
<%--                                        </div><!-- End .custom-checkbox -->--%>
<%--                                    </div><!-- End .form-footer -->--%>
<%--                                </form>--%>
<%--                                <div class="form-choice">--%>
<%--                                    <p class="text-center">or sign in with</p>--%>
<%--                                    <div class="row">--%>
<%--                                        <div class="col-sm-6">--%>
<%--                                            <a href="#" class="btn btn-login btn-g">--%>
<%--                                                <i class="icon-google"></i>--%>
<%--                                                Login With Google--%>
<%--                                            </a>--%>
<%--                                        </div><!-- End .col-6 -->--%>
<%--                                        <div class="col-sm-6">--%>
<%--                                            <a href="#" class="btn btn-login  btn-f">--%>
<%--                                                <i class="icon-facebook-f"></i>--%>
<%--                                                Login With Facebook--%>
<%--                                            </a>--%>
<%--                                        </div><!-- End .col-6 -->--%>
<%--                                    </div><!-- End .row -->--%>
<%--                                </div><!-- End .form-choice -->--%>
<%--                            </div><!-- .End .tab-pane -->--%>
<%--                        </div><!-- End .tab-content -->--%>
<%--                    </div><!-- End .form-tab -->--%>
                </div><!-- End .form-box -->
            </div><!-- End .modal-body -->
        </div><!-- End .modal-content -->
    </div><!-- End .modal-dialog -->
</div><!-- End .modal -->

<!-- Plugins JS File -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/jquery.hoverIntent.min.js"></script>
<script src="assets/js/jquery.waypoints.min.js"></script>
<script src="assets/js/superfish.min.js"></script>
<script src="assets/js/owl.carousel.min.js"></script>
<!-- Main JS File -->
<script src="assets/js/main.js"></script>
</body>


<!-- molla/about.html  22 Nov 2019 10:03:54 GMT -->
</html>