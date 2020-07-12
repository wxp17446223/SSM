<%@ page import="cn.com.bean.StatusEnum" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/6/26
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script >
        if(${not empty msg}) {
            alert('${msg}');
        }
    </script>
</head>
<body>
<form action="/user/save" method="post">
    <input type="hidden" name="id" value="${user.id}">
    用户名：<input type="text" name="userName" value="${user.userName}"><br>
    密码：<input type="password" name="password" value="${user.password}"><br>
    <input type="radio" name="status" value="1">在线 &nbsp;
    <input type="radio" name="status" value="0">离线<br>
    <input type="submit" value="${empty user?'新增':'修改' }">&nbsp;
    <input type="reset" value="重置">
</form>
</body>
</html>
