<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container quickView-container">
	<div class="quickView-content">
		<div class="row">
			<div class="col-lg-7 col-md-6">
				<div class="row">
					<div class="product-left">
						<a href="#main" class="carousel-dot active">
							<img src="${product.mainImage}">
						</a>
						<c:forEach var="img" items="${product.images}">
							<a href="#${img}" class="carousel-dot">
								<img src="${img}">
							</a>
						</c:forEach>

					</div>
					<div class="product-right">
						<div class="owl-carousel owl-theme owl-nav-inside owl-light mb-0" data-toggle="owl" data-owl-options='{
	                        "dots": false,
	                        "nav": false, 
	                        "URLhashListener": true,
	                        "responsive": {
	                            "900": {
	                                "nav": true,
	                                "dots": true
	                            }
	                        }
	                    }'>
							<div class="intro-slide" data-hash="main">
	                            <img src="${product.mainImage}" alt="Image Desc">
		                    </div><!-- End .intro-slide -->
							<c:forEach var="img" items="${product.images}">
								<div class="intro-slide" data-hash="${img}">
									<img src="${img}" alt="Image Desc">
								</div><!-- End .intro-slide -->
							</c:forEach>
		                </div>
					</div>
                </div>
			</div>
			<div class="col-lg-5 col-md-6">
				<h2 class="product-title">${product.name}</h2>
				<h3 class="product-price">${product.price} EGP</h3>

                <div class="ratings-container">
                    <div class="ratings">
                        <div class="ratings-val" style="width: 20%;"></div><!-- End .ratings-val -->
                    </div><!-- End .ratings -->
                    <span class="ratings-text">( 2 Reviews )</span>
                </div><!-- End .rating-container -->

                <p class="product-txt">${product.description}</p>


	            
<%--                <div class="details-filter-row details-row-size">--%>
<%--                    <label for="qty">Qty:</label>--%>
<%--                    <div class="product-details-quantity">--%>
<%--                        <input type="number" id="qty" class="form-control" value="1" min="1" max="10" step="1" data-decimals="0" required>--%>
<%--                    </div><!-- End .product-details-quantity -->--%>
<%--                </div><!-- End .details-filter-row -->--%>

                <div class="product-details-action">
                    <div class="details-action-wrapper">
                        <a onclick="addToWishList(${product.id})" class="btn-product btn-wishlist" title="Wishlist"><span>Add to Wishlist</span></a>
                    </div><!-- End .details-action-wrapper -->
					<c:if test="${product.quantity>0}">
                    		<a onclick="addToCart(${product.id})" class="btn-product btn-cart"><span>add to cart</span></a>
					</c:if>
                </div>

                <div class="product-details-footer">
                    <div class="product-cat">
                        <span>Category:</span>
                        <a href="categorized-product?categoryId=${product.category.categoryId}">${product.category.categoryName}</a>
                    </div><!-- End .product-cat -->
                </div>
			</div>
		</div>
	</div>
</div>
