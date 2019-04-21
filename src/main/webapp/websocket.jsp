<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>

  </head>

  <div>
    请输入发送内容:<input type="text" id="sendContent"><button id="send" onclick="send()">发送消息</button>
    <hr>
  </div>
  <div>
    <button onclick="closeWebSocket()">关闭webSocket连接</button>
  </div>
  <label>消息记录:</label>
  <div id="message">
  </div>

  <script type="text/javascript">
      function myBrowser(){
          var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
          var isOpera = userAgent.indexOf("Opera") > -1;
          //判断是否Opera浏览器
          if (isOpera) {
              return "Opera"
          };
          //判断是否Firefox浏览器
          if (userAgent.indexOf("Firefox") > -1) {
              return "Firefox";
          }
          //判断谷歌
          if (userAgent.indexOf("Chrome") > -1){
              return "Chrome";
          }
          //判断是否Safari浏览器
          if (userAgent.indexOf("Safari") > -1) {
              return "Safari";
          }
          //判断是否IE浏览器
          if (userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1 && !isOpera) {
              return "IE";
          };

      }

      //发送按钮保持选中
      $(document).keydown(function(event) {
          if (event.keyCode == 13) {
              $("#send").click();
          }
      });

      $(document).ready(function(){
          $("div").css("margin-top","50px");
      })
      var webSocket = null;
      //判断浏览器是否支持webSocket通信
      if('WebSocket' in window){
          webSocket = new WebSocket("ws://localhost:8080/ssm/webSocket");
      }else{
          alert("您的浏览器不支持webSocket通信,请升级浏览器或更换浏览器重试！")
      }
      console.log(webSocket);
      //连接发生错误的回调方法
      webSocket.onerror = function () {
          setMessageInnerHTML("WebSocket连接发生错误");
      };
      //连接成功建立的回调方法
      webSocket.onopen = function () {
          setMessageInnerHTML("WebSocket连接成功");
      }

      //接收到消息的回调方法
      webSocket.onmessage = function (event) {
          var message = $("#message").html();
          var obj =JSON.parse(event.data);
          if(obj.id ==="1"){
              alert("判断成功")
              setMessageInnerHTML(obj.message+"<br/>");
              alert("1");
              setMessageInnerHTML(obj.message+"<br/>");
              alert("2");
              setMessageInnerHTML(obj.id+"<br/>");
          }
          alert("3");
          setMessageInnerHTML(obj.message+"<br/>");
          setMessageInnerHTML(obj.id+"<br/>");

          alert("4");
      }

      //连接关闭的回调方法
      webSocket.onclose = function () {
          setMessageInnerHTML("WebSocket连接关闭");
      }

      //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
      window.onbeforeunload = function () {
          closeWebSocket();
      }

      //将消息显示在网页上
      function setMessageInnerHTML(innerHTML) {
          $("#message").html(innerHTML+"<br/>")
      }

      //关闭WebSocket连接
      function closeWebSocket() {
          webSocket.close();
      }

      //发送消息
      function send() {
          var browser = myBrowser()
          var message = $("#sendContent").val();
          webSocket.send(browser+":   "+message);
      }

  </script>




  </body>
</html>
