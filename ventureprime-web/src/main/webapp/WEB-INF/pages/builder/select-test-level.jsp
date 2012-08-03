<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include-header-venture.jsp" />
<h1>Select Test Level (Round 2)</h1>
<div id="accordion">
	<c:forEach var="level" items="${testLevels}">
	<h3>
		<a href="#"><c:out value="${level.friendlyName}" /></a>
	</h3>
	<div>
		<span style="float:right"><a href="#" style="font-size:8pt">Explanation of Pricing</a></span>
		<div>
			<p><c:out value="${level.description}" /></p>
		</div>
		<div>Example</div>
		<div style="font-weight:bold">
			<fmt:formatNumber type="currency" currencySymbol="$" pattern="¤ #,##0.00;¤ -#,##0.00" value="${level.price}" />
		</div>
	</div>
	</c:forEach>
	
	<script type="text/javascript">
		$(document).ready(function() {
			
			$('#accordion').accordion();
			
			/*
			$('.level').click(function() {
				$('#testLevel').val($(this).attr('id'));
				$('.selected').removeClass('selected');
				$(this).addClass('selected');
			});
			*/
		});
	</script>
</div>
<form action="" method="post">
	<input type="hidden" name="testLevel" id="testLevel" value="" />
	<input type="submit" name="submit" value="Submit" />
</form>
<jsp:include page="../include-footer-venture.jsp" />