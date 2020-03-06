
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script>
       $(function () {
           $.get("ProvinceServlet",{},function (data) {
               if (data){
                   var str = '<option value="">--请选择--</option>';
                   for(var i = 0; i < data.length;i++){
                       var p = data[i];
                       str += '<option value="">'+p.province+'</option>'
                   }
                   $("#address").html(str);
               }
           },"json");
           $("#address").change(function () {
               var province = $("#address option:selected").html();
               $.get("CityServlet",{province:province},function (data) {
                   if(data){
                       var str = '<option value="">--请选择--</option>';
                       for(var j = 0;j < data.length;j++){
                           var c = data[j];
                           str += '<option value="">'+c.city+'</option>'
                       }
                       $("#city").html(str);
                   }
               },"json")
           });
       });
    </script>
</head>
<body>
<h1>用户注册</h1>
用户名 ：<input type="text" id="username" name="username"/> <br>
密码 ：<input type="text" id="password" name="password"/> <br>
籍贯：
省份：<select name="address" id="address">
    <option value="">--请选择--</option>
    <option value="">湖南</option>
    <option value="">湖北</option>
    <option value="">广东</option>
    <option value="">广西</option>
</select>
城市：<select id="city" name="city">
    <option value="">--请选择--</option>
</select>
<br>
<input type="button" value="注册"/>

</body></body>
</html>
