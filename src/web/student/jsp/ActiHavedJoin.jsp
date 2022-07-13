<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>活动列表</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="<%=basePath%>/student/css/ActiHavedjoin.css" type="text/css">
</head>
<body>
<script>
    function workcheck(){
        alert("考勤成功!");
    }
</script>
<input type="button" class="submit" value="返回" onclick="window.location.href='${pageContext.request.contextPath}/student/jsp/ActiMenu.jsp'">
<table>
    <tr>
        <th colspan="10">已报名参加的活动</th>
    </tr>
    <tr>
        <th>活动主题</th>
        <th>活动发起者</th>
        <th>活动举行时间</th>
        <th>活动举行地点</th>
        <th>活动人数上限</th>
        <th>活动报名人数</th>
        <th>活动状态</th>
        <th>考勤状态</th>
        <th colspan="2">操作</th>
    </tr>
    <c:forEach items="${pb.list}" var="activiti">

        <tr>
            <td>${activiti.title}</td>
            <td>${activiti.host}</td>
            <td>${activiti.time}</td>
            <td>${activiti.place}</td>
            <td>${activiti.peopleLimit}</td>
            <td>${activiti.numofPeople}</td>
            <td>${activiti.state}</td>
            <td>${activiti.workCheck}</td>
            <c:choose>
            <c:when test="${activiti.workCheck=='unCheck'}">
                <td><input type="button" class="submit" value="未开始考勤" onclick="window.location.href='${pageContext.request.contextPath}/'" disabled></td>
            </c:when>
            <c:otherwise>
                <td><input  type="button" class="submit" value="点击考勤" onclick="workcheck();window.location.href='${pageContext.request.contextPath}/stuWorkCheckServlet?actiId=${activiti.id}';" id="btn"></td>
            </c:otherwise>
            </c:choose>
            <td><input type="button" class="submit" value="查看详情" onclick="window.location.href='${pageContext.request.contextPath}/FindActiByIdServlet?uri=checkActi.jsp&id=${activiti.id}'"></td>
        </tr>

    </c:forEach>
</table>
<div class="div1">
    <ul>
        <c:forEach begin="1" end="${pb.totalPage}" var="i">
            <li><a href="${pageContext.request.contextPath}/findActiHavedJoinServlet?currentPage=${i}&rows=5">${i}</a></li>
        </c:forEach>
        <span style="font-size:23px;margin-left:0px;" class="span_1">
        共${pb.totalCount}条记录，共${pb.totalPage}页
    </span>
    </ul>
</div>
</body>
</html>
