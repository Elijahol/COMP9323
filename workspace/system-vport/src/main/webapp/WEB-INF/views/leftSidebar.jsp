<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
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
                <img src="http://image.vport.com/${existUser.icon }" alt="user-img" title="Mat Helme" class="rounded-circle img-fluid">
            </div>
            <!-- user name -->
            <h5><a href="#">${existUser.name }</a> </h5>
        </div>

        <!--- Sidemenu -->
        <div id="sidebar-menu">

            <ul class="metismenu" id="side-menu">
                <li>
                	<c:if test="${existUser.role == 1 }">
                    <a href="${pageContext.request.contextPath }/rest/page/trainerMain">
                        <i class="fi-air-play"></i><span> Home </span>
                    </a>
                    </c:if>
                    <c:if test="${existUser.role == 2 }">
                    <a href="${pageContext.request.contextPath }/rest/page/studentMain">
                        <i class="fi-air-play"></i><span> Home </span>
                    </a>
                    </c:if>
                </li>

                <li>
                    <a href="javascript: void(0);"><i class="fi-layers"></i> <span> Courses </span>
                    </a>
                </li>
                <c:if test="${existUser.role == 2 }">
                <li>
                    <a href="javascript: void(0);"><i class="fi-bar-graph-2"></i> <span> Data Center </span></a>
                </li>
                </c:if>
                <li>
                    <a href="javascript: void(0);"><i class="fi-paper"></i> <span> Profile </span></a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath }/rest/user/logout"><i class="fi-disc"></i><span class="badge badge-info pull-right">10</span> <span> Log out </span></a>
                </li>
            </ul>

        </div>
        <!-- Sidebar -->

        <div class="clearfix"></div>

    </div>
    <!-- Sidebar -left -->

</div>
<!-- Left Sidebar End -->