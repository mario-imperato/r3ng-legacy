$.r3Utils.namespace("org.r3.jsportlet.cmsconsole");


org.r3.jsportlet.cmsconsole.CardDetailActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.tabGenerale = null;
		this.tabCardText = null;
		this.tabCardFile = null;
		this.tabCardLink = null;
	},

	close : function()
	{
		this.hide();
	},

	refresh: function()
	{
		if (this.tabCardFile)
		   this.tabCardFile.refresh();
		
		if (this.tabGenerale)
		   this.tabGenerale.refresh();
		
		if (this.tabCardLink)
			   this.tabCardLink.refresh();		
	},
	
	// open: function(aDataBeanInfo)
	// {
	// if (!aDataBeanInfo)
	// this.loadHtmlAndShow('UserDetailActionForm.html', $.r3Utils.hitch(this,
	// function()
	// {
	// $('#userdetailactionform_form').validate({ meta: "validate" });
	//
	// }));
	// else
	// this.loadDetail(aDataBeanInfo, true);
	// },

//	_intializeForm : function(aUserDataBean)
//	{
//		console.log("_intializeForm --> ", aUserDataBean);
//		if (aUserDataBean)
//		{
//			$('#userdetailactionform_form_nickname').attr('value', aUserDataBean.dataBean.nickname);
//			$('#userdetailactionform_form_username').attr('value', aUserDataBean.dataBean.username);	
//		}
//		
//		var userInfo = org.r3.PageManager.userInfo;
//		if (aUserDataBean)
//		{			
//			userInfo.populateUsertypeSelectFieldForDetail
//			(
//				$('#userdetailactionform_form_usertype'),
//				org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
//				aUserDataBean && aUserDataBean.dataBean.usertype
//			);
//		}
//		else
//		{
//			userInfo.populateUsertypeSelectFieldForNewUser
//			(
//				$('#userdetailactionform_form_usertype'),
//				org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
//				aUserDataBean && aUserDataBean.dataBean.usertype
//			);		
//		}
//
////		var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_usr_type');
////		org.r3.PageManager.lutManager.populateSelectField(
////		{
////			"lutUrl" : resolvedUrl,
////			"selectWidget" : $('#userdetailactionform_form_usertype'),
////			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
////			"selectedValue" : aUserDataBean && aUserDataBean.dataBean.usertype
////		});
//
//		if (aUserDataBean && aUserDataBean.dataBean.usertype && this['_setupUserScopeUIFor_' + aUserDataBean.dataBean.usertype + '_by_' + userInfo.dataBean.usertype])
//		{
//			// Modo conciso per invocare le funzioni
//			// _setupUserScopeUIFor_USR_MANAGER 'indicizzate' sul tipo
//			// dell'operatore.
//			this['_setupUserScopeUIFor_' + aUserDataBean.dataBean.usertype  + '_by_' + userInfo.dataBean.usertype](aUserDataBean);
//		}
//		else
//			this._setupUserScopeUIFor_usr_undefined(aUserDataBean);
//
//		var actionFormView = this;
//		$('#userdetailactionform_form_usertype').bind('change', function(e)
//		{
//			var itemVal = $(this).val();
//			if (itemVal && itemVal.length > 0 && actionFormView['_setupUserScopeUIFor_' + itemVal  + '_by_' + userInfo.dataBean.usertype])
//			{
//				actionFormView['_setupUserScopeUIFor_' + itemVal + '_by_' + userInfo.dataBean.usertype](null);
//			}
//			else
//				actionFormView._setupUserScopeUIFor_usr_undefined(null);
//		});
//		
//		$('#userdetailactionform_form_fieldset_message').formmessage({});
//	},
//
//	_initializeHiddenCSVAuthRoles: function(includeSClassRole)
//	{
//		var resolvedUrl = org.r3.PageManager.getRESTUrl('LUT_UNEPAuthRole_Esiti');
//		org.r3.PageManager.lutManager.populateInputFieldAsCSV(
//		{
//			"lutUrl" : resolvedUrl,
//			"selectWidget" : $('#userdetailactionform_form_csvruoliesiti')
//		});
//		
//		resolvedUrl = org.r3.PageManager.getRESTUrl('LUT_UNEPAuthRole_Postalizz');
//		if (includeSClassRole)
//		{
//			resolvedUrl = org.r3.PageManager.getRESTUrl('LUT_UNEPAuthRole_PostalizzAdmin');	
//		}
//		org.r3.PageManager.lutManager.populateInputFieldAsCSV(
//		{
//			"lutUrl" : resolvedUrl,
//			"selectWidget" : $('#userdetailactionform_form_csvruolipostaliz')
//		});		
//	},
//
//	_initializeListOfRolesPostalizz: function(aUserDataBean)
//	{
//		var resolvedUrl = org.r3.PageManager.getRESTUrl('LUT_UNEPAuthRole_Postalizz');
//		var theLUT = org.r3.PageManager.lutManager.populateSelectField(
//		{
//			"lutUrl" : resolvedUrl,
//			"selectWidget" : $('#userdetailactionform_form_ruolipostaliz'),
//			"selectedValue" : aUserDataBean && aUserDataBean.roles,
//			"onComplete" : function()
//			{
//				$('#userdetailactionform_form_ruolipostaliz').multiselect(
//				{
//					"minWidth" : 174,
//					"checkAllText" : "Tutti",
//					"uncheckAllText" : "Nessuno",
//					"noneSelectedText" : "Nessun Elemento Selezionato",
//					"selectedText" : "# Elementi Selezionati",
//					"selectedList" : 5
//				});
//			}
//		});
//		
//	},
//
	
