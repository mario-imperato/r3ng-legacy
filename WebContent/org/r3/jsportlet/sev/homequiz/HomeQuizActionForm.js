$.r3Utils.namespace("org.r3.jsportlet.sev.homequiz");

org.r3.jsportlet.sev.homequiz.HomeQuizActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aQuizId)
	{
		this.setPageManager(aPageManager);
		this.enterView = new org.r3.jsportlet.sev.homequiz.HomeQuizActionFormEnterView(aDetailViewContainerId, this);
		this.sessionsView = new org.r3.jsportlet.sev.homequiz.HomeQuizActionFormSessionsView(aDetailViewContainerId, this);
		
		this.questionsView = new org.r3.jsportlet.sev.homequiz.HomeQuizActionFormView(aDetailViewContainerId, this);
		this.questionsOpaqueView = new org.r3.jsportlet.sev.homequiz.HomeQuizActionFormQAOpaqueView(aDetailViewContainerId, this);
		
		this.quizcolldto = null;
		this.quizuserblocks = null;
		
		this.quizId = aQuizId; // "quiz_20181101";
	},

	close : function()
	{
		this.hide();
	},

	hide : function()
	{
		this.detailView.hide();
	},

	show : function()
	{
		this.detailView.show();
	},

	refresh : function()
	{
	},

	open : function()
	{
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "quizcollectioninfo",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_QuizInfo', [ this.quizId ]),
			dataType : "json"
		});
		
		networkRequestsQueue.push(
		{
			id : "quizuserblocks",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_QuizUserBlocks', [ this.quizId ]),
			dataType : "json"
		});
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
            this.quizcolldto = new org.r3.db.mongo.quiz.quizcollection.QuizCollectionDTOAdapter(responseData['quizcollectioninfo']);
			if (this.quizcolldto.isOpaque())
			{
				this.questionsView = this.questionsOpaqueView;
			}
			var userblockresponsedata = responseData['quizuserblocks'];
			
			var useridentified = org.r3.PageManager.userInfo.isUser();
			
			if (!useridentified || org.r3.PageManager.isRestDTO(userblockresponsedata))
			{
				// Utente Not Enrolled Debbo Mostrare Il Pannello Di Invito
				this.enterView.open(this.quizcolldto);
			}
			else 
			{
				// Utente enrolled. Debbo Mostrare Il Pannello Lista Blocks.
				if (userblockresponsedata)
				{					
					this.quizuserblocks = 
					 new org.r3.db.DTOTableAdapter(userblockresponsedata, 
							function(aRowDataBean) { return new org.r3.db.mongo.quiz.quizuserblockcollection.QuizUserBlockCollectionDTOAdapter(aRowDataBean); },
							true);	
				}
				else
					this.quizuserblocks = null;
				
				this.sessionsView.open(this.quizcolldto, this.quizuserblocks);
			}
			
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});				
	},
	
	openSessionsPanel: function()
	{
		var networkRequestsQueue = [];		
		networkRequestsQueue.push(
		{
			id : "quizuserblocks",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_QuizUserBlocks', [ this.quizId ]),
			dataType : "json"
		});
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{            			
			var userblockresponsedata = responseData['quizuserblocks'];
			if (org.r3.PageManager.isRestDTO(userblockresponsedata))
			{
				// Si e' verificato un errore
			}
			else 
			{
				// Utente enrolled. Debbo Mostrare Il Pannello Lista Blocks.
				if (userblockresponsedata)
				{					
					this.quizuserblocks = 
					 new org.r3.db.DTOTableAdapter(userblockresponsedata, 
							function(aRowDataBean) { return new org.r3.db.mongo.quiz.quizuserblockcollection.QuizUserBlockCollectionDTOAdapter(aRowDataBean); },
							true);	
				}
				else
					this.quizuserblocks = null;
				
				this.sessionsView.open(this.quizcolldto, this.quizuserblocks);
			}
			
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});						
	},
	
	openQuestionsPanel: function(aUserBlockId)
	{
		this.questionsView.open(this.quizcolldto, aUserBlockId);
	}
				
});

