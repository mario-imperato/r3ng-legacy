$.r3Utils.namespace("org.r3");

org.r3.ActionForm = Class.extend(
{

   
	 init: function(anHtmlActionFormContainerId, aParentActionForm)
	 {   
	 	   this.htmlContainerId = anHtmlActionFormContainerId;
	 	   this.parentActionForm = aParentActionForm;
	 	   this.queryParams = {};
       this.htmlHasBeenLoaded = false;
   },

   isHasBeenLoaded: function()
   {
   	  return this.htmlHasBeenLoaded;
   },

   setHasBeenLoaded: function(aFlag)
   {
   	  this.htmlHasBeenLoaded = aFlag;
   },
  
   setHtml: function(anHtml)
   {
   	  this.getHtmlContainer().html(anHtml);
   	  this.htmlHasBeenLoaded = true;
   },
  
   loadHtml: function(aUrl, onCompleteCallBack, showOnComplete)
   {
	 	   this.getHtmlContainer().load(aUrl, $.r3Utils.hitch(this, function(jsonData)
	 	   { 
	 	   	   this.htmlHasBeenLoaded = true;
	 	   	   if (showOnComplete)
	 	   	        this.getHtmlContainer().show();
	 	   	        
	 	   	   if (onCompleteCallBack)
	 	   	        onCompleteCallBack();
	 	   }
	 	   ));
   },

   loadHtmlAndShow: function(aUrl, onCompleteCallBack)
   {
   	  if (!this.isHasBeenLoaded())
   	         this.loadHtml(aUrl, onCompleteCallBack, true);
   	  else   
   	  {
   	  	if (onCompleteCallBack) onCompleteCallBack();
   	  	this.getHtmlContainer().show();
   	  }
   },

   show: function()
   {
   	  this.getHtmlContainer().show();
   },

   hide: function()
   {
   	  this.getHtmlContainer().hide();
   },
   
   getHtmlContainer: function()
   {
   	   return $(this.htmlContainerId);
   },
   
   closeParentActionForm: function()
   {
   	   if (this.parentActionForm)
   	      this.parentActionForm.close();
   },

   hideParentActionForm: function()
   {
   	   if (this.parentActionForm)
   	      this.parentActionForm.hide();
   },
  
   fnGetQueryParameters: function ( aoData ) 
   {
        if (this.queryParams != null)	
        {
        	   for (var name in this.queryParams)
        	   {
        	   	 // console.log("QueryParameters: ", name, this.queryParams[name]);
        	   	 aoData.push({ "name": name, "value": this.queryParams[name] });
        	   }        	           	   
        }
         
   },
   
   addQueryParameter: function(param)
   {
   	   for(var pname in param)
   	   {
   	   	   this.queryParams[pname] = param[pname];
   	   	   // console.log("Pname: ", pname, param[pname]);
   	   }
   }


	 	
});

