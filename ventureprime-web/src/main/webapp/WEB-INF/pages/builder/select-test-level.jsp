<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include-header-venture.jsp" />
<h1>Select Test Level (Round 2)</h1>
<div>
	<c:forEach var="level" items="${testLevels}">
	<div id="${level.id}" class="level" style="margin: 10px; padding: 10px; border: 1px solid gray; cursor: pointer">
		<div>
			<div style="float:right"><a href="#">Explanation of Pricing</a></div>
			<h1 style="font-weight:bold"><c:out value="${level.friendlyName}" /></h1>
		</div>
		<div>
			<div style="margin: 5px 0; padding 10px; background: gainsboro">
				<p><c:out value="${level.description}" /></p>
			</div>
			<div style="margin: 5px 0; padding 10px;">Example</div>
			<div style="font-weight:bold">
				<fmt:formatNumber type="currency" currencySymbol="$" pattern="� #,##0.00;� -#,##0.00" value="${level.price}" />
			</div>
		</div>
	</div>
	</c:forEach>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('.level').click(function() {
				$('#testLevel').val($(this).attr('id'));
				$('.selected').removeClass('selected');
				$(this).addClass('selected');
			});
		});
	</script>
</div>
<p>
	<form action="" method="post">
		<input type="hidden" name="testLevel" id="testLevel" value="" />
		<input type="submit" name="submit" value="Submit" />
	</form>
</p>
<jsp:include page="../include-footer-venture.jsp" />