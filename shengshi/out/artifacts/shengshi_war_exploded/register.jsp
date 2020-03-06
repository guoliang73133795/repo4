
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {
            // 发送异步请求获取省份列表
            $.get("ProvinceServlet2",{},function (data) {
                //  [{"province":"湖南省"},{},{}]
                if (data) {
                    var str = '<option value="">--请选择--</option>';
                    for (var i = 0; i < data.length; i++) {
                        var p = data[i]; // {"province":"湖南省"}
                        str += '<option value="">'+p.province+'</option>';
                    }
                    $("#address").html(str);
                }
            },"json");

            // 给省份设置改变事件，当选择的省份改变后，执行回调函数
            $("#address").change(function () {
                // 获取当前被选中的省份名称
                var province = $("#address option:selected").html();
                // 发送异步请求获取省份对应的城市信息。
                $.get("CityServlet",{"province":province},function (data) {
                    if (data) {
                        var str = '<option value="">--请选择--</option>';
                        for (var i = 0; i < data.length; i++) {
                            var p = data[i]; // {"province":"湖南省"}
                            str += '<option value="">'+p.city+'</option>';
                        }
                        $("#city").html(str);
                    }
                },"json");
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
