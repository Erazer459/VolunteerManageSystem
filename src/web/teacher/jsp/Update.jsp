<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生信息页面</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="<%=basePath%>/teacher/css/Update.css" type="text/css">
    <script>
        function goback(){
            if(window.history.back()!=null){
                window.history.back();
            }
            else{

            }
        }
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/updateStuServlet" method="post">
    <h2>修改学生信息</h2>
    <!-- 隐藏域提交id -->
    <input type="hidden" name="id" value="${student.id}">
    <label for="password">学生密码：</label><input type="text" placeholder="请设置密码" name="password" class="ccc" value="${student.password}" id="password" onkeyup="this.value=this.value.replace(/[, ]/g,'')"
>
    <label for="classname">学生班级：</label><input type="text" placeholder="请设置学生班级" name="classname" value="${student.classname}" class="ccc" id="classname" onkeyup="this.value=this.value.replace(/[, ]/g,'')"
>
    <label for="username">学生姓名：</label><input type="text" placeholder="请输入学生姓名" name="username" value="${student.username}" class="ccc" id="username" onkeyup="this.value=this.value.replace(/[, ]/g,'')"
>
    <label for="phone">学生手机号：</label><input type="text" placeholder="请输入学生手机号" name="phone" value="${student.phone}" class="ccc" id="phone" onkeyup="this.value=this.value.replace(/[, ]/g,'')"
>
    <label for="email">学生邮箱：</label><input type="email" placeholder="请输入学生邮箱" name="email" value="${student.email}" class="ccc" id="email" onkeyup="this.value=this.value.replace(/[, ]/g,'')"
>
    <div class="div1">
        <c:if test="${student.gender=='男'}">
    <span class="gen">学生性别:</span><input type="radio" name="gender" value="男" style="margin-left: 20px;" checked>男<input type="radio" name="gender" value="女" style="margin-left: 40px">女
        </c:if>
        <c:if test="${student.gender=='女'}">
    <span class="gen">学生性别:</span><input type="radio" name="gender" value="男" style="margin-left: 20px;" >男<input type="radio" name="gender" value="女" style="margin-left: 40px" checked>女
        </c:if>
    </div>
    <input type="reset" value="重置" class="button">
    <input type="submit" class="button" id="submit" value="修改">
    <input type="button" class="button" id="back" value="返回" onclick="goback()">
</form>
</body>
</html>
