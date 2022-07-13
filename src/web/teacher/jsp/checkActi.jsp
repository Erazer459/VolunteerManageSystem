<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/2/27
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看活动详情</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="<%=basePath%>/teacher/css/checkActi.css" type="text/css">
</head>
<body>
<form>
<h2>活动信息</h2>
<label for="title"> 活动主题：</label>
<input type="text" class="title" name="title" id="title" readonly value="${activiti.title}">
<div>
    活动举行时间：<input type="text" class="title" name="time" id="time" readonly value="${time}">
</div>
发起单位：<input type="text" class="title" value="${activiti.type}" readonly>
活动举行地点：<input type="text" name="place" id="place" class="title" value="${activiti.place}" readonly>
人数限制:<input type="text" name="peopleLimit" class="title" readonly value="${activiti.peopleLimit}">
    已报名人数：<input type="text" class="title" name="numofPeople" readonly value="${activiti.numofPeople}">
活动可获得的操行分：<input type="text" name="point" class="title" id="point" readonly value="${activiti.point}">
<label for="content">活动描述：</label>
<div class="area">
    <textarea name="content" rows="15" cols="80" id="content" class="content" minlength="1" maxlength="500" readonly>${activiti.content}</textarea>
</div>
    <input type="button" value="返回" onclick="JavaScript:history.go(-1)" class="submit" style="width: 90%">
</form>
</body>
</html>
