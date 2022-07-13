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
    <link rel="stylesheet" href="<%=basePath%>/student/css/stuCheckAncm.css" type="text/css">
</head>
<body>
<form>
    <h2>公告</h2>
    <label for="title"> 公告标题：</label>
    <input type="text" class="title" name="title" id="title" value="${ancm.title}" readonly>
    <label for="datetime">发布时间：</label>
    <input type="text" id="datetime" readonly value="${time}" class="time">
    <label for="content">公告内容：</label>
    <div class="area">
        <textarea  name="content" rows="15" cols="80" id="content" class="content" readonly >${ancm.content}</textarea>
    </div>
    <input type="button" value="返回" onclick="JavaScript:history.go(-1)" class="submit" style="width: 45%">
    <input type="button" class="submit" value="返回主菜单" onclick="javascript:window.location.href='${pageContext.request.contextPath}/student/jsp/studentMenu.jsp'" style="width: 45%">
</form>
</body>
</html>
