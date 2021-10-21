$.r3Utils.namespace("org.r3.console.siteconfig.page");

org.r3.console.siteconfig.page.PageQueryActionForm = org.r3.ActionFormManager.extend(
{
	init : function(aPageManager, anHtmlActionFormContainerId, anAdvancedSearchHtmlActionFormContainerId)
	{
		this.setPageManager(aPageManager);

		this.listView = new org.r3.db.cms.page.PageQueryActionFormView(anHtmlActionFormContainerId, this,
		{
			dataTableId : 'PageQueryActionFormView',
			layout : 'fullWidth',
			iDisplayLength: 25,
			gradeLevel : 'grade_level2 grade_clickable',
			legend : org.r3.db.cms.page.message.queryactionformview_legend,
			dataTableSource : 'GET_Pages',
			sortable: true,
			// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
			dataTableColumns : "pageid;sort,pagetitle;sort,pageorder;sort",
			// requiredLUTs : [ "GET_classifier_usr_type", "LUT_UNEPAreaOrganizzativa", "LUT_UNEPCentroLavorazione", "LUT_UNEPCentroEsiti", "LUT_UNEPGruppoCliente", "LUT_UNEPCliente" ],

			onSelected : $.r3Utils.hitch(this, this.detailItem),
			onDblClick : null,
			onClearSelection : null,
			onClearSelection : null

		});

	},

	close : function()
	{
		// M20140201 - org.r3.PageManager.popBreadCrumb();
		this.listView.hide();
	},

	open : function()
	{
		this.listView.open();
	},

	hide : function()
	{
		this.listView.hide();
	},

	show : function()
	{
		this.listView.show();
	},

	refresh : function()
	{
		this.listView.refresh();
	},
	   
	newItem : function()
	{
		this.listView.hide();
		org.r3.console.cms.cards.PageManager.newCard();
	},

	detailItem : function(aDataBean)
	{
		this.listView.hide();
		org.r3.console.siteconfig.PageManager.openDetailPagePanel(aDataBean);
	}
	

});

