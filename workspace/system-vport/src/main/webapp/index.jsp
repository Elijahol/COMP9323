<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Vport</title>
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/main.css">

    <!--[if lte IE 8]-->
    <script src="js/html5shiv.js"></script>
    <!--[end if]-->


    <!--<script>-->
        <!--$(function () {-->
            <!--$(".training-block a").mouseenter(function () {-->

                <!--$(this).stop();-->
                <!--var json = {"top": -2,-->
                    <!--"left": -6,-->
                    <!--"width": 367,-->
                    <!--"height": 214};-->
                <!--$(this).animate(json,200);-->
            <!--})-->
            <!--$(".training-block a").mouseleave(function () {-->
                <!--$(this).stop();-->
                <!--var json = {-->
                    <!--"width": 355,-->
                    <!--"height": 205,-->
                    <!--"top": +2,-->
                    <!--"left": +1,};-->
                <!--$(this).animate(json,200);-->
            <!--})-->
            <!--var color = null;-->
            <!--$(".view-course-icon").mouseenter(function () {-->
                <!--var viewCourse = $(".view-course");-->
                <!--viewCourse.animate({"left":8},300);-->
                <!--color = viewCourse.css("color");-->
                <!--viewCourse.css("color", "grey");-->
            <!--})-->
            <!--$(".view-course-icon").mouseleave(function () {-->
                <!--var viewCourse = $(".view-course");-->
                <!--viewCourse.animate({"left":0},300);-->
                <!--viewCourse.css("color",color);-->
            <!--})-->
        <!--})-->

    <!--</script>-->
</head>
<body>
<!--导航-->
<nav class="vport-nav">
    <a href="#" class="logo"></a>
    <div class="wrapper">

        <ul>
            <li><a href="#">Tennis Course</a></li>
            <li><a href="#">Shopping</a></li>
            <li><a href="#">News</a></li>
            <li><a href="${pageContext.request.contextPath }/rest/page/login">Sign up</a></li>
            <li><a href="${pageContext.request.contextPath }/rest/page/login">Log in </a></li>
        </ul>
    </div>
</nav>
<div class="video-controls">
    <video src="video/Wilson%20Tennis%20_%20From%20Federer-PU5h2qxmOGk.webm" autoplay muted loop></video>
    <div class="slogon">
        <h1>Training, as you wish.</h1>
    </div>
</div>
<!--展示-->
<section class="vport-content">
    <div class="para">
        <div class="para-title">Professtional plan & Scientific advise<br>
        </div>
        <div class="para-content">Designed for different ages, optimized by the new approach to the individual customization.</div>
    </div>
    <div class="bg" data-stellar-background-ratio="0.1">
        <div class="training-inner">
            <ul class="training-block">
                <li><a href="#" class="teenager">
                    <div class="training-detail">
                        <div class="training-title">Teenager</div>
                        <div class="training-population"></div>
                    </div>
                </a></li>
                <li><a href="#" class="adult">
                    <div class="training-detail">
                        <div class="training-title">Adult</div>
                        <div class="training-population"></div>
                    </div>
                </a></li>
                <li><a href="#" class="customization">
                    <div class="training-detail">
                        <div class="training-title">Customization</div>
                        <div class="training-population"></div>
                    </div>
                </a></li>
            </ul>
            <div class="view-course-icon">
                <span class="view-course">Courses</span>
                <span class="arrow">></span>
            </div>
        </div>
    </div>
</section>
 <!--底部-->
<footer class="vport-footer"></footer>
<script src="js/jquery-3.3.1.js"></script>
<script src="js/jquery.stellar.js"></script>
<script src="js/index.js"></script>
</body>
</html>