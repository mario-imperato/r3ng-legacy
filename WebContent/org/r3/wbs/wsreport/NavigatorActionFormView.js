$.r3Utils.namespace("org.r3.wbs.wsreport");


org.r3.wbs.wsreport.NavigatorActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.gmenubarInitialized = false;
	},

	close : function()
	{
		this.hide();
	},

	open : function(pageInfo, cardInfo)
	{
		var _self = this;
		
		org.r3.PageManager.wait("org.r3.message.waiting");

		var wbsesUrl = org.r3.PageManager.getRESTUrl("GET_WBSes");
		var networkRequestsQueue = [];		
		networkRequestsQueue.push(
		{
			id : "wbses",
			type : "Get",
			url : wbsesUrl,
			dataType : "json"
		});
		
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_CMS_Page'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			org.r3.PageManager.lutManager.addLUT(wbsesUrl, responseData["wbses"]);
			
			var wbses = responseData["wbses"];
			if (wbses)
			{
				wbses = new org.r3.db.DTOTableAdapter(wbses, 
						function(aRowDataBean) { return new org.r3.db.wbs.wbs.WBSDTOAdapter(aRowDataBean); });
				
		        this.createGMenuBar(wbses);
			}
			
//			org.r3.PageManager.lutManager.populateSelectField(
//			{
//				"lutUrl" : wbsesUrl,				
//				"selectWidget" : $('#wbsselection_filter'),
//				"onComplete"   : function(theLUT)
//				{
//					var selectedWbs = $('#wbsselection_filter').val();
//					if (selectedWbs)
//					{
//					    selectedWbs = selectedWbs.split('_')[1];
//					    _self.fetchWBSOutline(selectedWbs);					    
//					}
//					console.log("Select Field Loaded....", $('#wbsselection_filter').val());
//				}
//			});
					
			var resolvedUrl = org.r3.PageManager.getRESTUrl("LUT_CMS_Page");
			var lutItem = org.r3.PageManager.lutManager.getLUTItem(resolvedUrl, org.r3.Constants.site + '_' + pageInfo.pageid);
			if (lutItem)
			{
			    this.pageDTOAdapter = new org.r3.db.cms.page.PageDTOAdapter(lutItem);	
			    this.pageDTOAdapter.loadPageImage('#page_image');
			}
			
//			$('#wbsselection_filter').unbind().change(function(e) 
//			{
//				var currentTarget = $(e.currentTarget);
//				var selectedWbs = currentTarget.val();
//				
//				if (selectedWbs)
//				{
//				    selectedWbs = selectedWbs.split('_')[1];
//				    _self.fetchWBSOutline(selectedWbs);					    
//				}
//			});
			
			this.openFullReportPanel();
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
		
	 createGMenuBar: function(aListOfWBSDTOAdapter)
	 {		 		 
		 var gemnubarCfg = {};
		 gemnubarCfg.sections = []; 

		 gemnubarCfg.mainaction = {
				id : 'gmenubar_act_fullreport',
				actionId : 'gmenubar_act_fullreport',
				title : org.r3.wbs.wsreport.message.gmenubar_action_fullreport,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick)
		 };	 
		 
		 if (aListOfWBSDTOAdapter.getNumberOfItems() > 0)
		 {			 
			 var sectWBS = {
		   		        type: 'section',			    
						id : 'gmenubar_sect_wbs',
						bottom_border: true,
						items: []
			 };		 
			 gemnubarCfg.sections.push(sectWBS);
			 
			 for(var i = 0; i < aListOfWBSDTOAdapter.getNumberOfItems(); i++)
			 {
			     var aWBSDTOAdapter = aListOfWBSDTOAdapter.getItem(i);
				 sectWBS.items.push({			    
						id :  aWBSDTOAdapter.dataBean.wbsid,
						actionId: 'wbs_report',
						title : "Rep. " + aWBSDTOAdapter.dataBean.wbstitle,
						onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
						deletable: false,
						selected: false
				 });			     
			 }
		 }
		 		 
		 $('#gmenubar').gmenubar(gemnubarCfg);
		 this.gmenubarInitialized = true;
	},
	
	 _onGMenuBarClick: function(e, actionTriggered)
	 {
         console.info("_itsbeenclicked", e);	

         // Frammento di codice per la main action. Non presente in questo momento. Il codice non viene eseguito in
         // quanto gmenubar_act_newcontact non è presente.
         if (e.actionId == 'gmenubar_act_fullreport')
         {
        	 org.r3.PageManager.closeAllBreadCrumbs();
        	 $('#gmenubar').gmenubar('select', e.id);
        	 
        	 this.openFullReportPanel();
             return ;        	 
         }
	     
	     if (e.selected)
	     {
	    	 if (actionTriggered && actionTriggered == 'delete')
	    	 {
	    		 // this.deleteActorGroup(e.id);
	    	 }
	    	 else
	    	 {
	    		// Se e' selezionato allora vuol dire che nella history dei breadcrumb e' in posizione 1 visto che in posizione 0 ci sta la home console.	    	 
		    	 org.r3.PageManager.activateFirstBreadCrumb(); 
	    	 }
	     }
	     else 
	     {
	    	 if (actionTriggered && actionTriggered == 'delete')
	    	 {
	    		 this.deleteActorGroup(e.id);
	    	 }
	    	 else
	    	 {
	    	 $('#gmenubar').gmenubar('select', e.id);
	    	 org.r3.PageManager.closeAllBreadCrumbs();
	    	 
	    	 switch(e.actionId)
		     {
		     case 'wbs_report':
		    	 this.openReportDetailActionFormPanel(e.id);
		    	 break;		     		    	 
		     }
   		 }
	     }
	 },
	 
	 openReportDetailActionFormPanel : function(aWbsId)
	 {		 		 		 
	     $('#gmenubar').gmenubar('select', aWbsId);		 	
		 this.actionFormManager.openReportDetailActionFormPanel(aWbsId);
	 },
	 
	 openFullReportPanel: function()
	 {
		 this.actionFormManager.openFullReportPanel();		 
	 }
	 

});
