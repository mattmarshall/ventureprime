<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="../include-header-venture.jsp" />
<h1>Review</h1>
<div style="margin:20px;border:1px solid gray;padding:10px;text-align:center">
	<div style="text-align:left">
		<h2>Abbreviated Test View</h2>
		<div>
		<div style="display:inline-block;vertical-align:top;width:150px">IMAGE</div>
		<div style="display:inline-block;vertical-align:top;width:150px">
			<h3>Lore</h3>
			<p>We give instructors and students amazingly designed
			tools to manage their courses.</p>
			<p>Test type: <b>Level 3</b></p>
			<p>Eligible Primers: Students, instructors, recent alumni</p>
			<p><a href="#" onclick="javascript:alert('I ain't learnin from no teacher lady!')">Learn more...</a></p>
		</div>
		</div>
	</div>
</div>
<p>
	<a href="/v/builder/step/4">Back</a>&nbsp;
	<a href="#" onclick="javascript:alert('What's this do?)">Edit</a>&nbsp;
	<a href="/v/builder/step/${nextStep}">Next</a>
</p>
<jsp:include page="../include-footer-venture.jsp" />