<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h3>Message : ${message}</h3>	
	<h3>Username : ${username}</h3>
	
	<h2>Your Roles</h2>
	<ul>
		<c:forEach var="role" items="${roles}"><li>${role}</li></c:forEach>
	</ul>
 
	<a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
 
</body>
</html>