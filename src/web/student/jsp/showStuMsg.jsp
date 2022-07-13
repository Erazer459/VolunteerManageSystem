<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生个人信息</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="<%=basePath%>/student/css/showStuMsg.css" type="text/css">
</head>
<body>
<script>
    function check(form){
        if(form.email.value==""){
            alert("请输入邮箱");
            form.email.focus();
            return false;
        }if(form.phone.value==""){
            alert("请输入手机号");
            form.phone.focus();
            return false;
        }
        return true;
    }
</script>
<form method="post" action="${pageContext.request.contextPath}/stuUpdateServlet" onsubmit="return check(this)">
    <h2>个人信息</h2>
    <label>学号：</label>
    <input type="text" readonly value="${student.id}" class="text" name="id" id="id">
    <label for="username">姓名：</label>
<input type="text" readonly value="${student.username}" class="text" name="username" id="username">
    <div style="margin-bottom: 10px">
    <c:if test="${student.gender=='男'}">
        <span class="gen">性别:</span><input type="radio" name="gender" value="男" style="margin-left: 20px;" checked>男<input type="radio" name="gender" value="女" style="margin-left: 40px">女
    </c:if>
    <c:if test="${student.gender=='女'}">
        <span class="gen">性别:</span><input type="radio" name="gender" value="男" style="margin-left: 20px;" >男<input type="radio" name="gender" value="女" style="margin-left: 40px" checked>女
    </c:if>
    </div>
    <label for="classname">班级：</label>
    <input type="text" value="${student.classname}" name="classname" id="classname" class="text" readonly>
    <label for="phone">手机号：</label>
    <input type="text" value="${student.phone}" name="phone" id="phone" class="text" oninput="value=value.replace(/[^\d]/g,'');">
    <label for="email">邮箱地址：</label>
    <input type="email" value="${student.email}" name="email" id="email" class="text" onkeyup="this.value=this.value.replace(/[, ]/g,'')">
    <input type="text" class="submit" style="width: 30%" value="修改密码" onclick="javascript:window.location.href='${pageContext.request.contextPath}/passId?id=${student.id}'">
    <input type="submit" class="submit" style="width: 30%" value="修改个人信息">
    <input type="button" class="submit" style="width: 30%" value="返回菜单"onclick="javascript:window.location.href='${pageContext.request.contextPath}/student/jsp/studentMenu.jsp'" style="width: 30%">
</form>
</body>
</html>
