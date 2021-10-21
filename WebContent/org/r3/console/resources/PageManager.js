$.r3Utils.namespace("org.r3.console.resources");

org.r3.console.resources.PageManager = 
{
  	
	 init: function()
	 {
		 this.teamQueryActionForm = new org.r3.jsportlet.project.team.TeamQueryActionForm(this, "#teamQueryActionForm");		 
		 this.teamDetailActionForm = new org.r3.jsportlet.project.team.TeamDetailActionForm(this, "#teamDetailActionForm", "#teamDetailActionFormView_tab_generale");
		 		 
		 this.resourceQueryActionForm = new org.r3.jsportlet.project.resource.ResourceQueryActionForm(this, "#resourceQueryActionForm");		 
		 this.resourceDetailActionForm = new org.r3.jsportlet.project.resource.ResourceDetailActionForm(this, "#resourceDetailActionForm", "#resourceDetailActionFormView_tab_generale");
		 		 
		 this.userPickerActionForm = new org.r3.jsportlet.user.UserPickerActionForm(this, '#userPickerActionForm', '#userPickerAdvancedSearchActionForm');
		 this.userDetailActionForm = new org.r3.jsportlet.user.UserDetailActionForm(this, '#userDetailActionForm');
		 
		 this.teamMembersActionForm = new org.r3.jsportlet.teammemberprofile.TeamMemberProfileActionForm(this, '#teamMemberProfileDetailActionForm', '#teamMemberProfileQueryActionForm');					 
		 this.classifierActionForm = new org.r3.jsportlet.classifier.ClassifierActionForm(this, '#classifierActionForm', '#classifierItemActionForm', '#classifierItemDetailActionForm', '#classifierItemListActionForm');

		 this.teamtimesheetQueryActionForm = new org.r3.jsportlet.project.teamtimesheet.TeamTimesheetActionForm(this, "#teamtmesheetQueryActionForm");		 
		 
		 this.teamtimesheetReportActionForm = new org.r3.jsportlet.project.teamtimesheetreport.TeamTimesheetReportActionForm(this, "#teamtmesheetReportActionForm", "#teamTimesheetReportDatatableActionForm");		 
		 this.teamtimesheetPrintableReportActionForm = new org.r3.jsportlet.project.teamtimesheetreport.TeamTimesheetPrintableReportActionForm(this, "#canvas_report_content");
		 
		 // this.createGMenuBar();
		 this.createGSideBar();
		 org.r3.PageManager.pushHomeConsoleBreadCrumb();
		 this.openResourceQueryActionFormPanel();
		 
//		 $('#do-toggle').unbind().click(function (e) {
//			 $('.gsidebar-nav').addClass('hoverenabled');
//		 });
//		 
//		 $('#do-untoggle').unbind().click(function (e) {
//			 $('.gsidebar-nav').removeClass('hoverenabled');
//		 });


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
				id : 'act_queryresources',
				title : org.r3.console.resources.message.gmenubar_act_querycontacts_caption,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				selected: true,
				icon: 'users'
		 });	 
		 
		 sect1.items.push({			    
				id : 'act_queryteams',
				title : org.r3.console.resources.message.gmenubar_act_queryteams_caption,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				selected: true,
				icon: 'users'
		 });	

		 sect1.items.push({			    
				id : 'act_teamtimesheet',
				title : org.r3.console.resources.message.gmenubar_act_teamtimesheet_caption,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				selected: true,
				icon: 'users'
		 });			 

		 sect1.items.push({			    
				id : 'act_teamtimesheetreport',
				title : org.r3.console.resources.message.gmenubar_act_teamtimesheetreport_caption,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				selected: true,
				icon: 'users'
		 });			 
		 
		 sect1.items.push({
				id : 'act_query_teammembers',
				title : org.r3.console.resources.message.act_query_teammembers,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable : false,
				selected : false,
				icon: 'users'
		 });
		 
		 sect1.items.push({
				id : 'skillprofile',
				title : "Profili Professionali",
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable : false,
				selected : false,
				icon: 'circle-o'
		 });	
		 
		 sect1.items.push({
				id : 'skillambit',
				title : "Figure Professionali",
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable : false,
				selected : false,
				icon: 'circle-o'
		 });	
		 
		 $('#gsidebar-navanchor').gsidebar(gsidebarCfg);
		 
	 },
	 
	 _onGMenuBarClick: function(e, actionTriggered)
	 {
         console.info("_itsbeenclicked", e);	
         if (e.id == 'gmenubar_act_newresource')
         {
        	 org.r3.PageManager.closeAllBreadCrumbs();
        	 $('#gsidebar-navanchor').gsidebar('select', e.id);
        	 
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
		     case 'act_queryresources':
		    	 this.openResourceQueryActionFormPanel();
		    	 break;

		     case 'act_queryteams':
		    	 this.openTeamQueryActionFormPanel();
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
		    	 
		     case 'act_newoutmail':
		    	 this.openNewBulkMailPanel();
		    	 break;
		    	 
		     case 'skillprofile':
		    	 this.openClassifierActionForm(e.id, 'skillprofile');
		    	 break;
		    	 
		     case 'skillambit':
		    	 this.openClassifierActionForm(e.id, 'skillambit');
		    	 break;
		    	 
		     case 'act_query_teammembers':
		    	 this.openTeamMemberQueryActionFormPanel();
		    	 break;
		    	 
		     case 'act_teamtimesheet':
		    	 this.openTeamTimesheetQueryActionFormPanel();
		    	 break;
		    	 
		     case 'act_teamtimesheetreport':
		    	 this.openTeamTimesheetReportActionFormPanel();
		    	 break;
		    	 
		     default:
		    	 this.openActorGroupDetailPanel(e.id);
	    	     break;
		    	 
		     }
   		 }
	     }
	 },
	 
	 openResourceQueryActionFormPanel : function()
	 {		 
		 org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Elenco Risorse",
			"actionForm" : this.resourceQueryActionForm
		});
		 
		 this.resourceQueryActionForm.open();
		 $('#gsidebar-navanchor').gsidebar('select', 'act_queryresources');		 
	 },	
	 
	 openResourceDetailPanel : function(aResourceSiteViewDTOAdapter, anOpenOptionsHash)
	 {
		var openOptions = $.extend({ "traverseRelationship": true, "actions" : 'all' }, anOpenOptionsHash);
		 
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Det. Risorsa",
			"actionForm" : this.resourceDetailActionForm
		});

		this.resourceDetailActionForm.open(aResourceSiteViewDTOAdapter, openOptions);
	},
	
	 openNewResourcePanel : function()
	 {
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Nuova Risorsa",
			"actionForm" : this.resourceDetailActionForm
		});

		this.resourceDetailActionForm.open();
	},

	closeNewResourcePanel : function()
    {
   	     org.r3.PageManager.closeAllBreadCrumbs();
	     this.openResourceQueryActionFormPanel();
    },
    
    openTeamQueryActionFormPanel: function()
	 {		 
		 org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Elenco Team",
			"actionForm" : this.teamQueryActionForm
		});
		 
		 this.teamQueryActionForm.open();
		 $('#gsidebar-navanchor').gsidebar('select', 'act_queryteams');		 
	 },
	 
	 openNewTeamPanel : function()
	 {
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Nuovo Team",
			"actionForm" : this.teamDetailActionForm
		});

		this.teamDetailActionForm.open();
	},

	closeNewTeamPanel : function()
    {
   	     org.r3.PageManager.closeAllBreadCrumbs();
	     this.openTeamQueryActionFormPanel();
    },
    
	 openTeamDetailPanel : function(aTeamDTOAdapter, anOpenOptionsHash)
	 {
		var openOptions = $.extend({ "traverseRelationship": true,  "actions" : 'all' }, anOpenOptionsHash);
					 
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Det. Team",
			"actionForm" : this.teamDetailActionForm
		});

		this.teamDetailActionForm.open(aTeamDTOAdapter, openOptions);
	},
	
	 openClassifierActionForm: function(manubarid, clsId)
	 {
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Classificatori",
			"actionForm" : this.classifierActionForm
		});
		 
		this.classifierActionForm.open(clsId);
		$('#gsidebar-navanchor').gsidebar('select', manubarid);		 		 
	 },
    
	 openTeamTimesheetQueryActionFormPanel: function()
	 {		 
		 org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Consuntivazione",
			"actionForm" : this.teamtimesheetQueryActionForm
		});
		 
		this.teamtimesheetQueryActionForm.open();
		$('#gsidebar-navanchor').gsidebar('select', 'act_teamtimesheet');		 
	},
    
    openTeamTimesheetReportActionFormPanel: function()
	{		 
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Report Consuntivazione",
			"actionForm" : this.teamtimesheetReportActionForm
		});
		 
		this.teamtimesheetReportActionForm.open();
		$('#gsidebar-navanchor').gsidebar('select', 'act_teamtimesheetreport');		 
	},
			 
	openTeamTimesheetReportPrintableActionFormPanel: function(aReportType, queryParameters)
	{
		 org.r3.PageManager.openFullScreenLayout(this.teamtimesheetPrintableReportActionForm);
	     this.teamtimesheetPrintableReportActionForm.open(aReportType, queryParameters);
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
	},
	
	 openTeamMemberQueryActionFormPanel: function()
	 {
		 org.r3.PageManager.pushBreadCrumb(
		 {
			"title" : org.r3.console.resources.message.list_of_teammembers_breadcrumb,
			"actionForm" : this.teamMembersActionForm
		 });
		 
		 this.teamMembersActionForm.open(org.r3.Constants.site);
		 $('#gsidebar-navanchor').gsidebar('select', 'act_query_teammembers');		 
		 
	 }

	
};
