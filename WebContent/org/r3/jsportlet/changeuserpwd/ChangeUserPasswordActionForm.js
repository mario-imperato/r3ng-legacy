$.r3Utils.namespace("org.r3.jsportlet.changeuserpwd");

org.r3.jsportlet.changeuserpwd.ChangeUserPasswordActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.changeuserpwd.ChangeUserPasswordActionFormView(aDetailViewContainerId, this);
	},

	close : function()
	{
		this.hide();
	},

	hide : function()
	{
		this.detailView.hide();
	},

	show : function()
	{
		this.detailView.show();
	},

	refresh : function()
	{
	},

	open : function()
	{
		this.detailView.open();
	},
	
	doChangeUserPassword: function()
	{
		var _self = this;
		
		if ($('#changeuserpwdform_form').valid())
		{
			org.r3.PageManager.wait("org.r3.message.waiting");

			var method = "post";
			var restUrl = org.r3.PageManager.getRESTUrl('POST_User_ChangeMyPassword');
			$('#changeuserpwdform_form').ajaxSubmit(
			{
				"type" : method,
				"url" : restUrl,
				"dataType" : "json",
				"success" : function(responseData)
				{
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						org.r3.PageManager.closeNotifier();
						var restDto = new org.r3.RestDTOAdapter(responseData);

						if (restDto.isOk())
	                    {					
							console.info($(_self.detailView.htmlContainerId + " .panel-body"), _self.detailView.htmlContainerId + " .panel-body");
							$(_self.detailView.htmlContainerId + " .panel-body").cmsCard({ card_tmpl: "cms_tpl_simple", cardid: "HLP_CHANGEPWDOK"});
							$(_self.detailView.htmlContainerId + " .action-bar").hide();
							
							restDto.showMessage('changeuserpwdform_fieldset_message');
	                    }				
						else restDto.showMessage('changeuserpwdform_fieldset_message');
					}
					else 
					{						
						org.r3.PageManager.redirectToHomePage();
					}
										
				},
				"error" : function(jqXHR, timeout, message)
				{
					console.log(arguments);
					org.r3.PageManager.closeNotifier();
					$('#changeuserpwdform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
				}
			});
		}				
	}
		
});

