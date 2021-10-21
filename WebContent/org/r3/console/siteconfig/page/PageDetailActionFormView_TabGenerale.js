$.r3Utils.namespace("org.r3.console.siteconfig.page");


org.r3.console.siteconfig.page.PageDetailActionFormView_TabGenerale = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, aPageDataBean)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		
		$('#pagedetailactionform_form .date_picker').datepicker(
		{
			showOn : "button",
			buttonImage : org.r3.Constants.applicationContext + "/resources/img/calendar.gif",
			buttonImageOnly : true,
			dateFormat : "dd/mm/yy"
		});

		if (aPageDataBean == null)
		{				
			$('#pagedetailactionform_action_saveitem').unbind().click($.r3Utils.hitch(this.actionFormManager, this.actionFormManager.createItem));
			
			$('.hideOnNewItem').hide();			
			$('#pagedetailactionform_action_delete').hide();			
		}
		else
		{			
			var resolvedUrl = null; 

			$('.hideOnNewItem').show();

			this._initializeFormFields(aPageDataBean);
			
			$('#pagedetailactionform_action_saveitem').unbind().click($.r3Utils.hitch(this.actionFormManager, this.actionFormManager.updateItem));
			$('#pagedetailactionform_action_delete').unbind().click($.r3Utils.hitch(this.actionFormManager, this.actionFormManager.deleteItem));			
			$('#pagedetailactionform_action_delete').show();			
		}
				
		$('#pagedetailactionform_action_cancel').click($.r3Utils.hitch(this.actionFormManager, this.actionFormManager.closeNewPagePanel));						
		$('#pagedetailactionform_fieldset_message').formmessage({});

		// ignore: ':hidden:not("#userdetailactionform_form_ruoliesiti, #userdetailactionform_form_ruolipostaliz")'
		$('#pagedetailactionform_form').validate
        ({
        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
               rules: org.r3.console.siteconfig.page.pagedetailactionform_form_validationRules,
	           messages: org.r3.console.siteconfig.page.pagedetailactionform_form_validationMessages	           
        });			

	},
	
	refresh: function()
	{		

	},
	
	_initializeFormFields: function(aPageDTOAdapter)
	{
		$('#pagedetailactionform_pageid_label').html('[' + aPageDTOAdapter.dataBean.pageid + ']');
		
		$('#pagedetailactionform_pageid').val(aPageDTOAdapter.dataBean.pageid);
		$('#pagedetailactionform_pageid').prop('disabled', true);
		
		$('#pagedetailactionform_pagelink').val(aPageDTOAdapter.dataBean.pagelink);
		$('#pagedetailactionform_pageicon1').val(aPageDTOAdapter.dataBean.pageicon1);
		$('#pagedetailactionform_pageicon2').val(aPageDTOAdapter.dataBean.pageicon2);
		$('#pagedetailactionform_permissions').val(aPageDTOAdapter.dataBean.permissions);
		$('#pagedetailactionform_pageorder').val(aPageDTOAdapter.dataBean.pageorder);
		
		$('#pagedetailactionform_pagetitle').val(aPageDTOAdapter.dataBean.pagetitle);		
		
		$('#pagedetailactionform_pagestyle').val(aPageDTOAdapter.dataBean.pagestyle);
		$('#pagedetailactionform_forwardview').val(aPageDTOAdapter.dataBean.forwardview);
		
		$('#pagedetailactionform_pagetype_' +aPageDTOAdapter.dataBean.pagetype).prop('checked', true); 
		$('#pagedetailactionform_onuserstatus_' +aPageDTOAdapter.dataBean.onuserstatus).prop('checked', true); 

		$('#pagedetailactionform_viewoptions').val(aPageDTOAdapter.dataBean.viewoptions);
		var visbilitySelectedOptions = aPageDTOAdapter.getVisibilityAsArray();
		if (visbilitySelectedOptions)
		{
		    for(var i = 0; i < visbilitySelectedOptions.length; i++)	
		    {
		    	$('#pagedetailactionform_visibility_' + visbilitySelectedOptions[i]).prop('checked', true); 
		    }
		}
		
	}
		
});
