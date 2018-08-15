<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>WebSocket Chat</title>
</head>
<body>
<script type="text/javascript">
    <#--var msg = '\n';-->
    <#--<#list userMsgList as userMsg>-->
    <#--msg = msg + '${userMsg.name!''}'+':'+'${userMsg.msg!''}' +'\n';-->
    <#--</#list>-->
    <#--msg = msg+'\n'+'--- 以上为历史记录 ---'+'\n';-->
    var socket;
    if (!window.WebSocket) {
        window.WebSocket = window.MozWebSocket;
    }
    if (window.WebSocket) {
        socket = new WebSocket("ws://localhost:8090/ws");
        socket.onmessage = function(event) {
            var ta = document.getElementById('responseText');
            ta.value = ta.value + '\n' + event.data
        };
        socket.onopen = function(event) {
            var ta = document.getElementById('responseText');
             ta.value = "--- 连接开启! ---"
        };
        socket.onclose = function(event) {
            var ta = document.getElementById('responseText');
            ta.value = ta.value+ '\n' + "连接被关闭";
        };
    } else {
        alert("你的浏览器不支持 WebSocket！");
    }

    function send(message) {
        var level = document.getElementById('level');
        message = level.value + message;
        if (!window.WebSocket) {
            return;
        }
        if (socket.readyState == WebSocket.OPEN) {
            socket.send(message);
        } else {
            alert("连接没有开启.");
        }
    }
    window.onbeforeunload = function(event) {
        event.returnValue = "刷新提醒";
    };
</script>
<form onsubmit="return false;">
    <h3>SpringBoot netty 聊天室：</h3>
    <textarea id="responseText" style="width: 400px; height: 300px;"></textarea>
    <br>
    <select name="level" id="level">
        <option value="1">高级别用户</option>
        <option value="2">中级别用户</option>
        <option value="3">低级别用户</option>
    </select>
    <input type="text" name="message"  style="width: 300px" value="测试数据">
    <input type="button" value="发送消息" onclick="send(this.form.message.value)">
</form>
<br>
<br>
</body>
</html>