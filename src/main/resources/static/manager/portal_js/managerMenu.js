baseurl= $("#managerMenu").attr("href");
siteId= $("#managerMenu").attr("siteId");
li_menuid= $("#managerMenu").attr("li_menuid");
$.ajax({
    type: "GET",
    url: baseurl+'resources/islogin/selectByRoleIds',
    dataType: "json",
    async:false,
    success: function(data){
        //alert(JSON.stringify(data));
        if(data==null||data.length==0){
            alert("您不是管理员，请联系系统管理员给您分配角色权限");
        }else{
            var html='<ul class="list-unstyled">';
            for(var i=0;i<data.length;i++){
                html+='<li class="li_menu" id="li_menu'+data[i].id+'"><a href="'+baseurl+'managerhtml/'+data[i].siteId+'/'+data[i].url+'/'+data[i].action+'?li_menuid=li_menu'+data[i].id+'"> <i class="icon-home"></i>'+data[i].name+'</a></li>';
            }
            html+='</ul>';
        }
        $("#managerMenu").html(html);
        var li_menuid=$("#managerMenu").attr("li_menuid");
        if(li_menuid!=null&&li_menuid!=undefined)
            $("#"+li_menuid).addClass("active");
    }
});