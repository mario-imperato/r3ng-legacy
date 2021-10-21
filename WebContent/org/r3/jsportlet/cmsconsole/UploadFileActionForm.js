$.r3Utils.namespace("org.r3.jsportlet.cmsconsole");

org.r3.jsportlet.cmsconsole.UploadFileActionForm = org.r3.ActionFormManager.extend(
{
	init : function(aPageManager, anUploadFileViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.uploadFileView = new org.r3.jsportlet.cmsconsole.UploadFileActionFormView(anUploadFileViewContainerId, this);
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

	open : function(aCardDTOAdapter)
	{
		this.setDataBeanInfo(aCardDTOAdapter);
		this.uploadFileView.open(aCardDTOAdapter);
	},

	uploadFile : function()
	{
	},

	releaseSession : function()
	{
		if (this.uploadFileView.isPendingUpload())
		{
			if (!org.r3.PageManager.confirmation("org.r3.jsportlet.cmsconsole.message.pendingUploads"))
				return;					
		}		
	}
	
});

