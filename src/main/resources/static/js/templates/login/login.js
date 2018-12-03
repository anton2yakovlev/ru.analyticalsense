
/*
* LOGIN PAGE
* =============================================
*
* Generating all page elements
*
*/

function generateLoginPage(formsAfterSelector = formSelectorDefault) {
    generateForms(formsAfterSelector)
}



/*
* FORMS
* =============================================
*
* Login & Registration
*
*/




const formTemplate = 'static/mustache/login/forms.mustache';
const formSelectorDefault = ".content-wrap > .container";


function generateForms(selector) {
    $.get(formTemplate, function (template) {
        $(selector).prepend(
            Mustache.render(template)
        )
    });
}


$('body').on('submit', '#register-form', function () {


    $.ajax({
        type: "POST",
        dataType: "json",
        data: {
            "username": $('#register-form-name').val(),
            "password": $('#register-form-password').val()
        },
        url: "http://localhost:8080/registration",
        success: function (data) {
            showAlertBox(data.status, data.icon, data.message);
        },
        error: function (jqXHR, textStatus) {
            showAlertBox(alertStatusBad, alertIconBad, badRequest(jqXHR.status, textStatus));
        }
    });


    return false

});
