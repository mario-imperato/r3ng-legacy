$.r3Utils.namespace("org.r3");

org.r3.ActionFormManager = Class.extend(
{    
    setDataBeanInfo: function(aDataBeanInfo)
    {
    	  this.dataBeanInfo = aDataBeanInfo;
    },

    setPageManager: function(aPageManager)
    {
    	 this.pageManager = aPageManager;
    },
    
    setCanvas: function(amActionFormCanvasId)
    {
    	this.canvasId = amActionFormCanvasId;
    },
    
    showCanvas: function()
    {
    	if (this.canvasId)
    		$(this.canvasId).show();
    },
    
    hideCanvas: function()
    {
    	if (this.canvasId)
    		$(this.canvasId).hide();
    }
    
});

