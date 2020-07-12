<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/7/9
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form action="/user/find" method="post">
    id:<input type="text" name="id"><br>
    用户名：<input type="text" name="userName"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="查询">&nbsp;
    <input type="reset" value="重置">
</form>

<form action="/user/del" method="post">
    <table border="1">
        <thead>
            <tr>
                <th><input type="checkbox" class="all"></th>
                <th>Id</th>
                <th>用户名</th>
                <th>密码</th>
                <th>创建时间</th>
                <th>修改时间</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="user">
                <tr>
                    <td><input type="checkbox" name="ids" value="${user.id}"></td>
                    <td>${user.id}</td>
                    <td>${user.userName}</td>
                    <td>${user.password}</td>
                    <td>${user.createTime}</td>
                    <td>${user.updateTime}</td>
                    <td>
                        <c:choose>
                            <c:when test="${user.status==1}">
                                在线
                            </c:when>
                            <c:when test="${user.status==0}">
                                离线
                            </c:when>
                        </c:choose>

                    </td>
                    <td>
                        <a href="/user/save?id=${user.id}">修改</a>
                        <a href="/user/del?ids=${user.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="8" align="center">
                <button type="submit">删除</button>
            </td>
        </tr>
        </tfoot>
    </table>

</form>
<script>
    let all=document.querySelector(".all");
    all.onchange=function () {
        let ids=document.querySelectorAll("tbody input[type=checkbox]");
        for (let id of ids){
            id.checked=all.checked;
        }
    }
</script>
<a href="/user/save">新增</a>
</body>
</html>
