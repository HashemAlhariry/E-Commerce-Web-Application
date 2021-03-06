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
        <c:if test="${!empty errorMessage}">
            <div class="alert alert-warning alert-dismissible fade show" role="alert" style="text-align: center">
                <strong>Error</strong> ${errorMessage}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <%session.removeAttribute("errorMessage");%>
        </c:if>

        <div class="login-page bg-image pt-8 pb-8 pt-md-12 pb-md-12 pt-lg-17 pb-lg-17" style="background-image: url('assets/images/backgrounds/login-bg2.jpg')">
            <div class="container">
                <div class="form-box">
                    <div class="form-tab">
                        <ul class="nav nav-pills nav-fill" role="tablist">

                            <li class="nav-item">
                                <a class="nav-link active" id="signin-tab-2" data-toggle="tab" href="#signin-2" role="tab" aria-controls="signin-2" aria-selected="true">Sign In</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link " id="register-tab-2" data-toggle="tab" href="#register-2" role="tab" aria-controls="register-2" aria-selected="false">Register</a>
                            </li>


                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane fade show active" id="signin-2" role="tabpanel" aria-labelledby="signin-tab-2">
                                <form action="login" method="POST" id="loginform">
                                    <div class="form-group">
                                        <label for="signup-email-2">email address *</label>
                                        <input type="text" class="form-control" id="signup-email-2" name="signup-email" required>
                                    </div><!-- End .form-group -->

                                    <div class="form-group">
                                        <label for="signup-password-2">Password *</label>
                                        <input type="password" class="form-control" id="signup-password-2" name="signup-password" required>
                                    </div><!-- End .form-group -->

                                    <div class="form-footer">
                                        <button type="submit" class="btn btn-outline-primary-2">
                                            <span>LOG IN</span>
                                            <i class="icon-long-arrow-right"></i>
                                        </button>

                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="signin-remember-2" name="rememberMe">
                                            <label class="custom-control-label" for="signin-remember-2">Remember Me</label>
                                        </div><!-- End .custom-checkbox -->

                                    </div><!-- End .form-footer -->
                                    <div style="padding-top: 20px;padding-bottom: 20px;">
                                        <a href="#forgot-password-modal" data-toggle="modal" class="forgot-link">Forgot Your Password?</a>
                                    </div>
                                </form>
                                <%--							    	<div class="form-choice">--%>
                                <%--								    	<p class="text-center">or sign in with</p>--%>
                                <%--								    	<div class="row">--%>
                                <%--								    		<div class="col-sm-6">--%>
                                <%--								    			<a href="#" class="btn btn-login btn-g">--%>
                                <%--								    				<i class="icon-google"></i>--%>
                                <%--								    				Login With Google--%>
                                <%--								    			</a>--%>
                                <%--								    		</div><!-- End .col-6 -->--%>
                                <%--								    		<div class="col-sm-6">--%>
                                <%--								    			<a href="#" class="btn btn-login btn-f">--%>
                                <%--								    				<i class="icon-facebook-f"></i>--%>
                                <%--								    				Login With Facebook--%>
                                <%--								    			</a>--%>
                                <%--								    		</div><!-- End .col-6 -->--%>
                                <%--								    	</div><!-- End .row -->--%>
                                <%--							    	</div><!-- End .form-choice -->--%>
                            </div>
                            <div class="tab-pane fade " id="register-2" role="tabpanel" aria-labelledby="register-tab-2">
                                <form action="registration" id="regster-form" method="POST">
                                    <div class="form-group">
                                        <label for="register-name-2">name *</label>
                                        <input type="text" class="form-control" id="register-name-2" name="register_name" required>
                                    </div><!-- End .form-group -->

                                    <div class="form-group">
                                        <label for="register-birthday-2">birthday date *</label>
                                        <input type="date" class="form-control" id="register-birthday-2" name="register_birthday" required>
                                    </div><!-- End .form-group -->

                                    <div class="form-group">
                                        <label for="register-email-2">email *</label>
                                        <input type="email" class="form-control" id="register-email-2" name="register_email" required>
                                    </div><!-- End .form-group -->


                                    <div class="form-group">
                                        <label for="register-password-2">Password *</label>
                                        <input type="password" class="form-control" id="register-password-2" name="register_password" required>
                                    </div><!-- End .form-group -->

                                    <div class="form-group">
                                        <label for="register-password-2">Confirm Password *</label>
                                        <input type="password" class="form-control" id="confirm-register-password-2" name="confirm_register_password" required>
                                    </div><!-- End .form-group -->

                                    <%--                                        <div class="form-group">--%>
                                    <%--                                            <label for="register-jop-2">job *</label>--%>
                                    <%--                                            <input type="text" class="form-control" id="register-jop-2" name="register-job" required>--%>
                                    <%--                                        </div><!-- End .form-group -->--%>

                                    <div class="form-group">
                                        <label for="register-address-2">address *</label>
                                        <input type="text" class="form-control" id="register-address-2" name="register_address" required>
                                    </div><!-- End .form-group -->


                                    <%--                                        <div class="form-group">--%>
                                    <%--                                            <label for="register-credit limit-2">credit limit *</label>--%>
                                    <%--                                            <input type="text" class="form-control" id="register-credit limit-2" name="register-credit limit" required>--%>
                                    <%--                                        </div><!-- End .form-group -->--%>

                                    <div class="form-footer">
                                        <button type="button" id="register-submit" class="btn btn-outline-primary-2">
                                            <span>SIGN UP</span>
                                            <i class="icon-long-arrow-right"></i>
                                        </button>
                                    </div><!-- End .form-footer -->

                                    <div class="form-group">
                                        <ul id="errorMessage"></ul>
                                    </div><!-- End .form-group -->

                                </form>
                                <%--							    	<div class="form-choice">--%>
                                <%--								    	<p class="text-center">or sign in with</p>--%>
                                <%--								    	<div class="row">--%>
                                <%--								    		<div class="col-sm-6">--%>
                                <%--								    			<a href="#" class="btn btn-login btn-g">--%>
                                <%--								    				<i class="icon-google"></i>--%>
                                <%--								    				Login With Google--%>
                                <%--								    			</a>--%>
                                <%--								    		</div><!-- End .col-6 -->--%>
                                <%--								    		<div class="col-sm-6">--%>
                                <%--								    			<a href="#" class="btn btn-login  btn-f">--%>
                                <%--								    				<i class="icon-facebook-f"></i>--%>
                                <%--								    				Login With Facebook--%>
                                <%--								    			</a>--%>
                                <%--								    		</div><!-- End .col-6 -->--%>
                                <%--								    	</div><!-- End .row -->--%>
                                <%--							    	</div><!-- End .form-choice -->--%>
                            </div>
                        </div><!-- End .tab-content -->
                    </div><!-- End .form-tab -->
                </div><!-- End .form-box -->
            </div><!-- End .container -->
        </div><!-- End .login-page section-bg -->
    </main><!-- End .main -->

    <%@ include file="includes/footer.jsp" %><!-- End .footer -->
