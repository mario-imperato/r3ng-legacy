$.r3Utils.namespace("org.r3.jsportlet.sev.homecard");

org.r3.jsportlet.sev.homecard.HomeCardActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aCardId, aTemplateName)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.sev.homecard.HomeCardActionFormView(aDetailViewContainerId, this);
		this.cardId = (aCardId) ? aCardId : "__NOCARDID_PROVIDED__";
		this.templateName = (aTemplateName) ? aTemplateName : "cms_tpl_simple";
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
		this.detailView.open(this.cardId, this.templateName);
	}
				
});

