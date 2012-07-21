<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>Your Survey Has Been Created!</h1>
	<table>
		<tr><td><b>Survey ID:</b></td><td><c:out value="${survey.id}" /></td></tr>
		<tr><td><b>Survey Name:</b></td><td><c:out value="${survey.friendlyName}" /></td></tr>
		<tr><td><b>Description</b></td><td><c:out value="${survey.description}" /></td></tr>
	</table>
</body>
</html>