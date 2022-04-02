<script src="assets/js/amazonya/cookie-checker.js"></script>
<script>
    window.onload = (event) => {
        if(!navigator.cookieEnabled) {
            window.location.href = "un-enabled-cookie";
        }else{
            post('cart','post');
        }

    };

    function post(path,method='post') {

        // The rest of this code assumes you are not using a library.
        // It can be made less verbose if you use one.
        const form = document.createElement('form');
        form.method = method;
        form.action = path;

        const hiddenField = document.createElement('input');
        hiddenField.type = 'hidden';
        hiddenField.name = 'cart';
        const localStorageContent = localStorage.getItem("cartItems");
        console.log(localStorageContent);
        hiddenField.value =  localStorage.getItem("cartItems");

        form.appendChild(hiddenField);
        document.body.appendChild(form);
        form.submit();

    }
</script>