//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.mongo.sitecollection");

org.r3.db.mongo.sitecollection.SiteCollectionConfigDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	      this._super(new org.r3.db.mongo.sitecollection.SiteCollectionConfigDTO(aDataBean)); 
	      
	       this.timelinesMap = {};
	       
	       for(var i = 0; i < aDataBean.timelines.length; i++)  
	       {
	           var timelineCfgItem = aDataBean.timelines[i];
	           timelineCfgItem.path = timelineCfgItem._id;
	              
	           this.timelinesMap[timelineCfgItem._id] = timelineCfgItem;
	           if (timelineCfgItem.timelines && timelineCfgItem.timelines.length)
	           {
	  				for(var j = 0; j < timelineCfgItem.timelines.length; j++)  
	 				{
	    				var timelineCfgSubItem = timelineCfgItem.timelines[j];
	    				timelineCfgSubItem.path = timelineCfgItem._id + '/' + timelineCfgSubItem._id;
	    				this.timelinesMap[timelineCfgSubItem._id] = timelineCfgSubItem;
	    			}
		       }
	       }
	       
	       this.contentClassMap = {};
	       this.contentclasses  = [];
	       for(var i = 0; i < aDataBean.contentclasses.length; i++)  
	       {
	    	   var contentClassDataBean = aDataBean.contentclasses[i];
	           var contentclassCfgItem = new org.r3.db.mongo.sitecollection.ContentClassConfigDTOAdapter(contentClassDataBean);              
	           this.contentClassMap[contentClassDataBean.name] = contentclassCfgItem;  
	           this.contentclasses.push(contentclassCfgItem);
	       }       

	 },
	 
	 getTimeline: function(aTimelineId)
	 {
		 var t = this.timelinesMap[aTimelineId];
		 if (!t)
			 console.error("Could Not find Timeline for " + aTimelineId);
		 
		 return t;
	 },
	 
	 getContentclass: function(aContentclassId)
	 {
		 var t = this.contentClassMap[aContentclassId];
		 if (!t)
			 console.error("Could Not find Content class for " + aContentclassId);
		 
		 return t;
	 }
       
});


org.r3.db.mongo.sitecollection.ContentClassConfigDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {
		 this._super(new org.r3.db.mongo.sitecollection.ContentClassConfigDTO(aDataBean));
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
	 
	 getActionsByType: function(anActionType)
	 {
		 if (this.dataBean == null || this.dataBean.actions == null || !this.dataBean.actions.length)
			 return null;
		 
		 var acts = [];
		 for(var i = 0; i < this.dataBean.actions.length; i++)
		 {
			 var item = this.dataBean.actions[i];
			 if (item.actionType == anActionType)
			 {				 
				 acts.push(item);				 
			 }
		 }
		 		 		 
		 return acts;		 
	 },
	 
	 getActionsById: function(anActionId)
	 {
		 if (this.dataBean == null || this.dataBean.actions == null || !this.dataBean.actions.length)
			 return null;
		 		 
		 for(var i = 0; i < this.dataBean.actions.length; i++)
		 {
			 var item = this.dataBean.actions[i];
			 if (item.id == anActionId)
			 {				 
				 return item;				 
			 }
		 }
		 		 		 
		 return null;		 
	 },
	 
	 getEnabledActionsByType: function(anActionType, primaryObj, secondaryObject)
	 {
		 if (this.dataBean == null || this.dataBean.actions == null || !this.dataBean.actions.length)
			 return null;
		 
		 var acts = [];
		 for(var i = 0; i < this.dataBean.actions.length; i++)
		 {
			 var item = this.dataBean.actions[i];
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
		 if (this.dataBean == null || this.dataBean.actions == null || !this.dataBean.actions.length)
			 return false;
		 
		 for(var i = 0; i < this.dataBean.actions.length; i++)
		 {
			 var item = this.dataBean.actions[i];
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


