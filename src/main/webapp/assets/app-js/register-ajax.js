
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
    $.ajax({
        url: 'registration',
        type: 'POST',
        contentType: 'application/x-www-form-urlencoded',
        data: form_data,
        success: function (data) {
            $('#register-submit').prop('disabled', false);
            let resp = JSON.parse(data);
            if(resp.state === 'success'){
                console.log("success : ", "new email");
                window.location.href = "login";
            }
            else{
                console.log("ERROR : ", "same email");

                // $.each(data.messages, function (key, value) {
                    console.log("inside Error same email")
                    $('#errorMessage').append("<li style='text-decoration-style: solid; color: red'>"+data.messages+"</li>");
                // })
            }
        },
        error: function (e) {
            $('#loadMoreBtn').prop('disabled', false);
            $('#loader').modal('hide');
            console.log("ERROR : ", e);
        }

    });
}