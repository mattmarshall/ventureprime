<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<h1>Create a New Survey</h1>

	<form:form modelAttribute="survey" method="POST" action="survey">
		<table>
			<tr>
				<td><form:label path="friendlyName">Name</form:label></td>
				<td><form:input path="friendlyName" /></td>
			</tr>
			<tr>
				<td><form:label path="description">Description</form:label></td>
				<td><form:textarea path="description" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Start Survey" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>