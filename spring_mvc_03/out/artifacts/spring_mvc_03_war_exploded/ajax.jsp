<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/2/15
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script>
        var list = new Array();
        list.push({username:"郭亮",password:"guolaing"});
        list.push({username:"马蓓",password:"mabei"})
        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/user/quick12",
            data:JSON.stringify(list),
            contentType:"application/json;charset=utf-8"
        });
    </script>
</head>
<body>

</body>
</html>
