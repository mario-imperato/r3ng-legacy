$.r3Utils.namespace("org.r3.jsportlet.mongocms");


org.r3.jsportlet.mongocms.CardDetailActionFormView_TabGenerale = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, aCardDataBean)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		
		$('#carddetailactionform_form .r3_datepicker').datepicker({
			format: "dd/mm/yyyy"
		});
		
//		org.r3.PageManager.lutManager.populateSelectField(
//		{
//			"lutUrl" : org.r3.PageManager.getRESTUrl('GET_classifier_contentclassdef'),
//			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
//			"selectWidget" : $('#carddetailactionform_form_contentclass'),
//			"selectedValue": aCardDataBean && aCardDataBean.dataBean.contentclass,
//			"clientFilter": function(item) { return item.primary ? true : false; }
//		});

        $('#carddetailactionform_contenttype_cascade select').cascadingSelect({
	      	   lutManager : org.r3.PageManager.lutManager,
	      	   ajaxUrlMode: 'restful',
	      	   withNullOption: true,
	      	   widgetConfig: [
	      	      { 'widgetId': 'carddetailactionform_form_contentcategory', 
	      	    	'ajaxSource': org.r3.PageManager.getRESTUrl('GET_classifier_m_contentclass_category'),
	      	    	'value': aCardDataBean && aCardDataBean.dataBean.contentcategory 
	      	      },
	      	    	
	      	      { 'widgetId': 'carddetailactionform_form_contentclass' , 
	      	    	'ajaxSource': org.r3.PageManager.getRESTUrl('GET_classifier_m_contentclass_contentclassdef'), 
	      	    	'value':  aCardDataBean && aCardDataBean.dataBean.contentclass
	      	      }
	      	   ]
	    });
        
//		org.r3.PageManager.lutManager.populateSelectField(
//		{
//			"lutUrl" : org.r3.PageManager.getRESTUrl('LUT_Timelines'),
//			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
//			"selectWidget" : $('#carddetailactionform_timeline'),
//			"selectedValue": aCardDataBean && aCardDataBean.dataBean.timeline
//		});
//		
//		org.r3.PageManager.lutManager.populateSelectField(
//		{
//			"lutUrl" : org.r3.PageManager.getRESTUrl('GET_classifier_contentclassgrp'),
//			"selectWidget" : $('#carddetailactionform_contentclassgrp'),
//			"selectedValue": aCardDataBean && aCardDataBean.getGroupsAsArray(),
//			"onComplete": function() { $('#carddetailactionform_contentclassgrp').multiselect(); }
//		});
		
		if (aCardDataBean == null)
		{				
			$('#carddetailactionform_action_saveitem').unbind().click($.r3Utils.hitch(this, this.createItem));
			// $('#carddetailactionform_action_openchangepasswd').hide();
			
			$('.hideOnNewItem').hide();
			$('#carddetailactionform_form_authoricon').attr('src', org.r3.SiteConstants.getSiteCollectionIconUrl());			
			$('#carddetailactionform_form_authorname').html(org.r3.SiteConstants.targetSiteName);
			
			$('#carddetailactionform_author').val(org.r3.Constants.site);
			$('#carddetailactionform_authorname').val(org.r3.SiteConstants.targetSiteName);
			$('#carddetailactionform_authortype').val('neighborhood');
			
			$('#carddetailactionform_action_delete').hide();	
							
		}
		else
		{			
			var resolvedUrl = null; 
			
			$('#carddetailactionform_form_cardid_label').html('[' + aCardDataBean.dataBean.postid + ']');
			
			$('#carddetailactionform_form_postid').val(aCardDataBean.dataBean.postid);
			$('#carddetailactionform_form_postid').prop('disabled', true);

			$('#carddetailactionform_form_contentcategory').prop('disabled', true);
			$('#carddetailactionform_form_contentclass').prop('disabled', true);

			$('.hideOnNewItem').show();
			
			$('#carddetailactionform_form_title').val(aCardDataBean.dataBean.title);
						
			$('#carddetailactionform_form_authoricon').attr('src', aCardDataBean.getAuthorImgUrl());
			$('#carddetailactionform_form_authorname').html(aCardDataBean.dataBean.authorname);
							
			// /was/shkneighb1/it/userscollection/" +  userCollectionDTO.getUserid() + "/photo;photorole=icon
			
			$('#carddetailactionform_form_refdate').html(aCardDataBean.getLastmodifiedAsElapsed() + ' - ' + aCardDataBean.getLastmodified());
			
			$('#carddetailactionform_action_saveitem').unbind().click($.r3Utils.hitch(this, this.updateItem));
			$('#carddetailactionform_action_delete').unbind().click($.r3Utils.hitch(this.actionFormManager, this.actionFormManager.deleteItem));			
			$('#carddetailactionform_action_delete').show();	
			


		}
				
		$('#carddetailactionform_action_cancel').click($.r3Utils.hitch(this.actionFormManager, this.actionFormManager.closeCardPanel));						
		$('#carddetailactionform_fieldset_message').formmessage({});

		// ignore: ':hidden:not("#userdetailactionform_form_ruoliesiti, #userdetailactionform_form_ruolipostaliz")'
		$('#carddetailactionform_form').validate
        ({
        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
               rules: org.r3.jsportlet.mongocms.carddetailactionform_form_validationRules,
	           messages: org.r3.jsportlet.mongocms.carddetailactionform_form_validationMessages	           
        });			

	},
	
	refresh: function()
	{		

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
		var _self = this;
		
		var theForm = $('#carddetailactionform_form');
		var method = "post";
		var restUrl = org.r3.PageManager.getRESTUrl('POST_AddPost', [ org.r3.Constants.site, org.r3.Constants.language ]);
		if (isUpdate)
		{
			var idCard = this.actionFormManager.dataBeanInfo.dataBean.postid;
			restUrl = org.r3.PageManager.getRESTUrl('PUT_PostGeneralInfo_Detail', [ this.actionFormManager.dataBeanInfo.dataBean.site, org.r3.Constants.language, idCard ]);
			method = "put";
		}
		
		org.r3.AjaxUtils.submitForm(
			method, 
			restUrl,					 
			theForm, 
			function(responseData) 
			{
				if (org.r3.PageManager.isRestDTO(responseData))
				{
					var restDto = new org.r3.RestDTOAdapter(responseData);
					restDto.showMessage('carddetailactionform_fieldset_message');
				}
				else 
				{
					if (isUpdate)
					{
						$('#carddetailactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });							
					}
					else
					{
						var pdb = new org.r3.db.mongo.postcollection.PostCollectionDTOAdapter(responseData);
						_self.actionFormManager.onNewCardCreated(pdb);						
					}
				}					
			}, 
			function(jqXHR, timeout, message) 
			{
				console.log(arguments);
				$('#carddetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
			}, 
			"org.r3.message.saveconfirm", 
			true
		);		
	
	}	
		
});
