$.r3Utils.namespace("org.r3.console.sev.ranking");


org.r3.console.sev.ranking.RankingDetailActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},

	open : function(aRankId)
	{
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/sev/ranking/RankingDetailActionFormView.html.jsp?mode=detail'),
			dataType : "html"
		});

		if (aRankId)
		{
			networkRequestsQueue.push(
			{
				id : "content",
				type : "Get",
				url : org.r3.PageManager.getRESTUrl('GET_Ranking_Detail', [ aRankId ]),
				dataType : "json"
			});
		}

		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			var rankingDataBean = responseData['content'];
			if (rankingDataBean)
			{
				rankingDataBean = new org.r3.db.sailevent.ranking.RankingDTOAdapter(rankingDataBean);
			}

			$(this.htmlContainerId).html(responseData['view']);

			$('#rankingdetailactionform_form').validate(
			{
				errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
				rules : org.r3.console.sev.ranking.rankingdetailactionform_form_validationRules,
				messages : org.r3.console.sev.ranking.rankingdetailactionform_form_validationMessages
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
			
			this._initializeFormFields(rankingDataBean);
			
			if (rankingDataBean == null)
			{
				$('#rankingdetailactionform_action_saveitem').click(
						$.r3Utils.hitch(this, this._onCreateItem));			
				$('#rankingdetailactionform_action_deleteitem').hide();
			}
			else
			{				
				$('#rankingdetailactionform_action_saveitem').click(
						$.r3Utils.hitch(this, this._onUpdateItem));
				$('#rankingdetailactionform_action_deleteitem').unbind().click($.r3Utils.hitch(this, this._onDeleteItem));
				$('#rankingdetailactionform_action_deleteitem').show();
			}
		
			$('#rankingdetailactionform_fieldset_message').formmessage({});
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
		var _self = this;
		this.actionFormManager.createItem(
				function(responseData) { 
					$('#rankingdetailactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });					
		        }, 
				function(jqXHR, timeout, message) { $('#rankingdetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},
	
	_onDeleteItem: function()
	{
		var _self = this;
		this.actionFormManager.deleteItem(
				function(responseData) { 					
		        }, 
				function(jqXHR, timeout, message) { $('#rankingdetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},
	
	_onUpdateItem: function()
	{
		this.actionFormManager.updateItem(
				function(responseData) { 		
					$('#rankingdetailactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });
		        }, 
				function(jqXHR, timeout, message) { $('#rankingdetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},
	
	_initializeFormFields: function(anRankingDTOAdapter)
	{
		if (anRankingDTOAdapter)
		{
			$('#rankingdetailactionform_rankid').html(anRankingDTOAdapter.dataBean.rankid + ' - ');
			$('#rankingdetailactionform_ranktitle').val(anRankingDTOAdapter.dataBean.ranktitle);
			$('#rankingdetailactionform_rankordering').val(anRankingDTOAdapter.dataBean.rankordering);
			$('#rankingdetailactionform_racefilepattern').val(anRankingDTOAdapter.dataBean.racefilepattern);
			$('#rankingdetailactionform_overallfilepattern').val(anRankingDTOAdapter.dataBean.overallfilepattern);
			$('#rankingdetailactionform_championship_' + anRankingDTOAdapter.dataBean.championship).prop('checked', true);
			$('#rankingdetailactionform_rating_' + anRankingDTOAdapter.dataBean.rating).prop('checked', true);			
		}
		else
		{
			$('#rankingdetailactionform_championship_bfalse').prop('checked', true);
			$('#rankingdetailactionform_rating_rank_orc').prop('checked', true);						
		}
		
		var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_classifier_r3ea_sinott" );
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : resolvedUrl,
			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
			"selectWidget" : $('#rankingdetailactionform_rankinggroup'),
			"selectedValue": anRankingDTOAdapter && (anRankingDTOAdapter.dataBean.rankinggroup)
		});
		
        $('#rankingdetailactionform_racegrooup_cascade select').cascadingSelect({
	      	   lutManager : org.r3.PageManager.lutManager,
	      	   ajaxUrlMode: 'restful',
	      	   withNullOption: true,
	      	   widgetConfig: [
	      	      { 'widgetId': 'rankingdetailactionform_racegroup', 
	      	    	'ajaxSource': org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_boatgroup'),
	      	    	'value': anRankingDTOAdapter && (anRankingDTOAdapter.dataBean.racegroup)
	      	      },
	      	    	
	      	      { 'widgetId': 'rankingdetailactionform_raceclass' , 
	      	    	'ajaxSource': org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_racegroup_raceclass'), 
	      	    	'value': anRankingDTOAdapter && (anRankingDTOAdapter.dataBean.raceclass)
	      	      }]
	    });

	}

});
