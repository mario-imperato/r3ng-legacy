$.r3Utils.namespace("org.r3.console.sev.ranking");

org.r3.console.sev.ranking.PageManager = 
{
  	
	 init: function()
	 {
		 this.rankingQueryActionForm = new org.r3.console.sev.ranking.RankingQueryActionForm(this, "#rankingQueryActionForm");		 
		 this.rankingDetailActionForm = new org.r3.console.sev.ranking.RankingDetailActionForm(this, "#ranking-detail-canvas", "#rankingDetailActionForm", "#rankingInstancesQueryActionForm" );
		 this.rankingInstanceDetailActionForm = new org.r3.console.sev.ranking.RankingInstanceDetailActionForm(this, "#rankingInstanceDetailActionForm" );
		 this.rankingSynopticActionForm = new org.r3.jsportlet.sev.rankingview.RankingSynopticActionForm(this, "#rankingSynopticActionForm" );
		 this.rankingInstanceViewerCyFileActionForm = new org.r3.jsportlet.sev.rankingview.RankingInstanceViewerCyFileActionForm(this, '#rankingInstanceViewerActionForm');
		 
		 this.rankingInstanceViewerActionForm = new org.r3.jsportlet.sev.rankingview.RankingInstanceViewerActionForm(this, '#rankingInstanceViewerActionForm', '#rankingInstanceViewerActionForm_Entries', true);
		 
		 this.classifierActionForm = new org.r3.jsportlet.classifier.ClassifierActionForm(this, '#classifierActionForm', '#classifierItemActionForm', '#classifierItemDetailActionForm', '#classifierItemListActionForm');
		 this.uploadFileActionForm = new org.r3.jsportlet.fileupload.UploadFileActionForm(this, "#uploadFileActionForm");
		 
		 this.createGSideBar();
		 org.r3.PageManager.pushHomeConsoleBreadCrumb();
		 this.openRankingsQueryActionFormPanel();
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
			    id : 'gmenubar_act_uploadfiles',
				title : "Carica File",
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				selected: true
		 });	
		 
		 sect1.items.push({			    
				id : 'act_queryrankings',
				title : "Lista Classifiche...",
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				selected: true
		 });	 
		 
		 sect1.items.push({			    
				id : 'act_newranking',
				title : "Nuova Classifica...",
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false
		 });	 

		 sect1.items.push({			    
				id : 'act_synoptic',
				title : "Quadro Riassuntivo...",
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false
		 });	 
		 
		 sect1.items.push({
			id : 'r3ea_sinott',
			title : "Gruppi Quadro Sinottico",
			onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
			deletable : false,
			selected : false
		});	
		 
		 $('#gsidebar-navanchor').gsidebar(gsidebarCfg);		 
	 },
	 
	 _onGMenuBarClick: function(e, actionTriggered)
	 {
         console.info("_itsbeenclicked", e);	
         if (e.id == 'gmenubar_act_uploadfiles')
         {
        	 org.r3.PageManager.closeAllBreadCrumbs();
        	 $('#gsidebar-navanchor').gsidebar('select', e.id);
        	 
        	 this.openUploadFilesPanel();
             return ;        	 
         }
	     
	     if (e.selected)
	     {
    		 // Se e' selezionato allora vuol dire che nella history dei breadcrumb e' in posizione 1 visto che in posizione 0 ci sta la home console.	    	 
	    	 org.r3.PageManager.activateFirstBreadCrumb(); 
	     }
	     else 
	     {
	    	 $('#gsidebar-navanchor').gsidebar('select', e.id);
	    	 org.r3.PageManager.closeAllBreadCrumbs();
	    	 
	    	 switch(e.id)
		     {
		     case 'act_queryrankings':
		    	 this.openRankingsQueryActionFormPanel();
		    	 break;
		    	 
		     case 'act_newranking':		    	 
		    	 this.openNewRankingPanel();
		    	 break;

		     case 'act_synoptic':
		    	 this.openSynopticPanel();
		    	 break;
		    	 
		     case 'r3ea_sinott':
		    	 this.openClassifierActionForm(e.id, 'r3ea_sinott');
		    	 break;
		    	 
		     default:
	    	     break;
		    	 
		     }
   		 }
	 },

	 openUploadFilesPanel : function()
	 {
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Caricamento File Classifiche",
			"actionForm" : this.uploadFileActionForm
		});

		this.uploadFileActionForm.open({
			 "uploadfile_resturl": org.r3.PageManager.getRESTUrl('POST_Upload_CyberAltura_Files'), 
			 "uploadfile_resturl_ie": org.r3.PageManager.getRESTUrl('POST_Upload_CyberAltura_Files_IE'),
			 "fileTypes": [ "html", "htm" ]			 
		 });
	},

	 openRankingsQueryActionFormPanel : function()
	 {		 
		 org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Elenco Classifiche",
			"actionForm" : this.rankingQueryActionForm
		});
		 
		 this.rankingQueryActionForm.open();
		 $('#gsidebar-navanchor').gsidebar('select', 'act_queryrankings');		 
	 },

	 openRankingDetailPanel : function(rankingDataBean)
	 {
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Det. Classifica",
			"actionForm" : this.rankingDetailActionForm
		});

		this.rankingDetailActionForm.open(rankingDataBean.dataBean.rankid);
	},
	
	openSynopticPanel: function()
	{
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Quadro Sinottico",
			"actionForm" : this.rankingSynopticActionForm
		});

		this.rankingSynopticActionForm.open();		
	},
	
	openRankingInstanceViewer: function(aRankingInstanceViewDTOAdapter)
	{
		var act = this.rankingInstanceViewerCyFileActionForm;
		var title = "Dettaglio Classifica Prova";
		if (aRankingInstanceViewDTOAdapter.isRankType('rank_filedet'))
		{
			act = this.rankingInstanceViewerActionForm;
			title = "Dettaglio Classifica Prova (FD)";
		}
		
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : title,
			"actionForm" : act
		});

		act.open(aRankingInstanceViewDTOAdapter);		
	},
	
	 openNewRankingPanel : function()
	 {
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Nuova Classifica",
			"actionForm" : this.rankingDetailActionForm
		});

		this.rankingDetailActionForm.open();
	},

	closeNewRankingPanel : function()
    {
   	     org.r3.PageManager.closeAllBreadCrumbs();
	     this.openRankingsQueryActionFormPanel();
    },
    
	onRankingUpdate: function(aRankingDTOAdapter)
	{		   
   	   // $('#gsidebar-navanchor').gsidebar('updateItemTitle', anActorGroupDTOAdapter.dataBean.groupid, anActorGroupDTOAdapter.dataBean.grouptitle);	
	},

	onRankingCreate: function(aRankingDTOAdapter)
	{		   
//   	   groupItems = [{
// 				id : anActorGroupDTOAdapter.dataBean.groupid,
//				title : anActorGroupDTOAdapter.dataBean.grouptitle,
//				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
//				deletable: true	        				   
//		   }];        		   			    
//	   
//	   $('#gsidebar-navanchor').gsidebar('addItems2Section', 'gmenubar_sect_usergroups', groupItems);   
	   this.closeNewRankingPanel(aRankingDTOAdapter);
	},

	instanceDetail: function(aRankingInstanceDTOAdapter)
	{
		this.openRankingInstanceViewer(aRankingInstanceDTOAdapter);
		
//		org.r3.PageManager.pushBreadCrumb(
//		{
//			"title" : "Visualizza Classifica",
//			"actionForm" : this.rankingInstanceDetailActionForm
//		});
//
//		this.rankingInstanceDetailActionForm.open(aRankingInstanceDTOAdapter);		
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
	 }
};

