<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>公告栏</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="<%=basePath%>/teacher/css/CURDAncm.css" type="text/css">
</head>
<body>
<form>
    <c:forEach items="${ancm}" var="ancm" varStatus="s">
        <input type="hidden" value="${ancm.id}" name="id">
        <div>
        <span style="margin-top: 5px">
        <textarea rows="1" class="content" readonly >${ancm.title}</textarea>
        </span>
            <span>
        <input type="button" value="查看" class="submit" onclick="window.location.href='${pageContext.request.contextPath}/teacherFindAncmByIdServlet?id=${ancm.id}'">
        </span>
        </div>
    </c:forEach>
    <input type="button" value="返回" onclick="JavaScript:history.go(-1)" class="back" style="width: 30%">
    <input type="button" value="添加公告" style="width: 30%" onclick="javascript:window.location.href='${pageContext.request.contextPath}/teacher/jsp/ancm.jsp'" class="back">
    <input type="button" class="back" value="返回主菜单" onclick="javascript:window.location.href='${pageContext.request.contextPath}/teacher/jsp/managerMenu.jsp'" style="width: 30%">
</form>
</body>
</html>