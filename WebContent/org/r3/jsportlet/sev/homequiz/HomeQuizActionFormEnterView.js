$.r3Utils.namespace("org.r3.jsportlet.sev.homequiz");

org.r3.jsportlet.sev.homequiz.HomeQuizActionFormEnterView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.portletCanvasId = null;
		this.quizdto = null;
		
		this.helpPanelCallingSection = null;

	},

	close : function()
	{
		this.hide();
	},
	
	open : function(aQuizDtoAdapter)
	{
		// console.info('SiteConstants:', org.r3.SiteConstants);
		this.quizdto = aQuizDtoAdapter;
		
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/homequiz/HomeQuizActionFormEnter.html.jsp'),
			dataType : "html"
		});
							
		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_Agenda', [ org.r3.Constants.site ]));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();	
			
			this.portletCanvasId = $(this.htmlContainerId).attr("id");
			this.quizStatus = 'start';			
					    
			var membershipRequired = false;
			var useridentified = org.r3.PageManager.userInfo.isUser();
			if (useridentified && !org.r3.PageManager.userInfo.dataBean.companyid)
			{
				membershipRequired = true;
			}				
			
			var templatedHtml = tmpl(responseData['view'], { 			    
				 portletCanvasId: this.portletCanvasId, 
				 quizDto: this.quizdto,
				 membershipRequired: membershipRequired,
				 loginRequired: !useridentified
			});
 		    
			$(this.htmlContainerId).html(templatedHtml);	
 		    
			if (!useridentified)
			{
				$('#' + this.portletCanvasId + " .quiz-actions .quiz-action-start").hide();
				$('#' + this.portletCanvasId + " .quiz-actions .quiz-action-applymembership").hide();
			}
			
			if (membershipRequired)
			{
				$("#membership_form").validate
	            ({
		        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
		               rules: org.r3.jsportlet.sev.homequiz.membership_form_validationRules,
			           messages: org.r3.jsportlet.sev.homequiz.membership_form_validationMessages    
		        });
				
				$('#' + this.portletCanvasId + " .quiz-actions .quiz-action-start").prop('disabled', true);
				$('#' + this.portletCanvasId + " .quiz-actions .quiz-action-applymembership").unbind().click(
			 			  $.r3Utils.hitch(this, this.applyMembershipId)   
				);
				
				$('#entermembership_form_fieldset_message').formmessage({});
			}
			else
			{
				$('#' + this.portletCanvasId + " .quiz-actions .quiz-action-applymembership").hide();				
			}
			
 		   $('#' + this.portletCanvasId + " .quiz-actions .quiz-action-start").unbind().click(
 			  $.r3Utils.hitch(this, this.startQuiz)   
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
		
	startQuiz : function()
	{		
		var _self = this;
		
		var restUrl = org.r3.PageManager.getRESTUrl('POST_QuizEnter', [ this.quizdto.dataBean.quizid ]) 
		org.r3.AjaxUtils.ajaxInvoke(
				"post", restUrl, 
				function(responseData)
				{
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						// Devo Gestire Error
					}	
					
					_self.close();
					_self.actionFormManager.openSessionsPanel();
				},
				function(jqXHR, timeout, message) { console.error("startQuiz: " + message); }
		);
				
		org.r3.AjaxUtils.logUserActionEvent('ev_useraction', 'ev_quizenter', this.quizdto.dataBean.quizid);
	},
	
	applyMembershipId: function()
	{
		var _self = this;
		var theForm = $("#membership_form");
		org.r3.AjaxUtils.submitForm(
				"post", 
				org.r3.PageManager.getRESTUrl('POST_ApplyMembershipId', [ org.r3.PageManager.userInfo.nickname ]), 
				theForm,
				function(responseData) {
					var restDto = new org.r3.RestDTOAdapter(responseData);
					restDto.showMessage('entermembership_form_fieldset_message');
                    if (restDto.isOk()) 
                    {
                    	$('#' + _self.portletCanvasId + " .quiz-actions .quiz-action-applymembership").hide();	
                    	$('#' + _self.portletCanvasId + " .quiz-actions .quiz-action-start").prop('disabled', false);
                    }
				}, 
				function(jqXHR, timeout, message) { console.error(message); },
				"org.r3.jsportlet.sev.homequiz.message.membershipid_confirm",				
				true
		);
	}
	
		
});
