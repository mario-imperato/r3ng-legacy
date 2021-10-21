$.r3Utils.namespace("org.r3.jsportlet.sev.application");


org.r3.jsportlet.sev.application.CrewInfoActionFormView  = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		var _self = this;
		
		this._super(anHtmlActionFormContainerId, anActionFormManager);

		// this.crewMemberView = new org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberQueryActionFormView(anHtmlActionFormContainerId, this.actionFormManager,
		this.crewMemberView = new org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewQueryActionFormView(anHtmlActionFormContainerId, this.actionFormManager,
		{
			dataTableId : 'SailApplicationCrewMemberQueryActionFormView',
			showTemplateOnOpen : false,
			htmlTemplateUrl : org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/application/CrewInfoActionFormView.html.jsp',
			// layout : 'fullWidth',
			gradeLevel : 'grade_level1',
			iDisplayLength: -1,
			legend : 'Equipaggio',
			// dataTableSource : org.r3.PageManager.getRESTUrl('GET_CardFiles', [ aCardDataBean.dataBean.cardid ]),

			// pannello con l'identificativo del gruppo
			// onInitializationComplete : $.unepUtils.hitch(this,
			// this.populateRiepilogo),
			dataTableColumns : "cardnumberstatuscode,cardnumber,crewmemberrolecode,crewmembername,renewaldate,medexamexpirationdate,memberstatuscode,numcoviddocs",
			requiredLUTs : [ "GET_classifier_r3ea_crewrole", "GET_classifier_r3ea_crewstatus" ],

			onSelected : $.r3Utils.hitch(this, function(aCrewMemberDTOAdapter)
			{
				$('#crewinfo_deleteItem').prop('disabled', false);				
				this.crewMemberDetail(aCrewMemberDTOAdapter);
			}),

			onDblClick : $.r3Utils.hitch(this, function(aCrewMemberDTOAdapter)
			{
				$('#crewinfo_deleteItem').prop('disabled', true);		
			}),

			buttons : [
			{
				id : 'crewinfo_deleteItem',
				label : 'Elimina',
				disabled : true,
				onClick : $.r3Utils.hitch(this, this.crewMemberDelete)
			}],

			onClearSelection : function()
			{
				$('#crewinfo_deleteItem').prop('disabled', true);
			},

			onInitializationComplete : $.r3Utils.hitch(this, function(anApplicationDTOAdapter, wizardActions, showOnLoad)
			{
				$("#crewinfoform_form").validate
	            ({
		        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
		               rules: org.r3.jsportlet.sev.application.crewinfoform_form_validationRules,
			           messages: org.r3.jsportlet.sev.application.crewinfoform_form_validationMessages    
		        });
				
				 $('#crewinfoform_crewcovidurl_link').unbind().click(function(e) {					    
					    var w = window.open($('#crewinfoform_crewcovidurl').val(), "Document_Window");
					    w.focus();
				});
				 
				_self._initializeFormFields(anApplicationDTOAdapter);
			
				$('#crewinfoform_action_uloadinfo').unbind().click($.r3Utils.hitch(_self, _self.onDocumentUpload));
				$('#crewinfoform_action_uloadinfo').prop('disabled', true);	
				
				$('#crewinfoform_action_save').unbind().click($.r3Utils.hitch(_self, _self.onSaveItem));
				$('#crewinfoform_action_clear').unbind().click($.r3Utils.hitch(_self, function(e) {
				        $('#crewinfoform_form').resetForm();
				        $('#crewinfoform_crewmemberid').val("");
				}));
				
				$('#crewinfoform_action_next').unbind();
			    $('#crewinfoform_action_prev').unbind();
				if (wizardActions && wizardActions.indexOf('next') >= 0)
				{
	 			      $('#crewinfoform_action_next').show().click($.r3Utils.hitch(_self, _self.onNextClick));	
				}
				else  $('#crewinfoform_action_next').hide();
				
				if (wizardActions && wizardActions.indexOf('prev') >= 0)
				{
	 			      $('#crewinfoform_action_prev').show().click($.r3Utils.hitch(_self, _self.onPrevClick));	
				}
				else  $('#crewinfoform_action_prev').hide();		
				
				$('#crewinfoform_fieldset_message').formmessage({});
				
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
		this.crewMemberView.refresh();
		$("#crewinfoform_form").resetForm();
		$('#crewinfoform_crewmemberid').val("");
		$('#crewinfoform_action_uloadinfo').prop('disabled', true);	
	},
	
	open : function(anApplicationDTOAdapter, wizardActions, showOnLoad)
	{
		// GET_SEV_Application_Crew 
		var dataTableSource = org.r3.PageManager.getRESTUrl('GET_SEV_ConsoleApplication_CrewReport', [ anApplicationDTOAdapter.dataBean.applicationid ]);
		
		this.crewMemberView.open({
				"dataTableSource": dataTableSource,
				"onInitializationCompleteArgs": arguments
		});
	},
	
	_initializeFormFields: function(anApplicationDTOAdapter)
	{

		$('#crewinfoform_applicationid'           ).html(anApplicationDTOAdapter.dataBean.applicationid); 

		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_crewrole'),
			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
			"selectWidget" : $('#crewinfoform_crewmemberrole'),
			"selectedValue": null
		});						

		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_crewstatus'),
			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
			"selectWidget" : $('#crewinfoform_memberstatus'),
			"selectedValue": 'r3ea_titolare',
			"useBusinessKey": true
		});		
											
	},
	
	crewMemberDetail: function(crewMemberDTOAdapter)
	{
		
		var method = "GET";
		var restUrl = org.r3.PageManager.getRESTUrl('GET_SEV_Application_Crew_Documents', [ crewMemberDTOAdapter.dataBean.applicationid, crewMemberDTOAdapter.dataBean.crewmemberid] );
					 
		org.r3.AjaxUtils.ajaxInvoke(method, restUrl, 
		function(responseData) 
		{ 
			if (responseData.iTotalRecords && responseData.iTotalRecords > 0)
			{
				var u = $.r3Utils.formatDMSUrl4ClientAccess(responseData.aaData[0].documenturl);
				console.log("covidUrl: ", u);
				$('#crewinfoform_crewcovidurl_link').html(u);
				$('#crewinfoform_crewcovidurl').val(u);
			}
			else {
				$('#crewinfoform_crewcovidurl').val('');
				$('#crewinfoform_crewcovidurl_link').html('');
			}
			
			$('#crewinfoform_crewmemberid').val(crewMemberDTOAdapter.dataBean.crewmemberid);
			$('#crewinfoform_crewcardnumber').val(crewMemberDTOAdapter.dataBean.cardnumber);
			$('#crewinfoform_crewmembername').val(crewMemberDTOAdapter.dataBean.crewmembername);
			$('#crewinfoform_crewmemberrole').val(crewMemberDTOAdapter.dataBean.crewmemberrolecode);
			$('#crewinfoform_memberstatus').val(crewMemberDTOAdapter.dataBean.memberstatuscode);
			$('#crewinfoform_crewweight').val(crewMemberDTOAdapter.dataBean.weight);	
			
			$('#crewinfoform_action_uloadinfo').prop('disabled', false);	
        });						
	},
	
	activate: function()
	{
		this.actionFormManager.showHelp("HLP_SEVCREWINFO");
		this.show();
	},
	
	onNextClick: function()
	{
		this.actionFormManager.updateCrewInfo("next");		
	},
		
	onPrevClick: function()
	{	
		this.actionFormManager.updateCrewInfo("prev");		
	},
	
	onSaveItem: function()
	{	
		this.actionFormManager.saveCrewMember($('#crewinfoform_crewmemberid').val());	
	},
	
	onDocumentUpload: function()
	{	
		this.hide();
		this.actionFormManager.openCrewInfoDocumentUpload($('#crewinfoform_crewmemberid').val(), $('#crewinfoform_crewcardnumber').val(), $('#crewinfoform_crewmembername').val());	
	},
	
	
	crewMemberDelete: function()
	{
		if (org.r3.PageManager.confirmation("org.r3.message.deleteconfirm"))
		{           	
    	    var selectedItem = this.crewMemberView.fnGetSelectedDataBean();
    	    this.actionFormManager.deleteCrewMember(selectedItem);
		}	    	    		
	}

});
