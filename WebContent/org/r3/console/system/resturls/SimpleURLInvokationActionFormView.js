$.r3Utils.namespace("org.r3.console.system.resturls");

org.r3.console.system.resturls.SimpleURLInvokationActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},

	clear : function()
	{
		$('#simpleurlinvokationactionform_form_responsedata').val();
	},
	
	open : function(anHttpMethod, aUrlToInvoke)
	{
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/system/resturls/SimpleURLInvokationActionForm.html'),
			dataType : "html"
		});

		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			$(this.htmlContainerId).html(responseData['view']);
 		   	
			$('#simpleurlinvokationactionform_form_url').val(aUrlToInvoke);
			$('#simpleurlinvokationactionform_form_method').val(anHttpMethod);
			$('#simpleurlinvokationactionform_form_responsedata').val();
			
			$('#simpleurlinvokationactionform_action_execute').unbind().click($.r3Utils.hitch(this.actionFormManager, this.actionFormManager.execute));
			
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
	}
	
});
