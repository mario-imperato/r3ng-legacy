$.r3Utils.namespace("org.r3.jsportlet.mongotimeline.tuner");

org.r3.jsportlet.mongotimeline.tuner.TimelineTunerActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.targetTimelinectionForm = null;
		this.newPrimaryActionEnabled = false;
	},

	close : function()
	{		
		this.hide();
	},

	refresh : function()
	{
	},

	open : function(aTimelinectionForm)
	{
		var _self = this;		
		
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/mongotimeline/tuner/TimelineTunerActionFormView.html.jsp'),
			dataType : "html"
		});

		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_Timelines'));
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_graphcontentdef'));
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_contentclassdef'));	
		   
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{			 				
			var timelines = org.r3.PageManager.lutManager.getLUT(org.r3.PageManager.getRESTUrl("LUT_Timelines"));
			
			$(this.htmlContainerId).html(tmpl(responseData['view'], { "timelines" : timelines }));
			
			$('#timelinetuner_timelineid').unbind().change(function(e) 
			{
				var currentTarget = $(e.currentTarget);
				var l = currentTarget.val();
				
				var tl = org.r3.PageManager.lutManager.getLUTItem(org.r3.PageManager.getRESTUrl("LUT_Timelines"), l);
			   _self.onSelectedTimeline(tl);
			});
			
			if (timelines && timelines.aaData && timelines.aaData.length)
			{
				this.onSelectedTimeline(timelines.aaData[0]);
			}
			
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});	
	},
	
	onSelectedTimeline: function(aTimelineDataBean)
	{
		// Attenzione: il parametro di ingresso proviene da una LUT e non è un DTOAdapter ma direttamente un plain dataBean.
		var timelineDTOAdapter = new org.r3.db.mongo.timelinecollection.TimelineCollectionDTOAdapter(aTimelineDataBean);
		$('#timelinetuner_timelinedescription').html(timelineDTOAdapter.dataBean.description);
		this._setupTimelineGlobalActions(timelineDTOAdapter)
		this.actionFormManager.activateTimeline({ 
			timelineURL: org.r3.PageManager.getRESTUrl("GET_TimelineOfPosts", [ org.r3.Constants.site, org.r3.Constants.language ]) + "&timelineid=" + aTimelineDataBean.timelineid
		});
	},
	
	_setupTimelineGlobalActions: function(timelineDTOAdapter)
	{		
		var _self = this;
		
		/*
		 * Debbo determinare se debbo attivare il pulsante di creazione nuovo post oppure no. In
		 * questa versione il pulsante è dipendente dalla timeline.
		 */
		this.newPrimaryActionEnabled = false;
		if (!org.r3.PageManager.userInfo.isGuest() && timelineDTOAdapter.dataBean.allowedcontent && timelineDTOAdapter.dataBean.allowedcontent.length)
		{
			var dropDownULContainer = $('#timelinetuner_newprimarypost_action > ul');
			dropDownULContainer.empty();
			timelineDTOAdapter.dataBean.allowedcontent.forEach(function(item) 
			{
				var contentClassDefinitionDTOAdapter = org.r3.db.mongo.contentdefinitioncollection.getContentClassDefinition(item);
				if (contentClassDefinitionDTOAdapter.isActionEnabled('new-post'))
				{
					_self.newPrimaryActionEnabled = true;		
					dropDownULContainer.append("<li><a href='#' data-action='newprimary:" + contentClassDefinitionDTOAdapter.dataBean.dtokey + "'>" + contentClassDefinitionDTOAdapter.dataBean.dtodescr + "</a></li>"); 					
				}			
			});
		}
		
//		var postContentClass = timelineDTOAdapter.dataBean.allowedcontent[0];
//		if (postContentClass && !org.r3.PageManager.userInfo.isGuest())
//		{
//			var contentClassDefinitionDTOAdapter = org.r3.db.mongo.contentdefinitioncollection.getContentClassDefinition(postContentClass);
//			this.newPrimaryActionEnabled = contentClassDefinitionDTOAdapter.isActionEnabled('new-post');
//		}
		
		
		if (this.newPrimaryActionEnabled)
		{
			$('#timelinetuner_newprimarypost_action').show();
			$('#timelinetuner_newprimarypost_action li a').unbind().click($.r3Utils.hitch(this, this._onNewPost));
		}
		else 
		{
			$('#timelinetuner_newprimarypost_action').hide();
		}

		$('#timelinetuner_refreshtimeline_action').unbind().click($.r3Utils.hitch(this, this._onRefreshTimeline));
		
		// L'ActionBar Ptrebbe essere non visibile se switch mentre sto in editing di un nuovo messaggio (che la nasconde..)
		$('#timelinetuner_timeline_actionbar').show();
		
		// $('#timelinetuner_newprimarypost_action').attr('data-action', 'newprimary:' + postContentClass);
		$('#timelinetuner_refreshtimeline_action').attr('data-action', 'refresh' /* + ':' + timelineDTOAdapter.dataBean.timelineid */);		
	},
	
	_onRefreshTimeline: function(e)
	{
		var tl = org.r3.PageManager.lutManager.getLUTItem(org.r3.PageManager.getRESTUrl("LUT_Timelines"), $('#timelinetuner_timelineid').val());
		this.onSelectedTimeline(tl);
	},
	
	_onNewPost: function(e)
	{
		var target = $(e.target);
		var dataAction = target.attr('data-action');
		var dataActionTarget = target;
		var ps = null, cm = null;
		
		if (!dataAction)
		{
		   ps = target.parents('[data-action]');
		   if (ps.length > 0)
		   {
			   dataActionTarget = $(ps[0]); 
			   dataAction = dataActionTarget.attr('data-action');   
		   }			
		}
	
		if (dataAction != null)
		{
		   var dataActionPath = dataAction.split(':');
		   switch(dataActionPath[0])
		   {
		   case 'newprimary':
			   this.actionFormManager.newPost(dataActionPath[1], $('#timelinetuner_timelineid').val());
			   break ;
		   }
		}
	},
	
	onTimelineEvent: function(aTimelineEvent)
	{
		switch(aTimelineEvent.event)
		{
		case 'newprimarypost':
			$('#timelinetuner_newprimarypost_action').hide();			
			break;

		case 'close':
			this.close();			
			break;

		default:
			if (this.newPrimaryActionEnabled)
			 $('#timelinetuner_newprimarypost_action').show();
			
			break;
		}
	}

		
});
