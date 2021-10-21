$.r3Utils.namespace("org.r3.jsportlet.outmail");

org.r3.jsportlet.outmail.SentMailMessageActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, anUploadAttachmentContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.outmail.SentMailMessageActionFormView(aDetailViewContainerId, this);
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

	open: function(anOutMailSpoolerDTOAdapter)
	{
		this.detailView.open(anOutMailSpoolerDTOAdapter);			
	},
	
	listaMail : function()
	{
		org.r3.PageManager.back();
	}
		
});

