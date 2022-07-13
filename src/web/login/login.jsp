<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <!-- 防止请求转发过后css样式丢失-->
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="<%=basePath%>/login/login.css" type="text/css">
</head>
<body>
<script type="text/javascript">
    function check(form){
        if(form.id.value==""){
            alert("请输入账号");
            form.id.focus();
            return false;
        }if(form.password.value==""){
            alert("请输入登录密码");
            form.password.focus();
            return false;
        }
        return true;
    }
</script>
<form method="post" action="${pageContext.request.contextPath}/loginServlet" onsubmit="return check(this)">
    <h2>登录</h2> 您的身份是：<input type="radio" name="usertype" value="manager">管理员<input type="radio" name="usertype" value="student" style="margin-left: 20px" checked>学生
    <input type="text" placeholder="请输入账号" name="id" class="id" id="id"οnkeyup="this.value=code.value.replace(/[^0-9]/g,'')"
    >
    <input type="password" placeholder="请输入密码" name="password" class="password" id="password"onkeyup="this.value=this.value.replace(/[, ]/g,'')"
    >
    <input type="submit" value="Log In" class="submit">
    <strong>${msg}</strong>
</form>
</body>
</html>