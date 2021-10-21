$.r3Utils.namespace("org.r3.shkadmin.siteconfig");


org.r3.shkadmin.siteconfig.AdminsActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},

	open : function()
	{
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/shkadmin/siteconfig/AdminsActionFormView.html.jsp?mode=detail'),
			dataType : "html"
		});


		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			

			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));

			$('#actorgroupdetailactionform_form').validate(
			{
				errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
				rules : org.r3.console.contacts.actorgroupdetailactionform_form_validationRules,
				messages : org.r3.console.contacts.actorgroupdetailactionform_form_validationMessages
			});

//			var resolvedUrl = it.posteitaliane.unep.PageManager.getRESTUrl('GET_classifier_sys_recstatus');			
//			var recStatus = (prodottoDataBean) ? prodottoDataBean.dataBean.recstatus : 'sys_recact';
//			it.posteitaliane.unep.PageManager.lutManager.populateRadioGroup(
//			{
//				"lutUrl" : resolvedUrl,
//				"groupContainer" : $('#prodottodetailactionform_form_recstatus_cnt'),
//				"groupId" : "prodottodetailactionform_form_recstatus_",
//				"groupName" : "recstatus",
//				"value" : recStatus
//			});
			
			$("#adminsactionform_email").typeahead(
			{ 
				source: function(queryValue, processCallBack) 
				{ 
					var dataTableSource = org.r3.PageManager.getRESTUrl('GET_Users_ByEMail', [ queryValue ]);
					return $.getJSON( dataTableSource, function( data ) 
					{
						return processCallBack(data.aaData);
					});
				}, 
				minLength: 5,
			    autoSelect: true,
			    displayText: function(item) { return item.email; }
			});
			
			$("#adminsactionform_email").change(function() 
			{								
			    var current = $("#adminsactionform_email").typeahead("getActive");
			    if (current && current.email == $("#adminsactionform_email").val()) 
			    {
			            console.log("Exact Match");
			            $('#adminsactionform_firstname').val(current.firstname);
			            $('#adminsactionform_lastname').val(current.lastname);
			            $('#adminsactionform_userid').val(current.userid);
			            $('#adminsactionform_action_saveitem').prop('disabled', false);
			    }
			    else
			    {
			    	$('#adminsactionform_action_saveitem').prop('disabled', true);
			   	}
			});
			
			
			this._initializeFormFields();
			
			$('#adminsactionform_action_saveitem').click(
				$.r3Utils.hitch(this, this._onSaveItem));
											
			$('#adminsactionform_action_cancel').hide();
			
			$('#adminsactionform_fieldset_message').formmessage({});
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	
	_resetForm: function()
	{
		var theForm = $('#adminsactionform_form');
		theForm.resetForm();
		
		$('#adminsactionform_action_saveitem').prop('disabled', true);
	},
	
    _onEmailSelected: function(item)
    {
    	console.info(item);
    },
    
	_onSaveItem: function()
	{
		var _self = this;						
		
		var aUserId = $('#adminsactionform_userid').val();
		var theForm = $('#adminsactionform_form');
		org.r3.AjaxUtils.submitForm(
				"PUT", 
				org.r3.PageManager.getRESTUrl('PUT_User_Add_Role', [ aUserId, 'shkadmin' ]),  
				theForm, 
				function(responseData) { 
					$('#adminsactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' }); 
					// Debbo fare il refresh della lista.
					_self.actionFormManager.refresh();
					_self._resetForm();
				}, 
				function(jqXHR, timeout, message) { $('#adminsactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); },
				"org.r3.message.saveconfirm",
		        true);		
	},
    
	_initializeFormFields: function()
	{
		
	}

});
