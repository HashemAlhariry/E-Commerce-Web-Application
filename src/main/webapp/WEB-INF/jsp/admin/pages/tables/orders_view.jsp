<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">


<!-- Mirrored from www.urbanui.com/melody/template/pages/tables/data-table.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 15 Sep 2018 06:08:40 GMT -->
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
              Data table
            </h3>
            <nav aria-label="breadcrumb">
              <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">Tables</a></li>
                <li class="breadcrumb-item active" aria-current="page">Data table</li>
              </ol>
            </nav>
          </div>
          <div class="card">
            <div class="card-body">
              <h4 class="card-title">Data table</h4>
              <div class="row">
                <div class="col-12">
                  <div class="table-responsive">
                    <table id="order-listing" class="table">
                      <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Address</th>
                            <th>Date & Time</th>
                            <th>Phone Number</th>
                            <th>Total Price</th>
                            <th>State</th>
                            <th>More Action</th>

                        </tr>
                      </thead>
                      <tbody>
                      <c:forEach items="${allOrders}" var="order">
                          <tr id="${order.id}">
                              <td>${order.id}</td>
                              <td>${order.address}</td>
                              <td>${order.dateTime}</td>
                              <td>${order.phoneNumber}</td>
                              <td>${order.totalPrice}</td>
                              <td>
                                  <c:choose>
                                      <c:when test="${order.state=='PENDING'}">
                                          <label class="badge badge-warning">PENDING</label>
                                      </c:when>
                                      <c:when test="${order.state=='CANCELLED'}">
                                          <label class="badge badge-danger">CANCELLED</label>
                                      </c:when>
                                      <c:when test="${order.state=='ARRIVED'}">
                                          <label class="badge badge-success">ARRIVED</label>
                                      </c:when>
                                      <c:when test="${order.state=='PROCESSING'}">
                                          <label class="badge badge-primary">PROCESSING</label>
                                      </c:when>
                                  </c:choose>
                              </td>
                              <td>
                                  <button  class="btn btn-outline-primary" onclick="orderDetailView(${order.id})">View Details</button>
                                  <button  class="btn btn-outline-primary" onclick="">Update Status</button>
                              </td>
                          </tr>
                      </c:forEach>

                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- content-wrapper ends -->
        <!-- partial:../../partials/_footer.html -->
        <footer class="footer">
          <div class="d-sm-flex justify-content-center justify-content-sm-between">
            <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright © 2018 <a href="https://www.urbanui.com/" target="_blank">Urbanui</a>. All rights reserved.</span>
            <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted & made with <i class="far fa-heart text-danger"></i></span>
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
  <script src="assets/admin/js/data-table.js"></script>
  <!-- End custom js for this page-->
<script>
    var req = null;
    function orderDetailView(id)
    {
        var orderId = document.getElementById(id).innerHTML;
        var url = "admin-order-detail-view?orderId="+id;
        window.location.href = url;
    }
</script>
</body>


<!-- Mirrored from www.urbanui.com/melody/template/pages/tables/data-table.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 15 Sep 2018 06:08:41 GMT -->
</html>
