<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/2/21
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>封禁页面</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="<%=basePath%>/teacher/css/ban.css" type="text/css">
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/BanServlet">
    <h2>封禁账号</h2>
    <label for="id">账号：</label>
        <input type="text" value="${student.id}${id}" name="id" placeholder="请输入您要封禁的账号" id="id" class="id">
   <div>
    <label for="type">封禁类型:</label>
    <input type="radio" value="temp" name="type" checked id="type">暂时<input type="radio" value="forever" name="type" style="margin-left: 25px">永久
   </div>
    <div class="div_time">
   <label for="time">封禁至：</label>
    <input type="datetime-local" name="ban" id="time" class="time">
    </div>
<input type="submit" value="封禁" class="submit" style="width: 45%">
    <input type="button" value="返回" onclick="JavaScript:history.go(-1)" class="submit" style="width: 45%">
    <strong>${msg}</strong>
</form>
</body>
</html>
