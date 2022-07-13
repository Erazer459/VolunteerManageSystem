<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- 防止请求转发过后css样式丢失-->
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="<%=basePath%>/teacher/css/ancm.css" type="text/css">

</head>
<body>
<script>
    function deleteAncm(id){
        if (confirm("您确定要删除吗？")){
            location.href="${pageContext.request.contextPath}/DelAncmByIdServlet?id="+id;
        }
    }
    function check(form){
        if (form.title.value==""){
            alert("请输入公告标题");
            form.title.focus();
            return false;
        }
        if(form.content.value==""){
            alert("请输入公告内容");
            form.content.focus();
            return false;
        }
        return true;
    }
</script>
<form method="post" action="${pageContext.request.contextPath}/UpDateAncmServlet" onsubmit="return check(this)">
    <input type="hidden" value="${ancm.id}" name="id">
    <h2>修改公告</h2>
    <label for="title"> 公告标题：</label>
    <input type="text" class="title" name="title" id="title" value="${ancm.title}" onkeyup="this.value=this.value.replace(/[, ]/g,'')">
    <label for="content">公告内容：</label>
    <div class="area">
        <textarea name="content" rows="15" cols="80" id="content" class="content" minlength="1" maxlength="500" onkeyup="this.value=this.value.replace(/[, ]/g,'')">${ancm.content}</textarea>
    </div>
    <input type="submit" class="submit" value="修改" style="width: 30%" >
    <input type="button" class="submit" value="删除" style="width: 30%" onclick="javascript:window.location.href='javascript:deleteAncm(${ancm.id});'">
    <input type="button" class="submit" value="返回公告管理" onclick="javascript:window.location.href='${pageContext.request.contextPath}/ShowAncmServlet'" style="width: 30%">
</form>
</body>
</html>
