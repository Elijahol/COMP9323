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
    <%@include file="leftSidebar.jsp" %>
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

                <!-- end row -->
                <div class="row mt-3">
                    <div class="col-12">
                        <div class="card-box task-detail">
                            

                            <h4 class="m-b-20" style="margin: 20px 0">${classInfo.className }</h4>
							<div class="media mt-0 m-b-30">
                                <img class="d-flex mr-3 rounded-circle" alt="64x64" src="http://image.vport.com/${classInfo.trainer.icon }" style="width: 48px; height: 48px;">
                                <div class="media-body">
                                    <a href="${pageContext.request.contextPath }/rest/common/showProfile?id=${classInfo.trainer.id}" class="text-dark"><h5 class="media-heading mb-0 mt-0">${classInfo.trainer.name }</h5></a>
                                    <span class="badge badge-info">Instuctor</span>
                                    <div class="btn btn-primary" style="float: right;margin: -10px 33px 0 0;font-size:20px;"><strong>Rank: </strong><span class="badge badge-pill badge-light" style="top:-3px;">${classInfo.rank }</span></div>
                                </div>
                            </div>
                            <ul class="list-inline task-dates m-b-0 mt-5">
                                <li>
                                    <h5 class="m-b-5">Training Time</h5>
                                    <p> ${classInfo.hourTo }</p>
                                </li>
								<li>
                                	<h5 class="m-b-5">Training Days</h5>
                                    <p style="padding: 5px"> 
										<c:forEach var="day" items="${classInfo.daysOfTraining }" varStatus="status">
											<c:if test="${status.index % 3 == 0 }">
											<strong class="badge badge-pill badge-danger" style="margin-bottom:3px; font-size:14px">${day }</strong>
											</c:if>
											<c:if test="${status.index % 3 == 1 }">
											<strong class="badge badge-pill badge-info" style="margin-bottom:3px;font-size:14px">${day }</strong>
											</c:if>
											<c:if test="${status.index % 3 == 2 }">
											<strong class="badge badge-pill badge-warning" style="margin-bottom:3px;font-size:14px">${day }</strong>
											</c:if>
										</c:forEach>
                                    </p>
                                </li>
                                <li style="width: 100%">
                                    <h5 class="m-b-5">Address</h5>
                                    <a href="${pageContext.request.contextPath }/rest/location/toMap?classId=${classInfo.classId}&place=${classInfo.place}"><p> <span class="mdi mdi-map-marker-outline"></span>${classInfo.place }</p></a>
                                </li>
                                
                            </ul>
                            <div class="clearfix"></div>

                            <div class="assign-team mt-4">
                            	<c:if test="${classInfo.students.size() != 0 }">
                                <h5 class="m-b-5">${classInfo.students.size() } students in this course</h5>
                                <div>
                                	<c:forEach var="stu" items="${classInfo.students }">
                                    <a href="${pageContext.request.contextPath }/rest/common/showProfile?id=${stu.id}"> <img class="rounded-circle thumb-sm" alt="64x64" src="http://image.vport.com/${stu.icon }"> </a>
                                    </c:forEach>
                                </div>
                                </c:if>
                            </div>
                            <input type="hidden" id="classId" value="${classInfo.classId }">
                            
                            <div class="clear"></div>
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
                                    <!-- plan brief info template -->
                                    <c:forEach var="plan" items="${classInfo.plans }">
                                    <div class="class-box">
                                        <div class="class-box-header">
                                            <h5><i class="mdi mdi-bullseye"></i> ${plan.trainingDate }</h5>
                                            <a href="${pageContext.request.contextPath }/rest/course/toEachPlan?id=${plan.id}" class="class-box-time" style="margin: 0px 5px"><button class="btn btn-outline-custom btn-rounded waves-light waves-effect">View</button></a>
                                        </div>
                                    </div>
                                    </c:forEach>
                                    <!-- end template -->
                                </div>
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
<script type="text/javascript">
	$(function(){
		$.get("${pageContext.request.contextPath}/rest/course/closestPlan?classId="+$("#classId").val(),function(data){
			
			if(data != null && data != ''){
				$("#classId").after("<a href='http://www.vport.com/rest/course/toEachPlan?id="+data.id+"'>"+
					                  	"<div class='alert alert-primary bg-primary text-white border-0'  style='margin-top: 10px'>"+
								      		"View the nearest future training plan <strong>"+data.trainingDate+"</strong>"+
								      	"</div>"+
							     	"</a>");
			}
		});
	});
</script>
</body>
</html>