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
    <!-- Plugins css-->
    <link href="${pageContext.request.contextPath }/plugins/bootstrap-tagsinput/css/bootstrap-tagsinput.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath }/plugins/bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath }/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/switchery/switchery.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/bootstrap-select/css/bootstrap-select.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/plan.css">
    <script src="${pageContext.request.contextPath }/plugins/bootstrap-select/js/bootstrap-select.min.js"></script>
    <script src="${pageContext.request.contextPath }/plugins/switchery/switchery.min.js"></script>

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

                    <div class="row">
                        <div class="col-lg-12">
                            <div id="accordion" role="card-box" aria-multiselectable="true" class="m-b-30">

                                    <ul class="nav nav-pills navtab-bg nav-justified pull-in ">
                                            <li class="nav-item">
                                                <a href="#skills-plan-tab" data-toggle="tab" aria-expanded="true" class="nav-link active">
                                                    <i class="mdi mdi-hexagon-outline mr-2"></i>Skills
                                                </a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="#physical-plan-tab" data-toggle="tab" aria-expanded="false" class="nav-link">
                                                    <i class="mdi mdi-human mr-2"></i>Physical
                                                </a>
                                            </li>
                                    </ul>
                                <div class="modal-body">
                                    <select id="plan-select-content" class="custom-select">
                                        <option selected disabled="">Select a training time</option>
                                    </select>
                                </div>
                                <!--<form class="form-horizontal" role="form">-->
                                        <div class="tab-content">
                                            <!--技术部分-->
                                            <div class="tab-pane show active" id="skills-plan-tab">
                                                <!-- multiple level plans -->
                                                <div id="skillCat" role="tablist" aria-multiselectable="true" class="m-b-30">
                                                    <div class="card">
                                                        <div class="plan-content">
                                                            <a data-toggle="collapse" data-parent="#skillCat" href="#skillCat0" class="text-dark" aria-expanded="true" aria-controls="skillCat0">
                                                                <div class="card-header" role="tab">
                                                                    <h5 class="mb-0 mt-0" name="0">Stalemate Area</h5>
                                                                </div>
                                                            </a>
                                                            <div id="skillCat0" class="collapse" role="tabpanel" aria-labelledby="headingOne1">
                                                                <div class="card-body">
                                                                    <div class="select">
                                                                        <div class="btn-group" data-toggle="buttons">
                                                                        </div>
                                                                        <button class="btn btn-custom btn-addcourse" style="margin-bottom: 10px;">Add</button>
                                                                    </div>
                                                                    <div class="clearfix"></div>

                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="plan-content">
                                                            <a data-toggle="collapse" data-parent="#skillCat" href="#skillCat1" class="text-dark" aria-expanded="true" aria-controls="skillCat1">
                                                                <div class="card-header" role="tab">
                                                                    <h5 class="mb-0 mt-0" name="1">Oppression Area</h5>
                                                                </div>
                                                            </a>
                                                            <div id="skillCat1" class="collapse" role="tabpanel" aria-labelledby="headingOne1">
                                                                <div class="card-body">
                                                                    <div class="select">
                                                                        <div class="btn-group" data-toggle="buttons">
                                                                        </div>
                                                                        <button class="btn btn-custom btn-addcourse" style="margin-bottom: 10px;">Add</button>
                                                                    </div>
                                                                    <div class="clearfix"></div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="plan-content">
                                                            <a data-toggle="collapse" data-parent="#skillCat" href="#skillCat2" class="text-dark" aria-expanded="true" aria-controls="skillCat2">
                                                                <div class="card-header" role="tab">
                                                                    <h5 class="mb-0 mt-0" name="2">Score Area</h5>
                                                                </div>
                                                            </a>
                                                            <div id="skillCat2" class="collapse" role="tabpanel" aria-labelledby="headingOne1">
                                                                <div class="card-body">
                                                                    <div class="select">
                                                                        <div class="btn-group" data-toggle="buttons">
                                                                        </div>
                                                                        <button class="btn btn-custom btn-addcourse" style="margin-bottom: 10px;">Add</button>
                                                                    </div>
                                                                    <div class="clearfix"></div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="plan-content">
                                                            <a data-toggle="collapse" data-parent="#skillCat" href="#skillCat3" class="text-dark" aria-expanded="true" aria-controls="skillCat3">
                                                                <div class="card-header" role="tab">
                                                                    <h5 class="mb-0 mt-0" name="3">Out-side Area</h5>
                                                                </div>
                                                            </a>
                                                            <div id="skillCat3" class="collapse" role="tabpanel" aria-labelledby="headingOne1">
                                                                <div class="card-body">
                                                                    <div class="select">
                                                                        <div class="btn-group" data-toggle="buttons">
                                                                        </div>
                                                                        <button class="btn btn-custom btn-addcourse" style="margin-bottom: 10px;">Add</button>
                                                                    </div>
                                                                    <div class="clearfix"></div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="plan-content">
                                                            <a data-toggle="collapse" data-parent="#skillCat" href="#skillCat4" class="text-dark" aria-expanded="true" aria-controls="skillCat4">
                                                                <div class="card-header" role="tab">
                                                                    <h5 class="mb-0 mt-0" name="4">Serving Area</h5>
                                                                </div>
                                                            </a>
                                                            <div id="skillCat4" class="collapse" role="tabpanel" aria-labelledby="headingOne1">
                                                                <div class="card-body">
                                                                    <div class="select">
                                                                        <div class="btn-group" data-toggle="buttons">
                                                                        </div>
                                                                        <button class="btn btn-custom btn-addcourse" style="margin-bottom: 10px;">Add</button>
                                                                    </div>
                                                                    <div class="clearfix"></div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <!--体能部分-->
                                            <div class="tab-pane" id="physical-plan-tab">
                                                <div id="physicalCat" role="tablist" aria-multiselectable="true" class="m-b-30">
                                                    <div class="card">
                                                        <div class="physical-content">
                                                            <a data-toggle="collapse" data-parent="#skillCat" href="#physicalCat0" class="text-dark" aria-expanded="true" aria-controls="physicalCat0">
                                                                <div class="card-header" role="tab">
                                                                    <h5 class="mb-0 mt-0" name="0">Warm Up</h5>
                                                                </div>
                                                            </a>
                                                            <div id="physicalCat0" class="collapse" role="tabpanel" aria-labelledby="headingOne1">
                                                                <div class="card-body">
                                                                    <div class="select">
                                                                        <div class="btn-group" data-toggle="buttons">
                                                                        </div>
                                                                        <button class="btn btn-custom btn-addPhysical" style="margin-bottom: 10px;">Add</button>
                                                                    </div>
                                                                    <div class="clearfix"></div>

                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="physical-content">
                                                            <a data-toggle="collapse" data-parent="#skillCat" href="#physicalCat1" class="text-dark" aria-expanded="true" aria-controls="physicalCat1">
                                                                <div class="card-header" role="tab">
                                                                    <h5 class="mb-0 mt-0" name="1">Specialized Training</h5>
                                                                </div>
                                                            </a>
                                                            <div id="physicalCat1" class="collapse" role="tabpanel" aria-labelledby="headingOne1">
                                                                <div class="card-body" style="padding: 10px">

                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="physical-content">
                                                            <a data-toggle="collapse" data-parent="#skillCat" href="#physicalCat2" class="text-dark" aria-expanded="true" aria-controls="physicalCat2">
                                                                <div class="card-header" role="tab">
                                                                    <h5 class="mb-0 mt-0" name="2">Relaxation</h5>
                                                                </div>
                                                            </a>
                                                            <div id="physicalCat2" class="collapse" role="tabpanel" aria-labelledby="headingOne1">
                                                                <div class="card-body">
                                                                    <div class="select">
                                                                        <div class="btn-group" data-toggle="buttons">
                                                                        </div>
                                                                        <button class="btn btn-custom btn-addPhysical" style="margin-bottom: 10px;">Add</button>
                                                                    </div>
                                                                    <div class="clearfix"></div>

                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tab-pane" id="commenttab">
                                            </div>
                                        </div>                      
                                    <!--</form>-->
                                
                            </div>
                        </div>
                    </div>
                    <!-- end row -->
                    <div id="alertInfo" class="alert alert-danger mt-4" style="display: none">
                        
                    </div>
                    <button id="submitBtn" type="button" class="btn btn-primary" style="float: right">Submit</button>
                </div> <!-- container -->

            </div> <!-- content -->

            <footer class="footer text-right">
                <p class="">2018 © Vport. - vport.com.au</p>
                <input id="classId" type="hidden" value="${classId }">
                <input id="chiefTrainer" type="hidden" value="${chiefTrainer }">
            </footer>

        </div>

        <div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title" id="myModalLabel">Modal Heading</h4>
                    </div>
                    <input type="hidden" name="typeOfSkill">
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-form-label">Non-Limited Time</label>
                            <input name="isLimitedTime" value="Non-Limited Time" type="checkbox" class="js-switch js-check-click"/>
                        	<label class="col-form-label">Limited Time</label>
                        </div>
                        <div class="form-group">
                            <label class="col-form-label">Non-Continuous</label>
                            <input name="isContinuous" value="Non-Continuous" type="checkbox" class="js-switch js-check-click"/>
                        	<label class="col-form-label">Continuous</label>
                        </div>
                        <div class="form-group">
                            <label class="col-form-label">Position Fixed</label>
                            <input name="isMoved" value="Fixed" type="checkbox" class="js-switch js-check-click"/>
                        	<label class="col-form-label">Position Change</label>
                        </div>
                        <div class="form-group">
                            <label class="col-form-label">Bandy Bout</label>
                            <input name="isMultiple" value="Bandy" type="checkbox" class="js-switch js-check-click"/>
                        	<label class="col-form-label">Multi-ball Training</label>
                        </div>
                        <div class="form-group">
                            <label class="col-form-label">Non-Target</label>
                            <input name="isTarget" value="Non-Target" type="checkbox" class="js-switch js-check-click"/>
                        	<label class="col-form-label">Target</label>
                        </div>
                        <div class="form-group">
                            <label class="col-form-label">Group Number</label>
                            <input name="groupNum" type="number" class="form-control" placeholder="0-100" min="0" max="100">
                        </div>
                        <div class="form-group">
                            <label class="col-form-label">Number of Group</label>
                            <input name="countNumOfGroup" type="number" class="form-control" placeholder="0-100" min="0" max="100">
                        </div>
                        <div id="requiredTime" class="form-group" style="display: none;">
                            <label class="col-form-label">Required Time</label>
                            <input name="requiredTime" type="number" class="form-control" placeholder="0-100" min="0" max="100">
                        </div>
                        <div id="numberSuccess" class="form-group" style="display: none;">
                            <label class="col-form-label">Number of Success</label>
                            <input name="numOfSuccess" type="number" class="form-control" placeholder="0-100" min="0" max="100">
                        </div>
                        <div class="form-group">
                            <label class="col-form-label">Type</label>
                            <div class="radio radio-danger">
                                <input id="radio1" name="isCombined" type="radio" checked value="Front Hand"/>
                                <label for="radio1" style="margin-right: 12px;">Front Hand</label>
                                <input id="radio2" name="isCombined" type="radio" class="radio-danger" value="Back Hand"/>
                                <label for="radio2" style="margin-right: 12px;">Back Hand</label>
                                <input id="radio3" name="isCombined" type="radio" class="radio-danger" value="Combine"/>
                                <label for="radio3">Combination</label>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-light waves-effect" data-dismiss="modal">Close</button>
                        <button id="storeDataBtn" type="button" class="btn btn-primary waves-effect waves-light">Confirm</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
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
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/pages/jquery.form-advanced.init.js"></script>

    <!-- Modal-Effect -->
    <script src="${pageContext.request.contextPath }/plugins/custombox/js/custombox.min.js"></script>
    <script src="${pageContext.request.contextPath }/plugins/custombox/js/legacy.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/plan.js"></script>
</                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              