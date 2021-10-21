//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.mongo.contentdefinitioncollection");

org.r3.db.mongo.contentdefinitioncollection.formSerializationFieldExclusionList =
{ 
   "parentpostid": 1, "postid": 1, "contentclass": 1, "title": 1, "content": 1, "files" : 1, 
   "timeline" : 1, "author" : 1, "authorname" : 1, "authortype" : 1, "photo": 1, "geolat": 1, "geolong": 1, "geoacc": 1 
}
;

org.r3.db.mongo.contentdefinitioncollection.getContentClassDefinition = function(contentClass)
{
	var contentClassLUTResolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_contentclassdef');
	var lutItem = org.r3.PageManager.lutManager.getLUTItem(contentClassLUTResolvedUrl, contentClass);
	
	if (lutItem)
		lutItem = new org.r3.db.mongo.contentdefinitioncollection.ContentDefinitionDTOAdapter(lutItem);
	
	return lutItem;
};

org.r3.db.mongo.contentdefinitioncollection.getPhotoGraphicContentDefinitionByContentClass = function(contentClass)
{
	var contentClassDef = org.r3.db.mongo.contentdefinitioncollection.getContentClassDefinition(contentClass);
	
	var graphicContentDefinitionLUTResolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_graphcontentdef');
	var lutItem = org.r3.PageManager.lutManager.getLUTItem(graphicContentDefinitionLUTResolvedUrl, contentClassDef.dataBean.photographictype);
	return lutItem;
};

