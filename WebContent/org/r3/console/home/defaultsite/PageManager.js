$.r3Utils.namespace("org.r3.console.home.defaultsite");

org.r3.console.home.defaultsite.PageManager = 
{
  	
	 init: function()
	 {
		 this.regattasQueryActionForm = new org.r3.console.regattas.RegattasQueryActionForm(this, "#regattasQueryActionForm");	
		 this.regattaDetailActionForm = new org.r3.console.regattas.RegattaDetailActionForm(this, "#regattaDetailActionForm");	
		 
		 org.r3.PageManager.pushHomeConsoleBreadCrumb();			 		 
		 this.createConsoleGMenuBar($.r3Utils.hitch(this, this._onGMenuBarClick), $.r3Utils.hitch(this, this._onGMenuBarSiteClick));
	 },
	 
//	 openPanel : function()
//	 {
//		 org.r3.PageManager.pushHomeConsoleBreadCrumb();			 		 
//		 this.createGMenuBar();		 
//	 },
	 
	 createConsoleGMenuBar: function(onClickCallBack, onClickSiteCallBack)
	 { 
		 var gsidebarCfg = {};
		 gsidebarCfg.sections = []; 
	 
		 var networkRequestsQueue = [];
		 networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_CMS_ConsolePages'));
		 networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_Site_GSideBarChildren'));
		 
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
			 
			 var sideBarItem = {			    
					    id : 'gmenubar_act_newsite',
						title : org.r3.message.gmenubar_act_newsite,
						onClick : onClickCallBack,
						deletable: false,
						selected: false,
						icon: 'plus'
			 };
			
			 if (!firstSelectedSideBarItem && sideBarItem.selected)
				 firstSelectedSideBarItem = sideBarItem;
			
			 if (!firstEnabledSideBarItem)
				 firstEnabledSideBarItem = sideBarItem;
			 
			 sect1.items.push(sideBarItem);	 

			 
			 var sideBarItem = {			    
					id : 'act_queryregattas',
					title : org.r3.message.gmenubar_act_queryregattas,
					onClick : onClickCallBack,
					deletable: false,
					selected: true,
					icon: 'table'
			 };	 

			 if (!firstSelectedSideBarItem && sideBarItem.selected)
				 firstSelectedSideBarItem = sideBarItem;
			
			 if (!firstEnabledSideBarItem)
				 firstEnabledSideBarItem = sideBarItem;
			 
			 sect1.items.push(sideBarItem);	 

			 var lutPageItem = org.r3.PageManager.lutManager.getLUTItem(lutPageResolvedUrl, org.r3.Constants.site + "_contacts");
			 if (lutPageItem)
			 {
				 var sideBarItem = {			    
						id : 'act_contacts',
						title : org.r3.message.gmenubar_act_contacts,
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
			 
 
			 var lutPageItem = org.r3.PageManager.lutManager.getLUTItem(lutPageResolvedUrl, org.r3.Constants.site + "_manage_cms");
			 if (lutPageItem)
			 {
				 var sideBarItem = {			    
					id : 'act_cms',
					title : org.r3.message.gmenubar_act_cms,
					onClick : onClickCallBack,
					deletable: false,
					selected: false,
					icon: 'edit'
				 };
				 
				 if (!firstSelectedSideBarItem && sideBarItem.selected)
					 firstSelectedSideBarItem = sideBarItem;
				
				 if (!firstEnabledSideBarItem)
					 firstEnabledSideBarItem = sideBarItem;
				 
				 sect1.items.push(sideBarItem);
			 }
			 
			 var lutPageItem = org.r3.PageManager.lutManager.getLUTItem(lutPageResolvedUrl, org.r3.Constants.site + "_manage_bbs");
			 if (lutPageItem)
			 {
				 var sideBarItem = {			    
					id : 'act_bbs',
					title : org.r3.message.gmenubar_act_bbs,
					onClick : onClickCallBack,
					deletable: false,
					selected: false,
					icon: 'comment-o'
				 };
				 
				 if (!firstSelectedSideBarItem && sideBarItem.selected)
					 firstSelectedSideBarItem = sideBarItem;
				
				 if (!firstEnabledSideBarItem)
					 firstEnabledSideBarItem = sideBarItem;
				 
				 sect1.items.push(sideBarItem);
			 }
			 
			 var lutPageItem = org.r3.PageManager.lutManager.getLUTItem(lutPageResolvedUrl, org.r3.Constants.site + "_manage_wbs");
			 if (lutPageItem)
			 {
				 var sideBarItem = {			    
					id : 'act_wbs',
					title : org.r3.message.gmenubar_act_wbs,
					onClick : onClickCallBack,
					deletable: false,
					selected: false,
					icon: 'list-ul'
				 };
				 
				 if (!firstSelectedSideBarItem && sideBarItem.selected)
					 firstSelectedSideBarItem = sideBarItem;
				
				 if (!firstEnabledSideBarItem)
					 firstEnabledSideBarItem = sideBarItem;
				 
				 sect1.items.push(sideBarItem);
			 }
			
			 var lutPageItem = org.r3.PageManager.lutManager.getLUTItem(lutPageResolvedUrl, org.r3.Constants.site + "_manage_tow");
			 if (lutPageItem)
			 {
				 var sideBarItem = {			    
					id : 'act_tow',
					title : "Amministrazione TOW...",
					onClick : onClickCallBack,
					deletable: false,
					selected: false,
					icon: 'tasks'
				 };
				 
				 if (!firstSelectedSideBarItem && sideBarItem.selected)
					 firstSelectedSideBarItem = sideBarItem;
				
				 if (!firstEnabledSideBarItem)
					 firstEnabledSideBarItem = sideBarItem;
				 
				 sect1.items.push(sideBarItem);
			 }
			 
			 var lutPageItem = org.r3.PageManager.lutManager.getLUTItem(lutPageResolvedUrl, org.r3.Constants.site + "_manage_resource");
			 if (lutPageItem)
			 {
				 var sideBarItem = {			    
					id : 'act_resource',
					title : "Risorse...",
					onClick : onClickCallBack,
					deletable: false,
					selected: false,
					icon: 'user-times'
				 };
				 
				 if (!firstSelectedSideBarItem && sideBarItem.selected)
					 firstSelectedSideBarItem = sideBarItem;
				
				 if (!firstEnabledSideBarItem)
					 firstEnabledSideBarItem = sideBarItem;
				 
				 sect1.items.push(sideBarItem);
			 }	
			 
			 var lutPageItem = org.r3.PageManager.lutManager.getLUTItem(lutPageResolvedUrl, org.r3.Constants.site + "_siteconfig");
			 if (lutPageItem)
			 {
				 var sideBarItem = {			    
					id : 'act_config',
					title : org.r3.message.gmenubar_act_config,
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
			 
			 var sect_childrensites = {
		   		        type: 'section',			    
						id : 'gmenubar_sect_childrensites',
						title: org.r3.message.gmenubar_act_childrensite,
						bottom_border: true,
						items: [],
						icon: 'bars',
						grouped: true
				 };		 
			 gsidebarCfg.sections.push(sect_childrensites);
			 

			 var lutPageItem = org.r3.PageManager.lutManager.getLUTItem(lutPageResolvedUrl, org.r3.Constants.site + "_manage_users");
			 if (lutPageItem)
			 {
				 var p = new org.r3.db.cms.page.PageDTOAdapter(lutPageItem);
				 if (p.isInRole())
				 {
					 var sideBarItem = {			    
						id : 'act_users',
						title : org.r3.message.gmenubar_act_users,
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
			 }
			 
			 var lutPageItem = org.r3.PageManager.lutManager.getLUTItem(lutPageResolvedUrl, org.r3.Constants.site + "_manage_rest");
			 if (lutPageItem)
			 {
				 var p = new org.r3.db.cms.page.PageDTOAdapter(lutPageItem);
				 if (p.isInRole())
				 {
					 var sideBarItem = {			    
							 id : 'act_resturls',
							 title : org.r3.message.gmenubar_act_resturls,
							 onClick : onClickCallBack,
							 deletable: false,
							 selected: false,
							 icon: 'wrench'
					 };
					 
					 if (!firstSelectedSideBarItem && sideBarItem.selected)
						 firstSelectedSideBarItem = sideBarItem;
					
					 if (!firstEnabledSideBarItem)
						 firstEnabledSideBarItem = sideBarItem;
					 
					 sect1.items.push(sideBarItem);
				 }
			 }

			 $('#gsidebar-navanchor').gsidebar(gsidebarCfg);		 

			 var resolvedUrl = org.r3.PageManager.getRESTUrl('LUT_Site_GSideBarChildren');
			 var lutChildrenSite = org.r3.PageManager.lutManager.getLUT(resolvedUrl);
			 
			 if (lutChildrenSite && lutChildrenSite.aaData.length)
			 {
      		   var siteItems = [];
    		   for(var i = 0; i < lutChildrenSite.aaData.length; i++)
    		   {
    			  
    			   siteItems.push({
   	       				id : lutChildrenSite.aaData[i].site,
	       				title : lutChildrenSite.aaData[i].sitedescr,
	       				onClick : onClickSiteCallBack,
	       				deletable: false	        				   
        		   }); 	        				   
    			   
    		   }	        		   			    
    		   
        	   $('#gsidebar-navanchor').gsidebar('addItems2Section', 'gmenubar_sect_childrensites', siteItems);	
       
			 }
		
			 if (firstSelectedSideBarItem)
				 onClickCallBack(firstSelectedSideBarItem, 'gsidebar_init');
			 
			 else if (firstEnabledSideBarItem)
				 onClickCallBack(firstEnabledSideBarItem, 'gsidebar_init');
    		 
		 }));
		 		 				 		 
		 
	 },

	 _onGMenuBarSiteClick: function(e, actionTriggered)
	 {
		 org.r3.PageManager.gotoPage(org.r3.Constants.getStrutsActionContext(e.id) + "/org/r3/console/home.do");
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
    	 case 'gmenubar_act_newsite':
    		 this.openNewSitePanel();
    	     break;
    	     
	     case 'act_queryregattas':
	    	 this.openQueryRegattasPanel();
	    	 break;

	     case 'act_contacts':
	    	 this.openContactsPanel();
	    	 break;
	    	 
	     case 'act_cms':		    	 
	    	 this.openCMSPanel();
	    	 break;
	    	
	     case 'act_config':
	    	 this.openConfigPanel();
	    	 break;

	     case 'act_bbs':
	    	 this.openBBSPanel();
	    	 break;
	    	 
	     case 'act_wbs':
	    	 this.openWBSPanel();
	    	 break;

	     case 'act_tow':
	    	 this.openTOWPanel();
	    	 break;

	     case 'act_resource':
	    	 this.openResourcePanel();
	    	 break;
	    	 
	     case 'act_users':
	    	 this.openUsersPanel();
	    	 break;
	    	 
	     case 'act_resturls':
	    	 this.openRestUrlsPanel();
	    	 break;
	    	 
	     default:		    	 
    	     break;
	    	 
	     }
	 },

	 
	 openNewSitePanel : function()
	 {
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Nuova Regata",
			"actionForm" : this.regattaDetailActionForm
		});

		this.regattaDetailActionForm.open();
	},
	
	closeNewSitePanel: function()
	{
  	     org.r3.PageManager.closeAllBreadCrumbs();
	     this.openQueryRegattasPanel();
	},
	
	 openQueryRegattasPanel: function()
     {		 
		 org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Elenco Regate",
			"actionForm" : this.regattasQueryActionForm
		});
		 
		 this.regattasQueryActionForm.open();	 
	 },

	 openRegattaDetailPanel : function(regattaDataBean)
	 {
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Det. Regata",
			"actionForm" : this.regattaDetailActionForm
		});

		this.regattaDetailActionForm.open(regattaDataBean);
	},
	
	 openContactsPanel: function()
	 {
		 org.r3.PageManager.gotoPage('contacts.do');
	 },
	 
	 openCMSPanel: function()
	 {
		 org.r3.PageManager.gotoPage('cms/cards.do');
	 },
	 
	 openConfigPanel: function()
	 {
		 org.r3.PageManager.gotoPage('siteconfig.do');
	 },
	 
	 openUsersPanel: function()
	 {
		 org.r3.PageManager.gotoPage('users.do');
	 },

	 openWBSPanel: function()
	 {
		 org.r3.PageManager.gotoPage('wbs.do');
	 },

	 openTOWPanel: function()
	 {
		 org.r3.PageManager.gotoPage('tow.do');
	 },

	 openResourcePanel: function()
	 {
		 org.r3.PageManager.gotoPage('resources.do');
	 },

	 openBBSPanel: function()
	 {
		 org.r3.PageManager.gotoPage('bbs.do');
	 },
	 
	 openRestUrlsPanel: function()
	 {
		 org.r3.PageManager.gotoPage('system/resturls.do');		 
	 }
};

