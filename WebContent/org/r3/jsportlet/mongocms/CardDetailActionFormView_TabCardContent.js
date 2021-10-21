$.r3Utils.namespace("org.r3.jsportlet.mongocms");


org.r3.jsportlet.mongocms.CardDetailActionFormView_TabCardContent = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, aCardDataBean, aContentModelObject)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);		
		this.modelObject = aContentModelObject;
		var resolvedUrl = null; 
					    
		$('#cardcustomcontentactionform_cardid_label').html('[' + aCardDataBean.dataBean.postid + ']');
								
		$('#cardcustomcontentactionform_form_authoricon').attr('src', aCardDataBean.getAuthorImgUrl());
		$('#cardcustomcontentactionform_form_authorname').html(aCardDataBean.dataBean.authorname);
										
		$('#cardcustomcontentactionform_form_refdate').html(aCardDataBean.getLastmodifiedAsElapsed() + ' - ' + aCardDataBean.getLastmodified());
		
		this.modelObject.setupForm($.r3Utils.hitch(this, this.handleActions));
		this.modelObject.initializeForm({ targetnode_or_id : aCardDataBean });
		
		var photoConfigInfo = anActionFormManager._getPhotoGraphicContentDefinition(aCardDataBean);
		
		this.imageUploader = new org.r3.jsportlet.imageupload.ImageUploader(
		{
			img_selector: this.modelObject.displayPhoto,
			inputfile_selector: '#cardcustomcontentactionform_input_file',
			// overlay_selector : this.configOptions.imageCanvasIdHash + ' .overlay',
			// selectiontrigger_selector: this.configOptions.imageCanvasIdHash + ' .loadimage_canvas_selectiontrigger',
			modaldialog_selector : '#photo_dialog',
			aspect_ratio: photoConfigInfo.aspectratio,
			max_size: photoConfigInfo.maxsize,
			upload_url: org.r3.PageManager.getRESTUrl("POST_PostPhoto", [ aCardDataBean.dataBean.site, org.r3.Constants.language, aCardDataBean.dataBean.postid ]),
			current_image_url: false,
			extra_info: photoConfigInfo.extrainfo	
		});	
		
		this.imageUploader.setup();
	},
	
	refresh: function()
	{		

	},
	
	handleActions: function(e)
	{
		var target = $(e.target);
		var dataAction = target.attr('data-action');
		var dataActionTarget = target;
		var ps = null, cm = null;
		
		if (!dataAction)
		{
		   ps = target.parents('[data-action]');
		   if (ps.length > 0)
		   {
			   dataActionTarget = $(ps[0]); 
			   dataAction = dataActionTarget.attr('data-action');   
		   }			
		}
	
		if (dataAction != null)
		{
		   var dataActionPath = dataAction.split(':');
		   
		   switch(dataActionPath[0])
		   {
		   case 'primarypost-submit':
			   this.onSubmit();
			   break;
		   case 'image-selection':
			   $('#cardcustomcontentactionform_input_file').trigger('click');
			   break;
		   }
		}
		
		return true;
	},
		
	onSubmit : function()
	{
		var _self = this;
		
		var site = this.actionFormManager.dataBeanInfo.dataBean.site;
		var postId = this.actionFormManager.dataBeanInfo.dataBean.postid;	
		var theForm = this.modelObject.getForm();
		
		if (theForm.valid())
		{					
			this.modelObject.serializeContent();		    			
			org.r3.AjaxUtils.submitForm(
					"put", 
					org.r3.PageManager.getRESTUrl('PUT_PostContent_Detail', [ site, org.r3.Constants.language, postId ]),					 
					theForm, 
					function(responseData) 
					{
						_self.modelObject.showMessage({ text: org.r3.message.success, category: 'info' });											
					}, 
					function(jqXHR, timeout, message) 
					{
						console.log(arguments);
						_self.modelObject.showMessage({ text: message, category: 'error' });						
					}, 
					"org.r3.message.saveconfirm", 
					true);			
		}
	}
	
		
});
