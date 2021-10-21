$.r3Utils.namespace("org.r3.console.regattas");

org.r3.console.regattas.RegattasQueryActionForm = org.r3.ActionFormManager.extend(
{
   
    init : function(aPageManager, anHtmlActionFormContainerId, anAdvancedSearchHtmlActionFormContainerId)
	{
		this.setPageManager(aPageManager);

		// this.listView = new it.posteitaliane.unep.anagrafica.GruppoQueryActionFormView(anHtmlActionFormContainerId, this);
		// grade_clickable
		this.listView = new org.r3.db.system.site.SiteQueryActionFormView
		(
				anHtmlActionFormContainerId, 
				this,
				{
					dataTableId : 'SiteQueryActionFormView',
					gradeLevel : 'grade_level6 grade_clickable',
					legend : org.r3.db.system.site.message.queryactionformview_legend,	
					iDisplayLength: 25,
					dataTableSource : 'GET_Sites',  // 'GET_Sites_Of_Type_Regatta',
					layout : 'fullWidth',
					sortable: true,
					// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
					dataTableColumns : "site;sort,sitedescr,sitesummary",
					requiredLUTs : [ 
                        "GET_classifier_sys_recstatus" ],
					
                    onDblClick : null,
                    onSelected :  $.r3Utils.hitch(this, this.regattaDetail),
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
						id : 'console_regatta_action_refresh',
						label : org.r3.message.action_refresh,
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
	   // M20140201 - org.r3.PageManager.popBreadCrumb();
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
   
   regattaDetail: function(aDTOAdapter)
   {
		this.listView.hide();
		this.pageManager.openRegattaDetailPanel(aDTOAdapter);
   }
      
            	       
});



