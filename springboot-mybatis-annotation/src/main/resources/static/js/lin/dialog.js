//$(function(){
//	$("#bb").click(function(){
//		deletealert("正常title", "正常text" , function(){successalert("删除", "删除啦啦啦")});
//	});
//});



function show_dialog() {
    $("#lindialog").dialog("open");
}
function showdialog(bodytext , button1 , button2 ,button1function , button2function) {
    initdialog(bodytext , button1 , button2 ,button1function , button2function );
    $("#lindialog").dialog("open");
}

function initdialog(bodytext , button1 , button2 ,button1function , button2function ){
    var btnjson ;
    if(button1 == ""){
        btnjson = [{
            text: button2,
            click: function() {
                button2function();
                $( this ).dialog( "close" );
            }
        }];
    }else {
        btnjson = [
            {
                text: button1,
                click: function() {
                    button1function();
                    $( this ).dialog( "close" );
                }
            },
            {
                text: button2,
                click: function() {
                    button2function();
                    $( this ).dialog( "close" );
                }
            }
        ];
    }
    if($("#lindialog").length > 0 ){
        $("#lindialog").text(bodytext);
    }else{
        $("body").append('<div id="lindialog" style="display:none">' + bodytext +'</div>');
    }
    $( "#lindialog" ).dialog({
        autoOpen: false,
        width: 200,
        buttons: btnjson,
        show: {
            effect: "blind",
            duration: 300
        },
        hide: {
            effect: "explode",
            duration: 500
        }
    });

}

function nromalalert(title , text){
	swal({
		"title":title,
		"text":text
	});
}

function successalert(title , text){
	swal({
		"title":title,
		"text":text,
		"type":"success"
	});
}

function errorsalert(title , text){
	swal({
		"title":title,
		"text":text,
		"type":"error"
	});
}
function warningalert(title , text){
	swal({
		"title":title,
		"text":text,
		"type":"warning"
	});
}

function deletealert(title , text , func1){
	 swal({
         "title": title,
         "text": text,
         "type": "warning",
         "showCancelButton": true,
         "confirmButtonColor": "#DD6B55",
         "confirmButtonText": "是的，我要删除！",
         "cancelButtonText": "让我再考虑一下…",
         "closeOnConfirm": false,
         "closeOnCancel": false
     },  function (isConfirm) {
         if (isConfirm) {
             func1();
         } else {
             swal("", "您取消了删除操作！", "error");
         }
     }
     );
}
function updatealert(title , text , func1){
	swal({
		"title": title,
		"text": text,
		"type": "warning",
		"showCancelButton": true,
		"confirmButtonColor": "#DD6B55",
		"confirmButtonText": "是的！",
		"cancelButtonText": "再考虑一下…",
		"closeOnConfirm": false,
		"closeOnCancel": false
	},  function (isConfirm) {
		if (isConfirm) {
			func1();
		} else {
			swal("", "您取消了当前操作！", "error");
		}
	}
	);
}

