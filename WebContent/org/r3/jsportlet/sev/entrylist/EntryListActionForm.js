$.r3Utils.namespace("org.r3.jsportlet.sev.entrylist");

org.r3.jsportlet.sev.entrylist.EntryListActionForm = org.r3.ActionFormManager.extend(
{
   
    init : function(aPageManager, anHtmlActionFormContainerId, anAdvancedSearchHtmlActionFormContainerId)
	{
		this.setPageManager(aPageManager);
		
		// this.listView = new it.posteitaliane.unep.anagrafica.GruppoQueryActionFormView(anHtmlActionFormContainerId, this);
		// grade_clickable
		this.listView = new org.r3.db.sailevent.entrylist.SailEntryListQueryActionFormView
		(
				anHtmlActionFormContainerId, 
				this,
				{
					dataTableId : 'SailEntryListQueryActionFormView',
					gradeLevel : 'grade_level3',
					legend : 'Elenco Iscritti',	
					dataTableSource : 'GET_SEV_EntryList',
					layout : 'fullWidth',
					iDisplayLength: -1,
					sortable: true,
					htmlTemplateUrl: org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/entrylist/EntryListActionFormViewTemplate.html.jsp',
					// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
					dataTableColumns : "boaticon,sailnumber;sort,yachtname,yachttype,yachtclub,ownerlastname,racegroup_raceclass,accepted",
					requiredLUTs : [ 
                        "GET_classifier_sys_recstatus", "GET_classifier_r3ea_raceclass", "GET_classifier_r3ea_boatgroup" ],
					
					onSelected : null,
					onDblClick :  $.r3Utils.hitch(this, function() {}),
					onClearSelection : null,					        

	              	searchInfo: 
	              	{
	                    widget: 'select',

	              		widgetInitialization: {
	              			url: org.r3.PageManager.getRESTUrl('LUT_SailEventRaceGroups'),
	              			blankOptionText: org.r3.PageManager.getMessageFromDict("org.r3.jsportlet.sev.entrylist.message.any")
	              		},
	              		
	              	    label: org.r3.sev.entrylist.message.search_racegroup,
	              	    validationRules: org.r3.jsportlet.sev.entrylist.SailEntryListQueryActionFormView_filter_searchform_validationRules,
	              	    validationMessages: org.r3.jsportlet.sev.entrylist.SailEntryListQueryActionFormView_filter_searchform_validationMessages,
	              	    autoStart: true
	              	},
	              	
	              	onInitializationComplete: $.r3Utils.hitch(this, function()
	              	{
	              		$('#entrylist_action_showboaticons').prop('checked', false);
	              		$('#entrylist_action_showboaticons').unbind().click($.r3Utils.hitch(this, this.onShowIcons));

	              	}),
	              	
	              	onServerData: function(items, data)
	              	{
	              		if ($('#entrylist_action_showboaticons').prop('checked'))
	              		    $("a[rel='lightbox-entrylist']").slimbox();
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
   
	onShowIcons: function(evt)
	{
		if (!$('#entrylist_action_showboaticons').prop('checked'))
			$("a[rel='lightbox-entrylist']").unbind("click");
		
		this.listView.refresh();
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
   
   detailDocument: function(aDTOAdapter)
   {
	   this.listView.hide();  
	   this.pageManager.detailDocument(aDTOAdapter);
   }
            	       
});



