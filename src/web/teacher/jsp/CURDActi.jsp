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
    <link rel="stylesheet" href="<%=basePath%>/teacher/css/CURDActi.css" type="text/css">
</head>
<body>
<script>
    function deleteActi(id){
        if (confirm("您确定要删除吗？")){
            location.href="${pageContext.request.contextPath}/delActiServlet?id="+id;
        }
    }
</script>
<input type="button" class="submit" value="返回" onclick="window.location.href='${pageContext.request.contextPath}/teacher/jsp/ManagerActiMenu.jsp'">
<div class="form1">
    <form action="${pageContext.request.contextPath}/findActiByPageServlet" method="post">
        <div class="form2">
            <label for="title">标题关键字：</label>
            <input type="text" class="search" id="title" name="title" value="${condition.title[0]}" onkeyup="this.value=this.value.replace(/[, ]/g,'')">
        </div>
        <div class="form2">
            <label for="inputname">发起者姓名：</label>
            <input type="text" class="search" id="inputname" name="host" value="${condition.host[0]}" onkeyup="this.value=this.value.replace(/[, ]/g,'')">
        </div>
        <div class="form2">
            <label for="pass">审核状态:</label>
            <select name="pass" id="pass">
                <option value="passed">已审核</option>
                <option value="unknown">未审核</option>
            </select>
        </div>
        <div class="form2">
            <label for="type2">发布单位：</label>
            <input type="radio" class="radio" id="type1" value="class" name="type">班级<input type="radio" class="radio" id="type2" value="person" checked name="type">个人
        </div>
        <div class="form2">
            <label for="inputpeopleLimit">人数限制：</label>
            <input type="text" class="search" id="inputpeopleLimit" name="peopleLimit" value="${condition.peopleLimit[0]}" oninput="value=value.replace(/[^\d]/g,'');">
        </div>
        <div class="form2">
            <label for="inputplace">举办地点：</label>
            <input type="text" class="search" id="inputplace" name="place" value="${condition.place[0]}" onkeyup="this.value=this.value.replace(/[, ]/g,'')">
        </div>
        <div class="form2">
            <label for="time">举办时间：</label>
            <input type="date" class="search" id="time" name="time" value="${condition.time[0]}">
        </div>
        <input type="submit" class="submit" value="查询" style="width: 30%">
        <input type="button" value="返回" onclick="JavaScript:history.go(-1)" class="submit" style="width: 30%">
        <input type="button" class="submit" value="重置" onclick="window.location.href='${pageContext.request.contextPath}/findActiByPageServlet'" style="width: 30%">
    </form>
</div>
<table>
<tr>
   <th colspan="7">管理志愿活动信息</th>
    <th colspan="2"><input type="button" class="submit" value="添加活动" onclick="window.location.href='${pageContext.request.contextPath}/teacher/jsp/ManagerAddActi.jsp'"></th>
</tr>
<tr>
    <th>活动id</th>
    <th>活动主题</th>
    <th>活动发起者</th>
    <th>活动举行时间</th>
    <th>活动人数上限</th>
    <th>活动报名人数</th>
    <th>审核状态</th>
    <td colspan="2">操作</td>
</tr>
<c:forEach items="${pb.list}" var="activiti">
    <tr>
        <td>${activiti.id}</td>
        <td>${activiti.title}</td>
        <td>${activiti.host}</td>
        <td>${activiti.time}</td>
        <td>${activiti.peopleLimit}</td>
        <td>${activiti.numofPeople}</td>
        <td>${activiti.pass}</td>
        <td><input type="button" class="submit" value="删除" onclick="javascript:deleteActi(${activiti.id});"></td>
        <td><input type="button" class="submit" value="查看详情" onclick="window.location.href='${pageContext.request.contextPath}/FindActiByIdServlet?uri=checkActi.jsp&id=${activiti.id}'"></td>
    </tr>
</c:forEach>
</table>
<div class="div1">
    <ul>
        <c:forEach begin="1" end="${pb.totalPage}" var="i">
            <li><a href="${pageContext.request.contextPath}/findActiByPageServlet?currentPage=${i}&rows=5&time=${condition.time[0]}&peopleLimit=${peopleLimit.id[0]}&host=${condition.host[0]}&type=${condition.type[0]}&title=${condition.title[0]}&place=${condition.place[0]}&pass=${condition.pass[0]}">${i}</a></li>
        </c:forEach>
        <span style="font-size:23px;margin-left:0px;" class="span_1">
        共${pb.totalCount}条记录，共${pb.totalPage}页
    </span>
    </ul>
</div>
</body>
</html>
