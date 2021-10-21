$.r3Utils.namespace("org.r3.home.shakeus");

org.r3.home.shakeus.PageManager = 
{
 
	 init: function()
	 {		    
		org.r3.PageManager.googleAnalyticsSendPageView();	
		
		 this.mapExplorerActionForm = new org.r3.jsportlet.mapexplore.MapExplorerActionForm (this, '#JSPortlet_MapExplorerActionForm');
		 this.mapExplorerActionForm.open();	
	 }	 
	
};

