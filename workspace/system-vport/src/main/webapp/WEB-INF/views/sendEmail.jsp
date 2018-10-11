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
                                    <h2 class="text-uppercase text-center pb-4">
                                        <a href="index.html" class="text-success">
                                            <span><img src="${pageContext.request.contextPath }/assets/images/vport.png" alt="" height="50"></span>
                                        </a>
                                    </h2>

                                    
										<div id="mailBefore">
	                                        <div class="form-group m-b-20 row">
	
	                                            <div class="col-12">
	                                                <h4 style="color: #fff3cd;">Reset you password?</h4>
	                                                <label for="emailaddress" class="text-muted">We found the following information associated with your account.</label>
	                                                <span style="color:#eee">Email a link to ${email } ?</span>
	                                            </div>
	                                        </div>
	
	
	                                        <div class="form-group row text-left m-t-10">
	                                            <div class="col-12">
	                                                <button style="width: 50%" class="btn btn-primary b-r-30" type="button">Continue</button>
	                                            </div>
	                                        </div>
										</div>
										<div id="mailAfter" style="display: none">
	                                        <div class="form-group m-b-20 row">
	
	                                            <div class="col-12">
	                                                <h2 style="color: #fff3cd;">Check your email</h2>
	                                                <label for="emailaddress" class="text-muted">We've sent an email to ${email }. Click the link in the email to reset your password.</label>
	                                                <span style="color:#eee">If you don't see the email, check other places it might be, like your junk, spam, social or other folders.</span>
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
    		$.get("${pageContext.request.contextPath}/rest/user/sendRecover",{},function(res){
    			if(res == 1){
    				$("#mailBefore").hide();
    				$("#mailAfter").show();
    			}
    		});
    	});
    
    </script>
</body>
</html>