<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
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
                                <div id="register-box" class="card-box p-5 bg-dark">
                                    <h2 class="text-uppercase text-center pb-4">
                                        <a href="index.html" class="text-success">
                                            <span><img src="${pageContext.request.contextPath }/assets/images/vport.png" alt="" height="50"></span>
                                        </a>
                                    </h2>

                                    <form class="form-horizontal" action="${pageContext.request.contextPath }/rest/user/register" method="post">

	                                <div class="form-group row m-b-20">
	                                    <div class="col-12">
	                                        <label for="username" class="text-muted">Full Name</label>
	                                        <input class="form-control" type="text" id="username" required="" placeholder="Your name" name="name">
	                                    </div>
	                                </div>
	
	                                <div class="form-group row m-b-20">
	                                    <div class="col-12">
	                                        <label for="emailaddress" class="text-muted">Email address</label>
	                                        <span id="msg" style="color: #bb0000"></span>
	                                        <input class="form-control" type="email" id="emailaddress" required="" placeholder="Your Email" name="email">
	                                    </div>
	                                </div>
	
	                                <div class="form-group row m-b-20">
	                                    <div class="col-12">
	                                        <label for="password" class="text-muted">Password</label>
	                                        <input class="form-control" type="password" required="" id="password" placeholder="Enter your password" name="password">
	                                    </div>
	                                </div>
	
	                                <div class="form-group row m-b-20">
	                                    <div class="col-12">
	                                        <div class="radio radio-custom form-check-inline m-r-30">
	                                            <input id="role" type="radio" name="role" value="1" required>
	                                            <label for="role" class="text-custom">Instructor
	                                            </label>
	                                        </div>
	                                        <div class="radio radio-custom form-check-inline">
	                                            <input id="role2" type="radio" name="role" value="2" required>
	                                            <label for="role2" class="text-custom">Student
	                                            </label>
	                                        </div>
	                                    </div>
	                                </div>
	
	                                <div class="form-group row text-center m-t-10">
	                                    <div class="col-12">
	                                        <button id="subBtn" class="btn btn-block btn-custom waves-effect waves-light" type="submit">Sign Up Free</button>
	                                    </div>
	                                </div>
	
	                            </form>
                                    <!-- <div class="text-center">
                                        <p class=""><a href="page-register.html" class="text-muted">Don't have an account?</a></p>
                                    </div> -->
                                    
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
	    $("#emailaddress").on('blur',function(){
	        $("#msg").text('');
	        $("#emailaddress").css('border','1px solid #d9e3e9'); 
	        var $value = $(this).val();
	        if ($value != ''){
	            $.post("${pageContext.request.contextPath}/rest/user/checkEmail",{email:$value},function (data) {
	            	if (data == 0){
                        $("#register-box").append("<div id='error-msg' class='row' style='height: 80px;'>"
								                        +"<div class='alert alert-danger alert-dismissible fade show' role='alert'>"
								                            +"<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
								                                +"<span aria-hidden='true'>&times;</span>"
								                            +"</button>"
								                            +"The email has been registed before,please choose another email!"
								                        +"</div>"
								                    +"</div>");
                        $("#emailaddress").css('border','2px solid red');
                        $("#subBtn").attr('disabled',true);
                    } else if (data == 1){
                    	$("#register-box #error-msg").remove();
                        $("#emailaddress").css('border','1px solid #d9e3e9');
                        $("#subBtn").attr('disabled',false);
                    }
	            });
	        }
	    });

    </script>
</body>
</html>