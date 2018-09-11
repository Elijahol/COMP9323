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

</head>


<body class="enlarged" data-keep-enlarged="true">

    <!-- Begin page -->
    <div id="wrapper">

        <!-- ========== Left Sidebar Start ========== -->
        <div class="left side-menu side-menu-sm">

            <div class="slimscroll-menu" id="remove-scroll">

                <!-- LOGO -->
                <div class="topbar-left">
                    <a href="index.html" class="logo">
                        <span>
                            <img src="${pageContext.request.contextPath }/assets/images/vport.png" alt="" height="16">
                        </span>
                        <i>
                            <img src="${pageContext.request.contextPath }/assets/images/vport.png" alt="" height="16">
                        </i>
                    </a>
                </div>

                <!-- User box template-->
                <div class="user-box">
                    <div class="user-img">
                        <!-- user photo -->
                        <img src="${pageContext.request.contextPath }/assets/images/users/avatar-1.jpg" alt="user-img" title="Mat Helme" class="rounded-circle img-fluid">
                    </div>
                    <!-- user name -->
                    <h5><a href="#">Maxine Kennedy</a> </h5>
                </div>

                <!--- Sidemenu -->
                <div id="sidebar-menu">

                    <ul class="metismenu" id="side-menu">
                        <li>
                            <a href="index.html">
                                <i class="fi-air-play"></i><span> Home </span>
                            </a>
                        </li>

                        <li>
                            <a href="courses.html"><i class="fi-layers"></i> <span> Courses </span>
                            </a>
                        </li>
                        <li>
                            <a href="datacenter.html"><i class="fi-bar-graph-2"></i> <span> Data Center </span></a>
                        </li>
                        <li>
                            <a href="profile.html"><i class="fi-paper"></i> <span> Profile </span></a>
                        </li>
                        <li>
                            <a href="login.html"><i class="fi-disc"></i> <span> Log out </span></a>
                        </li>
                    </ul>

                </div>
                <!-- Sidebar -->

                <div class="clearfix"></div>

            </div>
            <!-- Sidebar -left -->

        </div>
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
                            <div class="card-box user-box-1">
                                <img src="${pageContext.request.contextPath }/assets/images/bg-1.jpg" alt="">
                                <h4>Hi, Alex</h4>
                                <p><i class="mdi mdi-bell-ring-outline"></i> class name will start at 12:00pm</p>
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
                                                CLASS LIST
                                            </a>
                                        </h5>
                                        <a><i class="mdi mdi-chevron-down listgroup-collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne"></i></a>
                                    </div>

                                    <div id="collapseOne" class="collapse show" role="tabpanel" aria-labelledby="headingOne">
                                        <div class="card-body">
                                            <!-- class brief info template -->
                                            <div class="class-box">
                                                <div class="class-box-header">
                                                    <h5><i class="mdi mdi-bullseye"></i> class name rank</h5>
                                                    <p class="class-box-time">ischief</p>
                                                </div>
                                                <div class="class-box-body">
                                                    <img src="${pageContext.request.contextPath }/assets/images/favicon.ico" alt="">
                                                    <img src="${pageContext.request.contextPath }/assets/images/favicon.ico" alt="">
                                                    <img src="${pageContext.request.contextPath }/assets/images/favicon.ico" alt="">
                                                    <p>... 15 students</p>
                                                    <a href="#"><button class="btn btn-outline-custom btn-rounded waves-light waves-effect">View</button></a>
                                                </div>
                                            </div>
                                            <!-- end template -->
                                        </div>
                                    </div>
                                </div>
                                <div class="card bg-transparent">
                                    <div class="card-header b-r-30 listgroup-title" role="tab" id="headingTwo">
                                        <h5 class="mb-0 mt-0">
                                            <a>
                                                TIME TABLE
                                            </a>
                                        </h5>
                                        <a><i class="mdi mdi-chevron-down listgroup-collapse"data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo"></i></a>
                                    </div>
                                    <div id="collapseTwo" class="collaps show" role="tabpanel" aria-labelledby="headingTwo">
                                        <div class="card-body timetable-box" >
                                        <div class="table-rep-plugin">
                                        <div class="table-responsive" data-pattern="priority-columns">
                                            <table id="tech-companies-1" class="table  table-striped timetable">
                                                <thead>
                                                    <tr>
                                                        <td>Su</td>
                                                        <td>M</td>
                                                        <td>Tu</td>
                                                        <td>W</td>
                                                        <td>TH</td>
                                                        <td>F</td>
                                                        <td>Sa</td>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td><a href="" class="btn btn-date">11</a></td>
                                                        <td><a href="" class="btn btn-date">12</a></td>
                                                        <td><a href="" class="btn btn-date">13</a></td>
                                                        <td><a href="" class="btn btn-date checked">14</a></td>
                                                        <td><a href="" class="btn btn-date">15</a></td>
                                                        <td><a href="" class="btn btn-date">16</a></td>
                                                        <td><a href="" class="btn btn-date">17</a></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            <h5>Wednesday 14 Augest 2018</h5>
                                            <div class="class-box">
                                                <div class="class-box-header">
                                                    <h5><i class="mdi mdi-bullseye"></i> 12:30 pm</h5>
                                                </div>
                                                <div class="class-box-body">
                                                    <p class="name">Class name</p>
                                                    <p class="address"><i class="mdi mdi-map-marker-outline"></i> Sport center</p>
                                                </div>
                                            </div>
                                        </div>
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



    

</body>
</html>