<%--
  Created by IntelliJ IDEA.
  User: Think
  Date: 2016/10/19
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>登陆</title>
	<style type="text/css">
		.log{
			width:300px;
			height:300px;
			margin-left: 300px;
			margin-top: 200px;
			border: 1px;
			border-color: cadetblue;
		}

	</style>
</head>
<body>
	<div class="log">
	<form action  ="tlogin">
		<li>用户名<input type="text" name="id" value=""></li>
		<li>密码<input type="text" value=""></li>
		<input type="submit" value="登陆">
	</form>
	</div>
</body>
</html>
