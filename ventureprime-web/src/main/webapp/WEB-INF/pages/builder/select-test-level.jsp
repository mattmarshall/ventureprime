<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include-header-venture.jsp" />

<script type="text/javascript">
	$(document).ready(function() {

		// Close dialog
		var closeDialog = $('<div></div>')
		.html('Would you really like to cancel?')
		.dialog({
			autoOpen: false,
			title: 'Cancel Test Builder?',
			modal: true,
			draggable: false,
			resizable: false,
			buttons: {
				No: function() {
					$(this).dialog('close');
				},
				'Yes': function() {
					$(this).dialog('close');
				}
			}
		});
		
		$('#accordion').accordion();
		
		// Activate cancel button
		$('button#cancel').button({
			icons: {
				primary: 'ui-icon-closethick'
			}
		}).click(function() {
			closeDialog.dialog('open');
			return false;
		});
		
		// Activate next button
		$('button#next-step').button({
			icons: {
				secondary: 'ui-icon-triangle-1-e'
			}
		}).click(function() {
			return $('form#test-level-form').submit();
		});
		
	});		
</script>

<h1 style="font-size:18px">Select Test Level (Round 2)</h1>

<div id="accordion" style="margin-top:10px">
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
</div>

<form id="test-level-form" action="" method="post">
	<input type="hidden" name="testLevel" id="testLevel" value="" />
	<div style="margin-top:10px">
		<span style="float:right">
			<button id="cancel">Cancel</button>
			<button id="next-step">Next</button>
		</span>
		<div style="height:0px;clear:right">&nbsp;</div>
	</div>
</form>

<jsp:include page="../include-footer-venture.jsp" />