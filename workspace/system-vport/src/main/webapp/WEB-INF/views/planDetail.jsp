<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <!-- DataTables -->
        <link href="${pageContext.request.contextPath }/plugins/datatables/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath }/plugins/datatables/buttons.bootstrap4.min.css" rel="stylesheet" type="text/css" />
        <!-- Responsive datatable examples -->
        <link href="${pageContext.request.contextPath }/plugins/datatables/responsive.bootstrap4.min.css" rel="stylesheet" type="text/css" />

        <!-- Multi Item Selection examples -->
        <link href="${pageContext.request.contextPath }/plugins/datatables/select.bootstrap4.min.css" rel="stylesheet" type="text/css" />

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
					<input id="schemaId" type="hidden" value="${schemaId }">
                    <div class="row">
                        <div class="col-lg-12">
                        <span id="trainingTime" class="badge badge-pill badge-info" style="margin-bottom:12px; font-size:20px;margin-left: 5px"></span>
                            <div id="accordion" role="tablist" aria-multiselectable="true" class="m-b-30">
                                <div class="card bg-transparent">
                                    <div class="card-header b-r-30 listgroup-title" role="tab" id="headingOne">
                                        <h5 class="mb-0 mt-0">
                                            <a>
                                                Skills Plan
                                            </a>
                                        </h5>
                                        <a><i class="mdi mdi-chevron-down listgroup-collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne"></i></a>
                                    </div>

                                    <div id="collapseOne" class="collapse show" role="tabpanel" aria-labelledby="headingOne">
                                        <div class="card-body" >
                                        <div class="table-rep-plugin">
                                        <div class="table-responsive" data-pattern="priority-columns">
                                            <table id="responsive-datatable" class="table table-bordered table-bordered dt-responsive nowrap dataTable no-footer dtr-inline collapsed" cellspacing="0" width="100%" role="grid" aria-describedby="responsive-datatable_info" style="width: 100%;">
                                                <thead>
                                                    <tr>
                                                    	<td>Area</td>
                                                    	<td>Type</td>
                                                        <td>Group Number</td>
                                                        <td>Number of Each Group</td>
                                                        <td>Time Requirement</td>
                                                        <td>Time-continuing Requirement</td>
                                                        <td>Position Requirement</td>
                                                        <td>Training Mode </td>
                                                        <td>Target Requirement</td>
                                                        <td>Number of Success</td>
                                                        <td>Required Time</td>
                                                        <td>Type Of Skill</td>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="card bg-transparent">
                                    <div class="card-header b-r-30 listgroup-title" role="tab" id="headingTwo">
                                        <h5 class="mb-0 mt-0">
                                            <a>
                                                Physical Plan
                                            </a>
                                        </h5>
                                        <a><i class="mdi mdi-chevron-down listgroup-collapse"data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo"></i></a>
                                    </div>
                                    <div id="collapseTwo" class="collaps show" role="tabpanel" aria-labelledby="headingTwo">
                                        <div class="card-body" >
                                        <div class="table-rep-plugin">
                                        <div class="table-responsive" data-pattern="priority-columns">
                                            <table id="physicaltable" class="table table-bordered table-bordered dt-responsive nowrap dataTable no-footer dtr-inline collapsed" cellspacing="0" width="100%" role="grid" aria-describedby="responsive-datatable_info" style="width: 100%;">
                                                <thead>
                                                    <tr>
                                                        <td>Classification</td>
                                                        <td>Type</td>
                                                        <td>Quantity</td>
                                                        <td>Sub-Classification</td>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    
                                                </tbody>
                                            </table>
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

    <script src="${pageContext.request.contextPath }/assets/pages/jquery.calendar.js"></script>
    <!-- Required datatable js -->
    <script src="${pageContext.request.contextPath }/plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath }/plugins/datatables/dataTables.bootstrap4.min.js"></script>


        <!-- Responsive examples -->
    <script src="${pageContext.request.contextPath }/plugins/datatables/dataTables.responsive.min.js"></script>
    <script src="${pageContext.request.contextPath }/plugins/datatables/responsive.bootstrap4.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/info.js"></script>
    <script type="text/javascript">
            $(document).ready(function() {
				var data = {};
				$.ajax({
					url:"${pageContext.request.contextPath}/rest/course/eachPlan?id="+$("#schemaId").val(),
					async:false,
					type:"get",
					dataType:"json",
					success:function(res){
						data = res;
					}
				});
				console.log(data);
				
				//载入时间
				$("#trainingTime").html("Training Time: <strong>"+data.trainingDate+"</strong>");
				
                
                
                
                //载入技术类内容
                var skillPart = data.skillPart;
                for(var area in skillPart){
                	$.each(skillPart[area],function(i,n){
                		$("#responsive-datatable tbody").append("<tr>"+
									                				"<td>"+area+"</td>"+
									                				"<td>"+n.typeName+"</td>"+
									                				"<td>"+n.groupNum+"</td>"+
									                				"<td>"+n.countNumOfGroup+"</td>"+
									                				"<td>"+n.isLimitedTime+"</td>"+
									                				"<td>"+n.isContinuous+"</td>"+
									                				"<td>"+n.isMoved+"</td>"+
									                				"<td>"+n.isMultiple+"</td>"+
									                				"<td>"+n.isTarget+"</td>"+
									                				"<td>"+(n.numOfSuccess==null?"-":n.numOfSuccess)+"</td>"+
									                				"<td>"+(n.requiredTime==null?"-":n.requiredTime)+"</td>"+
									                				"<td>"+n.isCombined+"</td>"+
									                			"</tr>");
                	});
                }
                
                //载入体能类内容
                var physicalPart = data.physicalPart;
                for(var clazz in physicalPart){
                	if(clazz != "specializedTraining"){
                		$.each(physicalPart[clazz],function(i,n){
                			$("#physicaltable tbody").append("<tr>"+
							                					"<td>"+clazz+"</td>"+
							                					"<td>"+n.typeName+"</td>"+
							                					"<td>"+n.count+" "+n.unitName+"</td>"+
							                					"<td>-</td>"+
							                				"</tr>");
                		});
                	}else{
                		for(var subClazz in physicalPart[clazz]){
                			$.each(physicalPart[clazz][subClazz],function(i,n){
                				$("#physicaltable tbody").append("<tr>"+
								                					"<td>"+clazz+"</td>"+
								                					"<td>"+n.typeName+"</td>"+
								                					"<td>"+n.count+" "+n.unitName+"</td>"+
								                					"<td>"+subClazz+"</td>"+
								                				"</tr>");
                			});
                		}
                	}
                }
                
                
             	// Responsive Datatable
                $('#responsive-datatable').DataTable();
                $('#physicaltable').DataTable();
                $("#responsive-datatable_length").hide();
                $("#responsive-datatable_filter").hide();
                $("#responsive-datatable_wrapper").children(".row:last").hide();
                $("#physicaltable_length").hide();
                $("#physicaltable_filter").hide();
                $("#physicaltable_wrapper").children(".row:last").hide();
            } );

        </script>
    <!-- App js -->
    <script src="${pageContext.request.contextPath }/assets/js/jquery.core.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/jquery.app.js"></script>

</body>
</html>