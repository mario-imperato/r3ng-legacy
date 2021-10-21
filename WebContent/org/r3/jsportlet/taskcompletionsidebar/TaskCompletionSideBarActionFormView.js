$.r3Utils.namespace("org.r3.jsportlet.rndphotosidebar");

org.r3.jsportlet.taskcompletionsidebar.TaskCompletionSideBarActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);		
	},

	close : function()
	{
		this.hide();
	},
	
	refresh : function(configHash)
	{
		var kd = $('#taskcompletionsidebar-progress-indicator');
		var v = configHash.taskCompletionLevel;
		if (v)
		     kd.val(v).trigger('change');
	},
	
	open : function(configHash)
	{
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/taskcompletionsidebar/TaskCompletionSideBarActionFormView.html.jsp'),
			dataType : "html"
		});

		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_SailEvent'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	

			var displayOptions = $.extend(this.defaultOptionsHash, configHash);
			displayOptions.startIcon = 1;
			
			var templatedHtml = tmpl(responseData['view'], displayOptions);
			$(this.htmlContainerId).html(templatedHtml);
			
			var kd = $('#taskcompletionsidebar-progress-indicator');
			kd.knob({ 
				'format': function(v) { return  (v || '0') + '%'; }
			});
			
			var v = configHash.taskCompletionLevel;
			if (v)
			     kd.val(v).trigger('change');
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
	}
		
});
