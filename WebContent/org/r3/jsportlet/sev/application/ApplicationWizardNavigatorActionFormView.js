$.r3Utils.namespace("org.r3.jsportlet.sev.application");

org.r3.jsportlet.sev.application.ApplicationWizardNavigatorActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		$(this.htmlContainerId).wizardnavigator('destroy');
		this.hide();
	},

	refresh : function()
	{
	},

	open : function(aCompanyDTOAdapter, navigatorSteps)
	{
		// $('#wizardnavigator')
		$(this.htmlContainerId).wizardnavigator(
		{			
			steps : navigatorSteps
		});

		this.show();

	},
	
	stepHandler: function(stepId)
	{
		console.info("Stepid is: ", stepId);
	},
	
	next: function()
	{
		console.info("Ciao");
		var stepInfo = $(this.htmlContainerId).wizardnavigator("next");
		return stepInfo;		
	},
	
	prev: function()
	{
		var stepInfo = $(this.htmlContainerId).wizardnavigator("prev");
		return stepInfo;		
	},
	
	selected: function()
	{
		var stepInfo = $(this.htmlContainerId).wizardnavigator("selected");
		return stepInfo;				
	},

	find: function(aStepId)
	{
		var stepInfo = $(this.htmlContainerId).wizardnavigator("find", aStepId);
		return stepInfo;				
	}

});
