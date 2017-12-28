$(function () {
	$("#changesubmit").click(function(){
		modify();
	});
	
	
	
	console.log("hello");
	$.jgrid.defaults.styleUI = 'Bootstrap';

	
	$.ajax({
		url:"/deptlistforadd",
		type:"POST",
		beforeSend:function(){
			$("#loading").show();
		},
		success:function(data){
			console.log(data);
			buildgrid(data);
		},
		error:function(){
			console.log("error");
		},
		complete:function(){
			$("#loading").hide();
		}
	});


			});

function deldialog(id) {
//    initdialog("确定要删除吗？" , "确定" , "关闭" , function () {
//		del(id);
//    } , function () {});
//    show_dialog();
	deletealert("" , "确定要删除此角色吗？" , function(){del(id)});
}


function del(id){

	var jsondata = {"id" : id};
	$.ajax({
		url: "/deleterole",
		type: "POST",
		data: jsondata,
		success: function(data , stutas){
			console.log(data);
			if(data == "000"){
				$("#table_list_2").trigger("reloadGrid");
				successalert("" , "删除角色完成");
			}else{
				errorsalert("" , "删除角色失败");
			}
		},
		error: function(){
			errorsalert("" , "出现错误，请重试");
		}
	});


}
function modify(){




	console.log($("#changefrom").serialize());
	
	$.ajax({
		url: "/setrole",
		type: "POST",
		data: $("#changefrom").serialize(),
		success: function(data){
			console.log(data);
			if(data == 000){
				successalert("" , "角色名称修改完成");
				$("#table_list_2").trigger("reloadGrid");
				changedialogdismiss();
			}else if(data == "009"){
				errorsalert("" , "已经存在相同的角色名称，修改失败");
			}else if(data == "008"){
				errorsalert("" , "已经存在相同的英文名称，修改失败");
			}
			
			else{
				errorsalert("" , "出现错误，请重试");
			}
			
		},
		error: function(){
			errorsalert("" , "出现错误，请重试");
		}
	});
}

var roleidforterr = x;

function showtreedialog(id){
	roleidforterr = id;
	showtree();
	console.log(window.event.clientX)
	console.log(window.event.clientY)
	
}

function resetpasswork(id){

	var jsondata = {"id" : id};
	$.ajax({
		url: "/resetpassword",
		type: "POST",
		data: jsondata,
		success: function(data , stutas){
			console.log(data);
			successalert("" , "用户密码重置完成");
			if(data == "1"){
				successalert("" , "用户密码重置完成");
			}else{
				errorsalert("" , "出现错误，请重试");
			}
		},
		error: function(){
			errorsalert("" , "出现错误，请重试");
		}
	});

}


function changedialogdismiss(){
	$("#changedialog").hide(speed="slow");
}
function changedialogshow(id){
	
	
	var datas = $("#table_list_2").jqGrid("getRowData",id);
	$("#changeid").attr("value" , id);
	$("#changetips").val(datas.tips);
	$("#changeroles").val(datas.roles);
	$("#changedialog").show(speed="slow");
}

function buildgrid(deptinfo){
	$("#table_list_2").jqGrid(
			{
				url : "/showrolelist",
				datatype: "json",
				mtype: "POST",
				height: "100%",
				autowidth: true,
//				shrinkToFit: true,
            rownumbers : true,
            jsonReader: {
                root:"dataList",
                page:"currentPage",
                total:"totalPage",          //   很重要 定义了 后台分页参数的名字。
                records:"totalCount"
            },
            rowNum: 10,
				rowList: [10, 20, 30],
				colNames: ['角色名称' ,'英文名称','可见菜单','操作'],
				colModel: [
				           {
				        	   name: 'tips',
				        	   index: 'tips',
				        	   editable: true,
				        	   width: 50

				           },
				           {
				        	   name: 'roles',
				        	   index: 'roles',
				        	   editable: true,
				        	   width: 50
				           },
				           {
				        	   name: 'menus',
				        	   index: 'menus',
				        	   width: 150
				           },
				           {
				        	   name: 'handle',
				        	   index: 'handle',
				        	   width: 60,
				        	   sortable: false
				           }
				           ],
				           pager: "#pager_list_2",
				           viewrecords: true,
				           caption: "用户列表",
				           add: true,
				           edit: false,
				           addtext: 'Add',
				           editurl: "/addrole",
				           hidegrid: false , 
				           gridComplete: function(){
				        	   console.log("grid Complete");				        	
				        	   var ids = $("#table_list_2").jqGrid("getDataIDs");
				        	   for (var int = 0; int < ids.length; int++) {
				        		   var id = ids[int];
				        		   var modify = "<a href='#' style='color:#f60' onclick='changedialogshow(" + id + ")'>修改信息</a>";  //这里的onclick就是调用了上面的javascript函数 Modify(id)
				        		   var resetpasswork = "<a href='#'  style='color:#f60' onclick='showtreedialog(" + id + ")' >配置菜单</a>";
				        		   var del = "<a href='#'  style='color:#f60' onclick='deldialog(" + id + ")' >删除角色</a>";
				        		   
				        		   if(id == 1 || id == 2){
				        			   del = "";
				        		   }
				        		   
				        		   var result = $("#table_list_2").jqGrid("setRowData", id, {handle: modify + "&nbsp &nbsp" + resetpasswork + "&nbsp &nbsp" + del});
				        	   }
				           }
			});

	// Setup buttons
	$("#table_list_2").jqGrid('navGrid', '#pager_list_2', {
		edit: false,
		add: true,
		del: false,
		search: false
	}, {
		height: 300,
		reloadAfterSubmit: true
	});


	$(window).bind('resize', function () {
		var width = $('.jqGrid_wrapper').width();
		$('#table_list_2').setGridWidth(width);
	});

}

function showtree(){
	$("#menutree").show("slow");
}
function hidetree(){
	$("#menutree").hide("slow");
}
function getChecked(){
	var nodes = $('#tt').tree('getChecked');
	var s = '';
	for(var i=0; i<nodes.length; i++){
		if (s != '') s += ',';
		s += nodes[i].text;
	}
	return s;
}


function submittree(){
	data = {"roleid":roleidforterr,"menus":getChecked()};
	$.ajax({
		url:"/addrelation",
		type:"post",
		"data":data,
		success: function(data){
			console.log(data);
			if(data == 000){
				successalert("","菜单配置完成");
				hidetree();
				$("#table_list_2").trigger("reloadGrid");
			}else{
				errorsalert("" , "出现错误，请重试" );
			}
		},
		error:function(){
			errorsalert("" , "出现错误，请重试" );
		}
	})
}
