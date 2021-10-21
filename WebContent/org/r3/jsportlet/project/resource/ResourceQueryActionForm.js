$.r3Utils.namespace("org.r3.jsportlet.project.resource");

org.r3.jsportlet.project.resource.ResourceQueryActionForm = org.r3.ActionFormManager.extend(
{
   
    init : function(aPageManager, anHtmlActionFormContainerId, anAdvancedSearchHtmlActionFormContainerId)
	{
		this.setPageManager(aPageManager);

		// this.listView = new it.posteitaliane.unep.anagrafica.GruppoQueryActionFormView(anHtmlActionFormContainerId, this);
		// grade_clickable
		this.listView = new org.r3.db.project.resource.ResourceQueryActionFormView
		(
				anHtmlActionFormContainerId, 
				this,
				{
					dataTableId : 'SiteResourceViewQueryActionFormView',
					gradeLevel : 'grade_level6 grade_clickable',
					legend : org.r3.db.project.resource.message.queryactionformview_legend,	
					iDisplayLength: 25,
					dataTableSource : 'GET_Resources',
					layout : 'fullWidth',
					sortable: true,
					// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
					dataTableColumns : "recstatus,resourceid;sort,firstname,lastname;sort,address,email,cellphone",
					requiredLUTs : [ 
                        "GET_classifier_sys_recstatus" ],
					
                    onDblClick : null,
                    onSelected :  $.r3Utils.hitch(this, this.resourceDetail),
					onClearSelection : null,					        

					searchInfo :
					{
						label : org.r3.jsportlet.project.resource.message.search_contact,
						validationRules :org.r3.jsportlet.project.resource.resourceQueryActionFormView_filter_searchform_validationRules,
						validationMessages : org.r3.jsportlet.project.resource.resourceQueryActionFormView_filter_searchform_validationMessages,
						autoStart : true
					},
	              	
					actionBarOnTop: true,
					buttons : [
					{
						id : 'console_resource_action_newresource',
						label : org.r3.jsportlet.project.resource.message.console_resource_action_newresource,
						disabled : false,
						onClick : $.r3Utils.hitch(this, function() { this.hide(); this.pageManager.openNewResourcePanel(); })
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
   
   resourceDetail: function(aDTOAdapter)
   {
		this.listView.hide();
		this.pageManager.openResourceDetailPanel(aDTOAdapter, {});
   }
      
            	       
});



