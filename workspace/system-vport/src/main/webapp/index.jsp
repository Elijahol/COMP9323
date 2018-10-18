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

    <jsp:forward page="rest/page/login" ></jsp:forward>



    

</body>
</html>