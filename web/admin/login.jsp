<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台登录-文档分享平台</title>
    <% String path = request.getContextPath();%>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/xadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/lib/layui/layui.js" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/admin/js/adLoginCheck.js" type="text/javascript"
            charset="UTF-8"></script>
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="login-bg">

<div class="login layui-anim layui-anim-up">
    <div class="message">文档分享管理登录</div>
    <div id="darkbannerwrap"></div>

    <form class="layui-form" method="post">
        <input name="admin.adname" id="adname" placeholder="用户名" type="text" class="layui-input">
        <hr class="hr15">
        <input name="admin.adpwd" id="adpwd" placeholder="密码" type="password" class="layui-input">
        <hr class="hr15">
        <input name="securityCode" placeholder="验证码" type="text" autocomplete="off" style="width: 190px;">
        <img src="Security/SecurityCodeImageAction" id="Verify" style="cursor:hand;" alt="看不清，换一张" width="116"
             height="36">
        <hr class="15">
        <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
        <%--        <input type="submit" id="sub_btn" value="登录" style="width: 100%;">--%>
        <hr class="hr20">
    </form>
</div>

<script>

    $(function () {

        $(function () {
            //点击图片更换验证码
            $("#Verify").click(function(){
                $(this).attr("src","${pageContext.request.contextPath}/Security/SecurityCodeImageAction?timestamp="+new Date().getTime());
            });
        });

        layui.use('form', function () {
            var form = layui.form;
            //监听提交
            form.on('submit(login)', function (data) {
                $.ajax({
                    async: true,
                    url: "test/login.action",
                    type: "POST",
                    dataType: "json",
                    data: data.field,
                    success: function (redata) {

                        // layer.msg(redata);
                        if ("success" == redata.info) {
                            layer.msg("登录成功");
                            window.location.href = "${pageContext.request.contextPath}/admin/index.jsp";
                        } else if ("fail" == redata.info) {
                            layer.msg("登陆失败");
                            window.location.href = "admin/login.jsp";
                        }
                        else if("codefail"== redata.info){
                            layer.msg("验证码错误");

                        }else {
                            layer.msg("账号无效，请先联系传一管理员");
                            window.location.href = "admin/login.jsp";
                        }
                    },
                    error: function () {
                        layer.msg("服务器崩溃，请求失败");
                    }
                })
                return false;
            })
        });
    });


</script>

</body>
</html>
