<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/2/25
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生活动管理</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="<%=basePath%>/student/css/ActiMenu.css" type="text/css">
</head>
<body>
<form>
    <h2>活动管理</h2>
<input type="button"  value="查看可承接活动" class="submit" onclick="window.location.href='${pageContext.request.contextPath}/StufindActiByPageServlet'">
<input type="button" value="查看已承接活动" class="submit" onclick="window.location.href='${pageContext.request.contextPath}/findActiHavedJoinServlet'">
    <input type="button" value="发布活动" class="submit" onclick="window.location.href='${pageContext.request.contextPath}/student/jsp/publishActi.jsp'">
    <input type="button" value="查看已发布的活动" class="submit" onclick="window.location.href='${pageContext.request.contextPath}/findActiHavedPublishServlet'">
    <input type="button" value="返回主菜单" class="submit" onclick="window.location.href='${pageContext.request.contextPath}/student/jsp/studentMenu.jsp'">
</form>
</body>
</html>
