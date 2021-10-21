$.r3Utils.namespace("org.r3.jsportlet.mongocms");


org.r3.jsportlet.mongocms.CardDetailActionFormView_TabCardFile = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, aCardDataBean)
	{
		var _self = this;
		
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.postDTOAdapter = aCardDataBean;
		
		this.fileView = new org.r3.db.mongo.MongoFileAttachmentQueryActionFormView(anHtmlActionFormContainerId, this.actionFormManager,
		{
				dataTableId : 'MongoFileAttachmentQueryActionFormView',
				showTemplateOnOpen: false,
				htmlTemplateUrl: org.r3.Constants.applicationContext + "/org/r3/jsportlet/mongocms/CardDetailActionFormView_TabCardFile.html",
				// layout : 'fullWidth',
				gradeLevel : 'grade_level1',
				legend : org.r3.jsportlet.mongocms.message.cardfileactionform_form_legend,
				dataTableSource: org.r3.PageManager.getRESTUrl('GET_PostFileAttachments', [ aCardDataBean.dataBean.site, org.r3.Constants.language, aCardDataBean.dataBean.postid ]),
				
				// pannello con l'identificativo del gruppo
				// onInitializationComplete : $.unepUtils.hitch(this,
				// this.populateRiepilogo),
				dataTableColumns : "fileid,attachmenttype,name,ctype",
				requiredLUTs : [ "GET_classifier_sys_recstatus" ],

				onSelected : $.r3Utils.hitch(this, function(aCardPropertyDTOAdapter) { 
					$('#tabfile_deleteItem').prop('disabled', false);
					this.propertyDetail(aCardPropertyDTOAdapter);
				}),
				
				onDblClick : null,

				buttons : [
				{
					id : 'tabfile_uploadfile',
					label : org.r3.message.action_upload,
					disabled : false,
					onClick : $.r3Utils.hitch(this.actionFormManager, this.actionFormManager.uploadFile)
				},

				{
					id : 'tabfile_deleteItem',
					label : org.r3.message.action_delete,
					disabled : true,
					onClick : $.r3Utils.hitch(this, this.propertyDelete)
				}
				],
				
				onClearSelection : function() { 
					$('#tabfile_deleteItem').prop('disabled', true);
				},
				
				onInitializationComplete: $.r3Utils.hitch(this, function() {

					$('#cardfileactionform_form').validate
			        ({
			        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
			               rules: org.r3.jsportlet.mongocms.cardfileactionform_form_validationRules,
				           messages: org.r3.jsportlet.mongocms.cardfileactionform_form_validationMessages    
			        });
					
					$('#cardfileactionform_fieldset_message').formmessage({});

					$('#cardfileactionform_authoricon').attr('src', aCardDataBean.getAuthorImgUrl());
					$('#cardfileactionform_authorname').html(aCardDataBean.dataBean.authorname);								
					$('#cardfileactionform_refdate').html(aCardDataBean.getLastmodifiedAsElapsed() + ' - ' + aCardDataBean.getLastmodified());	
					$('#cardfileactionform_cardid_label').html('[' + aCardDataBean.dataBean.postid + ']');

					console.info("SaveItem: ", $('#cardfileactionform_action_saveitem'));
					$('#cardfileactionform_action_saveitem').unbind().click($.r3Utils.hitch(_self, _self.updateProperty));
					$('#cardfileactionform_action_cancel').unbind().click(function(e) { org.r3.PageManager.back(); });		
					$('#cardfileactionform_action_ctlcurl').unbind().click(function(e) {
						window.prompt ("Per copiare premere i tasti Ctrl+C e successivamente Invio", $('#cardfileactionform_url').html());
					});
									
				})
			});
			
			this.fileView.open();			
		},
			
	    propertyDetail: function(aCardPropertyAdapterDTO)
	    {
	    	$('#cardfileactionform_fileid').attr('value', aCardPropertyAdapterDTO.dataBean.fileid);
	    	$('#cardfileactionform_attachmenttype').attr('value', aCardPropertyAdapterDTO.dataBean.attachmenttype);
	    	
            this.showDetail(aCardPropertyAdapterDTO);            

        	$('#cardfileactionform_name').val(aCardPropertyAdapterDTO.dataBean.name);
        	
        	var s = aCardPropertyAdapterDTO.dataBean.ctype + ' - ' + aCardPropertyAdapterDTO.dataBean.size;
        	$('#cardfileactionform_ctypesize').html(s);

            $('#cardfileactionform_value').html(aCardPropertyAdapterDTO.dataBean.url);
		    $('#cardfileactionform_url').unbind().click(function(e) 
		    {
			    org.r3.PageManager.viewDocument($.r3Utils.formatDMSUrl4ClientAccess(aCardPropertyAdapterDTO.dataBean.url));			    
		    });    
		    $('#cardfileactionform_url').html($.r3Utils.formatDMSUrl4ClientAccess(aCardPropertyAdapterDTO.dataBean.url));
		    
		    var iconUrl = org.r3.Constants.cms_default_icon; 				    
	        if (aCardPropertyAdapterDTO.hasIcon())
	        {
	        	iconUrl = $.r3Utils.formatDMSUrl4ClientAccess(aCardPropertyAdapterDTO.getIcon().dataBean.url);		        	
	        }	        		   
	    	
        	org.r3.PageManager.loadImage(iconUrl, {maxWidth: 100, maxHeight: 100}, function(img) {
        		$('#cardfileactionform_icon').html(img);
        	});		        	
	    	
	    },

	    refresh: function()
	    {
	    	this.fileView.refresh();
	    },
	    
	    propertyDelete: function()
	    {    	
	    	var _self = this;
	    	
	    	this.hideDetail();
    	    var selectedItem = this.fileView.fnGetSelectedDataBean();
		        	    
	    	var cardId = this.postDTOAdapter.dataBean.postid;
			var attachmentId = selectedItem.dataBean.fileid;
			
			org.r3.AjaxUtils.ajaxInvoke(
					'delete', 
					org.r3.PageManager.getRESTUrl('DELETE_PostFileAttachment', [ this.postDTOAdapter.dataBean.site, org.r3.Constants.language, cardId, attachmentId ]),
					function(responseData)
					{
						_self.actionFormManager.refresh();	
					},
					false,
					"org.r3.message.deleteconfirm",
					true
			);	
			   	    
	    },

	    updateProperty: function()
	    {    	
	    	var _self = this;
	    	
	    	var cardId = this.postDTOAdapter.dataBean.postid;
			var attachmentId = $('#cardfileactionform_fileid').val();
			
	    	org.r3.AjaxUtils.submitForm(
					'put', 
					org.r3.PageManager.getRESTUrl('PUT_PostFileAttachment', [ this.postDTOAdapter.dataBean.site, org.r3.Constants.language, cardId, attachmentId ]),
					$('#cardfileactionform_form'),
					function(responseData)
					{
						_self.actionFormManager.refresh();	
					},
					false,
					"org.r3.message.saveconfirm",
					true
			);		    	    	    
	    },

	    hideDetail: function()
	    {
	    	$('#cardfileactionform_action_bar').hide();
	    	$('#cardfileactionform_detail_container').hide();	    		
	    },
	    
	    showDetail: function(aCardPropertyAdapterDTO)
	    {
	    	$('#cardfileactionform_fieldset_message').formmessage('clear');
	    	$('#cardfileactionform_detail_container').show();	    		    	
	    	$('#cardfileactionform_action_bar').show();
	    }	    
					
});
