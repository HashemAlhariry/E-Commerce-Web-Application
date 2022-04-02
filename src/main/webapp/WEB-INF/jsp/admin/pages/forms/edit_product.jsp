<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">


<!-- Mirrored from www.urbanui.com/melody/template/pages/forms/wizard.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 15 Sep 2018 06:08:25 GMT -->

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Melody Admin</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="assets/admin/vendors/iconfonts/font-awesome/css/all.min.css">
  <link rel="stylesheet" href="assets/admin/vendors/css/vendor.bundle.base.css">
  <link rel="stylesheet" href="assets/admin/vendors/css/vendor.bundle.addons.css">
  <!-- endinject -->
  <!-- plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="assets/admin/css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="assets/admin/images/favicon.png" />
  <link rel="shortcut icon" href="http://www.urbanui.com/" />

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
              Edit Product
            </h3>
            <nav aria-label="breadcrumb">
              <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">product</a></li>
                <li class="breadcrumb-item active" aria-current="page">edit</li>
              </ol>
            </nav>
          </div>
          <div class="row">
            <div class="col-12 grid-margin">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">jquery-steps wizard</h4>
                  <form id="example-form" method="get" action="admin-update-product">
                    <div>
                      <h3>Product Details</h3>
                      <section>
                        <h4>Product Name</h4>
                        <div class="form-group">
                          <label>Product Id : ${editProduct.id} </label>
                          <input type="hidden" name="productId" value="${editProduct.id}" class="form-control" aria-describedby="emailHelp"
                                 placeholder="Product Id">
                          <label>Name </label>
                          <input type="text" name="productName" value="${editProduct.name}" class="form-control" aria-describedby="emailHelp"
                            placeholder="Product Name">
                        </div>
                        <div class="form-group">
                          <label>Quantity </label>
                          <input type="number" name="productQuantity" value="${editProduct.quantity}" class="form-control" aria-describedby="emailHelp"
                                 placeholder="Product Quantity">
                        </div>
                        <div class="form-group">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text bg-primary text-white">L.E</span>
                            </div>
                            <input type="text" name="productPrice" value="${editProduct.price}" class="form-control" aria-label="Amount (to the nearest dollar)">
                          </div>
                        </div>
                        <div class="form-group">
                          <label>Description</label>
                          <textarea class="form-control" name="productDescription" rows="3">${editProduct.description}</textarea>
                        </div>
                      </section>
                      <h3>Imgaes</h3>
                      <section>
                        <h4>Image</h4>
                        <div class="form-group">
                          <div class="row">
                            <div class="col-lg-6 grid-margin stretch-card">
                              <div class="card">
                                <div class="card-body">
                                  <h4 class="card-title">Profile Image</h4>
                                  <input type="file" class="dropify" name="productImage" data-max-file-size="30kb" />
                                </div>
                              </div>
                            </div>
                            <div class="col-lg-6 grid-margin stretch-card">
                              <div class="card">
                                <div class="card-body">
                                  <h4 class="card-title">Gallery</h4>
                                  <div class="file-upload-wrapper">
                                    <div id="fileuploader">Upload</div>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>

                      </section>
                      <h3>Category</h3>
                      <section>
                        <h4>Category</h4>
                        <div class="form-group">
                          <label>Single select box using select 2</label>
                          <select name="productCategory" class="js-example-basic-single w-100">
                            <option value="1">Mobile</option>
                            <option value="2">Smart Watches</option>
                            <option value="3">LapTop</option>
                          </select>
                        </div>
                          <h4>State</h4>
                          <div class="form-group">
                            <select name="productState" class="js-example-basic-single w-100" data-value="${editProduct.state}">
                              <option value="NEW">NEW</option>
                              <option value="OUT_OF_STOCK">OUT OF STOKE</option>
                              <option value="ON_SALE">ON SALE</option>
                              <option value="BEST_SELLER">BEST SELLER</option>
                              <option value="ARCHIVED">ARCHIVED</option>
                            </select>
                          </div>
                      </section>
                      <h3>Finish</h3>
                      <section>
                        <h4>Finish</h4>
                        <div class="form-check">
                          <label class="form-check-label">
                            <input class="checkbox" type="checkbox">
                            I agree with the Terms and Conditions.
                          </label>
                        </div>
                      </section>
                    </div>
                    <input class="btn btn-success" type="submit" value="update">
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
  <script src="assets/admin/js/jquery-file-upload.js"></script>

  <!-- End custom js for this page-->
</body>


<!-- Mirrored from www.urbanui.com/melody/template/pages/forms/wizard.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 15 Sep 2018 06:08:26 GMT -->

</html>