var nextLoadPage = 2;
// ${'#categoryIdDiv'}.getAttribute("data-brand");
var categoryId = $('#categoryId').val();

//var categoryId=
$('#loadMoreBtn').click(function () {
    var data = {};
    data.categoryId = categoryId;
    data.loadPage=nextLoadPage;

    sendData(data);

});


function sendData(form_data) {
    $('#loadMoreBtn').prop('disabled', true);
    $.ajax({
        url: 'categorized-product',
        type: 'POST',
        contentType: 'application/x-www-form-urlencoded',
        data: form_data,
        success: function (data) {
            if(data=='noMore'){
                $('#loadMoreBtn').prop('disabled', true);
            }else{
                nextLoadPage++;

                $('#loadMoreBtn').prop('disabled', false);
                $('#productsDiv').append(data);
            }

        },
        error: function (e) {
            $('#loadMoreBtn').prop('disabled', false);
            $('#loader').modal('hide');
            console.log("ERROR : ", e);
            showSwal('warning-message-and-cancel', e);
        }
    });
}