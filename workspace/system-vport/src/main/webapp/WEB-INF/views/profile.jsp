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
    <!-- Bootstrap fileupload css -->
    <link href="${pageContext.request.contextPath }/plugins/bootstrap-fileupload/bootstrap-fileupload.css" rel="stylesheet" />
    <!-- App css -->
    <link href="${pageContext.request.contextPath }/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/assets/css/icons.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/assets/css/metismenu.min.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/assets/css/style_dark.css" rel="stylesheet" type="text/css" />

    <script src="${pageContext.request.contextPath }/assets/js/modernizr.min.js"></script>
	<style type="text/css">
		.hidden{
			display:none;
		}
		.inputError{
			border:2px solid red;
		}
		.labelError{
			color:red;
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

                    <!-- user-info template -->
                    <%@ include file="headerInfo.jsp" %>
                    <!-- end row -->



                    <div class="row">
                        <div class="col-lg-12">
                            <div id="accordion" role="tablist" aria-multiselectable="true" class="m-b-30">
                                <div class="card bg-transparent">
                                    <div class="card-header b-r-30 listgroup-title" role="tab" id="headingOne">
                                        <h5 class="mb-0 mt-0">
                                            <a>
                                                Brief Introduction
                                            </a>
                                        </h5>
                                        <a><i class="mdi mdi-chevron-down listgroup-collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne"></i></a>
                                    </div>

                                    <div id="collapseOne" class="collapse show" role="tabpanel" aria-labelledby="headingOne">
                                        <div class="card-body bg-transparent">
                                            <p>
                                                ${user.introduction }
                                            </p>
                                        </div>
                                    </div>
                                </div>
                                <div class="card bg-transparent">
                                    <div class="card-header b-r-30 listgroup-title" role="tab" id="headingTwo">
                                        <h5 class="mb-0 mt-0">
                                            <a>
                                                Rewards History
                                            </a>
                                        </h5>
                                        <a><i class="mdi mdi-chevron-down listgroup-collapse"data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo"></i></a>
                                    </div>
                                    <div id="collapseTwo" class="collaps show" role="tabpanel" aria-labelledby="headingTwo">
                                        <div class="card-body plan-box" >
                                            <!-- reward info template -->
                                            <c:forEach var="reward" items="${user.rewards }" varStatus="status">
                                            <div class="class-box" id="reward-${status.index }">
                                            	<span class="hidden">${reward.id }</span>
                                                <div class="class-box-header">
                                                    <h5><i class="mdi mdi-bullseye"></i>
                                                    ${reward.title }</h5>
                                                </div>
                                                <div class="class-box-body">
                                                    <p>${reward.content }
                                                        <br>
                                                    ${reward.rewardTime }</p>
                                                </div>
                                            </div>
                                            </c:forEach>
                                            <!-- end template -->
                                            <!-- if edit the profile -->
                                            <c:if test="${user.id == existUser.id }">
                                            <button class="btn btn-custom waves-light waves-effect" data-toggle="modal" data-target="#rewardModal" style="width: 100%;">Edit Rewards</button>
                                            </c:if>
                                            <!-- end if -->
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- end row -->

                </div> <!-- container -->

            </div> <!-- content -->
            

            <!-- if edit this profile modal content template-->
            <div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="myModalLabel">Edit Your Information</h4>
                        </div>
                        <div class="modal-body">
                            <form id="profile-form" class="form-horizontal" role="form" action="${pageContext.request.contextPath }/rest/common/updateUser" method="post" enctype="multipart/form-data">
                            	<input type="hidden" name="id" value="${user.id }">
                                <div class="form-group">
                                    <label class="col-form-label">Name</label>
                                    <input name="name" type="text" class="form-control" value="${user.name }">
                                </div>
                                <div class="form-group">
                                    <label class="col-form-label">Phone</label>
                                    <input name="phone" type="text" class="form-control" value="${user.phone }">
                                </div>
                                <label class="col-form-label">BOD</label>
                                <div class="input-group">
                                    <input name="birthdayFormat" class="form-control" type="text" value="${user.birthdayFormat }" onfocus="(this.type='date')" placeholder="12/09/1990">
                                </div>
                                <label class="col-form-label">Weight</label>
                                <div class="input-group">
                                    <input name="weight" type="number" class="form-control" value="${user.weight }" aria-label="Weight" aria-describedby="basic-addon1">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">KG</span>
                                    </div>
                                </div>
                                <label class="col-form-label">Height</label>
                                <div class="input-group">
                                    <input name="height" type="number" class="form-control" value="${user.height }" aria-label="height" aria-describedby="basic-addon1">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">CM</span>
                                    </div>
                                </div>
                                <label class="col-form-label">Introduction</label>
                                <div class="input-group">
                                    <textarea class="form-control" rows="1" name="introduction" placeholder="Introduction">${user.introduction }</textarea>
                                </div>
                                <label class="col-form-label">Image Upload</label>
                                <div class="input-group">
                                    <div class="">
                                        <div class="fileupload fileupload-new" data-provides="fileupload">
                                            <div class="fileupload-new thumbnail" style="width: 200px; height: 150px;">
                                                <img src="http://image.vport.com/${user.icon }" alt="image" />
                                            </div>
                                            <div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
                                            <div>
                                                <button type="button" class="btn btn-outline-custom btn-file">
                                                    <span class="fileupload-new"><i class="fa fa-paper-clip"></i> Select image</span>
                                                    <span class="fileupload-exists"><i class="fa fa-undo"></i> Change</span>
                                                    <input type="file" class="btn-light" name="pictureFile"/>
                                                </button>
                                                <a href="#" class="btn btn-danger fileupload-exists" data-dismiss="fileupload"><i class="fa fa-trash"></i> Remove</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>                            
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-light waves-effect" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-custom waves-effect waves-light"  onclick="formSubmit()">Save changes</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div>
            
            <div id="rewardModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title" id="myModalLabel">Edit Your Rewards</h4>
                    </div>
                    <div class="modal-body">
                        <form id="reward-form" class="form-horizontal" role="form" action="${pageContext.request.contextPath }/rest/common/editReward" method="post">
                         	<label class="col-form-label mt-3">Operation</label>
                            <div class="custom-control custom-radio">
                                <input type="radio" id="Edit" name="operation" value="Edit" class="custom-control-input">
                                <label class="custom-control-label" for="Edit">Edit</label>
                            </div>
                            <div class="custom-control custom-radio">
                                <input type="radio" id="Delete" name="operation" value="Delete" class="custom-control-input">
                                <label class="custom-control-label" for="Delete">Delete</label>
                            </div>
                            <div class="custom-control custom-radio">
                                <input type="radio" id="Add" name="operation" value="Add" class="custom-control-input">
                                <label class="custom-control-label" for="Add">Add</label>
                            </div>
                            <div id="select-reward" class="hidden">
	                            <label class="col-form-label">Rewards</label>
	                            <div class="input-group">
	                                <select id="select-option" class="custom-select">
	                                    <option selected disabled="">Select a reward</option>
	                                    <c:forEach var="reward" items="${user.rewards }" varStatus="status">
	                                    <option value="reward-${status.index }">${reward.title }--${reward.rewardTime }</option>
	                                    </c:forEach>
	                                </select>
	                            </div>
                           </div>
                           <div id="input-reward" class="hidden">
	                            <div class="form-group mt-3">
	                            	<input type="hidden" name=id>
	                            	<input type="hidden" name=userId value="${existUser.id }">
	                                <label class="col-form-label">Title</label>
	                                <input name="title" type="text" class="form-control">
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label">Content</label>
	                                <input name="content" type="text" class="form-control">
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label">Time</label>
	                                <input name=rewardTime type="text" class="form-control" onfocus="(this.type='date')">
	                            </div>
                            </div>

                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-light waves-effect" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-custom waves-effect waves-light" onclick="rewardSubmit()">Save changes</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div>
        <!-- end if -->

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
<!-- Bootstrap fileupload js -->
<script src="${pageContext.request.contextPath }/plugins/bootstrap-fileupload/bootstrap-fileupload.js"></script>

<!-- App js -->
<script src="${pageContext.request.contextPath }/assets/js/jquery.core.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/jquery.app.js"></script>
<script type="text/javascript">
	function formSubmit(){
		$("#profile-form").submit();
	}
	//reward表单提交加校验
	function rewardSubmit(){
		var isValid = true;
		if($("#Edit").attr("checked") || $("#Add").attr("checked")){
			$("#input-reward input[type=text]").each(function(i,n){
				if($(n).val() == null || $(n).val() == '' ){
					$(this).addClass("inputError");
					$(this).siblings("label").addClass("labelError");
					isValid = false;
				}
			});
		}
		
		if(isValid == true){
			$("#reward-form").submit();
		}
		/* $("#reward-form").submit(); */
	}
	
	$("#input-reward input[type=text]").mousedown(function(){
		$(this).removeClass("inputError");
		$(this).siblings("label").removeClass("labelError");
	});
	
	
	var isEdit = false;
	$("#reward-form input[type=radio]").click(function(){
		isEdit = false;
		$("#select-reward").addClass("hidden");
		$("#input-reward").addClass("hidden");
		var id = $(this).attr("id");
		/*1.edit和delete 
			调出select选择框
		  2.edit和add
			跳出输入框
			edit回显信息*/
		if(id == "Edit" || id == "Delete"){
			if(id == "Edit") isEdit = true;
			$("#select-option option").removeAttr("selected");
			$("#select-option option:first-child").attr("selected","");
			$("#select-reward").removeClass("hidden");
		}else if(id == "Add"){
			$("#input-reward input[type=text]").val(null);
			$("#input-reward").removeClass("hidden");
		}
	}); 
	$("#select-option").change(function(){
		var eleId = $(this).val();
		var id = $("#"+eleId+" span").text().trim();
		var title = "";
		var content ="";
		var time ="";
		$("#input-reward input[name=id]").val(id);
		if(isEdit == true){
			title = $("#"+eleId+" h5").text().trim();
			content = $("#"+eleId+" p").html().split("<br>")[0].trim();
			time = $("#"+eleId+" p").html().split("<br>")[1].trim();
			$("#input-reward input[name=title]").val(title);
			$("#input-reward input[name=content]").val(content);
			$("#input-reward input[name=rewardTime]").val(time);
			$("#input-reward").removeClass("hidden");
		}
	});
</script>
</body>
</html>