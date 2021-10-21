$.r3Utils.namespace("org.r3.console.contacts");

org.r3.console.contacts.ActorQueryActionForm = org.r3.ActionFormManager.extend(
{
   
    init : function(aPageManager, anHtmlActionFormContainerId, anAdvancedSearchHtmlActionFormContainerId)
	{
		this.setPageManager(aPageManager);

		// this.listView = new it.posteitaliane.unep.anagrafica.GruppoQueryActionFormView(anHtmlActionFormContainerId, this);
		// grade_clickable
		this.listView = new org.r3.db.actor.actor.ActorQueryActionFormView
		(
				anHtmlActionFormContainerId, 
				this,
				{
					dataTableId : 'ActorQueryActionFormView',
					gradeLevel : 'grade_level6 grade_clickable',
					legend : org.r3.db.actor.actor.message.queryactionformview_legend,	
					iDisplayLength: 25,
					dataTableSource : 'GET_Actors',
					layout : 'fullWidth',
					sortable: true,
					// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
					dataTableColumns : "recstatus,actorid;sort,firstname,lastname;sort,address,email,cellphone",
					requiredLUTs : [ 
                        "GET_classifier_sys_recstatus" ],
					
                    onDblClick : null,
                    onSelected :  $.r3Utils.hitch(this, this.actorDetail),
					onClearSelection : null,					        

					searchInfo :
					{
						label : org.r3.console.contacts.message.search_contact,
						validationRules :org.r3.console.contacts.actorQueryActionFormView_filter_searchform_validationRules,
						validationMessages : org.r3.console.contacts.actorQueryActionFormView_filter_searchform_validationMessages,
						autoStart : true
					},
	              	
					actionBarOnTop: true,
					buttons : [
					{
						id : 'console_actor_action_refresh',
						label : org.r3.console.contacts.message.console_actor_action_refresh,
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
   
   actorDetail: function(aDTOAdapter)
   {
		this.listView.hide();
		this.pageManager.openActorDetailPanel(aDTOAdapter);
   }
      
            	       
});



