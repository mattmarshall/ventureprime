<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="../include-header-venture.jsp" />
<h1>Review</h1>
<div style="margin:20px;border:1px solid gray;padding:10px;text-align:center">
	<div style="text-align:left">
		<h2>Detailed Test Overview</h2>
		<div>
		<div style="display:inline-block;vertical-align:top;width:250px">
			<div style="width: 100px; height: 85px; background-color: orange">IMAGE</div>
			<div>
			<dl>
				<dt>Website</dt>
				<dd><a href="http://www.lore.com">www.lore.com</a></dd>
				
				<dt>Status</dt>
				<dd>Live</dd>
				
				<dt>Test Type</dt>
				<dd>Level 3</dd>
				
				<dt>Estimated Duration</dt>
				<dd>40 minutes</dd>
				
				<dt>Eligible Users</dt>
				<dd>College students, instructors, recent alumni</dd>
				
				<dt>Spots Remaining</dt>
				<dd>500</dd>
				
				<dt>Time Remaining</dt>
				<dd>15:00:00</dd>
			</dl>
			</div>
		</div>
		<div style="display:inline-block;vertical-align:top;width:650px">
			<h3><b>Company Name:</b> Lore</h3>
			<p style="margin: 10px 0">Lore is a new course management software that they hope will
			replace Blackboard on college campuses. Their goal is to make learning
			and classes a more social experience.</p>
			
			<p style="margin: 10px 0">The Lore team wants to test out their software on a few real
			college students to see how they like it compared to their current system.
			They are looking to get feedback on the tools, usability, and design of
			their platform.</p>
			
			<p style="margin: 10px 0">
				<b>Sample Task 1:</b> Pick any funny image, then upload and
				submit in the "Homework Assignment 1" folder.
			</p>
			
			<p style="margin: 10px 0">
				<b>Sample Task 2:</b> Enroll in the course "VenturePrime".
			</p>
			
			<p style="margin: 10px 0">
				<b>Sample Survey Question 1:</b> Did any of the tasks take longer
				to complete than others?
			</p>
			
			<p style="margin: 10px 0">
				<b>Sample Survey Question 2:</b> Which of these available tools do
				you think would be the most useful and why?
			</p>
			
			<div>
				<button>I want to Participate!</button>
			</div>
			
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