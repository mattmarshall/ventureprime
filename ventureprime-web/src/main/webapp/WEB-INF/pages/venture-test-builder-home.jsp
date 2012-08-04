<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="include-header-venture.jsp" />

<script type="text/javascript">
$(document).ready(function(){
	
	// Test name dialog
	var testNameDialog = $('<div></div>')
	.html('<div>Give this test a name</div><div><form id="create-test-form" method="post" action=""><input type="text" placeholder="Test Name" id="test-name" name="test-name" /></form></div>')
	.dialog({
		autoOpen: false,
		title: 'Create New Test?',
		modal: true,
		draggable: false,
		resizable: false,
		buttons: {
			'Create': function() {
				$(this).dialog('close');
				$(this).find('form#create-test-form').submit();
			},
			'Cancel': function() {
				$(this).dialog('close');
			}
		}
	});
	
	$('button#create-test').button().click(function(){
		testNameDialog.dialog('open').find('input#test-name').focus();
		return false;
	});
});
</script>

<p style="margin:10px 5px">You can create a VenturePrime test to conduct customized market
	research, test your product on real target users, and get the word out
	about your company (or keep your identity secret).</p>
<p style="margin:10px 5px;">
	We suggest you start by reading our manual on <a href="#">How to
		Create an Effective Test</a> and our <a href="#">How it Works</a> page if
	you haven't already.
<p style="margin:10px 5px">Ready to get started?</p>
<button id="create-test">Create a Test</button>
<jsp:include page="include-footer-venture.jsp" />