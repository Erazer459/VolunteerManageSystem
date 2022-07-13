<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/2/25
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布活动</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="<%=basePath%>/student/css/publishActi.css" type="text/css">
</head>
<body>
<script type="text/javascript">
    function check(form){
        if(form.title.value==""){
            alert("请输入活动主题");
            form.title.focus();
            return false;
        }if(form.place.value==""){
            alert("请输入活动举行地点");
            form.place.focus();
            return false;
        }if(form.peopleLimit.value==""){
            alert("请输入人数限制");
            form.peopleLimit.foucs();
            return false;
        }if(form.point.value==""){
            alert("请输入活动获得操行分");
            form.point.foucs();
            return false;
        }if(form.content.value==""){
            alert("请输入活动描述");
            form.content.foucs();
            return false;
        }if(form.time.value==""){
            alert("请输入活动举行时间");
            form.time.foucs();
            return false;
        }
        return true;
    }
</script>
<form method="post" action="${pageContext.request.contextPath}/publishActiServlet" onsubmit="return check(this)">
    <h2>发布志愿活动</h2>
    <label for="title"> 输入活动主题：</label>
    <input type="text" class="title" name="title" id="title" onkeyup="this.value=this.value.replace(/[, ]/g,'')">
    <div>
    请输入活动举行时间：<input type="datetime-local" class="time" name="time" id="time">
    </div>
    发起单位：<input type="radio" value="person" name="type" checked>个人<input type="radio" value="class" name="type" onkeyup="this.value=this.value.replace(/[, ]/g,'')">班级
    活动举行地点：<input type="text" name="place" id="place" class="title" onkeyup="this.value=this.value.replace(/[, ]/g,'')">
    人数限制:<input type="text" name="peopleLimit" class="title" input onkeyup="this.value=this.value.replace(/[^\d.]/g,'')">
    活动可获得的操行分：<input type="text" name="point" class="title" id="point" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')">
    <label for="content">活动描述：</label>
    <div class="area">
        <textarea name="content" rows="15" cols="80" id="content" class="content" minlength="1" maxlength="500" onkeyup="this.value=this.value.replace(/[, ]/g,'')"></textarea>
    </div>
    <input type="submit" class="submit" value="提交" style="width: 45%">
    <input type="button" class="submit" value="返回活动管理" onclick="javascript:window.location.href='${pageContext.request.contextPath}/student/jsp/ActiMenu.jsp'" style="width: 45%">
</form>
</body>
</html>
