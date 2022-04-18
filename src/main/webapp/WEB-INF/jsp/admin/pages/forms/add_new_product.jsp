<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">


<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Melody Admin</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/admin/vendors/iconfonts/font-awesome/css/all.min.css">
    <link rel="stylesheet" href="assets/admin/vendors/css/vendor.bundle.base.css">
    <link rel="stylesheet" href="assets/admin/vendors/css/vendor.bundle.addons.css">
    <!-- endinject -->
    <!-- plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="assets/admin/css/style.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="assets/admin/images/favicon.png"/>
    <link rel="shortcut icon" href="http://www.urbanui.com/"/>

</head>

<body>
<div class="container-scroller">
    <!-- partial:../../partials/_navbar.html -->
    <%@ include file="../../includes/header.jsp" %>



    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
        <!-- partial:../../partials/_settings-panel.html -->
        <%@ include file="../../includes/sidebar.jsp" %>
        <!-- partial -->
        <div class="main-panel">
            <div class="content-wrapper">
                <div class="page-header">
                    <h3 class="page-title">
                        Add New Product
                    </h3>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#">Product</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Add</li>
                        </ol>
                    </nav>
                </div>

                <!-- Load Model modal -->
<%--                <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-sm">Small modal</button>--%>

                <div class="modal fade bd-example-modal-sm" id="loader" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" data-backdrop="false" data-keyboard="false">
                    <div class="modal-dialog modal-sm">
                        <div class="modal-content">
                            <div class="loader-demo-box">
                                <div class="pixel-loader"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row grid-margin">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Product data</h4>
                                <form class="cmxform" id="productForm" method="post" action="admin-add-product"
                                      enctype="multipart/form-data">
                                    <fieldset>

                                        <div class="form-group">
                                            <label for="name">Name</label>
                                            <input id="name" class="form-control" name="name" minlength="2" maxlength="50" type="text"
                                                   required>
                                        </div>
                                        <div class="form-group">
                                            <label for="price">Price</label>
                                            <input id="price" class="form-control" name="price" type="number" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="quantity">Quantity</label>
                                            <input id="quantity" class="form-control" name="quantity" type="number"
                                                   required>
                                        </div>


                                        <div class="form-group">
                                            <label for="category">Category</label>
                                            <select class="form-control form-control-lg" id="category" name="category"
                                                    required>
                                                <c:forEach var="category" items="${currentCategories}">
                                                    <option value="${category.categoryId}">${category.categoryName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="form-group">
                                            <label for="description">Description</label>
                                            <textarea id="description" class="form-control" rows="5" maxlength="200"
                                                      name="description"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-lg-2 grid-margin stretch-card">
                                                    <div class="card">
                                                        <div class="card-body">
                                                            <h4 class="card-title">Main photo</h4>
                                                            <input id="img1" name="img1" type="file" class="dropify" required accept="image/jpeg, image/png, image/tiff, image/bmp" value="https://amazonya.s3.eu-central-1.amazonaws.com/60ff8e50-3b00-4db2-b17a-0d6a6b0f1e353-apple61i8Vjb17SL._AC_SX679_.jpg"/>
                                                            <div id="img1-error"></div>
                                                        </div>
                                                    </div>
                                                </div><!-- end main-->

                                                <div class="col-lg-2 grid-margin stretch-card">
                                                    <div class="card">
                                                        <div class="card-body">
                                                            <h4 class="card-title">Secondary photo</h4>
                                                            <input id="img2" name="img2" type="file" class="dropify" accept="image/jpeg, image/png, image/tiff, image/bmp"/>
                                                            <div id="img2-error"></div>
                                                        </div>
                                                    </div>
                                                </div><!-- end second-->

                                                <div class="col-lg-2 grid-margin stretch-card">
                                                    <div class="card">
                                                        <div class="card-body">
                                                            <h4 class="card-title">Secondary photo</h4>
                                                            <input id="img3" name="img3" type="file" class="dropify" accept="image/jpeg, image/png, image/tiff, image/bmp"/>
                                                            <div id="img3-error"></div>
                                                        </div>
                                                    </div>
                                                </div><!-- end second-->

                                                <div class="col-lg-2 grid-margin stretch-card">
                                                    <div class="card">
                                                        <div class="card-body">
                                                            <h4 class="card-title">Secondary photo</h4>
                                                            <input id="img4" name="img4" type="file" class="dropify" accept="image/jpeg, image/png, image/tiff, image/bmp"/>
                                                            <div id="img4-error"></div>
                                                        </div>
                                                    </div>
                                                </div><!-- end second-->

                                            </div>
                                        </div>
                                        <input class="btn btn-primary" type="button" id="submitBtn" value="Submit">
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- content-wrapper ends -->
            <!-- partial:../../partials/_footer.html -->
            <footer class="footer">
                <div class="d-sm-flex justify-content-center justify-content-sm-between">
            <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright © 2018 <a
                    href="https://www.urbanui.com/" target="_blank">Urbanui</a>. All rights reserved.</span>
                    <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted & made with <i
                            class="far fa-heart text-danger"></i></span>
                </div>
            </footer>
            <!-- partial -->
        </div>
        <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
</div>
<!-- container-scroller -->
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
<!-- endinject -->
<!-- Custom js for this page-->


<script src="assets/admin/js/wizard.js"></script>
<script src="assets/admin/js/dropify.js"></script>


<!--
<script src="../../js/jquery-file-upload.js"></script>
<script src="../../js/formpickers.js"></script>
<script src="../../js/form-repeater.js"></script>
-->
<script src="assets/admin/js/form-validation.js"></script>
<script src="assets/admin/js/product-maxLength.js"></script>
<script src="assets/admin/js/alerts.js"></script>
<script src="assets/admin/app-js/add-new-prod.js"></script>
<!-- End custom js for this page-->
</body>


<!-- Mirrored from www.urbanui.com/melody/template/pages/forms/wizard.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 15 Sep 2018 06:08:26 GMT -->

</html>