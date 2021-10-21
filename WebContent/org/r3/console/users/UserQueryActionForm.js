$.r3Utils.namespace("org.r3.console.users");

org.r3.console.users.UserQueryActionForm = org.r3.ActionFormManager.extend(
{
	init : function(aPageManager, anHtmlActionFormContainerId, anAdvancedSearchHtmlActionFormContainerId)
	{
		this.setPageManager(aPageManager);

		this.advancedSearchForm = new org.r3.console.users.UserQueryAdvancedSearchActionFormView(anAdvancedSearchHtmlActionFormContainerId, this);
		this.advancedSearchForm.open();

		this.listView = new org.r3.db.system.user.user.UserQueryActionFormView(anHtmlActionFormContainerId, this,
		{
			dataTableId : 'R3UserQueryActionFormView',
			// layout : 'fullWidth',
			gradeLevel : 'grade_level2 grade_clickable',
			legend : org.r3.db.system.user.user.message.queryactionformview_legend,
			dataTableSource : 'GET_Users',
			
			actionBarOnTop: true,
			layout : 'fullWidth',
			
			sortable: false,
			// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
			dataTableColumns : "userid,nickname,firstname,lastname,email,recstatus",
			// requiredLUTs : [ "GET_classifier_usr_type", "LUT_UNEPAreaOrganizzativa", "LUT_UNEPCentroLavorazione", "LUT_UNEPCentroEsiti", "LUT_UNEPGruppoCliente", "LUT_UNEPCliente" ],

			onSelected : $.r3Utils.hitch(this, this.detailItem),
			onDblClick : null,
			onClearSelection : null,

			searchInfo :
			{
				label : org.r3.console.users.message.search_username,
				validationRules : org.r3.console.users.R3UserQueryActionFormView_filter_searchform_validationRules,
				validationMessages : org.r3.console.users.R3UserQueryActionFormView_filter_searchform_validationMessages,
				autoStart : true
			},

          	advancedSearchInfo: [
      	    {
      	    	  label: org.r3.console.users.message.search_advanced,
      	    	  actionView: this.advancedSearchForm,
      	    	  autoOpen: false
      	    }],

			buttons : [
			{
				id : 'userqueryactionform_action_newuser',
				label : org.r3.message.action_new,
				disabled : false,
				onClick : $.r3Utils.hitch(this, this.newItem)
			} ]

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
		org.r3.console.users.PageManager.newUser();
	},

	detailItem : function(aDataBean)
	{
		this.listView.hide();
		org.r3.console.users.PageManager.detailUser(aDataBean);
	}
	
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

