在线直播

1，提供给主播一个开播界面，调用设备摄像头，可以往服务器发送图像数据
2，给观众一个围观界面，接收服务器发送的图像信息
3，使用websocket构建一个服务器

Socket编程

WebSocket协议是基于TCP的一种新的网络协议。
它实现了浏览器与服务器全双工(full-duplex)通信——允许服务器主动发送信息给客户端

Navigator.getUserMedia()方法提醒用户需要使用音频（0或者1）和（0或者1）视频输入设备，
比如相机，屏幕共享，或者麦克风。如果用户给予许可，successCallback回调就会被调用，MediaStream对象作为回调函数的参数。如果用户拒绝许可或者没有媒体可用，errorCallback就会被调用
navigator.getUserMedia ( constraints, successCallback, errorCallback );

一、URL.createObjectURL 
　　URL.createObjectURL()方法会根据传入的参数创建一个指向该参数对象的URL。
　　这个URL的生命仅存在于它被创建的这个文档里，新的对象URL指向执行的File对象或者是Blob对象。

setTimeout

定义和用法: setTimeout()方法用于在指定的毫秒数后调用函数或计算表达式。　　

语法: setTimeout(code,millisec) 　

参数： code （必需）：要调用的函数后要执行的 JavaScript 代码串。millisec（必需）：在执行代码前需等待的毫秒数。 　 提示： setTimeout() 只执行 code 一次。如果要多次调用，请使用 setInterval() 或者让 code 自身再次调用 setTimeout()。

setInterval

setInterval() 方法可按照指定的周期（以毫秒计）来调用函数或计算表达式。

setInterval() 方法会不停地调用函数，直到 clearInterval() 被调用或窗口被关闭。由 setInterval() 返回的 ID 值可用作 clearInterval() 方法的参数。

语法: setInterval(code,millisec[,"lang"])

参数: code 必需。要调用的函数或要执行的代码串。millisec 必须。周期性执行或调用 code 之间的时间间隔，以毫秒计。

返回值: 一个可以传递给 Window.clearInterval() 从而取消对 code 的周期性执行的值。

主播开播链接
http://localhost:8080/xiu

http://localhost:8080/xiu

围观主播链接
http://localhost:8080/live


html 结构
css  样式
js   功能

http://akquinet.github.io/jquery-toastmessage-plugin/