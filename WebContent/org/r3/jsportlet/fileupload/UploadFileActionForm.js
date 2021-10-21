$.r3Utils.namespace("org.r3.jsportlet.fileupload");

org.r3.jsportlet.fileupload.UploadFileActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.fileupload.UploadFileActionFormView(aDetailViewContainerId, this);
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

	open : function(fileUploadOptions)
	{
		this.detailView.open(fileUploadOptions);
	},
	
	closeFileUpload: function(onCloseActionForm)
	{
		var _self = this;

		onCloseActionForm();
	}
		
});

