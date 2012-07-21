<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>Your VenturePrime Account Has Been Created</h1>
	<table>
		<tr><td><b>Username:</b></td><td><c:out value="${user.id}" /></td></tr>
		<tr><td><b>Active:</b></td><td><c:out value="${user.active}" /></td></tr>
	</table>
</body>
</html>