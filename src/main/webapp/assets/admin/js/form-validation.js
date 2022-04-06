(function ($) {
    'use strict';
    jQuery.validator.addMethod("greaterThanZero", function (value, element) {
        return (parseFloat(value) >= 0);
    }, "* Amount must be greater than zero");
    $(function () {

        $("#productForm").validate({
            rules: {
                name: {
                    required: true,
                    minlength: 2/*,
                    maxLength:50*/
                },
                price: {
                    required: true,
                    greaterThanZero: true
                },
                quantity: {
                    required: true,
                    greaterThanZero: true
                },
                category: {
                    required: true
                },
                img1: {
                    required: true
                }/*,
                description: {
                    maxLength: 200
                }*/
            },
            messages: {
                name: {
                    required: "Please enter the product name",
                    minlength: "Your product must consist of at least 5 characters"/*,
                    maxLength :"This field size is 50"*/
                },
                price: {
                    required: "Please enter the product price",
                    greaterThanZero: "* Amount must be greater than zero"
                },
                quantity: {
                    required: "Please enter the product quantity",
                    greaterThanZero: "* Amount must be greater than zero"
                },
                category: {
                    required: "Please select category"
                },
                img1: {
                    required: "Please enter the main product image"
                }/*,
                description: {
                    maxLength :"This field size is 150"
                }*/

            },
            errorPlacement: function (label, element) {
                console.log(element);
                console.log(element.attr("type"));
                label.addClass('mt-2 text-danger');

                if(element.attr("type") === "file"){
                    label.insertAfter($('#'+element.attr('id')+'-error'));
                }else {
                    label.insertAfter(element);
                }
            },
            highlight: function (element, errorClass) {
                $(element).parent().addClass('has-danger')
                $(element).addClass('form-control-danger')
            }
        });

    });
})(jQuery);