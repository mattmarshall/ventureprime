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
			<div style="width: 975px;margin-top:5px">
				<div class="ui-state-default question-header" style="height:30px">
					<span style="float:right"><button class="delete" style="font-size:8pt;margin:2px;margin-right:5px">Delete</button></span>
					<h2 class="question-description"><span class="ui-icon ui-icon-grip-dotted-vertical" style="display:inline-block;margin-top:6px;cursor:pointer"></span><span class="question-description">${question.title}</span></h2>
					<input class="question-type" type="hidden" name="question-type[]" value="multiple-choice" />
					<input class="question-data" type="hidden" name="question-data[]" value="" />
				</div>
				<div class="question-body" style="clear:right;border-color:gainsboro;border-style:solid;border-width:0 1px 1px 1px;background-color:white;min-height:65px" class="ui-corner-bottom">
				<c:choose>
					<c:when test="${question.class.name == 'me.gotdo.vp3.web.model.survey.MultipleChoiceQuestion'}">
					
					<div style="padding:10px">
						<div>
							<div class="no-mc-choices" class="ui-widget" style="display:none">
								<div class="ui-state-highlight ui-corner-all"> 
									<p style="padding:10px;font-size:12pt"><span class="ui-icon ui-icon-info" style="float: left; margin-right:10px;"></span>
									You have no choices listed for this question, better create some.</p>
								</div>
							</div>
							<!-- Choices List -->
							<ol class="mcChoices">
							<c:forEach var="choice" varStatus="choiceStatus" items="${question.choices}">							
								<div class="mc-choice" style="margin: 5px 0">
									<div style="float:right">
										<button class="delete-choice" style="font-size:8pt">Delete</button>
									</div>
									<div style="width:90%;height:20px">
										<span class="ui-icon ui-icon-grip-dotted-vertical" style="display:inline-block;vertical-align:middle"></span>
										<span class="mc-choice" style="display:inline-block;vertical-align:middle">${choice}</span>
									</div>
									<div style="clear:right;height:0px">&nbsp;</div>
								</div>							
							</c:forEach>
							</ol>
						</div>
						<div style="margin-top:5px">
							<button class="add-mc-choice" style="font-size:8pt">Add Choice</button>
						</div>
					</div>					
					</c:when>
				</c:choose>
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