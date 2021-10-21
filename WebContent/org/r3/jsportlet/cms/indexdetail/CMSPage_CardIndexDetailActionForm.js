$.r3Utils.namespace("org.r3.jsportlet.cms.indexdetail");

org.r3.jsportlet.cms.indexdetail.CMSPage_CardIndexDetailActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.cms.indexdetail.CMSPage_CardIndexDetailActionFormView(aDetailViewContainerId, this);		
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

	refresh: function()
	{
	},
	
	open : function(aPageDTOAdapter, cardInfo, options)
	{
		this.detailView.open(aPageDTOAdapter, cardInfo, options);		
	}

		
});

