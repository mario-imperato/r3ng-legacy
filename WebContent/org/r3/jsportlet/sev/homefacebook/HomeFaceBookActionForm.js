$.r3Utils.namespace("org.r3.jsportlet.sev.homefacebook");

org.r3.jsportlet.sev.homefacebook.HomeFaceBookActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId,  aDataCardId, aDataOptions)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.sev.homefacebook.HomeFaceBookActionFormView(aDetailViewContainerId, this);
				
		this.portletWidth = (aDataOptions) ? aDataOptions : "300";
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
		this.detailView.open(this.portletWidth);
	}
				
});

