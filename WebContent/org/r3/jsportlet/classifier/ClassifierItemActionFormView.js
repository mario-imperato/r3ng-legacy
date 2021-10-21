$.r3Utils.namespace("org.r3.jsportlet.classifier");


org.r3.jsportlet.classifier.ClassifierItemActionFormView  = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		var _self = this;		
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.subgroupsEnabled = false;
	},

	close : function()
	{
		this.hide();
	},

	refresh: function()
	{
        $("#classifieritemform_form").resetForm();
        $('#classifieritemform_clsitemid').prop('disabled', false);
	},
	
	open : function(aClassifierDTOAdapter)
	{
		if (aClassifierDTOAdapter && aClassifierDTOAdapter.isHierarchical())
		{
			 this.subgroupsEnabled = true;		
		}
		else this.subgroupsEnabled = false;
		
		org.r3.PageManager.wait("org.r3.message.waiting");
        console.log("Logged User Is: ", org.r3.PageManager.userInfo);
		var networkRequestsQueue = [];

		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/classifier/ClassifierItemActionFormView.html.jsp'),
			dataType : "html"
		});
			
		org.r3.PageManager.multiAjax(networkRequestsQueue,
				
		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();		
			$(this.htmlContainerId).html(responseData['view']);	

			if (this.subgroupsEnabled)
			{
				$('#classifieritemform_subgroups_cnt').show();
			}
			else 
				$('#classifieritemform_subgroups_cnt').hide();
				
			$("#classifieritemform_form").validate
	        ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.jsportlet.classifier.classifieritem_form_validationRules,
		           messages: org.r3.jsportlet.classifier.classifieritem_form_validationMessages    
	        });
			
			$('#classifieritemform_action_save').unbind().click($.r3Utils.hitch(this, this.onSaveItem));
			$('#classifieritemform_action_clear').unbind().click($.r3Utils.hitch(this, function(e) {
			        $('#classifieritemform_form').resetForm();
			        $('#classifieritemform_clsitemid').val("");
			        $('#classifieritemform_clsitemid').prop("disabled", false);
			}));
			
			$('#classifieritemform_fieldset_message').formmessage({});	
			this.show();
		}),
		
		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
	
	},
	
//	_initializeFormFields: function(anApplicationDTOAdapter)
//	{					
//		$('#classifieritemform_clsitemid').prop('disabled', false);						
//	},
	
	classifierItemDetail: function(aClassifierItemDTOAdapter)
	{
		var networkRequestsQueue = [];

		networkRequestsQueue.push(
		{
			id : "item",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_classifieritemdetail', [ aClassifierItemDTOAdapter.dataBean.clsid,  aClassifierItemDTOAdapter.dataBean.clsitemid ]),
			dataType : "json"
		});
		
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_classifiers'));
			
		org.r3.PageManager.multiAjax(networkRequestsQueue,
				
		$.r3Utils.hitch(this, function(responseData)
		{
			var itemDataBean = responseData['item'];
			if (itemDataBean != null)
			{
				aClassifierItemDTOAdapter = new org.r3.db.system.classifieritem.ClassifierItemDTOAdapter(itemDataBean);
			}

			$('#classifieritemform_clsitemid').val(aClassifierItemDTOAdapter.dataBean.clsitemid);
			$('#classifieritemform_clsitemid').prop('disabled', true);
			
			$('#classifieritemform_clsitembusid').val(aClassifierItemDTOAdapter.dataBean.clsitembusid);
			$('#classifieritemform_classifieritemorder').val(aClassifierItemDTOAdapter.dataBean.classifieritemorder);
			$('#classifieritemform_classifieritemdescr').val(aClassifierItemDTOAdapter.dataBean.classifieritemdescr);
			$('#classifieritemform_classifieritemsattr').val(aClassifierItemDTOAdapter.dataBean.classifieritemsattr);
			$('#classifieritemform_classifieritemiattr').val(aClassifierItemDTOAdapter.dataBean.classifieritemiattr);		
			
			if (this.subgroupsEnabled)
			{
				$('#classifieritemform_subgroups').val(aClassifierItemDTOAdapter.getChildrenAsCSV());
			}
			
//			var lutItem = org.r3.PageManager.getLUTItem('LUT_classifiers', aClassifierItemDTOAdapter.getClassifierDTOKey());
//			if (lutItem)
//			{
//				lutItem = new org.r3.db.system.classifier.ClassifierDTOAdapter(lutItem);
//			   if (lutItem.isHierarchical())
//			   {
//				  console.log("Hierarchical");   
//			   }
//			}
		})
		
		);
		
	},
		
	onSaveItem: function()
	{	
		var _self = this;
		var restUrl = null;
		var method = "POST";
		
		var clsid = this.actionFormManager.dataBeanInfo.dataBean.clsid;
		
		if ($('#classifieritemform_clsitemid').prop("disabled"))
		{
 		    restUrl = org.r3.PageManager.getRESTUrl("PUT_classifieritems", [ clsid, $('#classifieritemform_clsitemid').val() ]);
 			method = "PUT";
		}
		else
		{
			restUrl = org.r3.PageManager.getRESTUrl("POST_classifieritems", [ clsid ]);			
		}
		
		this.actionFormManager.submitForm(
				method,
				restUrl,
				$("#classifieritemform_form"),
				function(responseData) { 
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('classifieritemform_fieldset_message');
					}		
					else $('#classifieritemform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });											
		        }, 
				function(jqXHR, timeout, message) { $('#classifieritemform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);	
	}
	


});
