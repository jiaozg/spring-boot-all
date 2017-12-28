
$(function () {
    $.ajax({
        url: "/getmenu",
        async: false,
        dataType: "json",
        success: function (data , textStatus) {
            console.log("data:" + data);
            console.log("textStatus:" + textStatus);
            console.log("datatext:" + data.text);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log("XMLHttpRequest:" + XMLHttpRequest);
            console.log("textStatus:" + textStatus);
            console.log("errorThrown:" + errorThrown);
        }
    })
})

function logout() {
    window.location = "/logout";
}

