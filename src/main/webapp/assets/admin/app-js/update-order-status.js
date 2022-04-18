$('#btn-submit').click(function () {
    var data = {};
    data.orderId= $('#productId').val();
    data.orderStatus= $('#productName').val();
    sendData(data);

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
            let resp = JSON.parse(data);
            if (resp.state === 'success') {
                $(".dropify-clear").click();
                window.scrollTo({ top: 0, behavior: 'smooth' });
                showSwal('success-message', resp.messages.join(' \n '));
            } else {
                showSwal('warning-message-and-cancel', resp.messages.join(' \n '));
            }
            setTimeout(
                function()
                {
                    location.reload(true);
                }, 5000);

        },
        error: function (e) {
            $('#btn-submit').prop('disabled', false);
            console.log("ERROR : ", e);
            showSwal('warning-message-and-cancel', e);
        }
    });
}