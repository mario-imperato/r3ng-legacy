$.r3Utils.namespace("org.r3.console.regattas");


org.r3.console.regattas.RegattaDetailActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},

	open : function(aDataBeanInfo)
	{
        var _self = this;
        
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/regattas/RegattaDetailActionFormView.html.jsp?mode=detail'),
			dataType : "html"
		});

		if (aDataBeanInfo)
		{
			networkRequestsQueue.push(
			{
				id : "content",
				type : "Get",
				url : org.r3.PageManager.getRESTUrl('GET_SiteDetail', [ aDataBeanInfo.dataBean.site ]),
				dataType : "json"
			});

			networkRequestsQueue.push(
			{
				id : "content_sail_event",
				type : "Get",
				url : org.r3.PageManager.getRESTUrl('GET_SailEventDetail', [ aDataBeanInfo.dataBean.site ]),
				dataType : "json"
			});
			
		}

		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			var siteDataBean = responseData['content'];
			if (siteDataBean)
			{
				siteDataBean = new org.r3.db.system.site.SiteDTOAdapter(siteDataBean);
			}

			var sailEventDataBean = responseData['content_sail_event'];
			if (sailEventDataBean)
			{
				sailEventDataBean = new org.r3.db.sailevent.event.SailEventDTOAdapter(sailEventDataBean);
			}
			
			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));

			// ignore: [],
			$('#regattadetailactionform_form').validate(
			{				
				errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
				rules : org.r3.console.regattas.regattadetailactionform_form_validationRules,
				messages : org.r3.console.regattas.regattadetailactionform_form_validationMessages
			});

			$('#regattadetailactionform_form_refsitetype_site_none, #regattadetailactionform_form_refsitetype_site_internal, #regattadetailactionform_form_refsitetype_site_external').click(
				function(e)
				{
					var currentTarget = $(e.currentTarget);
					var currentTargetId = currentTarget.attr('id');
							
					if (currentTarget.prop('checked'))
					{
						switch (currentTargetId)
						{
							case 'regattadetailactionform_form_refsitetype_site_none':
								_self._initializeRefSiteInfo('site_none', null, null);
								break;

							case 'regattadetailactionform_form_refsitetype_site_internal':	
								_self._initializeRefSiteInfo('site_internal', null, null);
								break;

							case 'regattadetailactionform_form_refsitetype_site_external':		
								_self._initializeRefSiteInfo('site_external', null, null);
								break;						
						}
					}										
				});

			$('#regattadetailactionform_form_admrefsitetype_site_none, #regattadetailactionform_form_admrefsitetype_site_internal, #regattadetailactionform_form_admrefsitetype_site_external').click(
			function(e)
			{
				var currentTarget = $(e.currentTarget);
				var currentTargetId = currentTarget.attr('id');
						
				if (currentTarget.prop('checked'))
				{
					switch (currentTargetId)
					{
						case 'regattadetailactionform_form_admrefsitetype_site_none':
							_self._initializeRefSiteConsoleInfo('site_none', null, null);
							break;

						case 'regattadetailactionform_form_admrefsitetype_site_internal':	
							_self._initializeRefSiteConsoleInfo('site_internal', null, null);
							break;

						case 'regattadetailactionform_form_admrefsitetype_site_external':		
							_self._initializeRefSiteConsoleInfo('site_external', null, null);
							break;						
					}
				}										
			});
			
