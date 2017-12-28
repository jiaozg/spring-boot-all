$(function() {

	
	$("#btndown").click(function() {

		downfile();
	});
    $("#btnclear").click(function() {
//        showdialog("确定要清除登陆日志？","确定","关闭" , function () {
//            clearlog();
//        } ,function () {});
      
        swal({
            "title": "",
            "text": "确定要清除登陆日志？",
            "type": "warning",
            "showCancelButton": true,
            "confirmButtonColor": "#DD6B55",
            "confirmButtonText": "清除登陆日志！",
            "cancelButtonText": "让我再考虑一下…",
            "closeOnConfirm": false,
            "closeOnCancel": false
        },  function (isConfirm) {
            if (isConfirm) {
            	clearlog();
            } else {
                swal("", "您取消了操作！", "error");
            }
        }
        );
        
    });

	$.jgrid.defaults.styleUI = 'Bootstrap';

	$("#table_list_2").jqGrid(
		{
			url : "/loginloglist",
			datatype : "json",
			mtype : "POST",
			height : "100%",
			rownumbers : true,        // 必须为true
			autowidth : true,
			shrinkToFit : true,
			rowNum : 10,
			jsonReader: {  
                root:"dataList", 
                page:"currentPage",
                total:"totalPage",          //   很重要 定义了 后台分页参数的名字。
                records:"totalCount"
            },
			rowList : [ 10, 20, 30 ],
			colNames : [ '用户名', '操作','时间' ],
			colModel : [
				{
					name : 'username',
					index : 'username',
					editable : true,
					width : 90
				},
				{
					name : 'logname',
					index : 'logname',
					width : 100,
					sortable : false
				},
				{
					name : 'createtime',
					index : 'createtime',
					width : 100,
					sortable : false
				}
			],
			pager : "#pager_list_2",
			viewrecords : true,
			caption : "登陆日志列表",
			add : true,
			edit : false,
			addtext : 'Add',
			editurl : "/adddept",
			hidegrid : false, 
			gridComplete : function() {
				console.log("grid Complete");
				$("#loading").hide();
				$("#btndown").show(speed="slow");
				$("#btnclear").show(speed="slow");
			}
		});

	//	// Add selection
		//	$("#table_list_2").setSelection(4, true);
		//

	// Setup buttons
	$("#table_list_2").jqGrid('navGrid', '#pager_list_2', {
		edit : false,
		add : false,
		del : false,
		search : false
	}, {
		height : 300,
		reloadAfterSubmit : true
	});


	$(window).bind('resize', function() {
		var width = $('.jqGrid_wrapper').width();
		$('#table_list_2').setGridWidth(width);
	});


});

function downfile() {
	/**
	 * JQuery的ajax函数的返回类型只有xml、text、json、html等类型，没有“流”类型，所以我们要实现ajax下载，不能够使用相应的ajax函数进行文件下载。但可以用js生成一个form，用这个form提交参数，并返回“流”类型的数据。
	 */
	var form = $("<form>"); //定义一个form表单
	form.attr("style", "display:none");
	form.attr("target", "");
	form.attr("method", "get");
	form.attr("action", "/downloginlogexcel");
	var input1 = $("<input>");
	input1.attr("type", "hidden");
	input1.attr("name", "type");
	input1.attr("value", "1");
	$("body").append(form); //将表单放置在web中
	form.append(input1);

	form.submit(); //表单提交 
}

function clearlog() {
	$.ajax({
		url : "/clearloginlog",
		data: {"type":1},
		type : "POST",
		success : function(data) {
			$("#table_list_2").trigger("reloadGrid");
			console.log(data);
			if (data == 000) {
                successalert("" , "登陆日志清除完成" );
                
			} else if (data == 005) {
				erroralert("" , "日志清除失败，或者数据库中无日志" );
			}
		},
		error : function() {
            erroralert("" , "日志清除失败" );
		}
	});
}

