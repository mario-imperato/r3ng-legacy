$.r3Utils.namespace("org.r3.jsportlet.site.please_login_or_register");

org.r3.jsportlet.site.please_login_or_register.PleaseLogInOrRegisterPortletActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);	
		this.faceBookLoginStatus = null;
	},

	close : function()
	{
		this.hide();
	},

	open : function(aDataBeanInfo)
	{
		var _self = this;
		
		this.siteMembersMap = {};
		this.fetchPostInfo = new org.r3.jsportlet.site.sitemember.portletScrollInfo(20);
		
		org.r3.PageManager.wait("org.r3.message.waiting");
        console.log("Logged User Is: ", org.r3.PageManager.userInfo);
		var networkRequestsQueue = [];

		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/site/please_login_or_register/PleaseLogInOrRegisterPortletActionFormView.html.jsp?mode=detail'),
			dataType : "html"
		});

		networkRequestsQueue.push(
		{
			id : "loginform",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/login/ShakeUsLoginActionForm2.html'),
			dataType : "html"
		});
		
		fbEnsureInit(function() {
			FB.getLoginStatus(function(response) {
			    _self.onFaceBookLoginStatus(response);
			});
		});	
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();
			
			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));		
						
			$('#please_action_register').unbind().click(function(e)
			{
				org.r3.PageManager.gotoPage(org.r3.Constants.getStrutsActionContext() + '/org/r3/registration/register.do');
			});
					
			$('#please_action_fblogin').unbind().click($.r3Utils.hitch(this, this.onFaceBookLogin));
			
			var hasLoginForm = false;			
			if ($("#loginform_form").length == 0)
			    hasLoginForm = true;		
			else if (!$('#loginform_form').is(":visible"))
			{
				$('#loginform_form').parent().empty();
				hasLoginForm = true;
			}
			
			if (hasLoginForm)
			{
				$(this.htmlContainerId + " #JSPortlet_PleaseLogInOrRegister_LoginForm").html(responseData['loginform']);
				$.r3Utils.onEnter('#loginform_form_password', this.actionFormManager, this.actionFormManager.doLogin, true);
				$("#loginform_form #loginButton").unbind().click($.r3Utils.hitch(this.actionFormManager, this.actionFormManager.doLogin));
				
				$("#loginform_form").validate
	            ({
		        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
		               rules: org.r3.jsportlet.login.loginform_form_validationRules,
			           messages: org.r3.jsportlet.login.loginform_form_validationMessages    
		        });
			}

			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	
	onFaceBookLoginStatus: function(response)
    {
    	// accessToken:
    	// "EAADmOcu0WDQBALJp8E1SwXaoLSM0GUPZAM9w1ImLo3D8ZCZB0qJXXHqUZCIF7ILmm0TmZAQuOHOWtpLOOh7sAH0KhSSOVdvjgvZAqW5B2kJWL6DznwJSkzm9fZA4K9FaW6opfkOgJQUHOJlZCpLOO6Glok5h9qpWg4duYK6sp0OWxwZDZD"
    	// expiresIn: 6256
    	// signedRequest: 
    	// "nv5UmiLJs8NLifL8Gut_AKV0B-3kBPECU0RuLgBUXqs.eyJhbGdvcml0aG0iOiJITUFDLVNIQTI1NiIsImNvZGUiOiJBUURNVHNuSmY3Q3NGZFNiamQwRktaX2EzLXE0bGZwcnJJUHhmRjlrNDFvT0h5MXdqT0dqTXBKdThxRXVTSmtxTFh4b1EwX25uMVpRZFBkeWpGWEZ4aEh0ZkhuWjlzeWgtM1JYVTVzazN1bGVHaFh5ZEVTeHM1OW9vbE9BS0YtU0dKT0IwUGhlUktaWGZfOXBEc0xXMm5FQXQzSVZoZWtZelRSV2ExQjN0cXMxTTFDV3p4cG9VTzFUZER3cmJ6aGhPS2xZdmZaOU5kdExZd2dmWElINkt0aG5ZYjJZeGtUelJtTnplb20xOXJId1JKZlFLdEZxb2czSDR6Z3FEd0JEVUl3ZXdnSmRsWFY2UW5ZX1pCanRYNzB6OVhPSV9nbDhrLTdkdF9GaWhrdm9VRDNWLUFrQVA4SHNsOTR2YWh2dDR1eFhpeW9kUldpT1J6YU1kd2M1OUlrZyIsImlzc3VlZF9hdCI6MTQ4NDA2MTM0NCwidXNlcl9pZCI6IjEyMjIwMTUwODQ1MzIyNTUifQ"
    	// userID: "1222015084532255"
    		
    	this.faceBookLoginStatus = response;    	
    },
    
    onFaceBookLogin: function(e)
    {
    	var _self = this;
		event.preventDefault();
		
    	if (!this.faceBookLoginStatus || this.faceBookLoginStatus.status != 'connected')
    	{
        	FB.login(function(response) 
	    	{
        		_self.faceBookLoginStatus = response;
	    		if (response.status === 'connected') 
	        	{
	    			_self.onConnected();
	        	} 

	    	}, {scope: 'public_profile,email', return_scopes: true });    		
    	}
    	else _self.onConnected();
    },
    
    onConnected: function()
    {
    	var _self = this;
    	console.log('Successful login for: ' , this.faceBookLoginStatus);
    	
        FB.api('/me', { fields: 'email,name,first_name,last_name' }, function(response) 
        {
        	_self.doFBLogin(_self.faceBookLoginStatus, response);
        });    
    },
    
    doFBLogin: function(aLoginStatus, aUserInformation)
    {
    	console.log("FBLogin: ", aLoginStatus, aUserInformation);
    	if (!aUserInformation.email)
    		return ;
    	
    	var formData = {
    		fbuserid: aUserInformation.id,
    		accesstoken: aLoginStatus.authResponse.accessToken,
    		email: aUserInformation.email,
    		firstname: aUserInformation.first_name,
    		lastname: aUserInformation.last_name    		
    	};
    	
    	var formPayload = $.param(formData);
    	console.log(formPayload);
    	org.r3.AjaxUtils.doPostLoginFormData(org.r3.PageManager.getRESTUrl('POST_FBLogin', [ aUserInformation.email ]), formPayload, org.r3.Constants.getStrutsActionContext() + "/org/r3/home.do");
    },
    
    onLoginRedirect: function()
    {
    	
    }
				

});