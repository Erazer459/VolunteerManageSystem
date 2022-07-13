<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生管理页面</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="<%=basePath%>/teacher/css/CURDPage.css" type="text/css">
    <script>
function deleteStu(id){
    if (confirm("您确定要删除吗？")){
    location.href="${pageContext.request.contextPath}/delStuServlet?id="+id;
    }
}
function banStu(id){
    if(confirm("您确定要封禁该用户吗？")){
        location.href="${pageContext.request.contextPath}/BanStuServlet?id="+id;
    }
}
    </script>
</head>
<body>
<input type="button" class="back" value="返回主菜单" onclick="javascript:window.location.href='${pageContext.request.contextPath}/teacher/jsp/managerMenu.jsp'">
<div class="form1">
    <form action="${pageContext.request.contextPath}/FindStuByPageServlet" method="post">
        <div class="form2">
            <label for="inputid">学号：</label>
            <input type="text" class="search" id="inputid" name="id" value="${condition.id[0]}" oninput="value=value.replace(/[^\d]/g,'');">
        </div>
        <div class="form2">
            <label for="inputname">姓名：</label>
            <input type="text" class="search" id="inputname" name="username" value="${condition.username[0]}"onkeyup="this.value=this.value.replace(/[, ]/g,'')">
        </div>
        <div class="form2">
            <label for="inputgender1">性别：</label>
            <input type="radio" class="radio" id="inputgender1" value="男" name="gender" checked>男<input type="radio" class="radio" id="inputgender2" value="女" name="gender">女
        </div>
        <div class="form2">
            <label for="inputban2">状态：</label>
            <input type="radio" class="radio" id="inputban1" value="ban" name="ban">封禁<input type="radio" class="radio" id="inputban2" value="notban" checked name="ban">正常
        </div>
        <div class="form2">
            <label for="inputclassname">班级：</label>
            <input type="text" class="search" id="inputclassname" name="classname" value="${condition.classname[0]}" onkeyup="this.value=this.value.replace(/[, ]/g,'')">
        </div>
        <input type="submit" class="submit" value="查询" style="width: 45%">
        <input type="button" value="返回" onclick="JavaScript:history.go(-1)" class="submit" style="width: 45%">
    </form>
</div>
<table>
    <tr>
        <th colspan="9">学生信息管理</th>
        <th colspan="3"><input type="button" class="submit" value="添加学生" onclick="window.location.href='${pageContext.request.contextPath}/teacher/jsp/RegStu.jsp'"></th>
    </tr>
    <tr class="classtop">
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>班级</th>
        <th>迟到次数</th>
        <th>缺勤次数</th>
        <th>状态</th>
        <th>邮箱</th>
        <th>电话号码</th>
        <th colspan="3">操作</th>
    </tr>
   <c:forEach items="${pb.list}" var="student">
       <tr>
           <td>${student.id}</td>
           <td>${student.username}</td>
           <td>${student.gender}</td>
           <td>${student.classname}</td>
           <td>${student.latetimes}</td>
           <td>${student.absenttimes}</td>
           <td>${student.ban}</td>
           <td>${student.email}</td>
           <td>${student.phone}</td>
           <td><a href="javascript:deleteStu(${student.id});">删除</a></td>
           <td><a href="${pageContext.request.contextPath}/findStuServlet?id=${student.id}">修改</a></td>
           <td><a href="javascript:banStu(${student.id});">封禁</a></td>
       </tr>
   </c:forEach>

</table>
<div class="div1">
<ul>
<c:forEach begin="1" end="${pb.totalPage}" var="i">
    <li><a href="${pageContext.request.contextPath}/FindStuByPageServlet?currentPage=${i}&rows=5&username=${condition.username[0]}&id=${condition.id[0]}&classname=${condition.classname[0]}">${i}</a></li>
</c:forEach>
    <span style="font-size:23px;margin-left:0px;" class="span_1">
        共${pb.totalCount}条记录，共${pb.totalPage}页
    </span>
</ul>
</div>
</body>
</html>
