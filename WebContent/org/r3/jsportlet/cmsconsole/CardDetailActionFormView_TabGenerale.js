$.r3Utils.namespace("org.r3.jsportlet.cmsconsole");


org.r3.jsportlet.cmsconsole.CardDetailActionFormView_TabGenerale = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, aCardDataBean)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		
		$('#carddetailactionform_form .r3_datepicker').datepicker({
			format: "dd/mm/yyyy"
		});

		$('#carddetailactionform_form_validityrule_always, #carddetailactionform_form_validityrule_never, #carddetailactionform_form_validityrule_date').click(
		function(e)
		{
			var currentTarget = $(e.currentTarget);
			var currentTargetId = currentTarget.attr('id');
					
			if (currentTarget.prop('checked'))
			{
				switch (currentTargetId)
				{
					case 'carddetailactionform_form_validityrule_always':													
						$('#carddetailactionform_form_validfrom').prop('disabled', true);
						$('#carddetailactionform_form_validfrom').val('');
						
						$('#carddetailactionform_form_validto').prop('disabled', true);						
						$('#carddetailactionform_form_validto').val('');
						break;

					case 'carddetailactionform_form_validityrule_never':													
						$('#carddetailactionform_form_validfrom').prop('disabled', true);
						$('#carddetailactionform_form_validfrom').val('');
						
						$('#carddetailactionform_form_validto').prop('disabled', true);
						$('#carddetailactionform_form_validto').val('');						
						break;

					case 'carddetailactionform_form_validityrule_date':													
						$('#carddetailactionform_form_validfrom').prop('disabled', false);
						$('#carddetailactionform_form_validto').prop('disabled', false);
						break;						
				}
			}										
		});

		$('#carddetailactionform_form_pagelinktype_none, #carddetailactionform_form_pagelinktype_page, #carddetailactionform_form_pagelinktype_custom').click(
		function(e)
		{
			var currentTarget = $(e.currentTarget);
			var currentTargetId = currentTarget.attr('id');
					
			if (currentTarget.prop('checked'))
			{
				switch (currentTargetId)
				{
					case 'carddetailactionform_form_pagelinktype_none':													
						$('#carddetailactionform_form_pagelink').prop('disabled', true);
						$('#carddetailactionform_form_pagelink').val('');
						
						$('#carddetailactionform_form_pageid').prop('disabled', true);						
						$('#carddetailactionform_form_pageid').val('');
						break;

					case 'carddetailactionform_form_pagelinktype_page':													
						$('#carddetailactionform_form_pagelink').prop('disabled', true);
						$('#carddetailactionform_form_pagelink').val('');
						
						$('#carddetailactionform_form_pageid').prop('disabled', false);						
						$('#carddetailactionform_form_pageid').val('');
						break;

					case 'carddetailactionform_form_pagelinktype_custom':													
						$('#carddetailactionform_form_pagelink').prop('disabled', false);
						$('#carddetailactionform_form_pagelink').val('');
						
						$('#carddetailactionform_form_pageid').prop('disabled', true);						
						$('#carddetailactionform_form_pageid').val('');
						break;						
				}
			}										
		});
		
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : org.r3.PageManager.getRESTUrl('LUT_CMS_Page'),
			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
			"selectWidget" : $('#carddetailactionform_form_pageid'),
			"selectedValue": aCardDataBean && aCardDataBean.dataBean.pageid && (aCardDataBean.dataBean.site + '_' + aCardDataBean.dataBean.pageid)
		});
		
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : org.r3.PageManager.getRESTUrl('LUT_CMS_Category'),
			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
			"selectWidget" : $('#carddetailactionform_form_categoryid'),
			"selectedValue": aCardDataBean && aCardDataBean.dataBean.categoryid
		});
		
