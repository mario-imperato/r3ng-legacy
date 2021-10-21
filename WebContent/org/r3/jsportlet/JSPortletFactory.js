$.r3Utils.namespace("org.r3.jsportlet");

org.r3.jsportlet.JSPortletFactory = Class.extend(
{
	 init : function()
	 {		
	 },

	 newPortlet: function(aPageManager, className, slotId, cmsCardId, portletOptions)
	 {		 	 	    	
    	var portletActionForm = null;
    	switch(className)
    	{
    	case 'JSPortlet_HomeCardActionForm':
    		portletActionForm = new org.r3.jsportlet.sev.homecard.HomeCardActionForm(aPageManager, '#' + slotId, cmsCardId, portletOptions);
    		break;
    	case 'JSPortlet_HomeVideoActionForm':
    		portletActionForm = new org.r3.jsportlet.sev.homecard.HomeCardActionForm(aPageManager, '#' + slotId, cmsCardId, portletOptions);
    		break;	  
    	case 'JSPortlet_HomeTwitterActionForm':
    		portletActionForm = new org.r3.jsportlet.sev.hometwitter.HomeTwitterActionForm(aPageManager, '#' + slotId, cmsCardId, portletOptions);
    		break;	    		
    	case 'JSPortlet_HomeFaceBookActionForm':
    		portletActionForm = new org.r3.jsportlet.sev.homefacebook.HomeFaceBookActionForm(aPageManager, '#' + slotId, cmsCardId, portletOptions);
    		break;	    		
    	case 'JSPortlet_MyAppActionForm':
    		portletActionForm = new org.r3.jsportlet.sev.myapp.MyAppActionForm(aPageManager, '#' + slotId);
    		break;
    	case 'JSPortlet_HomeEntryListActionForm':
    		portletActionForm = new org.r3.jsportlet.sev.homeentrylist.HomeEntryListActionForm(aPageManager, '#' + slotId);
    		break;
    	case 'JSPortlet_HomeCalendarActionForm':
    		portletActionForm = new org.r3.jsportlet.sev.homecalendar.HomeCalendarActionForm(aPageManager, '#' + slotId);
    		break;
    	case 'JSPortlet_HomeNORActionForm':
    		portletActionForm = new org.r3.jsportlet.sev.homenorlist.HomeNORActionForm(aPageManager, '#' + slotId);
    		break;
    	case 'JSPortlet_HomeComunicatiActionForm':
    		portletActionForm = new org.r3.jsportlet.sev.homecomunicati.HomeComunicatiActionForm(aPageManager, '#' + slotId);
    		break;
    	case 'JSPortlet_HomeRankingActionForm':
    		portletActionForm = new org.r3.jsportlet.sev.homeranking.HomeRankingActionForm(aPageManager, '#' + slotId);
    		break;
    	case 'JSPortlet_HomeYachtClubActionForm':
    		portletActionForm = new org.r3.jsportlet.sev.homeyachtclub.HomeYachtClubActionForm(aPageManager, '#' + slotId);
    		break;
    	case 'JSPortlet_HomeTrackerActionForm':
    		portletActionForm = new org.r3.jsportlet.sev.hometracker.HomeTrackerActionForm(aPageManager, '#' + slotId);
    		break;
    	case 'JSPortlet_HomeLoginActionForm':
    		portletActionForm = new org.r3.jsportlet.sev.homelogin.HomeLoginActionForm(aPageManager, '#' + slotId);
    		break;
    	case 'JSPortlet_HomeChannelsActionForm':
			$('#' + slotId).cmsCard({ 
				card_tmpl: "cms_tpl_regatta_channelshomeportlet", 
				cardquery: "channelid=CHN09",
				pageid: aPageManager.pageId,
			    onComplete: function()
			    {
			    }
			});		    		
    		break;
    	case 'JSPortlet_MyWbsesPortletActionForm':
    		portletActionForm = new org.r3.jsportlet.wbs.MyWbsesPortletActionForm(aPageManager, '#' + slotId);
    		break;

    	case 'JSPortlet_MyWbsActionsPortletActionForm':
    		portletActionForm = new org.r3.jsportlet.wbs.mytodolist.MyWbsNodesToDoListPortletActionForm(aPageManager, '#' + slotId);
    		break;    	
    		
    	case 'JSPortlet_FlowPlayerPortletActionForm':
    		portletActionForm = new org.r3.jsportlet.flowplayer.FlowPlayerPortletActionForm(aPageManager, '#' + slotId);
    		break;   
    	case 'JSPortlet_HomeQuizActionForm':
    		portletActionForm = new org.r3.jsportlet.sev.homequiz.HomeQuizActionForm(aPageManager, '#' + slotId, portletOptions);
    		break;    		
    	}	    	     
		 
	     return portletActionForm;
	 }

});
