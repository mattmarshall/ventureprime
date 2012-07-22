<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="../include-header-venture.jsp" />
<h1>Create Tasks</h1>

<!-- TASK 1 -->
<div style="border-top: 1px solid gray; border-bottom: 1px solid gray; margin: 10px 0; padding: 10px;">
	<div style="float:right"><a href="#">Edit</a>&nbsp;&nbsp;<a href="#">Delete</a></div>
	<h2>1. Create user account.</h2>
	<p style="margin: 10px 0; clear:right">Use tester_+ your first initial + last name as your username.
	For example, if your name is John Smith, your username would be tester_jsmith.</p>
</div>

<!-- TASK 2 -->
<div style="border-top: 1px solid gray; border-bottom: 1px solid gray; margin: 10px 0; padding: 10px;">
	<div style="float:right"><a href="#">Edit</a>&nbsp;&nbsp;<a href="#">Delete</a></div>
	<h2>2. Enroll in the course "VenturePrime".</h2>
	<div style="clear:right:height:0px">&nbsp;</div>
</div>

<!-- TASK 3 -->
<div style="border-top: 1px solid gray; border-bottom: 1px solid gray; margin: 10px 0; padding: 10px;">
	<div style="float:right"><a href="#">Edit</a>&nbsp;&nbsp;<a href="#">Delete</a></div>
	<div><span>3. </span><input name="task3-text" type="text" placeholder="Edit task text" /></div>
	<textarea style="clear:right; margin: 10px 0; margin-left: 15px; width: 90%" placeholder="Edit task details (if any)"></textarea>
</div>

<!-- NEW TASK -->
<div style="border-top: 1px solid gray; border-bottom: 1px solid gray; margin: 10px 0; padding: 10px;">
	<div style="text-align:center"><a href="#" onclick="javascript:alert('New task to come')">+ NEW TASK</a></div>
</div>


<p>
	<a href="/v/builder/step/${nextStep}">Next</a>
</p>
<jsp:include page="../include-footer-venture.jsp" />