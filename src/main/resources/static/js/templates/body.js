

/*
* BODY
* =============================================
*/
const bodyTemplate = 'static/mustache/body.mustache';

function generateBody() {
    $.get(bodyTemplate, function (template) {
        $('body').html(
            Mustache.render(template)
        );
    });
}


/*
* PAGE TITLE
* =============================================
*/

const bodyPageTemplate = 'static/mustache/page-title.mustache';


function generatePageTitleJson(title) {
    return {
        "title" : title
    }
}

function generatePageTitle(title, afterSelector = '#header') {
    $.get(bodyPageTemplate, function (template) {
        $(afterSelector).after(
            Mustache.render(template, generatePageTitleJson(title))
        )
    })
}


/*
* FUNCTIONS
* =============================================
*/

const badRequest = (status, text) =>
    `<strong>Bad request!</strong><br>
     Our specialists are already working on the problem<br>
     <b>Status code:</b> ${status} <br>
     <b>Text status:</b> ${text}`;

const alertStatusBad = "danger";
const alertIconBad = "icon-remove-sign";


function showAlertBox(status, icon, message) {
    $('#alert-box').html(
        `<div class="alert alert-${status}">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
            <i class="${icon}"></i>${message}
        </div>`);
}

