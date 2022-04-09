<!DOCTYPE html>
<html lang="en">


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

        <br>
        <br>
        <form onsubmit="post('order-completion','post')" method="post" id ="form">
        <div class="summary summary-cart">

            <h3 class="summary-title">Order Details</h3><!-- End .summary-title -->
            <table class="table table-summary">
                <tbody>
                <tr class="summary-subtotal">

                    <td>Subtotal:</td>
                    <td>${subTotal}</td>

                </tr>
                <tr class="summary-subtotal">
                    <td>Delivery:</td>
                    <td>100</td>
                </tr>
                <br>
                <br>
                <tr class="summary-shipping-estimate">

                        <div class="form-group">
                            <label for="phoneNumber">Phone Number *</label>
                            <input type="number" class="form-control" id="phoneNumber" name="phoneNumber" required>
                        </div>

                        <div class="form-group">
                            <label for="userEmail">email *</label>
                            <input type="email" class="form-control" id="userEmail" name="userEmail" required>
                        </div>

                        <div class="form-group">
                            <label for="userAddress">address *</label>
                            <input type="text" class="form-control" id="userAddress" name="userAddress" required>
                        </div>

                </tr>

                <tr class="summary-total">
                    <td>Total:</td>
                    <td>${total}</td>

                </tr>

                <input type="hidden" name="cartItems"  value=${cartItems}/>
                <input type="hidden" name="total"  value=${total}/>
                </tbody>
            </table><!-- End .table table-summary -->

            <button type="submit" class="btn btn-outline-primary-2 btn-order btn-block">
                <span>SUBMIT ORDER</span>

            </button>

        </div>

        </form>
        <br>
        <br>
        <div class="summary summary-cart">

            <h3 class="summary-title">Quantity available</h3>
            <table class="table table-summary">
                <tbody>
                <br>
                    <c:forEach items="${availabilityProducts}" var="quantity" >
                    <tr class="summary-subtotal">
                        <div class="form-group">
                            <label for="phoneNumber">${quantity}</label>
                        </div>

                    </tr>
                    </c:forEach >

                </tbody>
            </table>


        </div>
    </main><!-- End .main -->

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
<script>
    function post(path,method='post') {


        const form = document.getElementById('form');
        form.method = method;
        form.action = path;

        const hiddenField = document.createElement('input');
        hiddenField.type = 'hidden';
        hiddenField.name = 'cart';
        hiddenField.value =  localStorage.getItem("cartItems");

        form.appendChild(hiddenField);
        form.submit();

    }
</script>
</body>

</html>