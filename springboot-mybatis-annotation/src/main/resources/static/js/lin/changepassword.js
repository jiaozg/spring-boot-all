function submit1(){
	
	oldpassword = $("#oldpassword").val();
	password = $("#password").val();
	repassword = $("#repassword").val();
	
	if(password != repassword){
		alert("新密码两次输入不一样");
		return;
	}
	
	if(oldpassword == password){
		alert("新旧密码不能相同");
		return;
	}
	
	
	console.log("submit");
	$.ajax({
		url: "/rsetpassword",
		type: "POST",
		data: $("#changefrom").serialize(),
		success:function(data){
			console.log(data);
			if(data == 3){
				alert("原密码输入有误");
			}else if(data == 1){
				alert("修改完成");
				window.location="/logout"
			}else{
				alert("系统错误，请重试");
			}
			
		},
		error:function(){
			alert("系统错误，请重试");			
		}
	});
}