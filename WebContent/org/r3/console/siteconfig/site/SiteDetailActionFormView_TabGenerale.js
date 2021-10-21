$.r3Utils.namespace("org.r3.console.siteconfig.site");

org.r3.console.siteconfig.site.SiteDetailActionFormView_TabGenerale = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, aSiteDataBean, aSailEventDataBean)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		
		$('#sitedetailactionform_form .date_picker').datepicker(
		{
			showOn : "button",
			buttonImage : org.r3.Constants.applicationContext + "/resources/img/calendar.gif",
			buttonImageOnly : true,
			dateFormat : "dd/mm/yy"
		});
				
		$('#sitedetailactionform_fieldset_message').formmessage({});

		// ignore: ':hidden:not("#userdetailactionform_form_ruoliesiti, #userdetailactionform_form_ruolipostaliz")'
		$('#sitedetailactionform_form').validate
        ({
        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
               rules: org.r3.console.siteconfig.site.sitedetailactionform_form_validationRules,
	           messages: org.r3.console.siteconfig.site.sitedetailactionform_form_validationMessages	           
        });		
				
		this._initializeFormFields(aSiteDataBean, aSailEventDataBean);
		$('#sitedetailactionform_action_saveitem').click(
				$.r3Utils.hitch(this, this._onUpdateItem));
		
	},
	
	refresh: function()
	{		
	},
	
	_onUpdateItem: function()
	{
		this.actionFormManager.updateItem(
				function(responseData) { 					
		        }, 
				function(jqXHR, timeout, message) { $('#sitedetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); },
				function(restDto) { restDto.showMessage('sitedetailactionform_fieldset_message'); }	
		);
	},
	
	_initializeFormFields: function(aSiteDTOAdapter, aSailEventDTOAdapter)
	{
		var urlHome = "/r3ng/" + aSiteDTOAdapter.dataBean.site + "/it/org/r3/home.do";
		$('#regattadetailactionform_form_urlhome').html(urlHome);
		 $('#regattadetailactionform_form_urlhome').unbind().click(function(e) {
			    // org.r3.PageManager.viewDocument(urlHome);
			    var w = window.open(urlHome, "Site_Window_" + aSiteDTOAdapter.dataBean.site);
			    w.focus();
		}); 

		var urlConsoleHome = "/r3ng/" + aSiteDTOAdapter.dataBean.site + "/it/org/r3/console/home.do";
		$('#regattadetailactionform_form_urlhomeconsole').html(urlConsoleHome);
		 $('#regattadetailactionform_form_urlhomeconsole').unbind().click(function(e) {
			    // org.r3.PageManager.viewDocument(urlHome);
			    var w = window.open(urlConsoleHome, "Site_Window_Console_" + aSiteDTOAdapter.dataBean.site);
			    w.focus();
		}); 

		$('#regattadetailactionform_site').val(aSiteDTOAdapter.dataBean.site);
		$('#regattadetailactionform_site').prop('disabled', true);

		$('#regattadetailactionform_sitedescr').val(aSiteDTOAdapter.dataBean.sitedescr);
        if (aSiteDTOAdapter.dataBean.siteresourcepath && aSiteDTOAdapter.dataBean.siteresourcepath != 'default')
        {
        	var selectOptions = $('#regattadetailactionform_siteresourcepath').prop('options');
        	selectOptions[selectOptions.length] = new Option(aSiteDTOAdapter.dataBean.siteresourcepath, aSiteDTOAdapter.dataBean.siteresourcepath, true, true);	
        }
        			
        $('#regattadetailactionform_sitetheme').val(aSiteDTOAdapter.dataBean.sitetheme);
        
        var summary = aSiteDTOAdapter.dataBean.sitesummary;
		if (aSailEventDTOAdapter)
		{
			summary = aSailEventDTOAdapter.dataBean.eventdescr;
		}
		
		$('#regattadetailactionform_eventdescr').val(summary);
	}
			
});
