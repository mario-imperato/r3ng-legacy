$.r3Utils.namespace("org.r3.shkadmin.siteconfig");

org.r3.shkadmin.siteconfig.AddressActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.addressActionFormView = new org.r3.jsportlet.address.AddressActionFormView(aDetailViewContainerId, this);
	},

	close : function()
	{
		this.hide();
	},

	hide : function()
	{
		this.addressActionFormView.hide();
	},

	show : function()
	{
		this.addressActionFormView.show();
	},

	refresh : function()
	{
	},

	open : function(openParams)
	{
		var _self = this;
		var method = 'get';
		var restUrl = org.r3.PageManager.getRESTUrl('GET_SiteCollection_Detail', [ org.r3.Constants.site ]);
		
		$.ajax(
		{
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"success" : function(responseData)
			{
				var siteCollectionDTOAdapter = responseData;
				if (siteCollectionDTOAdapter)
				{
					siteCollectionDTOAdapter = new org.r3.db.mongo.sitecollection.SiteCollectionDTOAdapter(siteCollectionDTOAdapter);
					siteAddressDTOAdapter = siteCollectionDTOAdapter.getAddressDTOAdapter();										
				}				

				_self.addressActionFormView.open(siteCollectionDTOAdapter.getAddressDTOAdapter(), false);
				if (openParams && openParams.tabbedlayout)
				{				
				$('#addressActionFormViewTabs a[data-toggle="tab"]').on('shown.bs.tab', function (e) 
				{
					var activated = e.target;
					var prevActivated = e.relatedTarget;
					console.log(activated, prevActivated);
					
					_self.addressActionFormView.map.invalidateSize();
				});
				}
				
				_self.show();
					
			},
			"error" : function(jqXHR, timeout, message)
			{
				console.error(message);
			}
		});		
	},
	
	onViewStatusChanged: function()
	{
		
	},
	
	onAddressFormSave : function()
	{
		var _self = this;
		
		org.r3.AjaxUtils.submitForm(
			"put", 
			org.r3.PageManager.getRESTUrl('PUT_SiteCollection_Address', [ org.r3.Constants.site ]), 
			$("#addressform_form"), 
			function(responseData) { 
				$('#addressform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });
				// Notifico l'actionFormManager che ho fatto qualcosa.
				_self.onViewStatusChanged();				
			},
			function(jqXHR, timeout, message) { console.error(message); }, 
			"org.r3.message.saveconfirm", 
			true);				
	}
		
			
});

