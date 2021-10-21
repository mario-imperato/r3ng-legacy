$.r3Utils.namespace("org.r3.console.cms.cards");

org.r3.console.cms.cards.CardChannelQueryActionForm = org.r3.ActionFormManager.extend(
{
	init : function(aPageManager, anHtmlActionFormContainerId, anAdvancedSearchHtmlActionFormContainerId)
	{
		this.setPageManager(aPageManager);

		this.listView = new org.r3.db.cms.cardchannelview.CardChannelViewQueryActionFormView(anHtmlActionFormContainerId, this,
		{
			dataTableId : 'CardChannelViewQueryActionFormView',
			layout : 'fullWidth',
			iDisplayLength: 25,
			gradeLevel : 'grade_level2 grade_clickable',
			legend : org.r3.db.cms.cardchannelview.message.queryactionformview_legend,
			dataTableSource : 'GET_CMSCardChannels',
			sortable: true,
			// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
			dataTableColumns : "multiselector,channelid;sort,site;sort,cardid;sort,title,summary,refdate;sort",
			// requiredLUTs : [ "GET_classifier_usr_type", "LUT_UNEPAreaOrganizzativa", "LUT_UNEPCentroLavorazione", "LUT_UNEPCentroEsiti", "LUT_UNEPGruppoCliente", "LUT_UNEPCliente" ],

			onSelected : null,
			onDblClick : null,
			
			onClearSelection : function() { 
				$('#cardqueryactionform_action_deleteItem').prop('disabled', true);
			},

			requiredLUTs : [ 
	            "LUT_CMS_Channels", "LUT_Site" ],
	                        
			searchInfo :
			{
                widget: 'select',

          		widgetInitialization: {
          			url: org.r3.PageManager.getRESTUrl('LUT_CMS_Channels'),
          			blankOptionText: org.r3.PageManager.getMessageFromDict("org.r3.console.cms.cards.message.any")
          		},
          		
          	    label: org.r3.console.cms.cards.message.search_chanel,
          	    validationRules: org.r3.console.cms.cards.CardChannelQueryActionFormView_filter_searchform_validationRules,
          	    validationMessages: org.r3.console.cms.cards.CardChannelQueryActionFormView_filter_searchform_validationMessages,
          	    autoStart: true
          	},

          	actionBarOnTop: true,
			buttons : [
			{
				id : 'console_cardchannel_action_delete',
				label : org.r3.console.cms.cards.message.action_deleteselectedcardchannels,
				disabled : true,
				onClick : $.r3Utils.hitch(this, function() { this.onDeleteCardChannels(); })
			}],
			
			onInitializationComplete: function()
			{
				$('#CardChannelViewQueryActionFormView_all_channelid_site_cardid').unbind().click(function(e)
				{
					var currentTarget = $(e.currentTarget);
					
					if (currentTarget.prop('checked'))
					{
						$('#console_cardchannel_action_delete').prop('disabled', false);	
					    $("#CardChannelViewQueryActionFormView_tableform input[type='checkbox'][name='channelid_site_cardid']").prop('checked', true);
					}
					else 
					{
						$('#console_cardchannel_action_delete').prop('disabled', true);	
						$("#CardChannelViewQueryActionFormView_tableform input[type='checkbox'][name='channelid_site_cardid']").prop('checked', false);
					}
				});
				
				$('#CardChannelViewQueryActionFormView').bind('page', function () {
					$('#CardChannelViewQueryActionFormView_all_channelid_site_cardid').prop('checked', false);
					$('#console_cardchannel_action_delete').prop('disabled', true);	
				});
				
				var matchExpr = "#CardChannelViewQueryActionFormView_tableform input[type='checkbox'][name='channelid_site_cardid']";
				$(document).off('click', matchExpr).on('click', matchExpr, function(e) {
					$('#CardChannelViewQueryActionFormView_all_channelid_site_cardid').prop('checked', false);
					
					var numberOfSelected = 0;
					$.each($("#CardChannelViewQueryActionFormView_tableform input[type='checkbox'][name='channelid_site_cardid']"), function(index, item)
					{
						if ($(item).prop('checked'))
							numberOfSelected++;
					});

					if (numberOfSelected)
					{
						$('#console_cardchannel_action_delete').prop('disabled', false);	
					}
					else
					{
						$('#console_cardchannel_action_delete').prop('disabled', true);									
					}
					
					e.stopPropagation();
				});						
				
			}

		});

	},

	close : function()
	{
		// M20140201 - org.r3.PageManager.popBreadCrumb();
		this.listView.hide();
	},

	open : function()
	{
		this.listView.open();			
	},

	hide : function()
	{
		this.listView.hide();
	},

	show : function()
	{
		this.listView.show();
	},

	refresh : function()
	{
		this.listView.refresh();
	},
	
	onDeleteCardChannels: function()
	{		
		var _self = this;						
		
		var theForm = $('#CardChannelViewQueryActionFormView_tableform');
		org.r3.AjaxUtils.submitForm(
				"PUT", 
				org.r3.PageManager.getRESTUrl('DELETE_Selected_CardChannel'),  
				theForm, 
				function(responseData) { _self.listView.refresh(); }, 
				function(jqXHR, timeout, message) { console.error(message); },
				"org.r3.message.deletemulticonfirm",
		        true);				
		
	}

});

