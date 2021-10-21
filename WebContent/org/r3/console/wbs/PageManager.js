$.r3Utils.namespace("org.r3.console.wbs");

org.r3.console.wbs.PageManager = 
{
  	
	 init: function()
	 {			 
		 this.wbsQueryActionForm = new org.r3.jsportlet.wbs.WBSQueryActionForm(this, '#wbsQueryActionForm');
		 this.wbsActionForm = new org.r3.jsportlet.wbs.WBSActionForm(this, '#wbsActionForm');
		 
		 this.createGSideBar();
		 org.r3.PageManager.pushHomeConsoleBreadCrumb();
		 this.openWBSQueryActionFormPanel();
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
			    id : 'gmenubar_act_newwbs',
				title : org.r3.console.wbs.message.gmenubar_act_newwbs,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable : false,
				selected : true,
				icon: 'plus'
		 });
		 
		 sect1.items.push({
				id : 'act_query_wbs',
				title : org.r3.console.wbs.message.act_query_wbs,
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
         if (e.id == 'gmenubar_act_newwbs')
         {
        	 org.r3.PageManager.closeAllBreadCrumbs();
        	 $('#gsidebar-navanchor').gsidebar('select', e.id);
        	 
        	 this.openWBSPanel();
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
		     case 'act_query_wbs':
		    	 this.openWBSQueryActionFormPanel();
		    	 break;
		    	 		    	 
		     default:
	    	     break;
		    	 
		     }
   		 }
	     }
	 },
	 
	 openWBSPanel: function(aWbsDtoAdapter)
	 {
		 org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.console.wbs.message.wbs_breadcrumb,
			"actionForm" : this.wbsActionForm
		});
		 
		 this.wbsActionForm.open(aWbsDtoAdapter);		 
	 },

	 closeWBSPanel: function()
	 {
   	     org.r3.PageManager.closeAllBreadCrumbs();
	     this.openWBSQueryActionFormPanel();
	 },
	 
	 openWBSQueryActionFormPanel : function()
	 {		 
		 org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.console.wbs.message.list_of_wbs_breadcrumb,
			"actionForm" : this.wbsQueryActionForm
		});
		 
		 this.wbsQueryActionForm.open();
		 $('#gsidebar-navanchor').gsidebar('select', 'act_query_wbs');		 
	 }
	 	
};

