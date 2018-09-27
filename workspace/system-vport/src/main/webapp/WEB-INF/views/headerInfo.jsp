<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<div class="row m-t-50">
    <div class="col-12">
        <div class="card-box user-box-2" style="background-image: url(http://image.vport.com/${user.icon });">
		    <div class="mask">
		        <img src="http://image.vport.com/${user.icon }" alt="">
		    	<div class="user-name">
		        	<h4>${user.name } <i class=""></i></h4>
		    	</div>
		    
		    <!-- if edit the profile -->
		    <p><i class="mdi mdi-map-marker-outline"></i> ${user.email }</p>
		    <c:if test="${user.id == existUser.id }">
		    <button class="btn btn-outline-custom btn-rounded waves-light waves-effect"  data-toggle="modal" data-target="#myModal">Edit</button>
			</c:if>
		    </div>
		    
		    <!-- else if view this profile -->
		    <!-- <a href="dataCenter.html"><button class="btn btn-outline-custom btn-rounded waves-light waves-effect">More</button></a> -->
		    <!-- end if -->
		
		    
		</div>
        <div class="user-data-box">
            <div class="user-data">
                <h6>${user.age }</h6>
                <p>Age</p>
            </div>
            <div class="user-data">
                <h6>${user.weight }</h6>
                <p>KG</p>
            </div>
            <div class="user-data">
                <h6>${user.height }</h6>
                <p>CM</p>
            </div>
        </div>
    </div>
</div>
