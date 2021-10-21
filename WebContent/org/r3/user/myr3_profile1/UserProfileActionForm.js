$.r3Utils.namespace("org.r3.user.myr3_profile1");

org.r3.user.myr3_profile1.UserProfileActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.randomPhotoSideBarActionFormView = new org.r3.jsportlet.rndphotosidebar.RandomPhotoSideBarActionFormView('#JSPortlet_RandomPhotoSideBar', this);
		this.taskCompletionSideBarActionFormView = new org.r3.jsportlet.taskcompletionsidebar.TaskCompletionSideBarActionFormView ('#JSPortlet_TaskCompletionSideBar', this);							
		this.changeUserPwdActionFormView = new org.r3.jsportlet.changeuserpwd.ChangeUserPasswordActionFormView('#changeUserPasswordActionForm', this);
		this.userPhotoActionFormView = new org.r3.jsportlet.imageupload.ImageUploadActionFormView('#userPhotoActionForm', this);
		this.addressActionFormView = new org.r3.jsportlet.address.AddressActionFormView('#addressActionForm', this);
        this.businesscardinfoActionFormView = new org.r3.jsportlet.user.BusinessCardInfoActionFormView('#businesscardinfoActionForm', this);
	},

	close : function()
	{
		this.hide();
	},

	hide : function()
	{
		this.randomPhotoSideBarActionFormView.hide();
		this.taskCompletionSideBarActionFormView.hide();
		this.changeUserPwdActionFormView.hide();
		this.userPhotoActionFormView.hide();
		this.addressActionFormView.hide();
		this.businesscardinfoActionFormView.hide();
	},

	show : function()
	{
		this.randomPhotoSideBarActionFormView.show();
		this.taskCompletionSideBarActionFormView.show();
		this.changeUserPwdActionFormView.show();
		this.userPhotoActionFormView.show();
		this.addressActionFormView.show();
		this.businesscardinfoActionFormView.show();
	},

	refresh : function()
	{
	},

	open : function()
	{
		var _self = this;
		var method = 'get';
		var restUrl = org.r3.PageManager.getRESTUrl('GET_UserCollection_Detail', [ org.r3.PageManager.userInfo.dataBean.userid ]);
		
		$.ajax(
		{
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"success" : function(responseData)
			{
				var dtoAdapter = null;
				if (responseData)
				{
					dtoAdapter = new org.r3.db.mongo.usercollection.UserCollectionDTOAdapter(responseData);
				}
				else dtoAdapter = new org.r3.db.mongo.usercollection.UserCollectionDTOAdapter({
					userid : org.r3.PageManager.userInfo.dataBean.userid,
					description: org.r3.PageManager.userInfo.dataBean.lastname
				});

				_self.randomPhotoSideBarActionFormView.open();
				_self.taskCompletionSideBarActionFormView.open({ taskCompletionLevel: dtoAdapter.getCompletionPercentage() });
				_self.changeUserPwdActionFormView.open(dtoAdapter);
				_self.userPhotoActionFormView.open({
					 "cssClassName" : "css_" + "userphoto",
					 "extraInfo" : [ { "name": "cms_attachtype" , "value" : "userphoto" }], "aspectRatio": 1, "maxSize": [300, 300],
					 "templateFile" : "ImageUploadActionFormView.html.jsp",
					 "uploadUrl" : org.r3.PageManager.getRESTUrl('PUT_UserCollection_Photo', [ org.r3.PageManager.userInfo.dataBean.userid ]),
					 "currentImageUrl" : dtoAdapter.getPhotoUrl(),
					 "imageCanvasIdHash": '#loadimage_canvas',
					 "inputFileTriggerSelector" : '#loadimage_input_file',
					 "onSubmission" : $.r3Utils.hitch(_self, _self.updateProfileStatusInfo)
				});
				_self.addressActionFormView.open(dtoAdapter.getAddressDTOAdapter(), true);
				_self.businesscardinfoActionFormView.open(dtoAdapter);
				$('#profileActionFormTabs a[data-toggle="tab"]').on('shown.bs.tab', function (e) 
				{
					var activated = e.target;
					var prevActivated = e.relatedTarget;
					console.log(activated, prevActivated);
					
					_self.addressActionFormView.map.invalidateSize();
				});
					
			},
			"error" : function(jqXHR, timeout, message)
			{
				console.error(message);
			}
		});		
	},
	
	onViewStatusChanged: function()
	{
		this.updateProfileStatusInfo();
	},
	
	updateProfileStatusInfo: function()
	{
		var _self = this;
		var method = 'get';
		var restUrl = org.r3.PageManager.getRESTUrl('GET_UserCollection_Detail', [ org.r3.PageManager.userInfo.dataBean.userid ]);
		
		$.ajax(
		{
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"success" : function(responseData)
			{
				var dtoAdapter = null;
				if (responseData)
				{
					dtoAdapter = new org.r3.db.mongo.usercollection.UserCollectionDTOAdapter(responseData);
				}
				else dtoAdapter = new org.r3.db.mongo.usercollection.UserCollectionDTOAdapter({
					userid : org.r3.PageManager.userInfo.dataBean.userid,
					description: org.r3.PageManager.userInfo.dataBean.lastname
				});
				
				_self.taskCompletionSideBarActionFormView.refresh({ taskCompletionLevel: dtoAdapter.getCompletionPercentage() });				
			},
			"error" : function(jqXHR, timeout, message)
			{
				console.error(message);
			}
		});				
	},
	
	doChangeUserPassword : function()
	{
		var _self = this;
		
		org.r3.AjaxUtils.submitForm(
			"post", 
			org.r3.PageManager.getRESTUrl('POST_User_ChangeMyPassword'), 
			$("#changeuserpwdform_form"), 
			function(responseData) { 

				var restDto = new org.r3.RestDTOAdapter(responseData);

				if (restDto.isOk())
                {										
					 restDto.showMessage('changeuserpwdform_fieldset_message');
                }				
				else restDto.showMessage('changeuserpwdform_fieldset_message');
				
			},
			function(jqXHR, timeout, message) { 
			
				console.error(message); 
				$('#changeuserpwdform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
				
			}, 
			"org.r3.message.saveconfirm", 
			true);
				
		event.preventDefault();
	},
	
	onAddressFormSave : function()
	{
		var _self = this;
		
		org.r3.AjaxUtils.submitForm(
			"put", 
			org.r3.PageManager.getRESTUrl('PUT_UserCollection_Address', [ org.r3.PageManager.userInfo.dataBean.userid ]), 
			$("#addressform_form"), 
			function(responseData) { 
				$('#addressform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });
				// Notifico l'actionFormManager che ho fatto qualcosa.
				_self.onViewStatusChanged();
			},
			function(jqXHR, timeout, message) { console.error(message); }, 
			"org.r3.message.saveconfirm", 
			true);
				
	},
	
//	doChangeUserPassword: function()
//	{
//		var _self = this;
//		
//		if ($('#changeuserpwdform_form').valid())
//		{
//			org.r3.PageManager.wait("org.r3.message.waiting");
//
//			var method = "post";
//			var restUrl = org.r3.PageManager.getRESTUrl('POST_User_ChangeMyPassword');
//			$('#changeuserpwdform_form').ajaxSubmit(
//			{
//				"type" : method,
//				"url" : restUrl,
//				"dataType" : "json",
//				"success" : function(responseData)
//				{
//					if (org.r3.PageManager.isRestDTO(responseData))
//					{
//						org.r3.PageManager.closeNotifier();
//						var restDto = new org.r3.RestDTOAdapter(responseData);
//
//						if (restDto.isOk())
//	                    {					
//							console.info($(_self.detailView.htmlContainerId + " .panel-body"), _self.detailView.htmlContainerId + " .panel-body");
//							$(_self.detailView.htmlContainerId + " .panel-body").cmsCard({ card_tmpl: "cms_tpl_simple", cardid: "HLP_CHANGEPWDOK"});
//							$(_self.detailView.htmlContainerId + " .action-bar").hide();
//							
//							restDto.showMessage('changeuserpwdform_fieldset_message');
//	                    }				
//						else restDto.showMessage('changeuserpwdform_fieldset_message');
//					}
//					else 
//					{						
//						org.r3.PageManager.redirectToHomePage();
//					}
//										
//				},
//				"error" : function(jqXHR, timeout, message)
//				{
//					console.log(arguments);
//					org.r3.PageManager.closeNotifier();
//					$('#changeuserpwdform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
//				}
//			});
//		}				
//	}
	
			
});

