$.r3Utils.namespace("org.r3.jsportlet.site.sitemember");

org.r3.jsportlet.site.sitemember.portletScrollInfo = Class.extend(
{
	init: function(aPageSize)
	{  
    	this.pageSize = aPageSize;
    	this.pageOffset = 0;
    	this.keepLoading = false;
    	this.loadingInProgress = false;
	},
	
	update: function(dataSize)
	{
		if (dataSize < this.pageSize)
		{
			this.keepLoading = false;			
		}
		else
		{
			this.keepLoading = true;
			this.pageOffset += dataSize;
		}	
	}

});

org.r3.jsportlet.site.sitemember.SiteMemberPortletActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);	
		this.siteMembersMap = {};
	},

	close : function()
	{
		this.hide();
	},

	open : function(aDataBeanInfo)
	{
		var _self = this;
		
		this.siteMembersMap = {};
		this.fetchPostInfo = new org.r3.jsportlet.site.sitemember.portletScrollInfo(20);
		
		org.r3.PageManager.wait("org.r3.message.waiting");
        console.log("Logged User Is: ", org.r3.PageManager.userInfo);
		var networkRequestsQueue = [];

		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/site/sitemember/SiteMemberPortletActionFormView.html.jsp?mode=detail'),
			dataType : "html"
		});

		networkRequestsQueue.push(
		{
			id : "members",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_UserCollection_SiteMembers', [ this.fetchPostInfo.pageSize + '', this.fetchPostInfo.pageOffset + '' ]),
			dataType : "json"
		});

		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();
			
			$(this.htmlContainerId).html(tmpl(responseData['view'], { "members" : members }));			
			
			this.siteMemberPhotoCanvas = $('#JSPortlet_SiteMember_Photo_Canvas');
			this.siteMemberPhotoCanvas.slimScroll({
		        height: '250px'
		    }).bind('slimscroll', $.r3Utils.hitch(this, function(e, pos) {

		    	if (pos != 'bottom')
		    		return ;
		    	
		    	if (this.fetchPostInfo.loadingInProgress || !this.fetchPostInfo.keepLoading)	
					  return ;
				
				this.fetchPostInfo.loadingInProgress = true;
				$(this.htmlContainerId + " .sitemember-loading-state").show();
				
				this._loadSiteMembersPage(this.fetchPostInfo.pageSize, this.fetchPostInfo.pageOffset);
				
		    }));
		    
			this.siteMemberPhotoCanvas.click(function(e) {
		    	
		    	var currentTarget = $(e.target);
		    	if (currentTarget.attr('data-sitemember'))
		    	{
		    		_self.showMemberInfo(currentTarget.attr('data-sitemember'));
		    	}
		    });
		    
			
			$('#JSPortlet_SiteMember_ILike').unbind().click(function(e) { _self.addMeAsSiteMember(); });			
			$('#JSPortlet_SiteMember_IDisLike').unbind().click(function(e) { _self.removeMeAsSiteMember(); });								
			
			var members = responseData['members'];			
			if (members)
			{
				this.processPageOfMembers(this.siteMemberPhotoCanvas, members);			
			}
		    
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	
	processPageOfMembers: function(aCanvas, queryResult)
	{
		if (queryResult && queryResult.aaData && queryResult.aaData.length > 0)
		{
			this.fetchPostInfo.update(queryResult.aaData.length);
			
			$.each(queryResult.aaData, $.r3Utils.hitch(this, function(entryIndex, entry)
			{
				var dto = new org.r3.db.mongo.usercollection.UserCollectionDTOAdapter(entry);
				this.siteMembersMap[dto.dataBean.userid] = dto;
								
				var photoUrl = this._getPhotoUrlForMember(dto)
				var html = "<a href='javascript:void(0)' >" + 
		                   "<img data-sitemember='" + dto.dataBean.userid + "' " + 
		                   " src='"	+ photoUrl + "' " + 
		                   " class='img-thumbnail img-responsive' " + 
		                   " title='" + dto.getUsername() + "' " + 
		                   " />" + 
		                   "</a>";
				
				aCanvas.append(html);
			}));
		}
	},
	
	_loadSiteMembersPage: function(aPageSize, anOffset)
	{				
		var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_UserCollection_SiteMembers", [ aPageSize, anOffset ]);
			
		org.r3.AjaxUtils.ajaxInvoke(
			
			"GET", 
			resolvedUrl, 
			
			$.r3Utils.hitch(this, function(responseData)
			{
				if (responseData)
				{
					this.processPageOfMembers(this.siteMemberPhotoCanvas, responseData);			
				}
				this.fetchPostInfo.loadingInProgress = false;	
				$(this.htmlContainerId + " .sitemember-loading-state").hide();
			}),
			
			$.r3Utils.hitch(this, function(jqXHR, timeout, message)
			{
				console.log(arguments);	
				$(this.htmlContainerId + " .sitemember-loading-state").hide();
				this.fetchPostInfo.loadingInProgress = false;	
			})
		);				
	},
	
	_getPhotoUrlForMember: function(aUserCollectionDTOAdapter)
	{
		var u = aUserCollectionDTOAdapter.getPhotoIconUrl();                                                                                                                                                                                
        return $.r3Utils.formatDMSUrl4ClientAccess(u);              
	},
	
	addMeAsSiteMember: function()
	{
        var _self = this;						
				
		org.r3.AjaxUtils.ajaxInvoke(
				"PUT", 
				org.r3.PageManager.getRESTUrl('PUT_UserCollection_LikeSite'),  
				function(responseData) { 					
					// $('#JSPortlet_SiteMember_ILike_Canvas').hide();
					$('#JSPortlet_SiteMember_ILike_Canvas').html('<div style="width: 100%; text-align:center"><i class="fa fa-spinner fa-spin fa-2x" ></i></div>');					
					window.location.reload(true);
				}, 
				
				function(jqXHR, timeout, message) { console.error(message); },
				false,
		        false);			
	},
	
	removeMeAsSiteMember: function()
	{
        var _self = this;						
		
		org.r3.AjaxUtils.ajaxInvoke(
				"PUT", 
				org.r3.PageManager.getRESTUrl('PUT_UserCollection_DisLikeSite'),  
				function(responseData) { 					
					// $('#JSPortlet_SiteMember_IDisLike_Canvas').hide();
					$('#JSPortlet_SiteMember_IDisLike_Canvas').html('<div style="width: 100%; text-align:center"><i class="fa fa-spinner fa-spin fa-2x" ></i></div>');
					window.location.reload(true);
				}, 
				
				function(jqXHR, timeout, message) { console.error(message); },
				false,
		        false);			
	},
	
	showMemberInfo: function(aUserId)
	{
		console.log("UserId: " + aUserId);
		var dto = this.siteMembersMap[aUserId];
		if (dto)
		{
			var dform = null;
			
			if (org.r3.PageManager.isSmallDevice())
			{	
				dform = $("#jsportlet_endof_sitememberportlet");				
				dform.html(tmpl('cms_tpl_shakeussitememberbcard', { member: dto, memberPhoto: this._getPhotoUrlForMember(dto) }));		
				dform.show();
				
				$('html, body').animate({
	                scrollTop: dform.offset().top
	            }, 1000);
			}
			else
			{
				dform = $("#jsportlet_startof_centerband");
				dform.html(tmpl('cms_tpl_shakeussitememberbcard', { member: dto, memberPhoto: this._getPhotoUrlForMember(dto) }));		
				dform.show();
				
//				var dform = $("#sitemember-dialog-form");
//				dform.find('.modal-content').html(tmpl('cms_tpl_shakeussitememberbcard_modal', { member: dto, memberPhoto: this._getPhotoUrlForMember(dto) }));
//				dform.modal();				
			}
			
			
//			var memberPhotoUrl = "<img src='" + this._getPhotoUrlForMember(dto) + "' class='img-thumbnail' style='max-width: 128px;'>";
//			dform.find('.sitemember-photo').html(memberPhotoUrl);
//			dform.find('.sitemember-name').html(dto.dataBean.description);
			
				
		}
		
	}
	
		

});