$.r3Utils.namespace("org.r3.jsportlet.user");

org.r3.jsportlet.user.UserPickerActionForm = org.r3.ActionFormManager.extend({

	init : function(aPageManager, anHtmlActionFormContainerId, anAdvancedSearchHtmlActionFormContainerId) 
	{
		this.setPageManager(aPageManager);
		
		this.advancedSearchForm = new org.r3.jsportlet.user.UserQueryAdvancedSearchActionFormView(anAdvancedSearchHtmlActionFormContainerId, this);
		this.advancedSearchForm.open();
		
		this.pickedValue = null;
		
		this.listView = new org.r3.db.system.user.user.UserQueryActionFormView(anHtmlActionFormContainerId, this,
		{
			dataTableId : 'R3UserQueryActionFormView',
			// layout : 'fullWidth',
			gradeLevel : 'grade_level2 grade_clickable',
			legend : org.r3.db.system.user.user.message.queryactionformview_legend,
			// dataTableSource : 'GET_Users',
			sortable: false,
			layout : 'fullWidth',
			actionBarOnTop: true,
			
			// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
			dataTableColumns : "singleselector,userid,nickname,firstname,lastname,email,queryformview-tools",
			// requiredLUTs : [ "GET_classifier_usr_type", "LUT_UNEPAreaOrganizzativa", "LUT_UNEPCentroLavorazione", "LUT_UNEPCentroEsiti", "LUT_UNEPGruppoCliente", "LUT_UNEPCliente" ],

			onToolsIconSelected: $.r3Utils.hitch(this, this.userDetail),
			onSelected :  $.r3Utils.hitch(this, this._onRowSelected),
			onClearSelection: null,
			onDblClick : null,
			onPageChange : $.r3Utils.hitch(this, function() { 
				$('#userpickeractionform_action_selectuser').prop('disabled', true);				
			}),

			searchInfo :
			{
				label : org.r3.jsportlet.user.message.search_username,
				validationRules : org.r3.jsportlet.user.R3UserQueryActionFormView_filter_searchform_validationRules,
				validationMessages : org.r3.jsportlet.user.R3UserQueryActionFormView_filter_searchform_validationMessages,
				autoStart : true
			},

          	advancedSearchInfo: [
      	    {
      	    	  label: org.r3.jsportlet.user.message.search_advanced,
      	    	  actionView: this.advancedSearchForm,
      	    	  autoOpen: false
      	    }],

			buttons : [
			{
				id : 'userpickeractionform_action_selectuser',
				label : org.r3.message.action_select,
				disabled : true,
				onClick : $.r3Utils.hitch(this, this.onItemSelected)
			} ],
			
			onInitializationComplete : $.r3Utils.hitch(this, function()
			{
				var matchExpr = 'input[name="userid"]';
				$('#R3UserQueryActionFormView_tableform').off('click', matchExpr).on('click', matchExpr, $.r3Utils.hitch(this, function(e) 
				{					
					$('#userpickeractionform_action_selectuser').prop('disabled', false);
					
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
		
		var dataTableSourceRestUrlReference = 'GET_Users';
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
	
	_onRowSelected : function(aUserDTOAdapter) 
	{
		$('#R3UserQueryActionFormView_' + aUserDTOAdapter.dataBean.userid).prop('checked', true);
		$('#userpickeractionform_action_selectuser').prop('disabled', false);
		
		this.pickedValue = 
		{
			dtokey : aUserDTOAdapter.dataBean.userid,
			dtodescr : aUserDTOAdapter.dataBean.userid + ' - ' + aUserDTOAdapter.getUsername()							
		};		
	},
	
    userDetail: function(aUserDTOAdapter)
    {
		this._onRowSelected(aUserDTOAdapter);				
		this.hide();
		this.pageManager.openUserDetailPanel(aUserDTOAdapter);
    }


});

