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
        // var signUpElement = document.getElementById("signupElement").firstElementChild;
        // console.log(signUpElement);
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
                 }//else{document.getElementById("profileIcon").firstElementChild.replaceWith(signUpElement);}
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
