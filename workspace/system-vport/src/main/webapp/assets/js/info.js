$(function(){
	$.ajax({
		url:"http://www.vport.com/rest/info/allInfo",
		async:false,
		type:"get",
		dataType:"json",
		success:function(data){
			$("#link").children().remove();
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
			}else{
				$("#link").html("<div class='dropdown-item notify-item'>"+
	                    "<p class='text-muted'><strong>No New Info</strong></p>"+
	                "</div>");
			}
		}
	});
	
	$("#clearAll").click(function(){
		$.post("http://www.vport.com/rest/info/deleteInfo",{},function(res){
			if(res == 1){
				/*$("#link").children().remove();*/
				$("#link").html("<div class='dropdown-item notify-item'>"+
                                        "<p class='text-muted'><strong>No New Info</strong></p>"+
                                    "</div>");
				$("#info .arrow-none").html("<i class='fi-bell noti-icon'></i>");
				/*window.location.reload();*/
			}
		},"json");
	});
	/*return false;*/
	
});
//<small class="text-muted">1 min ago</small>
    


