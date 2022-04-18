(function($) {
    'use strict';

    $(function() {
        $("#regster-form").validate({
            rules: {

                register_name: {
                    required: true,
                    minlength: 2
                },
                register_password: {
                    required: true,
                    minlength: 8
                },
                confirm_register_password: {
                    required: true,
                    minlength: 8,
                    equalTo: "#register-password-2"
                },
                register_email: {
                    required: true,
                    email: true
                },
                register_address: {
                    required: true,
                    minlength: 5
                },
                agree: "required"
            },
            messages: {

                register_name: {
                    required: "Please enter a username",
                    minlength: "Your username must consist of at least 2 characters"
                },
                register_password: {
                    required: "Please provide a password",
                    minlength: "Your password must be at least 8 characters long"
                },
                confirm_register_password: {
                    required: "Please provide a password",
                    minlength: "Your password must be at least 8 characters long",
                    equalTo: "Please enter the same password as above"
                },
                register_email: "Please enter a valid email address",
                agree: "Please accept our policy",
                register_address: "Please enter real address"
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


