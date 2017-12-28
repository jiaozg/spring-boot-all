$(function(){
    $("#btnaddmemo").click(function () {
        $("#adddialog").show("slow");
    });

    $("#cancel").click(function () {
        $("#adddialog").hide("slow");
    });

    $("#submit").click(function () {
        addmemo();
    });



})

function addmemo(){
    title = $("#title").val();
    if(title == ""){
    	erroralert("" , "标题不能为空" );
        return;
    }
    text = $("#text").val();
    if(text == ""){
    	erroralert("" , "内容不能为空" );
        return;
    }

    time = new Date().toLocaleString();

    $.ajax({
        url: "addmemo",
        type: "POST",
        data:{"title":title,
        "text":text,
        "time":time
        },
        success: function (data) {
            if(data == "000"){
            	successalert("","便签保存完成");
            	window.location.reload();
            }
            $("#adddialog").hide("slow");
        },
        error: function () {
        	erroralert("" , "便签保存失败" );
            $("#adddialog").hide("slow");
        }
    });
    
    $("#title").val("");
    $("#text").val("");
 }

function deletememodialog(obj){
    swal({
        "title": "",
        "text": "确定要删除此便签吗？",
        "type": "warning",
        "showCancelButton": true,
        "confirmButtonColor": "#DD6B55",
        "confirmButtonText": "确定删除此便签！",
        "cancelButtonText": "让我再考虑一下…",
        "closeOnConfirm": false,
        "closeOnCancel": false
    },  function (isConfirm) {
        if (isConfirm) {
        	deletememo(obj);
        } else {
            swal("", "您取消了操作！", "error");
        }
    }
    );
}

function deletememo(obj){
	id = obj.id;
	console.log($("#"+id).attr("id"));
	$.ajax({
		url: "deletememo",
		type: "POST",
		data:{"id":id},
		success: function(data){
			if(data == "000"){
				successalert("", "删除完成");
				window.location.reload();
			}
		},
		error:function(){
			erroralert("" , "删除失败");
		}
	});
	
}