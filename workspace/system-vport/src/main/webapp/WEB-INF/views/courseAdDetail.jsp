<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <div class="topbar">

                <nav class="navbar-custom">
                    <ul class="list-inline menu-left mb-0">
                        <li class="float-left">
                            <button class="button-menu-mobile open-left">
                                <i class="dripicons-menu"></i>
                            </button>
                        </li>
                        <li>
                            <div class="page-title-box">
                                <h4 class="page-title">Course Detail</h4>
                            </div>
                        </li>

                    </ul>

                </nav>

            </div>
            <!-- Top Bar End -->



            <!-- Start Page content -->
            <div class="content">
                <div class="container-fluid">

                    <!-- user-info template -->
                    <div class="row">
                        <div class="col-12">
                            <div id="courseCarousel" class="carousel slide" data-ride="carousel">
                                <ol class="carousel-indicators">
                                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                                    <li data-target="#myCarousel" data-slide-to="1"></li>
                                    <li data-target="#myCarousel" data-slide-to="2"></li>
                                </ol>   
                                <!-- carousel item template -->
                                <div class="carousel-inner">
                                	<c:forEach var="pic" items="${course.pics }" varStatus="status">
                                	<c:if test="${status.index == 0 }">
                                    <div class="carousel-item active">
                                        <img src="http://image.vport.com/${pic }" alt="First slide">
                                    </div>
                                    </c:if>
                                    <c:if test="${status.index != 0 }">
                                    <div class="carousel-item">
                                        <img src="http://image.vport.com/${pic }" alt="First slide">
                                    </div>
                                    </c:if>
                                    </c:forEach>
                                </div>
                                <!-- end template -->
                                <a class="carousel-control-prev" href="#demo" data-slide="prev">
                                    <span class="carousel-control-prev-icon"></span>
                                </a>
                                <a class="carousel-control-next" href="#demo" data-slide="next">
                                    <span class="carousel-control-next-icon"></span>
                                </a>
                            </div> 
                        </div>
                    </div>
                    <!-- end row -->
                    <div class="row mt-3">
                        <div class="col-12">
                            <div class="card-box task-detail">
                                    <div class="media mt-0 m-b-30">
                                        <a href="${pageContext.request.contextPath }/rest/common/showProfile?id=${course.trainer.id}"></a><img class="d-flex mr-3 rounded-circle" alt="64x64" src="http://image.vport.com/${course.trainer.icon }" style="width: 48px; height: 48px;"></a>
                                        <div class="media-body">
                                            <a href="${pageContext.request.contextPath }/rest/common/showProfile?id=${course.trainer.id}" class="text-dark"><h5 class="media-heading mb-0 mt-0">${course.trainer.name }</h5></a>
                                            <span class="badge badge-info">Instuctor</span>
                                        </div>
                                    </div>

                                    <h4 class="m-b-20">${course.trainingClass.className }</h4>

                                    <p class="text-muted">
                                        ${course.trainingClass.description }
                                    </p>

                                    <ul class="list-inline task-dates m-b-0 mt-5">
                                    	<li>
                                            <h5 class="m-b-5">Rank</h5>
                                            <p> ${course.trainingClass.rank }</p>
                                        </li>
                                        <li>
                                            <h5 class="m-b-5">Start Date</h5>
                                            <p> ${course.startTime }</p>
                                        </li>
										<li>
                                            <h5 class="m-b-5">Training Time</h5>
                                            <p> ${course.trainingClass.hourTo }</p>
                                        </li>
                                        <li>
                                            <h5 class="m-b-5">Address</h5>
                                            <p> ${course.trainingClass.place }</p>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>

                                    <div class="assign-team mt-4">
                                    	<c:if test="${course.students.size() != 0 }">
                                        <h5 class="m-b-5">${course.students.size() } students add this course</h5>
                                        <div>
                                        	<c:forEach var="student" items="${course.students}">
                                            <a href="#"> <img class="rounded-circle thumb-sm" alt="64x64" src="http://image.vport.com/${student.icon }"> </a>
                                            </c:forEach>
                                        </div>
                                        </c:if>
                                    </div>
                                    <div class="alert alert-custom mt-4">The resitration deadline is <br><strong>${course.deadLine }</strong></div>
                                    <button class="btn btn-custom btn-addcourse">Add</button>
                                    <div class="clear"></div>
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

</body>
</html>