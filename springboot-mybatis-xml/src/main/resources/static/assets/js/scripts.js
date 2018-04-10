
jQuery(document).ready(function() {
	
    /*
        Fullscreen background
    */
    $.backstretch("assets/img/backgrounds/1.jpg");
    
    /*
        Form validation
    */
    $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function() {
    	$(this).removeClass('input-error');
    });
    
    $('.login-form').on('submit', function(e) {
    	
    	$(this).find('input[type="text"], input[type="password"], textarea').each(function(){
    		if( $(this).val() == "" ) {
    			e.preventDefault();
    			$(this).addClass('input-error');
    		}
    		else {
    			$(this).removeClass('input-error');


                $.ajax({
                    url: "/add?lan=java",
                    success: function(data){
                        // alert(data.res);
                        console.log(data);
                        var i = 0;
                        $.each(data, function(key,value){
                            console.log(key + " -- " + value);
                            i++;
                            option.xAxis.data[i] = key;
                            option.series[0].data[i] = value;
                        });

                        // 使用刚指定的配置项和数据显示图表。
                        myChart.setOption(option);
                    }
                });

    		}
    	});
    	
    });
    
    
});
