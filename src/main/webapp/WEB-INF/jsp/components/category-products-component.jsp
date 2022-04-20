<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">


<!-- molla/category-boxed.html  22 Nov 2019 10:03:00 GMT -->
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
    <link rel="stylesheet" href="assets/vendor/line-awesome/line-awesome/line-awesome/css/line-awesome.min.css">
    <!-- Plugins CSS File -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <!-- Plugins CSS File -->
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
<c:forEach var="product" items="${categorizedProducts}">
    <div class="col-6 col-md-4 col-lg-4 col-xl-3">
        <div class="product">
            <figure class="product-media">
                <a href="single-product-page?productId=${product.id}">
                    <img src="${product.mainImage}" alt="Product image"
                         class="product-image" style="height:218px">
                </a>

                <div class="product-action-vertical">
                    <a onclick="addToWishList(${product.id})" class="btn-product-icon btn-wishlist btn-expandable"><span>add to wishlist</span></a>
                </div>

                <c:choose>
                    <c:when test="${product.quantity>0}">
                        <div class="product-action">
                            <a onclick="addToCart(${product.id})" class="btn-product btn-cart" style="cursor: pointer"><span>add to cart</span></a>
                            <a href="quickView?productId=${product.id}" class="btn-product btn-quickview" title="Quick view"><span>quick view</span></a>
                        </div><!-- End .product-action -->
                    </c:when>
                    <c:otherwise>
                        <div class="product-action">
                            <a class="btn-product btn-cart" style="cursor: default"><span style="color: red">Out Of Stock</span></a>
                            <a href="quickView?productId=${product.id}" class="btn-product btn-quickview" title="Quick view"><span>quick view</span></a>
                        </div><!-- End .product-action -->
                    </c:otherwise>
                </c:choose>
            </figure><!-- End .product-media -->

            <div class="product-body">
                <div class="product-cat">
                    <a href="single-product-page?productId=${product.id}">${product.category.categoryName}</a>
                </div><!-- End .product-cat -->
                <h3 class="product-title"><a href="single-product-page?productId=${product.id}">${product.name}</a></h3>
                <!-- End .product-title -->
                <div class="product-price">
                        ${product.price} EGP
                </div><!-- End .product-price -->
                <div class="ratings-container">
                    <div class="ratings">
                        <div class="ratings-val" style="width: 80%;"></div>
                        <!-- End .ratings-val -->
                    </div><!-- End .ratings -->
                    <span class="ratings-text">( 11 Reviews )</span>
                </div><!-- End .rating-container -->
            </div><!-- End .product-body -->
        </div><!-- End .product -->
    </div>
    <!-- End .col-sm-6 col-lg-4 col-xl-3 -->
</c:forEach>

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


</body>
