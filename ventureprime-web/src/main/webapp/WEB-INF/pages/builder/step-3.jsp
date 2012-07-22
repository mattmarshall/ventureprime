<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="../include-header-venture.jsp" />
<h1>Create Feedback Survey</h1>

<!-- SURVEY 1 -->
<div style="border-top: 1px solid gray; border-bottom: 1px solid gray; margin: 10px 0; padding: 10px;">
	<div style="display:inline-block; vertical-align:top; padding: 0 10px">
		<div>1.</div>
		<div>
			<p style="margin: 5px 0"><a href="#">Up</a>
			<p style="margin: 5px 0"><a href="#">Down</a>
		</div>
	</div>
	<div style="display:inline-block; vertical-align:top; border-left: 1px solid gray; padding-left: 10px; width: 850px">
		<div style="float:right"><a href="#">Edit</a>&nbsp;&nbsp;<a href="#">Delete</a></div>
		<h2>What do you currently use to keep track of your assignments?
		Did you find the calendar feature helpful?</h2>
		<textarea style="margin: 10px; clear: right"></textarea>
	</div>
</div>

<!-- SURVEY 2 -->
<div style="border-top: 1px solid gray; border-bottom: 1px solid gray; margin: 10px 0; padding: 10px;">
	<div style="display:inline-block; vertical-align:top; padding: 0 10px">
		<div>2.</div>
		<div>
			<p style="margin: 5px 0"><a href="#">Up</a>
		</div>
	</div>
	<div style="display:inline-block; vertical-align:top; border-left: 1px solid gray; padding-left: 10px; width: 850px">
		<div style="float:right"><a href="#">Edit</a>&nbsp;&nbsp;<a href="#">Delete</a></div>
		<h2>Select Question Type:</h2>
		<div>
		<div style="display:inline-block;margin:10px;padding:10px;border-right:1px solid gray">
			<a href="#" onclick="javascript:alert('Multiple choice')">Multiple Choice</a>
		</div>
		<div style="display:inline-block;margin:10px;padding:10px;border-right:1px solid gray">
			<a href="#" onclick="javascript:alert('Checkbox')">Checkbox</a>
		</div>
		<div style="display:inline-block;margin:10px;padding:10px;border-right:1px solid gray">
			<a href="#" onclick="javascript:alert('Fill in the blank')">Fill in the blank</a>
		</div>
		<div style="display:inline-block;margin:10px;padding:10px;border-right:1px solid gray">
			<a href="#" onclick="javascript:alert('Short answer')">Short answer</a>
		</div>
		<div style="display:inline-block;margin:10px;padding:10px;border-right:1px solid gray">
			<a href="#" onclick="javascript:alert('Rank Order')">Rank Order</a>
		</div>
		<div style="display:inline-block;margin:10px;padding:10px;">
			<a href="#" onclick="javascript:alert('There is no spoon')">Matrix</a>
		</div>
		</div>
	</div>
</div>

<!-- NEW ITEM -->
<div style="border-top: 1px solid gray; border-bottom: 1px solid gray; margin: 10px 0; padding: 10px;">
	<div style="text-align:center"><a href="#" onclick="javascript:alert('New item to come')">+ NEW ITEM</a></div>
</div>

<p>
	<a href="/v/builder/step/${nextStep}">Next</a>
</p>
<jsp:include page="../include-footer-venture.jsp" />