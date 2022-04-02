$(document).ready(function () {
    jQuery.validator.addMethod("greaterThanZero", function (value, element) {
        return (parseFloat(value) >= 0);
    }, "* Amount must be greater than zero");
    $("#productForm").validate({
        rules: {
            price: {
                required: true,
                greaterThanZero: true
            },
            quantity: {
                required: true,
                greaterThanZero: true
            },
            name: {
                required: true,
                minlength: 5
            },
            img1: {
                required: true,
                accept: "image/jpeg, image/png"
            },
            img2: {
                accept: "image/jpeg, image/png"
            },
            img3: {
                accept: "image/jpeg, image/png"
            },
            img4: {
                accept: "image/jpeg, image/png"
            },
            img5: {
                accept: "image/jpeg, image/png"
            },
            img6: {
                accept: "image/jpeg, image/png"
            }
        },
        messages: {
            price: {
                required: "Please enter the product price",
                greaterThanZero: "* Amount must be greater than zero"
            },
            quantity: {
                required: "Please enter the product quantity",
                greaterThanZero: "* Amount must be greater than zero"
            },
            name: {
                required: "Please enter the product name",
                minlength: "Your product must consist of at least 5 characters"
            },
            img1: {
                required: "Please enter the product image",
                accept: "This field accept images only"
            },
            img2: {
                accept: "This field accept images only"
            },
            img3: {
                accept: "This field accept images only"
            },
            img4: {
                accept: "This field accept images only"
            },
            img5: {
                accept: "This field accept images only"
            },
            img6: {
                accept: "This field accept images only"
            }
        },
        errorPlacement: function (label, element) {
            console.log(label);
            label.addClass('mt-2 text-danger');
            label.insertAfter(element);
        },
        highlight: function (element, errorClass) {
            $(element).parent().addClass('has-danger')
            $(element).addClass('form-control-danger')
        }
    });
});

