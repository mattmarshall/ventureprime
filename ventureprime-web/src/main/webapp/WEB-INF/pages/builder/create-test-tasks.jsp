<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include-header-venture.jsp" />
<style>
.hidden { display: none }
</style>
<script type="text/javascript">
$(document).ready(function(){

	// Validate the form
	$('form#test-task-form').validate();

	// Make list sortable
	$('ol#tasks').sortable({'handle': 'div.task-header', 'placeholer': 'vacant', 'cursor': 'pointer'});	
	$('ol#tasks').bind('DOMSubtreeModified', function() {
		
		// Show/hide no tasks button
		var count = $(this).find('li').length;
		if (count > 0) {
			$('div#no-tasks').hide();
			$('button#next-step').button('enable');
		} else {
			$('div#no-tasks').show();
			$('button#next-step').button('disable');
		}
		
		// Re-validate field?
		$('form#test-task-form').validate();		
	});
	
	// Mark all existing tasks as "taskEdit()"
	$('ol#tasks li').taskEdit({
		doLoad: false
	});
	
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
		
		// Create list element
		var li = $(document.createElement('li'));
		li.taskEdit();
		$('ol#tasks').append(li);

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
    	<li>
		<div style="width: 975px;margin-top:5px">
			<div class="ui-state-default task-header" style="height:30px">
				<span class="ui-icon ui-icon-grip-dotted-vertical" style="display:inline-block;margin-top:6px;cursor:pointer"></span>
				<span style="float:right"><button class="delete" style="font-size:8pt;margin:2px;margin-right:5px">Delete</button></span>
				<span class="task-header-edit">
					<span class="task-title" style="font-size:12pt;padding:2px">${task.title}</span>
				</span>
			</div>
			<div style="clear:right;border-color:gainsboro;border-style:solid;border-width:0 1px 1px 1px;background-color:white;min-height:65px" class="ui-corner-bottom">
				<textarea name="task-description[]" class="task-description ui-corner-top ui-corner-all required" style="border:1px solid gainsboro;resize:none;width:957px;margin:5px;height:48px" placeholder="Give a longer description">${task.description}</textarea>
			</div>
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