(function($) {
    'use strict';

    $(function() {
    $(".signupForm").validate({
        rules: {
            // productQuantity: "required",
            productName: {
                required: true,
                minlength: 2
            },
            productQuantity: {
                required: true,
                minlength: 1,
                min:0
            },
            confirm_password: {
                required: true,
                minlength: 5,
                equalTo: "#password"
            },
            email: {
                required: true,
                email: true
            },
            topic: {
                required: "#newsletter:checked",
                minlength: 2
            },
            agree: "required"
        },
        messages: {
            // productQuantity: "Please enter your productQuantity",
            productPrice: "Please enter Price",
            productName: {
                required: "Please enter a username",
                minlength: "Your username must consist of at least 2 characters"
            },
            productQuantity: {
                required: "Please provide a password",
                minlength: "Your password must be at least 5 characters long",
                min : "the quantity should be greater than 0 or equal ;)"
            },
            confirm_password: {
                required: "Please provide a password",
                minlength: "Your password must be at least 5 characters long",
                equalTo: "Please enter the same password as above"
            },
            email: "Please enter a valid email address",
            agree: "Please accept our policy",
            topic: "Please select at least 2 topics"
        },
        errorPlacement: function(label, element) {
            label.addClass('mt-2 text-danger');
            label.insertAfter(element);
        },
        highlight: function(element, errorClass) {
            $(element).parent().addClass('has-danger')
            $(element).addClass('form-control-danger')
        }
    });
});
})(jQuery);