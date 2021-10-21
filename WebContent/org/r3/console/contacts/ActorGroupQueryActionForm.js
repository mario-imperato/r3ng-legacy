$.r3Utils.namespace("org.r3.console.contacts");

org.r3.console.contacts.ActorGroupQueryActionForm = org.r3.ActionFormManager.extend(
{
   
    init : function(aPageManager, anHtmlActionFormContainerId, anAdvancedSearchHtmlActionFormContainerId)
	{
		this.setPageManager(aPageManager);

		// this.listView = new it.posteitaliane.unep.anagrafica.GruppoQueryActionFormView(anHtmlActionFormContainerId, this);
		// grade_clickable
		this.listView = new org.r3.db.actor.group.ActorGroupQueryActionFormView
		(
				anHtmlActionFormContainerId, 
				this,
				{
					dataTableId : 'ActorGroupQueryActionFormView',
					gradeLevel : 'grade_level6 grade_clickable',
					legend : org.r3.db.actor.group.message.queryactionformview_legend,	
					iDisplayLength: 25,
					dataTableSource : 'GET_UserAndApp_ActorGroups',
					layout : 'fullWidth',
					sortable: true,
					// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
					dataTableColumns : "groupid;sort,grouptitle,groupprofile",
					requiredLUTs : [ 
                        "GET_classifier_sys_recstatus" ],
					
                    onDblClick : null,
                    onSelected :  $.r3Utils.hitch(this, this.actorGroupDetail),
					onClearSelection : null,					        
	              	
					actionBarOnTop: true,
					buttons : [
					{
						id : 'console_actorgroup_action_refresh',
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
   
   actorGroupDetail: function(aDTOAdapter)
   {
		this.listView.hide();
		this.pageManager.openActorGroupDetailPanel(aDTOAdapter.dataBean.groupid);
   }
      
            	       
});



