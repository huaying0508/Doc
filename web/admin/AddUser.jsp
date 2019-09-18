<%--
  Created by IntelliJ IDEA.
  User: hua
  Date: 2019/8/28
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>添加用户</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script src="${pageContext.request.contextPath}/admin/js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/AddUCheck.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>添加用户</legend>
</fieldset>
<!--<form class="layui-form layui-form-pane" action="" >-->
<form class="layui-form layui-form-pane" style="left:25%;position: relative;" enctype="multipart/form-data">

    <%--    头像--%>
    <div class="layui-form-item">
        <label class="layui-form-label">头像</label>
        <div class="layui-input-inline">
            <input name="uploadImage" type="file" style="height: 35px;">
        </div>
    </div>

    <span id="ename_msg"></span>
    <%--    用户名--%>
    <div class="layui-form-item" align="center">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-inline">
            <input name="user.uname" id="uname" class="layui-input" type="text" placeholder="请输入" autocomplete="off"
            >
        </div>
    </div>
    <%--    姓名--%>
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-inline">
            <input name="user.username" class="layui-input" type="text" placeholder="请输入" autocomplete="off"
            >
        </div>
    </div>
    <%--    密码--%>
    <span id="epwd_msg"></span>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input name="user.upwd" id="upwd" class="layui-input" type="password" placeholder="请输入" autocomplete="off"
            >
        </div>
    </div>

    <%--    确认密码--%>
    <span id="repwd_msg"></span>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input id="reupwd" class="layui-input" type="password" placeholder="请输入" autocomplete="off"
            >
        </div>
    </div>

    <%--    性别--%>
    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input name="user.usex" title="男" type="radio" checked="" value="男">
            <input name="user.usex" title="女" type="radio" value="女">
        </div>
    </div>
    <%--    学历--%>
    <div class="layui-form-item">
        <label class="layui-form-label">学历</label>
        <div class="layui-input-inline">
            <select name="user.eduno">
                <option value="">请选择学历</option>
                <option value="1" selected="">小学</option>
                <option value="2">中学</option>
                <option value="3">高中</option>
                <option value="4">大专</option>
                <option value="5">本科</option>
                <option value="6">博士</option>
                <option value="7">硕士</option>
            </select>
        </div>
    </div>

    <%--    职业--%>
    <div class="layui-form-item">
        <label class="layui-form-label">职业</label>
        <div class="layui-input-inline">
            <select name="user.posno">
                <option value="">请选择职业</option>
                <option value="1" selected="">软件工程师</option>
                <option value="2">导游</option>
                <option value="3">教师</option>
                <option value="4">军人</option>
                <option value="5">建筑师</option>
                <option value="6">学生</option>
                <option value="7">美容师</option>
                <option value="8">白领</option>
            </select>
        </div>
    </div>
    <%--    手机号--%>
    <span id="etel_msg"></span>
    <div class="layui-form-item">
        <label class="layui-form-label">手机号码</label>
        <div class="layui-input-inline">
            <input name="user.utel" id="utel" class="layui-input" type="tel" placeholder="请输入" autocomplete="off"
            >
        </div>
    </div>
    <%--    邮箱--%>
    <span id="email_msg"></span>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-inline">
            <input name="user.uemail" id="uemail" class="layui-input" type="email" placeholder="请输入" autocomplete="off"
            >
        </div>
    </div>


    <div class="layui-form-item">
        <button class="layui-btn" lay-filter="demo2" lay-submit="">提交</button>
        <button class="layui-btn">返回</button>
    </div>
</form>
<script src="${pageContext.request.contextPath}/admin/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });

        // 创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        // 自定义验证规则
        // form.verify({
        //     title: function (value) {
        //         if (value.length < 5) {
        //             return '标题至少得5个字符啊';
        //         }
        //     }
        //     , pass: [
        //         /^[\S]{6,12}$/
        //         , '密码必须6到12位，且不能出现空格'
        //     ]
        //     , content: function (value) {
        //         layedit.sync(editIndex);
        //     }
        // });


        //检测用户名

        $("#uname").blur(function () {
            var uname = $("#uname").val();

            $.post("${pageContext.request.contextPath}/test/login!CheckName.action", {
                "uname": uname
            }, function (data) {
                if (data.checkmsg == "success") {
                    $("#ename_msg").text("该用户名已注册").removeClass("error_msg");
                } else {
                    $("#ename_msg").text("该用户名可用").removeClass("error_msg");
                }
            });
            return false;
        });


        //监听提交
        form.on('submit(demo2)', function (data) {
            // layer.alert(JSON.stringify(data.field), {
            //     title: '最终的提交信息'
            // })

            $.ajax({
                async: true,
                url: "${pageContext.request.contextPath}/user/UserM!AddUser.action",
                type: "POST",
                dataType: "json",
                data: data.field,
                success: function (redate) {

                    alert(redate.addmsg);

                    if ("success" == redate.addmsg) {
                        layer.msg("注册成功");
                        window.location.href = "${pageContext.request.contextPath}/user/UserM!findByUser.action";
                    } else {
                        layer.msg("注册失败");
                        // window.location.href = "admin/login.jsp";
                    }

                },
                error: function () {
                    layer.msg("服务器崩溃，请求失败");
                }

            });
            return false;
        });

    });
</script>
</body>
</html>
