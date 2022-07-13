<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/3/1
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理考勤</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="<%=basePath%>/student/css/ActiWorkCheckCondition.css" type="text/css">
</head>
<body>
<input type="button" class="submit" value="返回" onclick="window.location.href='${pageContext.request.contextPath}/findActiHavedPublishServlet'">
<table>
    <tr>
        <th colspan="6">考勤管理</th>
    </tr>
    <tr>
        <th>参加者id</th>
        <th>参加者姓名</th>
        <th>参加者考勤状况</th>
        <th colspan="3">操作</th>
    </tr>
    <c:forEach items="${pb.list}" var="stu">
    <c:choose>
    <c:when test="${condition=='unCheck'}">
        <tr>
            <td>${stu.id}</td>
            <td>${stu.username}</td>
            <td>${stu.workCheck}</td>
            <c:choose>
                <c:when test="${stu.workCheck=='未考勤'}">
                    <td><input type="button" class="submit" value="迟到" onclick="window.location.href='${pageContext.request.contextPath}/'" disabled></td>
                    <td><input type="button" class="submit" value="缺勤" onclick="window.location.href='${pageContext.request.contextPath}/'" disabled></td>
                    <td><input type="button" class="submit" value="请假" onclick="window.location.href='${pageContext.request.contextPath}/'" disabled></td>
                </c:when>
                <c:otherwise>
                    <td colspan="3">${stu.workCheck}</td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:when>
        <c:otherwise>
            <tr>
                <td>${stu.id}</td>
                <td>${stu.username}</td>
                <td>${stu.workCheck}</td>
                <c:choose>
                    <c:when test="${stu.workCheck=='未考勤'}">
                        <td><input type="button" class="submit" value="迟到" onclick="window.location.href='${pageContext.request.contextPath}/dealUncheckStuServlet?userid=${stu.id}&condition=${condition}&type=迟到&id=${id}&actiId=${actiId}'" ></td>
                        <td><input type="button" class="submit" value="缺勤" onclick="window.location.href='${pageContext.request.contextPath}/dealUncheckStuServlet?userid=${stu.id}&condition=${condition}&type=缺勤&id=${id}&actiId=${actiId}'" ></td>
                        <td><input type="button" class="submit" value="请假" onclick="window.location.href='${pageContext.request.contextPath}/dealUncheckStuServlet?userid=${stu.id}&condition=${condition}&type=请假&id=${id}&actiId=${actiId}'" ></td>
                    </c:when>
                    <c:otherwise>
                        <td colspan="3">${stu.workCheck}</td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:otherwise>
    </c:choose>
    </c:forEach>
</table>
<div class="div1">
    <ul>
        <c:forEach begin="1" end="${pb.totalPage}" var="i">
            <li><a href="${pageContext.request.contextPath}/workCheckConditionServlet?condition=${condition}&id=${id}&currentPage=${i}&rows=5">${i}</a></li>
        </c:forEach>
        <span style="font-size:23px;margin-left:0px;" class="span_1">
        共${pb.totalCount}条记录，共${pb.totalPage}页
    </span>
    </ul>
</div>
</body>
</html>
