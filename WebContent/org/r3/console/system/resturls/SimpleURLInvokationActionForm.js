$.r3Utils.namespace("org.r3.console.system.resturls");

org.r3.console.system.resturls.SimpleURLInvokationActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.console.system.resturls.SimpleURLInvokationActionFormView(aDetailViewContainerId, this);
	},

	close : function()
	{
		// M20140201 - org.r3.PageManager.popBreadCrumb();
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

	open : function(theMethod, theUrlToInvoke)
	{
		console.log("SimpleURLInvokationActionForm::open", theMethod, theUrlToInvoke);
		this.detailView.open(theMethod, theUrlToInvoke);
		this.show();
	},
	
	execute: function()
	{
		var _self = this;		
		var theForm = $('#simpleurlinvokationactionform_form');
		
		this.detailView.clear();
		
		var restUrl = $('#simpleurlinvokationactionform_form_url').val();
		var method = $('#simpleurlinvokationactionform_form_method').val();
		
		if (theForm.valid())
		{
			org.r3.PageManager.wait("org.r3.message.waiting");
			$.ajax(
			{
				"type" : method,
				"url" : restUrl,
				"dataType" : "json",
				"success" : function(responseData)
				{
					org.r3.PageManager.closeNotifier();
					if (!responseData)
						$('#simpleurlinvokationactionform_form_riesponsedata').val("ResponseData is empty");
					else 
					{
						var str = JSON.stringify(responseData, undefined, 2);
						$('#simpleurlinvokationactionform_form_riesponsedata').val(str);
					}
						
				},
				"error" : function(jqXHR, timeout, message)
				{
					org.r3.PageManager.closeNotifier();
					$('#simpleurlinvokationactionform_form_riesponsedata').val(message);
				}
			});
		}	    	
	}
	
});

