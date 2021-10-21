$.r3Utils.namespace("org.r3.shkadmin.siteconfig");

org.r3.shkadmin.siteconfig.PageManager = 
{
  	
	 init: function()
	 {	
		 this.addressActionForm = new org.r3.shkadmin.siteconfig.AddressActionForm(this, '#addressActionForm');
		 this.imageUploadActionForm1 = new org.r3.jsportlet.imageupload.ImageUploadActionForm(this, '#imageUploadActionForm', '#imageUploadActionForm .imageUploadGraphicCanvas');
		 this.imageUploadActionForm2 = new org.r3.jsportlet.imageupload.ImageUploadActionForm(this, '#imageUploadActionForm', '#imageUploadActionForm .imageUploadGraphicCanvas');
		 this.siteInfoActionForm = new org.r3.shkadmin.siteconfig.SiteInfoActionForm(this, '#siteInfoActionForm');
		 this.facebookConfigActionForm = new org.r3.shkadmin.siteconfig.FacebookConfigActionForm(this, '#facebookConfigActionForm');
		 this.adminsActionForm = new org.r3.shkadmin.siteconfig.AdminsActionForm(this, '#adminsActionForm', '#listOfAdminsActionForm');
		 
		 this.createGSideBar();
		 org.r3.PageManager.pushHomeBreadCrumb();
		 org.r3.PageManager.pushBreadCrumb(this.getHomeBreadCrumb());
		 this.openInfoPanel();
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
			    id : 'act_info',
				title : org.r3.shkadmin.siteconfig.message.gmenubar_act_info,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				selected: true,
				icon: 'info'
		 });
		 
		 sect1.items.push({			    
			    id : 'act_address',
				title : org.r3.shkadmin.siteconfig.message.gmenubar_act_address,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				selected: true,
				icon: 'map-marker'
		 });

		 sect1.items.push({			    
			    id : 'act_img_sitesquared',
				title : org.r3.shkadmin.siteconfig.message.gmenubar_act_img_sitesquared,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				selected: true,
				icon: 'picture-o'
		 });
		 
		 sect1.items.push({			    
			    id : 'act_img_shksitephoto',
				title : org.r3.shkadmin.siteconfig.message.gmenubar_act_img_shksitephoto,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				selected: true,
				icon: 'picture-o'
		 });
		 
		 sect1.items.push({			    
			    id : 'act_admins',
				title : org.r3.shkadmin.siteconfig.message.gmenubar_act_admins,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				selected: true,
				icon: 'user-circle'
		 });

		 sect1.items.push({			    
			    id : 'act_facebook',
				title : org.r3.shkadmin.siteconfig.message.gmenubar_act_facebook,
				onClick : $.r3Utils.hitch(this, this._onGMenuBarClick),
				deletable: false,
				selected: true,
				icon: 'facebook'
		 });
		 		 
		 $('#gsidebar-navanchor').gsidebar(gsidebarCfg);	

         var _self = this;
		 	 		 
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
	    	 case 'act_info':
		    	 this.openInfoPanel();
		    	 break;
		    	 
	    	 case 'act_address':
		    	 this.openAddressConfigPanel();
		    	 break;

	    	 case 'act_img_sitesquared':
	    		 this.openImageConfigPanel('sitesquared', this.imageUploadActionForm1);
		    	 break;

	    	 case 'act_img_shksitephoto':
	    		 this.openImageConfigPanel('shksitephoto', this.imageUploadActionForm2);
		    	 break;
		    	 
	    	 case 'act_admins':
		    	 this.openAdminsPanel();
		    	 break;
		 
	    	 case 'act_facebook':
	    		 this.openFacebookConfigPanel();
	    		 break;
	    		 
		     default:
		    	 break;
		    	 
		     }
   		 }
	     }
	 },
	 
	 openAddressConfigPanel: function()
	 {
		 org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.shkadmin.siteconfig.message.breadcrumb_address,
			"actionForm" : this.addressActionForm
		});
		 
		 this.addressActionForm.open();		 
		 $('#gsidebar-navanchor').gsidebar('select', 'act_address');		 
	 },

	 openFacebookConfigPanel: function()
	 {
		 org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.shkadmin.siteconfig.message.breadcrumb_facebook,
			"actionForm" : this.facebookConfigActionForm
		});
		 
		 this.facebookConfigActionForm.open();		 
		 $('#gsidebar-navanchor').gsidebar('select', 'act_facebook');		 
	 },
	 
	 openInfoPanel: function()
	 {
		 org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.shkadmin.siteconfig.message.breadcrumb_siteinfo,
			"actionForm" : this.siteInfoActionForm
		});
		 
		 this.siteInfoActionForm.open();		 
		 $('#gsidebar-navanchor').gsidebar('select', 'act_info');		 
	 },
	 
	 openAdminsPanel: function()
	 {
		 org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.shkadmin.siteconfig.message.breadcrumb_address,
			"actionForm" : this.addressActionForm
		});
		 
		 this.addressActionForm.open();		 
		 $('#gsidebar-navanchor').gsidebar('select', 'act_address');		 
	 },
	 
	 openAdminsPanel: function()
	 {
		 org.r3.PageManager.pushBreadCrumb(
		{
			"title" : org.r3.shkadmin.siteconfig.message.breadcrumb_admins,
			"actionForm" : this.adminsActionForm
		});
		 
		 this.adminsActionForm.open();		 
		 $('#gsidebar-navanchor').gsidebar('select', 'act_admins');		 
	 },
	 
	 openImageConfigPanel: function(aGraphicType, anActionForm)
	 {
		var _self = this;
		var currentSite = org.r3.Constants.site;
				
		org.r3.AjaxUtils.ajaxInvoke(
		'get', 
			org.r3.PageManager.getRESTUrl('GET_SiteCollection_Detail', [ currentSite ]),
			function(responseData)
			{
				var siteCollectionDTOAdapter = null;
							
				if (responseData)
				{
				   siteCollectionDTOAdapter = new org.r3.db.mongo.sitecollection.SiteCollectionDTOAdapter(responseData);	
				   var mongoImage = siteCollectionDTOAdapter.getGraphicByRole('image', aGraphicType);
				   console.log(mongoImage);
				   
				   org.r3.PageManager.pushBreadCrumb(
				   {
						"title" : eval('org.r3.shkadmin.siteconfig.message.breadcrumb_img_' + aGraphicType),
						"actionForm" : anActionForm
				   });
					 
				   anActionForm.open(aGraphicType, mongoImage);		 
				   $('#gsidebar-navanchor').gsidebar('select', 'act_img_graphicType');								   
				}
			}
		);								 		 
	 }
	
};

