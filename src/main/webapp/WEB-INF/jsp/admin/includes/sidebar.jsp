<nav class="sidebar sidebar-offcanvas" id="sidebar">
    <ul class="nav">
        <li class="nav-item">
            <a class="nav-link" href="admin">
                <i class="fa fa-home menu-icon"></i>
                <span class="menu-title">Dashboard</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="admin-product">
                <i class="fas fa-shopping-cart menu-icon"></i>
                <span class="menu-title">Products</span>
            </a>
        </li>
<%--        <li class="nav-item">--%>
<%--            <a class="nav-link" href="pages/tables/category_view.html">--%>
<%--                <i class="fab fa-wpforms menu-icon"></i>--%>
<%--                <span class="menu-title">Category</span>--%>
<%--            </a>--%>
<%--        </li>--%>
        <li class="nav-item">
            <a class="nav-link" href="admin-order-view">
                <i class="fas fa-bell menu-icon"></i>
                <span class="menu-title">Orders</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="admin-view-users">
                <i class="fas fa-minus-square menu-icon"></i>
                <span class="menu-title">Users</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" onclick="logout()">
                <i class="fas fa-minus-square menu-icon"></i>
                <span class="menu-title">Logout</span>
            </a>
        </li>
    </ul>
</nav>

<script>
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
                if(window.location.href.endsWith('updateprofile')){
                    window.location.href = "login";
                }else{document.getElementById("profileIcon").firstElementChild.replaceWith(signUpElement);}
                addToCart(-1);
                addToWishList(-1);
            }
        })
    };
</script>
