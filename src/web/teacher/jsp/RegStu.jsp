<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <!-- 防止请求转发过后css样式丢失-->
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="<%=basePath%>/teacher/css/RegStu.css" type="text/css">
</head>
<body>
<script type="text/javascript">
    function check(form){
        let reg = /^1([0-9])\d{9}$/;
        let reg1 = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
        if(form.id.value==""){
        alert("请输入学生账号");
        form.id.focus();
        return false;
    }if(form.password.value==""){
        alert("请输入学生登录密码");
        form.password.focus();
        return false;
        }
        if(form.classname.value==""){
            alert("请输入学生班级");
            form.classname.focus();
            return false;
        } if(form.username.value==""){
            alert("请输入学生姓名");
            form.username.focus();
            return false;
        }if(!reg.test(form.phone.value)){
            alert("请输入正确的手机号")
            form.phone.focus();
            return false;
        }if(!reg1.test(form.email.value)){
            alert("请输入正确的邮箱账号")
            form.email.focus();
            return false;
        }
        return true;
    }
</script>
<form method="post" action="${pageContext.request.contextPath}/RegServlet" onsubmit="return check(this)">
    <h2>注册学生账号</h2>
    <label for="id">学生账号：</label><input type="text" placeholder="请设置学生账号" name="id" class="username" id="id" oninput="value=value.replace(/[^\d]/g,'');")
    >
    <strong>${msg}</strong>
    <label for="password">学生密码：</label><input type="text" placeholder="请设置密码" name="password" class="password" id="password" onkeyup="this.value=this.value.replace(/[, ]/g,'')"
    >
    <label for="classname">学生班级：</label><input type="text" placeholder="请设置学生班级" name="classname" class="classname" id="classname" onkeyup="this.value=this.value.replace(/[, ]/g,'')"
    >
    <label for="username">学生姓名：</label><input type="text" placeholder="请输入学生姓名" name="username" class="username" id="username" onkeyup="this.value=this.value.replace(/[, ]/g,'')"
    >
    <label for="phone">学生手机号：</label><input type="text" placeholder="请输入学生手机号" name="phone" class="username" id="phone" onkeyup="this.value=this.value.replace(/[, ]/g,'')"
>
    <label for="email">学生邮箱：</label><input type="email" placeholder="请输入学生邮箱" name="email" class="username" id="email" onkeyup="this.value=this.value.replace(/[, ]/g,'')"
    >
    <div>
    学生性别：<input type="radio" name="gender" value="男" checked>男<input type="radio" name="gender" value="女" style="margin-left: 40px">女
    </div>
    <input type="submit" value="注册" class="submit" id="submit" style="width: 45%" >
    <input type="button" class="submit"  value="返回"onclick="javascript:window.location.href='${pageContext.request.contextPath}/FindStuByPageServlet'" style="width: 45%">
    <strong>${msg}</strong>
</form>
</body>
</html>