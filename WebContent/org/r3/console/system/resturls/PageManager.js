$.r3Utils.namespace("org.r3.console.system.resturls");

org.r3.console.system.resturls.PageManager = 
{
  	
	 init: function()
	 {
//		 $('#mngmt_processmailqueue').click($.r3Utils.hitch(this, this.mngmt_processmailqueue));
//		 $('#mngmt_processfivcardqueue').click($.r3Utils.hitch(this, this.mngmt_processfivcardqueue));        
//		 $('#mngmt_processfivcardqueuer').click($.r3Utils.hitch(this, this.mngmt_processfivcardqueuer));
//		 $('#mngmt_processeventqueue').click($.r3Utils.hitch(this, this.mngmt_processeventqueue));
//		 $('#mngmt_lutinvalidate').click($.r3Utils.hitch(this, this.mngmt_lutinvalidate));
//		 $('#mngmt_lutreload').click($.r3Utils.hitch(this, this.mngmt_lutreload));
//		 $('#mngmt_initcalendar').click($.r3Utils.hitch(this, this.mngmt_initcalendar));
		 
		 this.simpleUrlInvokationActionForm = new org.r3.console.system.resturls.SimpleURLInvokationActionForm(this, '#pageWorkCanvas');	
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
			 id : 'act_initcalendar',
				title : org.r3.console.system.resturls.message.gmenubar_act_initcalendar_caption,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				selected: false,
				icon: 'user-plus'
		 });

		 sect1.items.push({			    
			 id : 'act_processmailqueue',
				title : org.r3.console.system.resturls.message.gmenubar_act_processmailqueue_caption,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				selected: false,
				icon: 'user-plus'
		 });

		 sect1.items.push({			    
			 id : 'act_processfivcardqueue',
				title : org.r3.console.system.resturls.message.gmenubar_act_processfivcardqueue_caption,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				selected: false,
				icon: 'user-plus'
		 });
    	 
		 sect1.items.push({			    
			 id : 'act_processfivcardqueuer',
				title : org.r3.console.system.resturls.message.gmenubar_act_processfivcardqueuer_caption,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				selected: false,
				icon: 'user-plus'
		 });

		 sect1.items.push({			    
			 id : 'act_processeventqueue',
				title : org.r3.console.system.resturls.message.gmenubar_act_processeventqueue_caption,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				selected: false,
				icon: 'user-plus'
		 });

		 sect1.items.push({			    
			 id : 'act_lutinvalidate',
				title : org.r3.console.system.resturls.message.gmenubar_act_lutinvalidate_caption,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				selected: false,
				icon: 'user-plus'
		 });

		 sect1.items.push({			    
			 id : 'act_lutreload',
				title : org.r3.console.system.resturls.message.gmenubar_act_lutreload_caption,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				selected: false,
				icon: 'user-plus'
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
		     case 'act_initcalendar':
		    	 this.mngmt_initcalendar();
		    	 break;
		    	 
		     case 'act_processmailqueue':
		    	 this.mngmt_processmailqueue();
		    	 break;
		    	 
		     case 'act_processfivcardqueue':
		    	 this.mngmt_processfivcardqueue();
		    	 break;
		    	 
		     case 'act_processfivcardqueuer':
		    	 this.mngmt_processfivcardqueuer();
		    	 break;

		     case 'act_processeventqueue':
		    	 this.mngmt_processeventqueue();
		    	 break;

		     case 'act_lutinvalidate':
		    	 this.mngmt_lutinvalidate();
		    	 break;
		    	 
		     case 'act_lutreload':
		    	 this.mngmt_lutreload();
		    	 break;
		    	 
		     default:
	    	     break;
		    	 
		     }
   		 }
	     }
	 },
	 
	 mngmt_initcalendar: function()
	 {
		 org.r3.PageManager.pushBreadCrumb(
		 {
			"title" : "Rest URLs Methods",
			"actionForm" : this.simpleUrlInvokationActionForm
		 });
		 
		 this.simpleUrlInvokationActionForm.open("POST", org.r3.Constants.applicationContext + "/was/default/it/system/calendar/initialize;calperiod=true;calendarid=default;startdate=20150101;startday=1;length=6575"); 
	 },
	 
	 mngmt_processmailqueue: function()
	 {
		 org.r3.PageManager.pushBreadCrumb(
		 {
			"title" : "Rest URLs Methods",
			"actionForm" : this.simpleUrlInvokationActionForm
		 });
		 
		 this.simpleUrlInvokationActionForm.open("POST", org.r3.Constants.applicationContext + "/was/default/it/system/queues/mailqueue/process");
	 },

	 mngmt_processfivcardqueue: function()
	 {
		 org.r3.PageManager.pushBreadCrumb(
		 {
			"title" : "Rest URLs Methods",
			"actionForm" : this.simpleUrlInvokationActionForm
		 });

		 this.simpleUrlInvokationActionForm.open("POST", org.r3.Constants.applicationContext + "/was/default/it/system/queues/fivcardqueue/process");
	 },

	 mngmt_processfivcardqueuer: function()
	 {
		 org.r3.PageManager.pushBreadCrumb(
		 {
			"title" : "Rest URLs Methods",
			"actionForm" : this.simpleUrlInvokationActionForm
		 });

		 this.simpleUrlInvokationActionForm.open("POST", org.r3.Constants.applicationContext + "/was/default/it/system/script/execute/RetryQueueSQLScript");
	 },

	 mngmt_processeventqueue: function()
	 {
		 org.r3.PageManager.pushBreadCrumb(
		 {
			"title" : "Rest URLs Methods",
			"actionForm" : this.simpleUrlInvokationActionForm
		 });

		 this.simpleUrlInvokationActionForm.open("POST", org.r3.Constants.applicationContext + "/was/default/it/system/queues/eventqueue/process");
	 },
	 
	 mngmt_lutinvalidate: function()
	 {
		 org.r3.PageManager.pushBreadCrumb(
		 {
			"title" : "Rest URLs Methods",
			"actionForm" : this.simpleUrlInvokationActionForm
		 });

		 this.simpleUrlInvokationActionForm.open("POST", org.r3.Constants.applicationContext + "/was/default/it/system/lut/invalidate");		 
	 },
	 
	 mngmt_lutreload: function()
	 {
		 org.r3.PageManager.pushBreadCrumb(
		 {
			"title" : "Rest URLs Methods",
			"actionForm" : this.simpleUrlInvokationActionForm
		 });

		 this.simpleUrlInvokationActionForm.open("POST", org.r3.Constants.applicationContext + "/was/default/it/system/lut/reload");		 
	 }
	 
