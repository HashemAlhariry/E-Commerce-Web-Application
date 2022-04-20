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
                        statistics Users
                      </p>
                       <h2>${statisticsBean.statisticsUsers}</h2>

<%--                       <input value="${statisticsBean.completedOrders}" type="text" > --%>

                      <label class="badge badge-outline-success badge-pill">75% increase</label>
                    </div>
                    <div class="statistics-item">
                      <p>
                        <i class="icon-sm fas fa-hourglass-half mr-2"></i>
                          completed Orders
                      </p>
                      <h2>${statisticsBean.completedOrders}</h2>
                      <label class="badge badge-outline-success badge-pill" >30% increase </label>
                    </div>
                    <div class="statistics-item">
                      <p>
                        <i class="icon-sm fas fa-cloud-download-alt mr-2"></i>
                          waiting Order
                      </p>
                      <h2>${statisticsBean.waitingOrder}</h2>
                      <label class="badge badge-outline-success badge-pill">12% increase</label>
                    </div>
                    <div class="statistics-item">
                      <p>
                        <i class="icon-sm fas fa-check-circle mr-2"></i>
                          not Completed Orders
                      </p>
                      <h2>${statisticsBean.notCompletedOrders}</h2>
                      <label class="badge badge-outline-danger badge-pill">57% decrease</label>
                    </div>
<%--                    <div class="statistics-item">--%>
<%--                      <p>--%>
<%--                        <i class="icon-sm fas fa-chart-line mr-2"></i>--%>
<%--                          all Products--%>
<%--                      </p>--%>
<%--                      <h2>${statisticsBean.allProducts}</h2>--%>
<%--                      <label class="badge badge-outline-success badge-pill">10% increase</label>--%>
<%--                    </div>--%>
<%--                    <div class="statistics-item">--%>
<%--                      <p>--%>
<%--                        <i class="icon-sm fas fa-circle-notch mr-2"></i>--%>
<%--                        Pending--%>
<%--                      </p>--%>
<%--                      <h2>7500</h2>--%>
<%--                      <label class="badge badge-outline-danger badge-pill">16% decrease</label>--%>
<%--                    </div>--%>
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
                  <canvas id="barChart"></canvas>
                </div>
              </div>
            </div>
            <div class="col-md-6 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">
                    <i class="fas fa-chart-line"></i>
                    products
                  </h4>
                  <h2 class="mb-5">${statisticsBean.allProducts} <span class="text-muted h4 font-weight-normal">products</span></h2>
                  <div id="morris-donut-example"></div>
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
  <script src="assets/admin/vendors/js/vendor.bundle.base.js"></script>
  <script src="assets/admin/vendors/js/vendor.bundle.addons.js"></script>
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
  <script src="assets/admin/js/c3.js"></script>
<%--  <script src="assets/admin/js/morris.js"></script>--%>

  <!-- End custom js for this page-->

<script>
  var options = {
    scales: {
      yAxes: [{
        ticks: {
          beginAtZero: true
        }
      }]
    },
    legend: {
      display: false
    },
    elements: {
      point: {
        radius: 0
      }
    }

  };

  var data = {
    labels: ["PENDING", "PROCESSING", "ARRIVED", "CANCELLED"],
    datasets: [{
      label: '# of Status',
      data: [${orderPENDING}, ${orderPROCESSING}, ${orderARRIVED}, ${orderCANCELLED}],
      backgroundColor: [
        'rgba(255, 99, 132, 0.2)',
        'rgba(54, 162, 235, 0.2)',
        'rgba(255, 206, 86, 0.2)',
        'rgba(75, 192, 192, 0.2)',
        'rgba(153, 102, 255, 0.2)',
        'rgba(255, 159, 64, 0.2)'
      ],
      borderColor: [
        'rgba(255,99,132,1)',
        'rgba(54, 162, 235, 1)',
        'rgba(255, 206, 86, 1)',
        'rgba(75, 192, 192, 1)',
        'rgba(153, 102, 255, 1)',
        'rgba(255, 159, 64, 1)'
      ],
      borderWidth: 1,
      fill: false
    }]
  };

  $(document).ready(function () {
    'use strict';
    var barChartCanvas = $("#barChart").get(0).getContext("2d");
    // This will get the first returned node in the jQuery collection.
    var barChart = new Chart(barChartCanvas, {
      type: 'bar',
      data: data,
      options: options
    });
  });

  $(document).ready(function () {
    'use strict';

    Morris.Donut({
      element: 'morris-donut-example',
      colors: ['#76C1FA', '#F36368', '#63CF72', '#FABA66'],
      data: [{
        label: "New",
        value: ${newProduct}
      },
        {
          label: "Out Of Stock",
          value: '${outOfStock}'
        },
        {
          label: "Best Seller",
          value: ${bestSeller}
        }
      ]
    });
  });
</script>
</body>

</html>