<!DOCTYPE html>
<html lang="en" dir="ltr">
<%
    response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
%>


<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title> </title>
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
    <meta name="apple-mobile-web-app-title" content="Amazony">
    <meta name="application-name" content="Amazony">
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

        <div class="container">
            <div class="page-header page-header-big text-center" style="background-image: url('assets/images/faq.png')">


            </div><!-- End .page-header -->
        </div><!-- End .container -->

        <div class="page-content pb-0">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 mb-3 mb-lg-0">
<%--                        <h2 class="title">QA part </h2><!-- End .title -->--%>
                        <br>
    <p><b>How can i get data set regarding smart home and green house gas emssion from smart homes?</b></p>
                        <p>I strongly recommend you use secondary data and, after that, justify why you opted for secondary research. Ojo Ademola, on one of his questions on Secondary Research, made such a justification. Kindly check it out!</p>
                        </br>

                        <br>
    <p><b>Why does my laptop fan turn on?</b></p>
                        <p>Laptops are designed to be compact. Their sleek design makes them easily portable but also creates challenges when managing heat. Because the components inside a laptop are tightly packed together, they can heat up easily. Airflow inside the laptop is essential to keep the components from overheating.</p>
                        </br>

                        <br>
    <p><b>Why has my laptop gotten slower?</b></p>
                        <p>It seems inevitable. Over time, computers get slower. Sometimes it just feels that way since other devices get faster, but it is also possible that your laptop has actually gotten slower since you first started using it. Below are a few reasons why the slowdown may have occurred, along with possible solutions.</p>
                        </br>

                        <br>
    <p><b>What Is A Smartwatch?</b></p>
                        <p>Smartwatch of today is basically a smartphone that you wear on your wrist like a normal watch. While early models could perform basic tasks, 2010s smartwatches have more general functionality closer to smartphones, including mobile apps, a mobile operating system and WiFi/Bluetooth connectivity.</p>
                   </br>

                        <br>
    <p><b>Do You Really Need A Smartwatch?</b></p>
                        <p>If you have survived this long without one, then no, you don’t need one. The same question can apply to a normal watch. Do you need to wear a watch that only tells the time in the age when we are surrounded by screens ranging from monitors to mobile phones and you can know what the time is in a second. Still, plenty of people wear watches as status symbols, as fashion accessories or just because they look great. All of these are valid reasons for a person to wear a watch.</p>
                     </br>
                    </div>
                </div>
            </div><!-- End .col-lg-6 -->


<br>
<%@ include file="includes/footer.jsp" %><!-- End .footer -->
</div><!-- End .page-wrapper -->
<button id="scroll-top" title="Back to Top"><i class="icon-arrow-up"></i></button>

        <!-- Mobile Menu -->
        <%@ include file="includes/sideMobileMenu.jsp" %><!-- End .mobile-menu-container -->

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



</html>