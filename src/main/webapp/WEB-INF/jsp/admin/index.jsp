<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
  <link rel="stylesheet" href="assets/admin/vendors/iconfonts/font-awesome/css/all.min.css">
  <link rel="stylesheet" href="assets/admin/vendors/css/vendor.bundle.base.css">
  <link rel="stylesheet" href="assets/admin/vendors/css/vendor.bundle.addons.css">
  <!-- endinject -->
  <!-- plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="assets/admin/css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="http://www.urbanui.com/" />
</head>

<body>
  <div class="container-scroller">
    <!-- partial:partials/_navbar.html -->
    <%@ include file="includes/header.jsp" %>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
      <!-- partial:partials/_settings-panel.html -->
      <!-- partial:partials/_sidebar.html -->
      <%@ include file="includes/sidebar.jsp" %>
      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
          <div class="page-header">
            <h3 class="page-title">
              Dashboard
            </h3>
          </div>
          <div class="row grid-margin">
            <div class="col-12">
              <div class="card card-statistics">
                <div class="card-body">
                  <div class="d-flex flex-column flex-md-row align-items-center justify-content-between">
                    <div class="statistics-item">
                      <p>
                        <i class="icon-sm fa fa-user mr-2"></i>
                        New users
                      </p>
                      <h2>54000</h2>
                      <label class="badge badge-outline-success badge-pill">2.7% increase</label>
                    </div>
                    <div class="statistics-item">
                      <p>
                        <i class="icon-sm fas fa-hourglass-half mr-2"></i>
                        Avg Time
                      </p>
                      <h2>123.50</h2>
                      <label class="badge badge-outline-danger badge-pill">30% decrease</label>
                    </div>
                    <div class="statistics-item">
                      <p>
                        <i class="icon-sm fas fa-cloud-download-alt mr-2"></i>
                        Downloads
                      </p>
                      <h2>3500</h2>
                      <label class="badge badge-outline-success badge-pill">12% increase</label>
                    </div>
                    <div class="statistics-item">
                      <p>
                        <i class="icon-sm fas fa-check-circle mr-2"></i>
                        Update
                      </p>
                      <h2>7500</h2>
                      <label class="badge badge-outline-success badge-pill">57% increase</label>
                    </div>
                    <div class="statistics-item">
                      <p>
                        <i class="icon-sm fas fa-chart-line mr-2"></i>
                        Sales
                      </p>
                      <h2>9000</h2>
                      <label class="badge badge-outline-success badge-pill">10% increase</label>
                    </div>
                    <div class="statistics-item">
                      <p>
                        <i class="icon-sm fas fa-circle-notch mr-2"></i>
                        Pending
                      </p>
                      <h2>7500</h2>
                      <label class="badge badge-outline-danger badge-pill">16% decrease</label>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-6 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">
                    <i class="fas fa-gift"></i>
                    Orders
                  </h4>
                  <canvas id="orders-chart"></canvas>
                  <div id="orders-chart-legend" class="orders-chart-legend"></div>
                </div>
              </div>
            </div>
            <div class="col-md-6 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">
                    <i class="fas fa-chart-line"></i>
                    Sales
                  </h4>
                  <h2 class="mb-5">56000 <span class="text-muted h4 font-weight-normal">Sales</span></h2>
                  <canvas id="sales-chart"></canvas>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- content-wrapper ends -->
        <!-- partial:partials/_footer.html -->
        <footer class="footer">
          <div class="d-sm-flex justify-content-center justify-content-sm-between">
            <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright © 2018. All rights
              reserved.</span>
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
  <script src="vendors/js/vendor.bundle.base.js"></script>
  <script src="vendors/js/vendor.bundle.addons.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page-->
  <!-- End plugin js for this page-->
  <!-- inject:js -->
  <script src="assets/admin/js/off-canvas.js"></script>
  <script src="assets/admin/js/hoverable-collapse.js"></script>
  <script src="assets/admin/js/misc.js"></script>
  <script src="assets/admin/js/settings.js"></script>
  <script src="assets/admin/js/todolist.js"></script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <script src="assets/admin/js/dashboard.js"></script>
  <!-- End custom js for this page-->
</body>


</html>