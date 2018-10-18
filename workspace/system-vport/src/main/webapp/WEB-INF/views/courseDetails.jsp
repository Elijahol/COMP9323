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
    <link rel="shortcut icon" href="assets/images/favicon.ico">

    <!-- App css -->
    <link href="${pageContext.request.contextPath }/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/assets/css/icons.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/assets/css/metismenu.min.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/assets/css/style_dark.css" rel="stylesheet" type="text/css" />

    <script src="${pageContext.request.contextPath }/assets/js/modernizr.min.js"></script>
    <!-- Plugins css-->
    <link href="${pageContext.request.contextPath }/plugins/bootstrap-tagsinput/css/bootstrap-tagsinput.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath }/plugins/bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath }/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/switchery/switchery.min.css">
	<style type="text/css">
		#link{
		 height: auto!important;
		}
		.background{
			background-color: #f3f6f8
		}
		.suggInfo{
		    background-color: #fff;
  			border-left: 1px solid #eee;
  			padding: 10px;
		}
		a{
			color:#fff;
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
					<div class="row m-t-50">
                        <div class="col-12">
                            <div class="card-box course-box-1">
                            	<a href="${pageContext.request.contextPath }/rest/course/classInfoByClassIdForStu?classId=${classInfo.classId}" style="color:#fff">
                                <div class="mask">
                                    <h4>${classInfo.className }&nbsp;&nbsp;${classInfo.rank }</h4>
                                    <input type="hidden" id="classId" value="${classInfo.classId }">
                                <p><i class="mdi mdi-calendar-clock"></i> ${classInfo.hourTo }</p>
                                <a href="${pageContext.request.contextPath }/rest/location/toMap?classId=${classInfo.classId}&place=${classInfo.place }"><p><i class="mdi mdi-map-marker-outline"></i> ${classInfo.place }</p></a>
                                </div>
                                </a>
                            </div>
                        </div>
                    </div>
                    <!-- user-info template -->
                    <%-- <div class="row m-t-50">
                        <div class="col-12">
                            <div class="card-box course-box-1">
                                <h4>${classInfo.className }&nbsp;&nbsp;${classInfo.rank }</h4>
                                <p><i class="mdi mdi-calendar-clock"></i> 12:00pm</p>
                                <p><i class="mdi mdi-map-marker-outline"></i> ${classInfo.place }</p>
                            </div>
                        </div>
                    </div> --%>
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
	                                        <div>
	                                        	<a href="${pageContext.request.contextPath }/rest/course/returnPlan?classId=${classInfo.classId}" class="btn btn-custom btn-block mb-3 waves-effect waves-light" style="width: 65%"><i class="mdi mdi-plus-circle"></i> Add A New Plan</a>
		                                        <div class="btn btn-purple waves-effect waves-light" style="display: inline-block;width: 30%;margin-bottom: 1rem" role="tab" id="SuggInfo" data-toggle="collapse" data-parent="#collapseOne" href="#suggInfoContent" aria-expanded="flase" aria-controls="suggInfoContent">
			                                        <a>Suggestion</a>
			                                    </div>
			                                    
			                                </div>
		                                    <div id="suggInfoContent" class="collapse" role="tabpanel" aria-labelledby="SuggInfo">
		                                        <ul class="nav nav-tabs">
	                                                <li class="nav-item">
	                                                    <a href="#sugg-plan-tab" data-toggle="tab" aria-expanded="true" class="nav-link active">
	                                                        <i class="fa fa-info"> </i> Suggestion
	                                                    </a>
	                                                </li>
	                                                <li class="nav-item">
	                                                    <a href="#skills-plan-tab" data-toggle="tab" aria-expanded="false" class="nav-link">
	                                                        <i class="mdi mdi-hexagon-outline mr-2"></i>Skills
	                                                    </a>
	                                                </li>
	                                                <li class="nav-item">
	                                                    <a href="#physical-plan-tab" data-toggle="tab" aria-expanded="false" class="nav-link">
	                                                        <i class="mdi mdi-human mr-2"></i>Physical
	                                                    </a>
	                                                </li>
	                                            </ul>
                                            	<div class="tab-content" style="padding: 0">
					                            	<div class="tab-pane" id="skills-plan-tab">
					                            		<div class="plan-content">
		                                        			<div class="card-box ribbon-box">
		                                        				<div class="ribbon ribbon-danger">
			                                                		<span>Skill AVG</span>
			                                                	</div>
		                                                   	 	<canvas id="classSkills" height="350" class=""></canvas>
		                                                	</div>
		                                                </div>
	                                                </div>
                                                	<div class="tab-pane" id="physical-plan-tab">
	                                                	<div class="plan-content">
	                                                		<div class="card-box ribbon-box">
	                                                			<div class="ribbon ribbon-purple">
		                                                			<span>Physical AVG</span>
		                                                		</div>
	                                                   		 	<canvas id="classPhysical" height="350" class=""></canvas>
	                                                		</div>
	                                                	</div>
                                                	</div>
                                                	<div class="tab-pane show active" id="sugg-plan-tab">
	                                                	<div class="plan-content">
	                                                	
		                                                	<div id="suggestion" class="card-box text-primary ribbon-box">
		                                                		<div class="ribbon ribbon-primary">
		                                                			<span>SUGGESTION</span>
		                                                		</div><br><br>
		                                                	<!-- <strong>Suggestion:</strong><br> -->
		                                                	</div>
	                                                	</div>
                                                	</div>
                                                </div>
                                            </div> 
                                            

		                                    <ul class="sortable-list taskList list-unstyled" id="upcoming">
		                                        <!-- student brief info template -->
		                                        <c:forEach var="stu" items="${classInfo.students }">
		                                        <li class="" id="task1">
		                                            <div class="clearfix"></div>
		                                            <div class="">
		                                                <p class="pull-right mb-0 mt-2">
		                                                    <button type="button" class="btn btn-custom btn-sm waves-effect waves-light btn-evaluate" data-studentId="${stu.id }" data-studentName="${stu.name }" data-toggle="modal" data-toggle="modal" data-target="#evaluateModal" >Evaluate</button>
		                                                </p>
		                                                <p class="mb-0"><a href="${pageContext.request.contextPath }/rest/common/showStu?id=${stu.id}" class="text-muted"><img src="http://image.vport.com/${stu.icon }" alt="task-user" class="thumb-sm rounded-circle mr-2"> <span class="font-bold font-secondary">${stu.name }</span></a> </p>
		                                            </div>
		                                        </li>
		                                        </c:forEach>
		                                        <!-- end template -->
		                                    </ul>
                                    
                                            
                                        </div>
                                    </div>
                                </div>
                                <div class="card bg-transparent">
                                    <div class="card-header b-r-30 listgroup-title" role="tab" id="headingThree">
                                        <h5 class="mb-0 mt-0">
                                            <a>
                                                	　FUTURE PLAN
                                            </a>
                                        </h5>
                                        <a><i class="mdi mdi-chevron-down listgroup-collapse"data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="true" aria-controls="collapseThree"></i></a>
                                    </div>
                                    <div id="collapseThree" class="collaps show" role="tabpanel" aria-labelledby="headingThree">
                                        <div class="card-body plan-box" >
                                            <!-- plan brief info template  trainingDate-->
                                            <c:forEach var="plan" items="${classInfo.futurePlans }">
                                            <div class="class-box">
                                                <div class="class-box-header">
                                                    <h5><i class="mdi mdi-bullseye"></i> ${plan.trainingDate }</h5>
                                                    <p class="class-box-time">${classInfo.place }</p>
                                                </div>
                                                <div class="class-box-body">
                                                    <p> ${plan.trainingDate }</p>
                                                    <a href="${pageContext.request.contextPath }/rest/course/toEachPlan?id=${plan.id}" class=""><button class="btn btn-outline-custom btn-rounded waves-light waves-effect">View</button></a>
                                                </div>
                                            </div>
                                            </c:forEach>
                                            <!-- end template -->
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
                                            <c:forEach var="plan" items="${classInfo.plansHistory }">
                                            <div class="class-box">
                                                <div class="class-box-header">
                                                    <h5><i class="mdi mdi-bullseye"></i> ${plan.trainingDate }</h5>
                                                    <p class="class-box-time">${classInfo.place }</p>
                                                </div>
                                                <div class="class-box-body">
                                                    <p> ${plan.trainingDate }</p>
                                                    <a href="${pageContext.request.contextPath }/rest/course/toEachPlan?id=${plan.id}" class=""><button class="btn btn-outline-custom btn-rounded waves-light waves-effect">View</button></a>
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
			<div id="evaluateModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="myModalLabel">Evaluate to Alex</h4>
                        </div>
                        <div class="modal-body">
                            <ul class="nav nav-pills navtab-bg nav-justified pull-in ">
                                <li class="nav-item">
                                        <a href="#commenttab" data-toggle="tab" aria-expanded="false" class="nav-link active">
                                            <i class="mdi mdi-comment-outline mr-2"></i>Comment
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="#skillstab" data-toggle="tab" aria-expanded="false" class="nav-link">
                                            <i class="mdi mdi-hexagon-outline mr-2"></i>Skills
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="#physicaltab" data-toggle="tab" aria-expanded="true" class="nav-link">
                                            <i class="mdi mdi-human mr-2"></i>Physical
                                        </a>
                                    </li>
                                </ul>
                            <form id="eval-form" class="form-horizontal" role="form" method="post">
                            	<input id="studentId" type="hidden" name="player" value="">
                            	<input type="hidden" name="trainer" value=${existUser.id }>
                                <label class="col-form-label">Comments</label>
                                <div class="input-group">
                                    <textarea class="form-control" rows="1" placeholder="" name="comment"></textarea>
                                </div>
                                <div class="tab-content">
                                    <div class="tab-pane" id="skillstab">
                                        <div class="form-group">
                                            <label class="col-form-label">Front Hand</label>
                                            <input type="hidden" name="performanceContents[0].contentId" value="1">
                                            <input type="number" class="form-control" placeholder="0-5" min="0" max="5" name="performanceContents[0].count">
                                        </div>
                                        <div class="form-group">
                                            <label class="col-form-label">Back Hand</label>
                                            <input type="hidden" name="performanceContents[1].contentId" value="2">
                                            <input type="number" class="form-control" placeholder="0-5" min="0" max="5" name="performanceContents[1].count">
                                        </div>
                                        <div class="form-group">
                                            <label class="col-form-label">Front Volley</label>
                                            <input type="hidden" name="performanceContents[2].contentId" value="3">
                                            <input type="number" class="form-control" placeholder="0-5" min="0" max="5" name="performanceContents[2].count">
                                        </div>
                                        <div class="form-group">
                                            <label class="col-form-label">Back Volley</label>
                                            <input type="hidden" name="performanceContents[3].contentId" value="4">
                                            <input type="number" class="form-control" placeholder="0-5" min="0" max="5" name="performanceContents[3].count">
                                        </div>
                                        <div class="form-group">
                                            <label class="col-form-label">Smash</label>
                                            <input type="hidden" name="performanceContents[4].contentId" value="5">
                                            <input type="number" class="form-control" placeholder="0-5" min="0" max="5" name="performanceContents[4].count">
                                        </div>
                                        <div class="form-group">
                                            <label class="col-form-label">Serve</label>
                                            <input type="hidden" name="performanceContents[5].contentId" value="6">
                                            <input type="number" class="form-control" placeholder="0-5" min="0" max="5" name="performanceContents[5].count">
                                        </div>
                                    </div>
                                    <div class="tab-pane" id="physicaltab">
                                        <div class="form-group">
                                            <label class="col-form-label">Speed</label>
                                            <input type="hidden" name="performanceContents[6].contentId" value="7">
                                            <input type="number" class="form-control" placeholder="0-5" min="0" max="5" name="performanceContents[6].count">
                                        </div>
                                        <div class="form-group">
                                            <label class="col-form-label">Strength</label>
                                            <input type="hidden" name="performanceContents[7].contentId" value="8">
                                            <input type="number" class="form-control" placeholder="0-5" min="0" max="5" name="performanceContents[7].count">
                                        </div>
                                        <div class="form-group">
                                            <label class="col-form-label">Explosive Force</label>
                                            <input type="hidden" name="performanceContents[8].contentId" value="9">
                                            <input type="number" class="form-control" placeholder="0-5" min="0" max="5" name="performanceContents[8].count">
                                        </div>
                                        <div class="form-group">
                                            <label class="col-form-label">Flexibility</label>
                                            <input type="hidden" name="performanceContents[9].contentId" value="10">
                                            <input type="number" class="form-control" placeholder="0-5" min="0" max="5" name="performanceContents[9].count">
                                        </div>
                                        <div class="form-group">
                                            <label class="col-form-label">Coordination</label>
                                            <input type="hidden" name="performanceContents[10].contentId" value="11">
                                            <input type="number" class="form-control" placeholder="0-5" min="0" max="5" name="performanceContents[10].count">
                                        </div>
                                    </div>
                                    <div class="tab-pane" id="commenttab">
                                        
                                    </div>
                                </div>                      
                            </form>
                        </div>
                        
                        <div class="modal-footer">
	                        <div id="alertInfo" class="alert alert-danger mt-4" style="display: none">
	                    	</div>
                            <button type="button" class="btn btn-light waves-effect" data-dismiss="modal">Close</button>
                            <button id="submit" type="button" class="btn btn-custom waves-effect waves-light">Save</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div>
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
    
    <!-- Chart JS -->
    <script src="${pageContext.request.contextPath }/plugins/chart.js/chart.bundle.js"></script>
    <script src="${pageContext.request.contextPath }/assets/pages/jquery.chartjs.init.js"></script>

    <!-- Modal-Effect -->
    <script src="${pageContext.request.contextPath }/plugins/custombox/js/custombox.min.js"></script>
    <script src="${pageContext.request.contextPath }/plugins/custombox/js/legacy.min.js"></script>
    <script type="text/javascript">
    	/*
    		1.绑定evaluate点击事件
    		2.判断是否与上一次一直，如果不一致，清空form里面所有的value
    		3.注入新的学生id和name
    	*/
    	$(".btn-evaluate").click(function(){
    		var origStuId = $("#studentId").val();
    		var newStuId = $(this).attr("data-studentId");
    		if(origStuId != newStuId){
    			$("#myModalLabel").text("Evaluate to "+$(this).attr("data-studentName"));
    			$("#eval-form textarea,#eval-form div input[type=number]").val(null);
    			$("#studentId").val(newStuId);
    			
    		}
    	});
    	
    	$("#submit").click(function(){
    		var form = $('#eval-form').formGet();
    		console.log(form); 
    		var myarr = new Array();
    		var per = {};
    		var isValid = true;
    		for(var o in form){
    			if(o.startWith("performanceContents")){
    				if(form[o].count == ''){
    					isValid = false
    				}
    				myarr.push(form[o]);
    			}else{
    				per[o] = form[o];
    			}
    		}
    		per["performanceContents"] = myarr;
    		if(isValid){
    			$.ajax({
    			url:"${pageContext.request.contextPath}/rest/performance/storeEvaluateData",
    			type:"post",
    			contentType: "application/json",
    			data:JSON.stringify(per),
    			success:function(res){
    				if(res == 1){
    					$("#eval-form textarea,#eval-form div input[type=number]").val(null);
    					$("#studentId").val(null);
    					$("#evaluateModal .close").click();
    				}
    			}
    		}); 
    		} else{
    			$("#alertInfo").html("Content Missing!");
        		$("#alertInfo").show();
                setTimeout(function () {
                    $("#alertInfo").hide();
                },3000);
    		}
    		
    	});
    
    	/*-------------------------*/
    	String.prototype.startWith=function(str){
			var reg=new RegExp("^"+str);
			return reg.test(this);
			}
    	/*-------------------------*/
    	var _fnObjectGetPropertyChainValue = function(obj, propertyChain) {
	      /* 获取属性链的值 */
	      if (!obj) return;
	      if (!propertyChain) return obj;
	      var property,
	        chains = propertyChain.split('.'),
	        i = 0,
	        len = chains.length;
	      for (;
	        (property = chains[i]) && i < len - 1; i++) {
	        if (!obj[property]) return;
	        obj = obj[property];
	      }
	      return obj[property];
	    },
	    _fnObjectSetPropertyChainValue = function(obj, propertyChain, value, allowMulti) {
	      /* 设置属性链的值 */
	      if (!obj || !propertyChain) return;
	      var property,
	        chainObj = obj,
	        chains = propertyChain.split('.'),
	        i = 0,
	        len = chains.length;
	      for (;
	        (property = chains[i]) && i < len - 1; i++) {
	        if (!chainObj[property]) {
	          chainObj[property] = {};
	        }
	        chainObj = chainObj[property];
	      }
	      // 改进版：checkbox的多选可以组合为数组
	      if (!allowMulti || chainObj[property] === undefined) {
	        chainObj[property] = value;
	      } else {
	        var pv = chainObj[property];
	        if ($.isArray(pv)) {
	          pv.push(value);
	        } else {
	          chainObj[property] = [pv, value];
	        }
	      }
	      return obj;
	    };
	 
	 
	 
	 /**
	     * jQuery form 扩展获取数据
	     */
	  $.fn.formGet = function(opts) {
	    opts = $.extend({}, opts);
	    var data = {},
	      els = opts.formGroup ? this.find('[form-group="' + opts.formGroup + '"]') : this.find('[name]');
	    if (!els || !els.length) {
	      return data;
	    }
	 
	 
	    var fnSetValue = (function(emptyToNull) {
	      return emptyToNull ? function(obj, propertyChain, value, allowMulti) {
	        value !== '' && _fnObjectSetPropertyChainValue(obj, propertyChain, value, allowMulti)
	      } : _fnObjectSetPropertyChainValue
	    })(opts.emptyToNull);
	 
	 
	    els.each(function() {
	      var $this = $(this),
	        type = $this.attr('type'),
	        name = $this.attr('name'), // 可能为属性链
	        tag = this.tagName.toLowerCase();
	      if (tag == 'input') {
	        if (type == 'checkbox') {
	          var v = $(this).val();
	          if (v == 'on' || !v) {
	            fnSetValue(data, name, $(this).prop('checked'));
	          } else {
	            $(this).prop('checked') && fnSetValue(data, name, v, true);
	          }
	        } else if (type == 'radio') {
	          this.checked && fnSetValue(data, name, $this.val());
	        } else {
	          fnSetValue(data, name, $this.val());
	        }
	      } else if ('|select|textarea|'.indexOf('|' + tag + '|') > -1) {
	        fnSetValue(data, name, $this.val());
	      } else {
	        fnSetValue(data, name, $.trim($this.text()));
	      }
	    });
	    return data;
	  };
	 
	 
	 
	 
	 
	 
	 
	 
	 
	  /**
	     * jQuery form 扩展绑定数据
	     * 
	     */
	  $.fn.formSet = function(data, formGroup) {
	    var els = formGroup ? this.find('[form-group="' + formGroup + '"]') : this.find('[name]');
	    if (!els || !els.length) {
	      return this;
	    }
	 
	 
	 
	    els.each(function() {
	      var $this = $(this),
	        type = $this.attr('type'),
	        name = $this.attr('name'),
	        tag = this.tagName.toLowerCase();
	 
	 
	      var value = _fnObjectGetPropertyChainValue(data, name);
	      if (tag == 'input') {
	        if (type == 'checkbox') {
	          var v = $(this).val();
	          if (v == 'on' || !v) {
	            this.checked = value ? 'checked' : '';
	          } else {
	            this.checked = $.isArray(value) && value.indexOf(v) > -1 ? 'checked' : ''
	          }
	        } else if (type == 'radio') {
	          this.checked = $this.val() == String(value) ? 'checked' : '';
	        } else {
	          $this.val(value);
	        }
	      } else if ('|select|textarea|'.indexOf('|' + tag + '|') > -1) {
	        $this.val(value);
	      } else {
	        $this.html(value);
	      }
	    });
	    return this;
	  }
    </script>
    

</body>
</html>