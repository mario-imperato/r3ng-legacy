$.r3Utils.namespace("org.r3.jsportlet.cmsconsole");


org.r3.jsportlet.cmsconsole.CardDetailActionFormView_TabCardFile = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, aCardDataBean)
	{
		var _self = this;
		
		this._super(anHtmlActionFormContainerId, anActionFormManager);

			// BOF Sezione: Prodotti			
		this.fileView = new org.r3.db.cms.cardproperty.CardPropertyQueryActionFormView(anHtmlActionFormContainerId, this.actionFormManager,
		{
				dataTableId : 'CardFileQueryActionFormView',
				showTemplateOnOpen: false,
				htmlTemplateUrl: org.r3.Constants.applicationContext + "/org/r3/jsportlet/cmsconsole/CardDetailActionFormView_TabCardFile.html",
				// layout : 'fullWidth',
				gradeLevel : 'grade_level1',
				legend : org.r3.jsportlet.cmsconsole.message.cardfileactionform_form_legend,
				dataTableSource: org.r3.PageManager.getRESTUrl('GET_CardFiles', [ aCardDataBean.dataBean.cardid ]),
				
				// pannello con l'identificativo del gruppo
				// onInitializationComplete : $.unepUtils.hitch(this,
				// this.populateRiepilogo),
				dataTableColumns : "propertyid,propertytypecode,propertyname,propertyrole,contenttype,propertysize,imagesize,iconsize",
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
			               rules: org.r3.jsportlet.cmsconsole.cardfileactionform_form_validationRules,
				           messages: org.r3.jsportlet.cmsconsole.cardfileactionform_form_validationMessages    
			        });
					
					$('#cardfileactionform_fieldset_message').formmessage({});
					$('#cardfileactionform_form_cardid_label').html('[' + aCardDataBean.dataBean.cardid + ']');

					console.info("SaveItem: ", $('#cardfileactionform_action_saveitem'));
					$('#cardfileactionform_action_saveitem').unbind().click($.r3Utils.hitch(_self, _self.updateProperty));
					$('#cardfileactionform_action_cancel').unbind().click(function(e) { org.r3.PageManager.back(); });		
					$('#cardfileactionform_action_ctlcurl').unbind().click(function(e) {
						window.prompt ("Per copiare premere i tasti Ctrl+C e successivamente Invio", $('#cardfileactionform_form_url').html());
					});
									
				})
			});
			
			this.fileView.open();			
		},
			
	    propertyDetail: function(aCardPropertyAdapterDTO)
	    {
	    	$('#cardfileactionform_form_propertyid').attr('value', aCardPropertyAdapterDTO.dataBean.propertyid);
	    	$('#cardfileactionform_form_propertytypecode').attr('value', aCardPropertyAdapterDTO.dataBean.propertytypecode);
	    	
            this.showDetail(aCardPropertyAdapterDTO);            

        	$('#cardfileactionform_form_propertyname').val(aCardPropertyAdapterDTO.dataBean.propertyname);
        	
        	var s = aCardPropertyAdapterDTO.dataBean.contenttype + ' - ' + aCardPropertyAdapterDTO.dataBean.propertysize;
        	$('#cardfileactionform_form_propertytypesize').html(s);

            $('#cardfileactionform_form_propertyvalue').html(aCardPropertyAdapterDTO.dataBean.propertyvalue);
		    $('#cardfileactionform_form_propertyvalue').unbind().click(function(e) {
			    org.r3.PageManager.viewDocument(aCardPropertyAdapterDTO.dataBean.propertyvalue);
		    });    
		    $('#cardfileactionform_form_url').html($.r3Utils.formatDMSUrl4ClientAccess(aCardPropertyAdapterDTO.dataBean.propertyvalue));
		    
		    var iconUrl = org.r3.Constants.cms_default_icon;
	    	if (aCardPropertyAdapterDTO.isImage())
	    	{	        				    
	        	if (aCardPropertyAdapterDTO.hasIcon())
	        	{
	        		iconUrl = aCardPropertyAdapterDTO.dataBean.iconurl;		        	
	        	}	        	
	    	}
	    	
        	org.r3.PageManager.loadImage(iconUrl, {maxWidth: 100, maxHeight: 100}, function(img) {
        		$('#cardfileactionform_form_icon').html(img);
        	});		        	
	    	
	    },

	    refresh: function()
	    {
	    	this.fileView.refresh();
	    },
	    
	    propertyDelete: function()
	    {    	
			if (org.r3.PageManager.confirmation("org.r3.message.deleteconfirm"))
			{
               	this.hideDetail();
	    	    var selectedItem = this.fileView.fnGetSelectedDataBean();
			    this.actionFormManager.deleteProperty(selectedItem, $.r3Utils.hitch(this, function(e) 
			    {		    	
			    	this.actionFormManager.refresh();		    	
			    }));
			}	    	    
	    },

	    updateProperty: function()
	    {    	
	    	console.log("Whatever: ", this);	    		    	
		    this.actionFormManager.updateFileProperty($('#cardfileactionform_form_propertyid').val(), $.r3Utils.hitch(this, function(e) 
		    {		    	
		    	this.actionFormManager.refresh();		    	
		    }));	    	    
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
