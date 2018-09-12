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
                                <h4 class="page-title">Home</h4>
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
                    <div class="row m-t-50">
                        <div class="col-12">
                            <div class="card-box course-box-1">
                                <h4>Class Name:${classInfo.className }&nbsp;&nbsp;Rank: ${classInfo.rank }</h4>
                                <p><i class="mdi mdi-calendar-clock"></i> 12:00pm</p>
                                <p><i class="mdi mdi-map-marker-outline"></i> ${classInfo.place }</p>
                            </div>
                        </div>
                    </div>
                    <!-- end row -->



                    <div class="row">
                        <div class="col-lg-12">
                            <div id="accordion" role="tablist" aria-multiselectable="true" class="m-b-30">
                                <div class="card bg-transparent">
                                    <div class="card-header b-r-30 listgroup-title" role="tab" id="headingOne">
                                        <h5 class="mb-0 mt-0">
                                            <a>
                                                STUDENTS LIST
                                            </a>
                                        </h5>
                                        <a><i class="mdi mdi-chevron-down listgroup-collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne"></i></a>
                                    </div>

                                    <div id="collapseOne" class="collapse show" role="tabpanel" aria-labelledby="headingOne">
                                        <div class="card-body bg-transparent">
                                            <a href="#" class="btn btn-custom btn-block mb-3 waves-effect waves-light"><i class="mdi mdi-plus-circle"></i> Add A New Plan</a>

                                    <ul class="sortable-list taskList list-unstyled" id="upcoming">
                                        <!-- student brief info template -->
                                        <c:forEach var="stu" items="${classInfo.students }">
                                        <li class="" id="task1">
                                            <div class="clearfix"></div>
                                            <div class="">
                                                <p class="pull-right mb-0 mt-2">
                                                    <a><button type="button" class="btn btn-custom btn-sm waves-effect waves-light">Evaluate</button></a>
                                                </p>
                                                <p class="mb-0"><a href="" class="text-muted"><img src="http://image.vport.com/${stu.icon }" alt="task-user" class="thumb-sm rounded-circle mr-2"> <span class="font-bold font-secondary">${stu.name }</span></a> </p>
                                            </div>
                                        </li>
                                        </c:forEach>
                                        <!-- end template -->
                                    </ul>
                                    
                                            
                                        </div>
                                    </div>
                                </div>
                                <div class="card bg-transparent">
                                    <div class="card-header b-r-30 listgroup-title" role="tab" id="headingTwo">
                                        <h5 class="mb-0 mt-0">
                                            <a>
                                                PLAN HISTORY
                                            </a>
                                        </h5>
                                        <a><i class="mdi mdi-chevron-down listgroup-collapse"data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo"></i></a>
                                    </div>
                                    <div id="collapseTwo" class="collaps show" role="tabpanel" aria-labelledby="headingTwo">
                                        <div class="card-body plan-box" >
                                            <!-- plan brief info template  trainingDate-->
                                            <c:forEach var="plan" items="${classInfo.plans }">
                                            <div class="class-box">
                                                <div class="class-box-header">
                                                    <h5><i class="mdi mdi-bullseye"></i> ${plan.trainingDate }</h5>
                                                    <p class="class-box-time">${classInfo.place }</p>
                                                </div>
                                                <div class="class-box-body">
                                                    <p> ${plan.trainingDate }</p>
                                                    <a href="#" class=""><button class="btn btn-outline-custom btn-rounded waves-light waves-effect">View</button></a>
                                                </div>
                                            </div>
                                            </c:forEach>
                                            <!-- end template -->
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
        <script src='${pageContext.request.contextPath }/plugins/fullcalendar/js/fullcalendar.min.js'></script>
        <script src="${pageContext.request.contextPath }/assets/pages/jquery.calendar.js"></script>

    <!-- App js -->
    <script src="${pageContext.request.contextPath }/assets/js/jquery.core.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/jquery.app.js"></script>

</body>
</html>