$.r3Utils.namespace("org.r3.console.contacts");

org.r3.console.contacts.PageManager = 
{
  	
	 init: function()
	 {
		 this.deleteGroupConfirmationDialogActionForm = new org.r3.jsportlet.dialog.DialogConfirmationActionForm(this, "#actorGroupDeleteConfirmationDialogActionForm");
		 this.deleteGroupConfirmationDialogActionForm.open();

		 this.actorQueryActionForm = new org.r3.console.contacts.ActorQueryActionForm(this, "#actorQueryActionForm");		 
		 this.actorDetailActionForm = new org.r3.console.contacts.ActorDetailActionForm(this, "#actorDetailActionForm", "#actorDetailActionFormView_tab_generale", "#actorDetailActionFormView_tab_siteresource");
		 
		 this.exportContactsActionForm = new org.r3.console.contacts.ExportContactsActionForm(this, "#exportContactsActionForm");
		 this.actorGroupQueryActionForm = new org.r3.console.contacts.ActorGroupQueryActionForm(this, "#actorGroupQueryActionForm");		 
		 this.actorGroupDetailActionForm = new org.r3.console.contacts.ActorGroupDetailActionForm(this, "#actorGroupDetailActionForm", "#actorGroupActorQueryActionForm");
		 this.actorGroupAddActorsActionForm = new org.r3.console.contacts.ActorGroupAddActorsActionForm(this, "#actorGroupAddActorsActionForm");
		 this.smsDetailActionForm = new org.r3.console.contacts.SMSDetailActionForm(this, "#smsDetailActionForm");
		 this.smsQueryActionForm = new org.r3.console.contacts.SMSQueryActionForm(this, "#smsQueryActionForm");
		 
		 this.mailQueryActionForm = new org.r3.console.contacts.OutMailQueryActionForm(this, "#mailQueryActionForm");		 
		 this.sentMailDetailActionForm = new org.r3.jsportlet.outmail.SentMailMessageActionForm(this, "#outMailMessageActionForm");
		 this.outMailMessageActionForm = new org.r3.jsportlet.outmail.OutMailMessageActionForm(this, "#outMailMessageActionForm", "#outMailMessageAttachmentsActionForm");
         this.importActorsFromChildSiteActionForm = new org.r3.console.contacts.ImportActorsFromChildSiteActionForm(this, "#importActorsFromChildSiteActionForm");
		 this.uploadFileActionForm = new org.r3.jsportlet.fileupload.UploadFileActionForm(this, "#uploadFileActionForm");
		 
		 this.userPickerActionForm = new org.r3.jsportlet.user.UserPickerActionForm(this, '#userPickerActionForm', '#userPickerAdvancedSearchActionForm');
		 this.userDetailActionForm = new org.r3.jsportlet.user.UserDetailActionForm(this, '#userDetailActionForm');
		 
		 this.fileImportQueryActionForm = new org.r3.jsportlet.fileupload.FileImportQueryActionForm(this, "#fileImportQueryActionForm");
		 this.fileImportDetailActionForm = new org.r3.jsportlet.fileupload.FileImportDetailActionForm(this, "#fileImportDetailActionForm", 
		 {
			 "formfragment": org.r3.Constants.applicationContext + '/org/r3/console/contacts/FileImportExtensionActionForm.html.jsp',
			 "formFragmentInit": function() 
			 {
					org.r3.PageManager.lutManager.populateSelectField(
					{
						"lutUrl" : org.r3.PageManager.getRESTUrl('GET_UserAndApp_ActorGroups'),					
						"selectWidget" : $('#jsportletfileimportform_actorgroup'),
						"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText")
					});
			 },
			 
			 "processURL": "PUT_ProcessUploadedActorFile"
		 });
		 
		 // this.createGMenuBar();
		 this.createGSideBar();
		 org.r3.PageManager.pushHomeConsoleBreadCrumb();
		 this.openActorQueryActionFormPanel();
		 
//		 $('#do-toggle').unbind().click(function (e) {
//			 $('.gsidebar-nav').addClass('hoverenabled');
//		 });
//		 
//		 $('#do-untoggle').unbind().click(function (e) {
//			 $('.gsidebar-nav').removeClass('hoverenabled');
//		 });


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
		 
		 var sectExport = {
	   		        type: 'section',			    
					id : 'gmenubar_sect_export',
					bottom_border: true,
					items: []
		 };		 
		 gsidebarCfg.sections.push(sectExport);	
		 
		 sectExport.items.push({			    
				id : 'act_exportcontacts',
				title : org.r3.console.contacts.message.gmenubar_act_exportcontacts_caption,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				selected: false,
				icon: 'download'
		 });	 

		 sectExport.items.push({			    
				id : 'act_filecontacts',
				title : org.r3.console.contacts.message.gmenubar_act_filecontacts_caption,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				selected: false,
				icon: 'file'
		 });	 

		 sectExport.items.push({			    
				id : 'act_importcontacts',
				title : org.r3.console.contacts.message.gmenubar_act_importcontacts_caption,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				selected: false,
				icon: 'upload'				
		 });	 		 

		 sectExport.items.push({			    
				id : 'act_importchildsitecontacts',
				title : org.r3.console.contacts.message.gmenubar_act_importchildsitecontacts_caption,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				selected: false,
				icon: 'upload'				
		 });	 
		 
		 var sectSMS = {
	   		        type: 'section',			    
					id : 'gmenubar_sect_sms',
					bottom_border: true,
					items: []
		 };		 
		 gsidebarCfg.sections.push(sectSMS);
		 
		 sectSMS.items.push({			    
				id : 'act_newsms',
				title : org.r3.console.contacts.message.gmenubar_act_newsms_caption,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				icon: 'envelope'
		 });	 

		 sectSMS.items.push({			    
				id : 'act_querysms',
				title : org.r3.console.contacts.message.gmenubar_act_querysms_caption,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				icon: 'table'
		 });	 

		 var sectMail = {
	   		        type: 'section',			    
					id : 'gmenubar_sect_mail',
					bottom_border: true,
					items: []
			        
		 };		 
		 gsidebarCfg.sections.push(sectMail);
		 
		 sectMail.items.push({			    
				id : 'act_newoutmail',
				title : org.r3.console.contacts.message.gmenubar_act_newoutmail_caption,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				icon: 'envelope-o'				
		 });	
		 
		 sectMail.items.push({			    
				id : 'act_querymail',
				title : org.r3.console.contacts.message.gmenubar_act_querymail_caption,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				icon: 'table'
		 });	
		 
//		 var sectGroup = {
//	   		        type: 'section',			    
//					id : 'gmenubar_sect_groups',
//					bottom_border: true,
//					items: []
//		 };		 
//		 gsidebarCfg.sections.push(sectGroup);	
		 
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

//	 createGMenuBar: function()
//	 {
//		 var gemnubarCfg = {};
//		 gemnubarCfg.sections = []; 
//
//		 gemnubarCfg.mainaction = {
//				id : 'gmenubar_act_newcontact',
//				title : org.r3.console.contacts.message.gmenubar_act_newcontact_caption,
//				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick)
//		 };	 
//
//		 var sect1 = {
//	   		        type: 'section',			    
//					id : 'gmenubar_sect_action',
//					bottom_border: true,
//					items: []
//		 };		 
//		 gemnubarCfg.sections.push(sect1);	 
//
//		 sect1.items.push({			    
//				id : 'act_querycontacts',
//				title : org.r3.console.contacts.message.gmenubar_act_querycontacts_caption,
//				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
//				deletable: false,
//				selected: true
//		 });	 
//		 
//		 var sectExport = {
//	   		        type: 'section',			    
//					id : 'gmenubar_sect_export',
//					bottom_border: true,
//					items: []
//		 };		 
//		 gemnubarCfg.sections.push(sectExport);	
//		 
//		 sectExport.items.push({			    
//				id : 'act_exportcontacts',
//				title : org.r3.console.contacts.message.gmenubar_act_exportcontacts_caption,
//				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
//				deletable: false,
//				selected: false
//		 });	 
//
//		 sectExport.items.push({			    
//				id : 'act_filecontacts',
//				title : org.r3.console.contacts.message.gmenubar_act_filecontacts_caption,
//				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
//				deletable: false,
//				selected: false
//		 });	 
//
//		 sectExport.items.push({			    
//				id : 'act_importcontacts',
//				title : org.r3.console.contacts.message.gmenubar_act_importcontacts_caption,
//				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
//				deletable: false,
//				selected: false
//		 });	 		 
//
//		 sectExport.items.push({			    
//				id : 'act_importchildsitecontacts',
//				title : org.r3.console.contacts.message.gmenubar_act_importchildsitecontacts_caption,
//				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
//				deletable: false,
//				selected: false
//		 });	 
//		 
//		 var sectSMS = {
//	   		        type: 'section',			    
//					id : 'gmenubar_sect_sms',
//					bottom_border: true,
//					items: []
//		 };		 
//		 gemnubarCfg.sections.push(sectSMS);
//		 
//		 sectSMS.items.push({			    
//				id : 'act_newsms',
//				title : org.r3.console.contacts.message.gmenubar_act_newsms_caption,
//				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
//				deletable: false
//		 });	 
//
//		 sectSMS.items.push({			    
//				id : 'act_querysms',
//				title : org.r3.console.contacts.message.gmenubar_act_querysms_caption,
//				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
//				deletable: false
//		 });	 
//
//		 var sectMail = {
//	   		        type: 'section',			    
//					id : 'gmenubar_sect_mail',
//					bottom_border: true,
//					items: []
//		 };		 
//		 gemnubarCfg.sections.push(sectMail);
//		 
//		 sectMail.items.push({			    
//				id : 'act_newoutmail',
//				title : org.r3.console.contacts.message.gmenubar_act_newoutmail_caption,
//				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
//				deletable: false
//		 });	
//		 
////		 var sectGroup = {
////	   		        type: 'section',			    
////					id : 'gmenubar_sect_groups',
////					bottom_border: true,
////					items: []
////		 };		 
////		 gemnubarCfg.sections.push(sectGroup);	
//		 
//		 var sectg = {
//	   		        type: 'section',			    
//					id : 'gmenubar_sect_groups',
//					bottom_border: true,
//					items: []
//		 };		 
//		 gemnubarCfg.sections.push(sectg);	 
//		 
//		 sectg.items.push({			    
//				id : 'act_query_groups',
//				title : org.r3.console.contacts.message.gmenubar_act_act_query_groups_caption,
//				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
//				deletable: false
//		 });
//		 
//		 sectg.items.push({			    
//				id : 'act_newgroup',
//				title : org.r3.console.contacts.message.gmenubar_act_act_newgroup_caption,
//				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
//				deletable: false
//		 });	 
//
//		 var sect2 = {
//	   		        type: 'section',			    
//					id : 'gmenubar_sect_quickgroupmenu',
//					bottom_border: true,
//					items: []
//		 };		 
//		 gemnubarCfg.sections.push(sect2);	 
//
//		 $('#gmenubar').gmenubar(gemnubarCfg);
//		 
//		 var _self = this;
//		 
//	     $.ajax({
//	          "dataType": 'json',
//	          "type": "GET",
//	          "url": org.r3.PageManager.getRESTUrl('GET_UserAndApp_ActorGroups'),
//	          "success": function(data, textStatus, jqXHR)
//	          {
//	        	  if (data.aaData && data.aaData.length)
//	        	  {
//	        		   var groupItems = [];
//	        		   for(var i = 0; i < data.aaData.length; i++)
//	        		   {
//	        			   if (data.aaData[i].groupprofile &&  data.aaData[i].groupprofile.indexOf('gmenubar') >= 0)
//	        			   {
//		        			   groupItems.push({
//		   	       				id : data.aaData[i].groupid,
//			       				title : data.aaData[i].grouptitle,
//			       				onClick : $.r3Utils.hitch(_self, _self._onGMenuBarClick),
//			       				deletable: data.aaData[i].groupprofile &&  data.aaData[i].groupprofile.indexOf('deletable') >= 0	        				   
//		        			   }); 
//        				   }
//        			   }	        		   			    
//	        		   
//	 	        	   $('#gmenubar').gmenubar('addItems2Section', 'gmenubar_sect_quickgroupmenu', groupItems);
//	        	  }
//	        	  
//	          },
//	          "error": function (xhr, error, thrown)
//	          {
//	            if ( error == "parsererror" ) {
//	              alert( "DataTables warning: JSON data from server could not be parsed. "+
//	                "This is caused by a JSON formatting error." );
//	            }
//	          }
//	   });
//	 },
	 
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
		    	
		     case 'act_importcontacts':
		    	 this.openFileImportQueryActionFormPanel();
		    	 break;
		    	 
		     case 'act_exportcontacts':
		    	 this.openExportContactsPanel();
		    	 break;
		    	 
		     case 'act_importchildsitecontacts':
		    	 this.openImportContactsFromChildSitePanel();
		    	 break;
		    	 
		     case 'act_query_groups':
		    	 this.openActorGroupQueryPanel();
		    	 break;
		    	 
		     case 'act_newgroup':		    	 
		    	 this.openNewActorGroupPanel();
		    	 break;
		    	
		     case 'act_newsms':
		    	 this.openNewSMSPanel();
		    	 break;
		    	 
		     case 'act_querysms':
		    	 this.openSMSQueryActionFormPanel();
		    	 break;
		    	 
		     case 'act_querymail':
		    	 this.openMailQueryActionFormPanel();
		    	 break;
		    	 
		     case 'act_newoutmail':
		    	 this.openNewBulkMailPanel();
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

	 openUploadFilesPanel : function()
	 {
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Caricamento File Contatti",
			"actionForm" : this.uploadFileActionForm
		});

		this.uploadFileActionForm.open({
			 "uploadfile_resturl": org.r3.PageManager.getRESTUrl('POST_Upload_Actor_Files'), 
			 "uploadfile_resturl_ie": org.r3.PageManager.getRESTUrl('POST_Upload_Actor_Files_IE'),
			 "fileTypes": [ "csv", "txt" ],
			 "formfragment": org.r3.Constants.applicationContext + '/org/r3/console/contacts/UploadFileExtensionActionForm.html.jsp'
		 });
	},
	
	 openExportContactsPanel : function()
	 {
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Esporta Contatti",
			"actionForm" : this.exportContactsActionForm
		});

		this.exportContactsActionForm.open();
	},

	openImportContactsFromChildSitePanel: function()
	{
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Contatti da Sito",
			"actionForm" : this.importActorsFromChildSiteActionForm
		});

		this.importActorsFromChildSiteActionForm.open();		
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
    
	 openNewSMSPanel : function()
	 {
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Nuovo SMS",
			"actionForm" : this.smsDetailActionForm
		});

		this.smsDetailActionForm.open();
	},
	
	closeNewSMSPanel : function()
    {
   	     org.r3.PageManager.closeAllBreadCrumbs();
	     this.openSMSQueryActionFormPanel();
    },
	
	 openSMSQueryActionFormPanel : function()
	 {		 
		 org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Elenco SMS",
			"actionForm" : this.smsQueryActionForm
		});
		 
		 this.smsQueryActionForm.open();
		 $('#gsidebar-navanchor').gsidebar('select', 'act_querysms');		 
	 },
	 
	 openMailQueryActionFormPanel: function()
	 {		 
		 org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.console.contacts.message.gmenubar_act_querymail_caption,
			"actionForm" : this.mailQueryActionForm
		});
		 
		 this.mailQueryActionForm.open();
		 $('#gsidebar-navanchor').gsidebar('select', 'act_querymail');		 
	 },
	 
	 openMailDetailPanel : function(aMailDataBean)
	 {
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.console.contacts.message.gmenubar_act_sentmaildetail_caption,
			"actionForm" : this.sentMailDetailActionForm
		});

		this.sentMailDetailActionForm.open(aMailDataBean);
	},
	
	 openFileImportQueryActionFormPanel: function()
	 {
		 org.r3.PageManager.pushBreadCrumb(
		 {
			"title" : "Elenco File Caricati",
			"actionForm" : this.fileImportQueryActionForm
		 });
		 
		 this.fileImportQueryActionForm.open();
		 $('#gsidebar-navanchor').gsidebar('select', 'act_importcontacts');		 		 
	 },
	 
	 openFileImportDetailPanel: function(fileImportDTOAdapter)
	 {
		 org.r3.PageManager.pushBreadCrumb(
		 {
			"title" : "Importazione File",
			"actionForm" : this.fileImportDetailActionForm
		 });
		 
		 this.fileImportDetailActionForm.open(fileImportDTOAdapter);		 		 
	 },
	 
	 openNewBulkMailPanel : function()
	 {
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Bulk Mail",
			"actionForm" : this.outMailMessageActionForm
		});

		this.outMailMessageActionForm.open();
	},
	
	closeNewBulkMailPanel : function()
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
    },
    
    openLogInUserPicker: function(srcPickerWidget)
    {
    	org.r3.PageManager.pushBreadCrumb(
        {
             "title" : "Selezione Log-In",
             "actionForm" : this.userPickerActionForm
        });

        this.userPickerActionForm.open({               
              pickerWidget: srcPickerWidget,
              queryUrl: "GET_Users_WithoutLoginContact"
        });
    },
    
	openUserDetailPanel : function(userDataBean)
	{
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Det. Utenza",
			"actionForm" : this.userDetailActionForm
		});

		var dataBeanInfo =
		{
			"userDataBean" : userDataBean
		};

		this.userDetailActionForm.open(dataBeanInfo);
	}

	
};
