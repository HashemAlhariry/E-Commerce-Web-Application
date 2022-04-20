<!DOCTYPE html>
<html lang="en">



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
        <center> <h4>  congratulation your order is placed successfully </h4></center>

        <br>
        <div class="summary summary-cart">
            <h3 class="summary-title">User Details</h3>
            <table class="table table-cart table-mobile">
                <tbody>

                    <tr>
                        <td class="product-col">
                            <div class="product">



                                <h3 class="product-title">
                                  Mobile Number: &ensp;  ${mobileNumber}
                                </h3>


                            </div>
                        </td>
                    </tr>
                        <td class="product-col">
                            <div class="product">

                                <h3 class="product-title">
                                 Total Number:   &ensp;  ${total}
                                </h3>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="product-col">
                            <div class="product">

                                <h3 class="product-title">
                                    Address:   &ensp;  ${userAddress}
                                </h3>
                            </div>
                        </td>
                    </tr>

                </tbody>
            </table>
        </div>
        
        <br>
        <center>
            <form action="AcceptPaymentServlet" method="POST">
                <script
                        src="https://checkout.stripe.com/checkout.js" class="stripe-button"
                        data-key="pk_test_51KmFuOJKNiBLygtkyrLQtjXf9p2BqxMmRR2miQElRuUeFWe9bN3BCx5zZz2KIfCxnV0ryIp1R1jMGsHYvIAfRSt900kuf0CNie"
                        data-amount="${total}"
                        data-name="Amazonya"
                        data-description="your online store"
                        data-image="https://stripe.com/img/documentation/checkout/marketplace.png"
                        data-locale="auto"
                        data-currency="egp">
                </script>
            </form>
        </center>

        <br>
        <center>
            <a href="home">Or Cash On Delivery</a>
        </center>
        <br>

    </main>

    <%@ include file="includes/footer.jsp" %><!-- End .footer -->
</div><!-- End .page-wrapper -->

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