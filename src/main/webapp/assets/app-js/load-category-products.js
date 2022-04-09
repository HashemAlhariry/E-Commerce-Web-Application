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
    $('#submitBtn').prop('disabled', true);
    console.log("asdasdAsdASdaSd");
    console.log(JSON.stringify(form_data));
    $.ajax({
        url: 'categorized-product',
        type: 'POST',
        contentType: 'application/x-www-form-urlencoded',
        data: form_data,
        success: function (data) {
            console.log(data);
            if(data=='noMore'){
                console.log('aaaaasasdASa');
                $('#submitBtn').prop('disabled', true);
            }else{
                nextLoadPage++;

                $('#loadMoreBtn').prop('disabled', false);
                $('#productsDiv').append(data);
            }
            /*let resp = JSON.parse(data);
            if (resp.state === 'success') {
                console.log(data);
            } else {
                showSwal('warning-message-and-cancel', resp.messages.join(' \n '));
            }
*/
        },
        error: function (e) {
            $('#submitBtn').prop('disabled', false);
            $('#loader').modal('hide');
            console.log("ERROR : ", e);
            showSwal('warning-message-and-cancel', e);
        }
    });
}