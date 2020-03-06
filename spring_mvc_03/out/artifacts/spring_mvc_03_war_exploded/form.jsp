<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/2/15
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/quick11" method="post">
    <input type="text" name="list[0].username" ><br/>
    <input type="text" name="list[0].password" ><br/>
    <input type="text" name="list[1].username" ><br/>
    <input type="text" name="list[1].password" ><br/>
    <input type="submit" value="提交">
</form>

</body>
</html>
