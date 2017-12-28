$(function() {

	inittoastr();
	initlaydate();
	
	$("#bb").click(function(){
		toastr.info("body" , "title");
	});
	
})




function inittoastr(){
	//参数设置，若用默认值可以省略以下面代
		toastr.options = {
			"closeButton" : true, //是否显示关闭按钮

			"debug" : false, //是否使用debug模式

			"positionClass" : "toast-top-right", //弹出窗的位置
			
			 "progressBar": true, //进度条

			"showDuration" : "300", //显示的动画时间

			"hideDuration" : "1000", //消失的动画时间

			"timeOut" : "5000", //展现时间

			"extendedTimeOut" : "1000", //加长展示时间

			"showEasing" : "swing", //显示时的动画缓冲方式

			"hideEasing" : "linear", //消失时的动画缓冲方式

			"showMethod" : "fadeIn", //显示时的动画方式

			"hideMethod" : "fadeOut" //消失时的动画方式

		};
		
}

function initlaydate(){
	 //日期范围限制
    var start = {
        elem: '#start',
        format: 'YYYY/MM/DD hh:mm:ss',
        min: laydate.now(), //设定最小日期为当前日期
        max: '2099-06-16 23:59:59', //最大日期
        istime: true,
        istoday: false,
        choose: function (datas) {
            end.min = datas; //开始日选好后，重置结束日的最小日期
            end.start = datas //将结束日的初始值设定为开始日
        }
    };
    var end = {
        elem: '#end',
        format: 'YYYY/MM/DD hh:mm:ss',
        min: laydate.now(),
        max: '2099-06-16 23:59:59',
        istime: true,
        istoday: false,
        choose: function (datas) {
            start.max = datas; //结束日选好后，重置开始日的最大日期
        }
    };
    laydate(start);
    laydate(end);
}