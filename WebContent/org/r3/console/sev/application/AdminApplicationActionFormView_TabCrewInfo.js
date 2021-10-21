$.r3Utils.namespace("org.r3.console.sev.application");

org.r3.console.sev.application.AdminApplicationActionFormView_TabCrewInfo = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, applicationDTOAdapter, pkg_fiv_properties)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
						
		this.crewReportView = new org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewQueryActionFormView('#sailApplicationCrewMemberViewQueryActionFormView', this.actionFormManager,
		{
				dataTableId : 'SailApplicationCrewMemberViewQueryActionFormView',
				showTemplateOnOpen: false,
				htmlTemplateUrl: org.r3.Constants.applicationContext + "/org/r3/console/sev/application/AdminApplicationActionFormView_TabCrewInfo.html.jsp",
				layout : 'fullWidth',
				gradeLevel : 'grade_level1',
				legend : 'Situazione Equipaggio',
				dataTableSource: org.r3.PageManager.getRESTUrl('GET_SEV_ConsoleApplication_CrewReport', [ applicationDTOAdapter.dataBean.applicationid ]),
				
				// pannello con l'identificativo del gruppo
				// onInitializationComplete : $.unepUtils.hitch(this,
				// this.populateRiepilogo),
				dataTableColumns : "cardnumberstatuscode,checkcardnumber_ts,cardnumber,memberinfo,renewaldate,medexamexpirationdate,rectimestamp,memberstatuscode,checkcardnumber",
				requiredLUTs : [ "GET_classifier_sys_recstatus", "GET_classifier_r3ea_crewstatus" ],

				onSelected : null,				
				onDblClick : null,				
				onInitializationComplete: $.r3Utils.hitch(this, function() 
				{
					if (pkg_fiv_properties)
					{
						pkg_fiv_properties = new org.r3.db.system.siteproperty.SitePropertyDTOTableAdapter(pkg_fiv_properties, 
								function(aRowDataBean) { return new org.r3.db.system.siteproperty.SitePropertyDTOAdapter(aRowDataBean); });					

						var property = pkg_fiv_properties.getPropertyByPropertyscopePropertykey("fiv", "fivclubid");
						if (property)
						{
						    $('#adminapp_submitcrewcheckform_yachtclubcode').val(property.dataBean.propertyvalue);
						}
						
						var property = pkg_fiv_properties.getPropertyByPropertyscopePropertykey("fiv", "fivpasswd");
						if (property)
						{
						    $('#adminapp_submitcrewcheckform_yachtclubpwd').val(property.dataBean.propertyvalue);
						    $('#adminapp_submitcrewcheckform_confirm_yachtclubpwd').val(property.dataBean.propertyvalue);
						}				
					}
					
					$("#adminapp_submitcrewcheckform_form").validate
		            ({
			        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
			               rules: org.r3.console.sev.application.adminapp_submitcrewcheckform_form_validationRules,
				           messages: org.r3.console.sev.application.adminapp_submitcrewcheckform_form_validationMessages    
			        });
					
					$('#adminapp_submitcrewcheckform_fieldset_message').formmessage({});			
					$('#adminapp_submitcrewcheckform_action_submit').unbind().click($.r3Utils.hitch(this, this.onSubmitClick));
					$('#adminapp_submitcrewcheckform_action_cancelsubmit').unbind().click($.r3Utils.hitch(this, this.onCancelSubmitClick));
					
				}),
				
				actionBarOnTop: true,
				buttons : [
				{
					id : 'crewReportView_action_refresheventlog',
					label : 'Aggiorna',
					disabled : false,
					onClick : $.r3Utils.hitch(this, function() { this.crewReportView.refresh(); })
				},

				{
					id : 'crewReportView_action_newcheck',
					label : 'Richiedi verifica',
					disabled : false,
					onClick : $.r3Utils.hitch(this, function() { $('#adminapp_submitcrewcheckform_actionform').show(); $('#crewReportView_action_newcheck').hide(); })
				}
				]
		
			});

			
			this.crewReportView.open();
			
	},
			
	onSubmitClick: function(event)
	{
		var _self = this;
		var urlRequested =  'POST_SEV_ConsoleApplication_CrewCheck';
		if ($('#adminapp_submitcrewcheckform_entirefleet_btrue').prop('checked'))
			   urlRequested =  'POST_SEV_ConsoleFleet_CrewCheck';
		
		this.actionFormManager.doProcessApplicationInput('post', urlRequested, $("#adminapp_submitcrewcheckform_form"), 
				function(responseData) { 
					if (org.r3.PageManager.isRestDTO(responseData))
					{						
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('adminapp_submitcrewcheckform_fieldset_message');
						_self.crewReportView.refresh();
					}
					else 
					{						
						$('#adminapp_submitcrewcheckform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });
					}						
				}, 
				function(jqXHR, timeout, message) { $('#adminapp_submitcrewcheckform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); });
		
		event.preventDefault();		
	},
	
	onCancelSubmitClick: function()
	{
		$('#adminapp_submitcrewcheckform_actionform').hide();
		$('#crewReportView_action_newcheck').show();
	}
		
});

