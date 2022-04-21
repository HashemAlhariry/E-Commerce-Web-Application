<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib  uri="/WEB-INF/tlds/sortTag.tld" prefix="p" %>


<!DOCTYPE html>
<html lang="en">
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
        <div class="page-header text-center" style="background-image: url('assets/images/page-header-bg.jpg')">
            <div class="container">
                <h1 class="page-title">Shop All Products<span>Shop</span></h1>
            </div><!-- End .container -->
        </div><!-- End .page-header -->
        <nav aria-label="breadcrumb" class="breadcrumb-nav mb-2">
            <div class="container">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="home">Home</a></li>
                    <c:choose>
                        <c:when test="${filtration}">
                            <li class="breadcrumb-item"><a href="shop">Shop</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Filters Page</li>                        </c:when>
                        <c:otherwise>
                            <li class="breadcrumb-item active" aria-current="page">Shop</li>
                        </c:otherwise>
                    </c:choose>
                </ol>
            </div><!-- End .container -->
        </nav><!-- End .breadcrumb-nav -->

        <div class="page-content">
            <div class="container">
                <div class="row">
                    <div class="col-lg-9">
                        <div class="toolbox">
                            <div class="toolbox-left">
                                <div class="toolbox-info">
                                    Showing <span>${currentPageProductsNumber} of ${totalCount}</span> Products          page : <span>${currentPageNumber}</span>
                                </div><!-- End .toolbox-info -->
                            </div><!-- End .toolbox-left -->

                            <div class="toolbox-right">
                                <div class="toolbox-sort">
                                    <label for="sortby">Sort by:</label>
                                    <div class="select-custom">
                                        <select name="sortby" id="sortby" class="form-control" onchange="sortProducts()">
                                            <option value="oldest" selected="selected">Oldest</option>
                                            <option value="priceAsc" >Price Low to High</option>
                                            <option value="priceDesc">Price High to Low</option>
                                            <option value="date">Newest</option>
                                        </select>
                                    </div>
                                </div><!-- End .toolbox-sort -->
                                <div class="toolbox-layout">

                                    <a onclick="" class="btn-layout"  id="productsView2">
                                        <svg width="10" height="10">
                                            <rect x="0" y="0" width="4" height="4" />
                                            <rect x="6" y="0" width="4" height="4" />
                                            <rect x="0" y="6" width="4" height="4" />
                                            <rect x="6" y="6" width="4" height="4" />
                                        </svg>
                                    </a>

                                    <a onclick="" class="btn-layout"  id="productsView3">
                                        <svg width="16" height="10">
                                            <rect x="0" y="0" width="4" height="4" />
                                            <rect x="6" y="0" width="4" height="4" />
                                            <rect x="12" y="0" width="4" height="4" />
                                            <rect x="0" y="6" width="4" height="4" />
                                            <rect x="6" y="6" width="4" height="4" />
                                            <rect x="12" y="6" width="4" height="4" />
                                        </svg>
                                    </a>

                                    <a   class="btn-layout active" id="productsView4" >
                                        <svg width="22" height="10">
                                            <rect x="0" y="0" width="4" height="4" />
                                            <rect x="6" y="0" width="4" height="4" />
                                            <rect x="12" y="0" width="4" height="4" />
                                            <rect x="18" y="0" width="4" height="4" />
                                            <rect x="0" y="6" width="4" height="4" />
                                            <rect x="6" y="6" width="4" height="4" />
                                            <rect x="12" y="6" width="4" height="4" />
                                            <rect x="18" y="6" width="4" height="4" />
                                        </svg>
                                    </a>
                                </div><!-- End .toolbox-layout -->
                            </div><!-- End .toolbox-right -->
                        </div><!-- End .toolbox -->

                        <div class="products mb-3">
