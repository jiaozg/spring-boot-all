$(function() {
	buildgrid();
});







function buildgrid() {
	$("#table_list_2").jqGrid(
		{
			url : "/getoperationleavelist",
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
			colNames : [ '类型','姓名', '开始时间', '结束时间', '原因', '申请时间', '状态', '操作人', '操作' ],
			colModel : [
				{
					name : 'type',
					index : 'type',
					editable : true,
				},
				{
					name : 'username',
					index : 'username',
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
					name : 'operationUsername',
					index : 'operationUsername',
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
						var resetpasswork = "<a href='#'  style='color:#f60' onclick='acceptdialog(" + id + ")' >允许</a>";
						var unaccept = "<a href='#'  style='color:#f60' onclick='unacceptdialog(" + id + ")' >拒绝</a>";

						if(bodys[int].isfinish != "未处理"){
							resetpasswork = "";
							unaccept = "";
						}
						
						
					var result = $("#table_list_2").jqGrid("setRowData", id, {
						handle : "&nbsp &nbsp" + resetpasswork + "&nbsp &nbsp" + unaccept
					});
				}
			}
		});




	$(window).bind('resize', function() {
		var width = $('.jqGrid_wrapper').width();
		$('#table_list_2').setGridWidth(width);
	});

}


function acceptdialog(id){

    swal({
        "title": "",
        "text": "确定要同意此次请假吗？",
        "type": "warning",
        "showCancelButton": true,
        "confirmButtonColor": "#DD6B55",
        "confirmButtonText": "确定！",
        "cancelButtonText": "让我再考虑一下…",
        "closeOnConfirm": false,
        "closeOnCancel": false
    },  function (isConfirm) {
        if (isConfirm) {
        	submitfinish(id , 1);
        } else {
            swal("", "您取消了操作！", "error");
        }
    }
    );

}

function unacceptdialog(id){


    swal({
        "title": "",
        "text": "确定要拒绝此次请假吗？",
        "type": "warning",
        "showCancelButton": true,
        "confirmButtonColor": "#DD6B55",
        "confirmButtonText": "确定！",
        "cancelButtonText": "让我再考虑一下…",
        "closeOnConfirm": false,
        "closeOnCancel": false
    },  function (isConfirm) {
        if (isConfirm) {
        	submitfinish(id , 0);
        } else {
            swal("", "您取消了操作！", "error");
        }
    }
    );


}

function submitfinish(id , finishdata){
	var data = {"id" : id,"finish":finishdata};
	$.ajax({
		url: "/operationleave",
		type:"POST",
		"data":data,
		success:function(data){
			if(data == 000){
				successalert("","操作完成");
				$("#table_list_2").trigger("reloadGrid");
				return ;
			}
			errorsalert("" , "出现错误，请重试" );
		},
		error:function(){
			errorsalert("" , "出现错误，请重试" );
		}
	});
	
	
}

