
/*
* LOGIN PAGE
* =============================================
*
* Generating all page elements
*
*/

function generateLoginPage(csrfToken, formsAfterSelector = formSelectorDefault) {
    generateForms(csrfToken, formsAfterSelector)
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
function generateFormsJson(csrfToken) {
    return {
        "csrfToken" : csrfToken
    }
}

function generateForms(csrfToken, selector) {
    $.get(formTemplate, function (template) {
        $(selector).prepend(
            Mustache.render(template, generateFormsJson(csrfToken))
        )
    });
}
