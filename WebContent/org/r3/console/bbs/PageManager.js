$.r3Utils.namespace("org.r3.console.bbs");

org.r3.console.bbs.PageManager = 
{
  	
	 init: function()
	 {			 
		 this.bbsTopicQueryActionForm = new org.r3.console.bbs.BBSTopicQueryActionForm(this, '#bbsTopicQueryActionForm');
		 this.bbsTopicDetailActionForm = new org.r3.console.bbs.BBSTopicDetailActionForm(this, '#bbsTopicDetailActionForm', '#bbsThreadQueryActionForm');
		 this.bbsThreadDetailActionForm = new org.r3.console.bbs.BBSThreadDetailActionForm(this, '#bbsThreadDetailActionForm', '#bbsThreadNodeQueryActionForm');
		 this.bbsThreadNodeDetailActionForm = new org.r3.console.bbs.BBSThreadNodeDetailActionForm(this, '#bbsThreadNodeDetailActionForm');
		 
		 this.createGSideBar();
		 org.r3.PageManager.pushHomeConsoleBreadCrumb();
		 this.openBBSTopicQueryActionFormPanel();
	 },
	 
	 createGSideBar: function()
	 {
		 var gsidebarCfg = {};
		 gsidebarCfg.sections = []; 


		 var sect1 = {
	   		        type: 'section',			    
					id : 'gmenubar_sect_action',
					bottom_border: true,
					items: []
		 };		 
		 gsidebarCfg.sections.push(sect1);	 
		 		
		 sect1.items.push({
				id : 'gmenubar_act_newbbstopic',
				title : org.r3.console.bbs.message.gmenubar_act_newbbstopic,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable : false,
				selected : true,
				icon: 'plus'
		 });
		 
		 sect1.items.push({
				id : 'act_query_bbstopic',
				title : org.r3.console.bbs.message.gmenubar_act_query_bbstopic,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable : false,
				selected : true,
				icon: 'table'
		 });
		 		 
		 $('#gsidebar-navanchor').gsidebar(gsidebarCfg);		 		 
	 },
	 
	 _onGMenuBarClick: function(e, actionTriggered)
	 {
         console.info("_itsbeenclicked", e);	
         if (e.id == 'gmenubar_act_newbbstopic')
         {
        	 org.r3.PageManager.closeAllBreadCrumbs();
        	 $('#gsidebar-navanchor').gsidebar('select', e.id);
        	 
        	 this.openBBSTopicPanel();
             return ;        	 
         }
	     
	     if (e.selected)
	     {
	    	 if (actionTriggered && actionTriggered == 'delete')
	    	 {
	    		 // Should a delete method present.
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
	    		 // Should a delete method present.
	    		 // this.deleteActorGroup(e.id);
	    	 }
	    	 else
	    	 {
	    	 $('#gsidebar-navanchor').gsidebar('select', e.id);
	    	 org.r3.PageManager.closeAllBreadCrumbs();
	    	 
	    	 switch(e.id)
		     {		    	 		    	 
		     case 'act_query_bbstopic':
		    	 this.openBBSTopicQueryActionFormPanel();
		    	 break;
		    	 		    	 
		     default:
	    	     break;
		    	 
		     }
   		 }
	     }
	 },
	 
	 openBBSTopicPanel: function(aBbsDtoAdapter)
	 {
		 org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.console.bbs.message.breadcrumb_bbstopic,
			"actionForm" : this.bbsTopicDetailActionForm
		});
		 
		 this.bbsTopicDetailActionForm.open(aBbsDtoAdapter);		 
	 },

	 closeBBSTopicPanel: function()
	 {
   	     org.r3.PageManager.closeAllBreadCrumbs();
	     this.openBBSTopicQueryActionFormPanel();
	 },
	 
	 openBBSTopicQueryActionFormPanel : function()
	 {		 
		 org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.console.bbs.message.breadcrumb_querybbstopic,
			"actionForm" : this.bbsTopicQueryActionForm
		});
		 
		 this.bbsTopicQueryActionForm.open();
		 $('#gsidebar-navanchor').gsidebar('select', 'act_query_bbstopic');		 
	 },
	 
	 openThreadPanel: function(aTopicId, aThreadDTOAdapter)
	 {
		 org.r3.PageManager.pushBreadCrumb(
		 {
			"title" : org.r3.console.bbs.message.breadcrumb_bbsthread,
			"actionForm" : this.bbsThreadDetailActionForm
		 });
					 
		 this.bbsThreadDetailActionForm.open(aTopicId, aThreadDTOAdapter);		 		 
	 },
	 
	 openThreadNodePanel: function(aTopicId, aThreadId, aParentThreadNodeId, aThreadNodeDTOAdapter)
	 {
		 org.r3.PageManager.pushBreadCrumb(
		 {
			"title" : org.r3.console.bbs.message.breadcrumb_bbspost,
			"actionForm" : this.bbsThreadNodeDetailActionForm
		 });
					 
		 this.bbsThreadNodeDetailActionForm.open(aTopicId, aThreadId, aParentThreadNodeId, aThreadNodeDTOAdapter);		 		 		 
	 }
	 	
};

