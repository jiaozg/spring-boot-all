$(function() {

	buildgrid();
	initlaydate();
	$(".radio-inline").change(function() {


		checkval = $("input[name='type']:checked").val();

		console.log(checkval);
		if (checkval == 3) {
			$("#otherdiv").show("slow");
		} else {
			$("#otherdiv").hide("slow");
		}
	});



});

var checkval = "1";


function initlaydate() {

	//日期范围限制
	var start = {
		elem : '#start',
		format : 'YYYY/MM/DD hh:mm:ss',
		min : laydate.now(), //设定最小日期为当前日期
		max : '2099-06-16 23:59:59', //最大日期
		istime : true,
		istoday : false,
		choose : function(datas) {
			end.min = datas; //开始日选好后，重置结束日的最小日期
			end.start = datas //将结束日的初始值设定为开始日
		}
	};
	var end = {
		elem : '#end',
		format : 'YYYY/MM/DD hh:mm:ss',
		min : laydate.now(),
		max : '2099-06-16 23:59:59',
		istime : true,
		istoday : false,
		choose : function(datas) {
			start.max = datas; //结束日选好后，重置开始日的最大日期
		}
	};
	laydate(start);
	laydate(end);

}


function submitleave() {
	var othertext = $("#othertext").val();
	var reason = $("#reason").val();
	var start = $("#start").val();
	var end = $("#end").val();
	if (checkval == 3 && othertext.trim() == "") {
		errorsalert("" , "请输入其他请假类型");
		return;
	}
	if (start == "") {
		errorsalert("" , "请选择开始时间");
		return;
	}
	if (end == "") {
		errorsalert("" , "请选择结束时间");
		return;
	}
	if (reason.trim() == "") {
		errorsalert("" , "请输入请假原因");
		return;
	}

	
	$.ajax({
		url : "/addleave",
		type : "POST",
		data : $("#leaveform").serialize(),
		success : function(data) {
			if (data == 000) {
				setTimeout(function() {
					window.location="/leavepage";					
				}, 1000)
				successalert("" , "已提交,请等待领导审核");
			}
		},
		error : function() {
			errorsalert("" , "提交失败，请重试！");
		}
	});


}

function buildgrid() {
	$("#table_list_2").jqGrid(
		{
			url : "/getuserleavelist",
			datatype : "json",
			mtype : "POST",
			height : "100%",
			autowidth : true,
			rownumbers : true,
			jsonReader : {
				root : "dataList",
				page : "currentPage",
				total : "totalPage", //   很重要 定义了 后台分页参数的名字。
				records : "totalCount"
			},
			rowNum : 10,
			rowList : [ 10, 20, 30 ],
			colNames : [ '类型', '开始时间', '结束时间', '原因', '申请时间', '状态', '操作' ],
			colModel : [
				{
					name : 'type',
					index : 'type',
					editable : true,
				},
				{
					name : 'starttime',
					index : 'starttime',
					editable : true,
					edittype : "select",
				},
				{
					name : 'endtime',
					index : 'endtime',
					editable : true,
				},
				{
					name : 'reason',
					index : 'reason',
				},
				{
					name : 'createtime',
					index : 'createtime',
				},
				{
					name : 'isfinish',
					index : 'isfinish',
				},
				{
					name : 'handle',
					index : 'handle',
				}
			],
			pager : "#pager_list_2",
			viewrecords : true,
			hidegrid : false, 
			gridComplete : function() {
				console.log("grid Complete");
				var ids = $("#table_list_2").jqGrid("getDataIDs");
				var bodys = $("#table_list_2").jqGrid("getRowData");
				for (var int = 0; int < ids.length; int++) {
					var id = ids[int];
					var resetpasswork = "<a href='#'  style='color:#f60' onclick='withdrawdialog(" + id + ")' >撤回</a>";
					
					if(bodys[int].isfinish != "未处理"){
						resetpasswork = "";
					}
					
					
					var result = $("#table_list_2").jqGrid("setRowData", id, {
						handle : "&nbsp &nbsp" + resetpasswork
					});
				}
			}
		});

	//	// Setup buttons
		//	$("#table_list_2").jqGrid('navGrid', '#pager_list_2', {
		//		edit: false,
		//		add: true,
		//		del: false,
		//		search: false
		//	}, {
		//		height: 300,
		//		reloadAfterSubmit: true
		//	});


	$(window).bind('resize', function() {
		var width = $('.jqGrid_wrapper').width();
		$('#table_list_2').setGridWidth(width);
	});

}


function toform() {
	$("#leaveformdiv").show("slow");
	$("#leavetable").hide("slow");
	$("#btnform").attr("class", "btn btn-w-m btn-danger");
	$("#btntable").attr("class", "btn btn-w-m btn-default");
}
function totable() {
	$("#leaveformdiv").hide("slow");
	$("#leavetable").show("slow");
	$("#btnform").attr("class", "btn btn-w-m btn-default");
	$("#btntable").attr("class", "btn btn-w-m btn-danger");
}

function withdrawdialog(id){
    swal({
        "title": "",
        "text": "确定要撤回吗？",
        "type": "warning",
        "showCancelButton": true,
        "confirmButtonColor": "#DD6B55",
        "confirmButtonText": "确定！",
        "cancelButtonText": "让我再考虑一下…",
        "closeOnConfirm": false,
        "closeOnCancel": false
    },  function (isConfirm) {
        if (isConfirm) {
        	withdraw(id);
        } else {
            swal("", "您取消了操作！", "error");
        }
    }
    );
}


function withdraw(id){
	data = {"id" : id};
	$.ajax({
		url: "withdrawleave",
		type: "POST",
		"data" : data,
		success:function(data){
			if(data == 000){
				successalert("" , "撤回成功");
				$("#table_list_2").trigger("reloadGrid");
				return ;
			}else{
				errorsalert("" , "撤回失败，请重试！");
			}
		},
		error:function(){
			errorsalert("" , "撤回失败，请重试！");
		}
	});
}