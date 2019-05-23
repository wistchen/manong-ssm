<%--
  Created by IntelliJ IDEA.
  User: APPLE
  Date: 2019/4/25
  Time: 上午10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品分类</title>
</head>
<body>
<ul id="productCategory" class="easyui-tree"></ul>

<div id="mm" class="easyui-menu" style="width:120px;">
    <div onclick="append()" data-options="iconCls:'icon-add'">增加</div>
    <div onclick="rename()" data-options="iconCls:'icon-add'">修改</div>
    <div onclick="remove()" data-options="iconCls:'icon-remove'">删除</div>
    <div onclick="appenddemo()" data-options="iconCls:'icon-remove'">增加新分类</div>
</div>
<div id="mm2" class="easyui-menu" style="width:120px;">
    <div onclick="append()" data-options="iconCls:'icon-add'">增加</div>
    <div onclick="rename()" data-options="iconCls:'icon-add'">修改</div>
    <div onclick="remove()" data-options="iconCls:'icon-remove'">删除</div>
</div>

<script type="text/javascript">
    $(function(){
        $('#productCategory').tree({
            url: "/product_category/list",
            onContextMenu: function(e, node){
                e.preventDefault();
                // select the node
                $('#productCategory').tree('select', node.target);
                //如果父亲节点是0 则多出一个操作
                if(node.attributes == 0) {
                    // display context menu
                    $('#mm').menu('show', {
                        left: e.pageX,
                        top: e.pageY
                    });
                }else{
                    // display context menu
                    $('#mm2').menu('show', {
                        left: e.pageX,
                        top: e.pageY
                    });
                }

            },

            onAfterEdit:function(node){
                var _tree = $('#productCategory');
                //如果node.id =0 增加
                if(node.id == 0){
                    $.post("/product_category/add",{parentId:node.parentId,name:node.text},function(data){
                        if(data.status == 200){
                            _tree.tree('update',{
                                target:node.target,
                                id:data.msg
                            })
                        } else{
                            $.messager.alert("添加分类失败");
                        }
                    })
                }else{
                //    rename
                    $.post("/product_category/edit",{parentId:node.attributes,id:node.id,name:node.text},function(data){
                        if(data.status == 200){
                            _tree.tree('update',{
                                target:node.target,
                                id:data.msg
                            })
                        } else{
                            $.messager.alert("更新分类失败");
                        }
                    })

                }
//           hhh
//                 if(parentId == 0){
//
//                     $.post("/product_category/adddemo",{parentId:0,name:node.text},function(data){
//                         if(data.status == 200){
//                             _tree.tree('update',{
//                                 target:node.target,
//                                 id:data.msg
//                             })
//                         } else{
//                             $.messager.alert("添加分类失败");
//                         }
//                     })
//
//                 }
            }
        });
    });

    function append(){
        // 获取点击的node
        var tree = $('#productCategory');
        var node = tree.tree('getSelected');
        // 根据文档查找的append方法
        tree.tree('append', {
            parent: node?node.target:null,
            data: [{
                id: 0,
                parentId:node.id,
                text: '新建分类'
            }]
        });
        //找到id=0的node使他处于编辑状态
        var _node = tree.tree("find",0);
        tree.tree("select",_node.target).tree("beginEdit",_node.target);

    }

    function rename(){
        // 获取点击的node
        var tree = $('#productCategory');
        var node = tree.tree('getSelected');
        tree.tree('beginEdit',node.target);
    }
    //
    // function rename(){
    //     // 获取点击的node
    //     var tree = $('#productCategory');
    //     var node = tree.tree('getSelected');
    //     tree.tree('beginEdit',node.target);
    // }

    // // 注意看 为什么id传不过去 是因为你写成name了
    // function remove(){
    //     // 获取点击的node
    //     var tree = $('#productCategory');
    //     var node = tree.tree('getSelected');
    //
    //     $.post("/product_category/del",{parentId:node.attributes,name:node.id},function(data){
    //         if(data.status == 200){
    //             tree.tree('remove',node.target);
    //         } else{
    //             $.messager.alert("删除信息失败");
    //         }
    //     })
    // }

    function remove() {
        // alert('remove')
        var tree = $('#productCategory');
        var node = tree.tree('getSelected');

        $.post("/product_category/del",{parentId:node.attributes,id:node.id},function (data) {
            if(data.status==200){
                tree.tree("remove",node.target);
            }else{
                $.messager.alert("删除分类失败");
            }
        })
    }

    function appenddemo() {
        // 获取点击的node
        var tree = $('#productCategory');
        var node = tree.tree('getSelected');
        // 根据文档查找的append方法
        tree.tree('append', {
            parent: node?node.target:null,
            data: [{
                id: 0,
                parentId:0,
                text: '新建分类'
            }]
        });
        //找到id=0的node使他处于编辑状态
        var _node = tree.tree("find",0);
        tree.tree("select",_node.target).tree("beginEdit",_node.target);
    }


</script>
</body>

</html>
