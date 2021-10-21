$.r3Utils.namespace("org.r3.discussion");


org.r3.discussion.NavigatorActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.gmenubarInitialized = false;
		this.topicDTOAdapter = null;
	},

	close : function()
	{
		this.hide();
	},

	open : function(pageInfo, cardInfo, aTopicInfo, options)
	{		
		var _self = this;
		
		org.r3.PageManager.wait("org.r3.message.waiting");

		
		var networkRequestsQueue = [];		
		
		var threadUrl = org.r3.PageManager.getRESTUrl("GET_BBSThreads_InTopic", [ aTopicInfo.topicid ]);
		networkRequestsQueue.push(
		{
			id : "threads",
			type : "Get",
			url : threadUrl,
			dataType : "json"
		});
				
		var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_BBSTopicDetail", [ aTopicInfo.topicid ]);
		networkRequestsQueue.push(
		{
			id : "topic_detail",
			type : "Get",
			url : resolvedUrl,
			dataType : "json"
		});
		
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_CMS_Page'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();
			
			var threads = responseData["threads"];
			if (threads)
			{								
				threads = new org.r3.db.DTOTableAdapter(threads, 
						function(aRowDataBean) { return new org.r3.db.bbs.bbsthread.BBSThreadDTOAdapter(aRowDataBean); });				
			}
			
			var topicDTOAdapter = responseData["topic_detail"];
			if (topicDTOAdapter)
			{								
				this.topicDTOAdapter = new org.r3.db.bbs.bbstopic.BBSTopicDTOAdapter(topicDTOAdapter);		
			}
			
	        this.createGMenuBar(threads, options);
	        
			var resolvedUrl = org.r3.PageManager.getRESTUrl("LUT_CMS_Page");
			var lutItem = org.r3.PageManager.lutManager.getLUTItem(resolvedUrl, org.r3.Constants.site + '_' + pageInfo.pageid);
			if (lutItem)
			{
			    this.pageDTOAdapter = new org.r3.db.cms.page.PageDTOAdapter(lutItem);	
			    this.pageDTOAdapter.loadPageImage('#page_image');
			}
			
			if (topicDTOAdapter)
			{ 
				this.openTopicInfoActionFormPanel(this.topicDTOAdapter);
			}
			
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
		
	 createGMenuBar: function(aListOfBBSThreadDTOAdapter, options)
	 {		 		 
		 var gemnubarCfg = {};
		 gemnubarCfg.sections = []; 

		 if (options.newThread)
		 {
			 gemnubarCfg.mainaction = {
						id : 'gmenubar_act_newthread',
						actionId : 'gmenubar_act_newthread',
						title : "Report",
						onClick : $.r3Utils.hitch(this, this._onGMenuBarClick)
		    };	 			 
		 }
		 
		 var threadDTOAdapter = null;
		 
		 if (aListOfBBSThreadDTOAdapter.getNumberOfItems() > 0)
		 {			 
			 var sectBBS = {
		   		        type: 'section',			    
						id : 'gmenubar_sect_bbs',
						bottom_border: true,
						items: []
			 };		 
			 gemnubarCfg.sections.push(sectBBS);
			 			 
			 for(var i = 0; i < aListOfBBSThreadDTOAdapter.getNumberOfItems(); i++)
			 {
			     var aBBSThreadDTOAdapter = aListOfBBSThreadDTOAdapter.getItem(i);
				 sectBBS.items.push({			    
						id :  aBBSThreadDTOAdapter.dataBean.threadid,
						actionId: 'bbs_thread',
						topicId: aBBSThreadDTOAdapter.dataBean.topicid,
						title : aBBSThreadDTOAdapter.dataBean.threadtitle,
						onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
						deletable: false,
						selected: (i == 0)
				 });	
				 
				 if (i == 0)
				    threadDTOAdapter = aBBSThreadDTOAdapter;
			 }
			 
		 }		
		 
		 $('#gmenubar').gmenubar(gemnubarCfg);
		 this.gmenubarInitialized = true;
		  		 
		 if (threadDTOAdapter)
			 this.openThreadDetailActionFormPanel(this.topicDTOAdapter, threadDTOAdapter.dataBean.threadid);
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
		     case 'bbs_thread':
		    	 this.openThreadDetailActionFormPanel(this.topicDTOAdapter, e.id);
		    	 break;		     		    	 
		     }
   		 }
	     }
	 },
	 
	 openThreadDetailActionFormPanel : function(aTopicDTOAdapter, aThreadId)
	 {		 		 		 
	     $('#gmenubar').gmenubar('select', aThreadId);		 	
		 this.actionFormManager.openThreadDetailActionFormPanel(aTopicDTOAdapter, aThreadId);
	 },
	 
	 openTopicInfoActionFormPanel : function(aTopicDTOAdapter)
	 {		 		 		 	 	
		 this.actionFormManager.openTopicInfoActionFormPanel(aTopicDTOAdapter);
	 }
	 
	 

});
