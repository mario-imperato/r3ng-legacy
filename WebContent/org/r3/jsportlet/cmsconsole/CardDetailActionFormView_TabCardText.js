$.r3Utils.namespace("org.r3.jsportlet.cmsconsole");


org.r3.jsportlet.cmsconsole.CardDetailActionFormView_TabCardText = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, aCardDataBean, aCardDescrDataBean)
	{
		var _self = this;
		
		this._super(anHtmlActionFormContainerId, anActionFormManager);

		$('#cardtextactionform_fieldset_message').formmessage({});
		$('#cardtextactionform_form_languagecode').unbind().change(function(e) 
		{
			var currentTarget = $(e.currentTarget);
			var l = currentTarget.val();
			
		    _self.actionFormManager.retrieveCardDescr(l, $.r3Utils.hitch(_self, _self.initializeFields), function(message)
		    {
		    	$('#cardtextactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' });	
		    });	
		});
		
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : org.r3.PageManager.getRESTUrl('GET_classifier_locale'),
			// "blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
			"selectWidget" : $('#cardtextactionform_form_languagecode'),
			"selectedValue": org.r3.Constants.language
		});
		
		$('#cardtextactionform_form_textbody').ckeditor();
		
	    // CKEDITOR.replace( 'cardtextactionform_form_textbody' );
	    
		this.initializeFields(aCardDescrDataBean);

		$('#cardtextactionform_action_saveitem').unbind().click($.r3Utils.hitch(this, this.updateItem));	
		
		$('#cardtextactionform_action_cancel').click(function(e) { org.r3.PageManager.back(); });								

		// ignore: ':hidden:not("#userdetailactionform_form_ruoliesiti, #userdetailactionform_form_ruolipostaliz")'
		$('#cardtextactionform_form').validate
        ({
        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
               rules: org.r3.jsportlet.cmsconsole.cardtextactionform_form_validationRules,
	           messages: org.r3.jsportlet.cmsconsole.cardtextactionform_form_validationMessages	           
        });			

	},
	
	updateItem: function()
	{
//		for ( instance in CKEDITOR.instances )
//            CKEDITOR.instances[instance].updateElement();
            
		this.actionFormManager.updateCardDescr4Language($('#cardtextactionform_form_languagecode').val());
	},
	
	initializeFields: function(aCardDescrDataBean)
	{
		$('#cardtextactionform_fieldset_message').formmessage('clear');
		
		if (aCardDescrDataBean != null)
		{				
		$('#cardtextactionform_form_cardid_label').html('[' + aCardDescrDataBean.dataBean.cardid + ']');
		$('#cardtextactionform_form_title').val(aCardDescrDataBean.dataBean.title);			
		$('#cardtextactionform_form_summary').val(aCardDescrDataBean.dataBean.summary);
		$( '#cardtextactionform_form_textbody' ).val( aCardDescrDataBean.dataBean.textbody );
		// CKEDITOR.instances.cardtextactionform_form_textbody.setData( aCardDescrDataBean.dataBean.textbody );
		}
		else
		{
			$('#cardtextactionform_form_title').val(null);			
			$('#cardtextactionform_form_summary').val(null);		
			$( '#cardtextactionform_form_textbody' ).val( "" );
			// CKEDITOR.instances.cardtextactionform_form_textbody.setData("");
		}
		
	}
		
});