</div><!-- End .page-wrapper -->
<button id="scroll-top" title="Back to Top"><i class="icon-arrow-up"></i></button>

<!-- Mobile Menu -->
<%@ include file="includes/sideMobileMenu.jsp" %><!-- End .mobile-menu-container -->

<!-- Sign in / Register Modal -->
<div class="modal fade" id="forgot-password-modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="returnForm()">
                    <span aria-hidden="true"><i class="icon-close"></i></span>
                </button>

                <div class="form-box" id="form">
                    <div class="form-tab" >
                        <div class="tab-content" id="tab-content-5">
                            <div class="tab-pane fade show active" id="recover-password" role="tabpanel" aria-labelledby="recovery-tab">
                                <form action="forgotPassword" method="post" id="myForm">
                                    <div class="form-group">
                                        <label for="recoveryEmail">Email address *</label>
                                        <input type="text" class="form-control" id="recoveryEmail" name="recoveryEmail" required>
                                    </div><!-- End .form-group -->

                                    <div class="form-footer">
                                        <button type="submit" class="btn btn-outline-primary-2" id="sendEmailButton">
                                            <span>Send Email</span>
                                            <i class="icon-long-arrow-right"></i>
                                        </button>
                                    </div><!-- End .form-footer -->
                                </form>
                            </div><!-- .End .tab-pane -->
                        </div><!-- End .tab-content -->
                    </div><!-- End .form-tab -->
                </div><!-- End .form-box -->
            </div><!-- End .modal-body -->
        </div><!-- End .modal-content -->
    </div><!-- End .modal-dialog -->