<%--                            TODO ARCHIVED STATE CONDITION OF NOT SHOWING THE PRODUCTS--%>
                            <div class="row justify-content-center" id="productsContainer">
                                <c:forEach items="${allProducts}" var="product">
                                    <c:if test="${!(fn:containsIgnoreCase(product.state,'ARCHIVED' ))}">
                                        <div class="col-6 col-md-4 col-lg-4 col-xl-3" id="productsView">
                                            <div class="product product-7 text-center">
                                                <figure class="product-media">
                                                    <c:if test="${!empty product.state}">
                                                        <span class="product-label label-new">${product.state}</span>
                                                    </c:if>
                                                    <a href="single-product-page?productId=${product.id}">
                                                        <img src="${product.mainImage}" alt="Product image" class="product-image" style="height: 218px;">
                                                    </a>

                                                    <div class="product-action-vertical">
                                                        <a onclick="addToWishList(${product.id})" class="btn-product-icon btn-wishlist btn-expandable" style="cursor: pointer"><span>add to wishlist</span></a>
                                                        <a href="quickView?productId=${product.id}" class="btn-product-icon btn-quickview" title="Quick view"><span>Quick view</span></a>
                                                    </div><!-- End .product-action-vertical -->


                                                    <c:choose>
                                                        <c:when test="${product.quantity>0}">
                                                            <div class="product-action">
                                                                <a onclick="addToCart(${product.id})" class="btn-product btn-cart" style="cursor: pointer"><span>add to cart</span></a>
                                                            </div><!-- End .product-action -->
                                                        </c:when>
                                                        <c:otherwise>
                                                            <div class="product-action">
                                                                <a class="btn-product btn-cart" style="cursor: default"><span style="color: red">Out Of Stock</span></a>
                                                            </div><!-- End .product-action -->
                                                        </c:otherwise>
                                                    </c:choose>
                                                </figure><!-- End .product-media -->

                                                <div class="product-body">
                                                    <div class="product-cat">
                                                        <a href="categorized-product?categoryId=${product.category.categoryId}">${product.category.categoryName}</a>
                                                    </div><!-- End .product-cat -->
                                                    <h3 class="product-title"><a href="single-product-page?productId=${product.id}">${product.name}</a></h3><!-- End .product-title -->
                                                    <div class="product-price">
                                                            ${product.price} EGP
                                                    </div><!-- End .product-price -->
                                                    <div class="ratings-container">
                                                        <div class="ratings">
                                                            <div class="ratings-val" style="width: ${(product.rating)*10}%;"></div><!-- End .ratings-val -->
                                                        </div><!-- End .ratings -->
                                                            <%--                                                    <span class="ratings-text">( 2 Reviews )</span>--%>
                                                    </div><!-- End .rating-container -->

                                                    <div class="product-nav product-nav-thumbs">
                                                        <c:forEach items="${product.images}" var="image" varStatus="loop">
                                                            <c:if test="${!loop.last }">
                                                                <a class="active" style="cursor: default">
                                                                    <img src="${image}" alt="product desc" style="height: 33px;margin-left: auto;margin-right: auto;">
                                                                </a>
                                                            </c:if>
                                                        </c:forEach>
                                                    </div><!-- End .product-nav -->
                                                </div><!-- End .product-body -->
                                            </div><!-- End .product -->
                                        </div><!-- End .col-sm-6 col-lg-4 col-xl-3 -->
                                    </c:if>
                                </c:forEach>


                            </div>
                            <div class="row justify-content-center" id="sortByPriceDesc" hidden>
                                <c:forEach items="${p:sortByPriceDesc(allProducts)}" var="product">
                                    <c:if test="${!(fn:containsIgnoreCase(product.state,'ARCHIVED' ))}">
                                        <div class="col-6 col-md-4 col-lg-4 col-xl-3" id="productsView">
                                            <div class="product product-7 text-center">
                                                <figure class="product-media">
                                                    <c:if test="${!empty product.state}">
                                                        <span class="product-label label-new">${product.state}</span>
                                                    </c:if>
                                                    <a href="single-product-page?productId=${product.id}">
                                                        <img src="${product.mainImage}" alt="Product image" class="product-image" style="height: 218px;">
                                                    </a>

                                                    <div class="product-action-vertical">
                                                        <a onclick="addToWishList(${product.id})" class="btn-product-icon btn-wishlist btn-expandable" style="cursor: pointer"><span>add to wishlist</span></a>
                                                        <a href="quickView?productId=${product.id}" class="btn-product-icon btn-quickview" title="Quick view"><span>Quick view</span></a>
                                                    </div><!-- End .product-action-vertical -->

                                                    <c:choose>
                                                        <c:when test="${product.quantity>0}">
                                                            <div class="product-action">
                                                                <a onclick="addToCart(${product.id})" class="btn-product btn-cart" style="cursor: pointer"><span>add to cart</span></a>
                                                            </div><!-- End .product-action -->
                                                        </c:when>
                                                        <c:otherwise>
                                                            <div class="product-action">
                                                                <a class="btn-product btn-cart" style="cursor: default"><span style="color: red">Out Of Stock</span></a>
                                                            </div><!-- End .product-action -->
                                                        </c:otherwise>
                                                    </c:choose>
                                                </figure><!-- End .product-media -->

                                                <div class="product-body">
                                                    <div class="product-cat">
                                                        <a href="categorized-product?categoryId=${product.category.categoryId}">${product.category.categoryName}</a>
                                                    </div><!-- End .product-cat -->
                                                    <h3 class="product-title"><a href="single-product-page?productId=${product.id}">${product.name}</a></h3><!-- End .product-title -->
                                                    <div class="product-price">
                                                            ${product.price} EGP
                                                    </div><!-- End .product-price -->
                                                    <div class="ratings-container">
                                                        <div class="ratings">
                                                            <div class="ratings-val" style="width: ${(product.rating)*10}%;"></div><!-- End .ratings-val -->
                                                        </div><!-- End .ratings -->
                                                            <%--                                                    <span class="ratings-text">( 2 Reviews )</span>--%>
                                                    </div><!-- End .rating-container -->

                                                    <div class="product-nav product-nav-thumbs">
                                                        <c:forEach items="${product.images}" var="image" varStatus="loop">
                                                            <c:if test="${!loop.last }">
                                                                <a class="active" style="cursor: default">
                                                                    <img src="${image}" alt="product desc" style="height: 33px;margin-left: auto;margin-right: auto;">
                                                                </a>
                                                            </c:if>
                                                        </c:forEach>
                                                    </div><!-- End .product-nav -->
                                                </div><!-- End .product-body -->
                                            </div><!-- End .product -->
                                        </div><!-- End .col-sm-6 col-lg-4 col-xl-3 -->
                                    </c:if>
                                </c:forEach>

                            </div>
                            <div class="row justify-content-center" id="sortByPriceAsc" hidden>
                                <c:forEach items="${p:sortByPriceAsc(allProducts)}" var="product">
                                    <c:if test="${!(fn:containsIgnoreCase(product.state,'ARCHIVED' ))}">
                                        <div class="col-6 col-md-4 col-lg-4 col-xl-3" id="productsView">
                                            <div class="product product-7 text-center">
                                                <figure class="product-media">
                                                    <c:if test="${!empty product.state}">
                                                        <span class="product-label label-new">${product.state}</span>
                                                    </c:if>
                                                    <a href="single-product-page?productId=${product.id}">
                                                        <img src="${product.mainImage}" alt="Product image" class="product-image" style="height: 218px;">
                                                    </a>

                                                    <div class="product-action-vertical">
                                                        <a onclick="addToWishList(${product.id})" class="btn-product-icon btn-wishlist btn-expandable" style="cursor: pointer"><span>add to wishlist</span></a>
                                                        <a href="quickView?productId=${product.id}" class="btn-product-icon btn-quickview" title="Quick view"><span>Quick view</span></a>
                                                    </div><!-- End .product-action-vertical -->

                                                    <c:choose>
                                                        <c:when test="${product.quantity>0}">
                                                            <div class="product-action">
                                                                <a onclick="addToCart(${product.id})" class="btn-product btn-cart" style="cursor: pointer"><span>add to cart</span></a>
                                                            </div><!-- End .product-action -->
                                                        </c:when>
                                                        <c:otherwise>
                                                            <div class="product-action">
                                                                <a class="btn-product btn-cart" style="cursor: default"><span style="color: red">Out Of Stock</span></a>
                                                            </div><!-- End .product-action -->
                                                        </c:otherwise>
                                                    </c:choose>
                                                </figure><!-- End .product-media -->

                                                <div class="product-body">
                                                    <div class="product-cat">
                                                        <a href="categorized-product?categoryId=${product.category.categoryId}">${product.category.categoryName}</a>
                                                    </div><!-- End .product-cat -->
                                                    <h3 class="product-title"><a href="single-product-page?productId=${product.id}">${product.name}</a></h3><!-- End .product-title -->
                                                    <div class="product-price">
                                                            ${product.price} EGP
                                                    </div><!-- End .product-price -->
                                                    <div class="ratings-container">
                                                        <div class="ratings">
                                                            <div class="ratings-val" style="width: ${(product.rating)*10}%;"></div><!-- End .ratings-val -->
                                                        </div><!-- End .ratings -->
                                                            <%--                                                    <span class="ratings-text">( 2 Reviews )</span>--%>
                                                    </div><!-- End .rating-container -->

                                                    <div class="product-nav product-nav-thumbs">
                                                        <c:forEach items="${product.images}" var="image" varStatus="loop">
                                                            <c:if test="${!loop.last }">
                                                                <a class="active" style="cursor: default">
                                                                    <img src="${image}" alt="product desc" style="height: 33px;margin-left: auto;margin-right: auto;">
                                                                </a>
                                                            </c:if>
                                                        </c:forEach>
                                                    </div><!-- End .product-nav -->
                                                </div><!-- End .product-body -->
                                            </div><!-- End .product -->
                                        </div><!-- End .col-sm-6 col-lg-4 col-xl-3 -->
                                    </c:if>
                                </c:forEach>

                            </div>
                            <div class="row justify-content-center" id="sortByDate" hidden>
                                <c:forEach items="${p:sortByDate(allProducts)}" var="product">
                                    <c:if test="${!(fn:containsIgnoreCase(product.state,'ARCHIVED' ))}">
                                        <div class="col-6 col-md-4 col-lg-4 col-xl-3" id="productsView">
                                            <div class="product product-7 text-center">
                                                <figure class="product-media">
                                                    <c:if test="${!empty product.state}">
                                                        <span class="product-label label-new">${product.state}</span>
                                                    </c:if>
                                                    <a href="single-product-page?productId=${product.id}">
                                                        <img src="${product.mainImage}" alt="Product image" class="product-image" style="height: 218px;">
                                                    </a>

                                                    <div class="product-action-vertical">
                                                        <a onclick="addToWishList(${product.id})" class="btn-product-icon btn-wishlist btn-expandable" style="cursor: pointer"><span>add to wishlist</span></a>
                                                        <a href="quickView?productId=${product.id}" class="btn-product-icon btn-quickview" title="Quick view"><span>Quick view</span></a>
                                                    </div><!-- End .product-action-vertical -->

                                                    <c:choose>
                                                        <c:when test="${product.quantity>0}">
                                                            <div class="product-action">
                                                                <a onclick="addToCart(${product.id})" class="btn-product btn-cart" style="cursor: pointer"><span>add to cart</span></a>
                                                            </div><!-- End .product-action -->
                                                        </c:when>
                                                        <c:otherwise>
                                                            <div class="product-action">
                                                                <a class="btn-product btn-cart" style="cursor: default"><span style="color: red">Out Of Stock</span></a>
                                                            </div><!-- End .product-action -->
                                                        </c:otherwise>
                                                    </c:choose>
                                                </figure><!-- End .product-media -->

                                                <div class="product-body">
                                                    <div class="product-cat">
                                                        <a href="categorized-product?categoryId=${product.category.categoryId}">${product.category.categoryName}</a>
                                                    </div><!-- End .product-cat -->
                                                    <h3 class="product-title"><a href="single-product-page?productId=${product.id}">${product.name}</a></h3><!-- End .product-title -->
                                                    <div class="product-price">
                                                            ${product.price} EGP
                                                    </div><!-- End .product-price -->
                                                    <div class="ratings-container">
                                                        <div class="ratings">
                                                            <div class="ratings-val" style="width: ${(product.rating)*10}%;"></div><!-- End .ratings-val -->
                                                        </div><!-- End .ratings -->
                                                            <%--                                                    <span class="ratings-text">( 2 Reviews )</span>--%>
                                                    </div><!-- End .rating-container -->

                                                    <div class="product-nav product-nav-thumbs">
                                                        <c:forEach items="${product.images}" var="image" varStatus="loop">
                                                            <c:if test="${!loop.last }">
                                                                <a class="active" style="cursor: default">
                                                                    <img src="${image}" alt="product desc" style="height: 33px;margin-left: auto;margin-right: auto;">
                                                                </a>
                                                            </c:if>
                                                        </c:forEach>
                                                    </div><!-- End .product-nav -->
                                                </div><!-- End .product-body -->
                                            </div><!-- End .product -->
                                        </div><!-- End .col-sm-6 col-lg-4 col-xl-3 -->
                                    </c:if>
                                </c:forEach>

                            </div>
                            <div class="row justify-content-center" id="watchAndLapContainer" hidden>
                                <c:forEach items="${allProducts}" var="product">
                                    <c:if test="${(product.category.categoryId==1)or(product.category.categoryId==5)}">
                                        <div class="col-6 col-md-4 col-lg-4 col-xl-3" id="productsView">
                                            <div class="product product-7 text-center">
                                                <figure class="product-media">
                                                    <span class="product-label label-new">New</span>

                                                    <a href="shop">
                                                        <c:choose>
                                                            <c:when test="${product.category.categoryId==1}">
                                                                <img src="https://amazonya.s3.eu-central-1.amazonaws.com/laptop2.jpg" alt="Product image" class="product-image">
                                                            </c:when>
                                                            <c:otherwise>
                                                                <img src="assets/images/products/watch.png" alt="Product image" class="product-image">
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </a>


                                                    <div class="product-action-vertical" >
                                                        <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>add to wishlist</span></a>
                                                        <a href="quickView?productId=${product.id}" class="btn-product-icon btn-quickview" title="Quick view"><span>Quick view</span></a>
                                                    </div><!-- End .product-action-vertical -->

                                                    <div class="product-action">
                                                        <a href="#" class="btn-product btn-cart"><span>add to cart</span></a>
                                                    </div><!-- End .product-action -->
                                                </figure><!-- End .product-media -->

                                                <div class="product-body">
                                                    <div class="product-cat">
                                                        <a href="#">${product.category.categoryName}</a>
                                                    </div><!-- End .product-cat -->
                                                    <h3 class="product-title"><a href="product.html">${product.description}</a></h3><!-- End .product-title -->
                                                    <div class="product-price">
                                                            ${product.price} EGP
                                                    </div><!-- End .product-price -->
                                                    <div class="ratings-container">
                                                        <div class="ratings">
                                                            <div class="ratings-val" style="width: ${(product.rating)*10}%;"></div><!-- End .ratings-val -->
                                                        </div><!-- End .ratings -->
                                                        <span class="ratings-text">( 2 Reviews )</span>
                                                    </div><!-- End .rating-container -->

                                                    <div class="product-nav product-nav-thumbs">
                                                        <a href="#" class="active">
                                                            <img src="assets/images/products/product-4-thumb.jpg" alt="product desc">
                                                        </a>
                                                        <a href="#">
                                                            <img src="assets/images/products/product-4-2-thumb.jpg" alt="product desc">
                                                        </a>

                                                        <a href="#">
                                                            <img src="assets/images/products/product-4-3-thumb.jpg" alt="product desc">
                                                        </a>
                                                    </div><!-- End .product-nav -->
                                                </div><!-- End .product-body -->
                                            </div><!-- End .product -->
                                        </div><!-- End .col-sm-6 col-lg-4 col-xl-3 -->
                                    </c:if>
                                </c:forEach>

                            </div>

                        </div><!-- End .products -->


                        <nav aria-label="Page navigation">
                            <ul class="pagination justify-content-center">

                                <c:if test="${empty filtration}" >
                                    <c:forEach begin="1" end="${numberOfPages}" var="i">
                                        <li class="page-item active" aria-current="page"><a class="page-link" href="shop?pageNumber=${i}" <c:if test="${currentPageNumber==i}"> style="border-color: orange;border-style: solid; cursor: pointer" </c:if> >${i}</a></li>
                                        <%--                                    <li class="page-item active" aria-current="page"><a class="page-link" onclick="getPageProducts(${i})">${i}</a></li>--%>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${!empty filtration}" >
                                    <c:forEach begin="1" end="${numberOfPages}" var="i">
                                        <li class="page-item active" aria-current="page" <c:if test="${currentPageNumber==i}"> style="border-color: orange;border-style: solid; cursor: pointer" </c:if> ><a class="page-link" onclick="loadFilteredPageNo(${i})">${i}</a></li>
                                        <%--                                    <li class="page-item active" aria-current="page"><a class="page-link" onclick="getPageProducts(${i})">${i}</a></li>--%>
                                    </c:forEach>
                                </c:if>
                                <!--
                                <li class="page-item disabled">
                                    <a class="page-link page-link-prev" href="#" aria-label="Previous" tabindex="-1" aria-disabled="true">
                                        <span aria-hidden="true"><i class="icon-long-arrow-left"></i></span>Prev
                                    </a>
                                </li>
                                <li class="page-item active" aria-current="page"><a class="page-link" href="#">1</a></li>
                                <li class="page-item active" aria-current="page"><a class="page-link" href="shop?pageNumber=1">1</a></li>
                                <li class="page-item"><a class="page-link" href="shop?pageNumber=3">3</a></li> -->
                                <li class="page-item-total">of ${numberOfPages}</li>
                            </ul>
                        </nav>
                    </div><!-- End .col-lg-9 -->
                    <aside class="col-lg-3 order-lg-first">
                        <div class="sidebar sidebar-shop">
                            <c:if test="${!empty filtration}" >
                                <div class="widget widget-clean">
                                    <label>Filters:</label>
                                    <a href="shop" class="sidebar-filter-clear">Clean All</a>
                                </div><!-- End .widget widget-clean -->
                            </c:if>
                            <div class="widget widget-collapsible">
                                <h3 class="widget-title">
                                    <a data-toggle="collapse" href="#widget-1" role="button" aria-expanded="true" aria-controls="widget-1">
                                        Category
                                    </a>
                                </h3><!-- End .widget-title -->

                                <div class="collapse show" id="widget-1">
                                    <div class="widget-body">
                                        <div class="filter-items filter-items-count">
                                            <div class="filter-item">
                                                <div class="custom-control custom-checkbox">
                                                    <input type="checkbox" class="custom-control-input" id="laptopCatCheckBox">
                                                    <label class="custom-control-label"  for="laptopCatCheckBox">Computers & Laptops</label> <!-- TODO -->
                                                </div><!-- End .custom-checkbox -->
                                                <span class="item-count" id="categoryProductsNumber">${laptopsCount}</span>
                                            </div><!-- End .filter-item -->

                                            <div class="filter-item">
                                                <div class="custom-control custom-checkbox">
                                                    <input type="checkbox" class="custom-control-input" id="watchCatCheckBox">
                                                    <label class="custom-control-label" for="watchCatCheckBox">Smart Watches</label>
                                                </div><!-- End .custom-checkbox -->
                                                <span class="item-count">${watchesCount}</span>
                                            </div><!-- End .filter-item -->

                                            <div class="filter-item">
                                                <div class="custom-control custom-checkbox">
                                                    <input type="checkbox" class="custom-control-input" id="mobileCatCheckBox">
                                                    <label class="custom-control-label" for="mobileCatCheckBox">Smart Phones</label>
                                                </div><!-- End .custom-checkbox -->
                                                <span class="item-count">${mobilesCount}</span>
                                            </div><!-- End .filter-item -->


                                        </div><!-- End .filter-items -->
                                        <div style="margin-top: 25px;">
                                            <center>
                                                <a class="btn btn-outline-primary btn-round" id="categoryFilterbutton" onclick="filterByCategory()">Filter</a>
                                            </center>
                                        </div>
                                    </div><!-- End .widget-body -->
                                </div><!-- End .collapse -->
                            </div><!-- End .widget -->

