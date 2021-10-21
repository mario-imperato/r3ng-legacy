$.r3Utils.namespace("org.r3.console.home.speedsails");

org.r3.console.home.speedsails.PageManager = 
{
  	
	 init: function()
	 {
		 this.openPanel();
	 },
	 
	 openPanel : function()
	 {
		 org.r3.PageManager.pushHomeConsoleBreadCrumb();			 		 
		 this.createGMenuBar();		 
	 },
	 
	 createGMenuBar: function()
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
				id : 'act_contacts',
				title : "Contatti...",
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				selected: false,
				icon: 'users'
		 });	 

		 sect1.items.push({			    
				id : 'act_cms',
				title : "Contenuti CMS...",
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				selected: false,
				icon: 'edit'
		 });	 

		 var sect_childrensites = {
	   		        type: 'section',			    
					id : 'gmenubar_sect_childrensites',
					bottom_border: true,
					items: []					
			 };		 
		 gsidebarCfg.sections.push(sect_childrensites);
			 
		 if (org.r3.PageManager.userInfo.isInRole(org.r3.Constants.site, 'consoleext'))
	     {
		 var sect_consoleext = {
	   		        type: 'section',			    
					id : 'gmenubar_sect_2',
					bottom_border: true,
					items: []
		 };		 
		 gsidebarCfg.sections.push(sect_consoleext);	 

		 sect_consoleext.items.push({			    
				id : 'act_users',
				title : "Gestione Utenti...",
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				selected: false,
				icon: 'users'
		 });	 

		 sect_consoleext.items.push({			    
				id : 'act_resturls',
				title : "Rest...",
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				selected: false,
				icon: 'wrench'
		 });	 
	     }
			 
		 $('#gsidebar-navanchor').gsidebar(gsidebarCfg);		 
		 
		 var _self = this;
			 
		 $.ajax({
		          "dataType": 'json',
		          "type": "GET",
		          "url": org.r3.PageManager.getRESTUrl('LUT_Site_GSideBarChildren'),
		          "success": function(data, textStatus, jqXHR)
		          {
		        	  if (data.aaData && data.aaData.length)
		        	  {
		        		   var siteItems = [];
		        		   for(var i = 0; i < data.aaData.length; i++)
		        		   {
		        			  
		        			   siteItems.push({
			   	       				id : data.aaData[i].site,
				       				title : data.aaData[i].sitedescr,
				       				onClick : $.r3Utils.hitch(_self, _self._onGMenuBarSiteClick),
				       				deletable: false	        				   
			        		   }); 	        				   
		        			   
		        		   }	        		   			    
		        		   
		 	        	   $('#gsidebar-navanchor').gsidebar('addItems2Section', 'gmenubar_sect_childrensites', siteItems);
		        	  }		        	  
		          },
		          "error": function (xhr, error, thrown)
		          {
		            if ( error == "parsererror" ) {
		              alert( "DataTables warning: JSON data from server could not be parsed. "+
		                "This is caused by a JSON formatting error." );
		            }
		          }
		    });
		 
	 },

	 _onGMenuBarSiteClick: function(e, actionTriggered)
	 {
		 org.r3.PageManager.gotoPage(org.r3.Constants.getStrutsActionContext(e.id) + "/org/r3/console/home.do");
	 },
	 
	 _onGMenuBarClick: function(e, actionTriggered)
	 {
         console.info("_itsbeenclicked", e);	
         if (e.id == 'gmenubar_act_newsite')
         {
        	 org.r3.PageManager.closeAllBreadCrumbs();
        	 $('#gsidebar-navanchor').gsidebar('select', e.id);
        	 
        	 this.openNewSitePanel();
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
	    		 // this.deleteActorGroup(e.id);
	    	 }
	    	 else
	    	 {
	    	 $('#gsidebar-navanchor').gsidebar('select', e.id);
	    	 org.r3.PageManager.closeAllBreadCrumbs();
	    	 
	    	 switch(e.id)
		     {
		     case 'act_querysites':
		    	 this.openQuerySitesPanel();
		    	 break;

		     case 'act_contacts':
		    	 this.openContactsPanel();
		    	 break;
		    	 
		     case 'act_cms':		    	 
		    	 this.openCMSPanel();
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
   		 }
	     }
	 },
	 
	 openNewSitePanel: function()
	 {
		 
	 },
	 
	 openQuerySitesPanel: function()
	 {
		 
	 },
	 
	 openContactsPanel: function()
	 {
		 org.r3.PageManager.gotoPage('contacts.do');
	 },
	 
	 openCMSPanel: function()
	 {
		 org.r3.PageManager.gotoPage('cms/cards.do');
	 },
	 
	 openUsersPanel: function()
	 {
		 org.r3.PageManager.gotoPage('users.do');
	 },
	 
	 openRestUrlsPanel: function()
	 {
		 org.r3.PageManager.gotoPage('system/resturls.do');		 
	 }
};

