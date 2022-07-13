
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员主菜单</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="<%=basePath%>/teacher/css/managerMenu.css" type="text/css">
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
    <h2>管理员主菜单</h2>
<input type="button" value="管理学生信息" class="submit" onclick="window.location.href='${pageContext.request.contextPath}/FindStuByPageServlet'">
    <input type="button" value="管理公告信息" class="submit" onclick="window.location.href='${pageContext.request.contextPath}/ShowAncmServlet'">
    <input type="button" value="管理活动" class="submit" onclick="window.location.href='${pageContext.request.contextPath}/teacher/jsp/ManagerActiMenu.jsp'">
    <input type="button" value="登出" class="submit" onclick="javascript:logoutCheck()">
</form>
</body>
</html>
