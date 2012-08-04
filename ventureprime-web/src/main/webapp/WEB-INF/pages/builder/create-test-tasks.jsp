<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include-header-venture.jsp" />

<script type="text/javascript">
$(document).ready(function(){
	
	// Make list sortable
	$('ol#tasks').sortable({'handle': 'div.task-header', 'placeholer': 'vacant', 'cursor': 'pointer'});	
	$('ol#tasks').bind('DOMSubtreeModified', function() {
		var count = $(this).find('li').length;
		if (count > 0) {
			$('div#no-tasks').hide();
			$('button#next-step').button('enable');
		} else {
			$('div#no-tasks').show();
			$('button#next-step').button('disable');
		}
	});
	
	// Edit in place
	$('span#test-name').editable();
	
	// Activate new task button
	$('button#add-task').button({
		icons: {
			primary: "ui-icon-plusthick"
		}
	}).click(function() {
		
		// Prevent wreckless adding of tasks
		var count = $('ol#tasks li').length;
		if (count >= 5) {
			alert("You cannot add any more tasks. Please delete some");
			return false;
		}
		
		var li = $(document.createElement('li'));
		li.load('/assets/ajax/test-task-entry.html',  function() {

			$(this).find('span.task-title').editable();

			var link = $(this).find('button.delete').button({
				icons: {
					primary: "ui-icon-trash"
				}
			}).click(function() {
				li.remove();
				return false;
			});
			$('ol#tasks').append(li);
		});
		return false;		
	});
	
	// Activate previous button
	$('button#prev-step').button({
		icons: {
			primary: "ui-icon-triangle-1-w"
		}
	}).click(function() {
		window.location.href = '/v/builder/step/1'
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

<h1 style="font-size:18px">Create Tasks for <span id="test-name">${test.testName}</span></h1>

<form id="test-task-form" action="" method="post">

<div id="test-tasks-contain" style="margin-top:10px">
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
  	<div id="no-tasks" class="ui-widget">
		<div class="ui-state-highlight ui-corner-all"> 
			<p style="padding:10px;font-size:12pt"><span class="ui-icon ui-icon-info" style="float: left; margin-right:10px;"></span>
			You have no tasks attached to this test, better create some.</p>
		</div>
	</div>  	
  	<ol id="tasks"></ol>
  </c:otherwise>
</c:choose>
</div>

<div style="margin-top:10px">
<span style="float:right">
	<button id="prev-step">Back</button>
	<button id="next-step">Next</button>
</span>
<button id="add-task">Add Task</button>
</div>

</form>
<jsp:include page="../include-footer-venture.jsp" />