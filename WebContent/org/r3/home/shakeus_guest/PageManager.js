$.r3Utils.namespace("org.r3.home.shakeus_guest");

org.r3.home.shakeus_guest.PageManager = 
{
 
	 init: function()
	 {		    
		org.r3.PageManager.googleAnalyticsSendPageView();	
		this.loginActionForm = new org.r3.jsportlet.login.LoginActionForm(
				this, '#JSPortlet_LoginActionForm', { "templateFileName": "ShakeUsLoginActionForm.html" });		
		
		if (!org.r3.PageManager.isSmallDevice())
		{
		$('#ShakeUSSplash').cmsCard(
		{
			pageid: 'CMSCARD_PAGEID_PARAM',
			card_tmpl : "cms_tpl_embeddedfragments",
			cardid : "SHKSPLASH",
			site: org.r3.SiteConstants.sitedomain,
			onComplete : function(responseInfo, totalNumberOfItems)
			{			
			}
		});	
		
		$('#ShakeUSSplash2').cmsCard(
		{
			pageid: 'CMSCARD_PAGEID_PARAM',
			card_tmpl : "cms_tpl_embeddedfragments",
			cardid : "SHKSPLASH2",
			site: org.r3.SiteConstants.sitedomain,
			onComplete : function(responseInfo, totalNumberOfItems)
			{			
			}
		});			
		}
		   

		$('#ShakeUSSplash3').cmsCard(
		{
			pageid: 'CMSCARD_PAGEID_PARAM',
			card_tmpl : "cms_tpl_embeddedfragments",
			cardid : "SHKSPLASH3",
			site: org.r3.SiteConstants.sitedomain,
			onComplete : function(responseInfo, totalNumberOfItems)
			{			
			}
		});	
		
		this.registrationActionForm = new org.r3.jsportlet.registration.RegistrationActionForm(this, '#JSPortlet_RegistrationActionForm');
		
		this.loginActionForm.open();
		this.registrationActionForm.open({ templateHtml: 'RegistrationActionForm_Mod2.html' });
	 }

};

