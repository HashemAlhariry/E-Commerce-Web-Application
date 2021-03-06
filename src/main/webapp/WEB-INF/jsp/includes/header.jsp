<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<header class="header header-intro-clearance header-4">

    <div class="header-top">
        <div class="container">
            <div class="header-left">
                <a href="tel:#"><i class="icon-phone"></i>Call: +20 114 905 6691</a>
            </div><!-- End .header-left -->

            <div class="header-right" id="replaceable">

                <ul class="top-menu">
                    <li>
                        <a href="#">Links</a>
                        <ul>
                            <li>
                                <div class="header-dropdown">
                                    <a href="#">English</a>
                                    <div class="header-menu">
                                        <ul>
                                            <li><a href="#">English</a></li>
                                            <li style="font-family: Arial"><a href="#">العربية</a></li>
                                        </ul>
                                    </div><!-- End .header-menu -->
                                </div>
                            </li>

                            <%--<li><a href="#signin-modal" data-toggle="modal">Sign in / Sign up</a></li>--%>
                            <c:choose>
                                <c:when test="${(!empty loggedIn)&&(loggedIn =='true')}" >
                                    <li id="profileIcon">
                                        <div class="header-dropdown" >
<%--                                            <a>Profile</a>--%>
                                            <div class="icon">
                                                <i class='fas fa-user-alt sf-with-ul' style='font-size:24px;margin-right: auto;margin-left: auto;margin-top: auto'><span style="color: darkgray;font-size: small;margin-left: 10px;font-family: 'Poppins'">${userBean.userName}</span></i>
                                            </div>
                                            <div class="header-menu">
                                                <ul>
                                                    <li style=" color:orange;cursor: default"><a >${sessionScope.userBean.email}</a></li>
                                                    <li><a href="updateprofile">Profile</a></li>
                                                    <li><a href="userorderhistory">Orders History</a></li>
                                                    <li onMouseOver="this.style.color='orange'"onMouseOut="this.style.color='#777'" style="font-family: Arial;cursor: pointer;"><a onclick="logout()">Logout</a></li>
                                                </ul>
                                            </div><!-- End .header-menu -->
                                        </div>
                                    </li>
                                    <li id="signupElement" hidden><a href="login"  >Sign in / Sign up</a></li>
