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
        <br>
        <div class="summary summary-cart">
            <h2>Orders</h2>

            <table class="table table-cart table-mobile">
                <tbody>
                <c:forEach items="${orderHistoryList}" var="orderHistory">
                    <tr>
                        <td class="product-col">
                            <h3>Order Number:  &ensp; ${orderHistory.orderId}</h3>
                            <br>


                            <div class="product">
                                <h6   >Order State: &ensp; ${orderHistory.state}</h6>
                            </div>
                            <br>
                            <div class="product">
                                <h6>Total Price: &ensp; ${orderHistory.totalPrice} </h6>

                            </div>
                            <br>
                            <div class="product">
                                <h6>Email: &ensp; ${orderHistory.email} </h6>

                            </div>
                            <br>
                            <div class="product">
                                <h6>Date: &ensp;  ${orderHistory.dateTime} </h6>

                            </div>
                            <br>
                            <div class="product">
                                <h6>Phone Number: &ensp; ${orderHistory.phoneNumber} </h6>

                            </div>
                            <br>
                            <div class="product">
                                <h6>address: &ensp; ${orderHistory.address} </h6>
                            </div>
                            <br>
                            <c:forEach items="${orderHistory.orderDetailsBeanList}" var="orderDetails">
                            <div class="product">
                                <figure class="product-media">
                                    <a  href="single-product-page?productId=${orderDetails.product.id}">
                                        <img src="${orderDetails.product.mainImage}" alt="Product image">
                                    </a>
                                </figure>

                                <h3 class="product-title">
                                    <a href="single-product-page?productId=${orderDetails.product.id}">
                                            ${orderDetails.product.name} &ensp;
                                    ${orderDetails.product.price}  X ${orderDetails.quantity}</a>
                                </h3>
                            </div><br>
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <br>
    </main>

    <%@ include file="includes/footer.jsp" %><!-- End .footer -->
</div><!-- End .page-wrapper -->

<!-- Mobile Menu -->
<%@ include file="includes/sideMobileMenu.jsp" %><!-- End .mobile-menu-container -->

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
<script>

    window.onload= (event) => {
        console.log("on documentLoad")
        if(!navigator.cookieEnabled) {
            window.location.href = "un-enabled-cookie";
        }else{
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
    function callStripeScript(){

    }
</script>


</html>