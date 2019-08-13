var initCurrentPage=1;
var initPageSize=15;
function managerMenuselect(){
    //初始化分页插件
    var  options = {
        bootstrapMajorVersion: 3, //版本
        currentPage: 1, //当前页数
        totalPages: 1, //总页数
        numberOfPages: 15,
        shouldShowPage:true,//是否显示该按钮
        itemTexts: function (type, page, current) {
            switch (type) {
                case "first":
                    return "首页";
                case "prev":
                    return "上一页";
                case "next":
                    return "下一页";
                case "last":
                    return "末页";
                case "page":
                    return page;
            }
        },//点击事件，用于通过Ajax来刷新整个list列表
        onPageClicked: function (event, originalEvent, type, page) {
            resPage(page,initPageSize);
        }
    }
    $('#pageoption').bootstrapPaginator(options);

    resPage(1,initPageSize);
}
$("#searchbtn").click(function(){
    resPage(1,initPageSize);
})
function number1(str){
    return str=="1"?"是":"否";
}
//获取分页数据
function resPage(page,pageSize) {
    $.ajax({
        type: "GET",
        url: baseurl+"/"+siteId+"/news/selectAll",
        data:{"currentPage":page,"pageSize":initPageSize,
            "isheadlines":$("#typeId").val(),
            "title":$("#title").val()},
        dataType: "json",
        success: function(data){
            if(data==null||data.length==0){
                //没有数据
                var newoptions = {
                    currentPage: 1, //当前页数
                    totalPages: 0, //总页数
                    numberOfPages: initPageSize}
                $('#pageoption').bootstrapPaginator("setOptions",newoptions);
            }else{
                var res=data.list;
                createTable(res);
                var currentPage = data.currentPage; //当前页数
                var totalPages = data.totalPage; //总页数
                initPageSize = data.pageSize; //总页数
                var newoptions = {
                    currentPage: currentPage, //当前页数
                    totalPages: totalPages, //总页数
                    numberOfPages: initPageSize}
                $('#pageoption').bootstrapPaginator("setOptions",newoptions);
            }}});
}
//格式化时间
function toDate(str){
    if(str!=null&&str!=''){
        var date=new Date(str);
     return   date.getFullYear()+'/'+(date.getMonth()+1)+'/'+date.getDate()
         +' '+date.getHours()+':'+date.getMinutes()+':'+date.getSeconds()
    }
    return "无时间";
}
//创建表格
function createTable(res){
    var html='';
    for(var i=0;i<res.length;i++) {
        html+='<tr>';
        html+='<th scope="row"><input type="checkbox" newsid="'+baseurl+""+res[i].newid+'"/></th>';
        html+='<td>'+(i+1)+'</td>';
        html+='<td>'+res[i].newid+'</td>';
        html+='<td>'+res[i].title+' </td>';
        html+='<td>'+res[i].userName+' </td>';
        html+='<td>'+number1(res[i].isheadlines)+'</td>';
        html+='<td>'+number1(res[i].ispublish)+'</td>';
        html+='<td>'+number1(res[i].isPush)+'</td>';
        html+='<td>'+toDate(res[i].createtime)+'</td>';
        html+='<td>'+toDate(res[i].publishTime)+'</td>';
        html+='<td><button class="doc_edit btn btn-info btn-sm" ><a href="'+
            baseurl+'managerhtml/'+res[i].siteId+'/news/newsManagerEdit/edit?id='+res[i].newid+'&li_menuid='+li_menuid+
            '">编辑</a></button ><button class="doc_del btn btn-default btn-sm" onclick="delNews('+res[i].newid+","+res[i].siteId+')">删除</button></td>';
        html+='</tr>';
    }
    $("#newsTable").html(html);
}
managerMenuselect();
function delNews(id,siteId){
    var b=confirm("确认删除？");
    if(b){
    $.ajax({
        type: "GET",
        url: baseurl + "/managerhtml/" + siteId + "/news/deleteById",
        data: {"id": id},
        dataType: "json",
        success: function (data) {
            resPage(1,initPageSize);
        }
    })
    }
}
