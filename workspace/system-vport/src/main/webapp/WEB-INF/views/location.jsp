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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/assets/css/ssi-uploader.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/ssi-uploader.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" media="all">
    <script src="${pageContext.request.contextPath }/assets/js/modernizr.min.js"></script>
     <style>
        .nav-item:hover{
            cursor: pointer;
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
                    <div class="row">
                        <div class="col-12">
                        	<input type="hidden" id="addr" value="${addr }">
                            <ul class="nav nav-pills navtab-bg nav-justified pull-in ">
				                <li class="nav-item">
				                    <a class="nav-link">
				                        <i class="fa fa-automobile"></i> <br>DRIVING
				                    </a>
				                </li>
				                <li class="nav-item">
				                    <a class="nav-link show active">
				                        <i class="fa fa-bus"></i> <br>TRANSIT
				                    </a>
				                </li>
				                <li class="nav-item">
				                    <a class="nav-link">
				                        <i class="fa fa-bicycle"></i> <br>BICYCLING
				                    </a>
				                </li>
				
				                <li class="nav-item">
				                    <a class="nav-link">
				                        <i class="fa fa-male"></i> <br>WALKING
				                    </a>
				                </li>
				            </ul>
				            <div id="map-content">
				                <div class="card-box">
				                    <h4 class="mb-3 header-title">TRANSIT</h4>
				                    <div id="location" class="gmaps"></div>
				                </div>
				                <div class="card-box">
				                    <div id="direction"></div>
				                </div>
				            </div>
                        </div>
                    </div>
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

    <!-- App js -->
    <script src="${pageContext.request.contextPath }/assets/js/jquery.core.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/jquery.app.js"></script>

     <!-- google maps api -->
    <script src="http://maps.google.com/maps/api/js?key=AIzaSyBDOBVcCau6NO4uXhXWJLxM2tJfTySQTlU&language=en"></script>
    <script src="${pageContext.request.contextPath }/assets/js/gmaps.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/mapDirection.js"></script>
    
</body>
</html>