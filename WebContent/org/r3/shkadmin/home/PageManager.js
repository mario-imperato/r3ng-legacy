$.r3Utils.namespace("org.r3.shkadmin.home");

org.r3.shkadmin.home.PageManager = 
{
  	
	 init: function()
	 {		 				 
		 org.r3.PageManager.pushHomeBreadCrumb();	
		 
		 this.shkWelcomeCard = new org.r3.shkadmin.home.SHKAdminWelcomeActionForm(this, "#shkinfoprofile_welcomecard");	
		 this.createGMenuBar($.r3Utils.hitch(this, this._onGMenuBarClick), $.r3Utils.hitch(this, this._onGMenuBarSiteClick));
		 

	 },
	 

	createGMenuBar: function(onClickCallBack, onClickSiteCallBack)
	{ 				
		 var gsidebarCfg = {};
		 gsidebarCfg.sections = []; 
	
		 var networkRequestsQueue = [];
		 networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_CMS_ConsolePages'));
		 
		 
		 org.r3.PageManager.multiAjax(networkRequestsQueue,
	
		 $.r3Utils.hitch(this, function(responseData)
		 {		
			 var lutPageResolvedUrl = org.r3.PageManager.getRESTUrl('LUT_CMS_ConsolePages');
			 var firstSelectedSideBarItem = null;
			 var firstEnabledSideBarItem = null;
			 
			 var sect1 = {
		   		        type: 'section',			    
						id : 'gmenubar_sect_action',
						bottom_border: true,
						items: []
			 };		 
			 gsidebarCfg.sections.push(sect1);	 
			 		
			 var lutPageItem = org.r3.PageManager.lutManager.getLUTItem(lutPageResolvedUrl, org.r3.Constants.site + "_shksiteprofile");
			 if (lutPageItem || true)
			 {
				 var sideBarItem = {			    
						id : 'act_shkprofile',
						title : org.r3.shkadmin.home.message.gmenubar_act_shksiteprofile,
						onClick : onClickCallBack,
						deletable: false,
						selected: false,
						icon: 'cog'
				 };
				 
				 if (!firstSelectedSideBarItem && sideBarItem.selected)
					 firstSelectedSideBarItem = sideBarItem;
				
				 if (!firstEnabledSideBarItem)
					 firstEnabledSideBarItem = sideBarItem;
				 
				 sect1.items.push(sideBarItem);		
			 }
			 
			 if (lutPageItem || true)
			 {
				 var sideBarItem = {			    
						id : 'act_shkcms',
						title : org.r3.shkadmin.home.message.gmenubar_act_cms,
						onClick : onClickCallBack,
						deletable: false,
						selected: false,
						icon: 'database'
				 };
				 
				 if (!firstSelectedSideBarItem && sideBarItem.selected)
					 firstSelectedSideBarItem = sideBarItem;
				
				 if (!firstEnabledSideBarItem)
					 firstEnabledSideBarItem = sideBarItem;
				 
				 sect1.items.push(sideBarItem);		
			 }
			 
			 if (lutPageItem || true)
			 {
				 var sideBarItem = {			    
						id : 'act_shkcontacts',
						title : org.r3.shkadmin.home.message.gmenubar_act_contacts,
						onClick : onClickCallBack,
						deletable: false,
						selected: false,
						icon: 'users'
				 };
				 
				 if (!firstSelectedSideBarItem && sideBarItem.selected)
					 firstSelectedSideBarItem = sideBarItem;
				
				 if (!firstEnabledSideBarItem)
					 firstEnabledSideBarItem = sideBarItem;
				 
				 sect1.items.push(sideBarItem);		
			 }
			 
			 $('#gsidebar-navanchor').gsidebar(gsidebarCfg);		 
	
		 }));
		 		 				 		 
		 this.openWelcomeCard();
	},
	
	_onGMenuBarSiteClick: function(e, actionTriggered)
	{
		 org.r3.PageManager.gotoPage(org.r3.Constants.getStrutsActionContext(e.id) + "/org/r3/shkadmin/home.do");
	},
	
	_onGMenuBarClick: function(e, actionTriggered)
	{	     
	    if (!actionTriggered)  
	    {
	   	 if (e.selected)
		     {
	   		 org.r3.PageManager.activateFirstBreadCrumb(); 
		     }
	   	 else
	   	 {
	            this.activateItem(e);		 
	   	 }
	  	 }
	    else
	    {
	   	 switch(actionTriggered)
	   	 {
	   	 case 'delete':
	   		 // this.deleteActorGroup(e.id);
	   		 break;
	   	 case 'gsidebar_init':
	   		 this.activateItem(e);	
	   		 break;
	   	 }
	    }
	},
		 
	activateItem: function(e)
	{
		 $('#gsidebar-navanchor').gsidebar('select', e.id);
		 org.r3.PageManager.closeAllBreadCrumbs();
		 
		 switch(e.id)
	    {
	   	
	    case 'act_shkprofile':
	   	 this.openConfigPanel();
	   	 break;
		
	    case 'act_shkcms':
		   	 this.openCMSPanel();
		   	 break;	   	 
	   	
	    case 'act_shkcontacts':
		   	 this.openContactsPanel();
		   	 break;	   	 
	   	
		   	 
	    default:		    	 
		     break;
	   	 
	    }
	},
	 
	 openConfigPanel: function()
	 {
		 org.r3.PageManager.gotoPage('siteconfig.do');
	 },

	 openCMSPanel: function()
	 {
		 org.r3.PageManager.gotoPage('cms.do');
	 },
	 
	 openContactsPanel: function()
	 {
		 org.r3.PageManager.gotoPage('contacts.do');
	 },
	 
	 openWelcomeCard: function()
	 {
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.shkadmin.home.message.breadcrumb_shkadmin,
			"actionForm" : this.shkWelcomeCard
		});
			
		// welcomeCardId: "SHKADMNEIGHBCARD". Non valorizzando questa property la actionForm cerca l'elemento nell'attribute data-cardid della canvas.
		this.shkWelcomeCard.open({  });
	 }

	 
	
};

