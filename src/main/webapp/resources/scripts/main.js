$(document).ready(function () {

    $.validator.addMethod("onlyNumber", function (value) {
        value = value.replace('.',',')
        if ($.isNumeric(value) && Math.floor(value) == value) {
            return true;
        }
        return false;
    }, "Only integers!");

    $("#addNumberForm").validate({
        rules: {
            numberValue: {
                required: true,
                maxlength: 20,
                onlyNumber: true
            }
        },
        messages: {
            numberValue: {
                required: "Value is required",
                maxlength: "Value is too big"
            }
        }
    });

});