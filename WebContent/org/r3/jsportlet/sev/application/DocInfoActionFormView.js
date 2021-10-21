$.r3Utils.namespace("org.r3.jsportlet.sev.application");


org.r3.jsportlet.sev.application.DocInfoActionFormView  = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		var _self = this;
		
		this._super(anHtmlActionFormContainerId, anActionFormManager);

		this.documentView = new org.r3.db.sailevent.appdocument.SailApplicationDocumentQueryActionFormView(anHtmlActionFormContainerId, this.actionFormManager,
		{
			dataTableId : 'SailApplicationDocumentQueryActionFormView',
			showTemplateOnOpen : false,
			htmlTemplateUrl : org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/application/DocInfoActionFormView.html.jsp',
			// layout : 'fullWidth',
			iDisplayLength: -1,
			gradeLevel : 'grade_level1',
			legend : 'Equipaggio',
			// dataTableSource : org.r3.PageManager.getRESTUrl('GET_CardFiles', [ aCardDataBean.dataBean.cardid ]),

			// pannello con l'identificativo del gruppo
			// onInitializationComplete : $.unepUtils.hitch(this,
			// this.populateRiepilogo),
			dataTableColumns : "documentid,documenttypecode,documentname",
			requiredLUTs : [ "GET_classifier_sys_recstatus", "GET_classifier_r3ea_doctype" ],

			onSelected : $.r3Utils.hitch(this, function(aDocumentDTOAdapter)
			{
				$('#docinfo_deleteItem').prop('disabled', false);
				// this.propertyDetail(aCrewMemberDTOAdapter);
			}),

			onDblClick : $.r3Utils.hitch(this, function(aDocumentDTOAdapter)
			{
				org.r3.PageManager.viewDocument(aDocumentDTOAdapter.dataBean.documenturl);
				$('#docinfo_deleteItem').prop('disabled', true);
			}),
			
			buttons : [
            {
	            id : 'docinfo_uploadItem',
	            label : 'Nuovo',
	            disabled : false,
	            onClick : $.r3Utils.hitch(this, this.onDocumentUpload)
            },			           
			{
				id : 'docinfo_deleteItem',
				label : 'Elimina',
				disabled : true,
				onClick : $.r3Utils.hitch(this, this.onDocumentDelete)
			} ],

			onClearSelection : function()
			{
				$('#docinfo_deleteItem').prop('disabled', true);
			},

			onInitializationComplete : $.r3Utils.hitch(this, function(anApplicationDTOAdapter, wizardActions, showOnLoad)
			{
				$("#docinfoform_form").validate
	            ({
		        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
		               rules: org.r3.jsportlet.sev.application.docinfoform_form_validationRules,
			           messages: org.r3.jsportlet.sev.application.docinfoform_form_validationMessages    
		        });
				
				_self._initializeFormFields(anApplicationDTOAdapter);
							
				$('#docinfoform_action_next').unbind();
			    $('#docinfoform_action_prev').unbind();
				if (wizardActions && wizardActions.indexOf('next') >= 0)
				{
	 			      $('#docinfoform_action_next').show().click($.r3Utils.hitch(_self, _self.onNextClick));	
				}
				else  $('#docinfoform_action_next').hide();
				
				if (wizardActions && wizardActions.indexOf('prev') >= 0)
				{
	 			      $('#docinfoform_action_prev').show().click($.r3Utils.hitch(_self, _self.onPrevClick));	
				}
				else  $('#docinfoform_action_prev').hide();		
				
				$('#docinfoform_fieldset_message').formmessage({});
				
				if (showOnLoad)
					_self.activate();

				// $('#cardfileactionform_action_saveitem').unbind().click($.r3Utils.hitch(_self, _self.updateProperty));
			})
		});
	},

	close : function()
	{
		this.hide();
	},

	refresh: function()
	{
		this.documentView.refresh();
	},
	
	open : function(anApplicationDTOAdapter, wizardActions, showOnLoad)
	{
		var dataTableSource = org.r3.PageManager.getRESTUrl('GET_SEV_Application_Documents', [ anApplicationDTOAdapter.dataBean.applicationid ]);
		
		this.documentView.open({
				"dataTableSource": dataTableSource,
				"onInitializationCompleteArgs": arguments
		});
	},
	
	_initializeFormFields: function(anApplicationDTOAdapter)
	{
		$('#docinfoform_applicationid'           ).html(anApplicationDTOAdapter.dataBean.applicationid); 										
	},
	
	activate: function()
	{
		this.actionFormManager.showHelp("HLP_SEVDOCINFO");
		this.show();
	},
	
	onNextClick: function()
	{
		this.actionFormManager.updateDocInfo("next");		
	},
		
	onPrevClick: function()
	{	
		this.actionFormManager.updateDocInfo("prev");		
	},
	
	onDocumentUpload: function()
	{
		this.hide();
		this.actionFormManager.openDocumentUpload();
	},

	onDocumentDelete: function(aDocumentDTOAdapter)
	{
		if (org.r3.PageManager.confirmation("org.r3.message.deleteconfirm"))
		{           	
    	    var selectedItem = this.documentView.fnGetSelectedDataBean();
    	    this.actionFormManager.deleteDocument(selectedItem);
		}	    	    
		
	}

});
