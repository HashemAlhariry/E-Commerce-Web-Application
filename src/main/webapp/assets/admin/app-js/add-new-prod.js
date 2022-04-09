$('#submitBtn').click(function () {
    if ($('#productForm').valid()) {
        var data = new FormData();
        data.append('name', $('#name').val());
        data.append('price', $('#price').val());
        data.append('quantity', $('#quantity').val());
        data.append('category', $('#category').val());
        data.append('description', $('#description').val());
        addImgInp(data, 'img1');
        addImgInp(data, 'img2');
        addImgInp(data, 'img3');
        addImgInp(data, 'img4');



        sendData(data);
    }
});
function addImgInp(data, id) {
    let img = $('#' + id);
    if (img && img.get(0).files.length !== 0) {
        data.append(id, img.prop('files')[0], img.val().split('\\').pop());
    }
}

function sendData(form_data) {
    $('#submitBtn').prop('disabled', true);
    $('#loader').modal('show');

    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "admin-add-product",
        data: form_data,
        processData: false,
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {

            $('#submitBtn').prop('disabled', false);
            $('#loader').modal('hide');
            let resp = JSON.parse(data);
            if (resp.state === 'success') {
                $("input[type=text]").val(null);
                $("#description").val(null);
                $("input[type=number]").val(null);
                $("input[type=file]").val(null);
                $(".dropify-clear").click();
                // $("input").val('');
                window.scrollTo({ top: 0, behavior: 'smooth' });
                showSwal('success-message', resp.messages.join(' \n '));
            } else {
                showSwal('warning-message-and-cancel', resp.messages.join(' \n '));
            }

        },
        error: function (e) {
            $('#submitBtn').prop('disabled', false);
            $('#loader').modal('hide');
            console.log("ERROR : ", e);
            showSwal('warning-message-and-cancel', e);
        }
    });
}