<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <title>用户查询</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <script src="${pageContext.request.contextPath}/admin/js/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/xadmin.css">
    <script src="${pageContext.request.contextPath}/admin/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/xadmin.js"></script>

</head>

<body>
<div class="x-nav">
            <span class="layui-breadcrumb">
                <a href="">首页</a>
                <a href="">演示</a>
                <a>
                    <cite>导航元素</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
    </a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <form class="layui-form layui-col-space5">
                        <div class="layui-inline layui-show-xs-block">
                            <input class="layui-input" autocomplete="off" placeholder="开始日" name="find.start"
                                   id="start">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <input class="layui-input" autocomplete="off" placeholder="截止日" name="find.end" id="end">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="find.username" placeholder="请输入用户名" autocomplete="off"
                                   class="layui-input"></div>
                        <div class="layui-inline layui-show-xs-block">
                            <button class="layui-btn" lay-submit="" lay-filter="sreach">
                                <i class="layui-icon">&#xe615;</i></button>
                        </div>
                    </form>
                </div>
                <div class="layui-card-body ">
                    <table class="layui-table">

                        <tr>

                            <th>ID</th>
                            <th>用户名</th>
                            <th>注册时间</th>
                            <th>积分</th>
                            <th>上传文档数</th>
                            <th>下载文档数</th>
                            <th>用户状态</th>
                            <th>操作</th>
                        </tr>


                        <c:forEach items="${ulist}" var="u" varStatus="s">


                            <c:if test="${not empty u}">
                                <tr>
                                    <td>${u.userno}</td>
                                    <td>${u.username}</td>
                                    <td>${u.uresdate}</td>
                                    <td>${u.intecont}</td>
                                    <td>${u.num}</td>
                                    <td>${u.downnum}</td>
                                    <td>${u.stname}</td>
                                    <td>
                                        <c:if test="${u.stname=='注册待审核'}">
                                            <button>审核通过</button>
                                        </c:if>
                                        <c:if test="${u.stname=='审核通过'}">
                                                <button>禁用</button>
                                        </c:if>
                                        <c:if test="${u.stname=='禁用'}">
                                            <button>启用</button>
                                        </c:if>
                                        <c:if test="${u.stname=='审核不通过'}">
                                            <label>不可操作</label>
                                        </c:if>
                                    </td>
                                </tr>

                            </c:if>

                        </c:forEach>

                        <%--                        </thead>--%>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<%--<!-- <script type="text/html" id="toolbarDemo">
     <div class = "layui-btn-container" >
         <button class = "layui-btn layui-btn-sm" lay-event = "getCheckData" > 获取选中行数据 </button>
         <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button >
         <button class = "layui-btn layui-btn-sm" lay-event = "isAll" > 验证是否全选</button>
     </div >
 </script>-->
<!-- <script type="text/html" id="switchTpl">
     &lt;%&ndash; 这里的checked的状态只是演示 &ndash;%&gt;
<!--<input type = "checkbox" name = "sex" value = "{{d.id}}" lay-skin = "switch"lay-text = "女|男" lay-filter = "sexDemo" {{ d.id == 10003 ? 'checked': ''}} >
</script>-->--%>
<%--<script>layui.use('laydate',--%>
<%--    function () {--%>
<%--        var laydate = layui.laydate;--%>

<%--        //执行一个laydate实例--%>
<%--        laydate.render({--%>
<%--            elem: '#start' //指定元素--%>
<%--        });--%>

<%--        //执行一个laydate实例--%>
<%--        laydate.render({--%>
<%--            elem: '#end' //指定元素--%>
<%--        });--%>

<%--    });--%>
<%--</script>--%>
<%--<script>layui.use('table',--%>
<%--    function () {--%>
<%--        var table = layui.table;--%>

<%--        //监听单元格编辑--%>
<%--        table.on('edit(test)',--%>
<%--            function (obj) {--%>
<%--                var value = obj.value //得到修改后的值--%>
<%--                    ,--%>
<%--                    data = obj.data //得到所在行所有键值--%>
<%--                    ,--%>
<%--                    field = obj.field; //得到字段--%>
<%--                layer.msg('[ID: ' + data.id + '] ' + field + ' 字段更改为：' + value);--%>
<%--            });--%>

<%--        //头工具栏事件--%>
<%--        table.on('toolbar(test)',--%>
<%--            function (obj) {--%>
<%--                var checkStatus = table.checkStatus(obj.config.id);--%>
<%--                switch (obj.event) {--%>
<%--                    case 'getCheckData':--%>
<%--                        var data = checkStatus.data;--%>
<%--                        layer.alert(JSON.stringify(data));--%>
<%--                        break;--%>
<%--                    case 'getCheckLength':--%>
<%--                        var data = checkStatus.data;--%>
<%--                        layer.msg('选中了：' + data.length + ' 个');--%>
<%--                        break;--%>
<%--                    case 'isAll':--%>
<%--                        layer.msg(checkStatus.isAll ? '全选' : '未全选');--%>
<%--                        break;--%>
<%--                };--%>
<%--            });--%>
<%--    });--%>

<%--</script>--%>
</html>
