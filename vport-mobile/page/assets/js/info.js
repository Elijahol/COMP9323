$(function(){
    $.get("http://www.vport.com/rest/info/allInfo",{},function (data) {
        console.log(data);
        if(data.length != 0){
            var count = 0;

            $.each(data,function(i,n){
                if(n.status == 0){
                    count++;
                    $("#link").append("<a href='"+n.url+"' class='dropdown-item notify-item'>"+
                        "<input type='hidden' value='"+n.id+"'>"+
                        "<div class='notify-icon bg-success'><i class='mdi mdi-comment-account-outline'></i></div>"+
                        "<p class='notify-details'>"+n.content+
                        "<small class='text-muted'>"+n.hisTime+"</small>"+
                        "</p>"+
                        "</a>");
                }else{
                    $("#link").append("<a href='"+n.url+"' class='dropdown-item notify-item'>"+
                        "<input type='hidden' value='"+n.id+"'>"+
                        "<div class='notify-icon bg-success'><i class='mdi mdi-comment-account-outline'></i></div>"+
                        "<p class='notify-details text-muted'>"+n.content+
                        "<small class='text-muted'>"+n.hisTime+"</small>"+
                        "</p>"+
                        "</a>");
                }
            });
            if(count != 0){
                $("#info .arrow-none").append("<span class='badge badge-danger badge-pill noti-icon-badge'>" +
                    count +
                    "</span>");
            }
            $("#link a").click(function(){
                var id = $(this).children("input").val();
                $.post("http://www.vport.com/rest/info/changeInfo",{"id":id},function(res){},"json");
            });
        }

    });
    $("#link").siblings("div.noti-title").children()

});