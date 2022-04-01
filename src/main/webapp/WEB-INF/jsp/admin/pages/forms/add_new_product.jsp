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
              Add New Product
            </h3>
            <nav aria-label="breadcrumb">
              <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">Product</a></li>
                <li class="breadcrumb-item active" aria-current="page">Add</li>
              </ol>
            </nav>
          </div>
          <div class="row">
            <div class="col-12 grid-margin">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Add</h4>
                  <form id="example-form" action="#">
                    <div>
                      <h3>Product Details</h3>
                      <section>
                        <h4>Product Details</h4>
                        <div class="form-group">
                          <label>Name</label>
                          <input type="text" class="form-control" aria-describedby="emailHelp"
                            placeholder="Name" required>
                        </div>
                        <div class="form-group">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text bg-primary text-white">L.E</span>
                            </div>
                            <input type="text" class="form-control" aria-label="Amount (to the nearest EGP)">
                            <div class="input-group-append">
                              <span class="input-group-text">.00</span>
                            </div>
                          </div>
                        </div>
                        <div class="form-group">
                          <label>Description</label>
                          <textarea class="form-control" rows="3"></textarea>
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
                                  <h4 class="card-title">You can add a max file size</h4>
                                  <input type="file" class="dropify" data-max-file-size="30kb" />
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
                          <select class="js-example-basic-single w-100">
                            <option value="AL">Mobile</option>
                            <option value="WY">LapTop</option>
                            <option value="AM">Smart Watches</option>
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

  <!-- End custom js for this page-->
</body>


<!-- Mirrored from www.urbanui.com/melody/template/pages/forms/wizard.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 15 Sep 2018 06:08:26 GMT -->

</html>