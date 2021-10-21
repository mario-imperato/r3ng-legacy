$.r3Utils.namespace("org.r3.console.sev.ranking");

org.r3.console.sev.ranking.RankingDetailActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, anOuterCanvasContainerId, aDetailViewContainerId, aChildEntityListViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailActionFormCanvas = anOuterCanvasContainerId;
		this.detailView = new org.r3.console.sev.ranking.RankingDetailActionFormView(aDetailViewContainerId, this);

		// this.listView = new it.posteitaliane.unep.anagrafica.GruppoQueryActionFormView(anHtmlActionFormContainerId, this);
		// grade_clickable
		this.listView = new org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewQueryActionFormView
		(
				aChildEntityListViewContainerId, 
				this,
				{
					dataTableId : 'RankingInstanceQueryActionFormView',
					gradeLevel : 'grade_level5 grade_clickable',
					legend : 'Elenco Classifiche Prove/Classifiche Generali',	
					iDisplayLength: 25,
					layout : 'fullWidth',
					canvasType : 'list-group',
					sortable: false,
					// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
					dataTableColumns : "multiselector,instanceid,racenumber,racedate,racetime,racedistance,racerating,rectimestamp",
					requiredLUTs : [ 
                        "GET_classifier_sys_recstatus" ],
					
                    onDblClick : null,
                    onSelected :  $.r3Utils.hitch(this, this.instanceDetail),
					onClearSelection : null,
					
					actionBarOnTop: true,
					buttons : [
					{
						id : 'console_ranking_action_deleteinstance',
						label : 'Elimina risultati prove',
						disabled : true,
						onClick : $.r3Utils.hitch(this, function() { this.removeInstances(); })
					}
                    ],

					onInitializationComplete: function()
					{
						$('#RankingInstanceQueryActionFormView_all_instanceid').unbind().click(function(e)
						{
							var currentTarget = $(e.currentTarget);
							
							if (currentTarget.prop('checked'))
							{
								$('#console_ranking_action_deleteinstance').prop('disabled', false);	
							    $("#RankingInstanceQueryActionFormView_tableform input[type='checkbox'][name='instanceid']").prop('checked', true);
							}
							else 
							{
								$('#console_ranking_action_deleteinstance').prop('disabled', true);	
								$("#RankingInstanceQueryActionFormView_tableform input[type='checkbox'][name='instanceid']").prop('checked', false);
							}
						});
						
						$('#RankingInstanceQueryActionFormView').bind('page', function () {
							$('#RankingInstanceQueryActionFormView_all_instanceid').prop('checked', false);
							$('#console_ranking_action_deleteinstance').prop('disabled', true);	
						});
						
						var matchExpr = "#RankingInstanceQueryActionFormView_tableform input[type='checkbox'][name='instanceid']";
						$(document).off('click', matchExpr).on('click', matchExpr, function(e) {
							$('#RankingInstanceQueryActionFormView_all_instanceid').prop('checked', false);
							
							var numberOfSelected = 0;
							$.each($("#RankingInstanceQueryActionFormView_tableform input[type='checkbox'][name='instanceid']"), function(index, item)
							{
								if ($(item).prop('checked'))
									numberOfSelected++;
							});

							if (numberOfSelected)
							{
								$('#console_ranking_action_deleteinstance').prop('disabled', false);	
							}
							else
							{
								$('#console_ranking_action_deleteinstance').prop('disabled', true);									
							}
							
							e.stopPropagation();
						});						
						
					}
				}
		);

	},

	close : function()
	{
		// M20140201 - org.r3.PageManager.popBreadCrumb();
		this.hide();
	},

	hide : function()
	{
		this.detailView.hide();
		this.listView.hide();
		$(this.detailActionFormCanvas).hide();
	},

	show : function()
	{
		this.detailView.show();
		this.listView.show();
		$(this.detailActionFormCanvas).show();
	},

	refresh: function()
	{
	   this.listView.refresh();	
	},
	
	open : function(aRankId)
	{
		this.setDataBeanInfo(aRankId);
		this.detailView.open(aRankId);		

		if (aRankId)
		{
		    this._openListOfRaces(aRankId);
		}
		
		$(this.detailActionFormCanvas).show();
	},

	_openListOfRaces: function(aRankId)
	{
		var dataTableSource = org.r3.PageManager.getRESTUrl('GET_Ranking_Instances', [ aRankId ]);
		
		this.listView.open({
				"dataTableSource": dataTableSource,
				"onInitializationCompleteArgs": arguments
		});
	},
	
	updateItem : function(onSuccessResponse, onFailResponse)
	{
		this._saveItem(true, onSuccessResponse, onFailResponse);
	},

	createItem : function(onSuccessResponse, onFailResponse)
	{
		this._saveItem(false, onSuccessResponse, onFailResponse);
	},

	_saveItem : function(isUpdate, onSuccessResponse, onErrorResponse)
	{
		var _self = this;
		
		var theForm = $('#rankingdetailactionform_form');
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
		{
			var method = "post";
			var restUrl = org.r3.PageManager.getRESTUrl('POST_Ranking');
			if (isUpdate)
			{
				var rankId = this.dataBeanInfo;
				restUrl = org.r3.PageManager.getRESTUrl('PUT_Ranking', [ rankId ]);
				method = "put";
			}

			org.r3.PageManager.wait("org.r3.message.waiting");
			theForm.ajaxSubmit(
			{
				"type" : method,
				"url" : restUrl,
				"dataType" : "json",
				"success" : function(responseData)
				{
					org.r3.PageManager.closeNotifier();
					if (onSuccessResponse)
						onSuccessResponse(responseData);	
					
					var rankingDataBean = new org.r3.db.sailevent.ranking.RankingDTOAdapter(responseData);	
					if (method == 'put')
					{						  
						  _self.pageManager.onRankingUpdate(rankingDataBean);						
					}
					else  
					{
						_self.pageManager.onRankingCreate(rankingDataBean);		
					}					
				},
				
				"error": function(jqXHR, timeout, message)
				{
					console.log(arguments);
					org.r3.PageManager.closeNotifier();
					if (onErrorResponse)
						onErrorResponse(jqXHR, timeout, message);
				}
			});
		}
	},
		
	deleteItem: function(onSuccessResponse, onErrorResponse)
	{
		var _self = this;
		
		if (org.r3.PageManager.confirmation("org.r3.message.deleteconfirm"))
		{
			var method = "delete";
			var rankId = this.dataBeanInfo;
			var restUrl = org.r3.PageManager.getRESTUrl('DELETE_Ranking', [ rankId ]);

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
					
					org.r3.PageManager.back();
				},
				
				"error": function(jqXHR, timeout, message)
				{
					console.log(arguments);
					org.r3.PageManager.closeNotifier();
					if (onErrorResponse)
						onErrorResponse(jqXHR, timeout, message);
				}
			});
		}
	},
	
	removeInstances: function()
	{
		
		var _self = this;
		
		var theForm = $('#RankingInstanceQueryActionFormView_tableform');
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.deletemulticonfirm"))
		{
			var rankId = this.dataBeanInfo;
			restUrl = org.r3.PageManager.getRESTUrl('DELETE_Ranking_Instances', [ rankId ]);
			method = "put";

			org.r3.PageManager.wait("org.r3.message.waiting");
			theForm.ajaxSubmit(
			{
				"type" : method,
				"url" : restUrl,
				"dataType" : "json",
				"success" : function(responseData)
				{
					org.r3.PageManager.closeNotifier();
					$('#console_ranking_action_deleteinstance').prop('disabled', true);
					_self.listView.refresh();
				},
				
				"error": function(jqXHR, timeout, message)
				{
					console.error(message);
					org.r3.PageManager.closeNotifier();
				}
			});
		}
	},
	
	instanceDetail: function(aRankingInstanceDTOAdapter)
	{
		this.hide();
		this.pageManager.instanceDetail(aRankingInstanceDTOAdapter);
	}
		

});

