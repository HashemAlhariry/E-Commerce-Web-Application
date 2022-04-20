$('#btn-submit').click(function () {
    if ($('#example-form').valid()) {
        var data = {};
        data.productId= $('#productId').val();
        data.productName= $('#productName').val();
        data.productPrice= $('#productPrice').val();
        data.productQuantity= $('#productQuantity').val();
        data.productCategory= $('#productCategory').val();
        data.productDescription= $('#productDescription').val();
        data.productState= $('#productState').val();

        sendData(data);
    }
});


function sendData(form_data) {
    $('#btn-submit').prop('disabled', true);
    // $('#loader').modal('show');

    $.ajax({
        url: "admin-update-product",
        type: 'POST',
        contentType: 'application/x-www-form-urlencoded',
        data: form_data,
        timeout: 600000,
        success: function (data) {

            $('#btn-submit').prop('disabled', false);
            // $('#loader').modal('hide');
            let resp = JSON.parse(data);
            if (resp.state === 'success') {
                $(".dropify-clear").click();
                // $("input").val('');
                window.scrollTo({ top: 0, behavior: 'smooth' });
                showSwal('success-message', resp.messages.join(' \n '));
            } else {
                showSwal('warning-message-and-cancel', resp.messages.join(' \n '));
            }

        },
        error: function (e) {
            $('#btn-submit').prop('disabled', false);
            $('#loader').modal('hide');
            console.log("ERROR : ", e);
            showSwal('warning-message-and-cancel', e);
        }
    });
}