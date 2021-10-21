$.r3Utils.namespace("org.r3.jsportlet.mongocms");


org.r3.jsportlet.mongocms.CardDetailActionFormView_TabPublishing = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, aCardDataBean, siteProperties)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.postDataBean = aCardDataBean;
		
		$('#cardpublishingactionform_form .r3_datepicker').datepicker({
			format: "dd/mm/yyyy"
		});
				
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : org.r3.PageManager.getRESTUrl('LUT_Timelines'),
			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
			"selectWidget" : $('#cardpublishingactionform_timeline'),
			"selectedValue": aCardDataBean && aCardDataBean.dataBean.timeline
		});
		
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : org.r3.PageManager.getRESTUrl('GET_classifier_contentclassgrp'),
			"selectWidget" : $('#cardpublishingactionform_contentclassgrp'),
			"selectedValue": aCardDataBean && aCardDataBean.getGroupsAsArray(),
			"onComplete": function() { $('#cardpublishingactionform_contentclassgrp').multiselect(); }
		});
		
		var property = null;
		if (siteProperties)
		{			
		    property = siteProperties.getPropertyByPropertyscopePropertykey("facebook.page.pub", "fbpagename");
		}
		
		if (property)
		{
			$('.facebook_publishing').show();
			$('#cardpublishingactionform_facebookpub_btrue').prop('checked', true);
			$('.facebook_publishing .facebookpub_targetpage').html(property.dataBean.propertyvalue);				
		}
		else 
		{
			$('#cardpublishingactionform_facebookpub_btrue').prop('checked', false);
			$('.facebook_publishing').hide();
		}
		
		var resolvedUrl = null; 
											
		$('#cardpublishingactionform_authoricon').attr('src', aCardDataBean.getAuthorImgUrl());
		$('#cardpublishingactionform_authorname').html(aCardDataBean.dataBean.authorname);										
		$('#cardpublishingactionform_refdate').html(aCardDataBean.getLastmodifiedAsElapsed() + ' - ' + aCardDataBean.getLastmodified());
		
		var saveButton = $('#cardpublishingactionform_action_saveitem');
		var pubButton = $('#cardpublishingactionform_action_publish');
		pubButton.unbind().click($.r3Utils.hitch(this, this.updateItem));
		saveButton.unbind().click($.r3Utils.hitch(this, this.updateItem));

		this.setupActionBar(aCardDataBean);
		
		$('#cardpublishingactionform_fieldset_message').formmessage({});

		// ignore: ':hidden:not("#userdetailactionform_form_ruoliesiti, #userdetailactionform_form_ruolipostaliz")'
		$('#cardpublishingactionform_form').validate
        ({
        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
               rules: org.r3.jsportlet.mongocms.cardpublishingactionform_validationRules,
	           messages: org.r3.jsportlet.mongocms.cardpublishingactionform_validationMessages	           
        });			

	},
	
	refresh: function()
	{		

	},
	
	setupActionBar: function(aCardDataBean)
	{
		var saveButton = $('#cardpublishingactionform_action_saveitem');
		var pubButton = $('#cardpublishingactionform_action_publish');

		if (aCardDataBean.isDraft())
		{			
			pubButton.show();
			saveButton.hide();
		}
		else 
		{
			pubButton.hide();
			saveButton.show();
		}
	},
	
	updateItem: function()
	{
		var _self = this;
		
		var method = "put";
		var theForm = $('#cardpublishingactionform_form');
		var idCard = this.postDataBean.dataBean.postid;
		var restUrl = org.r3.PageManager.getRESTUrl('PUT_PostPublish',  [ this.postDataBean.dataBean.site, org.r3.Constants.language, idCard ]);
		
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
						restDto.showMessage('cardpublishingactionform_fieldset_message');					
					}		
					else 
					{
						_self.postDataBean = new org.r3.db.mongo.postcollection.PostCollectionDTOAdapter(responseData);	
						_self.onPublishPost(_self.postDataBean);
						$('#cardpublishingactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });											
					}
		        }, 
				function(jqXHR, timeout, message) { 
					$('#cardpublishingactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
		        },
		        "org.r3.message.saveconfirm",
		        true
		);			
	},

	onPublishPost: function(aPostDataBean)
	{
    	this.actionFormManager.setDataBeanInfo(aPostDataBean);
     	this.setupActionBar(aPostDataBean);	    		 	    	
	}		
	
			
});
