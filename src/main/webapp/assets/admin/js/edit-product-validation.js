(function($) {
    'use strict';

    $(function() {
    $(".signupForm").validate({
        rules: {
            productState: "required",
            productName: {
                required: true,
                minlength: 2
            },
            productQuantity: {
                required: true,
                minlength: 1,
                min:0
            },
            productPrice: {
                required: true,
                minlength: 1,
                min:0
            },
            productCategory: {
                required: "required"
            },
            agree: "required"
        },
        messages: {
            productCategory: "Please select Product Category",
            productState: "Please select Product State",
            productName: {
                required: "Please enter a username",
                minlength: "Your username must consist of at least 2 characters"
            },
            productQuantity: {
                required: "Please provide a Quantity",
                min : "the quantity should be greater than 0 or equal ;)"
            },
            productPrice: {
                required: "Please provide a Price",
                min : "the Price should be greater than 0 or equal ;)"
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