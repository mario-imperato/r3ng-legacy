$.r3Utils.namespace("org.r3.jsportlet.mongocms");


org.r3.jsportlet.mongocms.CardDetailActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.tabGenerale = null;
		this.tabCardText = null;
		this.tabCardFile = null;
		this.tabCardLink = null;
		this.tabCardPhoto = null;
		this.tabCardContent = null;
		this.tabPublishing = null;
	},

	close : function()
	{
		this.hide();
	},

	refresh: function()
	{
		if (this.tabCardFile)
		   this.tabCardFile.refresh();
		
		if (this.tabGenerale)
		   this.tabGenerale.refresh();
		
		if (this.tabCardLink)
			   this.tabCardLink.refresh();		

		if (this.tabCardPhoto)
			   this.tabCardPhoto.refresh();	
		
		if (this.tabCardContent)
			   this.tabCardContent.refresh();		
		
		if (this.tabPublishing)
			   this.tabPublishing.refresh();			
	},
	


	open : function(aCardDTOAdapter)
	{
		org.r3.PageManager.wait("org.r3.message.waiting");
        console.log("Logged User Is: ", org.r3.PageManager.userInfo);
		var networkRequestsQueue = [];

		if (aCardDTOAdapter)
		{
			networkRequestsQueue.push(
			{
				id : "view",
				type : "Get",
				url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/mongocms/CardDetailActionFormView.html.jsp?mode=detail'),
				dataType : "html"
			});

			networkRequestsQueue.push(
			{
				id : "content",
				type : "Get",
				url : org.r3.PageManager.getRESTUrl('GET_Post_Detail', [ aCardDTOAdapter.dataBean.site, org.r3.Constants.language, aCardDTOAdapter.dataBean.postid ]),
				dataType : "json"
			});

			networkRequestsQueue.push(
			{
				id : "view_tabcardtext",
				type : "Get",
				url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/mongocms/CardDetailActionFormView_TabCardText.html'),
				dataType : "html"
			});
			
			networkRequestsQueue.push(
			{
				id : "pkg_facebookconfig_properties",
				type : "Get",
				url : org.r3.PageManager.getRESTUrl('GET_FacebookConfig_SiteProperties'),
				dataType : "json"
			});	
			
//			networkRequestsQueue.push(
//			{
//				id : "content_descr",
//				type : "Get",
//				url : org.r3.PageManager.getRESTUrl('GET_CardDescr_Detail', [ aCardDTOAdapter.dataBean.cardid, org.r3.Constants.language ]),
//				dataType : "json"
//			});

		}
		else
		{
			networkRequestsQueue.push(
			{
				id : "view",
				type : "Get",
				url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/mongocms/CardDetailActionFormView.html.jsp?mode=create'),
				dataType : "html"
			});			
		}

		networkRequestsQueue.push(
		{
			id : "view_tabgenerale",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/mongocms/CardDetailActionFormView_TabGenerale.html'),
			dataType : "html"
		});
		
		networkRequestsQueue.push(
		{
			id : "view_tabphoto",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/mongocms/CardDetailActionFormView_TabCardPhoto.html'),
			dataType : "html"
		});
		
		networkRequestsQueue.push(
		{
			id : "view_tabcontent",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/mongocms/CardDetailActionFormView_TabCardContent.html'),
			dataType : "html"
		});
		
		networkRequestsQueue.push(
		{
			id : "view_tabpublishing",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/mongocms/CardDetailActionFormView_TabPublishing.html'),
			dataType : "html"
		});
		
		var contentdefinition = null;
		if (aCardDTOAdapter)
		{
			contentdefinition = this.actionFormManager._getContentClassDefinition(aCardDTOAdapter);
			
			if (contentdefinition.isSectionEnabledInMongoCMS("customcontent"))
			{
				networkRequestsQueue.push(
				{
					id : "view_tabcontentedittemplate",
					type : "Get",
					url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + contentdefinition.getEditTemplateURL()),
					dataType : "html"
				});			
			}		
		}
		
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_sys_recstatus'));
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_locale'));
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_graphcontentdef'));
		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_contentclassdef'));	
		
		if (!org.r3.PageManager.lutManager.isLUTLoaded(org.r3.PageManager.getRESTUrl('GET_classifier_contentclassdef')))
		{
			console.error("LUT GET_classifier_contentclassdef Has Not Been Loaded But Is Required");
		}	
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();
						
			var cardDataBean = responseData['content'];
			if (cardDataBean)
			{
				cardDataBean = new org.r3.db.mongo.postcollection.PostCollectionDTOAdapter(cardDataBean);
			}
						
			$(this.htmlContainerId).html(tmpl(responseData['view'], { "contentdefinition": contentdefinition }));			

			$('#cardDetailActionForm_tab_generale').html(tmpl(responseData['view_tabgenerale'], {}));			
			this.tabGenerale = new org.r3.jsportlet.mongocms.CardDetailActionFormView_TabGenerale('__UNUSED__', this.actionFormManager, cardDataBean);

			if (cardDataBean)
            {						
				if (contentdefinition.isSectionEnabledInMongoCMS("customcontent"))
				{
			    $('#cardDetailActionForm_tab_cardcontent').html(tmpl(responseData['view_tabcontent'], {}));
			    $('#cardDetailActionForm_tab_cardcontent .contentcanvas').html(tmpl(responseData['view_tabcontentedittemplate'], {}));			    			    
			    
			    this.tabCardContent = new org.r3.jsportlet.mongocms.CardDetailActionFormView_TabCardContent('__UNUSED__', this.actionFormManager, cardDataBean, contentdefinition.getModelObject());				
				}
				
				if (contentdefinition.isSectionEnabledInMongoCMS("richtext"))
				{
			    $('#cardDetailActionForm_tab_cardtext').html(tmpl(responseData['view_tabcardtext'], {}));
			    this.tabCardText = new org.r3.jsportlet.mongocms.CardDetailActionFormView_TabCardText('__UNUSED__', this.actionFormManager, cardDataBean);				
				}

				if (contentdefinition.isSectionEnabledInMongoCMS("photo"))
				{			    				
			    $('#cardDetailActionForm_tab_cardphoto').html(tmpl(responseData['view_tabphoto'], {}));	
			    this.tabCardPhoto = new org.r3.jsportlet.mongocms.CardDetailActionFormView_TabCardPhoto('#cardDetailActionForm_tab_cardphoto', this.actionFormManager, cardDataBean);
			    this.graphicActionFormView = new org.r3.jsportlet.imageupload.ImageUploadActionFormView('#cardphotoactionform_uploadimage_canvas', this);
			    this.graphicActionFormView.open(this._getCardPhotoUploadOptions(cardDataBean));
				}
				
				if (contentdefinition.isSectionEnabledInMongoCMS("fileattachments"))
				{			    							    
			    this.tabCardFile = new org.r3.jsportlet.mongocms.CardDetailActionFormView_TabCardFile('#cardDetailActionForm_tab_cardfile', this.actionFormManager, cardDataBean);
				}
				
				if (contentdefinition.isSectionEnabledInMongoCMS("links"))
				{			    							    
				this.tabCardLink = new org.r3.jsportlet.mongocms.CardDetailActionFormView_TabCardLink('#cardDetailActionForm_tab_cardlink', this.actionFormManager, cardDataBean);
				}
				
				if (contentdefinition.isSectionEnabledInMongoCMS("publishing"))
				{			    							    
					var pkg_facebookconfig_properties = responseData['pkg_facebookconfig_properties'];
					if (pkg_facebookconfig_properties)
					{
						pkg_facebookconfig_properties = new org.r3.db.system.siteproperty.SitePropertyDTOTableAdapter(pkg_facebookconfig_properties, 
								function(aRowDataBean) { return new org.r3.db.system.siteproperty.SitePropertyDTOAdapter(aRowDataBean); });									
			
					}
					
					$('#cardDetailActionForm_tab_publishing').html(tmpl(responseData['view_tabpublishing'], {}));
					this.tabPublishing = new org.r3.jsportlet.mongocms.CardDetailActionFormView_TabPublishing('#cardDetailActionForm_tab_publishing', this.actionFormManager, cardDataBean, pkg_facebookconfig_properties);
				}
				
			}
			
			// $('#cardDetailActionFormTabs').tabs();
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	
	_getCardPhotoUploadOptions: function(aCardDataBean)
	{
		var graphicContentDefinition = this.actionFormManager._getPhotoGraphicContentDefinition(aCardDataBean);
		
		var actualValue = 
		{
		     "cssClassName" : "css_" + graphicContentDefinition.dtokey,
			 "extraInfo" : graphicContentDefinition.extrainfo, 
			 "aspectRatio": graphicContentDefinition.aspectratio, 
			 "maxSize": graphicContentDefinition.maxsize,
			 "templateFile" : "ImageUploadActionFormView2.html.jsp",
			 "uploadUrl" : org.r3.PageManager.getRESTUrl("POST_PostPhoto", [ aCardDataBean.dataBean.site, org.r3.Constants.language, aCardDataBean.dataBean.postid ]),
			 "currentImageUrl" : graphicContentDefinition.currentimageurl,
			 "imageCanvasIdHash": '#loadimage_canvas',
			 "inputFileTriggerSelector" : '#loadimage_input_file'
		};
		
		var u = aCardDataBean.getPhotoUrl();
		if (u)
		{
			actualValue.currentImageUrl = u;
		}
		
		return actualValue;
	}
	
});
