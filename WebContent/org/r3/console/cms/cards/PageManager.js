$.r3Utils.namespace("org.r3.console.cms.cards");

org.r3.console.cms.cards.PageManager =
{

	init : function()
	{
		this.cardQueryActionForm = new org.r3.jsportlet.cmsconsole.CardQueryActionForm(this, '#cardQueryActionForm',
				'#cardQueryAdvancedSearchActionForm');
		this.cardDetailActionForm = new org.r3.jsportlet.cmsconsole.CardDetailActionForm(this, '#cardDetailActionForm');
		this.uploadFileActionForm = new org.r3.jsportlet.cmsconsole.UploadFileActionForm(this, '#uploadFileActionForm');

		this.cardChannelQueryActionForm = new org.r3.console.cms.cards.CardChannelQueryActionForm(this, '#cardChannelQueryActionForm');
		
		this.createGSideBar();
		org.r3.PageManager.pushHomeConsoleBreadCrumb();

		this.openCMSCardQueryActionFormPanel();
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
			title : org.r3.console.cms.cards.message.gmenubar_action_newcard,
			onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
			deletable : false,
			selected : true,
			icon: 'plus'
		});

		sect1.items.push(
		{
			id : 'act_querycards',
			title : org.r3.console.cms.cards.message.gmenubar_action_querycards,
			onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
			deletable : false,
			selected : true,
			icon: 'table'
		});
		
		sect1.items.push(
		{
			id : 'act_querychannelcards',
			title : org.r3.console.cms.cards.message.gmenubar_action_querychannelcards,
			onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
			deletable : false,
			selected : true,
			icon: 'table'
		});
		
		var sect2 = {
   		        type: 'section',			    
				id : 'gmenubar_sect_promotedcats',
				title: org.r3.console.cms.cards.message.gmenubar_action_promotedcategories, 
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
	          "url": org.r3.PageManager.getRESTUrl('LUT_CMS_Category'),
	          "success": function(data, textStatus, jqXHR)
	          {
	        	  if (data.aaData && data.aaData.length)
	        	  {
	        		   var categoryItems = [];
	        		   for(var i = 0; i < data.aaData.length; i++)
	        		   {
	        			   if (data.aaData[i].categorymode == 'promoted')
	        			   {
		        			   categoryItems.push({
			   	       				id : data.aaData[i].categoryid,
				       				title : data.aaData[i].categorydescr,
				       				onClick : $.r3Utils.hitch(_self, _self._onGMenuBarClick),
				       				deletable: false	        				   
			        		   }); 	        				   
	        			   }
	        		   }	        		   			    
	        		   
	 	        	   $('#gsidebar-navanchor').gsidebar('addItems2Section', 'gmenubar_sect_promotedcats', categoryItems);
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

				case 'act_querychannelcards':
					this.openCMSCardChannelQueryActionFormPanel();
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
			"title" : org.r3.console.cms.cards.message.breadcrumb_managecards,
			"actionForm" : this.cardQueryActionForm
		});

		this.cardQueryActionForm.open(categoryId);
		if (categoryId)
		   $('#gsidebar-navanchor').gsidebar('select', categoryId);
		else
		   $('#gsidebar-navanchor').gsidebar('select', 'act_querycards');
			
	},

	openCMSCardChannelQueryActionFormPanel: function()
	{
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.console.cms.cards.message.breadcrumb_managecardchannels,
			"actionForm" : this.cardChannelQueryActionForm
		});
		
		this.cardChannelQueryActionForm.open();
	},
	
	
	
	openNewCardPanel : function()
	{
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.console.cms.cards.message.breadcrumb_newcard,
			"actionForm" : this.cardDetailActionForm
		});
		this.cardDetailActionForm.open(null);
	},

	closeNewCardPanel : function()
    {
   	     org.r3.PageManager.closeAllBreadCrumbs();
	     this.openCMSCardQueryActionFormPanel();
    },	
	
	detailCard : function(cardDataBean)
	{
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.console.cms.cards.message.breadcrumb_carddetail,
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
			"title" : org.r3.console.cms.cards.message.breadcrumb_fileupload,
			"actionForm" : this.uploadFileActionForm
		});

		this.uploadFileActionForm.open(cardDTOAdapter);
	}
};
