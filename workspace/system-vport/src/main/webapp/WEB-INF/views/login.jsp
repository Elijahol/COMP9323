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

                                <div class="card-box p-5 bg-dark">
                                    <h2 class="text-uppercase text-center pb-4">
                                        <a href="${pageContext.request.contextPath }/" class="text-success">
                                            <span><img src="${pageContext.request.contextPath }/assets/images/vport.png" alt="" height="50"></span>
                                        </a>
                                    </h2>

                                    <form class="" action="${pageContext.request.contextPath }/rest/user/login" method="post">

                                        <div class="form-group m-b-20 row">
                                            <div class="col-12">
                                                <label for="emailaddress" class="text-muted">Email address</label>
                                                <input class="form-control b-r-30" type="email" name="email" id="emailaddress" required="" placeholder=" Enter your email">
                                            </div>
                                        </div>

                                        <div class="form-group row m-b-20">
                                            <div class="col-12">
                                                <a href="${pageContext.request.contextPath }/rest/page/recover" class="text-muted pull-right"><small>Forgot your password?</small></a>
                                                <label for="password" class="text-muted">Password</label>
                                                <input class="form-control b-r-30" type="password" required="" name="password" id="password" placeholder=" Enter your password">
                                            </div>
                                        </div>

                                        <div class="form-group row m-b-20">
                                            <div class="col-12">

                                                <div class="checkbox checkbox-custom">
                                                    <input id="remember" type="checkbox" checked="" name="remember" value="1">
                                                    <label for="remember" class="text-muted">
                                                        Remember me
                                                    </label>
                                                </div>

                                            </div>
                                        </div>

                                        <div class="form-group row text-center m-t-10">
                                            <div class="col-12">
                                                <button class="btn btn-block btn-custom waves-effect waves-light b-r-30" type="submit">Sign In</button>
                                            </div>
                                        </div>

                                    </form>
                                    <div class="text-center">
                                        <p class=""><a href="${pageContext.request.contextPath }/rest/page/register" class="text-muted">Don't have an account?</a></p>
                                    </div>

                                    <!-- notification template -->
                                    <c:if test="${not empty msg}">
                                    <div class="row" style="height: 80px;">
                                        <!-- error -->
                                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                            ${msg }
                                        </div>
                                        <!-- end -->
                                    </div>
									</c:if>
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

</body>
</html>