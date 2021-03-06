<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%--<html lang="en">--%>
<html>

<%
    response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
%>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Amazonya - eCommerce Website</title>
    <meta name="keywords" content="HTML5 Template">
    <meta name="description" content="Amazonya - eCommerce Website">
    <meta name="author" content="p-themes">
    <!-- Favicon -->
    <link rel="apple-touch-icon" sizes="180x180" href="assets/images/icons/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="assets/images/icons/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="assets/images/icons/favicon-16x16.png">
    <link rel="manifest" href="assets/images/icons/site.html">
    <link rel="mask-icon" href="assets/images/icons/safari-pinned-tab.svg" color="#666666">
    <link rel="shortcut icon" href="assets/images/icons/favicon.ico">
    <meta name="apple-mobile-web-app-title" content="Amazonya">
    <meta name="application-name" content="Amazonya">
    <meta name="msapplication-TileColor" content="#cc9966">
    <meta name="msapplication-config" content="assets/images/icons/browserconfig.xml">
    <meta name="theme-color" content="#ffffff">
    <link rel="stylesheet" href="assets/vendor/line-awesome/line-awesome/line-awesome/css/line-awesome.min.css">
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
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>


</head>

<body>
    <div class="page-wrapper">
        <%@ include file="includes/header.jsp" %>

        <main class="main">
            <div class="intro-slider-container mb-5">
                <div class="intro-slider owl-carousel owl-theme owl-nav-inside owl-light" data-toggle="owl"
                     data-owl-options='{
                        "dots": true,
                        "nav": false, 
                        "responsive": {
                            "1200": {
                                "nav": true,
                                "dots": false
                            }
                        }
                    }'>
                    <div class="intro-slide"
                         style="background-image: url(assets/images/demos/demo-13/slider/slide-1.png);">
                        <div class="container intro-content">
                            <div class="row justify-content-start">
                                <div class="col-auto offset-lg-2 intro-col">
                                    <h3 class="intro-subtitle text-primary">Trade-In Offer</h3><!-- End .h3 intro-subtitle -->
                                    <h1 class="intro-title">MacBook Air <br>Latest Model<br>
                                        <span>
                                            <sup class="font-weight-light">from</sup>
                                            <span class="text-primary" >20,000 EGP</span>
                                        </span>
                                    </h1><!-- End .intro-title -->

                                    <a href="shop" class="btn btn-primary btn-round">
                                        <span>Shop More</span>
                                        <i class="icon-long-arrow-right"></i>
                                    </a>
                                </div><!-- End .col-lg-11 offset-lg-1 -->
                            </div><!-- End .row -->
                        </div><!-- End .intro-content -->
                    </div><!-- End .intro-slide -->

                    <div class="intro-slide"
                         style="background-image: url(assets/images/demos/demo-4/slider/slide-2.png);">
                        <div class="container intro-content">
                            <div class="row justify-content-end">
                                <div class="col-auto col-sm-7 col-md-6 col-lg-5">
                                    <h3 class="intro-subtitle text-primary">Comming Soon</h3>
                                    <!-- End .h3 intro-subtitle -->
                                    <h1 class="intro-title">Apple iPad Pro <br>12.9 Inch, 64GB </h1>
                                    <!-- End .intro-title -->

                                    <div class="intro-price">
                                        <sup>Today:</sup>
                                        <span class="text-primary">
                                            7450 EGP
                                        </span>
                                    </div><!-- End .intro-price -->

                                    <a href="shop" class="btn btn-primary btn-round">
                                        <span>Shop More</span>
                                        <i class="icon-long-arrow-right"></i>
                                    </a>
                                </div><!-- End .col-md-6 offset-md-6 -->
                            </div><!-- End .row -->
                        </div><!-- End .intro-content -->
                    </div><!-- End .intro-slide -->
                </div><!-- End .intro-slider owl-carousel owl-simple -->

                <span class="slider-loader"></span><!-- End .slider-loader -->
            </div><!-- End .intro-slider-container -->

            <div class="container">
                <h2 class="title text-center mb-4">Explore Popular Categories</h2><!-- End .title text-center -->
                <div class="cat-blocks-container">
                    <div class="row">
                        <c:forEach var="category" items="${currentCategories}">
                            <div class="col-6 col-sm-6 col-lg-4">
                                <a href="categorized-product?categoryId=${category.categoryId}" id="${category.categoryId}" class="cat-block">
                                    <figure>
                                    <span>
                                        <img src="${category.categoryImage}" alt="${category.categoryName}">
                                    </span>
                                    </figure>

                                    <h3 class="cat-block-title">${category.categoryName}</h3><!-- End .cat-block-title -->
                                </a>
                            </div><!-- End .col-sm-4 col-lg-2 -->

                        </c:forEach>
                    </div><!-- End .row -->
                </div><!-- End .cat-blocks-container -->
            </div><!-- End .container -->

            <div class="mb-4"></div><!-- End .mb-4 -->


            <div class="mb-3"></div><!-- End .mb-5 -->

            <div class="container new-arrivals">
                <div class="heading heading-flex mb-3">
                    <div class="heading-left">
                        <h2 class="title">New Arrivals</h2><!-- End .title -->
                    </div><!-- End .heading-left -->
                </div><!-- End .heading -->

                <div class="tab-content tab-content-carousel just-action-icons-sm">
                    <div class="tab-pane p-0 fade show active" id="new-all-tab" role="tabpanel"
                        aria-labelledby="new-all-link">
                        <div class="owl-carousel owl-full carousel-equal-height carousel-with-shadow" data-toggle="owl"
                            data-owl-options='{
                                "nav": true, 
                                "dots": true,
                                "margin": 20,
                                "loop": false,
                                "responsive": {
                                    "0": {
                                        "items":2
                                    },
                                    "480": {
                                        "items":2
                                    },
                                    "768": {
                                        "items":3
                                    },
                                    "992": {
                                        "items":4
                                    },
                                    "1200": {
                                        "items":5
                                    }
                                }
                            }'>
                            <c:forEach var="product" items="${newArrivals}">


                                <div class="product product-2">
                                    <figure class="product-media">
                                        <span class="product-label label-circle label-top"><c:out value="${product.state}"/></span>
                                        <a href="single-product-page?productId=${product.id}">
                                            <img src="${product.mainImage}" alt="Product image"
                                                 class="product-image" style="height:218px">
                                        </a>

                                        <div class="product-action-vertical">
                                            <a onclick="addToWishList(${product.id})" class="btn-product-icon btn-wishlist" title="Add to wishlist"></a>
                                        </div><!-- End .product-action -->

                                        <c:choose>
                                            <c:when test="${product.quantity>0}">
                                                <div class="product-action">
                                                    <a onclick="addToCart(${product.id})" class="btn-product btn-cart" style="cursor: pointer"><span>add to cart</span></a>
                                                    <a href="quickView?productId=${product.id}" class="btn-product btn-quickview"
                                                       title="Quick view"><span>quick view</span></a>
                                                </div><!-- End .product-action -->
                                            </c:when>
                                            <c:otherwise>
                                                <div class="product-action">
                                                    <a href="quickView?productId=${product.id}" class="btn-product btn-quickview"
                                                       title="Quick view"><span>quick view</span></a>
                                                </div><!-- End .product-action -->
                                            </c:otherwise>
                                        </c:choose>

                                    </figure><!-- End .product-media -->


                                    <div class="product-body">
                                        <div class="product-cat">
                                            <a href="categorized-product?categoryId=${product.category.categoryId}">${product.category.categoryName}</a>
                                        </div><!-- End .product-cat -->
                                        <h3 class="product-title"><a href="single-product-page?productId=${product.id}"><c:out value="${product.name}"/></a>
                                        </h3><!-- End .product-title -->
                                        <div class="product-price">
                                            <c:out value="${product.price} EGP"/>
                                        </div><!-- End .product-price -->
                                        <div class="ratings-container">
                                            <div class="ratings">
                                                <div class="ratings-val" style="width: 100%;"></div>
                                                <!-- End .ratings-val -->
                                            </div><!-- End .ratings -->
                                            <span class="ratings-text">( 4 Reviews )</span>
                                        </div><!-- End .rating-container -->
                                    </div><!-- End .product-body -->
                                </div><!-- End .product -->
                            </c:forEach>
                        </div><!-- End .owl-carousel -->
                    </div><!-- .End .tab-pane -->

                </div><!-- End .tab-content -->
            </div><!-- End .container -->
            <div id="hiddenCart" hidden>${sessionScope.cartItemBeans}</div>
            <div id="loggedInCheck" hidden>${sessionScope.loggedIn}</div>

            <div class="mb-6"></div>
            <!-- End .mb-6 -->



            <div class="container">
                <hr class="mb-0">
                <div class="owl-carousel mt-5 mb-5 owl-simple" data-toggle="owl" data-owl-options='{
                        "nav": false, 
                        "dots": false,
                        "margin": 30,
                        "loop": false,
                        "responsive": {
                            "0": {
                                "items":2
                            },
                            "420": {
                                "items":3
                            },
                            "600": {
                                "items":4
                            },
                            "900": {
                                "items":5
                            },
                            "1024": {
                                "items":6
                            }
                        }
                    }'>
                    <a href="#" class="brand">
                        <img src="assets/images/brands/oppo.png" alt="Brand Name">
                    </a>

                    <a href="#" class="brand">
                        <img src="assets/images/brands/samsung.png" alt="Brand Name">
                    </a>

                    <a href="#" class="brand">
                        <img src="assets/images/brands/Xiaomi.png" alt="Brand Name">
                    </a>

                    <a href="#" class="brand">
                        <img src="assets/images/brands/iphone.png" alt="Brand Name">
                    </a>

                    <a href="#" class="brand">
                        <img src="assets/images/brands/Dell.png" alt="Brand Name">
                    </a>

                    <a href="#" class="brand">
                        <img src="assets/images/brands/Motorola.png" alt="Brand Name">
                    </a>
                </div><!-- End .owl-carousel -->
            </div><!-- End .container -->



            <div class="mb-5"></div><!-- End .mb-5 -->



            <div class="mb-4"></div><!-- End .mb-4 -->

            <div class="container">
                <hr class="mb-0">
            </div><!-- End .container -->

            <div class="icon-boxes-container bg-transparent">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6 col-lg-3">
                            <div class="icon-box icon-box-side">
                                <span class="icon-box-icon text-dark">
                                    <i class="icon-rocket"></i>
                                </span>
                                <div class="icon-box-content">
                                    <h3 class="icon-box-title">Free Shipping</h3><!-- End .icon-box-title -->
                                    <p>Orders $50 or more</p>
                                </div><!-- End .icon-box-content -->
                            </div><!-- End .icon-box -->
                        </div><!-- End .col-sm-6 col-lg-3 -->

                        <div class="col-sm-6 col-lg-3">
                            <div class="icon-box icon-box-side">
                                <span class="icon-box-icon text-dark">
                                    <i class="icon-rotate-left"></i>
                                </span>

                                <div class="icon-box-content">
                                    <h3 class="icon-box-title">Free Returns</h3><!-- End .icon-box-title -->
                                    <p>Within 30 days</p>
                                </div><!-- End .icon-box-content -->
                            </div><!-- End .icon-box -->
                        </div><!-- End .col-sm-6 col-lg-3 -->

                        <div class="col-sm-6 col-lg-3">
                            <div class="icon-box icon-box-side">
                                <span class="icon-box-icon text-dark">
                                    <i class="icon-info-circle"></i>
                                </span>

                                <div class="icon-box-content">
                                    <h3 class="icon-box-title">Get 20% Off 1 Item</h3><!-- End .icon-box-title -->
                                    <p>when you sign up</p>
                                </div><!-- End .icon-box-content -->
                            </div><!-- End .icon-box -->
                        </div><!-- End .col-sm-6 col-lg-3 -->

                        <div class="col-sm-6 col-lg-3">
                            <div class="icon-box icon-box-side">
                                <span class="icon-box-icon text-dark">
                                    <i class="icon-life-ring"></i>
                                </span>

                                <div class="icon-box-content">
                                    <h3 class="icon-box-title">We Support</h3><!-- End .icon-box-title -->
                                    <p>24/7 amazing services</p>
                                </div><!-- End .icon-box-content -->
                            </div><!-- End .icon-box -->
                        </div><!-- End .col-sm-6 col-lg-3 -->
                    </div><!-- End .row -->
                </div><!-- End .container -->
            </div><!-- End .icon-boxes-container -->
        </main><!-- End .main -->

        <%@ include file="includes/footer.jsp" %><!-- End .footer -->

    </div><!-- End .page-wrapper -->
    <button id="scroll-top" title="Back to Top"><i class="icon-arrow-up"></i></button>

    <!-- Mobile Menu -->
    <%@ include file="includes/sideMobileMenu.jsp" %><!-- End .mobile-menu-container -->

    <!-- Sign in / Register Modal -->
