$.r3Utils.namespace("org.r3.console.home.site");

org.r3.console.home.site.SailApplicationEventLogViewQueryActionForm = org.r3.ActionFormManager.extend(
{
   
    init : function(aPageManager, anHtmlActionFormContainerId, anAdvancedSearchHtmlActionFormContainerId)
	{
		this.setPageManager(aPageManager);

		// this.listView = new it.posteitaliane.unep.anagrafica.GruppoQueryActionFormView(anHtmlActionFormContainerId, this);
		// grade_clickable
		this.listView = new org.r3.db.sailevent.appeventlogview.SailApplicationEventLogViewQueryActionFormView
		(
				anHtmlActionFormContainerId, 
				this,
				{
					dataTableId : 'SailApplicationEventLogViewQueryActionFormView',
					gradeLevel : 'grade_level6 grade_clickable',
					legend : 'Ultimi Aggiornamenti',	
					iDisplayLength: 25,
					dataTableSource : 'GET_SEV_ConsoleApplicationEventLogView',
					layout : 'fullWidth',
					sortable: true,
					// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
					dataTableColumns : "applicationid;sort,sailnumber;sort,yachtname,ownername,ev_general,ev_document,ev_crew,ev_commit,latest_ts",
					// dataTableColumns : "latest_ts,applicationinfo,ev_info",
					requiredLUTs : [ 
                        "GET_classifier_sys_recstatus", "GET_classifier_r3ea_raceclass", "GET_classifier_r3ea_boatgroup" ],
					
					onSelected : $.r3Utils.hitch(this, this.adminApplication),
					onDblClick : null,
					onClearSelection : null,					        

//	              	searchInfo: 
//	              	{
//	                    widget: 'select',
//
//	              		widgetInitialization: {
//	              			url: org.r3.PageManager.getRESTUrl('LUT_SailEventRaceGroups'),
//	              			blankOptionText: org.r3.PageManager.getMessageFromDict("org.r3.console.sev.application.message.any")
//	              		},
//	              		
//	              	    label: org.r3.console.sev.application.message.search_racegroup,
//	              	    validationRules: org.r3.console.sev.application.SailApplicationViewQueryActionFormView_filter_searchform_validationRules,
//	              	    validationMessages: org.r3.console.sev.application.SailApplicationViewQueryActionFormView_filter_searchform_validationMessages,
//	              	    autoStart: true
//	              	}
	              	
					actionBarOnTop: true,
					buttons : [
					{
						id : 'consolehome_action_refresheventlog',
						label : 'Aggiorna',
						disabled : false,
						onClick : $.r3Utils.hitch(this, function() { this.listView.refresh(); })
					} ]

				}
		);
		
	},
   
   open: function()
   {   	  	   
	   this.listView.open();		
   },
     
   close: function()
   {   	  	   
	   this.listView.close();		
   },
   
   hide: function()
   {   	  
   	  this.listView.hide();
   },

   show: function()
   {   	  
   	  this.listView.show();
   },

   refresh: function()
   {   	  
   	  this.listView.refresh();
   },
   
   adminApplication: function(aDTOAdapter)
   {
		var targetUrl = org.r3.Constants.getStrutsActionContext() + '/org/r3/console/sev/application/adminApplication.do?objid=' + aDTOAdapter.dataBean.applicationid;
		org.r3.PageManager.gotoPage(targetUrl);
   }
      
            	       
});



