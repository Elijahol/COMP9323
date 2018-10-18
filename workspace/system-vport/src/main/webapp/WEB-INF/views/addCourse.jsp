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
	<style type="text/css">
		.input-group .layui-form-checkbox{
			margin-bottom: 5px;
		}
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
                    <div class="row">
                        <div class="col-12">
                            <div class="card-box">
                                <form id="course-form" class="form-horizontal layui-form" role="form" action="${pageContext.request.contextPath }/rest/course/addCourse" method="post">
                                    <div class="form-group mt-3">
                                        <label class="col-form-label">Course Title</label>
                                        <input name="title" type="text" class="form-control">
                                    </div>
                                    <div class="form-group mt-3">
                                        <label class="col-form-label">Course Address</label>
                                        <input name="address" type="text" class="form-control">
                                    </div>
                                    <div class="form-group mt-3">
                                        <label class="col-form-label">Club Name</label>
                                        <input name="place" type="text" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label class="col-form-label">Course Description</label>
                                        <textarea name="description" type="text" class="form-control"></textarea>
                                    </div>
                                    <label class="col-form-label mt-3">Rank</label>
                                    <div class="input-group">
                                        <select name="rank" class="custom-select">
                                            <option selected disabled="">Select a Rank</option>
                                            <option value="A">A</option>
                                            <option value="B">B</option>
                                            <option value="C">C</option>
                                            <option value="D">D</option>
                                            <option value="S">S</option>
                                        </select>
                                    </div>
                                    <label class="col-form-label mt-3">Start Time</label>
                                    <div class="input-group">
                                        <input name="starttime" class="form-control" type="date">
                                    </div>
                                    <label class="col-form-label mt-3">Training Period</label>
                                    <div class="input-group">
                                    	<input type="checkbox" name="period" value="0" title="Sun">
                                        <input type="checkbox" name="period" value="1" title="Mon">
    									<input type="checkbox" name="period" value="2" title="Tue">
    									<input type="checkbox" name="period" value="3" title="Wen">
    									<input type="checkbox" name="period" value="4" title="Thu">
    									<input type="checkbox" name="period" value="5" title="Fri">
    									<input type="checkbox" name="period" value="6" title="Sat">
                                    </div>
                                    <label class="col-form-label mt-3">Training Time</label>
                                    <div class="input-group">
                                        <input name="hourTo1" class="form-control" type="time"><span style="font-size: 18px;line-height: 1.5;padding: 6px;">to</span>
                                        <input name="hourTo2" class="form-control" type="time">
                                    </div>
                                    <label class="col-form-label mt-3">Age Range</label>
                                    <div class="input-group">
                                        <input name="ageRange1" class="form-control" type="number" min="0"><span style="font-size: 18px;line-height: 1.5;padding: 6px;">to</span>
                                        <input name="ageRange2" class="form-control" type="number" min="0">
                                    </div>
                                    <label class="col-form-label mt-3">Registration Deadline</label>
                                    <div class="input-group">
                                        <input name="deadLine" class="form-control" type="date">
                                    </div>
                                    <label class="col-form-label mt-3">Instructor</label>
                                    <div class="input-group">
                                        <select id="trainers" name="trainer" class="custom-select">
                                            <option selected disabled="">Select a Instructor</option>
                                        </select>
                                    </div>
                                    <input type="hidden" name="pic" id="uploadimgsrc">
                                </form>
                                    <label class="col-form-label mt-3">Images</label>
                                    <div class="input-group" id="aaa">
                                        <input type="file" name="pics" multiple id="ssi-upload"/>
                                    </div>
                                <button class="btn btn-custom mt-3" onclick="formSubmit()">Save</button>
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

    <!--file-upload-->
    <script src="${pageContext.request.contextPath }/assets/js/jquery-2.1.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/assets/js/ssi-uploader.js"></script>
    <script src="${pageContext.request.contextPath }/layui/layui.js"></script>
    <script type="text/javascript">
    /* <option value="3">Three</option> */
    	$(function(){
    		$.get("${pageContext.request.contextPath}/rest/course/getTrainerList",{},function(res){
    			
    			$(res).each(function(i,n){
    				console.log(n);
    				$("#trainers").append("<option value="+n.id+">"+n.name+"</option>");
    			});
    			
    		});
    	});
    	layui.use(['form'], function(){
            var form = layui.form
        });
    	
    	$('#ssi-upload').ssi_uploader({
        	url:'${pageContext.request.contextPath}/rest/course/uploadFile',
        	maxFileSize:6,
        	allowed:['jpg','gif','txt','png','pdf'],
        	// 每个图片上传完成后回调函数
            onEachUpload: function (fileInfo) {
                // 这里在图片上传成功后将图片展示在用户图片列表中
                if($("#uploadimgsrc").val() == '')
                	$("#uploadimgsrc").val(fileInfo.responseMsg);
                else
                	$("#uploadimgsrc").val($("#uploadimgsrc").val()+","+fileInfo.responseMsg);
                
            }
        	
        });
    	function formSubmit(){
    		$("#course-form").submit();
    	}
        
       
    </script>
</body>
</html>