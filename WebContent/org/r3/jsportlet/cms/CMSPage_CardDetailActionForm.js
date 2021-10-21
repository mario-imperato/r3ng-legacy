$.r3Utils.namespace("org.r3.jsportlet.cms");

org.r3.jsportlet.cms.CMSPage_CardDetailActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.cms.CMSPage_CardDetailActionFormView(aDetailViewContainerId, this);		
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
	
	open : function(pageInfo, cardInfo, options)
	{
		this.detailView.open(pageInfo, cardInfo, options);		
	}

		
});

