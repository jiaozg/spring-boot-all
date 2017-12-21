
$.ajax({
    url: "/tree",
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