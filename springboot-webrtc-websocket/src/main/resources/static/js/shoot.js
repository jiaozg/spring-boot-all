/**
 * Created by jiaozhiguang on 2017/11/7.
 */

window.onload = function () {
    var oC = document.getElementById("c1");
    //创建绘图环境 2D 平面图
    var oGC = oC.getContext("2d");
    //创建一个图片
    var yImg = new Image();
    yImg.src = "img/person.png";

    var i = 0;
    yImg.onload = function () {
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
            //save 创造一个独立空间 不受定时器影响
            oGC.save();
            oGC.translate(300, 200);
            oGC.rotate(i++ * Math.PI / 180);
            oGC.translate(-40, -40);
            oGC.drawImage(yImg, 0, 0);
            oGC.restore();

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
                // if(ball[i].num == 270 + 180) {
                //     alert("Game Over");
                //     window.location.reload();
                // }
                // ball[i].x=Math.sin(ball[i].num*Math.PI/180)*ball[i].r+ball[i].startX;
                // ball[i].y=ball[i].r - Math.cos(ball[i].num*Math.PI/180)*ball[i].r+ball[i].startY;
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
    }

    var bullet = [];



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
