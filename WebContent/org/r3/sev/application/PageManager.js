$.r3Utils.namespace("org.r3.sev.application");

org.r3.sev.application.PageManager = 
{
  	
	 init: function(applicationId)
	 { 
		 // Viene Gestito dall'ActionForm. Internamente Dato che e' multi-pagina
		 // org.r3.PageManager.googleAnalyticsSendPageView();
					 
		 this.applicationActionForm = new org.r3.jsportlet.sev.application.ApplicationActionForm(this, '#JSPortlet_SEVApplicationActionForm');		 
		 this._retrieveApplication(applicationId);
	 },

	 _retrieveApplication: function(applicationId)
	 {
		 org.r3.PageManager.wait("org.r3.message.waiting");
		 
		var _self = this;
		$.ajax(
		{
			"type" : "get",
			"url" : org.r3.PageManager.getRESTUrl('GET_SEV_Application_Detail', [ applicationId ] ),
			"dataType" : "json",
			"success" : function(responseData)
			{
				org.r3.PageManager.closeNotifier();
				if (org.r3.PageManager.isRestDTO(responseData))
				{
					var restDto = new org.r3.RestDTOAdapter(responseData);
					console.error("Whatta...");
					// restDto.showMessage('searchactionform_form_fieldset_message');
				}
				else 
				{
					var applicationDTOAdapter = new org.r3.db.sailevent.application.SailApplicationDTOAdapter(responseData);
					_self.openApplicationPortlet(applicationDTOAdapter);
				}
				
			},

			"error" : function(jqXHR, timeout, message)
			{
				console.error("...> error");
				org.r3.PageManager.closeNotifier();
			}
		});	 
	 },
	 
	 openApplicationPortlet : function(applicationDTOAdapter)
	 {
		 org.r3.PageManager.pushHomeBreadCrumb();		 
	 	 org.r3.PageManager.pushBreadCrumb(
		 {
			"title" : "Modulo Iscrizione",
			"actionForm" : this.applicationActionForm
		 });

		this.applicationActionForm.open(applicationDTOAdapter);
	 }
	 

};

