$.r3Utils.namespace("org.r3.console.siteconfig");

org.r3.console.siteconfig.PageManager = 
{
  	
	 init: function()
	 {	
		 this.homePortletCfgActionForm = new org.r3.console.siteconfig.HomePortletCfgActionForm(this, '#homePortletCfgActionForm');
		 this.sitePropertyConfigActionForm = new org.r3.console.siteconfig.SitePropertyActionForm(this, '#sitePropertiesActionForm');
		 this.classifierActionForm = new org.r3.jsportlet.classifier.ClassifierActionForm(this, '#classifierActionForm', '#classifierItemActionForm', '#classifierItemDetailActionForm', '#classifierItemListActionForm');
		 this.calendarActionForm = new org.r3.console.siteconfig.calendar.CalendarActionForm(this, '#calendarDetailActionForm', '#calendarListActionForm');
		 
 		 this.siteDetailActionForm = new org.r3.console.siteconfig.site.SiteDetailActionForm(this, '#siteDetailActionForm');
		 this.uploadAssetFileActionForm = new org.r3.console.siteconfig.site.UploadFileActionForm(this, '#uploadFileActionForm');
		 		 
		 this.pageQueryActionForm = new org.r3.console.siteconfig.page.PageQueryActionForm(this, '#pageQueryActionForm',
			              '#pageQueryAdvancedSearchActionForm');
	     this.pageDetailActionForm = new org.r3.console.siteconfig.page.PageDetailActionForm(this, '#pageDetailActionForm');
	
	     // PageManager dependency
	  	 // this.cardQueryActionForm = new org.r3.jsportlet.cmsconsole.CardQueryActionForm(this, '#cardQueryActionForm', '#cardQueryAdvancedSearchActionForm');
		 this.cardDetailActionForm = new org.r3.jsportlet.cmsconsole.CardDetailActionForm(this, '#cardDetailActionForm');
		 this.uploadFileActionForm = new org.r3.jsportlet.cmsconsole.UploadFileActionForm(this, '#uploadFileActionForm');
		 this.cardPickerActionForm = new org.r3.jsportlet.cmsconsole.CardPickerActionForm(this, '#cardQueryActionForm', '#cardQueryAdvancedSearchActionForm');
		 
		 this.createGSideBar();
		 org.r3.PageManager.pushHomeConsoleBreadCrumb();
		 this.openSitePropertiesConfigPanel();
	 },
	 
	 createGSideBar: function()
	 {
		 var targetSiteType = org.r3.SiteConstants.targetSiteType;
		 
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
			    id : 'gmenubar_act_site',
				title : org.r3.console.siteconfig.message.gmenubar_act_site,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				selected: true,
				icon: 'building'
		 });
		 
		 sect1.items.push({			    
				id : 'act_properties',
				title : org.r3.console.siteconfig.message.gmenubar_act_properties,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				selected: true,
				icon: 'cog'
		 });
		 
		 
		 if (targetSiteType == 'regatta' || targetSiteType == 'workshop')
		 {
			 sect1.items.push({			    
					id : 'act_homeportlets',
					title : org.r3.console.siteconfig.message.gmenubar_act_homeportlets,
					onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
					deletable: false,
					selected: false,
					icon: 'desktop'
			 });	 			 		
		 }
		 
		 var sectpages = {
	   		        type: 'section',			    
					id : 'gmenubar_sect_pages',
					bottom_border: true,
					items: []
		 };		 
		 gsidebarCfg.sections.push(sectpages);	
		 
		 sectpages.items.push({
			    id : 'act_newpage',
				title : org.r3.console.siteconfig.message.gmenubar_act_newpage,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable : false,
				selected : false,
				icon: 'file'
		 });	

		 sectpages.items.push(
		 {
			id : 'act_querypages',
			title : org.r3.console.siteconfig.message.gmenubar_act_querypages,
			onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
			deletable : false,
			selected : false,
			icon: 'table'
		 });
		
		 var sect3 = {
	   		        type: 'section',			    
					id : 'gmenubar_sect_3',
					bottom_border: true,
					items: []
		 };		 
		 gsidebarCfg.sections.push(sect3);	

		 if (targetSiteType == 'regatta')
		 {
		 sect3.items.push({
			id : 'act_calendar',
			title : org.r3.console.siteconfig.message.gmenubar_act_calendar,
			onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
			deletable : false,
			selected : false,
			icon: 'calendar'
		 });	
		 }		 		 
		 
		 var sect2 = {
	   		        type: 'section',
	   		        title: org.r3.console.siteconfig.message.gmenubar_act_classifiers,
					id : 'gmenubar_sect_classifiers',
					bottom_border: true,
					items: [],
					grouped: true,
					icon: 'bars'
		 };		 
		 gsidebarCfg.sections.push(sect2);	 

		 $('#gsidebar-navanchor').gsidebar(gsidebarCfg);	

         var _self = this;
		 
	     $.ajax({
	          "dataType": 'json',
	          "type": "GET",
	          "url": org.r3.PageManager.getRESTUrl('LUT_classifiers'),
	          "success": function(data, textStatus, jqXHR)
	          {
	        	  if (data.aaData && data.aaData.length)
	        	  {
	        		   var classifierItems = [];
	        		   for(var i = 0; i < data.aaData.length; i++)
	        		   {
	        			   classifierItems.push({
	   	       				id : data.aaData[i].clsid,
		       				title : data.aaData[i].clsdescr,
		       				onClick : $.r3Utils.hitch(_self, _self._onGMenuBarClick),
		       				deletable: true	        				   
	        			   }); 
	        		   }	        		   			    
	        		   
	 	        	   $('#gsidebar-navanchor').gsidebar('addItems2Section', 'gmenubar_sect_classifiers', classifierItems);
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
         if (e.id == 'gmenubar_act_site')
         {
        	 org.r3.PageManager.closeAllBreadCrumbs();
        	 $('#gsidebar-navanchor').gsidebar('select', e.id);
        	 
        	 this.openSiteConfigPanel();
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
	    	 case 'act_properties':
		    	 this.openSitePropertiesConfigPanel();
		    	 break;
	    		 
		     case 'act_homeportlets':
		    	 this.openHomePortletConfigPanel();
		    	 break;
		    
		     case 'act_calendar':
		    	 this.openCalendarPanel();
		    	 break;

		     case 'act_newpage':
		    	 this.openNewPagePanel();
		    	 break;
		    	 
		     case 'act_querypages':
		    	 this.openPageQueryActionFormPanel();
		    	 break;
		    	 
		     default:
		    	 // Should some default action Present.
		    	 // this.openActorGroupDetailPanel(e.id);
		    	 this.openClassifierActionForm(e.id, e.id);
	    	     break;
		    	 
		     }
   		 }
	     }
	 },
	 
	 openSiteConfigPanel: function()
	 {
		 org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.console.siteconfig.message.breadcrumb_general,
			"actionForm" : this.siteDetailActionForm
		});
		 
		 this.siteDetailActionForm.open();		 
	 },
	 
	 openSitePropertiesConfigPanel: function()
	 {		 
		 org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.console.siteconfig.message.breadcrumb_properties,
			"actionForm" : this.sitePropertyConfigActionForm
		});
		 
		 this.sitePropertyConfigActionForm.open();
		 $('#gsidebar-navanchor').gsidebar('select', 'act_properties');		 
	 },
	 
	 openHomePortletConfigPanel: function()
	 {		 
		 org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.console.siteconfig.message.breadcrumb_homeportlet,
			"actionForm" : this.homePortletCfgActionForm
		});
		 
		 this.homePortletCfgActionForm.open();
		 $('#gsidebar-navanchor').gsidebar('select', 'act_homeportlets');		 
	 },
	 
	 openCalendarPanel: function()
	 {
		 org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.console.siteconfig.message.breadcrumb_calendar,
			"actionForm" : this.calendarActionForm
		});
		 
		 this.calendarActionForm.open();
		 $('#gsidebar-navanchor').gsidebar('select', 'act_calendar');	
	 },

     openCardPicker: function(srcPickerWidget)
     {
    	org.r3.PageManager.pushBreadCrumb(
        {
             "title" : "Selezione Card",
             "actionForm" : this.cardPickerActionForm
        });

        this.cardPickerActionForm.open({               
              pickerWidget: srcPickerWidget              
        });
     },
	    
