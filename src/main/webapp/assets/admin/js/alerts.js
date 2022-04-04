(function($) {
  showSwal = function(type,msg) {
    'use strict';
     if (type === 'success-message') {
      swal({
        title: 'Congratulations!',
        text: msg,
        icon: 'success',
        button: {
          text: "Continue",
          value: true,
          visible: true,
          className: "btn btn-primary"
        }
      })

    } else if (type === 'warning-message-and-cancel') {
      swal({
        title: 'Error?',
        text: msg,
        icon: 'error',
        showCancelButton: true,
        cancelButtonColor: '#ff4081',
        confirmButtonText: 'Great ',
        buttons: {
          cancel: {
            text: "Cancel",
            value: null,
            visible: true,
            className: "btn btn-danger",
            closeModal: true,
          }
        }
      })

    }
  }

})(jQuery);