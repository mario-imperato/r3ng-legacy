$.r3Utils.namespace("org.r3.console.siteconfig.page");


org.r3.console.siteconfig.page.PageDetailActionFormView_TabPageText = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, aPageDataBean, aPageDescrDataBean)
	{
		var _self = this;
		
		this._super(anHtmlActionFormContainerId, anActionFormManager);

		$('#pagetextactionform_fieldset_message').formmessage({});
		$('#pagetextactionform_form_languagecode').unbind().change(function(e) 
		{
			var currentTarget = $(e.currentTarget);
			var l = currentTarget.val();
			
		    _self.actionFormManager.retrievePageDescr(l, $.r3Utils.hitch(_self, _self.initializeFields), function(message)
		    {
		    	$('#pagetextactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' });	
		    });	
		});
		
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : org.r3.PageManager.getRESTUrl('GET_classifier_locale'),
			// "blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
			"selectWidget" : $('#pagetextactionform_form_languagecode'),
			"selectedValue": org.r3.Constants.language
		});
			    
		this.initializeFields(aPageDescrDataBean);

		$('#pagetextactionform_action_saveitem').unbind().click($.r3Utils.hitch(this, this.updateItem));	
		
		$('#pagetextactionform_action_cancel').click(function(e) { org.r3.PageManager.back(); });								

		$('#pagetextactionform_form').validate
        ({
        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
               rules: org.r3.console.siteconfig.page.pagetextactionform_form_validationRules,
	           messages: org.r3.console.siteconfig.page.pagetextactionform_form_validationMessages	           
        });			

	},
	
	updateItem: function()
	{            
		this.actionFormManager.updatePageDescr4Language($('#pagetextactionform_form_languagecode').val());
	},
	
	initializeFields: function(aPageDescrDataBean)
	{
		$('#pagetextactionform_fieldset_message').formmessage('clear');
		
		if (aPageDescrDataBean != null)
		{				
		$('#pagetextactionform_form_pageid_label').html('[' + aPageDescrDataBean.dataBean.pageid + ']');
		$('#pagetextactionform_form_pagetitle').val(aPageDescrDataBean.dataBean.pagetitle);			
		$('#pagetextactionform_form_summary').val(aPageDescrDataBean.dataBean.summary);
		}
		else
		{
			$('#pagetextactionform_form_pagetitle').val(null);			
			$('#pagetextactionform_form_summary').val(null);		
		}
		
	}
		
});
