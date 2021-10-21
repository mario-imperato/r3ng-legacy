$.r3Utils.namespace("org.r3");

org.r3.ActionFormView = Class.extend(
{
   
	 init: function(anHtmlActionFormContainerId, anActionFormManager)
	 {   
	 	   this.htmlContainerId = anHtmlActionFormContainerId;
	 	   this.actionFormManager = anActionFormManager;
	 	   this.viewIsVisible = false;
   },

   isVisible: function()
   {
   	  return this.viewIsVisible;
   },
    
   setHtml: function(anHtml)
   {
   	  this.getHtmlContainer().html(anHtml);
   },
  
   loadHtml: function(aUrl, onCompleteCallBack, showOnComplete)
   {
	 	   this.getHtmlContainer().load(aUrl, $.r3Utils.hitch(this, function(jsonData)
	 	   { 
	 	   	   if (showOnComplete)
	 	   	        this.getHtmlContainer().show();
	 	   	        
	 	   	   if (onCompleteCallBack)
	 	   	        onCompleteCallBack();
	 	   }
	 	   ));
   },

   loadHtmlAndShow: function(aUrl, onCompleteCallBack)
   {
       this.loadHtml(aUrl, onCompleteCallBack, true);
   },

   show: function()
   {
   	  this.getHtmlContainer().show();   	  
   	  this.viewIsVisible = true;   	     
   },

   refresh: function()
   {
	   
// Da verificarer eventuali problemi dall'aver commentato quanto segue.	   
//	  if (!this.viewIsVisible)
//		  this.show();
   },

   hide: function()
   {
	  this.getHtmlContainer().hide();
   	  this.viewIsVisible = false;
   },
   
   getHtmlContainer: function()
   {
   	   return $(this.htmlContainerId);
   },

   queryParams: [],
     
   fnGetQueryParameters: function ( aoData ) 
   {
   	    // console.log("fnGetQueryParameters::", this.queryParams);
        if (this.queryParams != null && this.queryParams.length)	
        {
        	   for (var i = 0; i < this.queryParams.length; i++)
        	   {
        	   	 // console.log("QueryParameters: ", pname, this.queryParams[pname]);
        	   	 aoData.push(this.queryParams[i]);
        	   }        	           	   
        }
         
   },
   
   addQueryParameter: function(param)
   {
	   this.queryParams.push(param);   	   
   },
   
   clearQueryParameters: function()
   {
   	  // console.log("clearQueryParameters::", this);
   	  this.queryParams = [];
   }
        
	 	
});

