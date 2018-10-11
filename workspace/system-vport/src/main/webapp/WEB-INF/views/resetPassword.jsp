<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Vport</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
    <meta content="Coderthemes" name="author" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />

    <!-- App favicon -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/assets/images/favicon.ico">
    <!-- App css -->
    <link href="${pageContext.request.contextPath }/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/assets/css/icons.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/assets/css/metismenu.min.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/assets/css/style.css" rel="stylesheet" type="text/css" />
    <script src="${pageContext.request.contextPath }/assets/js/modernizr.min.js"></script>
	<style type="text/css">
		
		.person-info{
			margin: 20px 0
		}
		.person-info p{
			    display: inline-block;
   				 margin-left: 20px;
   				 color: #fff;
    			font-size: 16px;
    			font-weight: 700;
		}
	</style>
</head>


<body class="">
    <!-- Begin page -->
    <div class="accountbg" style="background: url('${pageContext.request.contextPath }/assets/images/bg/tennis1.jpg');background-size: cover;"></div>
    <div class="container margin-top-40">
        <div class="row">
            <div class="col-md-4 offset-md-4">
                <div class="wrapper-page bg-dark">

                    <div class="card bg-dark ">
                        <div class="card-block">

                            <div class="account-box">

                                <div class="card-box p-5 bg-dark">
									<h3 style="color:#fff">Reset your password</h3>
									<div class="person-info">
                                   		<img height="50" width="60" style="border-radius: 60%" src="http://image.vport.com/${user.icon }">
										<p>${user.name }</p>
										<input type="hidden" value="${user.id }">
									</div>		
									<div id="resetBefore">
                                        <div class="form-group row m-b-20">
                                            <div class="col-12">
                                                <label for="password" class="text-muted">Type your new password</label>
                                                <input class="form-control b-r-30" type="password" required="" name="password" id="password" placeholder=" Enter your password">
                                            </div>
                                        </div>
										<div class="form-group row m-b-20">
                                            <div class="col-12">
                                                <label for="password" class="text-muted">Type your new password one more time</label>
                                                <input class="form-control b-r-30" type="password" required="" name="confirmPass" id="password" placeholder=" Enter your password">
                                            </div>
                                        </div>
	                                    <div class="form-group row text-left m-t-10">
	                                        <div class="col-12">
	                                             <button style="width: 50%" class="btn btn-primary b-r-30" type="button">Submit</button>
	                                        </div>
	                                     </div>
									</div>
									<div id="resetAfter" style="display: none">
                                        <div class="form-group m-b-20 row">

                                            <div class="col-12">
                                                <h4 style="color: #fff3cd;">Congratulations! You've successfully changed your password.</h4>
                                                <a href="${pageContext.request.contextPath }/rest/page/login" class="text-info pull-left"><span>Go to login</span></a>
                                            </div>
                                        </div>
									</div>	
                                    <!-- notification template -->
                                    


                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="m-t-40 text-center">
        <p class="account-copyright">2018 © Vport. - vport.com.au</p>
    </div>





    <!-- jQuery  -->
    <script src="${pageContext.request.contextPath }/assets/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/metisMenu.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/waves.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/jquery.slimscroll.js"></script>

    <!-- App js -->
    <script src="${pageContext.request.contextPath }/assets/js/jquery.core.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/jquery.app.js"></script>
    <script type="text/javascript">
    	$("button").click(function(){
    		$("input[name=password]").css("border","1px solid #d9e3e9");
			$("input[name=confirmPass]").css("border","1px solid #d9e3e9");
    		var password = $("input[name=password]").val();
    		if(password){
    			var conf = $("input[name=confirmPass]").val();
    			if(conf != password){
    				$("input[name=password]").css("border","2px solid red");
    				$("input[name=confirmPass]").css("border","2px solid red");
    			}else{
    				var data = {"id":$("input[type=hidden]").val(),"password":password};
    				$.ajax({
    	    			url:"${pageContext.request.contextPath}/rest/user/changePassword",
    	    			type:"post",
    	    			dataType:"json",
    	    			contentType:"application/json",
    	    			data:JSON.stringify(data),
    	    			success:function(res){
    	    				if(res == 1){
    	    					$("#resetBefore").hide();
        						$("#resetAfter").show();
    	    				}
    	    			}
    	    			
    	    		});
    			}
    		}else{
    			$("input[name=password]").css("border","2px solid red");
    		}
    	});
    
    </script>
</body>
</html>