//		$('#carddetailactionform_form_gruppi_ms').gmultiselect({ 
//			 "fieldName": 'cardgroup',
//			 "lutUrl" : org.r3.PageManager.getRESTUrl('LUT_CMS_Group'),
//			 "selectedValue": aCardDataBean && aCardDataBean.getCardgroupsAsCSV(),
//			 "buttonBarWidth": "110px"
//		});
		
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : org.r3.PageManager.getRESTUrl('LUT_CMS_Channels'),
			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
			"selectWidget" : $('#carddetailactionform_form_pubchannels'),
			"selectedValue": aCardDataBean && aCardDataBean.getChannelsAsCSV()
		});
		
		
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : org.r3.PageManager.getRESTUrl('LUT_CMS_Group'),
			"selectWidget" : $('#carddetailactionform_form_cardgroup'),
			"selectedValue": aCardDataBean && aCardDataBean.getCardgroupsAsArray(),
			"onComplete": function() { $('#carddetailactionform_form_cardgroup').multiselect(); }
		});
		
		if (aCardDataBean == null)
		{				
			$('#carddetailactionform_action_saveitem').unbind().click($.r3Utils.hitch(this.actionFormManager, this.actionFormManager.createItem));
			// $('#carddetailactionform_action_openchangepasswd').hide();
			
			$('.hideOnNewItem').hide();
			
			$('#carddetailactionform_form_validfrom').prop('disabled', true);
			$('#carddetailactionform_form_validto').prop('disabled', true);			
			
			$('#carddetailactionform_form_pagelink').prop('disabled', true);
			$('#carddetailactionform_form_pageid').prop('disabled', true);		
			
			$('#carddetailactionform_form_refdate').val($.r3Utils.getToday());
			$('#carddetailactionform_action_delete').hide();			
		}
		else
		{			
			var resolvedUrl = null; 
			
//			resolvedUrl = org.r3.PageManager.getRESTUrl("GET_CardImages", [ aCardDataBean.dataBean.cardid ] );
//			org.r3.PageManager.lutManager.populateSelectField(
//			{
//				"lutUrl" : resolvedUrl,
//				"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
//				"selectWidget" : $('#carddetailactionform_form_imagepropertyid'),
//				"selectedValue": aCardDataBean.dataBean.imagepropertyid
//			});
//
//			org.r3.PageManager.lutManager.populateSelectField(
//			{
//				"lutUrl" : resolvedUrl,
//				"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
//				"selectWidget" : $('#carddetailactionform_form_iconpropertyid'),
//				"selectedValue": aCardDataBean.dataBean.iconpropertyid
//			});
//
//			resolvedUrl = org.r3.PageManager.getRESTUrl("GET_CardPropertyLinks", [ aCardDataBean.dataBean.cardid ] );
//			org.r3.PageManager.lutManager.populateSelectField(
//			{
//				"lutUrl" : resolvedUrl,
//				"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
//				"selectWidget" : $('#carddetailactionform_form_titlelinkid'),
//				"selectedValue": aCardDataBean.dataBean.titlelinkid
//			});

			$('#carddetailactionform_form_cardid_label').html('[' + aCardDataBean.dataBean.cardid + ']');
			
			$('#carddetailactionform_form_cardid').val(aCardDataBean.dataBean.cardid);
			$('#carddetailactionform_form_cardid').prop('disabled', true);

			$('#carddetailactionform_form_categoryid').prop('disabled', true);
			
			$('.hideOnNewItem').show();
			
			$('#carddetailactionform_form_systemtitle').val(aCardDataBean.dataBean.systemtitle);

			$('#carddetailactionform_form_validityrule_' + aCardDataBean.dataBean.validityrule).prop('checked', true); 
			if (aCardDataBean.isValidityRuleDate())
			{
				$('#carddetailactionform_form_validfrom').prop('disabled', false);
				$('#carddetailactionform_form_validfrom').val(aCardDataBean.getValidfrom());
				
				$('#carddetailactionform_form_validto').prop('disabled', false);
				$('#carddetailactionform_form_validto').val(aCardDataBean.getValidto());								
			}
			else
			{
				$('#carddetailactionform_form_validfrom').prop('disabled', true);
				$('#carddetailactionform_form_validto').prop('disabled', true);				
			}
			
			$('#carddetailactionform_form_pagelinktype_' + aCardDataBean.dataBean.pagelinktype).prop('checked', true);
			switch(aCardDataBean.dataBean.pagelinktype)
			{
			case 'none':
				$('#carddetailactionform_form_pagelink').prop('disabled', true);
				$('#carddetailactionform_form_pageid').prop('disabled', true);			
				break;
			case 'page':
				$('#carddetailactionform_form_pagelink').prop('disabled', true);			
				break;
			case 'custom':
				$('#carddetailactionform_form_pageid').prop('disabled', true);
				$('#carddetailactionform_form_pagelink').val(aCardDataBean.dataBean.pagelink);
				break;				
			}
			
			$('#carddetailactionform_form_refdate').val(aCardDataBean.getRefdate());
			
			$('#carddetailactionform_action_saveitem').unbind().click($.r3Utils.hitch(this.actionFormManager, this.actionFormManager.updateItem));
			$('#carddetailactionform_action_delete').unbind().click($.r3Utils.hitch(this.actionFormManager, this.actionFormManager.deleteItem));			
			$('#carddetailactionform_action_delete').show();			
		}
				
		$('#carddetailactionform_action_cancel').click($.r3Utils.hitch(this.actionFormManager, this.actionFormManager.closeNewCardPanel));						
		$('#carddetailactionform_fieldset_message').formmessage({});

		// ignore: ':hidden:not("#userdetailactionform_form_ruoliesiti, #userdetailactionform_form_ruolipostaliz")'
		$('#carddetailactionform_form').validate
        ({
        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
               rules: org.r3.jsportlet.cmsconsole.carddetailactionform_form_validationRules,
	           messages: org.r3.jsportlet.cmsconsole.carddetailactionform_form_validationMessages	           
        });			

	},
	
	refresh: function()
	{		
//		var aCardDataBean = this.actionFormManager.dataBeanInfo;
//
//		// Salvo la selezione corrente in quanto questa potrebbe essere difforme rispetto a quanto presente nel dataBean.
//		var currentImageSelected = $('#carddetailactionform_form_imagepropertyid').val();
//			
//		var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_CardImages", [ aCardDataBean.dataBean.cardid ] );
//		org.r3.PageManager.lutManager.invalidateLUT(resolvedUrl);
//
//		org.r3.PageManager.lutManager.populateSelectField(
//		{
//			"lutUrl" : resolvedUrl,
//			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
//			"selectWidget" : $('#carddetailactionform_form_imagepropertyid'),
//			"selectedValue": currentImageSelected
//		});
		
//		var currentIconSelected = $('#carddetailactionform_form_iconpropertyid').val();
//		
//		org.r3.PageManager.lutManager.populateSelectField(
//		{
//			"lutUrl" : resolvedUrl,
//			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
//			"selectWidget" : $('#carddetailactionform_form_iconpropertyid'),
//			"selectedValue": currentIconSelected
//		});
//
//		resolvedUrl = org.r3.PageManager.getRESTUrl("GET_CardPropertyLinks", [ aCardDataBean.dataBean.cardid ] );
//		org.r3.PageManager.lutManager.invalidateLUT(resolvedUrl);
//
//		var currentLinkSelected = $('#carddetailactionform_form_titlelinkid').val();
//		
//		org.r3.PageManager.lutManager.populateSelectField(
//		{
//			"lutUrl" : resolvedUrl,
//			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
//			"selectWidget" : $('#carddetailactionform_form_titlelinkid'),
//			"selectedValue": currentLinkSelected
//		});

	}
		
});
