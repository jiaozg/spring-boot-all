$(function(){
    var onOFF=true; // 开关 控制点击里面做2件事
    $('.s_close').click(function(){
        $('.screen').toggle(1000);
        if(onOFF){
            $('.s_close').html('打开弹幕');
            onOFF=false;
        }else{
            $('.s_close').html('关闭弹幕');
            onOFF=true;
        }
        // 双选 时间 毫秒 1000MS=1S
    })

    // 初始化弹幕
    init_screen()
    //发送评论

    $('.btn').click(function(){
        var texts=$('.text').val();
        console.log(texts);
        var con=$('<li>'+texts+'</li>');
        $('.show').append(con);
        init_screen();

        count();

    })

    function count() {
        var count = $('.s_count').text();
        var intCount = parseInt(count);
        intCount++;
        $('.s_count').html(intCount);
    }

    function init_screen(){
        var _top=0;
        $('.show').find('li').each(function(){
            var _left=$(window).width()-$(this).width();
            var _height=$(window).height();
            _top=_top+76;
            if(_top >=_height-150){
                _top=76;
            }

            // 初始化文字的位置
            $(this).css({left:_left,top:_top,color:getColor()});
            // 动起来
            var time=(Math.random()+1)*10000
            // 1-2  10000-20000
            $(this).animate({left:"-"+_left+'px'},time,function(){
                $(this).remove()
            })

        })
    }
    // 封装一个获取随机颜色的方法
    // red #f00  rgba()
    // rgba(255,255,255,1) 白色
    //rgba(0,0,0,1) 黑色
    //Math.random()*254 0-255 Math.ceil(Math.random()*255) // 1-255
    //Math.ceil(3.2)  4 Math.ceil(3.8) 4
    function getColor(){
        var r=Math.ceil(Math.random()*255);
        var g=Math.ceil(Math.random()*255);
        var b=Math.ceil(Math.random()*255);
        return `rgba(${r},${g},${b},1)`
    }

})