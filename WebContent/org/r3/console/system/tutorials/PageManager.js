$.r3Utils.namespace("org.r3.console.system.tutorials");

org.r3.console.system.tutorials.PageManager = 
{
  	
	 init: function()
	 {

		 this.simpleUrlInvokationActionForm = new org.r3.console.system.tutorials.SimpleURLInvokationActionForm(this, '#pageWorkCanvas');	
		 org.r3.PageManager.pushHomeConsoleBreadCrumb();
		 
		 this.createGSideBar();
	 },
	 
	 createGSideBar: function()
	 {
		 var gsidebarCfg = {};
		 gsidebarCfg.csshoverenabled = false;
		 gsidebarCfg.sections = []; 

		 var sect1 = {
	   		        type: 'section',			    
					id : 'gmenubar_sect_action',
					bottom_border: true,
					items: []
		 };		 
		 gsidebarCfg.sections.push(sect1);	 

		 sect1.items.push({			    
			 id : 'act_videotutorials',
				title : org.r3.console.system.tutorials.message.gmenubar_act_videotutorials_caption,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				selected: false,
				icon: 'video-camera'
		 });

    	     	 
		 $('#gsidebar-navanchor').gsidebar(gsidebarCfg);
	 },
	 
	 _onGMenuBarClick: function(e, actionTriggered)
	 {
         console.info("_itsbeenclicked", e);	
         if (e.id == 'gmenubar_act_newcontact')
         {
        	 org.r3.PageManager.closeAllBreadCrumbs();
        	 $('#gsidebar-navanchor').gsidebar('select', e.id);
        	 
        	 this.openNewActorPanel();
             return ;        	 
         }
	     
	     if (e.selected)
	     {
	    	 if (actionTriggered && actionTriggered == 'delete')
	    	 {
	    		 this.onDeleteActorGroup(e.id);
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
	    		 this.onDeleteActorGroup(e.id);
	    	 }
	    	 else
	    	 {
	         $('#gsidebar-navanchor').gsidebar('select', e.id);
	    	 org.r3.PageManager.closeAllBreadCrumbs();
	    	 
	    	 switch(e.id)
		     {
		     case 'act_videotutorials':
		    	 this.mngmt_videotutorials();
		    	 break;
		    	 
		    	 
		     default:
	    	     break;
		    	 
		     }
   		 }
	     }
	 },
	 
	 mngmt_videotutorials: function()
	 {
		 org.r3.PageManager.pushBreadCrumb(
		 {
			"title" : "Rest URLs Methods",
			"actionForm" : this.simpleUrlInvokationActionForm
		 });
		 
		 this.simpleUrlInvokationActionForm.open("POST", org.r3.Constants.applicationContext + "/was/default/it/system/calendar/initialize;calperiod=true;calendarid=default;startdate=20150101;startday=1;length=6575"); 
	 }	 
	 
};

