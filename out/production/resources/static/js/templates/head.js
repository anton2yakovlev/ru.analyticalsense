
function generateHeadJson(title, styles) {
    return {
        "title" : title,
        "styles" : generateStyles(styles)
    }
}

function generateStyles(styles) {
    let stylesHTML = '';
    styles.forEach(function (href) {
        stylesHTML += `<link rel="stylesheet" href="${href}" type="text/css" />`;
    });

    return stylesHTML
}

function generateHead(title, styles=[]) {
    $.get('static/mustache/head.mustache', function (template) {
        $('head').html(

            Mustache.render(template, generateHeadJson(title, styles))
        )
    });
}
