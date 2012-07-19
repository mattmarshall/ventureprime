<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>This is the Surveys Page</h1>
	
	<ul>
		<c:forEach items="${surveys}" var="survey">
		<li><c:out value="${survey.id}" /></li>
		</c:forEach>
	</ul> 
</body>
</html>