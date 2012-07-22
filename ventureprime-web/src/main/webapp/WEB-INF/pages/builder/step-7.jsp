<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="../include-header-venture.jsp" />
<h1>Review</h1>
<div style="margin:20px;border:1px solid gray;padding:10px;text-align:center">
	<div style="text-align:left">
		<h2>Task List</h2>
		<div>
			<p><b>TODO:</b> Task list goes here</p>
		</div>
	</div>
</div>
<p>
	<a href="/v/builder/step/4">Back</a>&nbsp;
	<a href="#" onclick="javascript:alert('What's this do?)">Edit</a>&nbsp;
	<a href="/v/builder/step/${nextStep}">Next</a>
</p>
<jsp:include page="../include-footer-venture.jsp" />