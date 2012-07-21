<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<h1>Create your VenturePrime Account</h1>

	<form:form modelAttribute="user" method="POST" action="register">
		<table>
			<tr>
				<td><form:label path="id">Email Address:</form:label></td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="credentials">Credentials</form:label></td>
				<td><form:input path="credentials" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<p>Please select an account type</p>
					<ul>
						<c:forEach var="role" items="${roles}">
						<li><form:label path="${role}"><form:radiobutton path="role" value="${role}" /></form:label></li>
						</c:forEach>
					</ul>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Create User" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>