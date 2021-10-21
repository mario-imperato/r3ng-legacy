$.r3Utils.namespace("org.r3.jsportlet.user");

org.r3.jsportlet.user.UserDetailActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aChildEntityListViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.user.UserDetailActionFormView(aDetailViewContainerId, this);
		this.changePasswordView = new org.r3.jsportlet.user.ChangePasswordActionFormView('#changePasswordActionForm', this);
	},

	close : function()
	{
		// M20140201 - org.r3.PageManager.popBreadCrumb();
		this.hide();
	},

	hide : function()
	{
		this.detailView.hide();
		this.changePasswordView.hide();
	},

	show : function()
	{
		this.detailView.show();
	},

	open : function(aDataBeanInfo)
	{
		console.log("UserDetailActionForm::open", aDataBeanInfo);
		this.setDataBeanInfo(aDataBeanInfo);
		this.detailView.open(aDataBeanInfo);			
	},

	updateItem : function()
	{
		this._saveItem(true);
	},

	createItem : function()
	{
		this._saveItem(false);
	},

	_saveItem : function(isUpdate)
	{
		var theForm = $('#userdetailactionform_form');
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
		{
			var method = "post";
			var restUrl = org.r3.PageManager.getRESTUrl('POST_User');
			if (isUpdate)
			{
				var idUser = this.dataBeanInfo.userDataBean.dataBean.userid;
				restUrl = org.r3.PageManager.getRESTUrl('PUT_User', [ idUser ]);
				method = "put";
			}

			org.r3.PageManager.wait("org.r3.message.waiting");
			theForm.ajaxSubmit(
			{
				"type" : method,
				"url" : restUrl,
				"dataType" : "json",
				"success" : function(responseData)
				{
					org.r3.PageManager.closeNotifier();
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('userdetailactionform_fieldset_message');
					}
					else 
					{
						org.r3.PageManager.back();
					}					
				}
			});
		}
	},

	listaUsers : function()
	{
		org.r3.PageManager.back();
	},
	
	openChangePasswdPanel: function()
	{
		this.changePasswordView.open(this.dataBeanInfo);
	},
	
	doChangePassword : function()
	{
		var theForm = $('#changepasswordactionform_form');
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
		{
			var method = "put";
			var idUser = this.dataBeanInfo.userDataBean.dataBean.userid;
			var restUrl = org.r3.PageManager.getRESTUrl('PUT_User_Passwd', [ idUser ]);

			org.r3.PageManager.wait("org.r3.message.waiting");
			theForm.ajaxSubmit(
			{
				"type" : method,
				"url" : restUrl,
				"dataType" : "json",
				"success" : function(responseData)
				{
					org.r3.PageManager.closeNotifier();
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('changepasswordactionform_fieldset_message');
						
						if (restDto.isOk())
						{
						    theForm.resetForm();	
						}
					}
				}
			});
		}
	},
	
	
	updateRoles : function()
	{
		var theForm = $('#siterolesactionform_form');
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
		{
			var method = "put";
			var idUser = this.dataBeanInfo.userDataBean.dataBean.userid;
			var restUrl = org.r3.PageManager.getRESTUrl('PUT_User_Roles', [ idUser ]);

			org.r3.PageManager.wait("org.r3.message.waiting");
			theForm.ajaxSubmit(
			{
				"type" : method,
				"url" : restUrl,
				"dataType" : "json",
				"success" : function(responseData)
				{
					org.r3.PageManager.closeNotifier();
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('siterolesactionform_fieldset_message');						
					}
				}
			});
		}
	}
	

});