</div><!-- End .modal -->
<!-- plugins:js -->
<!-- plugins:js -->
<script src="assets/admin/vendors/js/vendor.bundle.base.js"></script>
<script src="assets/admin/vendors/js/vendor.bundle.addons.js"></script>
<!-- endinject -->
<!-- inject:js -->
<script src="assets/admin/js/off-canvas.js"></script>
<script src="assets/admin/js/hoverable-collapse.js"></script>
<script src="assets/admin/js/misc.js"></script>
<script src="assets/admin/js/settings.js"></script>
<script src="assets/admin/js/todolist.js"></script>
<script src="assets/admin/vendors/js/vendor.bundle.base.js"></script>
<script src="assets/admin/vendors/js/vendor.bundle.addons.js"></script>
<script src="assets/admin/js/alerts.js"></script>
<script src="assets/app-js/register-ajax.js"></script>

<!-- endinject -->
<!-- Plugins JS File -->
<%--    <script src="assets/js/jquery.min.js"></script>--%>
<%--    <script src="assets/js/bootstrap.bundle.min.js"></script>--%>
<%--    <script src="assets/js/jquery.hoverIntent.min.js"></script>--%>
<%--    <script src="assets/js/jquery.waypoints.min.js"></script>--%>
<%--    <script src="assets/js/superfish.min.js"></script>--%>
<%--    <script src="assets/js/owl.carousel.min.js"></script>--%>
<!-- Main JS File -->
<script src="assets/js/main.js"></script>
<script src="assets/js/register-validation.js"></script>

</body>

<script src="assets/js/amazonya/cookie-checker.js"></script>
<script>
    $(function () {
        $('#myForm').submit(function(event) {
            event.preventDefault();

            var actionUrl = $(this).attr('action');
            var formData = $(this).serialize();
            var sendElementButton = document.getElementById("sendEmailButton");
            sendElementButton.disabled = true;
            $("#form").append("<div class='d-flex justify-content-center' id='spinner'>" +
                "<div class='spinner-border' role='status'>" +
                "<span class='sr-only'>Loading...</span>" +
                "</div>" +
                "</div>");
            var form = document.getElementById("form");
            $.ajax({
                url: actionUrl,
                method: 'POST',
                dataType: 'json',
                data: formData,
                success: function(data) {
                    $('#form').children().last().remove();
                    $('#form')
                        .contents()
                        .filter(function() {
                            return this.nodeType == 3; //Node.TEXT_NODE
                        }).remove();

                    $('#form').append(data+'\n');
                    // $('#form').append("<div>"+data+"</div>");
                    document.getElementById("sendEmailButton").disabled = false;
                    console.log(data);
                },
                error: function (request, error){
                    $('#form').children().last().remove();
                    document.getElementById("sendEmailButton").disabled = false;


                    // form.append("<div class='d-flex justify-content-center' id='errorResponse' hidden=true style='padding-top: 20px;'>" +
                    // "<div>" +
                    // "<span > Server Error </span>" +
                    // "</div>" +
                    // "</div>");
                }
            });
        });
    });
    function returnForm(){
        var form = document.getElementById("form");
        var sendEmailButton = document.getElementById("sendEmailButton");
        sendEmailButton.disabled = false;
        //("#spinner").remove();
        // $('#form').children().last().remove();
        $('#form')
            .contents()
            .filter(function() {
                return this.nodeType == 3; //Node.TEXT_NODE
            }).remove();

    }
    window.onload = (event) => {
        if(!navigator.cookieEnabled) {
            window.location.href = "un-enabled-cookie";
        }else{
            addToCart(-1);
            addToWishList(-1);
            insertCartInForm();
        }

    };

    function insertCartInForm() {

        // The rest of this code assumes you are not using a library.
        // It can be made less verbose if you use one.
        const form = document.getElementById('loginform');

        const hiddenField = document.createElement('input');
        hiddenField.type = 'hidden';
        hiddenField.name = 'cart';
        hiddenField.value =  localStorage.getItem("cartItems");

        form.appendChild(hiddenField);


    }
</script>

</html>