//			var resolvedUrl = it.posteitaliane.unep.PageManager.getRESTUrl('GET_classifier_sys_recstatus');			
//			var recStatus = (prodottoDataBean) ? prodottoDataBean.dataBean.recstatus : 'sys_recact';
//			it.posteitaliane.unep.PageManager.lutManager.populateRadioGroup(
//			{
//				"lutUrl" : resolvedUrl,
//				"groupContainer" : $('#prodottodetailactionform_form_recstatus_cnt'),
//				"groupId" : "prodottodetailactionform_form_recstatus_",
//				"groupName" : "recstatus",
//				"value" : recStatus
//			});

			$('#regattadetailactionform_fieldset_message').formmessage({});
			
			$('#regattadetailactionform_form_action_cancel').click(
					$.r3Utils.hitch(this.actionFormManager, this.actionFormManager.listaRegate));
			
			this._initializeFormFields(siteDataBean, sailEventDataBean);
			
			if (siteDataBean == null)
			{
				$('#regattadetailactionform_action_saveitem').click(
						$.r3Utils.hitch(this, this._onCreateItem));
				$('#regattadetailactionform_form_action_cancel').hide();
				$('#regattadetailactionform_action_delete').hide();	
				$('.hide_on_create').hide();								
			}
			else
			{				
				
				$('#regattadetailactionform_action_saveitem').click(
					$.r3Utils.hitch(this, this._onUpdateItem));
				$('#regattadetailactionform_form_action_cancel').show();						

				$('#regattadetailactionform_action_delete').unbind().click(
					$.r3Utils.hitch(this, this._onDeleteItem));				
				$('#regattadetailactionform_action_delete').show();							
			}
		
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	
	_onCreateItem: function()
	{
		this.actionFormManager.createItem(
				function(responseData) { 					
		        }, 
				function(jqXHR, timeout, message) { $('#regattadetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); },
		        function(restDto) { restDto.showMessage('regattadetailactionform_fieldset_message'); }	
		);
	},
	
	_onUpdateItem: function()
	{
		this.actionFormManager.updateItem(
				function(responseData) { 					
		        }, 
				function(jqXHR, timeout, message) { $('#regattadetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); },
				function(restDto) { restDto.showMessage('regattadetailactionform_fieldset_message'); }	
		);
	},

	_onDeleteItem: function()
	{
		this.actionFormManager.deleteItem(
				function(responseData) { 					
		        }, 
				function(jqXHR, timeout, message) { $('#regattadetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},

	_initializeFormFields: function(aSiteDTOAdapter, aSailEventDTOAdapter)
	{
		if (aSiteDTOAdapter)
		{
			var urlHome = "/r3ng/" + aSiteDTOAdapter.dataBean.site + "/" + org.r3.Constants.language + "/org/r3/home.do";
			$('#regattadetailactionform_form_urlhome').html(urlHome);
			 $('#regattadetailactionform_form_urlhome').unbind().click(function(e) {
				    // org.r3.PageManager.viewDocument(urlHome);
				    var w = window.open(urlHome, "Site_Window_" + aSiteDTOAdapter.dataBean.site);
				    w.focus();
			}); 

			var urlConsoleHome = "/r3ng/" + aSiteDTOAdapter.dataBean.site + "/"  + org.r3.Constants.language + "/org/r3/console/home.do";
			$('#regattadetailactionform_form_urlhomeconsole').html(urlConsoleHome);
			 $('#regattadetailactionform_form_urlhomeconsole').unbind().click(function(e) {
				    // org.r3.PageManager.viewDocument(urlHome);
				    var w = window.open(urlConsoleHome, "Site_Window_Console_" + aSiteDTOAdapter.dataBean.site);
				    w.focus();
			}); 

			 
			if (aSiteDTOAdapter.isDomainController())
			{
				$('#regattadetailactionform_sitedomain_primary').prop('checked', true);						
			}
			else $('#regattadetailactionform_sitedomain_primary').prop('checked', false);	
			$('#regattadetailactionform_sitedomain_primary').prop('disabled', true);
			
			$('#regattadetailactionform_sitetheme').val(aSiteDTOAdapter.dataBean.sitetheme);
			 
			$('#regattadetailactionform_sitetype').val(aSiteDTOAdapter.dataBean.sitetype);
			$('#regattadetailactionform_sitetype').prop('disabled', true);
			
		    $('#regattadetailactionform_site').val(aSiteDTOAdapter.dataBean.site);
			$('#regattadetailactionform_site').prop('disabled', true);

			$('#regattadetailactionform_sitedescr').val(aSiteDTOAdapter.dataBean.sitedescr);
            if (aSiteDTOAdapter.dataBean.siteresourcepath && aSiteDTOAdapter.dataBean.siteresourcepath != 'default')
            {
            	var selectOptions = $('#regattadetailactionform_siteresourcepath').prop('options');
            	selectOptions[selectOptions.length] = new Option(aSiteDTOAdapter.dataBean.siteresourcepath, aSiteDTOAdapter.dataBean.siteresourcepath, true, true);	
            }

			$('#regattadetailactionform_form_refsitevisible_' + aSiteDTOAdapter.dataBean.refsitevisible).prop('checked', true);
			$('#regattadetailactionform_form_admrefsitevisible_' + aSiteDTOAdapter.dataBean.admrefsitevisible).prop('checked', true);

            $('#regattadetailactionform_form_refsitetype_' + aSiteDTOAdapter.dataBean.refsitetype).prop('checked', true);
            this._initializeRefSiteInfo(aSiteDTOAdapter.dataBean.refsitetype, aSiteDTOAdapter.dataBean.refsite, aSiteDTOAdapter.dataBean.refsitedescr);

            $('#regattadetailactionform_form_admrefsitetype_' + aSiteDTOAdapter.dataBean.admrefsitetype).prop('checked', true);
            this._initializeRefSiteConsoleInfo(aSiteDTOAdapter.dataBean.admrefsitetype, aSiteDTOAdapter.dataBean.admrefsite, aSiteDTOAdapter.dataBean.admrefsitedescr);    

			var siteOptions = aSiteDTOAdapter.getOptions();
			if (siteOptions && siteOptions.length > 0)
			{
				for(var i = 0; i < siteOptions.length; i++)
				{					
					$('#regattadetailactionform_options_' + siteOptions[i]).prop('checked', true);	
				}								
			}						
    		else $("#regattadetailactionform_form input[name='options']").prop('checked', false);
    		
		}			
		else
		{
			// Debbo decidere quale sia il valore iniziale..
			$('#regattadetailactionform_sitedomain_primary').prop('checked', false);
			
			$('#regattadetailactionform_form_refsitevisible_bfalse').prop('checked', true);
			$('#regattadetailactionform_form_admrefsitevisible_bfalse').prop('checked', true);
			$('#regattadetailactionform_form_refsitetype_site_none').prop('checked', true);
			this._initializeRefSiteInfo('site_none', null, null);			

			$('#regattadetailactionform_form_admrefsitetype_site_none').prop('checked', true);
			this._initializeRefSiteConsoleInfo('site_none', null, null);	
			
			$("#regattadetailactionform_form input[name='options']").prop('checked', false);
		}
					
		var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_classifier_childrensite", 
				[ org.r3.SiteConstants.targetSiteType ] );
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : resolvedUrl,
			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
			"selectWidget" : $('#regattadetailactionform_sitetype'),
			"selectedValue": aSiteDTOAdapter && aSiteDTOAdapter.dataBean.sitetype,
			"useBusinessKey": true
		});
		
        var summary = (aSiteDTOAdapter) ? aSiteDTOAdapter.dataBean.sitesummary : null;
		if (aSailEventDTOAdapter)
		{
			summary = aSailEventDTOAdapter.dataBean.eventdescr;
		}
		
		$('#regattadetailactionform_eventdescr').val(summary);

	},

	_initializeRefSiteInfo: function(aRefSiteType, aRefSite, aRefSiteDescr)
	{
		// Questa funzione non esegue il set del radio per evitare un set duplicato nel caso in cui viene invocato sull'onclick del radio stesso.
        switch(aRefSiteType)
        {
        case 'site_none':        	
        	$('#regattadetailactionform_form_refsite').val('');
        	$('#regattadetailactionform_form_refsite').prop('disabled', true);
        	$('#regattadetailactionform_form_refsitedescr').val('');
        	$('#regattadetailactionform_form_refsitedescr').prop('disabled', true);
        	
        	break;
        case 'site_external':
        	$('#regattadetailactionform_form_refsite').val(aRefSite);
        	$('#regattadetailactionform_form_refsite').prop('disabled', false);
        	$('#regattadetailactionform_form_refsitedescr').val(aRefSiteDescr);
        	$('#regattadetailactionform_form_refsitedescr').prop('disabled', false);
        	break;
        	
        case 'site_internal':
        	$('#regattadetailactionform_form_refsite').val(aRefSite);
        	$('#regattadetailactionform_form_refsite').prop('disabled', true);
        	
        	$('#regattadetailactionform_form_refsitedescr').val(aRefSiteDescr);
        	$('#regattadetailactionform_form_refsitedescr').prop('disabled', false);
        	break;
        }			
        
        
	},

	_initializeRefSiteConsoleInfo: function(aRefSiteType, aRefSite, aRefSiteDescr)
	{
		// Questa funzione non esegue il set del radio per evitare un set duplicato nel caso in cui viene invocato sull'onclick del radio stesso.
        switch(aRefSiteType)
        {
        case 'site_none':        	
        	$('#regattadetailactionform_form_admrefsite').val('');
        	$('#regattadetailactionform_form_admrefsite').prop('disabled', true);
        	$('#regattadetailactionform_form_admrefsitedescr').val('');
        	$('#regattadetailactionform_form_admrefsitedescr').prop('disabled', true);
        	
        	break;
        case 'site_external':
        	$('#regattadetailactionform_form_admrefsite').val(aRefSite);
        	$('#regattadetailactionform_form_admrefsite').prop('disabled', false);
        	$('#regattadetailactionform_form_admrefsitedescr').val(aRefSiteDescr);
        	$('#regattadetailactionform_form_admrefsitedescr').prop('disabled', false);
        	break;
        	
        case 'site_internal':
        	$('#regattadetailactionform_form_admrefsite').val(aRefSite);
        	$('#regattadetailactionform_form_admrefsite').prop('disabled', true);
        	
        	$('#regattadetailactionform_form_admrefsitedescr').val(aRefSiteDescr);
        	$('#regattadetailactionform_form_admrefsitedescr').prop('disabled', false);
        	break;
        }			        
        
	}

});
