

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