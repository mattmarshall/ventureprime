<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="include-header.jsp" />
<h1>VenturePrizes</h1>
<div style="border:4px solid gainsboro; padding: 10px; margin: 10px;">
	<p>Styling to appear later...</p>
	<c:forEach var="prize" items="${prizes}">
		<div style="display: inline-block; vertical-align: top; border: 1px solid black; margin: 5px; padding: 5px; width: 200px;">
			<h2>${prize.name}</h2>
			<div>Image goes here...</div>
			<h3>Points: ${prize.points}</h3>
			<div><button>Buy</button></div>
		</div>
	</c:forEach>
</div>
<jsp:include page="include-footer.jsp" />