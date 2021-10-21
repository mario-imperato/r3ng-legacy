$.r3Utils.namespace("org.r3.shakeus.newsite");

org.r3.shakeus.newsite.SiteInfoActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.shakeus.newsite.SiteInfoActionFormView(aDetailViewContainerId, this);
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

	open : function(anOpeningOptionsHash)
	{
		this.detailView.open(anOpeningOptionsHash);
	},
	
	onSiteCreationRequestPosted: function(aSiteDTOAdapter)
	{
		this.close();
		this.pageManager.onSiteCreationRequestPosted(aSiteDTOAdapter);
	}
});

