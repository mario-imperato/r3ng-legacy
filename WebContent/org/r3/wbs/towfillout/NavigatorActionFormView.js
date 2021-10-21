$.r3Utils.namespace("org.r3.wbs.towfillout");


org.r3.wbs.towfillout.NavigatorActionFormView = org.r3.ActionFormView.extend(
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

	open : function(pageInfo, cardInfo, aWbsId, aWbsNodeId)
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
			org.r3.PageManager.lutManager.populateSelectField(
			{
				"lutUrl" : wbsesUrl,				
				"selectWidget" : $('#wbsselection_filter'),
				"selectedValue": aWbsId,
				"useBusinessKey": true,
				"onComplete"   : function(theLUT)
				{
					var selectedWbs = $('#wbsselection_filter').val();
					if (selectedWbs)
					{					    
					    _self.fetchWBSOutline(selectedWbs, aWbsNodeId);					    
					}
					console.log("Select Field Loaded....", $('#wbsselection_filter').val());
				}
			});
					
			var resolvedUrl = org.r3.PageManager.getRESTUrl("LUT_CMS_Page");
			var lutItem = org.r3.PageManager.lutManager.getLUTItem(resolvedUrl, org.r3.Constants.site + '_' + pageInfo.pageid);
			if (lutItem)
			{
			    this.pageDTOAdapter = new org.r3.db.cms.page.PageDTOAdapter(lutItem);	
			    this.pageDTOAdapter.loadPageImage('#page_image');
			}
			
			$('#wbsselection_filter').unbind().change(function(e) 
			{
				var currentTarget = $(e.currentTarget);
				var selectedWbs = currentTarget.val();
				
				if (selectedWbs)
				{
				    _self.fetchWBSOutline(selectedWbs, null);					    
				}
			});
			
			
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	
	fetchWBSOutline: function(aWbsId, aWbsNodeId)
	{		
		var _self = this;
		
		var method = "GET";
		var restUrl = null;
		restUrl = org.r3.PageManager.getRESTUrl('GET_WBSTree', [ aWbsId ]);

		if (this.gmenubarInitialized)
		{
			$('#gmenubar').gmenubar('destroy');			
		}
		
		$.ajax(
		{
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"success" : function(responseData)
			{
				var dtoAdapter = new org.r3.db.wbs.wbs.WBSDTOAdapter(responseData);
				_self.createGMenuBar(dtoAdapter, aWbsNodeId);
				
				// In questo caso forzo una chiusura senza sapere lo stato del breadcrumb. Questo significa che la prima volta,
				// quando entro nella pagina ottengo nei log una segnalazione di errore ma senza conseguenze.
				org.r3.PageManager.closeAllBreadCrumbs();
				
				if (aWbsNodeId)
					 _self.openWBSNodeDetailActionFormPanel(aWbsId, aWbsNodeId);
				else _self.openWBSDetailActionFormPanel(dtoAdapter);
			},
			"error" : function(jqXHR, timeout, message)
			{
				console.error(message);
				// $('#wbsnodeform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
			}
		});
				
	},
	
	 createGMenuBar: function(aWBSDTOAdapter, aSelectedWbsNodeId)
	 {
		 var theWbsNodes = aWBSDTOAdapter.getListOfWbsNodes();
		 
		 var gemnubarCfg = {};
		 gemnubarCfg.sections = []; 

//		 gemnubarCfg.mainaction = {
//				id : 'gmenubar_act_newcontact',
//				title : "Nuovo Contatto",
//				onClick : null
//		 };	 
		 var sectWBS = {
	   		        type: 'section',			    
					id : 'gmenubar_sect_wbs',
					bottom_border: true,
					items: []
		 };		 
		 gemnubarCfg.sections.push(sectWBS);
		 
		 sectWBS.items.push({			    
				id :  aWBSDTOAdapter.dataBean.wbsid,
				actionId: 'wbs_detail',
				title : aWBSDTOAdapter.dataBean.wbstitle,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				selected: !aSelectedWbsNodeId
		 });	 
		 
		 var sectOutline = {
	   		        type: 'section',			    
					id : 'gmenubar_sect_wbsnode',
					bottom_border: true,
					items: []
		 };		 
		 gemnubarCfg.sections.push(sectOutline);	 

		 if (theWbsNodes) { 
		      for(var j = 0; j < theWbsNodes.length; j++) 
		      {
		    	  sectOutline.items.push({			    
						id :  theWbsNodes[j].dataBean.wbsnodeid,
						wbsid: aWBSDTOAdapter.dataBean.wbsid,
						actionId: 'wbsnode_detail',
						title : theWbsNodes[j].getNodeLabel(true),
						onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
						customCSSClassName: theWbsNodes[j].getCustomCSSClassName(), 
						deletable: false,
						selected: aSelectedWbsNodeId && (aSelectedWbsNodeId == theWbsNodes[j].dataBean.wbsnodeid)
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
         if (e.actionId == 'gmenubar_act_newcontact')
         {
        	 org.r3.PageManager.closeAllBreadCrumbs();
        	 $('#gmenubar').gmenubar('select', e.id);
        	 
        	 this.openNewActorPanel();
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
		     case 'wbs_detail':
		    	 this.openWBSDetailActionFormPanel(e.id);
		    	 break;

		     case 'wbsnode_detail':
		    	 this.openWBSNodeDetailActionFormPanel(e.wbsid, e.id);
		    	 break;
		    	 
		     }
   		 }
	     }
	 },
	 
	 openWBSDetailActionFormPanel : function(aWbsId_OR_aWbsDTOAdapter)
	 {		 		 		 
		 if (_.isString(aWbsId_OR_aWbsDTOAdapter))
		     $('#gmenubar').gmenubar('select', aWbsId_OR_aWbsDTOAdapter);
		 	
		 this.actionFormManager.openWBSDetailActionFormPanel(aWbsId_OR_aWbsDTOAdapter);
	 },
	 
	 openWBSNodeDetailActionFormPanel : function(aWbsId, aWbsNodeId)
	 {		 
		 $('#gmenubar').gmenubar('select', aWbsNodeId);
		 this.actionFormManager.openWBSNodeDetailActionFormPanel(aWbsId, aWbsNodeId);
	 }


});
