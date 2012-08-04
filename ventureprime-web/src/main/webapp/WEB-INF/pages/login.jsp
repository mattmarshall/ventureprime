<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="include-header.jsp" />
<script type="text/javascript">
	$(document).ready(function(){
		$('input#login').button();
	});
</script>
<h1 style="font-size:18px">Login</h1>
<div style="padding:10px;border:1px solid gainsboro;margin-top:10px" class="ui-corner-all">
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
				<td><input class="ui-corner-all" style="border:1px solid gainsboro;margin:5px" type='text' name='j_username' value=''></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input class="ui-corner-all" style="border:1px solid gainsboro;margin:5px" type='password' name='j_password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input id="login" type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
</div>
<jsp:include page="include-footer.jsp" />