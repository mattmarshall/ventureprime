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
		return $('form#test-survey-form').submit();
	});
});
</script>

<h1 style="font-size:18px">Create Feedback Survey for <span id="test-name">${test.testName}</span></h1>

<form id="test-survey-form" action="" method="post">
<div id="test-survey-contain" style="margin-top:10px">
<c:choose>
  <c:when test="${(not empty test.surveys) && (not empty test.surveys[0].questions)}">
 		<ol id="questions">
    	<c:forEach var="question" varStatus="status" items="${test.surveys[0].questions}">
    	<li class="question">
    		<div>Question</div>
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
</div>
</form>

<div style="margin-top:10px">
<span style="float:right">
	<button id="prev-step">Back</button>
	<button id="next-step">Next</button>
</span>
<button id="add-question">Add Question</button>
</div>

<jsp:include page="../include-footer-venture.jsp" />