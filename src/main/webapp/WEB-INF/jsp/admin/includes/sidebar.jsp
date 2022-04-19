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
           <button onclick="logout()">
               <i class="fas fa-power-off menu-icon"></i>
               <span class="menu-title">Logout</span>
           </button>

        </li>
    </ul>
</nav>

<script>
    function logout() {
        var url = "admin-logout";
        window.location.href = url;
    }
</script>
