<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/2/16
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<form action="${pageContext.request.contextPath}/user/quick21" method="post" enctype="multipart/form-data">
    名称<input type="text" name="username"><br/>
    文件1:<input type="file" multiple="multiple" name="upload"><br/>
    文件2:<input type="file" multiple="multiple" name="upload"><br/>
    <input type="submit" name="提交">
</form>
<body>
</body>
</html>
