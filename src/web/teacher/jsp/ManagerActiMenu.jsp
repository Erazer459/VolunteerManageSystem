
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>活动管理</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="<%=basePath%>/teacher/css/ManagerActiMenu.css" type="text/css">
</head>
<body>
<form>
    <h2>志愿活动管理</h2>
    <input type="button" class="submit" value="活动审批" onclick="window.location.href='${pageContext.request.contextPath}/FindAllUnkownActiServlet'">
    <input type="button" class="submit" value="活动列表" onclick="window.location.href='${pageContext.request.contextPath}/findActiByPageServlet'">
    <input type="button" class="submit" value="返回主菜单" onclick="javascript:window.location.href='${pageContext.request.contextPath}/teacher/jsp/managerMenu.jsp'">
</form>
</body>
</html>