//	 processEventQueue: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/queues/eventqueue/process");
//	 },
//	 
//	 processQuartz: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/processes/quartz/tasks");
//	 },
//
//	 processJobs: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/jobs/process");
//	 },
//
//	 initJobs: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/jobs/initialize");
//	 },
//
//	 enqueueEsitiPostalizzazioneQueue: function()
//	 {
//		 // this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/io/esitipostalizzazione");
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/events/qm_processesitipostaliz;idgruppo={0}/enqueue");		 
//	 },
//	 
//	 enqueueEsitiQueue: function()
//	 {
//		 // this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/io/esiti");
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/events/qm_processesiti;idgruppo={0}/enqueue");		 
//	 },
//	 
//	 enqueueEsitiImmaginiQueue: function()
//	 {
//		 // this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/io/esiti_immagini");
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/events/qm_processesitiimg;idgruppo={0}/enqueue");		 
//	 },
//
//	 enqueuePublishingQueue: function()
//	 {
//		 // this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/io/publishing");
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/events/qm_processpublishing;idgruppo={0}/enqueue");		 
//	 },
//
//	 
//	 enqueueJobFatturazione: function()
//	 {
//		 // this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/io/publishing");
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/events/job_fatturazione;idgruppo={0};monthperiodindex={1}/enqueue");		 
//	 },
//	 
//	 // 
//	 enqueueDBCleanUp: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/events/qm_dbcleanupevent/enqueue");
//	 },
//
//	 enqueueDBHourlyCleanUp: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/events/qm_dbhourlycleanupevent/enqueue");
//	 },
//
//	 enqueueDBHCleanUp: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/events/qm_dbhistprocess/enqueue");
//	 },
//
//	 enqueueDBExpCleanUp: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/events/qm_expiredcustomercleanupevent/enqueue");
//	 },
//
//	 enqueueCreateTestPackage: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/events/create_test_package/enqueue;idgruppo={0};numatti={1};numdest={2};numattixpacco={3}");
//	 },
//
//	 listProcessDefinitions: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("GET", "/UNEP/was/processes");
//	 },
//
//	 deployProcess01: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/processes/deploy/resources/activity/UNEP_process.bpmn");
//     },
//
//	 deployProcess02: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/processes/deploy/resources/activity/UNEP_esiti.bpmn");
//     },
//
//	 deleteDeployment: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("DELETE", "/UNEP/was/processes/deploy/{0}");
//	 },
//
//	 listInstances: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("GET", "/UNEP/was/processes/instances");
//	 },
//
//	 deleteInstance: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("DELETE", "/UNEP/was/processes/instances/{0}");
//	 },
//	 
//	 deleteAllInstances: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("DELETE", "/UNEP/was/processes/instances");
//	 },
//
//	 listTasks: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("GET", "/UNEP/was/processes/tasks");
//	 },
//
//	 claimTask: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/processes/tasks/{0}/claim/{1}");
//	 },
//	 
//	 unclaimTask: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/processes/tasks/{0}/unclaim");
//	 },
//
//	 getTaskVariables: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("GET", "/UNEP/was/processes/tasks/{0}/variables");
//	 },
//	 
//	 initializeCalendar: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/calendar/initialize;startdate=20121001;startday=735142;length=7397");		 
//	 },
//	 
//	 executeDBScript01: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/script/execute/ClearWorldCicloAttivoSQLScript");
//	 },
//
//	 executeDBScript02: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/script/execute/ClearWorldCicloEsitiSQLScript");
//	 },
//	 	 
//	 generaCodiceRaccomandata: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("GET", "/UNEP/was/system/codicipostali/raccomandata/generate;seed=0;number=1");
//	 },
//	 
//	 calcolaCodici_23L_daCodiceRaccomandata: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("GET", "/UNEP/was/system/codicipostali/raccomandata/{0}/23L");
//	 },
//
//	 calcolaCodici_ARCad_daCodiceRaccomandata: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("GET", "/UNEP/was/system/codicipostali/raccomandata/{0}/ARCad");
//	 },
//
//	 calcolaCodiceRaccomandataDa23L: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("GET", "/UNEP/was/system/codicipostali/23L/{0}/raccomandata");
//	 },
//
//	 calcolaCodiceRaccomandataDaARCad: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("GET", "/UNEP/was/system/codicipostali/ARCad/{0}/raccomandat");
//	 },
//
//	 generaDirectorygruppoMG: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/io/directory/GRP_MG");
//	 },
//
//	 generaDirectorygruppoAVV: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/io/directory/GRP_AVV");
//	 },
//	 
//	 generaDirectorygruppoPGOLD: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/io/directory/GRP_PGOLD");
//	 },
//
//	 generaDirectorygruppoSINT: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/io/directory/GRP_SINT");
//	 },
//
//	 generaCCatalog: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/io/ccatalog");
//	 },
//	 
//	 lutInvalidate: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/lut/invalidate");		 
//	 },
//	 
//	 lutReload: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("POST", "/UNEP/was/system/lut/reload");		 
//	 },
//	 
//	 mngmt_service_controlroom: function()
//	 {
//		 this.simpleUrlInvokationActionForm.open("GET", "/UNEP/was/system/scr/execute/t1");		 		 
//	 }
	 
};

