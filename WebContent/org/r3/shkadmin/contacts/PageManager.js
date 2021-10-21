$.r3Utils.namespace("org.r3.shkadmin.contacts");

org.r3.shkadmin.contacts.PageManager =
{
	init : function()
	{
		 this.deleteGroupConfirmationDialogActionForm = new org.r3.jsportlet.dialog.DialogConfirmationActionForm(this, "#actorGroupDeleteConfirmationDialogActionForm");
		 this.deleteGroupConfirmationDialogActionForm.open();

		 this.actorQueryActionForm = new org.r3.console.contacts.ActorQueryActionForm(this, "#actorQueryActionForm");		 
		 this.actorDetailActionForm = new org.r3.console.contacts.ActorDetailActionForm(this, "#actorDetailActionForm", "#actorDetailActionFormView_tab_generale", "#actorDetailActionFormView_tab_siteresource");
		 
		 this.actorGroupQueryActionForm = new org.r3.console.contacts.ActorGroupQueryActionForm(this, "#actorGroupQueryActionForm");		 
		 this.actorGroupDetailActionForm = new org.r3.console.contacts.ActorGroupDetailActionForm(this, "#actorGroupDetailActionForm", "#actorGroupActorQueryActionForm");
		 this.actorGroupAddActorsActionForm = new org.r3.console.contacts.ActorGroupAddActorsActionForm(this, "#actorGroupAddActorsActionForm");
		 
		 this.createGSideBar();
		 org.r3.PageManager.pushHomeBreadCrumb();
		 org.r3.PageManager.pushBreadCrumb(this.getHomeBreadCrumb());
		 this.openActorQueryActionFormPanel();		 		
	},
	
	 getHomeBreadCrumb: function()
	 {
			return  {
				"type": "breadcrumb_system",
				"noHistory": true,
				"title" : "Area Privata",
				"actionForm" :  
				{

					show : function()
					{
						org.r3.PageManager.gotoPage(org.r3.Constants.getStrutsActionContext() + "/org/r3/shkadmin/home.do");				
					},

					close : function()
					{					
					},
					
					refresh: function()
					{
					}
				}									 
			 };
	 },
	 
	 ask4Confirmation: function(optHash)
	 {
	     this.deleteGroupConfirmationDialogActionForm.show(optHash);
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
			 id : 'gmenubar_act_newcontact',
				title : org.r3.console.contacts.message.gmenubar_act_newcontact_caption,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				selected: true,
				icon: 'user-plus'
		 });	 

		 sect1.items.push({			    
				id : 'act_querycontacts',
				title : org.r3.console.contacts.message.gmenubar_act_querycontacts_caption,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				selected: true,
				icon: 'users'
		 });	 
		 		 		 		 
		 var sectg = {
	   		        type: 'section',			    
					id : 'gmenubar_sect_groups',
					bottom_border: true,
					items: []
		 };		 
		 gsidebarCfg.sections.push(sectg);	 
		 
		 sectg.items.push({			    
				id : 'act_query_groups',
				title : org.r3.console.contacts.message.gmenubar_act_act_query_groups_caption,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				icon: 'group'
		 });
		 
		 sectg.items.push({			    
				id : 'act_newgroup',
				title : org.r3.console.contacts.message.gmenubar_act_act_newgroup_caption,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				icon: 'plus'
		 });	 

		 var sect2 = {
	   		        type: 'section',			    
					id : 'gmenubar_sect_quickgroupmenu',
					bottom_border: true,
					items: [],
					title: "Menu' Rapido Gruppi",
					grouped: true,
					icon: 'bars'
		 };		 
		 gsidebarCfg.sections.push(sect2);	 

		 $('#gsidebar-navanchor').gsidebar(gsidebarCfg);
		 
		 var _self = this;
		 
	     $.ajax({
	          "dataType": 'json',
	          "type": "GET",
	          "url": org.r3.PageManager.getRESTUrl('GET_UserAndApp_ActorGroups'),
	          "success": function(data, textStatus, jqXHR)
	          {
	        	  if (data.aaData && data.aaData.length)
	        	  {
	        		   var groupItems = [];
	        		   for(var i = 0; i < data.aaData.length; i++)
	        		   {
	        			   if (data.aaData[i].groupprofile &&  data.aaData[i].groupprofile.indexOf('gmenubar') >= 0)
	        			   {
		        			   groupItems.push({
		   	       				id : data.aaData[i].groupid,
			       				title : data.aaData[i].grouptitle,
			       				onClick : $.r3Utils.hitch(_self, _self._onGMenuBarClick),
			       				deletable: data.aaData[i].groupprofile &&  data.aaData[i].groupprofile.indexOf('deletable') >= 0	        				   
		        			   }); 
        				   }
        			   }	        		   			    
	        		   
	        		   $('#gsidebar-navanchor').gsidebar('addItems2Section', 'gmenubar_sect_quickgroupmenu', groupItems);
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
		     case 'act_querycontacts':
		    	 this.openActorQueryActionFormPanel();
		    	 break;

		     case 'act_filecontacts':
		    	 this.openUploadFilesPanel();
		    	 break;
		    			    	 
		     case 'act_query_groups':
		    	 this.openActorGroupQueryPanel();
		    	 break;
		    	 
		     case 'act_newgroup':		    	 
		    	 this.openNewActorGroupPanel();
		    	 break;		    		    	 
		    	 
		     default:
		    	 this.openActorGroupDetailPanel(e.id);
	    	     break;
		    	 
		     }
   		 }
	     }
	 },
	 
	 openActorQueryActionFormPanel : function()
	 {		 
		 org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Elenco Contatti",
			"actionForm" : this.actorQueryActionForm
		});
		 
		 this.actorQueryActionForm.open();
		 $('#gsidebar-navanchor').gsidebar('select', 'act_querycontacts');		 
	 },
		
	openActorGroupQueryPanel: function()
	{
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Gruppi Contatto",
			"actionForm" : this.actorGroupQueryActionForm
		});

		this.actorGroupQueryActionForm.open();		
	},
	
	 openActorDetailPanel : function(actorDataBean)
	 {
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Det. Contatto",
			"actionForm" : this.actorDetailActionForm
		});

		this.actorDetailActionForm.open(actorDataBean);
	},
	
	 openNewActorPanel : function()
	 {
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Nuovo Contatto",
			"actionForm" : this.actorDetailActionForm
		});

		this.actorDetailActionForm.open();
	},

	closeNewActorPanel : function()
    {
   	     org.r3.PageManager.closeAllBreadCrumbs();
	     this.openActorQueryActionFormPanel();
    },
    
	     
	 openActorGroupDetailPanel : function(groupId)
	 {
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Det. Gruppo",
			"actionForm" : this.actorGroupDetailActionForm
		});

		this.actorGroupDetailActionForm.open(groupId);
	},

	onActorGroupUpdate: function(anActorGroupDTOAdapter)
	{		
	   var theItem = $('#gsidebar-navanchor').gsidebar('find', anActorGroupDTOAdapter.dataBean.groupid);
	   
	   if (anActorGroupDTOAdapter.isGroupprofile('gmenubar'))
	   {		   
		   if (theItem)
   	          $('#gsidebar-navanchor').gsidebar('updateItemTitle', anActorGroupDTOAdapter.dataBean.groupid, anActorGroupDTOAdapter.dataBean.grouptitle);
		   else
		   {
			   // Lo stesso frammento di onCreate.
			   groupItems = [{
	 				id : anActorGroupDTOAdapter.dataBean.groupid,
					title : anActorGroupDTOAdapter.dataBean.grouptitle,
					onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
					deletable: anActorGroupDTOAdapter.isGroupprofile('deletable')	        				   
		       }];        		   			    
		   
			   $('#gsidebar-navanchor').gsidebar('addItems2Section', 'gmenubar_sect_quickgroupmenu', groupItems);				   
		   }
	   }
	   else
	   {
		   // E' selezionato ed e' cancellabile.
		   if (theItem)
			   $('#gsidebar-navanchor').gsidebar('remove', anActorGroupDTOAdapter.dataBean.groupid);		   
	   }
	},

	onActorGroupCreate: function(anActorGroupDTOAdapter)
	{		   
	   if (anActorGroupDTOAdapter.isGroupprofile('gmenubar'))	
       {
		   groupItems = [{
	 				id : anActorGroupDTOAdapter.dataBean.groupid,
					title : anActorGroupDTOAdapter.dataBean.grouptitle,
					onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
					deletable: anActorGroupDTOAdapter.isGroupprofile('deletable')	        				   
		   }];        		   			    
		   
		   $('#gsidebar-navanchor').gsidebar('addItems2Section', 'gmenubar_sect_quickgroupmenu', groupItems);	
       }

	   this.closeNewActorGroupPanel(anActorGroupDTOAdapter);
	},

	openNewActorGroupPanel : function()
	{
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Nuovo Gruppo",
			"actionForm" : this.actorGroupDetailActionForm
		});

		this.actorGroupDetailActionForm.open();
	},
	
	onDeleteActorGroup: function(aGroupId)
	{
		this.ask4Confirmation({
			onConfirmed: $.r3Utils.hitch(this, function(aRemoveActorsFlag) { this.deleteActorGroup(aGroupId, aRemoveActorsFlag); })
		});	
	},	
	
    deleteActorGroup: function(aGroupId, removeActorsFlag)
    {    	
    	var _self = this;

		var method = "DELETE";
		var restUrl = org.r3.PageManager.getRESTUrl('DELETE_ActorGroup', [ aGroupId, removeActorsFlag ]);

		org.r3.PageManager.wait("org.r3.message.waiting");
		$.ajax(
		{
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"success" : function()
			{
				org.r3.PageManager.closeNotifier();
				 // E' selezionato ed e' cancellabile.
				 $('#gsidebar-navanchor').gsidebar('remove', aGroupId);
				 
		     	 $('#gsidebar-navanchor').gsidebar('select', 'act_querycontacts');
		     	 org.r3.PageManager.closeAllBreadCrumbs();
		   	     _self.openActorQueryActionFormPanel();	    		 
			},
			"error" : function(jqXHR, timeout, message)
			{
				console.error("Errore Deleting Actor Group: ", message);
			}
		});		
    },
    
	closeNewActorGroupPanel : function(anActorGroupDTOAdapter)
    {
   	     org.r3.PageManager.closeAllBreadCrumbs();
   	     
   	     if (anActorGroupDTOAdapter)
   	     {
   	    	 $('#gsidebar-navanchor').gsidebar('select', anActorGroupDTOAdapter.dataBean.groupid);
   	    	 this.openActorGroupDetailPanel(anActorGroupDTOAdapter.dataBean.groupid);   	    	 
   	     }
   	     else
   	     {
   	    	 $('#gsidebar-navanchor').gsidebar('select', 'act_querycontacts');
   		     this.openActorQueryActionFormPanel();   	    	    	    	 
   	     }
    },
    
    addActorsToGroup: function(aGroupId)
    {
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Aggiungi Contatti",
			"actionForm" : this.actorGroupAddActorsActionForm
		});

		this.actorGroupAddActorsActionForm.open(aGroupId);	
    }
    
	
};
