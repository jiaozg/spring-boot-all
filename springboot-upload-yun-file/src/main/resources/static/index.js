function fileChoice() {
    document.getElementById("files").click();
}

function fileUp() {
    var files = document.getElementById("files").files;
    var flist = document.getElementById("flist");
    var html = "";
    for(var i =0; i< files.length; i++){
        var file = files[i];
        html += "<ul>" +
                "<li style=\"width: 30%\">"+ file.name + "</li>" +
                "<li style='width: 68%'><progress max=100 value=0 id='pro"+i+"'></progress><label id='lbl"+i+"'></label></li>" +
                "</ul>";
        doFileUp(file, i);
    }
    console.log(html);
    flist.innerHTML += html;
}

function doFileUp(file, index) {
    var formData = new FormData();
    formData.append(file.name, file);
    var xhr = new XMLHttpRequest();
    xhr.open("post", "/fileUp.do", true);
    var total=0, curUpload = 0, oldUpload=0;
    xhr.upload.addEventListener("progress", function (event) {
        var percent = Math.round(event.loaded/event.total*100);
        document.getElementById("pro"+index).value = percent;
        curUpload = event.loaded;
        if(oldUpload == 0) {
            total = event.total;
            oldUpload = event.loaded;
        }
    }, false);

    var upSpeed = setInterval(function () {
        if(oldUpload != 0) {
            var result = curUpload - oldUpload;
            var leave = total - curUpload;
            oldUpload = curUpload;
            document.getElementById("lbl" + index).innerHTML = Math.round(result/(1024*1024)) + "M/S " + Math.round(leave/result) + "秒";
            if(total == oldUpload && result == 0) {
                clearInterval(upSpeed);
            }
        }
    }, 1000);

    xhr.send(formData);
}