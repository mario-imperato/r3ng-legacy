$.r3Utils.namespace("org.r3.shkadmin.cms");

org.r3.shkadmin.cms.PageManager =
{

	init : function()
	{
		this.cardQueryActionForm = new org.r3.jsportlet.mongocms.CardQueryActionForm(this, '#cardQueryActionForm',
				'#cardQueryAdvancedSearchActionForm');
		this.cardDetailActionForm = new org.r3.jsportlet.mongocms.CardDetailActionForm(this, '#cardDetailActionForm');
		
		this.timelineDetailActionForm = new org.r3.jsportlet.mongocms.TimelineDetailActionForm(this, '#timelineDetailActionForm');
		this.timelineQueryActionForm = new org.r3.jsportlet.mongocms.TimelineQueryActionForm(this, '#timelineQueryActionForm');
		this.uploadFileActionForm = new org.r3.jsportlet.fileupload.UploadFileActionForm(this, "#uploadFileActionForm");
				
		this.createGSideBar();
		org.r3.PageManager.pushHomeBreadCrumb();
	    org.r3.PageManager.pushBreadCrumb(this.getHomeBreadCrumb());
		 
		this.openCMSCardQueryActionFormPanel();
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
			
	createGSideBar : function()
	{
		var gsidebarCfg =
		{};
		gsidebarCfg.sections = [];

		var sect1 =
		{
			type : 'section',
			id : 'gmenubar_sect_action',
			bottom_border : true,
			items : []
		};
		gsidebarCfg.sections.push(sect1);

		sect1.items.push(
		{
			id : 'gmenubar_act_newcard',
			title : org.r3.shkadmin.cms.message.gmenubar_action_newcard,
			onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
			deletable : false,
			selected : true,
			icon: 'plus'
		});

		sect1.items.push(
		{
			id : 'act_querycards',
			title : org.r3.shkadmin.cms.message.gmenubar_action_querycards,
			onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
			deletable : false,
			selected : true,
			icon: 'table'
		});
		
		
		var sect2 = {
   		        type: 'section',			    
				id : 'gmenubar_sect_promotedcards',
				title: org.r3.shkadmin.cms.message.gmenubar_action_promotedcategories, 
				bottom_border: true,
				items: [],
				grouped: true,
				icon: 'bars'				
		};		 
		gsidebarCfg.sections.push(sect2);	 

		var sect3 = {
   		        type: 'section',			    
				id : 'gmenubar_sect_timelines',				
				bottom_border: true,
				items: [],
				icon: 'bars'				
		};		 
		gsidebarCfg.sections.push(sect3);
		
		sect3.items.push(
		{
			id : 'act_newtimeline',
			title : org.r3.shkadmin.cms.message.gmenubar_action_newtimeline,
			onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
			deletable : false,
			selected : true,
			icon: 'plus'
		});
		
		sect3.items.push(
		{
			id : 'act_querytimeline',
			title : org.r3.shkadmin.cms.message.gmenubar_action_querytimeline,
			onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
			deletable : false,
			selected : true,
			icon: 'list'
		});
				
		$('#gsidebar-navanchor').gsidebar(gsidebarCfg);
	 
		var _self = this;
		 
	    $.ajax({
	          "dataType": 'json',
	          "type": "GET",
	          "url": org.r3.PageManager.getRESTUrl('GET_classifier_m_contentclass'),
	          "success": function(data, textStatus, jqXHR)
	          {
	        	  if (data.aaData && data.aaData.length)
	        	  {
	        		   var categoryItems = [];
	        		   for(var i = 0; i < data.aaData.length; i++)
	        		   {
	        			   if (data.aaData[i].classifieritemsattr == 'promoted')
	        			   {
		        			   categoryItems.push({
			   	       				id : data.aaData[i].clsitemid,
				       				title : data.aaData[i].classifieritemdescr,
				       				onClick : $.r3Utils.hitch(_self, _self._onGMenuBarClick),
				       				deletable: false	        				   
			        		   }); 	        				   
	        			   }
	        		   }	        		   			    
	        		   
	 	        	   $('#gsidebar-navanchor').gsidebar('addItems2Section', 'gmenubar_sect_promotedcards', categoryItems);
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

	_onGMenuBarClick : function(e, actionTriggered)
	{
		console.info("_itsbeenclicked", e);
		if (e.id == 'gmenubar_act_newcard')
		{
			org.r3.PageManager.closeAllBreadCrumbs();
			$('#gsidebar-navanchor').gsidebar('select', e.id);

			this.openNewCardPanel();
			return;
		}

		if (e.selected)
		{
			if (actionTriggered && actionTriggered == 'delete')
			{
				// this.deleteActorGroup(e.id);
			}
			else
			{
				// Se e' selezionato allora vuol dire che nella history dei
				// breadcrumb e' in posizione 1 visto che in posizione 0 ci sta
				// la home console.
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

				switch (e.id)
				{
				case 'act_querycards':
					this.openCMSCardQueryActionFormPanel();
					break;
					
				case 'act_newtimeline':
					this.openNewTimelinePanel();
					break;
					
				case 'act_querytimeline':
					this.openQueryTimelineActionFormPanel();
					break;
										
				default:
					this.openCMSCardQueryActionFormPanel(e.id);
					break;

				}
			}
		}
	},

	openCMSCardQueryActionFormPanel : function(categoryId)
	{
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.shkadmin.cms.message.breadcrumb_managecards,
			"actionForm" : this.cardQueryActionForm
		});

		this.cardQueryActionForm.open(categoryId);
		if (categoryId)
		   $('#gsidebar-navanchor').gsidebar('select', categoryId);
		else
		   $('#gsidebar-navanchor').gsidebar('select', 'act_querycards');
			
	},

	openNewCardPanel : function()
	{
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.shkadmin.cms.message.breadcrumb_newcard,
			"actionForm" : this.cardDetailActionForm
		});
		this.cardDetailActionForm.open(null);
	},

	onNewCardCreated : function(cardDataBean)
    {
  	     org.r3.PageManager.closeAllBreadCrumbs();
	     this.detailCard(cardDataBean);
   },	
   
	closeCardPanel : function()
    {
   	     org.r3.PageManager.closeAllBreadCrumbs();
   	     this.openCMSCardQueryActionFormPanel();
    },	
	
	detailCard : function(cardDataBean)
	{
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.shkadmin.cms.message.breadcrumb_carddetail,
			"actionForm" : this.cardDetailActionForm
		});

		var dataBeanInfo =
		{
			"cardDataBean" : cardDataBean
		};

		this.cardDetailActionForm.open(cardDataBean);
	},

	openNewTimelinePanel : function()
	{
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.shkadmin.cms.message.breadcrumb_newtimeline,
			"actionForm" : this.timelineDetailActionForm
		});
		this.timelineDetailActionForm.open(null);
	},

	onNewTimelineCreated : function(timelineDataBean)
    {  	    
	     this.closeTimelinePanel();
    },	
   
	closeTimelinePanel : function()
    {
   	     org.r3.PageManager.closeAllBreadCrumbs();
   	     this.openQueryTimelineActionFormPanel();
    },	
	
	detailTimeline : function(timelineDataBean)
	{
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.shkadmin.cms.message.breadcrumb_timelinedetail,
			"actionForm" : this.timelineDetailActionForm
		});

		var dataBeanInfo =
		{
			"timelineDataBean" : timelineDataBean
		};

		this.timelineDetailActionForm.open(timelineDataBean);
	},

	openQueryTimelineActionFormPanel : function()
	{
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.shkadmin.cms.message.breadcrumb_managetimeline,
			"actionForm" : this.timelineQueryActionForm
		});

		this.timelineQueryActionForm.open();
		$('#gsidebar-navanchor').gsidebar('select', 'act_querytimeline');			
	},
	
	uploadFile : function(cardDTOAdapter)
	{
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.shkadmin.cms.message.breadcrumb_fileupload,
			"actionForm" : this.uploadFileActionForm
		});

		this.uploadFileActionForm.open(
		{
			 "uploadfile_resturl": org.r3.PageManager.getRESTUrl('POST_PostFileAttachment', [ cardDTOAdapter.dataBean.site, org.r3.Constants.language, cardDTOAdapter.dataBean.postid ]), 
			 "uploadfile_resturl_ie": org.r3.PageManager.getRESTUrl('POST_PostFileAttachment', [ cardDTOAdapter.dataBean.site, org.r3.Constants.language, cardDTOAdapter.dataBean.postid ]), 
			 "fileTypes": org.r3.message.getDefaultAcceptedCMSFileTypes(),
			 "formfragment": org.r3.Constants.applicationContext + '/org/r3/jsportlet/mongocms/UploadFileExtensionActionForm.html.jsp',			 
			 "formFragmentInit": function() 
			 {
					org.r3.PageManager.lutManager.populateSelectField(
					{
						"lutUrl" : org.r3.PageManager.getRESTUrl('LUT_CMS_Attachtype_post_fileattach'),					
						"selectWidget" : $('#uploadfileactionform_form_cms_attachtype')
					});
			 }
		
		     // ,"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText")
		});
	}
};
