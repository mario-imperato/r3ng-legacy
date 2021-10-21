$.r3Utils.namespace("org.r3");

org.r3.PageManager =
{
	restConfigManager : null,
	
	userInfo : null,
	siteCollectionDTOAdapter : null,
	userCollectionProfileInfo: null,
	
	actorUserProfileInfo : null,
	
	lutManager : null,
	notifier : null,
	urlRandomParameterName : '_r',
	secondaryWindow : null,
	autoCloseSecondaryWindow : true,

	pageCookie : null,
	
	jsAppVersionForm : null,
	
	clientGeoLocation : null,	
	
	// Contiene il riferimento al PageManager locale nella pagina in maniera da
	// poter essere referenziato anche
	// dalla Actionform comuni che debbono richiamarne i servizi ma non ne
	// conoscono il package.
	// packagePageManagerReference: null,

	init : function()
	{	
		$.fn.dataTable.ext.legacy.ajax = true;
		
		 tmpl.helper += ",log=function(){console.log.apply(console, arguments)}" +
		    ",st='',stream=function(cb){var l=st.length;st=_s;cb( _s.slice(l));}";
		 
		this.notifier = $("#wmg_application_notifier").notifier();
		$('#notifierButtonOK').click($.r3Utils.hitch(this, this.closeNotifier));

		// Dovrebbe essere eseguito dopo il caricamento del dizionario.
		$('#pageAction_logOut').attr('href', "javascript:void(0)");
		$('#pageAction_logOut').click($.r3Utils.hitch(this, this.logOut));
				
		$('#pageAction_console_logOut').attr('href', "javascript:void(0)");
		$('#pageAction_console_logOut').click($.r3Utils.hitch(this, this.consoleLogOut));
		
		if ($("#loginform_form").length > 0 && $('#loginform_form').is(":visible"))
		{
			$.r3Utils.onEnter('#loginform_form_password', this, function() { org.r3.AjaxUtils.doLogin(org.r3.PageManager.getRESTUrl('POST_User_Login', [ $('#loginform_form_nickname').val() ]), org.r3.Constants.getStrutsActionContext() + "/org/r3/home.do"); }, true);

			$("#loginform_form").validate
            ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.jsportlet.login.loginform_form_validationRules,
		           messages: org.r3.jsportlet.login.loginform_form_validationMessages    
	        });
		}
		// else $('#loginform_form').parent().empty();
		else console.info("Login Assente o NON visibile");
		
		$('#AppVersion').html(org.r3.Constants.applicationVersion);
		this.jsAppVersionForm = $('#r3_js_appversionform_form');
		
		this.lutManager = new org.r3.LUTManager();
		this.breadCrumbManager = new org.r3.BreadCrumbManager();
						
		if (org.r3.Constants.isI18NTranslationRequired())
		{	
		   $.i18n.init({ fallbackLng: false, dynamicLoad: false, sendMissing: false, lng: org.r3.Constants.language, ns: 'org.r3', customLoad: this._i18n_resource_loading, resGetPath: "/r3ng/{0}/i18n.{1}.json" });		
		}		
		
		this.pageCookie = $.r3Utils.getCookie("UNEPSESSIONID");
		this.cookieCheckInterval = setInterval($.r3Utils.hitch(this, this.checkCookie), 3000);	
		
		// CVF 41.7693635,12.224426,15
		// Colosseo: 41.890112,12.4920743,18
		this.clientGeoLocation = [ 41.7693635,12.224426 ];
		// Al momento disabilito la chiamata. In realtà la chiamata si auto disabilitava ma qui è meglio. Al limite introdurro' un parametro se mi serve a livello di pagina.
		if (false)
		{
		org.r3.GoogleMapsUtils.geoCodeLocation(
				function(lat, lng, accuracy)     { org.r3.PageManager.clientGeoLocation = [ lat, lng ]; },
				function(errCode,  errMessage)   { console.log("ErrCode/ErrMsg ", errCode,  errMessage); org.r3.PageManager.clientGeoLocation = [ 41.890112,12.4920743,18 ]; }
		);		
		}
		
		L.Icon.Default.imagePath = '/r3ng/resources/bootstrap/css/leaflet/images';
	},

	checkCookie: function()
	{
		var c = $.r3Utils.getCookie("UNEPSESSIONID");
		if (c != this.pageCookie)
		{
			console.error("Cookie Doesn't match");
			clearInterval(this.cookieCheckInterval);
		}		
	},
	
    _i18n_resource_loading: function(lng, ns, options, done) 
    {
    	var ns_path = ns.replace(/\./g, '/');
    	console.log('_i18n_resource_loading...ns_path: ' + ns_path);
    	
    	var url = $.r3Utils.stringFormat(options.resGetPath, [ ns_path, lng ]);
        $.ajax({
            url: url,
            success: function(data, status, xhr) {
                console.log('loaded: ' + url);
                done(null, data);
            },
            error : function(xhr, status, error) 
            {
                if ((status && status == 200) || (xhr && xhr.status && xhr.status == 200)) {
                    // file loaded but invalid json, stop waste time !
                    console.error('_i18n_resource_loading...There is a typo in: ' + url + " error is " + error);
                } else if ((status && status == 404) || (xhr && xhr.status && xhr.status == 404)) {
                    console.log('_i18n_resource_loading....Does not exist: ' + url);
                } else {
                    var theStatus = status ? status : ((xhr && xhr.status) ? xhr.status : null);
                    console.log(theStatus + ' when loading ' + url);
                }
                
                done(error, {});
            },
            "dataType" : "json",
            "method": "GET",
            async : true
        });
    },
    
	// setPackagePageManagerReference: function(aPageManager)
	// {
	// this.packagePageManagerReference = aPageManager;
	// },
	//   
	// getPackagePageManagerReference: function()
	// {
	// return this.packagePageManagerReference;
	// },

	networkInitialization : function(processOptions)
	{
		this.userInfo = null;

		this.restConfigManager = new org.r3.RESTConfigManager(
				org.r3.Constants.applicationContext,
				org.r3.Constants.getRestServicesContext(), 
				org.r3.Constants.restServicesConfigDictionary);

		var networkInitializationQueue = [];

		networkInitializationQueue.push(
		{
			"id" : "restConfigManager",
			"context" : this.restConfigManager,
			"requester" : this.restConfigManager.networkInitialization
		});

		networkInitializationQueue.push(
		{
			id : "sitecollection",
			type : "Get",
			url : org.r3.Constants.getRestServicesContext() + "/sitecollection/" + org.r3.Constants.site,
			dataType : "json"
		});
		
		if (processOptions.verifyIdentity)
		{
			networkInitializationQueue.push(
			{
				"id" : "whoami",
				"context" : this,
				"requester" : this.whoami
			});
			
			networkInitializationQueue.push(
			{
				"id" : "usercollection_whoami",
				"context" : this,
				"requester" : this.usercollection_whoami
			});
		}	

		// TODO
		// networkInitializationQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_usr_type'));				
		
		// this.processBatchOfNetworkRequests(networkInitializationQueue,
		// processOptions.success, processOptions.error);
		// this.multiAjax(networkInitializationQueue, processOptions.success, processOptions.error);
		this.multiAjax(networkInitializationQueue, 
				$.r3Utils.hitch(this, function(responseData) {
					
					var s = responseData['sitecollection'];
					if (s != null)
						 this.siteCollectionDTOAdapter = new org.r3.db.mongo.sitecollection.SiteCollectionDTOAdapter(s);
					else this.siteCollectionDTOAdapter = null;
					
					if (this.userCollectionProfileInfo)
					{
						this.userCollectionProfileInfo.setupEnabledRoles4Site(this.userInfo, this.siteCollectionDTOAdapter);
					}
					
					if (processOptions && processOptions.success)
						processOptions.success(responseData);
				}),
				
				// Error.
				function(jqXHR, timeout, message)
				{
					console.error("org.r3.Pagemanager Initialization Error", message);
					if (processOptions && processOptions.error)
						processOptions.error(jqXHR, timeout, message);
				}
		);
		
	},

	isSmallDevice : function()
	{
		// Dovrei includere anche i tablet..
		var smallDevice = window.matchMedia("screen and (max-width: 767px)")		
		return smallDevice.matches;
	},
	
	isSmallOrTabletDevice : function()
	{
		// Dovrei includere anche i tablet..
		var smallDevice = window.matchMedia("screen and (max-width: 768px)")		
		return smallDevice.matches;
	},
	
	canvasInitialization: function()
	{
		if (org.r3.PageManager.userInfo)
	          $('#userName').text(org.r3.PageManager.userInfo.getUsername());
		
		if (this.userInfo.isUserConsentRequired())
        {
		    this.cookieLawActionForm = new org.r3.jsportlet.cookielaw.CookieLawActionForm(this, '#cookieLawConsent');
			this.cookieLawActionForm.open();			
        }
		
		$('.language_selector').unbind().click($.r3Utils.hitch(this, function(e) {
			
			var theItem = $(e.currentTarget);
			var languageCode = theItem.attr('data-language');
			
			if (org.r3.Constants.language != languageCode)
			   this.goto2CurrentUrlAndSwitchLanguage(location.href, languageCode);
		}));
			
		if (!this.isSmallOrTabletDevice())
		  $().UItoTop({ easingType: 'easeOutQuart' });
		
	},
	
	consoleLogOut: function()
	{
		this.doLogOut(true);
	},
	
	logOut: function()
	{
		this.doLogOut(false);
	},
	
	doLogOut: function(isConsoleEnvironment)
	{
		// console.log("Doing log-out");
		
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "post",
			url : this.getRESTUrl('POST_User_Logout', [this.userInfo.dataBean.userid] ),
			dataType : "json"
		});
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			this.redirectToHomePage(isConsoleEnvironment);
		}),
		
		$.r3Utils.hitch(this, function(jqXHR, timeout, message)
		{
			this.redirectToHomePage(isConsoleEnvironment);
		})
		
		);

	},

	onlineHelp: function()
	{
		var targetUrl = this.getRESTUrl('GET_Guida_In_Linea', [ 'GUIDA_UTENTE' ] );
		this.openFullScreenSecondaryWindow("Guida_in_Linea", targetUrl);
	},
	
	redirectToHomePage: function(isConsoleEnvironment)
	{
		if (isConsoleEnvironment)
			 this.redirectToConsoleHomePage();
		else this.gotoPage(org.r3.Constants.getStrutsActionContext() + "/org/r3/home.do");
	},

	redirectToConsoleHomePage: function()
	{
		this.gotoPage(org.r3.Constants.getStrutsActionContext() + "/org/r3/console/home.do");
	},

	getHomeConsoleBreadCrumb: function()
	{
		return  {
			"type": "breadcrumb_system",
			"noHistory": true,			
			"title" : "Home Console",
			"actionForm" :  
			{

				show : function()
				{
					org.r3.PageManager.redirectToConsoleHomePage();					
				},

				close : function()
				{					
				},
				
				refresh: function()
				{
				}
			}									 
		 };
	},

	getReferrerWebSiteConsoleBreadCrumb: function()
	{
		return  {
			"type": "breadcrumb_system",
			"noHistory": true,			
			"title" : org.r3.SiteConstants.referrerWebSiteConsoleName(),
			"actionForm" :  
			{

				show : function()
				{
					org.r3.PageManager.gotoPage(org.r3.SiteConstants.referrerWebSiteConsoleUrl());					
				},

				close : function()
				{					
				},
				
				refresh: function()
				{
				}
			}									 
		 };
	},

	pushHomeConsoleBreadCrumb: function()
	{
		if (org.r3.SiteConstants.hasReferrerWebSiteConsoleReferences())
		{
			this.pushBreadCrumb(this.getReferrerWebSiteConsoleBreadCrumb());		
		}

		this.pushBreadCrumb(this.getHomeConsoleBreadCrumb());	
	},

	getHomeBreadCrumb: function()
	{
		return  {
			"type": "breadcrumb_system",
			"noHistory": true,
			"title" : org.r3.SiteConstants.targetSiteName,
			"actionForm" :  
			{

				show : function()
				{
					org.r3.PageManager.redirectToHomePage();					
				},

				close : function()
				{					
				},
				
				refresh: function()
				{
				}
			}									 
		 };
	},

	getReferrerWebSiteHomeBreadCrumb: function()
	{
		return  {
			"type": "breadcrumb_system",
			"noHistory": true, 
			"title" : org.r3.SiteConstants.referrerWebSiteHomeName(),
			"actionForm" :  
			{

				show : function()
				{
					org.r3.PageManager.gotoPage(org.r3.SiteConstants.referrerWebSiteHomeUrl());					
				},

				close : function()
				{					
				},
				
				refresh: function()
				{
				}
			}									 
		 };
	},
	
	pushHomeBreadCrumb: function()
	{
		if (org.r3.SiteConstants.hasReferrerWebSiteHomeReferences())
		{
			this.pushBreadCrumb(this.getReferrerWebSiteHomeBreadCrumb());		
		}
		
		this.pushBreadCrumb(this.getHomeBreadCrumb());	
	},
	
	buildURL2Page: function(aPage)
	{
		return org.r3.Constants.getStrutsActionContext() + aPage;
	},

	goto2CurrentUrlAndSwitchLanguage: function(aUrl, aLanguageCode)
	{
		var ndx = aUrl.indexOf('/' + org.r3.Constants.language + '/');
		if (ndx >= 0)
		{
		    var newUrl = aUrl.substring(0, ndx + 1);
		    newUrl = newUrl + aLanguageCode;
		    newUrl = newUrl + aUrl.substring(ndx + 1 + org.r3.Constants.language.length);
		    
		    console.log("goto2CurrentUrlAndSwitchLanguage: ", newUrl);
		    window.location.href = newUrl;
		}
	},
	
	gotoPage : function(aUrl)
	{
		window.location.href = 
			this.getRandomParameterizedURL(aUrl);
	},

	isRestDTO: function(responseData)
	{
	    if (!responseData || !$.isPlainObject(responseData))
	    	return false;
	    
	    if (responseData.status && (responseData.status == 'fail' || responseData.status == 'ok' || responseData.status == 'warning' ))
	    	return true;
	},
	
	getRestDTO: function(responseData)
	{
		if (this.isRestDTO(responseData))
			return new org.r3.RestDTOAdapter(responseData);
			    
	    return null;	    	
	},
	
