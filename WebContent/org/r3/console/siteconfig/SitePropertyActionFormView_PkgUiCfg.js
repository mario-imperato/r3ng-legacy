$.r3Utils.namespace("org.r3.console.siteconfig");


org.r3.console.siteconfig.SitePropertyActionFormView_PkgUiCfg = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, siteProperties)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);		
		
		$('#pkg_uicfg_form_property_package').val("ui.cfg");
		
//		var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_uicfgmenusi');
//		var property = siteProperties.getPropertyByPropertyscopePropertykey("ui.cfg", "menusitems");
//		org.r3.PageManager.lutManager.populateCheckBoxGroup(
//		{
//			"lutUrl" : resolvedUrl,
//			"groupContainer" : $('#pkg_uicfg_form_menusitems_cnt'),
//			"groupId" : "pkg_uicfg_form_menusitems_",
//			"groupName" : "prop_menusitems",
//			"value" : property && property.dataBean.propertyvalue,
//			"labelSize" : 200
//		});
		
		// Caricol la lista delle pagine. La scorro per capire se sono visibili e costruisco il valore per il checkbox group.
		// A questo punto lo popolo. DOvrebbe essere tutto locale e quindi sincrono
//		var resolvedUrl = org.r3.PageManager.getRESTUrl('LUT_CMS_Page');
//		org.r3.PageManager.lutManager.getLUT(resolvedUrl, function(theLUT)
//		{
//			var checkboxConfig = "";
//    		if (theLUT.aaData && theLUT.aaData.length > 0)
//    		{
//    			for(var i = 0; i < theLUT.aaData.length; i++)
//    			{
//    				var pageItem = new org.r3.db.cms.page.PageDTOAdapter(theLUT.aaData[i]);
//    				if (pageItem.isVisible('cmspg_iconmenu'))
//    				{
//    					checkboxConfig += pageItem.dataBean.pageid + ",";	
//    				}
//    			}
//    		}    
//    		
//    		org.r3.PageManager.lutManager.populateCheckBoxGroup(
//			{
//				"lutUrl" : resolvedUrl,
//				"groupContainer" : $('#pkg_uicfg_form_menusitems_cnt'),
//				"groupId" : "pkg_uicfg_form_menusitems_",
//				"groupName" : "prop_pages",
//				"value" : checkboxConfig,
//				"labelSize" : 200
//			});
//    		
//    	});			
		
		var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_uicfgmenus');
		var property = siteProperties.getPropertyByPropertyscopePropertykey("ui.cfg", "menus");
		org.r3.PageManager.lutManager.populateCheckBoxGroup(
		{
			"lutUrl" : resolvedUrl,
			"groupContainer" : $('#pkg_uicfg_form_menus_cnt'),
			"groupId" : "pkg_uicfg_form_menus_",
			"groupName" : "prop_menus",
			"value" : property && property.dataBean.propertyvalue,
			"labelSize" : 200
		});
		
		$('#pkg_uicfg_action_save').click(
				$.r3Utils.hitch(this, this._onSaveForm));				

	    $('#pkg_uicfg_fieldset_message').formmessage({});
	
	},
	
	refresh: function()
	{		
	},
	
	_onSaveForm: function()
	{
		var _self = this;
		var restUrl = org.r3.PageManager.getRESTUrl("POST_SiteProperties_Invalidate", [ "ui.cfg" ]);
		
		this.actionFormManager.saveForm(
				restUrl,
				$('#pkg_uicfg_form'),
				function(responseData) { 
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('pkg_uicfg_fieldset_message');
					}					
		        }, 
				function(jqXHR, timeout, message) { $('#pkg_uicfg_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	}
		
});
