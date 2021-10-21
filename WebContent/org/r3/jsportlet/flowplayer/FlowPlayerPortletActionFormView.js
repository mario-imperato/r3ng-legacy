$.r3Utils.namespace("org.r3.jsportlet.flowplayer");

org.r3.jsportlet.flowplayer.FlowPlayerPortletActionFormView = org.r3.ActionFormView.extend(
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
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/flowplayer/FlowPlayerPortletActionForm.html.jsp'),
			dataType : "html"
		});
						
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	
		
 		    $(this.htmlContainerId).html(responseData['view']);	 
 		    // Il JS FlowPlayer e' stato modificato alla riga 2948. 
 		    $('#webcamplayer').flowplayer({ 		    	
 		    		
 		    		live: true, 
 		    		ratio: 9/16,  
 		    		wmode: 'direct',
 		    		embed: false, 

 		    		time: false, 

 		    		 
 		    		muted: false, 

 		    		volume:1.0, 

 		    		
 		    		wmode: "direct",
 		    		
 		    		clip: { 
 		    		sources: [ 
 		    		          
 		    		{ type: "application/x-mpegurl", src: "http://95.110.157.56:1935/streamfiumicino(rm)/streamfiumicino(rm).stream/playlist.m3u8" }, 
 		    		{ type: "video/webm", src: "rtmp://" }, 
 		    		{ type: "video/mp4", src: "rtmp://" } 
 		    		 
 		    		], 

 		    		accelerated: true,
 		    		title: "Nautilus - Fiumicino"
 		    		}


 		    });
 		    
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
		
	}
		
		
});
