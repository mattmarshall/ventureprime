<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include-header-venture.jsp" />
<h1>Create Tasks for ${test.testName}</h1>

<script type="text/javascript">
$(document).ready(function(){
	
	// Enable the delete button
	$('a.delete').click(function(){
		alert('You are deleting a task!');
		return false;
	});
	
	function updateIndexes() {
		$('ol#tasks li').each(function() {
			var index = $('ol#tasks li').index(this);
			$(this).find('input.taskTitle').attr('name', 'taskTitle').attr('id', 'taskTitle' + index)
			$(this).find('textarea.taskDescription').attr('name', 'taskDescription').attr('id', 'taskDescription' + index);
		});
	}

	// Enable the add new task button
	$('a#newTask').click(function() {
		var li = $(document.createElement('li'));
		li.load('/assets/ajax/test-task-entry.html',  function() {
			
			var link = $(this).find('a.delete').click(function() {
				li.remove();
				updateIndexes();
				var taskCount = $('ol#tasks li').length;
				if (taskCount == 0) {
					$('p#noTasks').show();
				}

				return false;
			});
			
			$('ol#tasks').append(li);
			updateIndexes();
			
		});

		// Remove notice
		$('p#noTasks').hide();

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

<form name="testTask" action="" method="post">

<c:choose>
  <c:when test="${not empty test.tasks}">
 		<ol id="tasks">
    	<c:forEach var="task" varStatus="status" items="${test.tasks}">
		<!-- TASK -->
		<li id="task${status.index}">
		<div style="border-top: 1px solid gray; border-bottom: 1px solid gray; margin: 10px 0; padding: 10px;">
			<div style="float:right"><a href="#">Edit</a>&nbsp;&nbsp;<a class="delete" href="deleteTask/${status.index}">Delete</a></div>
			<h2>${task.title}</h2>
			<p style="margin: 10px 0; clear:right">${task.description}</p>
		</div>
		</li>
  	</c:forEach>
  		</ol>
  </c:when>
  <c:otherwise>
  	<p id="noTasks">You have no tasks attached to this test, better create some.</p>
  	<ol id="tasks"></ol>
  </c:otherwise>
</c:choose>

<!-- NEW TASK -->
<div style="border-top: 1px solid gray; border-bottom: 1px solid gray; margin: 10px 0; padding: 10px;">
	<div style="text-align:center"><a id="newTask" href="newTask">+ NEW TASK</a></div>
</div>


<p>
	<input type="submit" name="submit" value="Next" />
</p>
</form>
<jsp:include page="../include-footer-venture.jsp" />