//	 openWBSPanel: function()
//	 {
//		 org.r3.PageManager.pushBreadCrumb(
//		{
//			"title" : "WBS",
//			"actionForm" : this.wbsActionForm
//		});
//		 
//		 this.wbsActionForm.open();
//		 $('#gsidebar-navanchor').gsidebar('select', 'act_wbs');	
//	 },
//
//	 closeWBSPanel: function()
//	 {
//   	     org.r3.PageManager.closeAllBreadCrumbs();
//	     this.openWBSQueryActionFormPanel();
//	 },
//	 
//	 openWBSQueryActionFormPanel : function()
//	 {		 
//		 org.r3.PageManager.pushBreadCrumb(
//		{
//			"title" : "Elenco WBS",
//			"actionForm" : this.wbsQueryActionForm
//		});
//		 
//		 this.wbsQueryActionForm.open();
//		 $('#gsidebar-navanchor').gsidebar('select', 'act_querywbs');		 
//	 },
	 
	 openClassifierActionForm: function(manubarid, clsId)
	 {
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.console.siteconfig.message.breadcrumb_classifiers,
			"actionForm" : this.classifierActionForm
		});
		 
		this.classifierActionForm.open(clsId);
		$('#gsidebar-navanchor').gsidebar('select', manubarid);		 		 
	 },
	 
	 uploadSiteAssetFile : function(aCardId)
	 {
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.console.siteconfig.message.breadcrumb_fileupload,
			"actionForm" : this.uploadAssetFileActionForm
		});

		this.uploadAssetFileActionForm.open(aCardId);
	 },
	 
	openPageQueryActionFormPanel : function()
	{
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.console.siteconfig.message.breadcrumb_pages,
			"actionForm" : this.pageQueryActionForm
		});

		this.pageQueryActionForm.open();
		$('#gsidebar-navanchor').gsidebar('select', 'act_querypages');
	},

	openNewPagePanel : function()
	{
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.console.siteconfig.message.breadcrumb_newpage,
			"actionForm" : this.pageDetailActionForm
		});
		this.pageDetailActionForm.open(null);
	},

	closeNewPagePanel : function()
    {
   	     org.r3.PageManager.closeAllBreadCrumbs();
	     this.openPageQueryActionFormPanel();
    },	
	
	openDetailPagePanel : function(pageDataBean)
	{
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.console.siteconfig.message.breadcrumb_pagedetail,
			"actionForm" : this.pageDetailActionForm
		});

		var dataBeanInfo =
		{
			"pageDataBean" : pageDataBean
		};

		this.pageDetailActionForm.open(pageDataBean);
	},
	
	openCardDetailPanel : function(cardDataBean)
	{
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.jsportlet.cmsconsole.message.breadcrumb_carddetail,
			"actionForm" : this.cardDetailActionForm
		});

		var dataBeanInfo =
		{
			"cardDataBean" : cardDataBean
		};

		this.cardDetailActionForm.open(cardDataBean);
	},

	uploadFile : function(cardDTOAdapter)
	{
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.jsportlet.cmsconsole.message.breadcrumb_fileupload,
			"actionForm" : this.uploadFileActionForm
		});

		this.uploadFileActionForm.open(cardDTOAdapter);
	}
	 
	
};

