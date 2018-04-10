// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('main'));

// 指定图表的配置项和数据
var option = {
    title: {
        text: 'Java 行情分析'
    },
    tooltip: {},
    legend: {
        data:['Java']
    },
    xAxis: {
        data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
    },
    yAxis: {},
    series: [{
        name: '招聘人数',
        type: 'bar',
        data: [5, 20, 36, 10, 10, 20]
    }]
};

// myChart.setOption(option);


$.ajax({
    url: "/map?lan=java",
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

// console.log($.ajax({url:"/map?lan=java"}));
