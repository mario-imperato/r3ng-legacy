$.r3Utils.namespace("org.r3.jsportlet.mongotimeline.tuner");

org.r3.jsportlet.mongotimeline.tuner.TimelineTunerActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aTimeLineTunerViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.tunerView = new org.r3.jsportlet.mongotimeline.tuner.TimelineTunerActionFormView(aTimeLineTunerViewContainerId, this);		
		
		// Mantengo un riferimento alla timeline collegata. La timeline all'apertura avrà un riferimento al tuner.
		// In pratica i due hanno dei riferimenti reciproci per permettere di comunicare.
		this.timelineActionForm = null;
	},

	close : function()
	{
		this.tunerView.close();
	},

	hide : function()
	{
		this.tunerView.hide();
	},

	show : function()
	{
		this.tunerView.show();
	},

	refresh : function()
	{
		
	},

	open : function(aTimelinectionForm)
	{	   
		this.targetTimelinectionForm = aTimelinectionForm;
       this.tunerView.open();		       
	},
	
	activateTimeline: function(aSetOfTimelineParams)
	{		
		// console.log("Activating MongoTimeline: " + aSetOfTimelineParams.timeline.timelineid);
		this.pageManager.activateMongoTimeline(aSetOfTimelineParams);		
	},
	
	newPost: function(aContentDefinitionId, aTimelineId)
	{
		this.targetTimelinectionForm.newPost(aContentDefinitionId, aTimelineId);		
	},
	
	onTimelineEvent: function(aTimelineEvent)
	{
		this.tunerView.onTimelineEvent(aTimelineEvent);
	}

	
	
});

