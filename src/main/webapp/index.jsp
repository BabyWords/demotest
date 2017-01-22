<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="javascript" src="<%=path%>/static/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<form action="<%=path%>/user/login.do" id="logform" method="post">
    <input type="text" id="username"/>
    <input type="text" id="password"/>
    <button id="login">登陆</button>
</form>
</body>
</html>
