<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include-header-venture.jsp" />
<h1>Create Feedback Survey</h1>

<script type="text/javascript">
$(document).ready(function(){
	
	// Enable the delete button
	$('a.delete').click(function(){
		alert('You are deleting a question!');
		return false;
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
			
			var link = $(this).find('a.delete').click(function() {
				li.remove();
				updateIndexes();
				var taskCount = $('ol#questions li').length;
				if (taskCount == 0) {
					$('p#noTasks').show();
				}

				return false;
			});
			
			$(this).find('a.multipleChoice').click(function() {
				li.load('/assets/ajax/survey-question-multiple-choice.html', function() {
					// Multiple coice loaded
					updateIndexes();
					$(this).find('a.delete').click(deleteQuestion);
					var noChoices = $(this).find('p.noMcChoices');
					var mcChoices = $(this).find('ul.mcChoices');
					var template = $(document.createElement('li')).load('/assets/ajax/survey-mc-choice.html');
					template.addClass('mcChoice');
					$(this).find('a.newMcChoice').click(function() {
						var choice = template.clone();
						choice.find('a.deleteChoice').click(function() {
							choice.remove();
							if (mcChoices.find('li.mcChoice').length == 0) {
								noChoices.show();
							}
							return false;
						});
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
});
</script>

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
  	<p id="noQuestions">You have no questions in this test's survey, add some below.</p>
  	<ol id="questions"></ol>
  </c:otherwise>
</c:choose>
</form>

<!-- NEW ITEM -->
<div style="border-top: 1px solid gray; border-bottom: 1px solid gray; margin: 10px 0; padding: 10px;">
	<div style="text-align:center"><a id="newQuestion" href="newItem">+ NEW ITEM</a></div>
</div>

<p>
	<a href="/v/builder/step/${nextStep}">Next</a>
</p>
<jsp:include page="../include-footer-venture.jsp" />