<%--                            <div class="widget widget-collapsible">--%>
<%--                                <h3 class="widget-title">--%>
<%--                                    <a data-toggle="collapse" href="#widget-5" role="button" aria-expanded="true" aria-controls="widget-5">--%>
<%--                                        Price--%>
<%--                                    </a>--%>
<%--                                </h3><!-- End .widget-title -->--%>

<%--                                <div class="collapse show" id="widget-5">--%>
<%--                                    <div class="widget-body">--%>
<%--                                        <div class="filter-price">--%>
<%--                                            <div class="filter-price-text">--%>
<%--                                                Price Range:--%>
<%--                                                <span id="filter-price-range"></span>--%>
<%--                                            </div><!-- End .filter-price-text -->--%>

<%--                                            <div id="price-slider"></div><!-- End #price-slider -->--%>
<%--                                        </div><!-- End .filter-price -->--%>
<%--                                    </div><!-- End .widget-body -->--%>
<%--                                </div><!-- End .collapse -->--%>
<%--                            </div><!-- End .widget -->--%>
                        </div><!-- End .sidebar sidebar-shop -->
                    </aside><!-- End .col-lg-3 -->
                </div><!-- End .row -->
            </div><!-- End .container -->
        </div><!-- End .page-content -->
    </main><!-- End .main -->

    <%@ include file="includes/footer.jsp" %><!-- End .footer -->
