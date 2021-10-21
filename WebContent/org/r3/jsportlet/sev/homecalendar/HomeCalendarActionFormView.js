$.r3Utils.namespace("org.r3.jsportlet.sev.homecalendar");

org.r3.jsportlet.sev.homecalendar.HomeCalendarActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},
	
	open : function()
	{
		// console.info('SiteConstants:', org.r3.SiteConstants);
		
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/homecalendar/HomeCalendarActionForm.html.jsp'),
			dataType : "html"
		});
				
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_Agenda', [ org.r3.Constants.site ]));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	
		
			var restUrl = org.r3.PageManager.getRESTUrl('LUT_Agenda', [ org.r3.Constants.site ]);
			var theLut = org.r3.PageManager.lutManager.getLUT(restUrl);
			var calendarAdapterArray = [];
			if (theLut && theLut.aaData && theLut.aaData.length)
			{
			    for(var i = 0; i < theLut.aaData.length; i++)	
			    {
			         calendarAdapterArray.push(new org.r3.db.agenda.agendaentry.AgendaEntryDTOAdapter(theLut.aaData[i]));	
			    }
			}
 		    
			var templatedHtml = tmpl(responseData['view'], { "calendarData": calendarAdapterArray });
 		    $(this.htmlContainerId).html(templatedHtml);			
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
		
	}
		
		
});
