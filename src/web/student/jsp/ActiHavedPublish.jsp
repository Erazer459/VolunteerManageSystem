<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看已发布的内容</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="<%=basePath%>/student/css/ActiHavedPublish.css" type="text/css">
</head>
<body>
<input type="button" class="submit" value="返回" onclick="window.location.href='${pageContext.request.contextPath}/student/jsp/ActiMenu.jsp'">
<table>
    <tr>
        <th colspan="10">发布考勤</th>
    </tr>
    <tr>
        <th>活动主题</th>
        <th>活动举行时间</th>
        <th>活动举行地点</th>
        <th>活动人数上限</th>
        <th>活动报名人数</th>
        <th>活动状态</th>
        <th>考勤状态</th>
        <th colspan="3">操作</th>
    </tr>
    <c:forEach items="${pb.list}" var="activiti">

        <tr>
            <td>${activiti.title}</td>
            <td>${activiti.time}</td>
            <td>${activiti.place}</td>
            <td>${activiti.peopleLimit}</td>
            <td>${activiti.numofPeople}</td>
            <td>${activiti.state}</td>
            <td>${activiti.workCheck}</td>
            <c:choose>
                <c:when test="${activiti.workCheck=='unCheck'}">
                    <td><input type="button" class="submit" value="开始考勤" onclick="window.location.href='${pageContext.request.contextPath}/startworkCheckServlet?id=${activiti.id}'"></td>
                </c:when>
                <c:otherwise>
                    <td><input type="button" class="submit" value="结束考勤" onclick="window.location.href='${pageContext.request.contextPath}/stopWorkCheckServlet?id=${activiti.id}'"></td>
                </c:otherwise>
            </c:choose>
            <td><input type="button" class="submit" value="查看详情" onclick="window.location.href='${pageContext.request.contextPath}/FindActiByIdServlet?uri=checkActi.jsp&id=${activiti.id}'"></td>
            <td><input type="button" class="submit" value="查看考勤状况" onclick="window.location.href='${pageContext.request.contextPath}/workCheckConditionServlet?condition=${activiti.workCheck}&id=${activiti.id}'"></td>
        </tr>

    </c:forEach>
</table>
<div class="div1">
    <ul>
        <c:forEach begin="1" end="${pb.totalPage}" var="i">
            <li><a href="${pageContext.request.contextPath}/findActiHavedPublishServlet?currentPage=${i}&rows=5">${i}</a></li>
        </c:forEach>
        <span style="font-size:23px;margin-left:0px;" class="span_1">
        共${pb.totalCount}条记录，共${pb.totalPage}页
    </span>
    </ul>
</div>

</body>
</html>
