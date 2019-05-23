1<%--
  Created by IntelliJ IDEA.
  User: APPLE
  Date: 2019/4/24
  Time: 下午10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
                    <%--访问url地址来获取数据|| 自适应宽度 || 每次只能选择一行 || 此处初始值显示的大小在后面数组出现 || 定义可选的每页显示个数 || 生成一个分页（pagination）工具栏 pagination将发送两个参数到服务器|| 显示换行符号--%>
<table class="easyui-datagrid"
       data-options="url:'/product/list',fitColumns:true,singleSelect:true,pageSize:5,pageList:[5,10,15,20]"
       pagination="true" rownumbers="true" toolbar="#bar">
    <thead>
    <tr>
        <th data-options="field:'id',width:100">id</th>
        <th data-options="field:'name',width:100">商品名称</th>
        <th data-options="field:'image',width:100,formatter:showImage">主图</th>
        <th data-options="field:'maketPrice',width:100">市场价格</th>
        <th data-options="field:'price',width:100">价格</th>
        <th data-options="field:'productNumber',width:100">商品编号</th>
    </tr>
    </thead>
    <tbody>

    </tbody>
</table>

<%--<div id="bar">--%>
    <%--<a id="btn" href="#" class="easyui-linkbutton" data-option="iconCls:'icon-search'">搜索</a>--%>
    <%--<a id="btn" href="#" class="easyui-linkbutton" data-option="iconCls:'icon-search'">编辑</a>--%>
<%--</div>--%>

<script>
    function showImage(value,row,index) {
        if(row.image){
            return "<img style='height: 100px; width: auto' src='http://65.49.227.129:8888/"+row.image+"'/>"
        }
    }
</script>

</body>
</html>
