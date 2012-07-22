<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="../include-header-venture.jsp" />
<h1>Pay & Publish</h1>

<div style="margin: 10px 0; padding: 10px; border-top: 1px solid gray; border-bottom: 1px solid gray">
	<p>
		You will be charged <b>$300</b> for this test now +
		<b>$2 x Number of Completed Tests</b> when your test period closes.
	</p>
</div>

<p>
	<a href="/v/builder/step/8">Back</a>
	<a href="/v/builder/step/${nextStep}">Publish!</a>
</p>
<jsp:include page="../include-footer-venture.jsp" />