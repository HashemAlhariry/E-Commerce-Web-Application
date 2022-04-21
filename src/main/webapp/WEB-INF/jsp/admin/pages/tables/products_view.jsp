<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">


<!-- Mirrored from www.urbanui.com/melody/template/pages/tables/js-grid.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 15 Sep 2018 06:08:41 GMT -->

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Amazonya Admin</title>
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
                <div class="col-12 grid-margin stretch-card">
                  <div class="card">
                    <div class="card-body">
                      <h4 class="card-title">Search</h4>
                      <form action="admin-product-search" class="form-inline">
                        <label class="sr-only" for="inlineFormInputName2">Product Price</label>
                        <input name="productPrice" type="number" class="form-control mb-2 mr-sm-2" id="inlineFormInputName2" placeholder="price" value="">
                        <div class="input-group mb-2 mr-sm-2">
                          <label>Select Category</label>
                          <select name="categoryId" class="js-example-basic-single w-100">
                            <option value="0">All</option>
                          <c:forEach items="${currentCategories}" var="category">
                            <option value="${category.categoryId}">${category.categoryName}</option>
                          </c:forEach>
                          </select>
                        </div>
                        <button type="submit" class="btn btn-primary mb-2">Search</button>
                      </form>
                    </div>
                  </div>
                </div>
                <div class="col-12">
                  <div class="table-responsive">
                    <table id="order-listing" class="table">
                      <thead>
                      <tr>
                        <th>Id</th>
                        <th>Publish Date</th>
                        <th>Product Name</th>
                        <th>Quantity</th>
                        <th>Sale Percentage</th>
                        <th>Category Name</th>
                        <th>Price</th>
                        <th>Status</th>
                        <th>Actions</th>
                      </tr>
                      </thead>
                      <tbody>
                      <c:forEach items="${allProducts}" var="product">
                        <tr id="${product.id}">
                          <td>${product.id}</td>
                          <td>${product.creationDate}</td>
                          <td>${product.name}</td>
                          <td>${product.quantity}</td>
                          <td>${product.salePercentage}</td>
                          <td>${product.category.categoryName}</td>
                          <td>${product.price}</td>
                          <td>
                            <c:choose>
                              <c:when test="${product.state=='NEW'}">
                                <label class="badge badge-primary">NEW</label>
                              </c:when>
                              <c:when test="${product.state=='OUT_OF_STOCK'}">
                                <label class="badge badge-danger">OUT OF STOCK</label>
                              </c:when>
                              <c:when test="${product.state=='ON_SALE'}">
                                <label class="badge badge-success">ON SALE</label>
                              </c:when>
                              <c:when test="${product.state=='BEST_SELLER'}">
                                <label class="badge badge-warning">BEST SELLER</label>
                              </c:when>
                              <c:when test="${product.state=='ARCHIVED'}">
                                <label class="badge badge-secondary">ARCHIVED</label>
                              </c:when>
                            </c:choose>
                          </td>
                          <td>
                            <button  class="btn btn-outline-primary" onclick="updateProduct(${product.id})">Edit</button>
                            <button class="btn btn-outline-danger" onclick="deleteProduct(${product.id})">Delete</button>
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
  <script src="assets/admin/js/js-grid.js"></script>
  <script src="assets/admin/js/db.js"></script>
    <script src="assets/admin/js/select2.js"></script>

    <!-- End custom js for this page-->
    <script>
      var req = null;
      function updateProduct(id)
      {
        var productId = document.getElementById(id).innerHTML;
        var url = "admin-edit-product?productId="+id;
        window.location.href = url;
      }
      function deleteProduct(id)
      {
        var trElement = document.getElementById(id);
        trElement.remove();
        deleteBean(id);
      }

      function deleteBean(id){
        if (window.XMLHttpRequest)
          req = new XMLHttpRequest();
        else if (window.ActiveXObject)
          req = new ActiveXObject(Microsoft.XMLHTTP);
        req.onreadystatechange = handleReq;
        req.open( "GET", "admin-delete-product?productId="+id, true);
        req.send(null);
      }
      function handleReq() {
        if (req.readyState == 4 && req.status == 200) {
              // xmlvalue = req.responseText;
        }
      }

    </script>
</body>


<!-- Mirrored from www.urbanui.com/melody/template/pages/tables/js-grid.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 15 Sep 2018 06:08:42 GMT -->


</html>