$.r3Utils.namespace("org.r3.jsportlet.fileupload");

org.r3.jsportlet.fileupload.FileImportQueryActionForm = org.r3.ActionFormManager.extend(
{
   
    init : function(aPageManager, anHtmlActionFormContainerId, anAdvancedSearchHtmlActionFormContainerId)
	{
		this.setPageManager(aPageManager);

		// this.listView = new it.posteitaliane.unep.anagrafica.GruppoQueryActionFormView(anHtmlActionFormContainerId, this);
		// grade_clickable
		this.listView = new org.r3.db.system.fileimport.fileimport.FileImportQueryActionFormView
		(
				anHtmlActionFormContainerId, 
				this,
				{
					dataTableId : 'FileImportQueryActionFormView',
					gradeLevel : 'grade_level6 grade_clickable',
					legend : org.r3.db.system.fileimport.fileimport.message.queryactionform_caption,	
					iDisplayLength: 25,
					dataTableSource : 'GET_FileImports',
					layout : 'fullWidth',
					sortable: true,
					// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
					dataTableColumns : "importname,recstatus,rectimestamp",
					requiredLUTs : [ 
                        "GET_classifier_sys_recstatus" ],
					
                    onDblClick : null,
                    onSelected :  $.r3Utils.hitch(this, this.fileImportDetail),
					onClearSelection : null,					        
	              	
					actionBarOnTop: true,
					buttons : [
					{
						id : 'console_fileimport_action_refresh',
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
   
   fileImportDetail: function(aDTOAdapter)
   {
		this.listView.hide();
		org.r3.console.contacts.PageManager.openFileImportDetailPanel(aDTOAdapter);
   }
         
            	       
});



