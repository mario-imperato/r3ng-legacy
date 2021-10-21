$.r3Utils.namespace("org.r3.jsportlet.cms");

org.r3.jsportlet.cms.CMSPage_CardPagedIndexActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aDetailViewCMSCardIndexContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.cms.CMSPage_CardPagedIndexActionFormView(aDetailViewContainerId, aDetailViewCMSCardIndexContainerId, this);		
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
	},
	
	openCMSCardDetailByPageIdCardId: function(pageId, cardId)
	{
		this.hide();
		this.pageManager.openCMSCardDetailByPageIdCardId(pageId, cardId);
	}
		
});

