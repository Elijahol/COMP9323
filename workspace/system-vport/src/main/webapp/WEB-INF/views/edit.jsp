<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 上传图片是需要指定属性 enctype="multipart/form-data" -->
	<!-- <form id="itemForm" action="" method="post" enctype="multipart/form-data"> -->
	<form id="itemForm"	action="${pageContext.request.contextPath }/rest/user/edit" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${user.id }" /> 修改商品信息：
		<table width="100%" border=1>
		<!-- private String name;
    private String password;
    private String email;
    private String phone;
    private Date birthday;
    private Integer gender;
    private Integer height;
    private Double weight;
    private String city;
    private String icon;
    private String exprience;
    private String award; -->
			<tr>
				<td>name</td>
				<td><input type="text" name="name" value="${user.name }" /></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="text" name="password" value="${user.password }" /></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="text" name="email" value="${user.email }" /></td>
			</tr>
			<%-- <tr>
				<td>birthday</td>
				<td><input type="text" name="birthday" value="${user.birthday }" /></td>
			</tr> --%>
			<%-- <tr>
				<td>商品生产日期</td>
				<td><input type="text" name="items.createtime"
					value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>" /></td>
			</tr> --%>
			<tr>
				<td>height</td>
				<td><input type="text" name="height" value="${user.height }" /></td>
			</tr>
			<tr>
				<td>weight</td>
				<td><input type="text" name="weight" value="${user.weight }" /></td>
			</tr>
			<tr>
				<td>city</td>
				<td><input type="text" name="city" value="${user.city }" /></td>
			</tr>
			<tr>
				<td>icon</td>
				<td>
					<c:if test="${user.icon !=null}">
						<img src="http://image.vport.com/${user.icon}" width=100 height=100/>
						<br/>
					</c:if>
					<input type="file"  name="pictureFile"/> 
				</td>
			</tr>
			
			<tr>
				<td>exprience</td>
				<td><textarea rows="3" cols="30" name="exprience">${user.exprience }</textarea>
				</td>
			</tr>
			<tr>
				<td>award</td>
				<td><textarea rows="3" cols="30" name="award">${user.award }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>

	</form>
</body>
</html>