<%--                                    <li><a href="updateprofile"  > Update Profile </a></li>--%>
                                </c:when>
                                <c:otherwise>
                                    <li id="signupElement"><a href="login"  >Sign in / Sign up</a></li>
                                </c:otherwise>
                            </c:choose>

                        </ul>
                    </li>
                </ul><!-- End .top-menu -->
            </div><!-- End .header-right -->

        </div><!-- End .container -->
    </div><!-- End .header-top -->

    <div class="header-middle">
        <div class="container">
            <div class="header-left">
                <button class="mobile-menu-toggler">
                    <span class="sr-only">Toggle mobile menu</span>
                    <i class="icon-bars"></i>
                </button>

                <a href="home" class="logo">
                    <img src="assets/images/amazonya_logo.png" alt="Amazonya Logo" width="205" height="25">
                </a>
            </div><!-- End .header-left -->

            <div class="header-center">
                <div class="header-search header-search-extended header-search-visible d-none d-lg-block">
                    <a href="#" class="search-toggle" role="button"><i class="icon-search"></i></a>
                    <form action="searchproduct" method="get">
                        <div class="header-search-wrapper search-wrapper-wide">
                            <label for="q" class="sr-only">Search</label>
                            <button class="btn btn-primary" type="submit"><i class="icon-search"></i></button>
                            <input type="search" class="form-control" name="product-name" id="q" placeholder="Search product ..."
                                   required>
                        </div><!-- End .header-search-wrapper -->
                    </form>
                </div><!-- End .header-search -->
            </div>

            <div class="header-right">

                <div class="wishlist">
                    <a onclick= "postWishList('wishlist','post')" title="Wishlist" id="wishList" onMouseOver="this.style.color='orange'"onMouseOut="this.style.color='#777'" style="cursor: pointer">
                        <div class="icon">
                            <i class="icon-heart-o"></i>
                            <span class="wishlist-count badge" id="wishListItemsNumber">0</span>
                        </div>
                        <p>Wishlist</p>
                    </a>
                </div>

                <div class="dropdown cart-dropdown">

                        <a  onclick="post('cart','post')" id="cartIcon" class="dropdown-toggle" role="button"  aria-haspopup="false"
                           aria-expanded="false" data-display="static" onMouseOver="this.style.color='orange'"onMouseOut="this.style.color='#777'" style="cursor: pointer;" > <!-- data-toggle="dropdown"  attribute to be added in case you want dropdown to operate-->
                            <div class="icon">
                                <i class="icon-shopping-cart"></i>
                                <span class="cart-count" id="cartItemsNumber">0</span>
                            </div>
                            <p>Cart</p>
                        </a>
                    <%--                            <div class="dropdown-menu dropdown-menu-right">--%>
                    <%--                                <div class="dropdown-cart-products">--%>
                    <%--                                    <div class="product">--%>
                    <%--                                        <div class="product-cart-details">--%>
                    <%--                                            <h4 class="product-title">--%>
                    <%--                                                <a href="product.html">Beige knitted elastic runner shoes</a>--%>
                    <%--                                            </h4>--%>

                    <%--                                            <span class="cart-product-info">--%>
                    <%--                                                <span class="cart-product-qty">1</span>--%>
                    <%--                                                x $84.00--%>
                    <%--                                            </span>--%>
                    <%--                                        </div><!-- End .product-cart-details -->--%>

                    <%--                                        <figure class="product-image-container">--%>
                    <%--                                            <a href="product.html" class="product-image">--%>
                    <%--                                                <img src="assets/images/products/cart/product-1.jpg" alt="product">--%>
                    <%--                                            </a>--%>
                    <%--                                        </figure>--%>
                    <%--                                        <a href="#" class="btn-remove" title="Remove Product"><i class="icon-close"></i></a>--%>
                    <%--                                    </div><!-- End .product -->--%>

                    <%--                                    <div class="product">--%>
                    <%--                                        <div class="product-cart-details">--%>
                    <%--                                            <h4 class="product-title">--%>
                    <%--                                                <a href="product.html">Blue utility pinafore denim dress</a>--%>
                    <%--                                            </h4>--%>

                    <%--                                            <span class="cart-product-info">--%>
                    <%--                                                <span class="cart-product-qty">1</span>--%>
                    <%--                                                x $76.00--%>
                    <%--                                            </span>--%>
                    <%--                                        </div><!-- End .product-cart-details -->--%>

                    <%--                                        <figure class="product-image-container">--%>
                    <%--                                            <a href="product.html" class="product-image">--%>
                    <%--                                                <img src="assets/images/products/cart/product-2.jpg" alt="product">--%>
                    <%--                                            </a>--%>
                    <%--                                        </figure>--%>
                    <%--                                        <a href="#" class="btn-remove" title="Remove Product"><i class="icon-close"></i></a>--%>
                    <%--                                    </div><!-- End .product -->--%>
                    <%--                                </div><!-- End .cart-product -->--%>

                    <%--                                <div class="dropdown-cart-total">--%>
                    <%--                                    <span>Total</span>--%>

                    <%--                                    <span class="cart-total-price">$160.00</span>--%>
                    <%--                                </div><!-- End .dropdown-cart-total -->--%>

                    <%--                                <div class="dropdown-cart-action">--%>
                    <%--                                    <a href="cart.html" class="btn btn-primary">View Cart</a>--%>
                    <%--                                    <a href="checkout.html" class="btn btn-outline-primary-2"><span>Checkout</span><i class="icon-long-arrow-right"></i></a>--%>
                    <%--                                </div><!-- End .dropdown-cart-total -->--%>
                    <%--                            </div><!-- End .dropdown-menu -->--%>
                </div><!-- End .cart-dropdown -->
            </div><!-- End .header-right -->
        </div><!-- End .container -->
    </div><!-- End .header-middle -->

    <div class="header-bottom sticky-header">
        <div class="container">
            <div class="header-left">
                <div class="dropdown category-dropdown">
                    <a href="#" class="dropdown-toggle" role="button" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false" data-display="static" title="Browse Categories">
                        Browse Categories <i class="icon-angle-down"></i>
                    </a>

                    <div class="dropdown-menu">
                        <nav class="side-nav">
                            <ul class="menu-vertical sf-arrows">
                                <c:forEach var="category" items="${currentCategories}">
                                    <li class="item-lead"><a href="categorized-product?categoryId=${category.categoryId}" id="${category.categoryId}">${category.categoryName}</a></li>
                                </c:forEach>
                                <!-- href to shop categorized by watches sent in paramters-->
                                <%--                                        <li><a href="#">Beds</a></li>--%>
                            </ul><!-- End .menu-vertical -->
                        </nav><!-- End .side-nav -->
                    </div><!-- End .dropdown-menu -->
                </div><!-- End .category-dropdown -->
            </div><!-- End .header-left -->

            <div class="header-center">
                <nav class="main-nav">
                    <ul class="menu sf-arrows">
                        <li class="megamenu-container ">
                            <a href="home" class="our-sf-with-ul">Home</a>

                                </li>
                                    <c:if test="${(!empty userBean)&&(fn:containsIgnoreCase(userBean.role,'ADMIN'))}">
                                        <li class="megamenu-container ">
                                            <a href="admin" class="our-sf-with-ul">Admin</a>
                                        </li>
                                    </c:if>

                                <li>
                                    <a href="shop" class="our-sf-with-ul">Shop</a>
                                </li>

                                <li>
                                    <a href="#" class="sf-with-ul">Pages</a>
                                    <ul>

                                        <li>
                                            <a href="aboutUs" class="our-sf-with-ul">About</a>
                                        </li>



                                        <li>
                                            <a href="qs">FAQs</a>
                                        </li>

                                        <li>
                                            <a href="comingsoon">Coming Soon</a>
                                        </li>

