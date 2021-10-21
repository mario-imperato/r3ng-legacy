$.r3Utils.namespace("org.r3.console.sev.application");

org.r3.console.sev.application.SailApplicationViewQueryActionForm = org.r3.ActionFormManager.extend(
{
   
    init : function(aPageManager, anActionFormCanvasId, anHtmlActionFormContainerId, anAdvancedSearchHtmlActionFormContainerId, crewVerificationContainerId)
	{
		this.setPageManager(aPageManager);
        this.setCanvas(anActionFormCanvasId);
		this.crewVerificationView = new org.r3.console.sev.application.CrewVerificationActionsActionFormView(crewVerificationContainerId, this);
		
		// this.listView = new it.posteitaliane.unep.anagrafica.GruppoQueryActionFormView(anHtmlActionFormContainerId, this);
		// grade_clickable
		this.listView = new org.r3.db.sailevent.applicationview.SailApplicationViewQueryActionFormView
		(
				anHtmlActionFormContainerId, 
				this,
				{
					dataTableId : 'SailApplicationViewQueryActionFormView',
					gradeLevel : 'grade_level2 grade_clickable',
					legend : 'Elenco Iscritti',	
					dataTableSource : 'GET_SEV_ConsoleApplicationView',
					layout : 'fullWidth',
					canvasType: 'list-group',
					iDisplayLength: -1,
					sortable: true,
					// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
					dataTableColumns : "completionstatus,applicationid;sort,userid,sailnumber;sort,yachtname;sort,yachttype,yachtclub,ownername,racegroup_raceclass,adminchecks,accepted,rectimestamp",
					requiredLUTs : [ 
                        "GET_classifier_sys_recstatus", "GET_classifier_r3ea_raceclass", "GET_classifier_r3ea_boatgroup", "GET_classifier_r3ea_admincks" ],
					
					onSelected : $.r3Utils.hitch(this, this.viewApplication),
					onDblClick : null,
					onClearSelection : null,					        

	              	searchInfo: 
	              	{
	                    widget: 'select',

	              		widgetInitialization: {
	              			url: org.r3.PageManager.getRESTUrl('LUT_SailEventRaceGroups'),
	              			blankOptionText: org.r3.PageManager.getMessageFromDict("org.r3.console.sev.application.message.any")
	              		},
	              		
	              	    label: org.r3.console.sev.application.message.search_racegroup,
	              	    validationRules: org.r3.console.sev.application.SailApplicationViewQueryActionFormView_filter_searchform_validationRules,
	              	    validationMessages: org.r3.console.sev.application.SailApplicationViewQueryActionFormView_filter_searchform_validationMessages,
	              	    autoStart: true
	              	}
	              	
//					buttons : [
//					{
//						id : 'gruppoqueryactionform_action_newgruppo',
//						label : 'Nuovo',
//						disabled : false,
//						onClick : $.unepUtils.hitch(this, this.newGruppo)
//					} ]

				}
		);
		
	},
   
   open: function()
   {   	  	   
	   this.listView.open();
	   this.crewVerificationView.open();
	   
	   this.showCanvas();
   },
     
   close: function()
   {   	  	   
	   this.listView.close();
	   this.crewVerificationView.close();
	   this.hideCanvas();
   },
   
   hide: function()
   {   	  
   	  this.listView.hide();
   	  this.crewVerificationView.hide();
   	  this.hideCanvas();
   },

   show: function()
   {   	  
   	  this.listView.show();
   	  this.crewVerificationView.show();
   	  this.showCanvas();
   },

   refresh: function()
   {   	  
   	  this.listView.refresh();
   },
   
   viewApplication: function(aDTOAdapter)
   {
	   this.hide();  
	   this.pageManager.openAdminApplicationPanel(aDTOAdapter.dataBean.applicationid);
   },
   
   viewFleetReport: function()
   {
      this.pageManager.viewFleetReport();
   },
   
   athletesReport: function()
   {
	   this.pageManager.athletesReport(); 
   },
   
   doProcessUserForm: function(aMethod, dictionaryUrl, theForm, onSuccess, onError)
   {
		var _self = this;
		
		if (theForm.valid())
		{
			org.r3.PageManager.wait("org.r3.message.waiting");

			var method = aMethod;
			var restUrl = org.r3.PageManager.getRESTUrl(dictionaryUrl);
			theForm.ajaxSubmit(
			{
				"type" : method,
				"url" : restUrl,
				"dataType" : "json",
				"success" : function(responseData)
				{
					org.r3.PageManager.closeNotifier();
					if (onSuccess)
						onSuccess(responseData);										
				},
				"error" : function(jqXHR, timeout, message)
				{
					console.log(arguments);
					org.r3.PageManager.closeNotifier();
					if (onError)
					   onError(jqXHR, timeout, message);
				}
			});
		}				
	}

      
            	       
});



