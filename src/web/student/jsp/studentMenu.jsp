<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/2/22
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生主菜单</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="<%=basePath%>/student/css/studentMenu.css" type="text/css">
</head>
<body>
<script>
    function logoutCheck(){
        if (confirm("您确定要登出吗？")){
            location.href="${pageContext.request.contextPath}/logOutServlet";
        }
    }
</script>
<form>
    <h2>学生主菜单</h2>
    <input type="button" value="查看公告" class="submit" onclick="window.location.href='${pageContext.request.contextPath}/checkAncmServlet'">
    <input type="button" value="查看个人信息" class="submit" onclick="window.location.href='${pageContext.request.contextPath}/showStuMsgServlet'">
    <input type="button" value="活动管理" class="submit" onclick="window.location.href='${pageContext.request.contextPath}/student/jsp/ActiMenu.jsp'">
    <input type="button" value="登出" class="submit" onclick="javascript:logoutCheck()">
</form>
</body>
</html>