`
<%--    <div class="container newsletter-popup-container mfp-hide" id="newsletter-popup-form">--%>
<%--        <div class="row justify-content-center">--%>
<%--            <div class="col-10">--%>
<%--                <div class="row no-gutters bg-white newsletter-popup-content">--%>
<%--                    <div class="col-xl-3-5col col-lg-7 banner-content-wrap">--%>
<%--                        <div class="banner-content text-center">--%>
<%--                            <img src="assets/images/popup/newsletter/logo.png" class="logo" alt="logo" width="60"--%>
<%--                                height="15">--%>
<%--                            <h2 class="banner-title">get <span>25<light>%</light></span> off</h2>--%>
<%--                            <p>Subscribe to the Molla eCommerce newsletter to receive timely updates from your favorite--%>
<%--                                products.</p>--%>
<%--                            <form action="#">--%>
<%--                                <div class="input-group input-group-round">--%>
<%--                                    <input type="email" class="form-control form-control-white"--%>
<%--                                        placeholder="Your Email Address" aria-label="Email Adress" required>--%>
<%--                                    <div class="input-group-append">--%>
<%--                                        <button class="btn" type="submit"><span>go</span></button>--%>
<%--                                    </div><!-- .End .input-group-append -->--%>
<%--                                </div><!-- .End .input-group -->--%>
<%--                            </form>--%>
<%--                            <div class="custom-control custom-checkbox">--%>
<%--                                <input type="checkbox" class="custom-control-input" id="register-policy-2" required>--%>
<%--                                <label class="custom-control-label" for="register-policy-2">Do not show this popup--%>
<%--                                    again</label>--%>
<%--                            </div><!-- End .custom-checkbox -->--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="col-xl-2-5col col-lg-5 ">--%>
<%--                        <img src="assets/images/popup/newsletter/banner-4.jpg" class="newsletter-img" alt="newsletter">--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>

    <!-- Plugins JS File -->


    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/bootstrap.bundle.min.js"></script>
    <script src="assets/js/jquery.hoverIntent.min.js"></script>
    <script src="assets/js/jquery.waypoints.min.js"></script>
    <script src="assets/js/superfish.min.js"></script>
    <script src="assets/js/owl.carousel.min.js"></script>
    <script src="assets/js/bootstrap-input-spinner.js"></script>
    <script src="assets/js/jquery.plugin.min.js"></script>
    <script src="assets/js/jquery.magnific-popup.min.js"></script>
    <script src="assets/js/jquery.countdown.min.js"></script>
    <!-- Main JS File -->
    <script src="assets/js/main.js"></script>
    <script src="assets/js/demos/demo-4.js"></script>
        <script>
            window.onload= (event) => {
                console.log("on documentLoad")
                if(!navigator.cookieEnabled) {
                    window.location.href = "un-enabled-cookie";
                }else{
                    console.log("on documentLoad else condition");
                    hiddenCart = document.getElementById("hiddenCart");
                    loggedIn = document.getElementById("loggedInCheck");
                    console.log(hiddenCart);
                    if(loggedIn.textContent === "true" && hiddenCart.textContent !== null && hiddenCart.textContent !== "" && loggedIn !== null){
                        localStorage.setItem("cartItems",hiddenCart.textContent);
                        hiddenCart.remove();
                    }
                    addToCart(-1);
                    addToWishList(-1);
                }

            };
            function addToCart(productId){
                //get all available id in local storage
                //update list
                //save list to local storage
                var checker=true;
                var localStorageContent = localStorage.getItem("cartItems");

                if (localStorageContent == null) {
                    cartItems = [];
                } else {
                    cartItems = JSON.parse(localStorageContent);
                }

                cartItem = new CartItem(productId,1);

                for(var i =0;i<cartItems.length;i++){
                    if(cartItems[i].id === productId){
                        cartItems[i].quantity++;
                        checker=false;
                    }
                }

                if(checker && productId>=0){
                    cartItems.push(cartItem);
                }

                localStorage.setItem('cartItems', JSON.stringify(cartItems));
                console.log(JSON.parse(localStorage.getItem("cartItems")));
                console.log(cartItems);

                document.getElementById("cartItemsNumber").textContent =  cartItems.length;



            }
            function addToWishList(productId){

                //get all available id in local storage
                //update list
                //save list to local storage
                var check=true;
                var localStorageContent = localStorage.getItem("wishlistItems");
                if (localStorageContent == null) {
                    WishListItems = [];
                } else {
                    WishListItems = JSON.parse(localStorageContent);
                }



                for(let i =0;i<WishListItems.length;i++){
                    if(WishListItems[i]===productId){
                        check = false;
                    }
                }


                if( check && productId>=0){
                    WishListItems.push(productId);
                }

                localStorage.setItem('wishlistItems', JSON.stringify(WishListItems));
                console.log(JSON.parse(localStorage.getItem("wishlistItems")));
                console.log(WishListItems);

                document.getElementById("wishListItemsNumber").textContent =  WishListItems.length.toString();

            }
        </script>
</body>



</html>