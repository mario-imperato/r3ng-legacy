$.r3Utils.namespace("org.r3");

org.r3.RestDTOAdapter = Class.extend(
{
	init : function(aRowDataBean)
	{
        this.status = aRowDataBean.status;
        this.reason = aRowDataBean.reason;
        this.reasoncode = aRowDataBean.reasoncode;
        this.correlationid = aRowDataBean.correlationid;
        this.counter1 = aRowDataBean.counter1;
        this.counter2 = aRowDataBean.counter2;        
	},

    isOk: function()
    {
    	return this.status == 'ok';
    },

    isFail: function()
    {
    	return this.status == 'fail';
    },

    isWarning: function()
    {
    	return this.status == 'warning';
    },
    
    isFailOrWarning: function()
    {
    	return this.isFail() || this.isWarning() ;
    },
    
    showMessage: function(formMessageWidgetId, messageNamespace)
    {
    	var msgCategory = 'info';
    	if (this.isFailOrWarning())
    		msgCategory = 'error';
    	
    	var msgReason = this.getMessageReason(messageNamespace);
    	var formMessageObj = $('#' + formMessageWidgetId);
    	if (formMessageObj.length == 0)
    		console.error("Invalid form message id: " + formMessageWidgetId);
    	formMessageObj.formmessage('setText', { text: msgReason, category: msgCategory });
    },
    
    getMessageReason: function(aNamespace)
    {
    	var msgReason = this.reason;
    	if (this.reasoncode && this.reasoncode != '_NO_CODE_')
    	{
    		if (aNamespace)
    			msgReason = org.r3.PageManager.getMessageFromDict(aNamespace + '.message.' + this.reasoncode);	
    		else  
    			msgReason = org.r3.PageManager.getMessageFromDict('org.r3.message.' + this.reasoncode);	
    	}
    	
    	return msgReason;
    }

});
