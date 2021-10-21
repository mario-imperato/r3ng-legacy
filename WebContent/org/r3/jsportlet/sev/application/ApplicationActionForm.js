$.r3Utils.namespace("org.r3.jsportlet.sev.application");

org.r3.jsportlet.sev.application.ApplicationActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, anActionFormContainerId, isAdminFlag)
	{
		this.setPageManager(aPageManager);
		
		this.isAdmin = isAdminFlag;
		
		this.actionFormContainer = $(anActionFormContainerId);
		
		this.wizardNavigatorActionFormView = new org.r3.jsportlet.sev.application.ApplicationWizardNavigatorActionFormView('#JSPortlet_SEVApplicationActionForm_wizardnavigator', this);
		this.boatInfoView = new org.r3.jsportlet.sev.application.BoatInfoActionFormView("#JSPortlet_SEVApplicationActionForm_BoatInfoActionForm", this);
		this.classInfoView = new org.r3.jsportlet.sev.application.ClassInfoActionFormView("#JSPortlet_SEVApplicationActionForm_ClassInfoActionForm", this);
		this.ownerInfoView = new org.r3.jsportlet.sev.application.OwnerInfoActionFormView("#JSPortlet_SEVApplicationActionForm_OwnerInfoActionForm", this);
		this.crewInfoView = new org.r3.jsportlet.sev.application.CrewInfoActionFormView("#JSPortlet_SEVApplicationActionForm_CrewInfoActionForm", this);
		this.authorInfoView = new org.r3.jsportlet.sev.application.AuthorInfoActionFormView("#JSPortlet_SEVApplicationActionForm_AuthorInfoActionForm", this);
		this.docInfoView = new org.r3.jsportlet.sev.application.DocInfoActionFormView("#JSPortlet_SEVApplicationActionForm_DocInfoActionForm", this);
		this.docUploadView = new org.r3.jsportlet.sev.application.UploadFileActionFormView("#JSPortlet_SEVApplicationActionForm_UploadFileActionForm", this);
		this.crewInfoDocUploadView = new org.r3.jsportlet.sev.application.UploadCrewInfoFileActionFormView("#JSPortlet_SEVApplicationActionForm_UploadCrewInfoFileActionForm", this);
		this.payInfoView = new org.r3.jsportlet.sev.application.PayInfoActionFormView("#JSPortlet_SEVApplicationActionForm_PayInfoActionForm", this);
		this.summaryInfoView = new org.r3.jsportlet.sev.application.SummaryInfoActionFormView("#JSPortlet_SEVApplicationActionForm_SummaryInfoActionForm", this);
		
		this.appViewer = new org.r3.jsportlet.sev.appviewer.AppViewerActionFormView("#canvas_report_content", this);
	},

	close : function()
	{
		// M20140201 - org.r3.PageManager.popBreadCrumb();
		this.hide();

		this.wizardNavigatorActionFormView.close();
		this.boatInfoView.close();
		this.classInfoView.close();
		this.ownerInfoView.close();
		this.crewInfoView.close();
		this.authorInfoView.close();
		this.docInfoView.close();
		this.docUploadView.close();
		this.payInfoView.close();
		this.summaryInfoView.close();		
	},

	hide : function()
	{
		this.actionFormContainer.hide();
	},

	show : function()
	{
		this.actionFormContainer.show();
	},

	refresh: function()
	{
		// this.detailView.refresh();
	},
	
	open : function(anApplicationDTOAdapter)
	{
		this.setDataBeanInfo(anApplicationDTOAdapter);
		
		var navigatorSteps = [];
		if (anApplicationDTOAdapter.isDraft() || anApplicationDTOAdapter.isEmpty() || (this.isAdmin && org.r3.PageManager.isUserInRole('console')))
		{
			navigatorSteps = this._setupFullApplicationNavigatorSteps(anApplicationDTOAdapter, this.isAdmin);	
		}
		else 
			navigatorSteps = this._setupPartialApplicationNavigatorSteps(anApplicationDTOAdapter, false);
		
		org.r3.PageManager.googleAnalyticsSendPageView();
		this.wizardNavigatorActionFormView.open(anApplicationDTOAdapter, navigatorSteps);		
		this.actionFormContainer.show();
	},

	_setupPartialApplicationNavigatorSteps: function(anApplicationDTOAdapter, activateJumpsFlag)
	{
		var navigatorSteps = [];

		navigatorSteps.push({
			id : 'crewinfo',
			title : "Iscrizione - Equipaggio",
			briefTitle : "Equipaggio",					
			active : activateJumpsFlag,
			selected : true,
			onClick : $.r3Utils.hitch(this, this.onActiveStepClick),
			actionFormView: this.crewInfoView
		});
		
		this.crewInfoView.open(anApplicationDTOAdapter, "next", true);			

		navigatorSteps.push({
			id : 'summaryinfo',
			title : "Iscrizione - Riepilogo",
			briefTitle : "Riepilogo",					
			active : activateJumpsFlag,
			selected : false,
			onClick : $.r3Utils.hitch(this, this.onActiveStepClick),
			actionFormView: this.summaryInfoView
		});
		
		this.summaryInfoView.open(anApplicationDTOAdapter, "prev", false);			

		return navigatorSteps;
	},
	
	_setupFullApplicationNavigatorSteps: function(anApplicationDTOAdapter, activateJumpsFlag)
	{
		var navigatorSteps = [];
		
		navigatorSteps.push({
			id : 'boatinfo',
			title : "Iscrizione - Informazioni generali",
			briefTitle : "Info Barca",					
			active : activateJumpsFlag,
			selected : true,
			onClick : $.r3Utils.hitch(this, this.onActiveStepClick),
			actionFormView: this.boatInfoView
		});

		this.boatInfoView.open(anApplicationDTOAdapter, "next", true);			

		navigatorSteps.push({
			id : 'classinfo',
			title : "Iscrizione - Informazioni raggruppamento",
			briefTitle : "Info Raggrupp.",					
			active : activateJumpsFlag,
			selected : false,
			onClick : $.r3Utils.hitch(this, this.onActiveStepClick),
			actionFormView: this.classInfoView
		});
		
		this.classInfoView.open(anApplicationDTOAdapter, "prev,next", false);			

		navigatorSteps.push({
			id : 'ownerinfo',
			title : "Iscrizione - Armatore/timoniere",
			briefTitle : "Armatore/ timoniere",					
			active : activateJumpsFlag,
			selected : false,
			onClick : $.r3Utils.hitch(this, this.onActiveStepClick),
			actionFormView: this.ownerInfoView
		});
		
		this.ownerInfoView.open(anApplicationDTOAdapter, "prev,next", false);			

		navigatorSteps.push({
			id : 'crewinfo',
			title : "Iscrizione - Equipaggio",
			briefTitle : "Equipaggio",					
			active : activateJumpsFlag,
			selected : false,
			onClick : $.r3Utils.hitch(this, this.onActiveStepClick),
			actionFormView: this.crewInfoView
		});
		
		this.crewInfoView.open(anApplicationDTOAdapter, "prev,next", false);			

		navigatorSteps.push({
			id : 'authorinfo',
			title : "Iscrizione - Liberatorie",
			briefTitle : "Liberatorie",					
			active : activateJumpsFlag,
			selected : false,
			onClick : $.r3Utils.hitch(this, this.onActiveStepClick),
			actionFormView: this.authorInfoView
		});
		
		this.authorInfoView.open(anApplicationDTOAdapter, "prev,next", false);			

		navigatorSteps.push({
			id : 'docinfo',
			title : "Iscrizione - Documenti",
			briefTitle : "Documenti",					
			active : activateJumpsFlag,
			selected : false,
			onClick : $.r3Utils.hitch(this, this.onActiveStepClick),
			actionFormView: this.docInfoView
		});
		
		this.docInfoView.open(anApplicationDTOAdapter, "prev,next", false);			

		navigatorSteps.push({
			id : 'payinfo',
			title : "Iscrizione - Costi",
			briefTitle : "Costi",					
			active : activateJumpsFlag,
			selected : false,
			onClick : $.r3Utils.hitch(this, this.onActiveStepClick),
			actionFormView: this.payInfoView
		});
		
		this.payInfoView.open(anApplicationDTOAdapter, "prev,next", false);			

		navigatorSteps.push({
			id : 'summaryinfo',
			title : "Iscrizione - Riepilogo",
			briefTitle : "Riepilogo",					
			active : activateJumpsFlag,
			selected : false,
			onClick : $.r3Utils.hitch(this, this.onActiveStepClick),
			actionFormView: this.summaryInfoView
		});
		
		this.summaryInfoView.open(anApplicationDTOAdapter, "prev", false);			
		return navigatorSteps;
	},
	
	onActiveStepClick: function(aStepItem, isActivating)
	{
		if (aStepItem && aStepItem.actionFormView)
		{
			if (isActivating)
			{
				org.r3.PageManager.googleAnalyticsSendPageView();
				aStepItem.actionFormView.activate();
			}
			else 
			{
				if (this.docUploadView.isVisible())
					this.docUploadView.hide();
				
				aStepItem.actionFormView.hide();
			}
		}
		else console.error("Selected Item is not actionForm: ", aStepItem);		
	},
	
	next: function()
	{
		var selectedItem = this.wizardNavigatorActionFormView.next();
		if (selectedItem && selectedItem.actionFormView)
		{
			org.r3.PageManager.googleAnalyticsSendPageView();
			selectedItem.actionFormView.activate(); 	
		}
		else org.r3.PageManager.redirectToHomePage();
	},

	prev: function()
	{
		var selectedItem = this.wizardNavigatorActionFormView.prev();
		if (selectedItem.actionFormView)
		{
			org.r3.PageManager.googleAnalyticsSendPageView();
			selectedItem.actionFormView.activate(); 	
		}
	},

	updateInfo: function(urlName, actionForm, theFormObj, theFieldsetMessageObj, gotoAction)
	{
		var _self = this;
		
		if (theFormObj.valid())
		{
			org.r3.PageManager.wait("org.r3.message.waiting");

			var method = "put";
			var restUrl = org.r3.PageManager.getRESTUrl(urlName, [ this.dataBeanInfo.dataBean.applicationid ]);
			theFormObj.ajaxSubmit(
			{
				"type" : method,
				"url" : restUrl,
				"dataType" : "json",
				"success" : function(responseData)
				{
					org.r3.PageManager.closeNotifier();
					if (org.r3.PageManager.isRestDTO(responseData))
					{						
						var restDto = new org.r3.RestDTOAdapter(responseData);

						if (restDto.isFail())
	                    {
							theFieldsetMessageObj.formmessage('setText', { text: restDto.reason, category: 'error' });						
	                    }
						else
						{
							actionForm.hide();
							_self.executeWizardAction(gotoAction);	
						}
					}		
					else
					{
						actionForm.hide();
						_self.executeWizardAction(gotoAction);							
					}
				},
				"error" : function(jqXHR, timeout, message)
				{
					console.log(arguments);
					org.r3.PageManager.closeNotifier();
					theFieldsetMessageObj.formmessage('setText', { text: message, category: 'error' });
				}
			});
		}				
	},
	
	
	executeWizardAction: function(wizardAction)
	{
		if (wizardAction == 'next')
			this.next();
		
		if (wizardAction == 'prev')
			this.prev();
	},
	
	showHelp: function(anHelpId)
	{
		// In Futuro lo realizzo a Card
		// $('#HLP_CMP_PROFILE').cmsCard({ cardid: "HLP_INFO_BE8_ACT_001"});
		
		$('.applicationactionform_helpsidebar').hide();
		$('#' + anHelpId).show();

	},
	
	updateBoatInfo: function(gotoAction)
	{
		this.updateInfo('PUT_SEV_Application_BoatInfo', this.boatInfoView, $('#boatinfoform_form'), $('#boatinfoform_fieldset_message'), gotoAction);
	},
	
	updateClassInfo: function(gotoAction)
	{		
		this.updateInfo('PUT_SEV_Application_ClassInfo', this.classInfoView, $('#classinfoform_form'), $('#classinfoform_fieldset_message'), gotoAction);
	},

	updateOwnerInfo: function(gotoAction)
	{
		this.updateInfo('PUT_SEV_Application_OwnerInfo', this.ownerInfoView, $('#ownerinfoform_form'), $('#ownerinfoform_fieldset_message'), gotoAction);		
	},

	updateCrewInfo: function(gotoAction)
	{
		var _self = this;
		
		_self.crewInfoView.hide();
		_self.executeWizardAction(gotoAction);			
	},

	updateAuthorInfo: function(gotoAction)
	{
		this.updateInfo('PUT_SEV_Application_AuthorInfo', this.authorInfoView, $('#authorinfoform_form'), $('#authorinfoform_fieldset_message'), gotoAction);				
	},

	updateDocInfo: function(gotoAction)
	{
		var _self = this;
		
		_self.docInfoView.hide();
		_self.executeWizardAction(gotoAction);			
	},

	updatePayInfo: function(gotoAction)
	{
		var _self = this;
		
		_self.payInfoView.hide();
		_self.executeWizardAction(gotoAction);			
	},

	updateSummaryInfo: function(gotoAction)
	{
		var _self = this;
		
		_self.summaryInfoView.hide();
		_self.executeWizardAction(gotoAction);			
	},

	openCrewInfoDocumentUpload: function(crewId, crewCardId, crewName)
	{
		this.crewInfoDocUploadView.open(this.dataBeanInfo, crewId, crewCardId, crewName);
	},
	
	openDocumentUpload: function()
	{
		this.docUploadView.open(this.dataBeanInfo);
	},

	closeDocumentUpload: function()
	{
		this.docInfoView.refresh();
		this.docInfoView.show();
	},
	
	closeCrewInfoDocumentUpload: function()
	{
		this.crewInfoView.refresh();
		this.crewInfoView.show();
	},
	
	deleteDocument: function(aDocumentDTOAdapter)
	{
		var _self = this;

		var method = "DELETE";
		var restUrl = null;
		var site = aDocumentDTOAdapter.dataBean.eventid;
		var applicationId = aDocumentDTOAdapter.dataBean.applicationid;
		var documentId = aDocumentDTOAdapter.dataBean.documentid;
		restUrl = org.r3.PageManager.getRESTUrl('DELETE_SEV_Application_File', [ applicationId, documentId ]);

		org.r3.PageManager.wait("org.r3.message.waiting");
		$.ajax(
		{
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"success" : function()
			{
				org.r3.PageManager.closeNotifier();
				_self.docInfoView.refresh();
			},
			"error" : function(jqXHR, timeout, message)
			{
				console.error("GruppoDetailActionForm: ", message);
			}
		});
	},
	
	saveCrewMember: function(crewMemberId)
	{
		var _self = this;
		
		$('#crewinfoform_fieldset_message').formmessage('clear');
		
		var theFormObj = $('#crewinfoform_form'); 
		if (theFormObj.valid())
		{
			org.r3.PageManager.wait("org.r3.message.waiting");

			var method = "post";			
			var restUrl = org.r3.PageManager.getRESTUrl("POST_SEV_Application_Crew", [ this.dataBeanInfo.dataBean.applicationid ]);
			if (crewMemberId && crewMemberId.length > 0)
			{
				method = "put";	
				restUrl = org.r3.PageManager.getRESTUrl("PUT_SEV_Application_Crew", [ this.dataBeanInfo.dataBean.applicationid, crewMemberId ]);
			}
			
			theFormObj.ajaxSubmit(
			{
				"type" : method,
				"url" : restUrl,
				"dataType" : "json",
				"success" : function(responseData)
				{
					org.r3.PageManager.closeNotifier();
					if (org.r3.PageManager.isRestDTO(responseData))
					{						
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('crewinfoform_fieldset_message');
					}
					
					_self.crewInfoView.refresh();
				},
				"error" : function(jqXHR, timeout, message)
				{
					console.log(arguments);
					org.r3.PageManager.closeNotifier();
					$('#crewinfoform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
				}
			});
		}						
	},
	
	deleteCrewMember: function(aCrewMemberDTOAdapter)
	{
		var _self = this;

		var method = "DELETE";
		var restUrl = null;
		var site = aCrewMemberDTOAdapter.dataBean.eventid;
		var applicationId = aCrewMemberDTOAdapter.dataBean.applicationid;
		var crewMemberId = aCrewMemberDTOAdapter.dataBean.crewmemberid;
		restUrl = org.r3.PageManager.getRESTUrl('DELETE_SEV_Application_Crew', [ applicationId, crewMemberId ]);

		org.r3.PageManager.wait("org.r3.message.waiting");
		$.ajax(
		{
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"success" : function()
			{
				org.r3.PageManager.closeNotifier();
				_self.crewInfoView.refresh();
			},
			"error" : function(jqXHR, timeout, message)
			{
				console.error("GruppoDetailActionForm: ", message);
			}
		});
	},
	
	viewApplication: function()
	{
		org.r3.PageManager.openFullScreenLayout(this.appViewer);
		this.appViewer.open(this.dataBeanInfo.dataBean.applicationid);
	},

	commitApplication: function(onSuccessResponse, onErrorResponse)
	{
		var _self = this;
		var method = 'POST';
		var restUrl = org.r3.PageManager.getRESTUrl('POST_SEV_Application_Commit', [ this.dataBeanInfo.dataBean.applicationid ]);
		org.r3.PageManager.wait("org.r3.message.waiting");
		$.ajax(
		{
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"success" : function(responseData)
			{
				org.r3.PageManager.closeNotifier();
				if (onSuccessResponse)
					onSuccessResponse(responseData);

			},
			"error" : function(jqXHR, timeout, message)
			{
				org.r3.PageManager.closeNotifier();
				if (onErrorResponse)
				{
					onErrorResponse(jqXHR, timeout, message);	
				}
			}
		});
	},
	
	endWizard: function()
	{
	    org.r3.PageManager.back();		
	}

});

