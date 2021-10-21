$.r3Utils.namespace("org.r3.jsportlet.dialog");

org.r3.jsportlet.dialog.DialogConfirmationActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.dialogId = "#org_r3_jsportlet_dialog_confirmationdialog";
		this.options = null;
	},

	close : function()
	{
		$(this.dialogId).modal("hide");
	},

	show : function(optionsHash)
	{
		$(this.dialogId).modal();
	   	this.options = optionsHash;
	   	
	   	$('#org_r3_jsportlet_dialog_confirmationdialog #org_r3_jsportlet_dialog_confirmationdialog_opt_delete').prop('checked', false);
	},

	open : function()
	{
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkInitializationQueue = [];

		networkInitializationQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/dialog/DialogConfirmationActionFormView.html.jsp'),
			dataType : "html"
		});
				
		org.r3.PageManager.multiAjax(networkInitializationQueue,
 		
		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			$(this.htmlContainerId).html(responseData['view']);

			var actionFormView = this;
//			$(this.dialogId).dialog(
//			{
//				dialogClass: 'r3_dialog_no_title',
//				autoOpen : false,
//				height : 150,
//				width : 500,
//				modal : true,
//				buttons :
//				{
//					"OK" : $.r3Utils.hitch(actionFormView, actionFormView.confirmDialog),
//					"Annulla" : $.r3Utils.hitch(actionFormView, actionFormView.dismissDialog)
//				},
//				close : function()
//				{
//				}
//			});		
			
			$('#org_r3_jsportlet_dialog_confirmationdialog_actionconfirm')
		     .unbind()
		     .click($.r3Utils.hitch(actionFormView, actionFormView.confirmDialog));
						
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},

	dismissDialog : function()
	{
		$(this.dialogId).modal("hide");
	},

	confirmDialog : function()
	{
		var checkField = $('#org_r3_jsportlet_dialog_confirmationdialog_opt_delete');
		$(this.dialogId).modal("hide");
        if (this.options.onConfirmed)
        {        	
            this.options.onConfirmed(checkField.prop('checked') ? 'btrue' : 'bfalse');	
        }
        		
	}
	        	
});
