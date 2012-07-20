<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>This is the Surveys Page</h1>
	
	<ul>
		<c:forEach items="${surveys}" var="survey">
			<table>
				<tr><td><b>Survey ID:</b></td><td><c:out value="${survey.id}" /></td></tr>
				<tr><td><b>Survey Name:</b></td><td><c:out value="${survey.friendlyName}" /></td></tr>
				<tr><td><b>Schema Version</b></td><td><c:out value="${survey.metadata.schemaVersion}" /></td></tr>
			</table>
		</c:forEach>
	</ul> 
</body>
</html>