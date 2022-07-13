<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="<%=basePath%>/teacher/css/ActiApproval.css" type="text/css">
</head>
<body>
<input type="button" class="submit" value="返回" onclick="window.location.href='${pageContext.request.contextPath}/teacher/jsp/ManagerActiMenu.jsp'">
<table>
    <tr>
        <th colspan="4">审批志愿活动</th>
    </tr>
    <tr>
    <th>活动id</th>
        <th>活动发起者</th>
        <th>活动状态</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${ActiList}" var="activiti">
        <tr>
            <td>${activiti.id}</td>
            <td>${activiti.host}</td>
            <td>${activiti.pass}</td>
            <td><input type="button" class="submit" value="审核" onclick="window.location.href='${pageContext.request.contextPath}/FindActiByIdServlet?uri=Approval.jsp&id=${activiti.id}'"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