org.r3.db.mongo.contentdefinitioncollection.ContentDefinitionDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	   this._super(new org.r3.db.mongo.contentdefinitioncollection.ContentDefinitionDTO(aDataBean));  
	   this.modelObject = null;
	   this.viewTemplate = null;
	 },
	 
	 isSectionEnabledInMongoCMS: function(aSectionName)
	 {
		 if (this.dataBean.mongocms && this.dataBean.mongocms.sections && this.dataBean.mongocms.sections.length)
		 {
			 for(var i = 0; i < this.dataBean.mongocms.sections.length; i++)
			 {
				 if (this.dataBean.mongocms.sections[i] == aSectionName)
					 return true;
			 }
		 }
		 
		 return false;
	 },
	 
	 getGeolocationOptions: function()
	 {
		 return this.dataBean.geolocation || "disabled";
	 },
	 
	 shouldGeoLocationBeAcquired: function()
	 {
		 var o = this.getGeolocationOptions();
		 return o != "disabled";
	 },
	 
	 isGeoLocationRequired: function()
	 {
		 var o = this.getGeolocationOptions();
		 return o == "required";
	 },
	 
	 newModelObject: function()
	 {
		 var modelObject = eval('new ' + this.dataBean.modelclass + '()');
		 modelObject.setContentDefinitionDTOAdapter(this);

		 return modelObject;
	 },
	 
	 getModelObject: function()
	 {
		 if (!this.modelObject)			 
		 {
			 this.modelObject = this.newModelObject();
		 }

		 return this.modelObject;
	 },
	 
	 initializeModelObject: function(eventHandler)
	 {
		 this.getModelObject().setupForm(eventHandler);
	 },
	 
	 setAuhtorInfo: function(anAuthorInfo)
	 {
		 this.getModelObject().setAuhtorInfo(this.dataBean.dtokey, anAuthorInfo);
	 },
	 
	 getFormValidation: function()
	 {
		 var fv = eval(this.dataBean.formvalidation);
		 return fv;
	 },

	 getTimelinePhotoUploadOptions: function()
	 {
		 var _self = this;
		 
		 var graphicContent = org.r3.db.mongo.contentdefinitioncollection.getPhotoGraphicContentDefinitionByContentClass(this.dataBean.dtokey);
		 
		 var uploadOptions = 
		 {
			"extra_info" : graphicContent.extrainfo, 
	    	"aspect_ratio": graphicContent.aspectratio, 
	    	"max_size": graphicContent.maxsize,
			onUploadCallback  : this.getModelObject().displayPhoto, 		
			onUploadedCallback: function(responseData) 
			{ 
				// Nel caso di immagine potrei avere due elementi: il primo l'immagine scalata, il secondo l'icona.	
				_self.getModelObject().setPhoto(responseData);
				console.log('On Uploaded CallBack', responseData); 
			}				 
		 };
		 
		 return uploadOptions;	
	 },			   

	 getEditTemplateURL: function()
	 {
		 return this.dataBean.mongocms.content.template;
	 },
	 
	 getTimelineEditTemplateURL: function()
	 {
		 return this.dataBean.timeline.timeline_edit_template;
	 },
	 
	 getTimelineViewTemplateURL: function()
	 {
		 return this.dataBean.timeline.timeline_view_template;;
	 },
	 
	 setViewTemplate: function(aViewTemplate)
	 {
		 this.viewTemplate = aViewTemplate;
	 },
	 
	 applyViewTemplate: function(aPost)
	 {
		 templatedHtml = tmpl(this.viewTemplate, { post : aPost, postProfile: this });
		 return templatedHtml;
	 },
	 
	 getActionsByActionType: function(anActionType, targetObj, commentObj)
	 {		 		 
		 return this.getEnabledActionsByType(anActionType, targetObj, commentObj);
	 },
	 
	 _evalVisibility: function(aVisibilityRule, primaryObj, secondaryObject)
	 {
		 var targetObj = (secondaryObject) ? secondaryObject : primaryObj;
		 
		 var tokenizedExpr = aVisibilityRule && aVisibilityRule.split(/([ ||&&()!]+)/);
		 if (tokenizedExpr && tokenizedExpr.length)
		 {
			 var compiledVisibilityRule = "";
			 for(var j = 0; j < tokenizedExpr.length; j++)
			 {
				 var token = tokenizedExpr[j];
				 switch(token)
				 {
				 case 'always':
					 compiledVisibilityRule += 'true';
					 break;
				 case 'isFollower':
					 if (org.r3.PageManager.userCollectionProfileInfo.isUserFollower())
						 compiledVisibilityRule += 'true';
					 else 
						 compiledVisibilityRule += 'false';					 
					 break;
				 case 'isOwner':
					 if (targetObj.isUserOwnerOfContent(org.r3.PageManager.userInfo, org.r3.PageManager.userCollectionProfileInfo))
						 compiledVisibilityRule += 'true';
					 else 
						 compiledVisibilityRule += 'false';					 
					 break;
				 case 'isMerchant':
					 if (org.r3.PageManager.userCollectionProfileInfo.isUserMerchant())
						 compiledVisibilityRule += 'true';
					 else 
						 compiledVisibilityRule += 'false';
					 break;
				 case 'isShaked':
					 // Non uso in questo caso il targetObj in quanto la condizione è solo sui commenti.
					 if (secondaryObject && secondaryObject.isShaked())
						 compiledVisibilityRule += 'true';
					 else 
						 compiledVisibilityRule += 'false';		
					 break;
				 case 'isPostOwner':
					 if (primaryObj.isUserOwnerOfContent(org.r3.PageManager.userInfo, org.r3.PageManager.userCollectionProfileInfo))
						 compiledVisibilityRule += 'true';
					 else 
						 compiledVisibilityRule += 'false';		
					 break;
				 case 'isNeighbowner':
					 if (org.r3.PageManager.userCollectionProfileInfo.isUserNeighborhoodOwner())
						 compiledVisibilityRule += 'true';
					 else 
						 compiledVisibilityRule += 'false';		
					 break;
				 case 'never':
					 compiledVisibilityRule += 'false';
					 break;	
					 
			     default: 
			    	 compiledVisibilityRule += token;
				 }					 
			 }		
			 
			 if (compiledVisibilityRule.length > 0)
				 return eval(compiledVisibilityRule);
		 }

		 return false;
	 },

	 _getTimelineActions: function()
	 {
		 if (this.dataBean == null || !this.dataBean.timeline || !this.dataBean.timeline.timeline_actions || !this.dataBean.timeline.timeline_actions.length)
			 return null;
	
		 return this.dataBean.timeline.timeline_actions;
	 },
	 
	 getActionsByType: function(anActionType)
	 {
		 var actions = this._getTimelineActions();
		 if (!actions)
			 return null;
		 
		 var acts = [];
		 for(var i = 0; i < actions.length; i++)
		 {
			 var item = actions[i];
			 if (item.actionType == anActionType)
			 {				 
				 acts.push(item);				 
			 }
		 }
		 		 		 
		 return acts;		 
	 },
	 
	 getActionsById: function(anActionId)
	 {
		 var actions = this._getTimelineActions();
		 if (!actions)
			 return null;
		 		 
		 for(var i = 0; i < actions.length; i++)
		 {
			 var item = actions[i];
			 if (item.id == anActionId)
			 {				 
				 return item;				 
			 }
		 }
		 		 		 
		 return null;		 
	 },
	 
	 getEnabledActionsByType: function(anActionType, primaryObj, secondaryObject)
	 {
		 var actions = this._getTimelineActions();
		 if (!actions)
			 return null;
		 
		 var acts = [];
		 for(var i = 0; i < actions.length; i++)
		 {
			 var item = actions[i];
			 if (item.actionType == anActionType)
			 {
				 if (this._evalVisibility(item.visibility, primaryObj, secondaryObject))
				 {
					 acts.push(item);
				 }
			 }
		 }
		 		 		 
		 return acts;		 
	 },
	 
	 isActionEnabled: function(anActionId, primaryObj, secondaryObject)
	 {
		 var actions = this._getTimelineActions();
		 if (!actions)
			 return false;
		 
		 for(var i = 0; i < actions.length; i++)
		 {
			 var item = actions[i];
			 if (item.id == anActionId)
			 {
				 return this._evalVisibility(item.visibility, primaryObj, secondaryObject);
			}
		 }
		 		 		 
		 return false;
	 },
	 
	 getCurrentUserEnabledRoles4NewPost: function(anActionId, aPostObj)
	 {
		 var roles = [];
		 
		 var lastAuthorChosenByUser = org.r3.PageManager.userCollectionProfileInfo.getUserAnalyticsLastpostauthor();
		 var preferredAuthor = null;
		 
		 var act = this.getActionsById(anActionId);
		 if (act)
		 {
			 // Per evitare doppio inserimento in presenza del ruolo postOwner (che puo' essere piu' o meno qualsiasi cosa
			 // memorizzo l'id relativo al postOwner ed evito di re-inserirlo nelle verifiche successive.
			 var postOwnerAdded = null;
			 
			 var enabledRoles = act.roles;
			 // Ipotesi Non ci puo' essere pstOwner se l'azione e' newPost....
			 if (enabledRoles.indexOf('postOwner') >= 0)
			 {
				 switch(aPostObj.dataBean.authortype)
				 {
				 case 'user':
					 if (org.r3.PageManager.userInfo.dataBean.userid == aPostObj.dataBean.author)
					 {
						 roles.push({					 
							author: org.r3.PageManager.userInfo.dataBean.userid,
							authorname: org.r3.PageManager.userInfo.getUserFullname(),
							authortype : 'user',
							getAuthorphotourl: function() { return org.r3.PageManager.userInfo.getUserPhotoIconUrl(); }
						 });	
						 
						 postOwnerAdded = aPostObj.dataBean.author;
						 
						 if (lastAuthorChosenByUser && lastAuthorChosenByUser == org.r3.PageManager.userInfo.dataBean.userid)
							 preferredAuthor = roles[roles.length - 1];
					 }	 
					 break;
				 case 'merchant':
					 // Non posso usare direttamente l comparazione sull'id in quanto potrei avere piu' id di amministrazione.
					 // quindi debbo verificare che si tratti di un merchant abilitato. In realtà potrei vedere sui merchantRoles della userCollection...
					 // Qui è da inserire un ruolo specifico. In quanto lo sto mettendo come vicinato
					 // if (org.r3.PageManager.userInfo.isInRole(aPostObj.dataBean.author, '__any__')
					 if (org.r3.PageManager.userInfo.hasRole4Site(aPostObj.dataBean.author, org.r3.db.system.user.user.role_shkadmin) || 
						 org.r3.PageManager.userInfo.hasRole4Site(aPostObj.dataBean.author, org.r3.db.system.user.user.role_shkowner))
					 {
						 var m = org.r3.PageManager.userCollectionProfileInfo.getMerchantRoleById(aPostObj.dataBean.author);
						 roles.push({					 
								author: m.site.site,
								authorname: m.site.sitedescription,
								authortype : 'merchant',
								getAuthorphotourl: function() { 
									return org.r3.PageManager.getRESTUrl("GET_SiteCollection_Graphic", [ this.author, 'sitesquared', 'icon' ]); 
								}
						 });						 

						 postOwnerAdded = aPostObj.dataBean.author;
						 
						 if (lastAuthorChosenByUser && lastAuthorChosenByUser == m.site.site)
							 preferredAuthor = roles[roles.length - 1];
					 }
					 break;
				 case 'neighbowner':
					 // Qui è da inserire un ruolo specifico. In quanto lo sto mettendo come vicinato
					 // if (org.r3.PageManager.userInfo.isInRole(aPostObj.dataBean.author, '__any__'))
					 if (org.r3.PageManager.userInfo.hasRole4Site(aPostObj.dataBean.author, org.r3.db.system.user.user.role_shkadmin) || 
						 org.r3.PageManager.userInfo.hasRole4Site(aPostObj.dataBean.author, org.r3.db.system.user.user.role_shkowner))					 
					 {
						 roles.push({					 
							author: org.r3.SiteConstants.targetSite,
						    authorname: org.r3.SiteConstants.targetSiteName,
						    authortype : 'neighborhood',
						    getAuthorphotourl: function() { return org.r3.PageManager.getRESTUrl("GET_SiteCollection_Graphic", [ org.r3.SiteConstants.targetSite, 'sitesquared', 'icon' ]); }
						 });
						 
						 postOwnerAdded = aPostObj.dataBean.author;
						 
						 if (lastAuthorChosenByUser && lastAuthorChosenByUser == org.r3.SiteConstants.targetSite)
							 preferredAuthor = roles[roles.length - 1];
					 }					 
					 break;
				 }				 				 				 
			 }
			 
			 // Bisogna vincolare lo user ad avere un certo ruolo?
			 if (enabledRoles.indexOf('user') >= 0 && (!postOwnerAdded || postOwnerAdded != org.r3.PageManager.userInfo.dataBean.userid))
			 {
				 roles.push({					 
					author: org.r3.PageManager.userInfo.dataBean.userid,
					authorname: org.r3.PageManager.userInfo.getUserFullname(),
					authortype : 'user',
					getAuthorphotourl: function() { return org.r3.PageManager.userInfo.getUserPhotoIconUrl(); }
				 });				 
				 
				 if (lastAuthorChosenByUser && lastAuthorChosenByUser == org.r3.PageManager.userInfo.dataBean.userid)
					 preferredAuthor = roles[roles.length - 1];
			 }
			 
			 if (enabledRoles.indexOf('merchant') >= 0 && org.r3.PageManager.userCollectionProfileInfo.isUserMerchant())
			 {
				 // In questo caso i merchantROles dovrebbero essere gia' filtrati..
				 var merchantRoles = org.r3.PageManager.userCollectionProfileInfo.merchantRoles;
				 for(var i = 0; i < merchantRoles.length; i++)
				 {
					 if ((!postOwnerAdded || postOwnerAdded != merchantRoles[i].site.site))
					 {
					 roles.push({					 
						author: merchantRoles[i].site.site,
						authorname: merchantRoles[i].site.sitedescription,
						authortype : 'merchant',
						getAuthorphotourl: function() { 
							return org.r3.PageManager.getRESTUrl("GET_SiteCollection_Graphic", [ this.author, 'sitesquared', 'icon' ]); 
						}
					 });
					 
					 if (lastAuthorChosenByUser && lastAuthorChosenByUser == merchantRoles[i].site.site)
						 preferredAuthor = roles[roles.length - 1];
					 
					 }
				 }
			 }
			 
			 // In questo caso la verifica del neighborhood role dovrebbe gia' coprire il ruolo specifico.
			 if (enabledRoles.indexOf('neighbowner') >= 0 && 
					 org.r3.PageManager.userCollectionProfileInfo.isUserNeighborhoodOwner() && 
					 (!postOwnerAdded || postOwnerAdded != org.r3.SiteConstants.targetSite))
			 {				 
				 roles.push({					 
					author: org.r3.SiteConstants.targetSite,
				    authorname: org.r3.SiteConstants.targetSiteName,
				    authortype : 'neighborhood',
				    getAuthorphotourl: function() { return org.r3.PageManager.getRESTUrl("GET_SiteCollection_Graphic", [ org.r3.SiteConstants.targetSite, 'sitesquared', 'icon' ]); }
				 });
				 
				 if (lastAuthorChosenByUser && lastAuthorChosenByUser == org.r3.SiteConstants.targetSite)
					 preferredAuthor = roles[roles.length - 1];
			 }
			 
		 }
		 
		 if (roles.length)
		 {
			 if (!preferredAuthor)
				 preferredAuthor = roles[0];
			 return { current : preferredAuthor, listofroles : roles };
		 }
		 
		 return null;
	 }

       
});

