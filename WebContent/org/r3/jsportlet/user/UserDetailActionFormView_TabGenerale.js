$.r3Utils.namespace("org.r3.jsportlet.user");


org.r3.jsportlet.user.UserDetailActionFormView_TabGenerale = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, aUserDataBean)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);

		// ignore: ':hidden:not("#userdetailactionform_form_ruoliesiti, #userdetailactionform_form_ruolipostaliz")'
		$('#userdetailactionform_form').validate
        ({
        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
               rules: org.r3.jsportlet.user.userdetailactionform_form_validationRules,
	           messages: org.r3.jsportlet.user.userdetailactionform_form_validationMessages
	           
        });			
				
		if (aUserDataBean == null)
		{				
			$('#userdetailactionform_action_saveitem').unbind().click($.r3Utils.hitch(this.actionFormManager, this.actionFormManager.createItem));
			$('#userdetailactionform_action_openchangepasswd').hide();
		}
		else
		{
			$('#userdetailactionform_form_nickname').attr('value', aUserDataBean.dataBean.nickname);
			$('#userdetailactionform_form_firstname').attr('value', aUserDataBean.dataBean.firstname);	
			$('#userdetailactionform_form_lastname').attr('value', aUserDataBean.dataBean.lastname);
			$('#userdetailactionform_form_email').attr('value', aUserDataBean.dataBean.email);			
			
			$('#userdetailactionform_form_nickname').prop('disabled', true);
			
			$('#userdetailactionform_action_saveitem').unbind().click($.r3Utils.hitch(this.actionFormManager, this.actionFormManager.updateItem));
			$('#userdetailactionform_action_openchangepasswd').click($.r3Utils.hitch(this.actionFormManager, this.actionFormManager.openChangePasswdPanel));
			
			$('#userdetailactionform_form_createsiteactor').prop('checked', aUserDataBean.dataBean.actorid && true);
		}
		
		
		var checkContainer = $('#userdetailactionform_authrole_cnt');
		if (checkContainer.length > 0)
		{
			var resolvedUrl = org.r3.PageManager.getRESTUrl('LUT_AuthRole');
			org.r3.PageManager.lutManager.populateCheckBoxGroup(
			{
				"lutUrl" : resolvedUrl,
				"groupContainer" : $('#userdetailactionform_authrole_cnt'),
				"groupId" : "userdetailactionform_authrole_",
				"groupName" : "authrole",
				"value" : aUserDataBean && aUserDataBean.getCSVPermissions4Site(org.r3.Constants.site),
				"labelSize" : 200
			});
		}
		
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : org.r3.PageManager.getRESTUrl('GET_classifier_sys_recstatus'),
			// "blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
			"selectWidget" : $('#userdetailactionform_form_recstatus'),
			"selectedValue": (aUserDataBean) ? aUserDataBean.dataBean.recstatus : null
		});
		
		$('#userdetailactionform_action_cancel').click(function(e) { org.r3.PageManager.back(); });						
		$('#userdetailactionform_fieldset_message').formmessage({});

	}
		
});
