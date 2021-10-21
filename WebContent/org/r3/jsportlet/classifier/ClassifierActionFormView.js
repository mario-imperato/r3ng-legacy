$.r3Utils.namespace("org.r3.jsportlet.classifier");


org.r3.jsportlet.classifier.ClassifierActionFormView  = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		var _self = this;		
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
		$('#classifier_infoLine').infoLine('destroy');
	},

	refresh: function()
	{
	},
	
//	open : function(aClassifierDTOAdapter)
//	{
//		var clsid = (aClassifierDTOAdapter && aClassifierDTOAdapter.dataBean.clsid) || 'n.d.';
//		var clsdescr = (aClassifierDTOAdapter && aClassifierDTOAdapter.dataBean.clsdescr) || 'Non Presente';
//	    $('#classifier_infoLine').infoLine({
//       	  groupId: "classifier",
//	          items: [
//	         	     { id: "infoline_clsid", label: "Id.", value: clsid },
//	         	     { id: "infoline_clsdescr", label: "Nome", value: clsdescr }	         	     
//	          ] 	
//       });		
//	    
//	   this.show();
//	},
	
	open : function(aClassifierDTOAdapter)
	{
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/classifier/ClassifierActionFormView.html.jsp'),
			dataType : "html"
		});

		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_SailEvent'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	
			
			$(this.htmlContainerId).html(responseData['view']);												

			$("#classifierform_form").validate
            ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.jsportlet.classifier.classifier_form_validationRules,
		           messages: org.r3.jsportlet.classifier.classifier_form_validationMessages    
	        });

			$('#classifierform_action_save').unbind().click($.r3Utils.hitch(this, this.onSaveItem));
			$('#classifierform_fieldset_message').formmessage({});
						
			var clsid = (aClassifierDTOAdapter && aClassifierDTOAdapter.dataBean.clsid) || 'n.d.';
			var clsdescr = (aClassifierDTOAdapter && aClassifierDTOAdapter.dataBean.clsdescr) || 'Non Presente';
			
			$('#classifierform_clsid').html(clsid);
			$('#classifierform_clsdescr').val(clsdescr);
			
			$('#classifierform_form_panel_legend_close').unbind().click(function() {
				
					$('#classifierform_form_panel').hide();
					$('#classifier_infoLine').show();
			});

			if (aClassifierDTOAdapter)
			{
			    $('#classifier_infoLine').infoLine({
			    	groupId: "classifier",
			    	items: [
		         	     { id: "infoline_clsid", label: "<i class='fa fa-caret-square-o-down' ></i> Id.", value: clsid },
		         	     { id: "infoline_clsdescr", label: "Nome", value: clsdescr }	         	     
		         	] 	
			    });		
			    
				$('#classifier_infoLine').unbind().click(function() {
					
					$('#classifierform_form_panel').show();
					$('#classifier_infoLine').hide();
			    });			    
			}
			else
			{
			    $('#classifier_infoLine').infoLine({
			    	groupId: "classifier",
			    	items: [
		         	     { id: "infoline_clsid", label: "Id.", value: clsid },
		         	     { id: "infoline_clsdescr", label: "Nome", value: clsdescr }	         	     
		         	] 	
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
	
	onSaveItem: function()
	{	
		var _self = this;

		var method = "PUT";
		var clsid = this.actionFormManager.dataBeanInfo.dataBean.clsid;
		var restUrl = org.r3.PageManager.getRESTUrl("PUT_classifier", [ clsid ]);
					
		this.actionFormManager.submitForm(
				method,
				restUrl,
				$("#classifierform_form"),
				function(responseData) { 
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('classifierform_fieldset_message');
					}		
					else 
					{
					    $('#classifier_infoLine').infoLine('update', {
					    	groupId: "classifier",
					    	items: [
				         	     { id: "infoline_clsid", label: "<i class='fa fa-caret-square-o-down' ></i> Id.", value: responseData.clsid },
				         	     { id: "infoline_clsdescr", label: "Nome", value: responseData.clsdescr }	         	     
				         	] 	
					    });										
						
						$('#classifierform_fieldset_message').formmessage('clear');
						$('#classifierform_form_panel').hide();
						$('#classifier_infoLine').show();
					}
						
					_self.refresh();
		        }, 
				function(jqXHR, timeout, message) { $('#classifierform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);	
	}
	
	
});
