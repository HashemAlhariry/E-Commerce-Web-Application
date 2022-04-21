<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <c:if test="${!empty requestScope.errorMessage}">
            <div class="alert alert-warning alert-dismissible fade show" role="alert" style="text-align: center">
                <strong>Warning </strong> ${errorMessage}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
        <div class="page-header text-center" style="background-image: url('assets/images/page-header-bg.jpg')">
            <div class="container">
                <h1 class="page-title">Shopping Cart<span>Shop</span></h1>
            </div><!-- End .container -->
        </div><!-- End .page-header -->
        <nav aria-label="breadcrumb" class="breadcrumb-nav">
            <div class="container">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="home">Home</a></li>
                    <li class="breadcrumb-item"><a href="shop">Shop</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Shopping Cart</li>
                </ol>
            </div><!-- End .container -->
        </nav><!-- End .breadcrumb-nav -->

        <div class="page-content">
            <div class="cart" id="cart">
                <c:if test="${!empty(cartItemBeans) }">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-9">
                                <table class="table table-cart table-mobile">
                                    <thead>
                                    <tr>
                                        <th>Product</th>
                                        <th>Price</th>
                                        <th>Quantity</th>
                                        <th>Total</th>
                                        <th></th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                    <c:forEach items="${cartItemBeans}" var="cartItem" >
                                        <tr id="productRow${cartItem.productBean.id}">
                                            <td class="product-col">
                                                <div class="product">
                                                    <figure class="product-media">
                                                        <a href="single-product-page?productId=${cartItem.productBean.id}">
                                                            <img src="${cartItem.productBean.mainImage} " alt="Product image">
                                                        </a>
                                                    </figure>

                                                    <h3 class="product-title">
                                                        <a href="single-product-page?productId=${cartItem.productBean.id}">${cartItem.productBean.name}</a>
                                                    </h3><!-- End .product-title -->
                                                </div><!-- End .product -->
                                            </td>
                                            <td class="price-col">${cartItem.productBean.price} EGP</td>
                                            <td class="quantity-col">
                                                <div class="cart-product-quantity">
                                                    <input type="number" id="${cartItem.productBean.id}" name="quantityInput" class="form-control" value="${cartItem.requiredQuantity}" min="1" max="${cartItem.productBean.quantity}" step="1" data-decimals="0" required>
                                                </div><!-- End .cart-product-quantity -->
                                            </td>
                                            <td class="total-col" style="font-size: small">${(cartItem.productBean.price)*(cartItem.requiredQuantity)} EGP</td>
                                            <td class="remove-col"><button class="btn-remove" onclick="removeProduct(${cartItem.productBean.id},${cartItem.productBean.price})"><i class="icon-close"></i></button></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>

                                </table><!-- End .table table-wishlist -->

                                <div class="cart-bottom">
                                    <div class="cart-discount">
                                        <form action="#">
                                            <div class="input-group">
                                                <input type="text" class="form-control" required placeholder="coupon code">
                                                <div class="input-group-append">
                                                    <button class="btn btn-outline-primary-2" type="submit"><i class="icon-long-arrow-right"></i></button>
                                                </div><!-- .End .input-group-append -->
                                            </div><!-- End .input-group -->
                                        </form>
                                    </div><!-- End .cart-discount -->

                                    <a onclick="updateCart()" class="btn btn-outline-dark-2"><span>UPDATE CART</span><i class="icon-refresh"></i></a>
                                </div><!-- End .cart-bottom -->
                            </div><!-- End .col-lg-9 -->
                            <aside class="col-lg-3">
                                <div class="summary summary-cart">
                                    <h3 class="summary-title">Cart Total</h3><!-- End .summary-title -->

                                    <table class="table table-summary">
                                        <tbody>
                                        <tr class="summary-subtotal">
                                            <td >Subtotal:</td>

                                            <td id="subTotalValue">${subTotal} EGP</td>

                                        </tr><!-- End .summary-subtotal -->
                                        <tr class="summary-shipping">
                                            <td>Shipping:</td>
                                            <td>&nbsp;</td>
                                        </tr>

                                        <tr class="summary-shipping-row">
                                            <td>
                                                <div class="custom-control custom-radio">
                                                    <input type="radio" id="free-shipping" name="shipping" class="custom-control-input">
                                                    <label class="custom-control-label" for="free-shipping">Free Shipping</label>
                                                </div><!-- End .custom-control -->
                                            </td>
                                            <td>0</td>
                                        </tr><!-- End .summary-shipping-row -->

                                        <tr class="summary-shipping-row">
                                            <td>
                                                <div class="custom-control custom-radio">
                                                    <input type="radio" id="standart-shipping" name="shipping" class="custom-control-input">
                                                    <label class="custom-control-label" for="standart-shipping">Standart:</label>
                                                </div><!-- End .custom-control -->
                                            </td>
                                            <td>10</td>
                                        </tr><!-- End .summary-shipping-row -->

                                        <tr class="summary-shipping-row">
                                            <td>
                                                <div class="custom-control custom-radio">
                                                    <input type="radio" id="express-shipping" name="shipping" class="custom-control-input">
                                                    <label class="custom-control-label" for="express-shipping">Express:</label>
                                                </div><!-- End .custom-control -->
                                            </td>
                                            <td>20</td>
                                        </tr><!-- End .summary-shipping-row -->

                                        <tr class="summary-total">
                                            <td>Total:</td>
                                            <td id="totalValue">${subTotal}</td>
                                        </tr><!-- End .summary-total -->
                                        </tbody>
                                  </table><!-- End .table table-summary -->

                                <a href="order-details" id="checkoutButton" class="btn btn-outline-primary-2 btn-order btn-block">PROCEED TO CHECKOUT</a>
                            </div><!-- End .summary -->

                            <a href="shop" class="btn btn-outline-dark-2 btn-block mb-3"><span>CONTINUE SHOPPING</span><i class="icon-refresh"></i></a>
                        </aside><!-- End .col-lg-3 -->
                    </div><!-- End .row -->
                </div><!-- End .container -->
                </c:if>
                <c:if test="${cartItemBeans.size()==0}" >
                    <div class="text-center" style="padding-top: 10px;background-image: url('assets/images/page-header-bg.jpg'); margin-left: 150px;margin-right: 150px; align-self: center">
                        <div class="container">
                            <h4 style="margin-top: 10px;" class="page-title">Cart is Empty</h4>
                            <a style="width: 0%;border-color: orange" href="shop" class="btn btn-outline-dark-2 btn-block mb-3"><span>Start SHOPPING</span><i class="icon-refresh"></i></a>
                        </div><!-- End .container -->
                    </div>
                </c:if>
            </div><!-- End .cart -->
        </div><!-- End .page-content -->
        <c:if test="${!empty jsonCart}">
            <div id="hiddenJsonCart" hidden>${jsonCart}</div>
        </c:if>
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
<script src="assets/js/bootstrap-input-spinner.js"></script>
<!-- Main JS File -->
<script src="assets/js/main.js"></script>
</body>
<script>
    window.onload = (event) => {
        var jsonCart  = document.getElementById("hiddenJsonCart").textContent;
        localStorage.setItem("cartItems",jsonCart);
        addToCart(-1);
        addToWishList(-1);

    };
    function removeProduct(productId , productPrice){
        console.log(productId+" awl marra ");
        var localStorageContent = localStorage.getItem("cartItems");
        let cartItems = JSON.parse(localStorageContent);
        for(var i=0 ; i<cartItems.length ; i++){
            if (cartItems[i].id === productId){
                var quantity = cartItems[i].quantity;
                cartItems.splice(i,1);
                var oldSubTotal = parseInt(document.getElementById("subTotalValue").textContent);
                var subTotal = oldSubTotal - (productPrice * quantity);
                document.getElementById("subTotalValue").textContent = subTotal.toString()+" EGP";
                var oldTotal = parseInt(document.getElementById("totalValue").textContent);
                var total = oldTotal - (productPrice * quantity);
                if(subTotal ===0){
                    document.getElementById("totalValue").textContent = "0 EGP";
                }
                else{
                    document.getElementById("totalValue").textContent = total.toString()+" EGP";
                }
                localStorage.setItem('cartItems', JSON.stringify(cartItems));
                document.getElementById("productRow"+productId).remove();
                break;
            }
        }
        if(cartItems.length === 0){
            console.log(cartItems.length)
            document.getElementById("checkoutButton").style.visibility= 'hidden';
        }
        document.getElementById("cartItemsNumber").textContent =  cartItems.length;
        if(cartItems.length===0){
            window.location.href= "cart"  // TODO With Ajax
        }

    }
    const radioButtons = document.querySelectorAll('input[name="shipping"]');
    for (const radioButton of radioButtons) {
        radioButton.addEventListener('change', changeTotal);
    }
    function changeTotal(e){
        if(this.checked){
            const subTotal = parseInt(document.getElementById("subTotalValue").textContent);
            const shippingValue = parseInt(this.parentElement.parentElement.nextElementSibling.innerText);
            const total = subTotal + shippingValue;
            document.getElementById("totalValue").textContent = total.toString()+" EGP";

        }
    }
    function updateCart(){
        const quantityInputs = document.querySelectorAll('input[name="quantityInput"]');
        let subTotal = 0
        for (const quantityInput of quantityInputs){
            var localStorageContent = localStorage.getItem("cartItems");
            let cartItems = JSON.parse(localStorageContent);
            for(var i=0 ; i<cartItems.length ; i++){
                if (cartItems[i].id === parseInt(quantityInput.id)){
                    cartItems[i].quantity = quantityInput.value;
                    break;
                }
            }
            localStorage.setItem('cartItems', JSON.stringify(cartItems));
            console.log(quantityInput.parentElement.parentElement.previousElementSibling.textContent.split(" ")[0]);
            let productPrice = parseInt(quantityInput.parentElement.parentElement.previousElementSibling.textContent.split(" ")[0]);
            let productTotalPrice = productPrice * quantityInput.value;
            subTotal += productTotalPrice;
            quantityInput.parentElement.parentElement.nextElementSibling.textContent = productTotalPrice+ " EGP";
            //console.log(quantityInput.parentElement.previousElementSibling.textContent);
        }
        document.getElementById("subTotalValue").textContent = subTotal + " EGP";
        const radioButtons = document.querySelectorAll('input[name="shipping"]');
        for (const radioButton of radioButtons) {
            console.log(radioButton.checked);
            if(radioButton.checked){
                const shippingValue = parseInt(radioButton.parentElement.parentElement.nextElementSibling.innerText);
                subTotal += shippingValue;
            }
        }
        document.getElementById("totalValue").textContent = subTotal.toString()+" EGP";
    }
    if ( window.history.replaceState ) {
        window.history.replaceState( null, null, window.location.href );
    }

</script>


</html>