<%--                                        <li>--%>
<%--                                            <a href="updateprofile">apdate</a>--%>
<%--                                        </li>--%>

                                    </ul>
                                </li>

                    </ul><!-- End .menu -->
                </nav><!-- End .main-nav -->
            </div><!-- End .header-center -->

            <div class="header-right">
                <i class="la la-lightbulb-o"></i>
                <p>Clearance<span class="highlight">&nbsp;Up to 30% Off</span></p>
            </div>
        </div><!-- End .container -->
    </div><!-- End .header-bottom -->
</header>
<!-- End .header -->

<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

<script>
    if(PerformanceNavigationTiming.type ==="back_forward") location.reload();

    function CartItem(id, quantity) {
        this.id = id;
        this.quantity = quantity;
    }
    window.onload = (event) => {

        addToCart(-1);
        addToWishList(-1);

    };


    function addToCart(productId){

        //get all available id in local storage
        //update list
        //save list to local storage

        var checker=true;
        var localStorageContent = localStorage.getItem("cartItems");

        if (localStorageContent == null) {
            cartItems = [];
        } else {
            cartItems = JSON.parse(localStorageContent);
        }

        cartItem = new CartItem(productId,1);

        for(var i =0;i<cartItems.length;i++){
            if(cartItems[i].id === productId){
                cartItems[i].quantity++;
                checker=false;
            }
        }

        if(checker && productId>=0){
            cartItems.push(cartItem);
        }

        localStorage.setItem('cartItems', JSON.stringify(cartItems));
        console.log(JSON.parse(localStorage.getItem("cartItems")));
        console.log(cartItems);
        console.log(cartItems);
        document.getElementById("cartItemsNumber").textContent =  cartItems.length;

    }



    function setRedirect(){
        var Json = localStorage.getItem("cartItems");
        document.cookie= "Cart=" + Json;
    }

    function post(path,method='post') {

        // The rest of this code assumes you are not using a library.
        // It can be made less verbose if you use one.
        const form = document.createElement('form');
        form.method = method;
        form.action = path;

        const hiddenField = document.createElement('input');
        hiddenField.type = 'hidden';
        hiddenField.name = 'cart';
        hiddenField.value =  localStorage.getItem("cartItems");
        form.appendChild(hiddenField);
        document.body.appendChild(form);
        form.submit();

    }


    function addToWishList(productId){

        //get all available id in local storage
        //update list
        //save list to local storage

        var localStorageContent = localStorage.getItem("wishlistItems");

        if (localStorageContent == null) {
            WishListItems = [];
        } else {
            WishListItems = JSON.parse(localStorageContent);
        }


        if(productId>=0){
            WishListItems.push(productId);
        }

        localStorage.setItem('wishlistItems', JSON.stringify(WishListItems));
        console.log(JSON.parse(localStorage.getItem("wishlistItems")));
        console.log(WishListItems);

        document.getElementById("wishListItemsNumber").textContent =  WishListItems.length;

    }


    function postWishList(path,method='post') {

        // The rest of this code assumes you are not using a library.
        // It can be made less verbose if you use one.
        const form = document.createElement('form');
        form.method = method;
        form.action = path;

        const hiddenField = document.createElement('input');

        hiddenField.type = 'hidden';
        hiddenField.name = 'wishlist';

        hiddenField.value =  localStorage.getItem("wishlistItems");
        form.appendChild(hiddenField);
        document.body.appendChild(form);
        form.submit();

    }

    function logout(){
        console.log("logging Out");
        var cartItems = localStorage.getItem("cartItems")
        var cartJson = {"cartItems":cartItems}
        var signUpElement = document.getElementById("signupElement").firstElementChild;
        console.log(signUpElement);
        $.ajax({
            url: 'logout',
            type: 'POST',
            contentType: 'application/x-www-form-urlencoded',
            data: cartJson,
            dataType: 'json',
            success: function (data) {
                localStorage.setItem("cartItems",JSON.stringify(data));
                // $("#profileIcon").html("<li><a href="login" id="singupElement" >Sign in / Sign up</a></li>");
                if(window.location.href.endsWith('updateprofile')||window.location.href.endsWith('userorderhistory')){
                    window.location.href = "login";
                }else if(window.location.href.endsWith('cart')){
                    window.location.href = "cart";
                }else{document.getElementById("profileIcon").firstElementChild.replaceWith(signUpElement);}
                addToCart(-1);
                addToWishList(-1);
            }
        })
    };






