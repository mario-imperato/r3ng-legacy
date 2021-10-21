$.r3Utils.namespace("org.r3.jsportlet.mongocms");

org.r3.jsportlet.mongocms.TimelineQueryActionForm = org.r3.ActionFormManager.extend(
{
	init : function(aPageManager, anHtmlActionFormContainerId, anAdvancedSearchHtmlActionFormContainerId)
	{
		this.setPageManager(aPageManager);

		this.listView = new org.r3.db.mongo.timelinecollection.TimelineCollectionQueryActionFormView(anHtmlActionFormContainerId, this,
		{
			dataTableId : 'TimelineCollectionQueryActionFormView',
			layout : 'fullWidth',
			iDisplayLength: 25,
			gradeLevel : 'grade_level2 grade_clickable',
			legend : org.r3.db.mongo.timelinecollection.message.queryactionformview_legend,
			// dataTableSource : 'GET_Cards',
			sortable: true,
			// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
			dataTableColumns : "timelineid;sort,title;sort,lastmodified;sort",
			requiredLUTs : [ "GET_classifier_contentclassdef", "GET_classifier_m_contentclass_category", "GET_classifier_contentclassdef" ],

			onSelected : $.r3Utils.hitch(this, this.detailItem)

		});

	},

	close : function()
	{
		// M20140201 - org.r3.PageManager.popBreadCrumb();
		this.listView.hide();
	},

	open : function(aCategoryId)
	{
		var dataTableSource = org.r3.PageManager.getRESTUrl('GET_Timelines', [ org.r3.Constants.site, org.r3.Constants.language ]);

		this.listView.open({
			"dataTableSource": dataTableSource
		});			
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
	   
	detailItem : function(aDataBean)
	{
		this.listView.hide();
		this.pageManager.detailTimeline(aDataBean);
	}
	

});

