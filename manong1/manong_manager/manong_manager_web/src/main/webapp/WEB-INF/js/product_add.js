var MN = MANONG = {

    initProductCategory: function () {
        $("#productAddForm").find("select[name='cid']").combobox({
            onChange:function(){
                var value = $("#cc").val();
                $("#productAddForm").find("input[name='categoryId']").val(value);
                loadSubCategory(value);
            }
        });

        // 加载子类 如果 value==0 则没有子类
        function loadSubCategory(value) {
            var $box = $("#productAddForm").find('#cbox');
            if (value == 0) {
                $box.html('').hide();
                return;
            }
            $.getJSON("/product_category/list", {id: value}, function (data) {
                var s = '';
                s = '<select id="cc2" class="easyui-combobox" name="cid2" style="width:200px;">';
                s += '<option value="0">请选二级分类</option>';

                $.each(data, function (idx, item) {
                    s += '<option value="' + item.id + '">' + item.text + '</option>';
                });
                s += '</select>';
                $box.html(s).show();

                $("#productAddForm").find("select[name='cid2']").combobox({
                    onChange:function () {
                        var value = $("#cc2").val();
                        if(value==0){
                            $("#productAddForm").find("input[name='categoryId']").val($("#productAddForm").find("input[name='cid']").val());
                        }else{
                            $("#productAddForm").find("input[name='categoryId']").val(value);
                        }
                    }
                });

            });
        };
    },
    initPicUpload: function () {
        //初始化 框框
        $("#fileName").filebox({
            prompt:"kunkun来选图片",
            width:"150",
            buttonText:"浏览",
        });

        $(".uploadPic").click(function () {
            $.ajaxFileUpload({
                url:'/uploadfile',
                fileElementId:'filebox_file_id_1', //文件上传域的ID
                type:'post',
                success:function (data) {
                    alert($(data).text());
                    console.log($(data).find("body").text());
                    $("img").attr("src","http://172.16.107.136:8888/"+ $(data).find("body").text());
                    $("#productAddForm").find("input[name='image']").val($(data).find("body").text());
                }
            });
        })
     },
    init:function (data) {
        //实例化编辑器
        //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
        var ue = UE.getEditor('editor');
        // 初始化商品分类
        this.initProductCategory();
        // 初始化上传照片
        this.initPicUpload();


    }
}
