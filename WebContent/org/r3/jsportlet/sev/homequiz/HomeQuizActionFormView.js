$.r3Utils.namespace("org.r3.jsportlet.sev.homequiz");

org.r3.jsportlet.sev.homequiz.HomeQuizActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.portletCanvasId = null;
		this.quizdto = null;
		this.quizblockdto = null;
		
		this.quizStatus = 'start';
		
		this.questionIndex = 0;
		this.currentQuestion = null;
		this.currentQuestionNumberOfResponses = 0;
		
		this.helpPanelCallingSection = null;

	},

	close : function()
	{
		this.hide();
	},
	
	open : function(aQuizDtoAdapter, aUserBlockId)
	{
		// console.info('SiteConstants:', org.r3.SiteConstants);
		this.quizdto = aQuizDtoAdapter;
		
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/homequiz/HomeQuizActionForm.html.jsp'),
			dataType : "html"
		});
			
		networkRequestsQueue.push(
		{
			id : "templates",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/homequiz/HomeQuizActionFormView_Template.html.jsp'),
			dataType : "html"
		});
		
		networkRequestsQueue.push(
		{
			id : "quizuserblock",
			type : "Post",
			url : org.r3.PageManager.getRESTUrl('POST_QuizStartSession', [ this.quizdto.dataBean.quizid, aUserBlockId ]),
			dataType : "json"
		});
		
		
		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_Agenda', [ org.r3.Constants.site ]));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();	
			
			this.portletCanvasId = $(this.htmlContainerId).attr("id");
			this.quizStatus = 'start';			
			
			this.quizblockdto = new org.r3.db.mongo.quiz.quizuserblockcollection.QuizUserBlockCollectionDTOAdapter(responseData['quizuserblock']);
		    
			var templatedHtml = tmpl(responseData['view'], { 
			     quizblockdto : this.quizblockdto,
				 portletCanvasId: this.portletCanvasId, 
				 quizDto: this.quizdto 
			});
 		    
			$(this.htmlContainerId).html(templatedHtml);	
 		    
 		    $(this.htmlContainerId).append(responseData['templates']);
 		    		   
		    $('#' + this.portletCanvasId + " .quiz-question-section .quiz-actions .quiz-action-answer").unbind().click(
			  $.r3Utils.hitch(this, this.answerQuizQuestion) 
		    ); 		  
		   		   
		    $('#' + this.portletCanvasId + " .quiz-question-section .quiz-actions .quiz-action-next").unbind().click(
	 			  $.r3Utils.hitch(this, this.nextQuizQuestion) 
		    ); 	
		   
		    $('#' + this.portletCanvasId + " .quiz-end-section .quiz-actions .quiz-action-end").unbind().click(
		 			  $.r3Utils.hitch(this.actionFormManager, this.actionFormManager.openSessionsPanel) 
			); 	
		    
		    $('#' + this.portletCanvasId + " .quiz-action-help").unbind().click(
	 			  $.r3Utils.hitch(this, this.showQuizHelp) 
		    );
 		  
		    $('#' + this.portletCanvasId + " .quiz-help-section .quiz-actions .quiz-action-closehelp").unbind().click(
	  	 			  $.r3Utils.hitch(this, this.hideQuizHelp) 
	  		); 	
		   
		    this.startQuiz();
		    this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
		
	},
	
	hideQuizHelp: function()
	{
		$('#' + this.portletCanvasId + " .quiz-help-section").hide();
		this.helpPanelCallingSection.show();
	},
	
	showQuizHelp: function()
	{
		this.helpPanelCallingSection = $('#' + this.portletCanvasId + " .box-info:visible");
		this.helpPanelCallingSection.hide();
		$('#' + this.portletCanvasId + " .quiz-help-section").show();
	},
	
	answerQuizQuestion : function()
	{
		var _self = this;
		var selectedAnswer = $('#' + this.portletCanvasId + " .quiz-question-section input[type='radio'][name='quiz-question-answer']:checked").val();		
		if (selectedAnswer)
		{
			var questionAnswer = this.quizblockdto.findAnswer4(this.currentQuestion, selectedAnswer);
			console.log(" --- ", selectedAnswer, questionAnswer);
			
			if (questionAnswer)
			{
				if (this.currentQuestion.selectedAnswer == null || selectedAnswer != this.currentQuestion.selectedAnswer)
				{
					// Gestisco lato client la risposta al secondo tentativo
					if (this.currentQuestion.numberOfResponses == 1)
						_self.updateUIOnAnsweredQuestion(selectedAnswer, questionAnswer);
					else
					{
					var restUrl = org.r3.PageManager.getRESTUrl('POST_QuizAnswerQuestion', 
							[ this.quizdto.dataBean.quizid, this.quizblockdto.dataBean.quizuserblocknumber, this.currentQuestion.questionid, selectedAnswer ]);
					org.r3.AjaxUtils.ajaxInvoke(
							"post", restUrl, 
							function(responseData)
							{
								if (org.r3.PageManager.isRestDTO(responseData))
								{
									var restDto = new org.r3.RestDTOAdapter(responseData);
									if (restDto.isOk())
										_self.updateUIOnAnsweredQuestion(selectedAnswer, questionAnswer);
									else if (restDto.reasoncode == 'QTIMEOUT')
									{
										_self.onTimeout();
									}
								}	
								
							},
							function(jqXHR, timeout, message) { console.error("startQuiz: " + message); }
					);
					}
					
				}
			}
			
			org.r3.AjaxUtils.logUserActionEvent('ev_useraction', 'ev_quizanswer', this.quizdto.dataBean.quizid);
		}
	},

	updateUIOnAnsweredQuestion: function(selectedAnswer, questionAnswer)
	{
		this.currentQuestion.numberOfResponses++;
		this.currentQuestion.selectedAnswer = selectedAnswer;
		
		if (questionAnswer.valid)
		{
			$('#' + this.portletCanvasId + " .quiz-question-section .quiz-question-correct-feedback").show();
			$('#' + this.portletCanvasId + " .quiz-question-section .quiz-question-correct-feedback p").html(
					org.r3.jsportlet.sev.homequiz.message.answer_correct
			);
			
			$('#' + this.portletCanvasId + " .quiz-question-section .quiz-question-error-feedback").hide();
			$('#' + this.portletCanvasId + " .quiz-question-section .quiz-actions .quiz-action-answer").prop('disabled', true);
			this.currentQuestion.selectedAnswerValid = true;					
			if (this.currentQuestion.numberOfResponses == 1)
			{
				this.quizblockdto.numberOfOK++;
			}
			else
			{
				this.quizblockdto.numberOfKO--;
				this.quizblockdto.numberOfRepaired++;
			}
		}
		else
		{										
			if (this.currentQuestion.numberOfResponses == 1)
			{
				this.quizblockdto.numberOfKO++;								
				$('#' + this.portletCanvasId + " .quiz-question-section .quiz-question-error-feedback p").html(
						org.r3.jsportlet.sev.homequiz.message.answer_first_error
				);
			}
			else
			{
				$('#' + this.portletCanvasId + " .quiz-question-section .quiz-question-error-feedback p").html(
						org.r3.jsportlet.sev.homequiz.message.answer_second_error + '<b>' + this.quizblockdto.findCorrectAnswer(this.currentQuestion).text + '</b>'
						
				);
				
				$('#' + this.portletCanvasId + " .quiz-question-section .quiz-actions .quiz-action-answer").prop('disabled', true);							
			}
			
			$('#' + this.portletCanvasId + " .quiz-question-section .quiz-question-error-feedback").show();
		}
										
		$('#' + this.portletCanvasId + " .quiz-question-section .quiz-actions .quiz-action-next").prop('disabled', false);	
		
		this.refreshCounterInformation(this.quizblockdto);		
	},
	
	refreshCounterInformation: function(aQuizDtoAdapter)
	{
		$('#' + this.portletCanvasId + " .quiz-question-section .quiz-counters .quiz-info-box-numberofok").html(aQuizDtoAdapter.numberOfOK);
		$('#' + this.portletCanvasId + " .quiz-question-section .quiz-counters .quiz-info-box-numberofko").html(aQuizDtoAdapter.numberOfKO);
		$('#' + this.portletCanvasId + " .quiz-question-section .quiz-counters .quiz-info-box-numberofrepaired").html(aQuizDtoAdapter.numberOfRepaired);
	},
	
	endQuiz : function()
	{
		$('#' + this.portletCanvasId + " .quiz-question-section .quiz-timer-display-data").timer('remove');
		$('#' + this.portletCanvasId + " .quiz-question-section").hide();
		
		var templatedHtml = tmpl('template-homeportlet-quiz-report', { quiz: this.quizdto, quizblockdto: this.quizblockdto} );
		$('#' + this.portletCanvasId + " .quiz-end-section .quiz-report").html(templatedHtml);
		$('#' + this.portletCanvasId + " .quiz-end-section .quiz-score-value").html(this.quizblockdto.getScore());
		$('#' + this.portletCanvasId + " .quiz-end-section .quiz-score-description").html(this.quizdto.getScoreComment(this.quizblockdto.getScore()));
		
		$('#' + this.portletCanvasId + " .quiz-end-section .quiz-result").show();
		$('#' + this.portletCanvasId + " .quiz-end-section").show();
		
		org.r3.AjaxUtils.logUserActionEvent('ev_useraction', 'ev_quizend', this.quizdto.dataBean.quizid);
	},
	
	onTimeout: function()
	{
		var _self = this;
		$('#' + _self.portletCanvasId + " .quiz-question-section .quiz-timer-display-data").timer('remove');		        
        $('#' + _self.portletCanvasId + " .quiz-timer .quiz-timer-display").addClass("timed-out");		        		        		        
        
        $('#' + _self.portletCanvasId + " .quiz-question-section .quiz-actions .quiz-action-answer").prop('disabled', true);
        $('#' + _self.portletCanvasId + " .quiz-question-section .quiz-actions .quiz-action-next").prop('disabled', false);
        
        $('#' + _self.portletCanvasId + " .quiz-question-section .quiz-question-correct-feedback").hide();		        
        $('#' + _self.portletCanvasId + " .quiz-question-section .quiz-question-error-feedback").hide();
        $('#' + _self.portletCanvasId + " .quiz-question-section .quiz-question-timedout-feedback").show();
        $('#' + _self.portletCanvasId + " .quiz-question-section .quiz-question-timedout-feedback p").html(
				org.r3.jsportlet.sev.homequiz.message.quiz_timedout						
		);
        
        _self.quizStatus = 'timedout';	
	},
	
	startQuiz : function()
	{		
		var _self = this;
		
		// $('#' + this.portletCanvasId + " .quiz-end-section .quiz-actions").hide();		
		$('#' + this.portletCanvasId + " .quiz-end-section").hide();
		
		$('#' + this.portletCanvasId + " .quiz-question-section").show();
		$('#' + this.portletCanvasId + " .quiz-question-section .quiz-counters .quiz-info-box-numberofquestions").html(this.quizblockdto.getBlockSize() + '/' + this.quizblockdto.getNumberOfQuestions());
		$('#' + this.portletCanvasId + " .quiz-question-section .quiz-counters .quiz-info-box-numberofok").html("0");
		$('#' + this.portletCanvasId + " .quiz-question-section .quiz-counters .quiz-info-box-numberofrepaired").html("0");
		$('#' + this.portletCanvasId + " .quiz-question-section .quiz-counters .quiz-info-box-numberofko").html("0");
				
		this.questionIndex = 0;
		this.currentQuestion = this.quizblockdto.getQuestion(this.questionIndex);
		this.initializeQuizQuestion(this.questionIndex, this.currentQuestion);
		
		$('#' + this.portletCanvasId + " .quiz-question-section .quiz-timer-display-data").timer
		({
			seconds: this.quizblockdto.getUserTimer(),
		    duration: this.quizblockdto.dataBean.duration,
		    callback: function() {
				_self.onTimeout();
		    }			
		});	 	
		
		org.r3.AjaxUtils.logUserActionEvent('ev_useraction', 'ev_quizstart', this.quizdto.dataBean.quizid);
	},
	
	initializeQuizQuestion: function(aQuestionIndex, aQuestion)
	{
		var templatedHtml = tmpl('template-homeportlet-quiz-question', { questionIndex: aQuestionIndex, question: aQuestion } );
		$('#' + this.portletCanvasId + " .quiz-question-section .quiz-question").html(templatedHtml);		
		$('#' + this.portletCanvasId + " .quiz-question-section .quiz-question-error-feedback").hide();
		$('#' + this.portletCanvasId + " .quiz-question-section .quiz-question-correct-feedback").hide();
	
		$('#' + this.portletCanvasId + " .quiz-question-section .quiz-actions .quiz-action-next").prop('disabled', true);
		$('#' + this.portletCanvasId + " .quiz-question-section .quiz-actions .quiz-action-answer").prop('disabled', false);
		
		aQuestion.numberOfResponses = 0;
		aQuestion.selectedAnswer = null;
		aQuestion.selectedAnswerValid = false;
	},
	
	nextQuizQuestion: function()
	{
		if (this.quizStatus == 'timedout' || this.questionIndex >= (this.quizblockdto.getNumberOfQuestions() - 1))
		{
			this.endQuiz();
		}
		else
		{			
		this.questionIndex++;
		this.currentQuestion = this.quizblockdto.getQuestion(this.questionIndex);
		this.initializeQuizQuestion(this.questionIndex, this.currentQuestion);
		}
	}
	
});
