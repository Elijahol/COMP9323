<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link href="${pageContext.request.contextPath }/assets/css/style_dark.css" rel="stylesheet" type="text/css" />

    <script src="${pageContext.request.contextPath }/assets/js/modernizr.min.js"></script>
	<style type="text/css">
		#link{
		 height: auto!important;
		}
	</style>
</head>


<body class="enlarged" data-keep-enlarged="true">

    <!-- Begin page -->
    <div id="wrapper">

        <!-- ========== Left Sidebar Start ========== -->
        <%@ include file="leftSidebar.jsp" %>
        <!-- Left Sidebar End -->



        <!-- ============================================================== -->
        <!-- Start right Content here -->
        <!-- ============================================================== -->

        <div class="content-page">

            <!-- Top Bar Start -->
            <%@include file="home.jsp" %>
            <!-- Top Bar End -->



            <!-- Start Page content -->
            <div class="content">
                <div class="container-fluid">

                    <!-- user-info template -->
                    <div class="row m-t-50">
                        <div class="col-12">
                            <div class="card-box user-box-2" style="background-image: url('http://image.vport.com/${student.icon }')">
                                <div class="mask">
                                    <img src="http://image.vport.com/${student.icon }" alt="">
                                    <div class="user-name">
                                    <h4>${student.name } <i class=""></i></h4>
                                    <span id="studentId" hidden="hidden">${student.id }</span>
                                </div>
                                <a href="${pageContext.request.contextPath }/rest/common/showProfile?id=${student.id}" style="position: absolute;top: 40px;right: 40px;"><button class="btn btn-outline-custom btn-rounded waves-light waves-effect">View</button></a>
                                <p><i class="mdi mdi-map-marker-outline"></i> ${student.email }</p>
                                </div>
                            </div>
                            <div class="user-data-box">
                                <div class="user-data">
                                    <h6>${student.age }</h6>
                                    <p>Age</p>
                                </div>
                                <div class="user-data">
                                    <h6>${student.weight }</h6>
                                    <p>KG</p>
                                </div>
                                <div class="user-data">
                                    <h6>${student.height }</h6>
                                    <p>CM</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- end row -->



                    <div class="row">
                        <div class="col-lg-12">
                            <div id="accordion" role="tablist" aria-multiselectable="true" class="m-b-30">
                            	<c:if test="${comment != '' }">
		                            <div class="card bg-transparent">
		                            	<div class="alert alert-primary alert-dismissible fade show" role="alert">
	                                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	                                            <span aria-hidden="true">×</span>
	                                        </button>
	                                        <div>
	                                        	<strong>Recent Comment</strong>
	                                        </div>
	                                        <p>${comment }</p>
	                                    </div>
		                            </div>
	                            </c:if>
                                <div class="card bg-transparent">
                                    <div class="card-header b-r-30 listgroup-title" role="tab" id="headingOne">
                                        <h5 class="mb-0 mt-0">
                                            <a>
                                                Skills
                                            </a>
                                        </h5>
                                        <a><i class="mdi mdi-chevron-down listgroup-collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne"></i></a>
                                    </div>

                                    <div id="collapseOne" class="collapse show" role="tabpanel" aria-labelledby="headingOne">
                                        <div class="card-body bg-transparent">
                                            <div class="card-box">
                                                <h4 class="header-title">Compare Last one and average</h4>
                                                <canvas id="skills" height="350" class="mt-4"></canvas>
                                            </div>
                                            <div class="card-box">
                                                <h4 class="header-title">Average Score By Time</h4>
                                                <canvas id="skillsByTime" height="350" class="mt-4"></canvas>
                                            </div>
                                            <div class="card-box">
                                                <h4 class="header-title">Each skill By Time</h4>
                                                <canvas id="skillsByScore" height="350" class="mt-4"></canvas>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="card bg-transparent">
                                    <div class="card-header b-r-30 listgroup-title" role="tab" id="headingTwo">
                                        <h5 class="mb-0 mt-0">
                                            <a>
                                                Physical Ability
                                            </a>
                                        </h5>
                                        <a><i class="mdi mdi-chevron-down listgroup-collapse"data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo"></i></a>
                                    </div>
                                    <div id="collapseTwo" class="collaps show" role="tabpanel" aria-labelledby="headingTwo">
                                        <div class="card-body bg-transparent">
                                            <div class="card-box">
                                                <h4 class="header-title">Compare Last one and average</h4>
                                                <canvas id="physical" height="350" class="mt-4"></canvas>
                                            </div>
                                            <div class="card-box">
                                                <h4 class="header-title">Average Score By Time</h4>
                                                <canvas id="phsicalByTime" height="350" class="mt-4"></canvas>
                                            </div>
                                            <div class="card-box">
                                                <h4 class="header-title">Each ability By Time</h4>
                                                <canvas id="physicalByScore" height="350" class="mt-4"></canvas>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- end row -->

                </div> <!-- container -->

            </div> <!-- content -->

            <footer class="footer text-right">
                <p class="">2018 © Vport. - vport.com.au</p>
            </footer>

        </div>


        <!-- ============================================================== -->
        <!-- End Right content here -->
        <!-- ============================================================== -->


    </div>
    <!-- END wrapper -->



    <!-- jQuery  -->
    <script src="${pageContext.request.contextPath }/assets/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/metisMenu.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/waves.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/jquery.slimscroll.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/info.js"></script>
    

    <!-- KNOB JS -->
        <!--[if IE]>
        <script type="text/javascript" src="${pageContext.request.contextPath }/plugins/jquery-knob/excanvas.js"></script>
    <![endif]-->
    <script src="${pageContext.request.contextPath }/plugins/jquery-knob/jquery.knob.js"></script>

    <!-- Dashboard Init -->
    <script src="${pageContext.request.contextPath }/assets/pages/jquery.dashboard.init.js"></script>
    <!-- Jquery-Ui -->
    <script src="${pageContext.request.contextPath }/plugins/jquery-ui/jquery-ui.min.js"></script>
    <script src="${pageContext.request.contextPath }/plugins/moment/moment.js"></script>

    <!-- Chart JS -->
    <script src="${pageContext.request.contextPath }/plugins/chart.js/chart.bundle.js"></script>
    <script src="${pageContext.request.contextPath }/assets/pages/jquery.chartjs.init.js"></script>

    <!-- App js -->
    <script src="${pageContext.request.contextPath }/assets/js/jquery.core.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/jquery.app.js"></script>
</body>
</html>