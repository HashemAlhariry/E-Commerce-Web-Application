
//var categoryId=
$('#register-submit').click(function () {
    if ($('#regster-form').valid()){
        var data = {};
        data.register_name = $('#register-name-2').val();
        data.register_birthday=$('#register-birthday-2').val();
        // console.log(register_birthday);
        console.log($('#register-birthday-2').val());
        console.log($('#register-email-2').val());
        data.register_email=$('#register-email-2').val();
        data.register_password=$('#register-password-2').val();
        data.register_address=$('#register-address-2').val();
        console.log($('#register-address-2').val());

        sendData(data);
    }


});


function sendData(form_data) {
    $('#register-submit').prop('disabled', true);
    $('#errorMessage').empty();
    $.ajax({
        url: 'registration',
        type: 'POST',
        contentType: 'application/x-www-form-urlencoded',
        data: form_data,
        timeout: 600000,
        success: function (data) {
            //console.log(data);

            $('#register-submit').prop('disabled', false);
            let resp = JSON.parse(data);
            if(resp.state === 'success'){
                showSwal('success-message', resp.messages.join(' \n '));
                $('#signin-tab-2')[0].click();
                $("input[type=text]").val(null);
                $("input[type=date]").val("");
                //window.location.href = "login";
                // $('#signin-tab').ariaSelected = "true";
            }
            else{

                $('#errorMessage').append("<li style='text-decoration-style: solid; color: red'>"+resp.messages.join(' \n ')+"</li>");
            }
        },
        error: function (e) {
            $('#loadMoreBtn').prop('disabled', false);
            console.log("ERROR : ", e);
        }

    });
}