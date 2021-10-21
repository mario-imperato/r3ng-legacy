$.r3Utils.namespace("org.r3.console.contacts");

org.r3.console.contacts.OutMailQueryActionForm = org.r3.ActionFormManager.extend(
{
   
    init : function(aPageManager, anHtmlActionFormContainerId, anAdvancedSearchHtmlActionFormContainerId)
	{
		this.setPageManager(aPageManager);

		// this.listView = new it.posteitaliane.unep.anagrafica.GruppoQueryActionFormView(anHtmlActionFormContainerId, this);
		// grade_clickable
		this.listView = new org.r3.db.system.outmailspooler.OutMailSpoolerQueryActionFormView
		(
				anHtmlActionFormContainerId, 
				this,
				{
					dataTableId : 'OutMailSpoolerQueryActionFormView',
					gradeLevel : 'grade_level6 grade_clickable',
					legend : org.r3.db.system.outmailspooler.message.queryactionformview_legend,	
					iDisplayLength: 25,
					dataTableSource : 'GET_OUTMAIL',
					layout : 'fullWidth',
					sortable: true,
					// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
					dataTableColumns : "messageid;sort,msgtitle,numberoftargets,numberofsentitems,numberofattachments,recstatus,rectimestamp",
					requiredLUTs : [ 
                        "GET_classifier_sys_recstatus" ],
					
                    onDblClick : null,
                    onSelected :  $.r3Utils.hitch(this, this.openDetail),
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
						id : 'console_mail_action_refresh',
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
   
   openDetail: function(aDtoAdapter)
   {
	   this.hide();
	   this.pageManager.openMailDetailPanel(aDtoAdapter);
   }
         
            	       
});



