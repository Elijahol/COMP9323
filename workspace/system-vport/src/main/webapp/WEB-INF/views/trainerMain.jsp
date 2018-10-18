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
	                            <div class="card-box user-box-1" style="background-image: url('http://image.vport.com/${existUser.icon }');">
	                                <div class="mask">
	                                    <img src="http://image.vport.com/${existUser.icon }" alt="">
	                                <h4>Hi, ${existUser.name }</h4>
	                                <p id="firstReminder"><i class="mdi mdi-bell-ring-outline"></i> </p>
	                                </div>
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
	                                        <a><i class="mdi mdi-chevron-down listgroup-collapse collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne"></i></a>
	                                    </div>
	
	                                    <div id="collapseOne" class="collapse show" role="tabpanel" aria-labelledby="headingOne">
	                                        <div class="card-body" id="courseInfo">
	                                            <!-- class brief info template -->
	                                            
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
			                                        <div id="timetableDis" class="table-responsive" data-pattern="priority-columns">
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
			                                                        <td><li class="btn btn-date"></li></td>
			                                                        <td><li class="btn btn-date"></li></td>
			                                                        <td><li class="btn btn-date"></li></td>
			                                                        <td><li class="btn btn-date" ></li></td>
			                                                        <td><li class="btn btn-date"></li></td>
			                                                        <td><li class="btn btn-date"></li></td>
			                                                        <td><li class="btn btn-date"></li></td>
			                                                    </tr>
			                                                </tbody>
			                                            </table>
			                                            <h5 id="currDate">Wednesday 14 Augest 2018</h5>
			                                            <!-- ClassTimetables -->
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
	        <script src='${pageContext.request.contextPath }/plugins/fullcalendar/js/fullcalendar.min.js'></script>
	        <script src="${pageContext.request.contextPath }/assets/pages/jquery.calendar.js"></script>
	
	    <!-- App js -->
	    <script src="${pageContext.request.contextPath }/assets/js/jquery.core.js"></script>
	    <script src="${pageContext.request.contextPath }/assets/js/jquery.app.js"></script>
	    <script src="${pageContext.request.contextPath }/assets/js/info.js"></script>
		<script type="text/javascript">
		// class name will start at 12:00pm
			$(function(){
				
				
				var date = {};
				/* 得到用户信息 */
				$.ajax({
					url:"${pageContext.request.contextPath}/rest/course/timeTable?id=${existUser.id}",
					async:false,
					type:"get",
					dataType:"json",
					success:function(data){
						if(data != {}) date = data;
					}
				});
				console.log(date);
				//添加最近课程
				if(date["00"] != null){
					var firstReminder = date["00"];
					$("#firstReminder").append(" Next Course: "+firstReminder.visualTime);
				}
				
				
				/* 得到班级信息 */
				$.get("${pageContext.request.contextPath}/rest/course/classInfo",{},function(data){
					
					$(data).each(function(i,n){
						var isChief = n.isChief == true?"chief":"assisstant";
						if(n.students != null){
							var length = n.students.length;
							$("#courseInfo").append("<div class='class-box'>"
	                                +"<div class='class-box-header'>"
	                                +"<h5><i class='mdi mdi-bullseye'></i> "+n.className+" <strong>"+n.rank+"</strong></h5>"
	                                
	                            +"</div>"
	                            +"<div class='class-box-body'>"
		                            +"<img src=http://image.vport.com/"+n.students[0].icon+">"
		                            +"<img src=http://image.vport.com/"+n.students[1].icon+">"
		                            +"<img src=http://image.vport.com/"+n.students[2].icon+">"
	                                +"<p>... "+n.students.length+" students</p>"
	                                +"<a href='${pageContext.request.contextPath}/rest/course/classInfoByClassId?classId="+n.classId+"'><button class='btn btn-outline-custom btn-rounded waves-light waves-effect'>View</button></a>"
	                            +"</div>"
	                        +"</div>");
						}
						
						
						
					});
				},"json");
			
			//对date的key进行排序
			var arr = [];
			for(var key in date){
				if(key != "00"){
					date[key].key = key;
					arr.push(date[key]);
				}
			}
			//arr.sort();
			arr.sort(function(a,b){
				return a.time - b.time;
			});
			console.log(arr);
			
			//获得当前几号
			function dayFormat(s) {
			    return s < 10 ? '0' + s: s;
			}
			var currDate = new Date();
			var currDay = dayFormat(currDate.getDate());
			
			/* 注入课程信息 */
			var days = $("#tech-companies-1 li");
			$(days).each(function(i,n){
				$(n).text(arr[i].key);
				if(currDay == arr[i].key){
					var timeTables = arr[i].timeTables;
					
					$(n).addClass("checked");
					$("#currDate").text(date[$(this).text()].visualTime);
					$(timeTables).each(function(i,n){
						$("#timetableDis").append("<div class='class-box'>"
				                +"<div class='class-box-header'>"
				                    +"<h5><i class='mdi mdi-bullseye'></i> "+n.visualTime+"</h5>"
				                +"</div>"
				                +"<div class='class-box-body'>"
				                	+"<a href='http://www.vport.com/rest/course/classInfoByClassId?classId="+n.classId+"'>"
				                    +"<p class='name'><strong>"+n.className+"</strong></p>"
				                    +"</a>"
				                    +"<a href='${pageContext.request.contextPath}/rest/location/toMap?classId="+n.classId+"&place="+n.place+"'>"
				                    	+"<p class='address'><i class='mdi mdi-map-marker-outline'></i> "+n.place+"</p>"
				                	+"</a>"
		                    	+"</div>"
				            +"</div>");
					});

				}
			});
			/* 日期点击事件 */
			days.bind("click",function(){
				$(days).each(function(i,n){
					$(n).removeClass("checked");
				});
				//删除原来的div
				$("#timetableDis").children("div").remove();
				$(this).addClass("checked");
				var key = $(this).text();
				//添加时间
				$("#currDate").text(date[key].visualTime);
				var timeTables = date[key].timeTables;
				//遍历当天课程信息
				$(timeTables).each(function(i,n){
					$("#timetableDis").append("<div class='class-box'>"
			                +"<div class='class-box-header'>"
			                    +"<h5><i class='mdi mdi-bullseye'></i> "+n.visualTime+"</h5>"
			                +"</div>"
			                +"<div class='class-box-body'>"
			                	+"<a href='http://www.vport.com/rest/course/classInfoByClassId?classId="+n.classId+"'>"
			                    +"<p class='name'><strong>"+n.className+"</strong></p>"
			                    +"</a>"
			                    +"<a href='${pageContext.request.contextPath}/rest/location/toMap?classId="+n.classId+"&place="+n.place+"'>"
			                    	+"<p class='address'><i class='mdi mdi-map-marker-outline'></i> "+n.place+"</p>"
			                	+"</a>"
	                    	+"</div>"
			            +"</div>");
				});
			});
				
		});
			
		</script>

</body>
</html>