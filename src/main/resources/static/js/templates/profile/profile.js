
/*
* PROFILE PAGE
* =============================================
*
* Profile page
*
*/
const profileTemplate = "static/mustache/profile/profile-content.mustache";
function generateProfilePage(selector = ".content-wrap > .container") {
    $.get(profileTemplate, function (template) {
        $(selector).prepend(
            Mustache.render(template)
        )
    });
}



