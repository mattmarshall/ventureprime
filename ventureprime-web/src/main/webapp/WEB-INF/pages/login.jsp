<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="include-header.jsp" />
<h1>Login</h1>
	<h3>Login with Username and Password (Custom Page)</h3>
 
	<c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
	
	<form method="post" action="<c:url value='j_spring_security_check' />">
		<table>
			<tr>
				<td>Username</td>
				<td><input type='text' name='j_username' value=''></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type='password' name='j_password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
<jsp:include page="include-footer.jsp" />