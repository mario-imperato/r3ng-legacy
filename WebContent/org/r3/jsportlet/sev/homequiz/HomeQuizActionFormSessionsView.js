$.r3Utils.namespace("org.r3.jsportlet.sev.homequiz");

org.r3.jsportlet.sev.homequiz.HomeQuizActionFormSessionsView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.portletCanvasId = null;
		this.quizdto = null;
		this.quizUserBlocks = null;
		
		this.helpPanelCallingSection = null;

	},

	close : function()
	{
		this.hide();
	},
	
	open : function(aQuizDtoAdapter, aUserBlocksDataTableAdapter)
	{
		// console.info('SiteConstants:', org.r3.SiteConstants);
		this.quizdto = aQuizDtoAdapter;
		this.quizUserBlocks = aUserBlocksDataTableAdapter;
		
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/homequiz/HomeQuizActionFormSessions.html.jsp'),
			dataType : "html"
		});
							
		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_Agenda', [ org.r3.Constants.site ]));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();	
			
			this.portletCanvasId = $(this.htmlContainerId).attr("id");	
					    
			var templatedHtml = tmpl(responseData['view'], { 			    
				 portletCanvasId: this.portletCanvasId, 
				 quizDto: this.quizdto,
				 quizUserBlocks : this.quizUserBlocks
			});
 		    
			$(this.htmlContainerId).html(templatedHtml);	
 		     		    		
 		   	$('#' + this.portletCanvasId + " .editableuserblock").unbind().click(
 	  	 			  $.r3Utils.hitch(this, this.startSession) 
 	 		   	);
 		   	
 		   	$('#' + this.portletCanvasId + " .quiz-action-help").unbind().click(
  	 			  $.r3Utils.hitch(this, this.showQuizHelp) 
 		   	);
 		  
 		   	$('#' + this.portletCanvasId + " .quiz-help-section .quiz-actions .quiz-action-closehelp").unbind().click(
	  	 			  $.r3Utils.hitch(this, this.hideQuizHelp) 
 		   	); 	
		   
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
		
	startSession : function(e)
	{		
		var _self = this;		
		var currentTarget = $(e.currentTarget);
		var userBlockId = currentTarget.attr("data-userblockid");
		
		org.r3.AjaxUtils.ajaxInvoke(
				
				"GET", 
				org.r3.PageManager.getRESTUrl('QUIZ_QuizSessionInfo', [ this.quizdto.dataBean.quizid, userBlockId ]), 
				
				$.r3Utils.hitch(this, function(responseData)
				{
					var quizblockinfo = new org.r3.db.mongo.quiz.quizuserblockcollection.QuizUserBlockCollectionDTOAdapter(responseData);
					if (quizblockinfo.canBeStarted())
					{
						console.info("Block: " + userBlockId);
						_self.close();
						_self.actionFormManager.openQuestionsPanel(userBlockId);						
					}
					else
					{
						org.r3.PageManager.alert("org.r3.jsportlet.sev.homequiz.message.session_cannotbestarted");
					}
				}),
				
				$.r3Utils.hitch(this, function(jqXHR, timeout, message)
				{
					console.log(arguments);	
				})
		);	

		
	}
	
		
});
