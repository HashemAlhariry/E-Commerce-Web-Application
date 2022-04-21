<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<%
  response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
%>

<!-- Mirrored from www.urbanui.com/melody/template/pages/forms/wizard.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 15 Sep 2018 06:08:25 GMT -->

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
  <link rel="shortcut icon" href="assets/admin/images/favicon.png"/>

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
          <div class="modal fade bd-example-modal-sm" id="loader" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" data-backdrop="false" data-keyboard="false">
            <div class="modal-dialog modal-sm">
              <div class="modal-content">
                <div class="loader-demo-box">
                  <div class="pixel-loader"></div>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-12 grid-margin">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Edit Product</h4>
                  <form id="example-form" class="signupForm" method="get" action="admin-update-product">
                    <div>
                      <h3>Product Details</h3>
                      <section>
                        <h4>Product Name</h4>
                        <div class="form-group">
                          <label>Product Id : ${editProduct.id} </label>
                          <input id="productId" type="hidden" name="productId" value="${editProduct.id}" class="form-control" aria-describedby="emailHelp"
                                 placeholder="Product Id">
                          <label>Name </label>
                          <input id="productName" type="text" name="productName" value="${editProduct.name}" class="form-control" aria-describedby="emailHelp"
                            placeholder="Product Name">
                        </div>
                        <div class="form-group">
                          <label>Quantity </label>
                          <input id="productQuantity" type="number" name="productQuantity" value="${editProduct.quantity}" class="form-control" aria-describedby="emailHelp"
                                 placeholder="Product Quantity">
                        </div>
                        <div class="form-group">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text bg-primary text-white">L.E</span>
                            </div>
                            <input id="productPrice" type="number" name="productPrice" value="${editProduct.price}" class="form-control" aria-label="Amount (to the nearest dollar)">
                          </div>
                        </div>
                        <div class="form-group">
                          <label>Description</label>
                          <textarea id="productDescription" class="form-control" name="productDescription" rows="3">${editProduct.description}</textarea>
                        </div>
                      </section>
                      <h3>Category</h3>
                      <section>
                        <h4>Category</h4>
                        <div class="form-group">
                          <label>Single select box using select 2</label>
                          <select id="productCategory" name="productCategory" class="js-example-basic-single w-100">
                            <c:forEach items="${currentCategories}" var="category">
                              <c:if test="${category.categoryId eq productCategoryId}">
                                <option value="${category.categoryId}">${category.categoryName}</option>
                              </c:if>
                            </c:forEach>
                            <c:forEach items="${currentCategories}" var="category">
                              <c:if test="${category.categoryId ne productCategoryId}">
                                <option value="${category.categoryId}">${category.categoryName}</option>
                              </c:if>
                            </c:forEach>

                          </select>
                        </div>
                          <h4>State</h4>
                          <div class="form-group">
                            <select id="productState" name="productState" class="js-example-basic-single w-100" data-value="${editProduct.state}">
                              <option value="NEW">NEW</option>
                              <option value="OUT_OF_STOCK">OUT OF STOKE</option>
                              <option value="ON_SALE">ON SALE</option>
                              <option value="BEST_SELLER">BEST SELLER</option>
                              <option value="ARCHIVED">ARCHIVED</option>
                            </select>
                          </div>
                      </section>
                    </div>
                    <input id="btn-submit" class="btn btn-success" type="button" value="update">
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
  <script src="assets/admin/app-js/edit-new-prod.js"></script>
  <script src="assets/admin/js/edit-product-validation.js"></script>
  <script src="assets/admin/js/wizard.js"></script>
  <script src="assets/admin/js/dropify.js"></script>
  <script src="assets/admin/js/alerts.js"></script>
  <script src="assets/admin/js/jquery-file-upload.js"></script>

  <!-- End custom js for this page-->
</body>


<!-- Mirrored from www.urbanui.com/melody/template/pages/forms/wizard.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 15 Sep 2018 06:08:26 GMT -->

</html>