//	_initializeForm : function(aUserDataBean)
//	{
//		console.log("_intializeForm --> ", aUserDataBean);
//
//		
//		this._initializeListOfRoles(aUserDataBean);
//    },

	open : function(aCardDTOAdapter)
	{
		org.r3.PageManager.wait("org.r3.message.waiting");
        console.log("Logged User Is: ", org.r3.PageManager.userInfo);
		var networkRequestsQueue = [];

		if (aCardDTOAdapter)
		{
			networkRequestsQueue.push(
			{
				id : "view",
				type : "Get",
				url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/cmsconsole/CardDetailActionFormView.html.jsp?mode=detail'),
				dataType : "html"
			});

			networkRequestsQueue.push(
			{
				id : "content",
				type : "Get",
				url : org.r3.PageManager.getRESTUrl('GET_Card_Detail', [ aCardDTOAdapter.dataBean.cardid ]),
				dataType : "json"
			});

			networkRequestsQueue.push(
			{
				id : "view_tabcardtext",
				type : "Get",
				url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/cmsconsole/CardDetailActionFormView_TabCardText.html'),
				dataType : "html"
			});
			
			networkRequestsQueue.push(
			{
				id : "content_descr",
				type : "Get",
				url : org.r3.PageManager.getRESTUrl('GET_CardDescr_Detail', [ aCardDTOAdapter.dataBean.cardid, org.r3.Constants.language ]),
				dataType : "json"
			});

		}
		else
		{
			networkRequestsQueue.push(
			{
				id : "view",
				type : "Get",
				url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/cmsconsole/CardDetailActionFormView.html.jsp?mode=create'),
				dataType : "html"
			});			
		}

		networkRequestsQueue.push(
		{
			id : "view_tabgenerale",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/cmsconsole/CardDetailActionFormView_TabGenerale.html'),
			dataType : "html"
		});
				
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_sys_recstatus'));
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_locale'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			var cardDataBean = responseData['content'];
			if (cardDataBean)
			{
				cardDataBean = new org.r3.db.cms.card.CardDTOAdapter(cardDataBean);								
			}

			var cardDescrDataBean = responseData['content_descr'];
			if (cardDescrDataBean)
			{
				cardDescrDataBean = new org.r3.db.cms.carddescr.CardDescrDTOAdapter(cardDescrDataBean);		
			}
			
			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));			

			$('#cardDetailActionForm_tab_generale').html(tmpl(responseData['view_tabgenerale'], {}));			
			this.tabGenerale = new org.r3.jsportlet.cmsconsole.CardDetailActionFormView_TabGenerale('__UNUSED__', this.actionFormManager, cardDataBean);

			if (cardDataBean)
            {
			    $('#cardDetailActionForm_tab_cardtext').html(tmpl(responseData['view_tabcardtext'], {}));
			    this.tabCardText = new org.r3.jsportlet.cmsconsole.CardDetailActionFormView_TabCardText('__UNUSED__', this.actionFormManager, cardDataBean, cardDescrDataBean);

			    // $('#cardDetailActionForm_tab_cardfile').html(responseData['view_tabgenerale']);
			    this.tabCardFile = new org.r3.jsportlet.cmsconsole.CardDetailActionFormView_TabCardFile('#cardDetailActionForm_tab_cardfile', this.actionFormManager, cardDataBean);
			    this.tabCardLink = new org.r3.jsportlet.cmsconsole.CardDetailActionFormView_TabCardLink('#cardDetailActionForm_tab_cardlink', this.actionFormManager, cardDataBean);
            }
			
			// $('#cardDetailActionFormTabs').tabs();
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	}
	
	
});
