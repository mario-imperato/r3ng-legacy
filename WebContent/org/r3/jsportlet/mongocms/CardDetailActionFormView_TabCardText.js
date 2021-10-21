$.r3Utils.namespace("org.r3.jsportlet.mongocms");


org.r3.jsportlet.mongocms.CardDetailActionFormView_TabCardText = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, aCardDataBean)
	{
		var _self = this;
		
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.postDataBean = aCardDataBean;
		
		$('#cardtextactionform_fieldset_message').formmessage({});
		$('#cardtextactionform_form_languagecode').unbind().change(function(e) 
		{
			var currentTarget = $(e.currentTarget);
			var l = currentTarget.val();
			
			_self.initializeFields(_self.postDataBean, l);
		});
		
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : org.r3.PageManager.getRESTUrl('GET_classifier_locale'),
			// "blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
			"selectWidget" : $('#cardtextactionform_form_languagecode'),
			"selectedValue": org.r3.Constants.language
		});
		
		var ckeditor_uploadfile_resturl = org.r3.PageManager.getRESTUrl('POST_PostCKEditorImageAttachment', 
				[ aCardDataBean.dataBean.site, org.r3.Constants.language, aCardDataBean.dataBean.postid, "upload", "imgshkmessage" ]);
		 
		$('#cardtextactionform_form_textbody').ckeditor({
			extraPlugins : 'uploadimage',
			uploadUrl : ckeditor_uploadfile_resturl,
			imageUploadUrl: ckeditor_uploadfile_resturl
		});
		
	    // CKEDITOR.replace( 'cardtextactionform_form_textbody' );
	    
		this.initializeFields(this.postDataBean, org.r3.Constants.language);

		$('#cardtextactionform_action_saveitem').unbind().click($.r3Utils.hitch(this, this.updateItem));	
		
		$('#cardtextactionform_action_cancel').click(function(e) { org.r3.PageManager.back(); });								

		// ignore: ':hidden:not("#userdetailactionform_form_ruoliesiti, #userdetailactionform_form_ruolipostaliz")'
		$('#cardtextactionform_form').validate
        ({
        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
               rules: org.r3.jsportlet.mongocms.cardtextactionform_form_validationRules,
	           messages: org.r3.jsportlet.mongocms.cardtextactionform_form_validationMessages	           
        });			

	},
	
	updateItem: function()
	{
		var _self = this;
		
		var method = "put";
		var theForm = $('#cardtextactionform_form');
		var idCard = this.postDataBean.dataBean.postid;
		var restUrl = org.r3.PageManager.getRESTUrl('PUT_PostTextBody_Detail',  [ this.postDataBean.dataBean.site, org.r3.Constants.language, idCard, $('#cardtextactionform_form_languagecode').val() ]);
		
		// this.actionFormManager.updateCardDescr4Language($('#cardtextactionform_form_languagecode').val());
		
		org.r3.AjaxUtils.submitForm(
				method,
				restUrl,
				theForm,
				function(responseData) 
				{ 
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('cardtextactionform_fieldset_message');					
					}		
					else 
					{
						_self.postDataBean = new org.r3.db.mongo.postcollection.PostCollectionDTOAdapter(responseData);	
						$('#cardtextactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });											
					}
		        }, 
				function(jqXHR, timeout, message) { 
					$('#cardtextactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
		        },
		        "org.r3.message.saveconfirm",
		        true
		);			
	},
	
	initializeFields: function(aCardDataBean, aLanguageCode)
	{
		$('#cardtextactionform_fieldset_message').formmessage('clear');
		
		if (aCardDataBean != null)
		{
			$('#cardtextactionform_form_cardid_label').html('[' + aCardDataBean.dataBean.postid + ']');				
		
			var aCardDescrDataBean = aCardDataBean.getTextBody4Language(aLanguageCode);
			if (aCardDescrDataBean != null)
			{				
				$('#cardtextactionform_form_title').val(aCardDescrDataBean.dataBean.title);			
				$('#cardtextactionform_form_summary').val(aCardDescrDataBean.dataBean.summary);
				$( '#cardtextactionform_form_textbody' ).val( aCardDescrDataBean.dataBean.body );
			}
			else
			{
				this._clearFields(); 
			}	
		}
		else
		{
			this._clearFields(); 			
		}
		
		$('#cardtextactionform_authoricon').attr('src', aCardDataBean.getAuthorImgUrl());
		$('#cardtextactionform_authorname').html(aCardDataBean.dataBean.authorname);
						
		// /was/shkneighb1/it/userscollection/" +  userCollectionDTO.getUserid() + "/photo;photorole=icon
		
		$('#cardtextactionform_refdate').html(aCardDataBean.getLastmodifiedAsElapsed() + ' - ' + aCardDataBean.getLastmodified());		
	},
	
	_clearFields: function()
	{
		$('#cardtextactionform_form_title').val(null);			
		$('#cardtextactionform_form_summary').val(null);		
		$( '#cardtextactionform_form_textbody' ).val( "" );	
	}
	

		
});
