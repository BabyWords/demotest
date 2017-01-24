<%--
  Created by IntelliJ IDEA.
  User: Gerry
  Date: 2017/1/10
  Time: 下午3:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>SpringMvcDemo</title>
    <script src="<%=path%>/static/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="<%=path%>/static/jquery/jquery-3.1.1.min.js" type="text/javascript"></script>
</head>
<body>
<link rel="stylesheet" href="<%=path%>/static/bootstrap/css/bootstrap.min.css"/>
<div class="container">
    <div class="col-md-4 col-md-offset-4">
        <form action="<%=basePath%>user/login" method="post" role="form">
            <div class="form-group">
                <label for="username" class="uname" data-icon="u"> 用户名 ：</label>
                <input id="username" name="username" required="required" type="text"
                       placeholder="请输入用户名" class="form-control"/><div id="result"></div>
            </div>
            <div class="form-group">
                <label for="password" class="youpasswd" data-icon="p"> 密 码 ：</label>
                <input id="password" name="password" required="required" type="password" placeholder="请输入密码" class="form-control"/>
            </div>
            <p class="login button">
                <input type="submit" value="登 录"/>
            </p>
        </form>
    </div>
</div>
    <script type="text/javascript">
        $("#username").focus()
        $("#username").blur(function(){
            debugger;
            $.ajax({
                type:"post",
                data:{"name":$("#username").val()},
                url:"<%=basePath%>user/userexists",
                success:function(result){
                    if(result=="1"){
                        $("#result").text("用户已存在")
                        $("#result").css("color","red")
                    }else{
                        $("#result").text("")
                    }
                }
            })
        })
    </script>
</body>
</html>