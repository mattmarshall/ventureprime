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

	// Make test name editable
	$('span#test-name').editable();

	// Activate new task button
	$('button#add-question').button({
		icons: {
			primary: "ui-icon-plusthick"
		}
	}).click(function() {
		// Create new question
		var li = $(document.createElement('li'));
		li.addClass('question'); //for css selector issue
		
		function deleteQuestion() {
			li.remove();
			updateIndexes();
			var taskCount = $('ol#questions li.question').length;
			if (taskCount == 0) {
				$('p#noTasks').show();
			}
			return false;
		}
		
		li.load('/assets/ajax/survey-question-entry.html',  function() {
			
			// Make the question description editable
			$(this).find('span.question-description').editable();
			
			// Activate delete button
			$(this).find('button.delete').button({
				icons: {
					primary: "ui-icon-trash"
				}
			}).click(function() {
				li.remove();
				return false;
			});
			
			// Multiple choice selected
			$(this).find('a.multipleChoice').click(function() {
				li.find('div.question-body').load('/assets/ajax/survey-question-multiple-choice.html', function() {
					
					// Multiple choice loaded
					$(this).find('a.delete').click(deleteQuestion);
					
					// Make choices list sortable
					$(this).find('ul.mcChoices').sortable({
						handle: 'div.mc-choice'
					});
					
					// Set subtree listener
					$(this).find('ul.mcChoices').bind('DOMSubtreeModified', function() {
						var count = $(this).find('li').length;
						if (count > 0) {
							$('div.no-mc-choices').hide();
						} else {
							$('div.no-mc-choices').show();
						}
					});
					
					var noChoices = $(this).find('p.noMcChoices');
					var mcChoices = $(this).find('ul.mcChoices');
					var template = $(document.createElement('li')).load('/assets/ajax/survey-mc-choice.html');
					
					// Add CSS classes to li element
					template.addClass('mcChoice').css('display','list-item').css('list-style-type','disc').css('list-style-position','inside');
					
					// Activate new multiple choice field
					$(this).find('button.add-mc-choice').button({
						icons: {
							primary: "ui-icon-plusthick"
						}
					}).click(function(){
						
						// Prevent adding too many choices
						var count = mcChoices.find('li').length;
						if (count >= 5) {
							alert('You cannot create more than 5 choices for this type of question. Please delete a choice.');
							return false;
						}
						
						var choice = template.clone();
						choice.find('button.delete-choice').button({
							icons: {
								primary: 'ui-icon-trash'
							},
							text: false
						}).click(function(){
							choice.remove();
							if (mcChoices.find('li.mcChoice').length == 0) {
								noChoices.show();
							}
							return false;
						});
						
						/*
						choice.find('input.choiceInput').blur(function() {
							choice.find('span.choiceText').first().html($(this).val()).removeClass('hidden');
							$(this).addClass('hidden');
							choice.find('a.editChoice').removeClass('hidden');
						});
						choice.find('a.editChoice').click(function() {
							$(this).addClass('hidden');
							var span = choice.find('span.choiceText').first();
							span.addClass('hidden');
							choice.find('input.choiceInput').removeClass('hidden').val(span.html()).focus();
							return false;
						});
						*/
						
						// Edit in place multiple choice field
						choice.find('span.mc-choice').editable();
						
						mcChoices.append(choice);
						noChoices.hide();
						return false;
					});
				});
				return false;
			});
			
			$(this).find('a.unsupported').click(function() {
				li.load('/assets/ajax/survey-question-unsupported.html', function() {
					// Multiple coice loaded
					updateIndexes();
					$(this).find('a.delete').click(deleteQuestion);
				});
				return false;
			});
			
			$('ol#questions').append(li);
			updateIndexes();
			
		});

		// Remove notice
		$('p#noQuestions').hide();

		/*
		$.ajax({
			type: "POST",
			url: './2/addTask',
			dataType: 'json',
			contentType: "application/json",
			async: false,
			data: '{ "description" : "My Description", "title" : "My Title" }',
			success: function (data, textStatus, jqXHR) {
				// alert(data.title);
			}
		})
		*/
		
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
	
	function updateIndexes() {
		$('ol#questions li').each(function() {
			var index = $('ol#questions li.question').index(this);
			$(this).find('div.order').html((index + 1) + '.');
			//$(this).find('input.taskTitle').attr('name', 'taskTitle').attr('id', 'taskTitle' + index)
			//$(this).find('textarea.taskDescription').attr('name', 'taskDescription').attr('id', 'taskDescription' + index);
		});
	}

	// Enable the add new task button
	$('a#newQuestion').click(function() {
		alert('Click');
		return false;
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