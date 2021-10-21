$.r3Utils.namespace("org.r3.shkadmin.siteconfig");


org.r3.shkadmin.siteconfig.FacebookConfigActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.faceBookLoginStatus = null;
		this.fbPageInfo = null;
	},

	close : function()
	{
		this.hide();
	},

	open : function()
	{
        var _self = this;
        
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/shkadmin/siteconfig/FacebookConfigActionFormView.html.jsp?mode=detail'),
			dataType : "html"
		});
		
		networkRequestsQueue.push(
		{
			id : "content",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_SiteCollection_Detail', [ org.r3.Constants.site ]),
			dataType : "json"
		});

		networkRequestsQueue.push(
		{
			id : "pkg_facebookconfig_properties",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_FacebookConfig_SiteProperties'),
			dataType : "json"
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
			$(this.htmlContainerId + ' .showwhenacquiringtoken').hide();
			
			var pkg_facebookconfig_properties = responseData['pkg_facebookconfig_properties'];
			if (pkg_facebookconfig_properties)
			{
				pkg_facebookconfig_properties = new org.r3.db.system.siteproperty.SitePropertyDTOTableAdapter(pkg_facebookconfig_properties, 
						function(aRowDataBean) { return new org.r3.db.system.siteproperty.SitePropertyDTOAdapter(aRowDataBean); });									
	
				this._initializeFormFields(pkg_facebookconfig_properties);
			}
			else this._initializeFormFields(null);
			
			
			// ignore: [],
			$('#facebookconfigform_form').validate(
			{				
				errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
				rules : org.r3.shkadmin.siteconfig.facebookconfigform_form_validationRules,
				messages : org.r3.shkadmin.siteconfig.facebookconfigform_form_validationMessages
			});

			$('#getfacebookpagetokenform_form').validate(
			{				
				errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
				rules : org.r3.shkadmin.siteconfig.getfacebookpagetokenform_form_validationRules,
				messages : org.r3.shkadmin.siteconfig.getfacebookpagetokenform_form_validationMessages
			});						
			
			$('#facebookconfigform_fieldset_message').formmessage({});	
			
			$('#facebookconfigform_action_saveitem').click(
				$.r3Utils.hitch(this, this._onUpdateItem));

			$('#getfacebookpagetokenform_action_getpagetoken').click(
					$.r3Utils.hitch(this, this._onGetPageToken));			

			$('#getfacebookpagetokenform_action_saveitem').click(
					$.r3Utils.hitch(this, this._onSavePageToken));	
			
			$('#getfacebookpagetokenform_action_cancel').click(
					$.r3Utils.hitch(this, this._onCancelSavePageToken));	
			
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},

	_initializeFormFields: function(siteProperties)
	{
		if (siteProperties)
		{
		var property = siteProperties.getPropertyByPropertyscopePropertykey("facebook.page.url", "pageurl");
		if (property)
		{
		    $('#pkg_facebook_pageurl').val(property.dataBean.propertyvalue);
		}
		
		var property = siteProperties.getPropertyByPropertyscopePropertykey("facebook.page.pub", "fbpagename");
		if (property)
		{
		    $('#pkg_facebook_fbpagename').val(property.dataBean.propertyvalue);
		}
		
		var property = siteProperties.getPropertyByPropertyscopePropertykey("facebook.page.pub", "fbpageid");
		if (property)
		{
		    $('#pkg_facebook_fbpageid').val(property.dataBean.propertyvalue);
		}	
		}
	},
	
	_onUpdateItem: function()
	{
		var _self = this;						
		
		var theForm = $('#facebookconfigform_form');
		org.r3.AjaxUtils.submitForm(
				"POST", 
				org.r3.PageManager.getRESTUrl("POST_SiteProperties_Invalidate", [ "facebook.page.url" ]),  
				theForm, 
				function(responseData) { $('#facebookconfigform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' }); }, 
				function(jqXHR, timeout, message) { $('#facebookconfigform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); },
				"org.r3.message.saveconfirm",
		        true);		
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
    
    _onGetPageToken: function(e)
    {
    	var _self = this;
		e.preventDefault();
		
//    	if (!this.faceBookLoginStatus || this.faceBookLoginStatus.status != 'connected')
//    	{
        	FB.login(function(response) 
	    	{
        		_self.faceBookLoginStatus = response;
	    		if (response.status === 'connected') 
	        	{
	    			_self.onConnected();
	        	} 

	    	}, {scope: 'public_profile,email,manage_pages,pages_show_list,publish_pages', return_scopes: true });    		
//    	}
//    	else _self.onConnected();
    },
    
    onConnected: function()
    {
    	var _self = this;
    	
    	_self.fbPageInfo = [];
    	
        FB.api('/me/accounts', function(response) 
        {
        	console.info(response);
        	if (response && response.data.length)
        	{
	    		var pages = [];
        		for(var i = 0; i < response.data.length; i++)
        		{        			
        			var item = response.data[i];
    	    		var permissions = "";
    	    		var canCreateContent = false;
        	    	if (item.perms && item.perms.length)
        	    	{
        	    		for(var j = 0; j < item.perms.length; j++)
        	    		{
        	    			permissions = permissions + item.perms[j] + ',';
        	    			if (item.perms[j] == 'ADMINISTER' || item.perms[j] == 'EDIT_PROFILE' || item.perms[j] == 'CREATE_CONTENT')
        	    			{
        	    				canCreateContent = true;
        	        	    	console.log('Candidate Page: ' + item.name + " - " + item.id + " - " + item.access_token + ' - ' + permissions);        			
        	    			}
        	    		}
        	    		
        	    		if (canCreateContent)
        	    		{
    	    				pages.push({
    	    					name :  item.name, id : item.id, accesstoken : item.access_token
    	    				});        	    			
        	    		}	    				
        	    	}        	    	
        		}
        		
        		_self.fbPageInfo = pages;
        		
    	    	if (pages.length)                 
    	    	{                                           
    	    		_self._populateListOfCandidatePages($('#getfacebookpagetokenform_fbpageid'), pages);
    	    		
    	    		$('#getfacebookpagetokenform_fbaccesstoken').val(_self.faceBookLoginStatus.authResponse.accessToken);
    	    		$('#getfacebookpagetokenform_fbuserid').val(_self.faceBookLoginStatus.authResponse.userID);
    	    		
    				$(_self.htmlContainerId + ' .hidewhenacquiringtoken').hide();
    	    		$(_self.htmlContainerId + ' .showwhenacquiringtoken').show();
    	    	}
    	    	else
    	    	{
    	    		$('#facebookconfigform_fieldset_message').formmessage('setText', { text: org.r3.shkadmin.siteconfig.message.facebook_nopages, category: 'error' }); 
    	    	}

        	}
        	else $('#facebookconfigform_fieldset_message').formmessage('setText', { text: org.r3.shkadmin.siteconfig.message.facebook_nopages, category: 'error' });        		
        });    
    },
    
    _populateListOfCandidatePages: function(selectWidget, anArrayOfPages)
    {
    	var selectOptions = selectWidget.prop('options');		
		selectOptions.length = 0;
		
		for(var i = 0; i < anArrayOfPages.length; i++ )
		{
			selectOptions[selectOptions.length] = new Option(anArrayOfPages[i].name, anArrayOfPages[i].id);	
		}
    },
    
    _onSavePageToken: function()
    {
    	var _self = this;						

    	var selectedIndex = $('#getfacebookpagetokenform_fbpageid').prop('selectedIndex');
    	if (this.fbPageInfo.length > selectedIndex)
    	{
    		$('#getfacebookpagetokenform_fbpagename').val(this.fbPageInfo[selectedIndex].name);
    		$('#getfacebookpagetokenform_fbpagetoken').val(this.fbPageInfo[selectedIndex].accesstoken);    		
    	}

		var theForm = $('#getfacebookpagetokenform_form');
		org.r3.AjaxUtils.submitForm(
				"POST", 
				org.r3.PageManager.getRESTUrl("POST_SiteProperties_AcquireFacebookPageToken", [ "facebook.page.pub" ]),  
				theForm, 
				function(responseData) 
				{ 
					$('#facebookconfigform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' }); 
					_self._onCancelSavePageToken();
				}, 
				function(jqXHR, timeout, message) { 
					$('#facebookconfigform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); 
					_self._onCancelSavePageToken();
				},
				"org.r3.message.saveconfirm",
		        true);	
    },
    
    _onCancelSavePageToken: function()
    {
		$(this.htmlContainerId + ' .hidewhenacquiringtoken').show();
		$(this.htmlContainerId + ' .showwhenacquiringtoken').hide();
    }
	

});
