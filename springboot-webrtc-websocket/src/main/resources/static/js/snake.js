/**
 * Created by jiaozhiguang on 2017/11/8.
 */

var canvas = document.getElementById("game");
var ctx = canvas.getContext("2d");
var width = 15; //每个格子的宽度

//开始画格子
for(var i =0; i<30; i++) {
    //设置画笔颜色
    ctx.strokeStyle = "RED";
    //开始和结束
    ctx.beginPath();
    //画横线
    ctx.moveTo(0, i*width);
    ctx.lineTo(450, i * width);
    //画竖线
    ctx.moveTo(i*width, 0);
    ctx.lineTo(i * width, 450 );
    ctx.closePath();
    //将线画到面板
    ctx.stroke();
}
/**
 * 面向对象，蛇的身体是一节一节的 x,y是坐标，f是方向
 * @param x
 * @param y
 * @param f方向
 *      1左 -1右 相反，判断不能走相反方向
 *      2上 -2下
 * @constructor
 */

function Cell(x, y, f) {
    this.x = x;
    this.y = y;
    this.f = f;
}
function Food(x, y) {
    this.x = x;
    this.y = y;
}
//蛇的对象， 用数组存放
var snake = [];
var length = 2; //蛇的初始长度
var speed = 100;//蛇的移动速度

var food = new Food(15, 15);
for(var i=0; i<length; i++) {
    snake[i] = new Cell(i, 0, -1);
}

for(var i=0; i<snake.length; i++) {
    var cell = snake[i];
    ctx.fillStyle = "gray";
    if(i == length -1 ) {
        ctx.fillStyle = "red";
    }
    ctx.beginPath();
    ctx.rect(cell.x*width, cell.y*width, width, width);
    ctx.closePath();
    ctx.fill();
}

ctx.fillStyle = "green";
ctx.beginPath();
ctx.rect(food.x*width, food.y*width, width, width);
ctx.closePath();
ctx.fill();

//让蛇头跟着键盘动 监听键盘事件
document.onkeydown = function (e) {
    var code = e.keyCode;
    console.log(code);
    var direction = 0;
    switch(code){
        case 37:direction=1;break;
        case 38:direction=2;break;
        case 39:direction=-1;break;
        case 40:direction=-2;break;
        case 65:direction=1;break;
        case 87:direction=2;break;
        case 68:direction=-1;break;
        case 83:direction=-2;break;
    }
    var head = snake[snake.length - 1];

    if(direction != 0 && (head.f + direction != 0)) {
        //调用蛇的移动方法
        head.f = direction;
        moveSnake(direction);

    }
}


function moveSnake(direction) {
    var head = snake[snake.length - 1];
    var newSnake = []; //新的临时的蛇的身体
    var newHead = new Cell(head.x, head.y, head.f);//复制一个新的蛇头
    //将尾巴去掉，把剩下的放到新数组
    for(var i=1; i<snake.length; i++) {
        newSnake[i - 1] = snake[i];
    }

    if(! direction) {
        direction = head.f;
    }
    newHead.f = direction;
    //修改x ， y 的坐标
    switch (direction) {
        case 1: newHead.x-- ; break;
        case 2: newHead.y--; break;
        case -1: newHead.x++; break;
        case -2: newHead.y++; break;
    }
    newSnake[newSnake.length] = newHead;
    snake = newSnake;

    gameOver();

    draw();
}

function gameOver() {
    //检测撞到游戏的边界
    var head = snake[snake.length - 1];
    if(head.x >29 || head.y > 29 || head.x < 0 || head.y <0 ) {
        alert("撞墙");
        clearInterval(autoRun);
        window.location.reload();
    }
    //不能咬到自己
    for(var i=0; i< snake.length; i++) {
        if((head.x == snake[i].x) && (head.y = snake[i].y) ){
            alert("咬到自己了");
            clearInterval(autoRun);
            window.location.reload();
        }
    }

}

draw();
function draw() {
    ctx.clearRect(0, 0, 450, 450);
    //画食物
    ctx.fillStyle = "green";
    ctx.beginPath();
    ctx.rect(food.x*width, food.y*width, width, width);
    ctx.closePath();
    ctx.fill();
    //吃食物， 食物的坐标和蛇头的坐标重叠
    var head = snake[snake.length - 1];
    if(head.x == food.x && head.y == food.y) {
        var newHead = new Cell(head.x, head.y, head.f);
        //修改x ， y 的坐标
        switch (newHead.f) {
            case 1: newHead.x-- ; break;
            case 2: newHead.y--; break;
            case -1: newHead.x++; break;
            case -2: newHead.y++; break;
        }
        snake[snake.length] = newHead;
        randomFood();
    }
    //画蛇
    for(var i=0; i<snake.length; i++) {
        var cell = snake[i];
        ctx.fillStyle = "gray";
        if(i == snake.length -1 ) {
            ctx.fillStyle = "red";
        }
        ctx.beginPath();
        ctx.rect(cell.x*width, cell.y*width, width, width);
        ctx.closePath();
        ctx.fill();
    }
}

function randomFood() {
    food.x = Math.ceil(Math.random() * 29);
    food.y = Math.ceil(Math.random() * 29);
}

var autoRun = setInterval(moveSnake, speed);


var id = document.getElementById("id");


var data = [];
for(var i=0; i<data.length;i++) {
    data[i] = i;
}

data: data;