//	logout : function()
//	{
//		
//		window.location.href = resolvedUrl;
//	},
	
	// Codice simile al multiajax ma che prevede che vengano passate delle
	// funzioni che si occupano della richiesta.
//	processBatchOfNetworkRequests : function(requestsQueue, onSuccess, onError)
//	{
//		var sucessIndex = 1, numberOfRequests = requestsQueue.length - 1;
//
//		$.each(requestsQueue, function(i, d)
//		{
//
//			// console.info("Pippo", d.requester);
//			d.requester.call(d.context, function()
//			{
//				if (sucessIndex > numberOfRequests)
//				{
//					onSuccess();
//				}
//				else
//				{
//					sucessIndex++;
//				}
//			},
//
//			function(jqXHR, timeout, message)
//			{
//				console.log("That's an errore");
//				onError(jqXHR, timeout, message);
//			});
//
//		});
//	},

	initializeCanvas : function(fDescription)
	{
		$('#info_area_functionid').text(fDescription);
	},

	whoami : function(onSuccess, onError)
	{
		// console.info("unep_UserInfo::whoami");

	    var whoamiRestUrl = this.getRandomParameterizedURL(org.r3.Constants.getRestServicesContext() + "/users/whoami");
      			
		// In questo caso non posso utilizzare il resolver in quanto il file di
		// configurazione
		// non è stato ancora caricato.
		$.getJSON(

				whoamiRestUrl,
				$.r3Utils.hitch(this, function(jsonData)
				{
					this.userInfo = new org.r3.db.system.user.user.UserDTOAdapter(jsonData);
					// console.log("UserInfo::whoami - Log-in succesful", this.userInfo, this.userInfo.isInRole(org.r3.Constants.site, 'fpub'), jsonData);
					onSuccess();
				}))
				.error(
						$.r3Utils.hitch(this, function(jqXHR, timeout, message)
						{
							console.info("UserInfo::whoami - Log-in error", jqXHR, timeout, message);

							if (jqXHR.status == 403)
							{
								var p = JSON.parse(jqXHR.responseText);
								if (p)
								{
								    console.info("Authorization Error: " + p.reasoncode);	
								    if (p.reasoncode == 'userunknown')
										this.redirectToLoginPage();
								    else if (p.reasoncode == 'usernotfound')
								    {
								    	this.redirectToIAMUserNotDefinedPage();
								    }								    	
								}
							}         
							else 
							{
								console.info("WhoAMI Returned: ", jqXHR.status);
								if (!jqXHR.status)
									this.redirectToHomePage();
								else
								    this.redirectToWhoAmiServerErrorPage();							
							}
							// assume that our login has expired - reload our
							// current page

							
							// window.location.href = org.r3.PageManager
							// 		.getRandomParameterizedURL(org.r3.Constants.applicationContext
							// 				+ "/it/posteitaliane/unep/login/login.html");
						}));

	},
	
	scroll2BottomActive: false,
	scroll2BottomCallBack: null,
	
	setScrollToBottomCallback: function(aCallBack)
	{
		var _self = this;
		
		this.scroll2BottomCallBack = aCallBack;
		
		if (!this.scroll2BottomActive)
		{			
			this.scroll2BottomActive = true;
			
		    $(window).scroll(
		    	function() {
		    		
		    	  if (!_self.scroll2BottomActive)
		    			return ;
		    		
				  if ($(window).scrollTop() == $(document).height() - $(window).height())
				  {
					  _self.scroll2BottomCallBack();
				  }
		    });
				    
		}
	},

	clearScrollToBottomCallback: function()
	{
		if (this.scroll2BottomActive)
		{	
			// Should reset the scrolling...
		}	
		
		this.scroll2BottomActive = false;
	},

	usercollection_whoami : function(onSuccess, onError)
	{
		// console.info("unep_UserInfo::whoami");

	    var whoamiRestUrl = this.getRandomParameterizedURL(org.r3.Constants.getRestServicesContext() + "/userscollection/whoami");
      			
		// In questo caso non posso utilizzare il resolver in quanto il file di
		// configurazione
		// non è stato ancora caricato.
		$.getJSON(

				whoamiRestUrl,
				$.r3Utils.hitch(this, function(jsonData)
				{
					this.userCollectionProfileInfo = null;
					
					if (jsonData)
					   this.userCollectionProfileInfo = new org.r3.db.mongo.usercollection.UserCollectionDTOAdapter(jsonData);
					// console.log("UserInfo::whoami - Log-in succesful", this.userInfo, this.userInfo.isInRole(org.r3.Constants.site, 'fpub'), jsonData);
					onSuccess();
				}))
				.error(
						$.r3Utils.hitch(this, function(jqXHR, timeout, message)
						{
							console.info("UserInfo::usercollection_whoami - Error", jqXHR, timeout, message);
							if (onError) onError();
						})
				);

	},

	getSiteActorId: function()
	{
	    return this.actorUserProfileInfo && this.actorUserProfileInfo.getSiteActorId();	
	},
	
	isUserInRole: function(functionCode)
	{
		var checkRc = this.userInfo.isInRole(org.r3.Constants.site, functionCode);
		// console.log("IsUser In Role: " + checkRc);
	    return  checkRc;	
	},
	
	//
	// Dictionary Related Functions.
	// 
	getMessageFromDict : function(str, params)
	{
		var msg = null;
		try
		{
			msg = eval(str);
		}
		catch (e)
		{
		}

		if (msg == null || msg == "undefined")
			msg = str;
		return $.r3Utils.stringFormat(msg);
	},

	getRESTUrl : function(aUrlName, params)
	{
		var restUrl = this.restConfigManager.getRESTUrl(aUrlName, params);
		if (!restUrl)
			console.error("org.r3.PageManager::getRESTUrl - Resolution Error for - ", aUrlName);
		// return this.getRandomParameterizedURL(restUrl);

		return restUrl;
	},

	//
	// Notifier
	//
	wait : function(aMessage)
	{
		this.notifier.wait(this.getMessageFromDict(aMessage), 0);
	},

	error : function(aMessage)
	{
		this.notifier.error(this.getMessageFromDict(aMessage), 0);
	},

	message : function(aMessage)
	{
		this.notifier.message(this.getMessageFromDict(aMessage), 0);
	},

	closeNotifier : function()
	{
		this.notifier.close();
	},

	//
	// DIALOGS
	//
	confirmation : function(aMessage)
	{
		return window.confirm(this.getMessageFromDict(aMessage));
	},

	alert : function(aMessage)
	{
		return window.alert(this.getMessageFromDict(aMessage));
	},

	//
	// AJAX STUFF
	// 
	multiAjax : function(requests, success, error)
	{
		var sucessIndex = 1, numberOfRequests = requests.length - 1, data =
		{};

		$.each(requests, function(i, d)
		{

			var multiAjaxSuccess = function(d2)
			{
				if (d.requester && d.context)
				{
					data[d.id] = d.context;
					// console.info("Ajax Success: ", d.id, data[d.id]);
				}
				else
				{
					data[d.id] = d2;
					// console.info("Ajax Success: ", d.id);
				}

				if (sucessIndex > numberOfRequests)
				{
					// console.info("Ajax Terminate");
					success(data);
				}
				else
				{
					sucessIndex++;
				}
			};

			var multiAjaxError = function(jqXHR, timeout, message)
			{
				if (typeof error == 'function')
				{
					error(jqXHR, timeout, message);
				}
				else
					console.error("Getting an unmanaged error: ", message);
			};

			if (d.requester)
			{
				d.requester.call(d.context, multiAjaxSuccess, multiAjaxError);
			}
			else
			{
				$.ajax(
				{
					type : d.type,
					url : d.url,
					dataType : d.dataType,
					success : multiAjaxSuccess,
					error : multiAjaxError
				});
			}

		});
	},

	//
	// BREADCRUMB SUPPORT
	//
	



	back : function()
	{
		this.breadCrumbManager.back();
	},

	pushBreadCrumb : function(aBreadCrumb)
	{
		this.breadCrumbManager.pushBreadCrumb(aBreadCrumb);
	},
	
	popBreadCrumb : function()
	{
		this.breadCrumbManager.popBreadCrumb();
	},
	
	peekBreadCrumb : function()
	{
		this.breadCrumbManager.peekBreadCrumb();
	},
	
	setBreadCrumb : function(aBreadCrumb)
	{
		this.breadCrumbManager.setBreadCrumb(aBreadCrumb);
	},
	
	closeAllBreadCrumbs: function()
	{
		this.breadCrumbManager.closeAllBreadCrumbs();
	},
	
	closeBreadCrumbs : function(startingBreadCrumbIndex, onBrowserHistory)
	{
		if ($('#canvas_report').is(":visible"))
		{
			this.closeFullScreenLayout();
		}
		
		this.breadCrumbManager.closeBreadCrumbs(startingBreadCrumbIndex, onBrowserHistory);
	},
	
	activateFirstBreadCrumb: function()
	{
		this.breadCrumbManager.activateFirstBreadCrumb();
	},
	
	activateBreadCrumb : function(breadCrumbIndex, onBrowserHistory)
	{
		this.breadCrumbManager.activateBreadCrumb(breadCrumbIndex, onBrowserHistory);
	},
	
	getVersionedUIURL : function(aUrl)
	{
		var u = $.r3Utils.addParameterToUrl(aUrl, 'r3_ui_version', org.r3.Constants.r3_ui_version);
		u = $.r3Utils.addParameterToUrl(u, 'r3_site', org.r3.Constants.site);
		u = $.r3Utils.addParameterToUrl(u, 'r3_lang', org.r3.Constants.language);
		return u;
	},

	getRandomParameterizedURL : function(aUrl)
	{
		return $.r3Utils.addParameterToUrl(aUrl, this.urlRandomParameterName, Math.random() * 5);
	},


	// LUT Convenience functions.
	getLUTItemDescription : function(aLutUrl, aLutItemKey, lutUrlParameters)
	{
        var theLUTItem = this.getLUTItem(aLutUrl, aLutItemKey, lutUrlParameters);
		if (!theLUTItem)
			return '';
				
		return theLUTItem.dtodescr;
	},

	getLUTItem : function(aLutUrl, aLutItemKey, lutUrlParameters)
	{
		if (!aLutItemKey)
			return null;

		var resolvedUrl = aLutUrl;
		if (aLutUrl.indexOf('/') < 0)
			resolvedUrl = this.getRESTUrl(aLutUrl, lutUrlParameters);
		
		var theLUTItem = this.lutManager.getLUTItem(resolvedUrl, aLutItemKey, false);
		return theLUTItem;
	},

	openWindow : function(
	/* String */aName,
	/* String */targetUrl, /* int */aWidth, /* int */anHeight,
	/* Boolean */withMenuBar, /* Boolean */isResizable, /* Boolean */withScrollbars, /* Boolean */withStatus)
	{
		var windowName = (aName) ? aName : "_blank";
		var windowOptions = "dependent,width=" + aWidth + ",height=" + anHeight;

		if (withMenuBar)
			windowOptions = windowOptions + ",menubar";

		if (isResizable)
			windowOptions = windowOptions + ",resizable";

		if (withScrollbars)
			windowOptions = windowOptions + ",scrollbars";

		if (withStatus)
			windowOptions = windowOptions + ",status";

		var winObject = window.open(targetUrl, windowName, windowOptions);
		
		// console.error("Focusing window: " , winObject);
		winObject.focus();
		return winObject;
	},

	openSecondaryWindow : function(
	/* String */aName,
	/* String */targetUrl, /* int */aWidth, /* int */anHeight,
	/* Boolean */withMenuBar, /* Boolean */isResizable, /* Boolean */withScrollbars, /* Boolean */withStatus)
	{
		this.secondaryWindow = this.openWindow(aName, targetUrl, aWidth, anHeight, withMenuBar, isResizable, withScrollbars, withStatus);
	},

	openFullScreenSecondaryWindow : function(
	/* String */aName, /* String */targetUrl)
	{
		console.info("Screen: ", window.screen + ' - ' + window.screen.availWidth + ' - ' + window.screen.availHeight);
		if (targetUrl.indexOf("DMS_FILE") == 0)
			targetUrl = $.r3Utils.formatDMSUrl4ClientAccess(targetUrl);
		
		this.secondaryWindow = this.openWindow(aName, targetUrl, screen.availWidth, screen.availHeight);
	},

	closeSecondaryWindow : function()
	{
		if (this.secondaryWindow && this.autoCloseSecondaryWindow)
		{
			if (!this.secondaryWindow.closed)
			{
				this.secondaryWindow.close();
			}
		}
		this.secondaryWindow = null;
	},

	viewDocument: function(documentUrl)
	{
		this.openFullScreenSecondaryWindow('Visualizza_Documenti', documentUrl);
	},
	
	saveAsDocument: function(targetUrl)
	{
		if (targetUrl.indexOf("DMS_FILE") == 0)
			targetUrl = $.r3Utils.formatDMSUrl4ClientAccess(targetUrl, ';saveas=true');
		
		window.location.href = targetUrl;
	},
	
	loadImage: function(targetUrl, loadImageOptions, onSuccess)
	{
		if (targetUrl.indexOf("DMS_FILE") == 0)
			targetUrl = $.r3Utils.formatDMSUrl4ClientAccess(targetUrl);
		
    	loadImage(
    	    targetUrl,
    	    function (img) 
    	    {
    	        if(img.type === "error") {
    	            console.error("Error loading image " + targetUrl);
    	        } else {
    	        	onSuccess($(img));
    	        }
    	    },
    	    loadImageOptions
        );	        				
	},
	
		
	// Le due funzioni successive sono invocate quando viene invocato il metodo showFullScreen dell'ActionFormView
	// e il metodo close della stessa.	
	openFullScreenLayout: function(anActionForm)
	{
		this.googleAnalyticsSendPageView();
		
		if (console_layout)
		{
			$('.wrapper').hide();	
		}
		else
		{
		    $('#header').hide();	
		    $('#canvas_content').hide();
		    $('#layoutFooter').hide();					
		}
	    
	    $('#canvas_report').show();	    
	    $('#canvas_report_closeAction').unbind().click(function(e) 
	    {
	    	anActionForm.close();
	        org.r3.PageManager.closeFullScreenLayout();	
	    });
	    
	    $('#canvas_report_printAction').unbind().click(function(e) 
	    {
	    	window.print();	
	    });
	},
	
	closeFullScreenLayout: function()
	{
		// Da decidere se inserire o meno. Forse No. In pratica li raddoppia.
		// this.googleAnalyticsSendPageView();

		if (console_layout)
		{
			$('.wrapper').show();	
		}
		else
		{
		$('#header').show();	
	    $('#canvas_content').show();
	    $('#layoutFooter').show();	
		}
		
	    $('#canvas_report').hide();	    	
	},
	
	// Google Utils.
	googleAnalyticsCurrentUrl: function(aPageSpecifier)
	{
		if (aPageSpecifier)
		{
			return window.location.pathname + "/" + aPageSpecifier;			
		}
		
	    return window.location.pathname;
	},
	
	googleAnalyticsSendPageView: function(pageSpecifier)
	{
		if (org.r3.SiteConstants.googleAnalytics && org.r3.SiteConstants.googleAnalytics.trackerid && typeof ga != 'undefined')
		{
			var gaPayload = {
				 'hitType': 'pageview'		
			};
			
			if (pageSpecifier)
			{
				gaPayload['page'] = this.googleAnalyticsCurrentUrl(pageSpecifier);	
			}
			
			ga('send', gaPayload);									
		}
		else console.info('No Google Analytics Tracker defined: skipping....' + this.googleAnalyticsCurrentUrl(pageSpecifier));
	}
	
		
};
