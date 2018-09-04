<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>LoginPage</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css">
    <script src="${pageContext.request.contextPath }/js/jquery-3.3.1.js"></script>

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

<section class="login-signup">
    <form id="form1" action="" class="login-form" method="post">
        <article class="logbt">Log in</article>
        <article class="signbt">Sign up</article>
        <div class="error" id="error-email1"></div>
        <input type="email" name="email" placeholder="Email" required>
        <span class="error" id="error-password"></span>
        <input type="password" name="password" placeholder="Password" required pattern=".*[A-Z].*">
        <input type="button" class="button" value="Submit">
    </form>
    <form action="${pageContext.request.contextPath }/rest/customer/register" class="signup-form" method="post">
        <article class="logbt">Log in</article>
        <article class="signbt">Sign up</article>
        <span class="error" id="error-email2"></span>
        <input type="email" name="email" placeholder="Email" required>
        <span class="error" id="error-password"></span>
        <input type="password" name="password" placeholder="Password" required pattern=".*[A-Z].*">
        <input type="text" name="username" placeholder="Username" required>
        <div class="gender">
            <div class="gender1">
                <input id="gender1" type="radio" name="gender" value="1" required>
                <label for="gender1">Male</label>
            </div>
            <div class="gender2">
                <input id="gender2" type="radio" name="gender" value="0" required>
                <label for="gender2">Female</label>
            </div>
        </div>
        <div class="user-type">
            <div class="type1">
                <input id="type1" type="radio" name="type" value="2">
                <label for="type1">Student</label>
            </div>
            <div class="type2">
                <input id="type2" type="radio" name="type" value="1">
                <label for="type2">Trainer</label>
            </div>
        </div>
        <input type="submit" class="button" value="Submit">
        
    </form>
</section>

<script>

    $("input[name=email]").on('invalid',function () {
        this.setCustomValidity("Please enter the correct email");
    });
    $("input[name=password]").on('invalid',function () {
        this.setCustomValidity("Please enter the correct password");
    });
    $("input[name=username]").on('invalid',function () {
        this.setCustomValidity("Please enter the username");
    });
    /*change log in or sign up*/
    $(".logbt").on('click', function () {
        $(".login-form").css("display", "block");
        $(".signup-form").css("display", "none");
    })
    $(".signbt").on('click', function () {
        $(".login-form").css("display", "none");
        $(".signup-form").css("display", "block");
    })

    /*validate information*/
    $(".signup-form input[name=email]").on('blur',function () {
    	var $value = $(this).val();
    	if($value != ""){
	        $.post("${pageContext.request.contextPath }/rest/user/checkEmail", {"email":$value}, function (res) {
	        	
	            if (res == 1) {
	                $("#error-email2").text("The email has been registered");
	                $("#error-email2").css("display", "block");
	                setTimeout(function () {
	                    $("#error-email2").css("display", "none");
	                }, 2000)
	                $(".signup-form input[type=submit]").attr("disabled", true);
	            }else{
	            	$(".signup-form input[type=submit]").attr("disabled", false);
	            }
	        })
    	}
    })
    

    $(".login-form .button").click(function () {
    	var form = new FormData(document.getElementById("form1"));
       $.ajax({
            url:'${pageContext.request.contextPath }/rest/customer/login',
            type: 'post',
            data:form,
            dataType: 'json',
            contentType:false,
            processData:false,
            success: function(res) {
            	if (res == 1) {
                    $("#error-email1").text("wrong email.");
                    $("#error-email1").css("display", "block");
                    setTimeout(function () {
                        $("#error-email1").css("display", "none");
                    }, 2000)
                } else if (res == 2) {
                	alert(res);
                    $("#error-password").text("wrong password.");
                    $("#error-password").css("display", "block");
                    setTimeout(function () {
                        $("#error-password").css("display", "none");
                    }, 2000)
                }else if (res == 3) {
                	$("#error-email1").text("you have not activated your account");
                    $("#error-email1").css("display", "block");
                    setTimeout(function () {
                        $("#error-email1").css("display", "none");
                    }, 2000)
                }else{
                	window.location.href="${pageContext.request.contextPath}/rest/page/success";
                }
            }
        })
    })

/*     $(".signup-form .button").click(function () {
        $.ajax({
            url:'',
            type: 'post',
            data:$('.signup-form').serialize(),
            dataType: 'json',
            success: function(res) {
                alert(res);
                
            }
        })
    }) */
</script>
</body>
</html>