</div><!-- End .page-wrapper -->
<button id="scroll-top" title="Back to Top"><i class="icon-arrow-up"></i></button>

<!-- Mobile Menu -->
    <%@ include file="includes/sideMobileMenu.jsp" %><!-- End .mobile-menu-container -->


<!-- Plugins JS File -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/jquery.hoverIntent.min.js"></script>
<script src="assets/js/jquery.waypoints.min.js"></script>
<script src="assets/js/superfish.min.js"></script>
<script src="assets/js/owl.carousel.min.js"></script>
<script src="assets/js/wNumb.js"></script>
<script src="assets/js/bootstrap-input-spinner.js"></script>
<script src="assets/js/jquery.magnific-popup.min.js"></script>
<script src="assets/js/nouislider.min.js"></script>
<!-- Main JS File -->
<script src="assets/js/main.js"></script>


<script>
    $(document).ready(function(){

        $("#productsView4").click(function(){

            $("[id=productsView]").attr('class', 'col-6 col-md-4 col-lg-4 col-xl-3');
            $('#productsView3').attr('class','btn-layout');
            $('#productsView2').attr('class','btn-layout');
            $("#productsView4").attr('class','btn-layout active');

        });
        $("#productsView3").click(function(){

            $("[id=productsView]").attr('class', 'col-6 col-md-4 col-lg-4');
            $('#productsView4').attr('class','btn-layout');
            $('#productsView2').attr('class','btn-layout');
            $("#productsView3").attr('class','btn-layout active');

        });
        $("#productsView2").click(function(){

            $("[id=productsView]").attr('class', 'col-6');
            $('#productsView3').attr('class','btn-layout');
            $('#productsView4').attr('class','btn-layout');
            $("#productsView2").attr('class','btn-layout active');

        });
    });
    function filterByCategory(){

        var laptops = document.getElementById("laptopCatCheckBox").checked;
        var mobiles = document.getElementById("mobileCatCheckBox").checked;
        var watches = document.getElementById("watchCatCheckBox").checked;

        if((laptops && mobiles && watches)||(!laptops && !mobiles && !watches)){
            window.location.href = "shop";
        }
        else{
            window.location.href = "filter?laptops="+laptops+"&mobiles="+mobiles+"&watches="+watches;
        }

        // var productView = document.getElementById("productsView");
        //
        // $("#productsContainer").hide();
        // $("#laptopsContainer").hide();
        // $("#mobileContainer").hide();
        // $("#watchContainer").hide();
        // $("#mobAndWatchContainer").hide();
        // $("#mobAndLapContainer").hide();
        // $("#watchAndLapContainer").hide();
        //
        // if((laptops && mobiles && watches)||(!laptops && !mobiles && !watches)){
        //     $("#productsContainer").show();
        // }
        // else{
        //     if (laptops){
        //         if(mobiles){
        //             window.location.href = "filter?laptop=1&mobile=1"
        //             $("#mobAndLapContainer").attr("hidden",false);
        //             $("#mobAndLapContainer").show();
        //         }
        //         else if(watches){
        //             $("#watchAndLapContainer").attr("hidden",false);
        //             $("#watchAndLapContainer").show();
        //         }
        //         else{
        //             $("#laptopsContainer").attr("hidden",false);
        //             $("#laptopsContainer").show();
        //         }
        //     }else if(mobiles){
        //         if(watches){
        //             $("#mobAndWatchContainer").attr("hidden",false);
        //             $("#mobAndWatchContainer").show();
        //         }
        //         else{
        //             $("#mobileContainer").attr("hidden",false);
        //             $("#mobileContainer").show();
        //         }
        //     }else{
        //         $("#watchContainer").attr("hidden",false);
        //         $("#watchContainer").show();
        //     }
        // }
        //
        //

    }


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
    function CartItem(id, quantity) {
        this.id = id;
        this.quantity = quantity;
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
    function loadFilteredPageNo(pageNumber){
        let urlString = window.location.href;
        let paramString = urlString.split('&')[0]+"&"+urlString.split('&')[1]+"&"+urlString.split('&')[2];
        window.location.href = paramString+"&pageNumber="+pageNumber;

    }
    window.onload= (event) => {
        let urlString = window.location.href;
        let paramString = urlString.split('?')[1];
        let queryString = new URLSearchParams(paramString);
        let newQueryString = urlString.split('?')[0]+"?";
        for (let pair of queryString.entries()) {
            if(pair[0] === "laptops" && pair[1]==="true") {

                window.document.getElementById("laptopCatCheckBox").checked = true;
            }
            if(pair[0] === "mobiles" && pair[1]==="true") {
                window.document.getElementById("mobileCatCheckBox").checked = true;
            }
            if(pair[0] === "watches" && pair[1]==="true") {
                window.document.getElementById("watchCatCheckBox").checked = true;
            }
        }
        addToCart(-1)
        addToWishList(-1)


    };
    function sortProducts(){
        $("#productsContainer").hide();
        $("#sortByPriceAsc").hide();
        $("#sortByPriceDesc").hide();
        $("#sortByDate").hide();
        let select = document.getElementById("sortby");
        console.log(select.value === "priceAsc");
        if (select.value === "priceAsc") {
            console.log("msh fahem")
            $("#sortByPriceAsc").attr("hidden",false);
            $("#sortByPriceAsc").show();

        }
        if (select.value === "priceDesc") {
            $("#sortByPriceDesc").attr("hidden",false);
            $("#sortByPriceDesc").show();
            }
        if (select.value === "date") {
            $("#sortByDate").attr("hidden",false);
            $("#sortByDate").show();
        }
        if (select.value === "oldest") {$("#productsContainer").show();}
    }
    // function getPageProducts(pageNumber) {
    //     if (window.XMLHttpRequest) {
    //         request = new XMLHttpRequest();
    //     }
    //     else if (window.ActiveXObject) {
    //         request = new ActiveXObject("Microsoft.XMLHTTP");
    //     }
    //
    //     request.onreadystatechange = handleStateChanges;
    //     // yourvalue = this.textContent;
    //
    //     url = "shop?pageNumber="+ pageNumber + "&timeStamp=" + new Date().getTime();
    //     request.open("GET", url, true);
    //     request.send(null);
    // }
    // function handleStateChanges() {
    //     if (request.readyState == 4 && request.status == 200) {
    //         xmlvalue = request.responseText;
    //         console.log(xmlvalue);
    //         window.document.innerHTML = xmlvalue;
    //     }
    // }
    // function handleStateChange() {
    //     if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
    //         document.getElementById("resultsTable").innerHTML = xmlHttp.responseText;
    // }


</script>

</body>


</html>


