$.r3Utils.namespace("org.r3.jsportlet.sev.myapp");

org.r3.jsportlet.sev.myapp.MyAppActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.sev.myapp.MyAppActionFormView(aDetailViewContainerId, this);
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
		// Non faccio nulla se non e' loggato..
		if (!org.r3.PageManager.userInfo.isGuest())
		      this.detailView.open();
	},
	
	editApplication: function(applicationId)
	{
		var targetUrl = org.r3.Constants.getStrutsActionContext() + '/org/r3/sev/application/editMyApplication.do?objid=' + applicationId;
		org.r3.PageManager.gotoPage(targetUrl);
	},
	
	newApplication: function()
	{
		var _self = this;
		var method = 'POST';
		var restUrl = org.r3.PageManager.getRESTUrl('POST_SEV_MyApplications');
		org.r3.PageManager.wait("org.r3.message.waiting");
		$.ajax(
		{
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"success" : function(responseData)
			{
				org.r3.PageManager.closeNotifier();
				_self.editApplication(responseData.applicationid);
			},
			"error" : function(jqXHR, timeout, message)
			{
				console.error("AccettazioneActionForm: ", message);
			}
		});
	}
			
});

