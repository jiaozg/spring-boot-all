/**
 * Created by jiaozhiguang on 2017/11/7.
 */

window.onload = function () {
    var oC = document.getElementById("c1");
    //创建绘图环境 2D 平面图
    var oGC = oC.getContext("2d");
    // oGC.beginPath();
    //起点X轴，Y轴，半径，开始度数 结束度数 弧度=度数*Math.PI／180
    // oGC.arc(300, 200, 200, 0, 90 * Math.PI / 180, false); //画圆
    // oGC.closePath();
    // oGC.stroke();//划线
    
    setInterval(function () {
        //清除画布
        oGC.clearRect(0, 0, oC.width, oC.height);
        //轨道一
        oGC.beginPath();
        oGC.arc(300, 200, 200, -90*Math.PI/180, 180 * Math.PI / 180, false); //画圆
        oGC.stroke();//划线
        //轨道er
        oGC.beginPath();
        oGC.arc(250, 200, 150, 180*Math.PI/180, 360 * Math.PI / 180, false); //画圆
        oGC.stroke();//划线
        //轨道三
        oGC.beginPath();
        oGC.arc(400, 200, 20, 0, 360 * Math.PI / 180, false); //画圆
        oGC.stroke();//划线


        for(var i=0; i<ball.length;i++) {
            oGC.beginPath();
            oGC.moveTo(ball[i].x, ball[i].y);
            oGC.arc(ball[i].x, ball[i].y, 20, 0, 360 * Math.PI / 180, false); //画圆
            oGC.fill();//划线
        }


    }, 1000/60)

    //
    setInterval(function () {
        for(var i=0; i<ball.length; i++) {
            ball[i].num++;
            if(ball[i].num == 270) {
                ball[i].r = 150;
                ball[i].startX = 250;
                ball[i].startY = 50;
            }
            if(ball[i].num == 270 + 180) {
                alert("Game Over");
                window.location.reload();
            }
            ball[i].x=Math.sin(ball[i].num*Math.PI/180)*ball[i].r+ball[i].startX;
            ball[i].y=ball[i].r - Math.cos(ball[i].num*Math.PI/180)*ball[i].r+ball[i].startY;
        }

    }, 30)

    var ball = [];

    setInterval(function () {
        ball.push(
            {
                x:300,
                y:0,
                r:200,
                num:0,
                startX:300,
                startY:0
            }
        )
    }, 500)



    // var i=0;
    // setInterval(function () {
    //     //清除画布
    //     oGC.clearRect(0, 0, oC.width, oC.height);
    //     oGC.beginPath();
    //     oGC.arc(i++, i++, 20, 0, 360 * Math.PI / 180, false); //画圆
    //     oGC.closePath();
    //     oGC.stroke();//划线
    // }, 30)
}
