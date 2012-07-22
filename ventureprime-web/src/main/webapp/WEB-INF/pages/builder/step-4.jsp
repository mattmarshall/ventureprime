<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="../include-header-venture.jsp" />
<h1>Test Details</h1>

<div style="margin: 10px 0; padding: 10px;">
<h2>1. Please provide a brief explanation of why you are conducting this test.</h2>
<p>(If you do not with to disclose this information, just leave this question blank.)</p>
<textarea rows="10" cols="20"></textarea>
</div>

<div style="margin: 10px 0; padding: 10px;">
<div>2. Cost per imer is <b>$2</b>. Allow no more than <input name="max-primers" type="text" />participants</div>
</div>

<div style="margin: 10px 0; padding: 10px;">
<div style="display:float-right;font-style:italic;">eg. 18-25 year old males with iPads</div>
<h2>Who is eligible to participate in this test?</h2>
<input type="text" style="clear:right; width: 100%" name="eligible" />
</div>

<div style="margin: 10px 0; padding: 10px;">
<h2>4. What is the estimated duaration of this test, including the feedback survey?</h2>
<p>days, hours, minutes (some js widget we can snipe from somewhere)</p>
</div>

<div style="margin: 10px 0; padding: 10px;">
<h2>5. What is the last day primers can sign up for this test?</h2>
<p>calendar</p>
</div>

<div style="margin: 10px 0; padding: 10px;">
<h2>6. How long do primers have to complete this test once they sign up?</h2>
<p>(Please consider that many of our primers lead
busy lives and are participating in multiple tests at a time.)</p>
<p>Calendar thingy</p>
</div>

<p>
	<a href="/v/builder/step/${nextStep}">Next</a>
</p>
<jsp:include page="../include-footer-venture.jsp" />