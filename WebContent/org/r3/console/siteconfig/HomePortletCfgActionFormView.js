$.r3Utils.namespace("org.r3.console.siteconfig");


org.r3.console.siteconfig.HomePortletCfgActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.portletConfig = null;
	},

	close : function()
	{
		this.hide();
	},

	open : function()
	{
		var _self = this;
		
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/siteconfig/HomePortletCfgActionFormView.html.jsp'),
			dataType : "html"
		});

		networkRequestsQueue.push(
		{
			id : "portletconfig",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_Site_PortletConfig', [ 'home' ]),
			dataType : "json"
		});
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			this.portletConfig = {};
			
			var pcfg = responseData["portletconfig"];
			if (pcfg && pcfg.aaData && pcfg.iTotalRecords > 0)
			{			
				for(var i = 0; i < pcfg.aaData.length; i++)
				{ 
					this.portletConfig[pcfg.aaData[i].positionid] = new org.r3.db.system.siteportletcfg.SitePortletConfigDTOAdapter(pcfg.aaData[i]);		
				}
			}			

			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));

			$('#homeportletcfgactionform_form').validate(
			{
				errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
				rules : org.r3.console.siteconfig.homeportletcfgactionform_form_validationRules,
				messages : org.r3.console.siteconfig.homeportletcfgactionform_form_validationMessages
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
			
			this._initializeFormFields(this.portletConfig);
			$(".homeportletslot").unbind().click(function(e) 
			{
				var current = $(e.currentTarget);                
				if (!current.hasClass("layout1-homeportlet-selected"))
				{
				    $("div .homeportletslot").removeClass("layout1-homeportlet-selected");
				    current.addClass("layout1-homeportlet-selected");
				}
				
				var slotId = current.attr('id'); 
                if (slotId.indexOf('layout1-homeportlet-') == 0)
                {
                    slotId = slotId.substr(20);	
                }

                _self._setFormFields(slotId, _self.portletConfig[slotId]);
			});
						
			$('#homeportletcfgactionform_action_saveitem').click(
						$.r3Utils.hitch(this, this._onSaveForm));				
		
			$('#homeportletcfgactionform_fieldset_message').formmessage({});
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	
	_onSaveForm: function()
	{
		var _self = this;
		
		this.actionFormManager.saveForm(
				function(responseData) { 
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('homeportletcfgactionform_fieldset_message');
					}
					else 
					{
						var dtoAdapter = new org.r3.db.system.siteportletcfg.SitePortletConfigDTOAdapter(responseData);
						_self.portletConfig[dtoAdapter.dataBean.positionid] = dtoAdapter;
						_self._updateGraphicSlot(dtoAdapter);						
					}
		        }, 
				function(jqXHR, timeout, message) { $('#homeportletcfgactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},
		
	_initializeFormFields: function(portletConfig)	
	{
		var configPosition_00 = null;
		
        if (portletConfig)
        {
           for(var propertyName in portletConfig) 
           {
        	    var item = portletConfig[propertyName];
        	    var positionId = item.dataBean.positionid;
        	    
        	    var portletSlot = $("#layout1-homeportlet-" + positionId);
        	    portletSlot.addClass("layout1-homeportlet-configured");
        	    portletSlot.addClass(item.dataBean.jsclassname);

        	    if (positionId == '00')
        	    {
        	    	configPosition_00 = item;	
        	    }        	    
           }           
        }
        
        $(".homeportletslot:not(.layout1-homeportlet-configured)").each(function(index, element) {
   	       $(element).addClass("layout1-homeportlet-empty");    
        });

        // Initialize Position 00.
		var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_classifier_portlets" );
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : resolvedUrl,
			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
			"selectWidget" : $('#homeportletcfgactionform_jsclassname'),
			"selectedValue": configPosition_00 && configPosition_00.dataBean.jsclassname
		});
		
		var cardPickerValue = null;
		if (configPosition_00)
		{
			$('#homeportletcfgactionform_positionid').val(configPosition_00.dataBean.positionid);
			$('#homeportletcfgactionform_cssclassname').val(configPosition_00.dataBean.cssclassname);
    		$('#homeportletcfgactionform_datacardid').val(configPosition_00.dataBean.datacardid);
    		$('#homeportletcfgactionform_dataoptions').val(configPosition_00.dataBean.dataoptions);			
    		$('#homeportletcfgactionform_dataonuserstatus_' + configPosition_00.dataBean.dataonuserstatus).prop('checked', true);
    		
    		if (configPosition_00.dataBean.datacardid)
    			cardPickerValue = { dtokey: configPosition_00.dataBean.datacardid, dtodescr: configPosition_00.dataBean.datacardid };    		
		}
		else $('#homeportletcfgactionform_positionid').val('00');
		
		$('#homeportletcfgactionform_pickerdatacardid_cnt').picker(
		{
			multiple: false,
			fieldName: "datacardid",
			openPicker: $.r3Utils.hitch(this.actionFormManager, this.actionFormManager.openCardPicker),
			fieldId: "homeportletcfgactionform_pickerdatacardid",
			pickerValue: cardPickerValue
		});
		
        $("#layout1-homeportlet-00").addClass("layout1-homeportlet-selected");
    },
	
    _setFormFields: function(aPositionId, aPortletConfigDTOAdapter)
    {
    	if (!aPortletConfigDTOAdapter)
    	{
    	    $('#homeportletcfgactionform_form').resetForm();	
    	    $('#homeportletcfgactionform_jsclassname').val('');
    	    $('#homeportletcfgactionform_pickerdatacardid').val('');
    	    $('#homeportletcfgactionform_positionid').val(aPositionId);
    	}
    	else
    	{
    		$('#homeportletcfgactionform_positionid').val(aPortletConfigDTOAdapter.dataBean.positionid);
    		$('#homeportletcfgactionform_jsclassname').val(aPortletConfigDTOAdapter.dataBean.jsclassname);
    		$('#homeportletcfgactionform_cssclassname').val(aPortletConfigDTOAdapter.dataBean.cssclassname);
    		
    		$('#homeportletcfgactionform_dataoptions').val(aPortletConfigDTOAdapter.dataBean.dataoptions);
    		$('#homeportletcfgactionform_dataonuserstatus_' + aPortletConfigDTOAdapter.dataBean.dataonuserstatus).prop('checked', true);
    		
    		if (aPortletConfigDTOAdapter.dataBean.datacardid)
    		{
    			var cardPickerValue = { dtokey: aPortletConfigDTOAdapter.dataBean.datacardid, dtodescr: aPortletConfigDTOAdapter.dataBean.datacardid };   
    			$('#homeportletcfgactionform_pickerdatacardid_cnt').picker('setVal', cardPickerValue);
    		}

    		
    	}
    },
    
    _updateGraphicSlot: function(aDtoadapter)
    {
    	console.log("A Dto Adapter", aDtoadapter);
    	var portletSlot = $("#layout1-homeportlet-" + aDtoadapter.dataBean.positionid);
    	
    	if (aDtoadapter && aDtoadapter.dataBean.jsclassname && aDtoadapter.dataBean.jsclassname.length > 0)
    	{
    		if (portletSlot.hasClass("layout1-homeportlet-empty"))
    		{
    			portletSlot.removeClass("layout1-homeportlet-empty");
    			portletSlot.addClass("layout1-homeportlet-configured");
    			this._updateSlotCSSClass(portletSlot, aDtoadapter.dataBean.jsclassname);    			
    		}
    		else
    		{
    			if (portletSlot.hasClass("layout1-homeportlet-configured"))
    			{
    				this._updateSlotCSSClass(portletSlot, aDtoadapter.dataBean.jsclassname);
    			}
    		}
    	}
    	else
    	{
			if (portletSlot.hasClass("layout1-homeportlet-configured"))
            {
    			portletSlot.addClass("layout1-homeportlet-empty");
    			this._updateSlotCSSClass(portletSlot, null);    							
            }    		
    	}    	    	    	  
    },
    
    _updateSlotCSSClass: function(aPortletSlotJQObject, newJsClassName)
    {
    	var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_classifier_portlets" );
    	org.r3.PageManager.lutManager.getLUT(resolvedUrl, function(theLUT)
    	{
    		$.each(theLUT.aaData, function(index, item)
    		{
    			aPortletSlotJQObject.removeClass(item.dtokey);    				
    		});
    		
    		if (newJsClassName)
			{			
    		aPortletSlotJQObject.addClass(newJsClassName);
			}
   
    	});
    }

});
