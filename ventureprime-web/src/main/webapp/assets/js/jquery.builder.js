(function($) {
	
	/**
	 * Creates a simple editor
	 */
	$.fn.highlight = function(options) {
		
		var defaults = {
				
		}
		
		/**
		 * Create settings object
		 */
		options = $.extend({}, defaults, options);
		
		return this.each(function() {
			var $this = $(this);
			$this.mouseenter(function(){
				$this.addClass('ui-state-highlight');
			});
			$this.mouseleave(function(){
				$this.removeClass('ui-state-highlight');
			});
		});		
	}

	/**
	 * Creates a simple editor
	 */
	$.fn.simpleEdit = function(options) {
		
		var defaults = {
			inputType: 'text',
			inputName: 'default'
		}
		
		/**
		 * Create settings object
		 */
		options = $.extend({}, defaults, options);
		
		return this.each(function() {
			var $this = $(this);
			var parent = $this.parent();
			var input = $(document.createElement('input'));

			input.attr('type', options.inputType).attr('name', options.inputName);
			input.val($this.text());
			input.hide();
			
			// Click
			$this.click(function() {
				input.val($this.text());
				input.show();
				$this.hide();
				input.focus();
				return false;
			});
			
			// Blur
			input.blur(function() {
				$this.text(input.val());
				input.hide();
				$this.show();
				return false;
			});
			parent.append(input);
		});		
	}

	/**
	 * Runs the task editor on
	 * an li element
	 */
	$.fn.taskEdit = function(options) {
		
		var defaults = {
				ajax: '/assets/ajax/test-task-entry.html',
				doLoad: true
		}
		
		/**
		 * Create settings object
		 */
		options = $.extend({}, defaults, options);
		
		return this.each(function() {
			var $this = $(this);
			$this.css('display','list-item').css('list-style-type','decimal').css('list-style-position','inside');
			
			function configureTask() {
				// Make task title editable in place
				$this.find('span.task-title').highlight().simpleEdit({
					inputName: 'task-title[]'
				});
				
				// Activate delete button
				var link = $this.find('button.delete').button({
					icons: {
						primary: "ui-icon-trash"
					}
				}).click(function() {
					$this.remove();
					return false;
				});
			}

			if (options.doLoad) {
				$this.load(options.ajax,  configureTask);
			} else {
				configureTask();
			}
		});
	}

	/**
	 * Runs the unsupported editor on
	 * an element
	 */
	$.fn.unsupported = function(options) {
		var defaults = {
				ajax: '/assets/ajax/survey-question-entry.html',
		}
		
		/**
		 * Create settings object
		 */
		options = $.extend({}, defaults, options);
		
		return this.each(function() {
			$(this).load('/assets/ajax/survey-question-unsupported.html');
		});
	}

	/**
	 * Runs the multiple choice editor on
	 * an element
	 */
	$.fn.multipleChoice = function(options) {
		var defaults = {
				template: '/assets/ajax/survey-question-multiple-choice.html',
				choiceTemplate: '/assets/ajax/survey-mc-choice.html'
		}
		
		/**
		 * Create settings object
		 */
		options = $.extend({}, defaults, options);
		
		return this.each(function() {
			$(this).load(options.template, function() {
				
				// Make choices list sortable
				$(this).find('ol.mcChoices').sortable({
					handle: 'div.mc-choice'
				});
				
				// Set subtree listener
				$(this).find('ol.mcChoices').bind('DOMSubtreeModified', function() {
					var count = $(this).find('li').length;
					if (count > 0) {
						$('div.no-mc-choices').hide();
					} else {
						$('div.no-mc-choices').show();
					}
				});

				// Get elements
				var noChoices = $(this).find('p.noMcChoices');
				var mcChoices = $(this).find('ol.mcChoices');
				var template = $(document.createElement('li')).load(options.choiceTemplate);
				
				// Add CSS classes to li element
				template.addClass('mcChoice').css('display','list-item').css('list-style-type','lower-alpha').css('list-style-position','inside');
				
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
					
					// Clone the choice template
					var choice = template.clone();
					choice.find('button.delete-choice').button({
						icons: {
							primary: 'ui-icon-trash'
						},
						text: false
					}).click(function(){
						choice.remove();
						return false;
					});
					
					// Edit in place multiple choice field
					// choice.find('span.mc-choice').editable();
					choice.find('span.mc-choice').highlight().simpleEdit({
						inputName: 'choice[]'
					});
					
					// Append to list
					mcChoices.append(choice);

					return false;
				});
			});
		});
	}
	
	
	/**
	 * Runs the question editor on
	 * an li element
	 */
	$.fn.questionEdit = function(options) {
		
		var defaults = {
				ajax: '/assets/ajax/survey-question-entry.html',
		}
		
		/**
		 * Create settings object
		 */
		options = $.extend({}, defaults, options);
		
		return this.each(function() {
			// Create new question
			var li = $(this);
			li.addClass('question'); //for css selector issue
			
			li.load('/assets/ajax/survey-question-entry.html',  function() {
				
				// Make the test title editable
				$(this).find('span.question-description').highlight().simpleEdit({
					inputName: 'question-description[]'
				});

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
					li.find('div.question-body').multipleChoice();
					return false;
				});
				
				$(this).find('a.unsupported').click(function() {
					li.find('div.question-body').unsupported();
					return false;
				});
				
				$('ol#questions').append(li);				
			});
			
			return false;
		});
	}
	
})(jQuery);