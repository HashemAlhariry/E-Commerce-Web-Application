
//var categoryId=
$('#register-submit').click(function () {
    if ($('#regster-form').valid()){
        var data = {};
        data.register_name = $('#register-name-2').val();
        data.register_birthday=$('#register-birthday-2').val();
        data.register_email=$('#register-email-2').val();
        data.register_password=$('#register-password-2').val();
        data.register_address=$('#register-address-2').val();

        sendData(data);
    }


});


function sendData(form_data) {
    $('#register-submit').prop('disabled', true);
    $('#loader').modal('show');

    $.ajax({
        url: 'registration',
        type: 'POST',
        contentType: 'application/x-www-form-urlencoded',
        data: form_data,
        success: function (data) {
            $('#register-submit').prop('disabled', false);
            $('#loader').modal('hide');
            let resp = JSON.parse(data);
            if(resp.state === 'success'){
                window.location.href = "login";
            }
            else{
                $('#loader').modal('hide');
                $('#errorMessage').append("<li style='text-decoration-style: solid; color: red'>This Email is already exist</li>");
            }
        },
        error: function (e) {
            $('#loadMoreBtn').prop('disabled', false);
            $('#loader').modal('hide');
            console.log("ERROR : ", e);
        }

    });
}