$.r3Utils.namespace("org.r3.jsportlet.mongocms");

org.r3.jsportlet.mongocms.CardQueryActionForm = org.r3.ActionFormManager.extend(
{
	init : function(aPageManager, anHtmlActionFormContainerId, anAdvancedSearchHtmlActionFormContainerId)
	{
		this.setPageManager(aPageManager);

		this.advancedSearchForm = new org.r3.jsportlet.mongocms.CardQueryAdvancedSearchActionFormView(anAdvancedSearchHtmlActionFormContainerId, this);
		this.advancedSearchForm.open();

		this.listView = new org.r3.db.mongo.postcollection.PostCollectionQueryActionFormView(anHtmlActionFormContainerId, this,
		{
			dataTableId : 'PostCollectionQueryActionFormView',
			layout : 'fullWidth',
			iDisplayLength: 25,
			gradeLevel : 'grade_level2 grade_clickable',
			legend : org.r3.db.mongo.postcollection.message.queryactionformview_legend,
			// dataTableSource : 'GET_Cards',
			sortable: true,
			// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
			dataTableColumns : "postid;sort,title;sort,contentclass,authorname,lastmodified;sort",
			requiredLUTs : [ "GET_classifier_contentclassdef" ],

			onSelected : $.r3Utils.hitch(this, this.detailItem),
			onDblClick : null,
			
			onClearSelection : function() { 
				$('#cardqueryactionform_action_deleteItem').prop('disabled', true);
			},

			searchInfo :
			{
                widget: 'select',

          		widgetInitialization: {
          			url: org.r3.PageManager.getRESTUrl('GET_classifier_m_contentclass'),
          			blankOptionText: org.r3.PageManager.getMessageFromDict("org.r3.jsportlet.mongocms.message.any")
          		},
          		
          	    label: org.r3.jsportlet.mongocms.message.search_category,
          	    validationRules: org.r3.jsportlet.mongocms.CardQueryActionFormView_filter_searchform_validationRules,
          	    validationMessages: org.r3.jsportlet.mongocms.CardQueryActionFormView_filter_searchform_validationMessages,
          	    autoStart: true
          	},

          	advancedSearchInfo: [
      	    {
      	    	  label: org.r3.jsportlet.mongocms.message.search_advanced,
      	    	  actionView: this.advancedSearchForm,
      	    	  autoOpen: false
      	    }]

//			buttons : [
//			{
//				id : 'cardqueryactionform_action_newcard',
//				label : 'Nuovo',
//				disabled : false,
//				onClick : $.r3Utils.hitch(this, this.newItem)
//			}]

		});

	},

	close : function()
	{
		// M20140201 - org.r3.PageManager.popBreadCrumb();
		this.listView.hide();
	},

	open : function(aCategoryId)
	{
		var dataTableSource = org.r3.PageManager.getRESTUrl('GET_Posts', [ org.r3.Constants.site, org.r3.Constants.language ]);
		if (aCategoryId)
		{
			dataTableSource = org.r3.PageManager.getRESTUrl('GET_PostsByContentClass', [ org.r3.Constants.site, org.r3.Constants.language, aCategoryId ]);
		}	

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
	   
	newItem : function()
	{
		this.listView.hide();
		this.pageManager.newCard();
	},

	detailItem : function(aDataBean)
	{
		this.listView.hide();
		this.pageManager.detailCard(aDataBean);
	}
	
//	deleteItem : function()
//	{
//		var _self = this;
//
//		var selectedCard = this.listView.fnGetSelectedDataBean();
//		if (org.r3.PageManager.confirmation("org.r3.message.deleteconfirm"))
//		{
//			var method = "DELETE";
//			var restUrl = null;
//			var cardId = selectedCard.dataBean.cardid;
//			restUrl = org.r3.PageManager.getRESTUrl('DELETE_Card', [ cardId ]);
//
//			org.r3.PageManager.wait("org.r3.message.waiting");
//			$.ajax(
//			{
//				"type" : method,
//				"url" : restUrl,
//				"dataType" : "json",
//				"success" : function()
//				{
//					org.r3.PageManager.closeNotifier();
//					_self.listView.refresh();
//				},
//				"error" : function(jqXHR, timeout, message)
//				{
//					console.error("CardQueryActionForm: ", message);
//				}
//			});
//		}
//	}

//	,
//
//	search : function()
//	{
//		this.listView.clearQueryParameters();
//		this.listView.applyFnFilter($('#dataTables_filter_user').attr('value'));
//	},
//
//	advancedSearch : function()
//	{
//		$('#dataTables_filter_user').attr('value', null);
//		this.listView.applyFnFilter('');
//	}

});

