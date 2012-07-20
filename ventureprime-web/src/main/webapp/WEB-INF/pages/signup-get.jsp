<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
	<title>Signup for VenturePrime</title>
	<link rel="stylesheet" href="style.css" type="text/css" media="screen" />
</head>
<body>
	<h1>Thanks for your interest in signing up for VenturePrime</h1>
	<p>Please complete the form below</p>
	<p>
		<a href="${contextPath}/welcome">Welcome</a>
	</p>

	<form action="${contextPath}/signup" method="post">
		<table>
			<tr>
				<td><b>First Name:</b></td>
				<td></td>
			</tr>
			<tr>
				<td><b>Last Name:</b></td>
				<td></td>
			</tr>
		</table>
	</form>

</body>
</html>