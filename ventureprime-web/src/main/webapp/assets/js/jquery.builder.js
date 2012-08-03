(function($) {

	/**
	 * Runs the test task builder
	 * page
	 */
	$.fn.taskBuilder = function(options) {
		
		/*
		 * Set default options
		 */
		options = options || {
			
		};
		
		/*
		 * Update the index when a question
		 * is added or deleted to the list
		 */
		function updateIndexes() {
			this.find('ol#tasks li').each(function() {
				var index = $('ol#tasks li').index(this);
				$(this).find('div.order').html((index + 1) + '.');
				$(this).find('input.taskTitle').attr('name', 'taskTitle').attr('id', 'taskTitle' + index)
				$(this).find('textarea.taskDescription').attr('name', 'taskDescription').attr('id', 'taskDescription' + index);
			});
		}
		
		/*
		 * Enable the delete button
		 */
		this.find('a.delete').click(function(){
			alert('You are deleting a task!');
			return false;
		});

		/*
		 * Enable the new task button
		 */
		this.find('a#newTask').click(function() {
			var li = $(document.createElement('li'));
			li.load('/assets/ajax/test-task-entry.html',  function() {				
				var link = $(this).find('a.delete').click(function() {
					li.remove();
					updateIndexes();
					var taskCount = this.find('ol#tasks li').length;
					if (taskCount == 0) {
						this.find('p#noTasks').show();
					}
					return false;
				});				
				this.find('ol#tasks').append(li);
				updateIndexes();				
			});

			// Remove notice
			this.find('p#noTasks').hide();

			return false;
		});

		return true;
	};
	
	/**
	 * Runs the survey question
	 * builder page
	 */
	$.fn.surveyBuilder = function(options) {
		
		/*
		 * Update the index when a question
		 * is added or deleted to the list
		 */
		function updateIndexes() {
			this.find('ol#questions li').each(function() {
				var index = this.find('ol#questions li.question').index(this);
				$(this).find('div.order').html((index + 1) + '.');
			});
		}
		
		/*
		 * Enable the delete button
		 */
		this.find('a.delete').click(function(){
			alert('You are deleting a question!');
			return false;
		});

		/*
		 * Enable the new task button
		 */
		this.find('a#newQuestion').click(function() {
			var li = $(document.createElement('li'));
			li.addClass('question'); //for css selector issue
			
			function deleteQuestion() {
				li.remove();
				updateIndexes();
				var taskCount = this.find('ol#questions li.question').length;
				if (taskCount == 0) {
					this.find('p#noTasks').show();
				}
				return false;
			}
			
			li.load('/assets/ajax/survey-question-entry.html',  function() {
				
				var link = $(this).find('a.delete').click(function() {
					li.remove();
					updateIndexes();
					var taskCount = this.find('ol#questions li').length;
					if (taskCount == 0) {
						this.find('p#noTasks').show();
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
				
				this.find('ol#questions').append(li);
				updateIndexes();
				
			});

			// Remove notice
			this.find('p#noQuestions').hide();

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

		return true;
	}

})(jQuery);