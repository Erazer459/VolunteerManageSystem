<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/2/24
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="<%=basePath%>/student/css/upDatePassword.css" type="text/css">
</head>
<body>
<script type="text/javascript">
    function checkpassword() {
        var password = document.getElementById("password1").value;
        var repassword = document.getElementById("password2").value;
        if(password == repassword) {
            document.getElementById("tishi").innerHTML="<br><font color='green'>两次密码输入一致</font>";
            document.getElementById("submit").disabled = false;

        }else {
            document.getElementById("tishi").innerHTML="<br><font color='red'>两次输入密码不一致!</font>";
            document.getElementById("submit").disabled = true;
        }
    }
    function check(form){
        if(form.password1.value==""){
            alert("请输入新密码");
            form.password1.focus();
            return false;
        }if(form.password2.value==""){
            alert("请再次输入登录密码");
            form.password2.focus();
            return false;
        }
        return true;
    }
</script>
<form method="post" action="${pageContext.request.contextPath}/upDatePasswordServlet" onsubmit="return check(this)">
    <label for="password1">新密码：</label>
    <input type="hidden" value="${id}" name="id" class="id">
    <input type="password" class="text" placeholder="请输入新密码" id="password1" name="password1">
    <input type="password" class="text" placeholder="请再次输入新密码" id="password2" name="password2" onkeyup="checkpassword()">
    <div>
    <span id="tishi"></span></input>
    </div>
    <input type="submit" class="submit" value="确认" style="width: 45%">
    <input type="button" class="submit" value="返回" onclick="JavaScript:history.go(-1)" style="width:45%;">
</form>
</body>
</html>
