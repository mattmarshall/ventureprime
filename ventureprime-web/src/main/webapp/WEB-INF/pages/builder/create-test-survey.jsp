<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include-header-venture.jsp" />

<script type="text/javascript">
$(document).ready(function(){

	// Make list sortable
	$('ol#questions').sortable({'handle': 'div.question-header', 'cursor': 'pointer'});	
	$('ol#questions').bind('DOMSubtreeModified', function() {
		var count = $(this).find('li').length;
		if (count > 0) {
			$('div#no-questions').hide();
			$('button#next-step').button('enable');
		} else {
			$('div#no-questions').show();
			$('button#next-step').button('disable');
		}
	});

	// Activate new task button
	$('button#add-question').button({
		icons: {
			primary: "ui-icon-plusthick"
		}
	}).click(function() {
		// Create new question
		var li = $(document.createElement('li'));
		li.addClass('question'); //for css selector issue
		li.questionEdit();
		return false;
	});
	
	// Activate previous button
	$('button#prev-step').button({
		icons: {
			primary: "ui-icon-triangle-1-w"
		}
	}).click(function() {
		window.location.href = '/v/builder/step/2';
		return false;
	});
	
	// Activate next button
	$('button#next-step').button({
		disabled: true,
		icons: {
			secondary: "ui-icon-triangle-1-e"
		}
	}).click(function() {
		return $('form#test-task-form').submit();
	});
});
</script>

<h1 style="font-size:18px">Create Feedback Survey for <span id="test-name">${test.testName}</span></h1>

<div id="test-survey-contain" style="margin-top:10px">
<form name="testSurvey" action="" method="post">
<c:choose>
  <c:when test="${(not empty test.surveys) && (not empty test.surveys[0].questions)}">
 		<ol id="questions">
    	<c:forEach var="question" varStatus="status" items="${test.surveys[0].questions}">
    	<li class="question">
			<!-- Question -->
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
					<h2>${question.title}</h2>
					<textarea style="margin: 10px; clear: right"></textarea>
				</div>
			</div>
		</li>
  	</c:forEach>
  		</ol>
  </c:when>
  <c:otherwise>
  	<div id="no-questions" class="ui-widget">
		<div class="ui-state-highlight ui-corner-all"> 
			<p style="padding:10px;font-size:12pt"><span class="ui-icon ui-icon-info" style="float: left; margin-right:10px;"></span>
			You have no questions in this survey, better create some.</p>
		</div>
	</div>  	
  	<ol id="questions"></ol>
  </c:otherwise>
</c:choose>
</form>
</div>

<div style="margin-top:10px">
<span style="float:right">
	<button id="prev-step">Back</button>
	<button id="next-step">Next</button>
</span>
<button id="add-question">Add Question</button>
</div>

<jsp:include page="../include-footer-venture.jsp" />