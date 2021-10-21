$.r3Utils.namespace("org.r3.home.site");

org.r3.home.site.PageManager = 
{
  	
	 init: function()
	 {
		org.r3.PageManager.googleAnalyticsSendPageView();
			
		 if (org.r3.PageManager.userInfo.isGuest())
		 {
			 this.loginActionForm = this._initializeSlots('JSPortlet_HomeLoginActionForm');
			 this.wbsesActionForms = null;
		 }
		 else 
		 {
			 this.loginActionForm = null;
			 this.wbsesActionForms = this._initializeSlots('JSPortlet_MyWbsesPortletActionForm');
		 }
		 
		 this.myFlowPlayerActionForm = this._initializeSlots('JSPortlet_FlowPlayerPortletActionForm');
		 this.myWbsActionsActionForms = this._initializeSlots('JSPortlet_MyWbsActionsPortletActionForm');		 
		 this.myappActionForm = this._initializeSlots('JSPortlet_MyAppActionForm');	     
		 this.homeEntryListActionForm = this._initializeSlots('JSPortlet_HomeEntryListActionForm');
		 this.homeCalendarActionForm = this._initializeSlots('JSPortlet_HomeCalendarActionForm');
		 this.homeNORActionForm = this._initializeSlots('JSPortlet_HomeNORActionForm');
		 this.homeCardActionForms = this._initializeSlots('JSPortlet_HomeCardActionForm');
		 this.homeComunicatiActionForm = this._initializeSlots('JSPortlet_HomeComunicatiActionForm');
		 this.homeTrackerActionForm = this._initializeSlots('JSPortlet_HomeTrackerActionForm');
		 this.homeRankingActionForm = this._initializeSlots('JSPortlet_HomeRankingActionForm');
		 this.homeYachtClubActionForm = this._initializeSlots('JSPortlet_HomeYachtClubActionForm');
		 this.homeChannelActionForm = this._initializeSlots('JSPortlet_HomeChannelsActionForm');
		 this.homeVideoActionForms = this._initializeSlots('JSPortlet_HomeVideoActionForm');
		 this.homeTwitterActionForms = this._initializeSlots('JSPortlet_HomeTwitterActionForm');
		 this.homeFaceBookActionForms = this._initializeSlots('JSPortlet_HomeFaceBookActionForm');
		 this.homeQuizActionForms = this._initializeSlots('JSPortlet_HomeQuizActionForm');
		 
		 if ($('#JSPortlet_HomeIconMenuActionForm').length)		 		 		 
		     this.homeIconMenuActionForm = new org.r3.jsportlet.sev.homeiconmenu.HomeIconMenuActionForm(this, '#JSPortlet_HomeIconMenuActionForm');
		 
		 org.r3.PageManager.pushHomeBreadCrumb();	
		 
		 var actionForms = null;

		 actionForms = this.loginActionForm;
		 this._openSlot(actionForms);

		 actionForms = this.myFlowPlayerActionForm;
		 this._openSlot(actionForms);
		 
		 actionForms = this.myWbsActionsActionForms;
		 this._openSlot(actionForms);
		 
		 actionForms = this.myappActionForm;
		 this._openSlot(actionForms);

		 actionForms = this.homeEntryListActionForm;
		 this._openSlot(actionForms);

		 actionForms = this.homeCalendarActionForm;
		 this._openSlot(actionForms);

		 actionForms = this.homeNORActionForm;
		 this._openSlot(actionForms);

		 actionForms = this.homeCardActionForms;
		 this._openSlot(actionForms);

		 actionForms = this.homeComunicatiActionForm;
		 this._openSlot(actionForms);

		 actionForms = this.homeTrackerActionForm;
		 this._openSlot(actionForms);

		 actionForms = this.homeRankingActionForm;
		 this._openSlot(actionForms);

		 actionForms = this.homeYachtClubActionForm;
		 this._openSlot(actionForms);

		 actionForms = this.homeVideoActionForms;
		 this._openSlot(actionForms);
		 
		 actionForms = this.homeTwitterActionForms;
		 this._openSlot(actionForms);

		 actionForms = this.homeFaceBookActionForms;
		 this._openSlot(actionForms);

		 actionForms = this.wbsesActionForms;
		 this._openSlot(actionForms);

		 actionForms = this.homeQuizActionForms;
		 this._openSlot(actionForms);

		 if (this.homeIconMenuActionForm)
			 this.homeIconMenuActionForm.open();		 		 
			 	 
	 },
	
	 _openSlot: function(actionFormArray)
	 {
		 if (actionFormArray && actionFormArray.length)
		 {
			 for(var i = 0; i < actionFormArray.length; i++)
				 actionFormArray[i].open();	 
		 }				 
	 },
	 
	 _initializeSlots: function(className)
	 {		 
		 var actionforms = [];
		 
		 var jsPortletFactory = new org.r3.jsportlet.JSPortletFactory();
		 var portletJsClassName = $('.' + className);
		 for(var i = 0; i < portletJsClassName.length; i++)
	     {
	    	var item = $(portletJsClassName[i]);
	    	var slotId = item.attr("id");
	    	var dataCardId = item.attr("data-cardid");
	    	var dataOptions = item.attr("data-options");
	    	
	    	switch(className)
	    	{
	    	case 'JSPortlet_HomeVideoActionForm':
	    		if (!dataOptions)
	    			dataOptions = 'cms_tpl_embeddedfragments';
	    		break;	  
	    	}

	    	var portletActionForm = jsPortletFactory.newPortlet(this, className, slotId, dataCardId, dataOptions);
	    	if (portletActionForm)
	    		actionforms.push(portletActionForm);

	     }
		 
	     return actionforms;
	 }
	
};

