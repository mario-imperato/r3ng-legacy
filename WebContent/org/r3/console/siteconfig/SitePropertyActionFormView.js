$.r3Utils.namespace("org.r3.console.siteconfig");


org.r3.console.siteconfig.SitePropertyActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.pkgUicfg = null;
		this.pkgGoogleAnalytics = null;
		this.pkgSevApp = null;
		this.pkgSevRanking = null;
		this.pkgSms = null;
		this.pkgFiv = null;
		this.pkgMail = null;
		
		this.address = null;
	},

	close : function()
	{
		this.hide();
	},

	refresh: function()
	{
		if (this.pkgUicfg)
		   this.pkgUicfg.refresh();		
	},
	
	open : function()
	{
		var _self = this;
		
		var targetSiteType = org.r3.SiteConstants.targetSiteType;
		
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];

		var actionFormView = org.r3.Constants.applicationContext + '/org/r3/console/siteconfig/SitePropertyActionFormView.html.jsp';	
		if (org.r3.SiteConstants.is10Gen())
		{
			actionFormView = org.r3.Constants.applicationContext + '/org/r3/console/siteconfig/SitePropertyActionFormView_10Gen.html.jsp';
		}
		else if (targetSiteType == 'regatta' || targetSiteType == 'workshop')
		{
		    actionFormView = org.r3.Constants.applicationContext + '/org/r3/console/siteconfig/SitePropertyActionFormView_' + targetSiteType + '.html.jsp';	
		}
		
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(actionFormView),
			dataType : "html"
		});

		if (targetSiteType == 'workshop')
		{
			networkRequestsQueue.push(
			{
				id : "pkg_uicfg_properties",
				type : "Get",
				url : org.r3.PageManager.getRESTUrl('GET_UiCfg_SiteProperties'),
				dataType : "json"
			});
			
			networkRequestsQueue.push(
			{
				id : "pkg_uicfg_view",
				type : "Get",
				url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/siteconfig/SitePropertyActionFormView_PkgUiCfg.html'),
				dataType : "html"
			});	

		}
		
		if (targetSiteType == 'regatta')
		{
			networkRequestsQueue.push(
			{
				id : "pkg_uicfg_properties",
				type : "Get",
				url : org.r3.PageManager.getRESTUrl('GET_UiCfg_SiteProperties'),
				dataType : "json"
			});			
			
			networkRequestsQueue.push(
			{
				id : "pkg_sevapp_properties",
				type : "Get",
				url : org.r3.PageManager.getRESTUrl('GET_SevApp_SiteProperties'),
				dataType : "json"
			});
			
			networkRequestsQueue.push(
			{
				id : "pkg_sevranking_properties",
				type : "Get",
				url : org.r3.PageManager.getRESTUrl('GET_SevRanking_SiteProperties'),
				dataType : "json"
			});		

			networkRequestsQueue.push(
			{
				id : "pkg_fiv_properties",
				type : "Get",
				url : org.r3.PageManager.getRESTUrl('GET_FIV_SiteProperties'),
				dataType : "json"
			});

			networkRequestsQueue.push(
			{
				id : "pkg_uicfg_view",
				type : "Get",
				url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/siteconfig/SitePropertyActionFormView_PkgUiCfg.html'),
				dataType : "html"
			});
	
			networkRequestsQueue.push(
			{
				id : "pkg_sevapp_view",
				type : "Get",
				url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/siteconfig/SitePropertyActionFormView_PkgSevApp.html'),
				dataType : "html"
			});
	
			networkRequestsQueue.push(
			{
				id : "pkg_sevranking_view",
				type : "Get",
				url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/siteconfig/SitePropertyActionFormView_PkgSevRanking.html'),
				dataType : "html"
			});

			networkRequestsQueue.push(
			{
				id : "pkg_fiv_view",
				type : "Get",
				url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/siteconfig/SitePropertyActionFormView_PkgFiv.html'),
				dataType : "html"
			});
			
		}

		networkRequestsQueue.push(
		{
			id : "pkg_googleanalytics_properties",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_GoogleAnalytics_SiteProperties'),
			dataType : "json"
		});	

		networkRequestsQueue.push(
		{
			id : "pkg_sms_properties",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_SMS_SiteProperties'),
			dataType : "json"
		});
		
		networkRequestsQueue.push(
		{
			id : "pkg_mail_properties",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_MAIL_SiteProperties'),
			dataType : "json"
		});
		
		networkRequestsQueue.push(
		{
			id : "pkg_google_view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/siteconfig/SitePropertyActionFormView_PkgGoogle.html'),
			dataType : "html"
		});

		networkRequestsQueue.push(
		{
			id : "pkg_sms_view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/siteconfig/SitePropertyActionFormView_PkgSms.html'),
			dataType : "html"
		});

		networkRequestsQueue.push(
		{
			id : "pkg_mail_view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/siteconfig/SitePropertyActionFormView_PkgMail.html'),
			dataType : "html"
		});
		
		if (org.r3.SiteConstants.is10Gen())
		{
		networkRequestsQueue.push(
		{
			id : "sitecollection",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_SiteCollection_Detail', [ org.r3.Constants.site ]),
			dataType : "json"
		});
		
		networkRequestsQueue.push(
		{
			id : "address_view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/siteconfig/SitePropertyActionFormView_Address.html.jsp'),
			dataType : "html"
		});
		}
		
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_CMS_Page'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			var pkg_uicfg_properties = responseData['pkg_uicfg_properties'];
			if (pkg_uicfg_properties)
			{
				pkg_uicfg_properties = new org.r3.db.system.siteproperty.SitePropertyDTOTableAdapter(pkg_uicfg_properties, 
						function(aRowDataBean) { return new org.r3.db.system.siteproperty.SitePropertyDTOAdapter(aRowDataBean); });									
			}
			
			var pkg_googleanalytics_properties = responseData['pkg_googleanalytics_properties'];
			if (pkg_googleanalytics_properties)
			{
				pkg_googleanalytics_properties = new org.r3.db.system.siteproperty.SitePropertyDTOTableAdapter(pkg_googleanalytics_properties, 
						function(aRowDataBean) { return new org.r3.db.system.siteproperty.SitePropertyDTOAdapter(aRowDataBean); });									
			}						

			var pkg_sevapp_properties = responseData['pkg_sevapp_properties'];
			if (pkg_sevapp_properties)
			{
				pkg_sevapp_properties = new org.r3.db.system.siteproperty.SitePropertyDTOTableAdapter(pkg_sevapp_properties, 
						function(aRowDataBean) { return new org.r3.db.system.siteproperty.SitePropertyDTOAdapter(aRowDataBean); });									
			}		

			var pkg_sevranking_properties = responseData['pkg_sevranking_properties'];
			if (pkg_sevranking_properties)
			{
				pkg_sevranking_properties = new org.r3.db.system.siteproperty.SitePropertyDTOTableAdapter(pkg_sevranking_properties, 
						function(aRowDataBean) { return new org.r3.db.system.siteproperty.SitePropertyDTOAdapter(aRowDataBean); });									
			}		

			var pkg_sms_properties = responseData['pkg_sms_properties'];
			if (pkg_sms_properties)
			{
				pkg_sms_properties = new org.r3.db.system.siteproperty.SitePropertyDTOTableAdapter(pkg_sms_properties, 
						function(aRowDataBean) { return new org.r3.db.system.siteproperty.SitePropertyDTOAdapter(aRowDataBean); });									
			}		

			var pkg_fiv_properties = responseData['pkg_fiv_properties'];
			if (pkg_fiv_properties)
			{
				pkg_fiv_properties = new org.r3.db.system.siteproperty.SitePropertyDTOTableAdapter(pkg_fiv_properties, 
						function(aRowDataBean) { return new org.r3.db.system.siteproperty.SitePropertyDTOAdapter(aRowDataBean); });									
			}		

			var pkg_mail_properties = responseData['pkg_mail_properties'];
			if (pkg_mail_properties)
			{
				pkg_mail_properties = new org.r3.db.system.siteproperty.SitePropertyDTOTableAdapter(pkg_mail_properties, 
						function(aRowDataBean) { return new org.r3.db.system.siteproperty.SitePropertyDTOAdapter(aRowDataBean); });									
			}	
			
			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));			

			if (targetSiteType == 'workshop')
			{
				$('#sitePropertiesActionForm_tab_pkg_uicfg').html(tmpl(responseData['pkg_uicfg_view'], {}));			
				this.pkgUicfg = new org.r3.console.siteconfig.SitePropertyActionFormView_PkgUiCfg('__UNUSED__', this.actionFormManager, pkg_uicfg_properties);
			}
			
			if (targetSiteType == 'regatta')
			{
				$('#sitePropertiesActionForm_tab_pkg_uicfg').html(tmpl(responseData['pkg_uicfg_view'], {}));			
				this.pkgUicfg = new org.r3.console.siteconfig.SitePropertyActionFormView_PkgUiCfg('__UNUSED__', this.actionFormManager, pkg_uicfg_properties);

				$('#sitePropertiesActionForm_tab_pkg_sevapp').html(tmpl(responseData['pkg_sevapp_view'], {}));			
				this.pkgSevApp = new org.r3.console.siteconfig.SitePropertyActionFormView_PkgSevApp('__UNUSED__', this.actionFormManager, pkg_sevapp_properties);

				$('#sitePropertiesActionForm_tab_pkg_sevranking').html(tmpl(responseData['pkg_sevranking_view'], {}));			
				this.pkgSevApp = new org.r3.console.siteconfig.SitePropertyActionFormView_PkgSevRanking('__UNUSED__', this.actionFormManager, pkg_sevranking_properties);

				$('#sitePropertiesActionForm_tab_pkg_fiv').html(tmpl(responseData['pkg_fiv_view'], {}));			
				this.pkgFiv = new org.r3.console.siteconfig.SitePropertyActionFormView_PkgFiv('__UNUSED__', this.actionFormManager, pkg_fiv_properties);			
			}
			
			$('#sitePropertiesActionForm_tab_pkg_google').html(tmpl(responseData['pkg_google_view'], {}));			
			this.pkgGoogleAnalytics = new org.r3.console.siteconfig.SitePropertyActionFormView_PkgGoogle('__UNUSED__', this.actionFormManager, pkg_googleanalytics_properties);

			$('#sitePropertiesActionForm_tab_pkg_sms').html(tmpl(responseData['pkg_sms_view'], {}));			
			this.pkgSms = new org.r3.console.siteconfig.SitePropertyActionFormView_PkgSms('__UNUSED__', this.actionFormManager, pkg_sms_properties);

			$('#sitePropertiesActionForm_tab_pkg_mail').html(tmpl(responseData['pkg_mail_view'], {}));			
			this.pkgMail = new org.r3.console.siteconfig.SitePropertyActionFormView_PkgMail('__UNUSED__', this.actionFormManager, pkg_mail_properties);

			if (org.r3.SiteConstants.is10Gen())
			{
			$('#sitePropertiesActionForm_tab_address').html(tmpl(responseData['address_view'], {}));
			
			var siteAddressDTOAdapter = null;
			var siteCollectionDTOAdapter = responseData['sitecollection'];
			if (siteCollectionDTOAdapter)
			{
				siteCollectionDTOAdapter = new org.r3.db.mongo.sitecollection.SiteCollectionDTOAdapter(siteCollectionDTOAdapter);
				siteAddressDTOAdapter = siteCollectionDTOAdapter.getAddressDTOAdapter();
			}
						
			this.address = new org.r3.console.siteconfig.SitePropertyActionFormView_Address('__UNUSED__', this.actionFormManager, siteAddressDTOAdapter);
			
			$('#sitePropertiesActionFormTabs a[data-toggle="tab"]').on('shown.bs.tab', function (e) 
			{
				var activated = e.target;
				var prevActivated = e.relatedTarget;
				console.log(activated, prevActivated);
				
				_self.address.map.invalidateSize();
			});
			}
			
			// $('#sitePropertiesActionFormTabs').tabs();
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	}
	
	
});
