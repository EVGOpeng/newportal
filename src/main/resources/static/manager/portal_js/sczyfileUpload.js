KindEditor.ready(function(K) {
    window.editor = K.create('#editor_id',
        {
            langType : 'zh-CN',
            //从图片空间选择文件后执行的回调函数。
            afterSelectFile:function(){
            alert("完成选择");
            },
            // 文件上传
            uploadJson : baseurl+'sczy/updateFile',
            fileManagerJson : '../jsp/file_manager_json.jsp',
            allowFileManager : true,
            //上传文件后执行的函数
            afterUpload : function(url) {
            alert(url);
            }
        });
});