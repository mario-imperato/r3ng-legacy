$.r3Utils.namespace("org.r3.sev.entrylist");

org.r3.sev.entrylist.PageManager = 
{
  	
	 init: function()
	 { 
 		 org.r3.PageManager.googleAnalyticsSendPageView();
					 
		 this.entryListActionForm = new org.r3.jsportlet.sev.entrylist.EntryListActionForm(this, '#JSPortlet_SEVEntryListActionForm');		 
		 this.openEntryListPortlet();
	 },
	 
	 openEntryListPortlet : function()
	 {
		 org.r3.PageManager.pushHomeBreadCrumb();			 
	 	 org.r3.PageManager.pushBreadCrumb(
		 {
			"title" : "Lista Iscritti",
			"actionForm" : this.entryListActionForm
		 });

		this.entryListActionForm.open();
	 }
	 

};

