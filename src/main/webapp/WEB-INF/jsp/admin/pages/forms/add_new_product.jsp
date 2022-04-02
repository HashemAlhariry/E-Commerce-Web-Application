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
          <div class="row grid-margin">
            <div class="col-lg-12">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Product data</h4>
                  <form class="cmxform" id="productForm" method="post" action="admin-add-product" enctype="multipart/form-data">
                    <fieldset>
                      <div class="form-group">
                        <label for="pname">Name</label>
                        <input id="pname" class="form-control" name="name" minlength="5" type="text" required>
                      </div>
                      <div class="form-group">
                        <label for="pprice">Price</label>
                        <input id="pprice" class="form-control" name="price" type="number" required>
                      </div>
                      <div class="form-group">
                        <label for="pquantity">Quantity</label>
                        <input id="pquantity" class="form-control" name="quantity" type="number" required>
                      </div>


                      <div class="form-group">
                        <label for="category">Category</label>
                        <select  class="form-control form-control-lg" id="category" name="category" required>
                          <c:forEach var="category" items="${currentCategories}">
                            <option value="${category.categoryId}">${category.categoryName}</option>
                          </c:forEach>
                        </select>
                      </div>

                      <div class="form-group">
                        <label for="pdescription">Description</label>
                        <textarea id="pdescription" class="form-control" rows="5" name="description" ></textarea>
                      </div>


                      <!--
                      <div class="form-group">
                        <label for="img">Image</label>
                        <input id="img" name="img" type="file"  class="dropify" data-max-file-size="3mb" accept="image/png, image/jpeg" multiple />
                      </div>
                      -->
                      <!--
                      <div class="row">
                        <div class="col-lg-4 grid-margin stretch-card">
                          <div class="card">
                            <div class="card-body">
                              <h4 class="card-title d-flex">Dropify
                                <small class="ml-auto align-self-end">
                                  <a href="dropify.html" class="font-weight-light" target="_blank">More dropify examples</a>
                                </small>
                              </h4>
                              <div class="dropify-wrapper"><div class="dropify-message"><span class="file-icon"></span> <p>Drag and drop a file here or click</p><p class="dropify-error">Ooops, something wrong appended.</p></div><div class="dropify-loader"></div><div class="dropify-errors-container"><ul></ul></div><input type="file" class="dropify"><button type="button" class="dropify-clear">Remove</button><div class="dropify-preview"><span class="dropify-render"></span><div class="dropify-infos"><div class="dropify-infos-inner"><p class="dropify-filename"><span class="file-icon"></span> <span class="dropify-filename-inner"></span></p><p class="dropify-infos-message">Drag and drop or click to replace</p></div></div></div></div>
                            </div>
                          </div>
                        </div>

                        </div>-->


                          <div class="form-group">
                            <div class="row">
                              <div class="col-lg-2 grid-margin stretch-card">
                                <div class="card">
                                  <div class="card-body">
                                    <h4 class="card-title">Main photo</h4>
                                    <input name="img1" type="file"  class="dropify" data-max-file-size="3mb" accept="image/png, image/jpeg" multiple required/>
                                  </div>
                                </div>
                              </div><!-- end main-->

                              <div class="col-lg-2 grid-margin stretch-card">
                                <div class="card">
                                  <div class="card-body">
                                    <h4 class="card-title">Secondary photo</h4>
                                    <input name="img2" type="file"  class="dropify" data-max-file-size="3mb" accept="image/png, image/jpeg" multiple />
                                  </div>
                                </div>
                              </div><!-- end second-->

                              <div class="col-lg-2 grid-margin stretch-card">
                                <div class="card">
                                  <div class="card-body">
                                    <h4 class="card-title">Secondary photo</h4>
                                    <input name="img3" type="file"  class="dropify" data-max-file-size="3mb" accept="image/png, image/jpeg" multiple />
                                  </div>
                                </div>
                              </div><!-- end second-->

                              <div class="col-lg-2 grid-margin stretch-card">
                                <div class="card">
                                  <div class="card-body">
                                    <h4 class="card-title">Secondary photo</h4>
                                    <input name="img4" type="file"  class="dropify" data-max-file-size="3mb" accept="image/png, image/jpeg" multiple />
                                  </div>
                                </div>
                              </div><!-- end second-->

                              <div class="col-lg-2 grid-margin stretch-card">
                                <div class="card">
                                  <div class="card-body">
                                    <h4 class="card-title">Secondary photo</h4>
                                    <input name="img5" type="file"  class="dropify" data-max-file-size="3mb" accept="image/png, image/jpeg" multiple />
                                  </div>
                                </div>
                              </div><!-- end second-->

                              <div class="col-lg-2 grid-margin stretch-card">
                                <div class="card">
                                  <div class="card-body">
                                    <h4 class="card-title">Secondary photo</h4>
                                    <input name="img6" type="file"  class="dropify" data-max-file-size="3mb" accept="image/png, image/jpeg" multiple />
                                  </div>
                                </div>
                              </div><!-- end second-->


                            </div>
                          </div>







                      <input class="btn btn-primary" type="submit" value="Submit">
                      <input class="btn btn-primary" type="button" id="testBtn" value="Test">

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

  <script>
    $('#testBtn').click(function (){
      console.log('aaa');
      console.log($('#productForm').valid());
    });
  </script>
  <!-- End custom js for this page-->
</body>


<!-- Mirrored from www.urbanui.com/melody/template/pages/forms/wizard.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 15 Sep 2018 06:08:26 GMT -->

</html>