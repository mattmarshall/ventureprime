<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="include-header.jsp" />
<h1>Companies</h1>
<c:forEach var="company" items="${companies}">
<div style="border:4px solid gainsboro; padding: 10px; margin: 10px;">
	<h2>${company.name}</h2>
	<p>A description will go here eventually...</p>
</div>
</c:forEach>
<jsp:include page="include-footer.jsp" />