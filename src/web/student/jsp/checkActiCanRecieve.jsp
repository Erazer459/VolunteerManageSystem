<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>审核活动</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="<%=basePath%>/student/css/checkActiCanRecieve.css" type="text/css">
</head>
<body>
<input type="button" class="submit" value="返回" onclick="window.location.href='${pageContext.request.contextPath}/student/jsp/ActiMenu.jsp'">
<table>
    <tr>
        <th colspan="8">报名参加活动</th>
    </tr>
    <tr>
        <th>活动主题</th>
        <th>活动发起者</th>
        <th>活动类型</th>
        <th>活动举行时间</th>
        <th>活动人数上限</th>
        <th>活动报名人数</th>
        <td colspan="2">操作</td>
    </tr>
    <c:forEach items="${pb.list}" var="activiti">

            <tr>
                <td>${activiti.title}</td>
                <td>${activiti.host}</td>
                <th>${activiti.type}</th>
                <td>${activiti.time}</td>
                <td>${activiti.peopleLimit}</td>
                <td>${activiti.numofPeople}</td>
                <td><input type="button" class="submit" value="报名参加" onclick="window.location.href='${pageContext.request.contextPath}/ApplicationServlet?id=${activiti.id}&num=${activiti.numofPeople}'"></td>
                <td><input type="button" class="submit" value="查看详情" onclick="window.location.href='${pageContext.request.contextPath}/FindActiByIdServlet?uri=checkActi.jsp&id=${activiti.id}'"></td>
            </tr>

    </c:forEach>
</table>
<div class="div1">
    <ul>
        <c:forEach begin="1" end="${pb.totalPage}" var="i">
            <li><a href="${pageContext.request.contextPath}/StufindActiByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
        </c:forEach>
        <span style="font-size:23px;margin-left:0px;" class="span_1">
        共${pb.totalCount}条记录，共${pb.totalPage}页
    </span>
    </ul>
</div>
</body>
</html>
