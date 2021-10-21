$.r3Utils.namespace("org.r3.console.siteconfig.site");

org.r3.console.siteconfig.site.UploadFileActionForm = org.r3.ActionFormManager.extend(
{
	init : function(aPageManager, anUploadFileViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.uploadFileView = new org.r3.console.siteconfig.site.UploadFileActionFormView(anUploadFileViewContainerId, this);
	},

	close : function()
	{
		// M20140201 - org.r3.PageManager.popBreadCrumb();
		this.hide();
	},

	hide : function()
	{
		this.uploadFileView.hide();
	},

	show : function()
	{
		this.uploadFileView.show();
	},

	open : function(aCardId)
	{
		this.setDataBeanInfo(aCardId);
		this.uploadFileView.open(aCardId);
	},

	uploadFile : function()
	{
	},

	releaseSession : function()
	{
		if (this.uploadFileView.isPendingUpload())
		{
			if (!org.r3.PageManager.confirmation("org.r3.console.cms.cards.message.pendingUploads"))
				return;					
		}		
	}
	
});