/*
    $('#cartIcon').click(function () {

        var jsonData = localStorage.getItem("cartItems");
        $.ajax({
            url: 'cart',
            type: 'GET',
            contentType: 'application/x-www-form-urlencoded',
            data: {
                "jsonObject" : jsonData
            },
            dataType: 'json',
            success: function () {

            }
        });
    });
     */

</script>

<%--<!-- Start of ChatBot (www.chatbot.com) code -->--%>
<%--<script type="text/javascript">--%>
<%--    window.__be = window.__be || {};--%>
<%--    window.__be.id = "625087007c98d9000779c426";--%>
<%--    (function() {--%>
<%--        var be = document.createElement('script'); be.type = 'text/javascript'; be.async = true;--%>
<%--        be.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'cdn.chatbot.com/widget/plugin.js';--%>
<%--        var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(be, s);--%>
<%--    })();--%>
<%--</script>--%>
<%--<!-- End of ChatBot code -->--%>

<!-- Start of LiveChat (www.livechat.com) code -->
<script>
    window.__lc = window.__lc || {};
    window.__lc.license = 14025066;
    ;(function(n,t,c){function i(n){return e._h?e._h.apply(null,n):e._q.push(n)}var e={_q:[],_h:null,_v:"2.0",on:function(){i(["on",c.call(arguments)])},once:function(){i(["once",c.call(arguments)])},off:function(){i(["off",c.call(arguments)])},get:function(){if(!e._h)throw new Error("[LiveChatWidget] You can't use getters before load.");return i(["get",c.call(arguments)])},call:function(){i(["call",c.call(arguments)])},init:function(){var n=t.createElement("script");n.async=!0,n.type="text/javascript",n.src="https://cdn.livechatinc.com/tracking.js",t.head.appendChild(n)}};!n.__lc.asyncInit&&e.init(),n.LiveChatWidget=n.LiveChatWidget||e}(window,document,[].slice))
</script>
<noscript><a href="https://www.livechat.com/chat-with/14025066/" rel="nofollow">Chat with us</a>, powered by <a href="https://www.livechat.com/?welcome" rel="noopener nofollow" target="_blank">LiveChat</a></noscript>
<!-- End of LiveChat code -->