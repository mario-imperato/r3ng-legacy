$.r3Utils.namespace("org.r3.jsportlet.mongocms");

org.r3.jsportlet.mongocms.CardPickerActionForm = org.r3.ActionFormManager.extend({

	init : function(aPageManager, anHtmlActionFormContainerId, anAdvancedSearchHtmlActionFormContainerId) 
	{
		this.setPageManager(aPageManager);
		
		this.advancedSearchForm = new org.r3.jsportlet.mongocms.CardQueryAdvancedSearchActionFormView(anAdvancedSearchHtmlActionFormContainerId, this);
		this.advancedSearchForm.open();
		
		this.pickedValue = null;
		
		this.listView = new org.r3.db.cms.card.CardQueryActionFormView(anHtmlActionFormContainerId, this,
		{
			dataTableId : 'CardQueryActionFormView',
			// layout : 'fullWidth',
			gradeLevel : 'grade_level2 grade_clickable',
			legend : org.r3.db.cms.card.message.queryactionformview_legend,
			// dataTableSource : 'GET_Users',
			sortable: true,
			layout : 'fullWidth',
			actionBarOnTop: true,
			
			// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
			dataTableColumns : "singleselector,valid,cardid;sort,systemtitle;sort,categoryid,refdate;sort,queryformview-tools",
			// requiredLUTs : [ "GET_classifier_usr_type", "LUT_UNEPAreaOrganizzativa", "LUT_UNEPCentroLavorazione", "LUT_UNEPCentroEsiti", "LUT_UNEPGruppoCliente", "LUT_UNEPCliente" ],

			onToolsIconSelected: $.r3Utils.hitch(this, this.detailItem),
			onSelected :  $.r3Utils.hitch(this, this._onRowSelected),
			onClearSelection: null,
			onDblClick : null,
			onPageChange : $.r3Utils.hitch(this, function() { 
				$('#cardpickeractionform_action_selectcard').prop('disabled', true);				
			}),

			searchInfo :
			{
                widget: 'select',

          		widgetInitialization: {
          			url: org.r3.PageManager.getRESTUrl('LUT_CMS_Category'),
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
      	    }],

			buttons : [
			{
				id : 'cardpickeractionform_action_selectcard',
				label : org.r3.message.action_select,
				disabled : true,
				onClick : $.r3Utils.hitch(this, this.onItemSelected)
			} ],
			
			onInitializationComplete : $.r3Utils.hitch(this, function()
			{
				var matchExpr = 'input[name="cardid"]';
				$('#CardQueryActionFormView_tableform').off('click', matchExpr).on('click', matchExpr, $.r3Utils.hitch(this, function(e) 
				{					
					$('#cardpickeractionform_action_selectcard').prop('disabled', false);
					
					var currentTarget = $(e.currentTarget);
					this.pickedValue = 
					{
						dtokey : currentTarget.val(),
						dtodescr : currentTarget.val() + ' - ' + currentTarget.attr('title')							
					};
					
					e.stopPropagation();
				}));		
			})

		});

	},

	close : function() 
	{
		this.hide();
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
	},

	open : function(options)
	{
		this.srcPickerWidget = options.pickerWidget;
		
		var dataTableSourceRestUrlReference = 'GET_Cards';
		if (options.queryUrl)
			dataTableSourceRestUrlReference = options.queryUrl;
		
		var dataTableSource = org.r3.PageManager.getRESTUrl(dataTableSourceRestUrlReference);
		
		this.listView.open({
				"dataTableSource": dataTableSource,
				"onInitializationCompleteArgs": arguments
		});
		
	},

	onItemSelected : function() {
		console.info("actionForm:pickerWidget is: ", this.srcPickerWidget);
		this.srcPickerWidget.addVal(this.pickedValue);
		org.r3.PageManager.back();
	},
	
	_onRowSelected : function(aCardDTOAdapter) 
	{
		$('#CardQueryActionFormView_' + aCardDTOAdapter.dataBean.cardid).prop('checked', true);
		$('#cardpickeractionform_action_selectcard').prop('disabled', false);
		
		this.pickedValue = 
		{
			dtokey : aCardDTOAdapter.dataBean.cardid,
			dtodescr : aCardDTOAdapter.dataBean.cardid + ' - ' + aCardDTOAdapter.dataBean.systemtitle							
		};		
	},
	
    detailItem: function(aCardDTOAdapter)
    {
		this._onRowSelected(aCardDTOAdapter);				
		this.hide();
		this.pageManager.openCardDetailPanel(aCardDTOAdapter);
    }


});

