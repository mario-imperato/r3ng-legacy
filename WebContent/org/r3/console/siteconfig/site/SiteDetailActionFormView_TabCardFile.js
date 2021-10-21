$.r3Utils.namespace("org.r3.console.siteconfig.site");


org.r3.console.siteconfig.site.SiteDetailActionFormView_TabCardFile = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, aSiteDataBean)
	{
		var _self = this;
		
		this._super(anHtmlActionFormContainerId, anActionFormManager);

		this.siteCardId = aSiteDataBean.dataBean.cardid;
		
			// BOF Sezione: Prodotti			
		this.fileView = new org.r3.db.cms.cardproperty.CardPropertyQueryActionFormView(anHtmlActionFormContainerId, this.actionFormManager,
		{
				dataTableId : 'CardSiteFileQueryActionFormView',
				showTemplateOnOpen: false,
				htmlTemplateUrl: org.r3.Constants.applicationContext + "/org/r3/console/siteconfig/site/SiteDetailActionFormView_TabCardFile.html.jsp",
				// layout : 'fullWidth',
				gradeLevel : 'grade_level1',
				legend : org.r3.console.siteconfig.site.message.siteDetailActionForm_tab_cardfile,
				dataTableSource: org.r3.PageManager.getRESTUrl('GET_CardFiles', [ aSiteDataBean.dataBean.cardid ]),
				
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
					onClick : $.r3Utils.hitch(this, this._onUploadFile)
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

					$('#sitefileactionform_form').validate
			        ({
			        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
			               rules: org.r3.console.siteconfig.sitefileactionform_form_validationRules,
				           messages: org.r3.console.siteconfig.sitefileactionform_form_validationMessages    
			        });
					
					$('#sitefileactionform_fieldset_message').formmessage({});
					$('#sitefileactionform_form_cardid_label').html('[' + _self.siteCardId + ']');

					$('#sitefileactionform_action_saveitem').unbind().click($.r3Utils.hitch(_self, _self.updateProperty));
							
					$('#sitefileactionform_action_ctlcurl').unbind().click(function(e) {
						window.prompt ("Per copiare premere i tasti Ctrl+C e successivamente Invio", $('#sitefileactionform_form_url').html());
					});
									
				})
			});
			
			this.fileView.open();			
		},
			
	    propertyDetail: function(aCardPropertyAdapterDTO)
	    {
	    	$('#sitefileactionform_form_propertyid').attr('value', aCardPropertyAdapterDTO.dataBean.propertyid);
	    	$('#sitefileactionform_form_propertytypecode').attr('value', aCardPropertyAdapterDTO.dataBean.propertytypecode);
	    	
            this.showDetail(aCardPropertyAdapterDTO);            

        	$('#sitefileactionform_form_propertyname').val(aCardPropertyAdapterDTO.dataBean.propertyname);
        	
        	var s = aCardPropertyAdapterDTO.dataBean.contenttype + ' - ' + aCardPropertyAdapterDTO.dataBean.propertysize;
        	$('#sitefileactionform_form_propertytypesize').html(s);

            $('#sitefileactionform_form_propertyvalue').html(aCardPropertyAdapterDTO.dataBean.propertyvalue);
		    $('#sitefileactionform_form_propertyvalue').unbind().click(function(e) {
			    org.r3.PageManager.viewDocument(aCardPropertyAdapterDTO.dataBean.propertyvalue);
		    });    
		    $('#sitefileactionform_form_url').html($.r3Utils.formatDMSUrl4ClientAccess(aCardPropertyAdapterDTO.dataBean.propertyvalue));
		    
		    var iconUrl = org.r3.Constants.cms_default_icon;
	    	if (aCardPropertyAdapterDTO.isImage())
	    	{	        				    
	        	if (aCardPropertyAdapterDTO.hasIcon())
	        	{
	        		iconUrl = aCardPropertyAdapterDTO.dataBean.iconurl;		        	
	        	}	        	
	    	}
	    	
        	org.r3.PageManager.loadImage(iconUrl, {maxWidth: 100, maxHeight: 100}, function(img) {
        		$('#sitefileactionform_form_icon').html(img);
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
		    this.actionFormManager.updateFileProperty(this.siteCardId, $('#sitefileactionform_form_propertyid').val(), $.r3Utils.hitch(this, function(e) 
		    {		    	
		    	this.actionFormManager.refresh();		    	
		    }));	    	    
	    },

	    hideDetail: function()
	    {
	    	$('#sitefileactionform_action_bar').hide();
	    	$('#sitefileactionform_detail_container').hide();	    		
	    },
	    
	    showDetail: function(aCardPropertyAdapterDTO)
	    {
	    	$('#sitefileactionform_fieldset_message').formmessage('clear');
	    	$('#sitefileactionform_detail_container').show();	    		    	
	    	$('#sitefileactionform_action_bar').show();
	    },
	    
	    _onUploadFile: function()
	    {
	    	this.actionFormManager.uploadFile(this.siteCardId);
	    }
					
});
