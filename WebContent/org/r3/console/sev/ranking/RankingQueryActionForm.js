$.r3Utils.namespace("org.r3.console.sev.ranking");

org.r3.console.sev.ranking.RankingQueryActionForm = org.r3.ActionFormManager.extend(
{
   
    init : function(aPageManager, anHtmlActionFormContainerId, anAdvancedSearchHtmlActionFormContainerId)
	{
		this.setPageManager(aPageManager);

		// this.listView = new it.posteitaliane.unep.anagrafica.GruppoQueryActionFormView(anHtmlActionFormContainerId, this);
		// grade_clickable
		this.listView = new org.r3.db.sailevent.ranking.RankingQueryActionFormView
		(
				anHtmlActionFormContainerId, 
				this,
				{
					dataTableId : 'RankingQueryActionFormView',
					gradeLevel : 'grade_level6 grade_clickable',
					legend : 'Contatti',	
					iDisplayLength: 25,
					dataTableSource : 'GET_Rankings',
					layout : 'fullWidth',
					sortable: true,
					// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
					dataTableColumns : "rankordering,rankid,rankinggroup,ranktitle,rating,racefilepattern,overallfilepattern",
					requiredLUTs : [ 
                        "GET_classifier_sys_recstatus", "GET_classifier_r3ea_sinott", "GET_classifier_rank_rating" ],
					
                    onDblClick : null,
                    onSelected :  $.r3Utils.hitch(this, this.onRankingSelected),
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
						id : 'console_ranking_action_refresh',
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
   
   onRankingSelected: function(aDTOAdapter)
   {
		this.listView.hide();
		org.r3.console.sev.ranking.PageManager.openRankingDetailPanel(aDTOAdapter);
   }
      
            	       
});



