//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.cms.cardview");

org.r3.db.cms.cardview.CardViewDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	this.dtrowclass   = "grade_cardview";
        this.dtokey       = aDataBean.dtokey   || null;
        this.dtodescr     = aDataBean.dtodescr || null;
       
        this.site = aDataBean.site || null;
        this.cardid = aDataBean.cardid || null;
        this.languagecode = aDataBean.languagecode || null;
        this.categoryid = aDataBean.categoryid || null;
        this.pagelinktype = aDataBean.pagelinktype || null;
        this.pagelink = aDataBean.pagelink || null;
        this.pageid = aDataBean.pageid || null;
        this.refdate = aDataBean.refdate || null;
        this.options = aDataBean.options || null;
        this.title = aDataBean.title || null;
        this.summary = aDataBean.summary || null;
        this.textbody = aDataBean.textbody || null;
        this.rectimestamp = aDataBean.rectimestamp || null;
 
         // Inserito
        this.properties = null;
        this.cardicon = null;
        this.cardimage = null;
        
        this.listof_image = null;
        this.listof_document = null;
        this.listof_file = null;
        this.listof_link = null;
        this.listof_textlink = null;
        this.listof_iconlink = null;
        this.listof_htmlfragments = null;
        this.listof_executablehtmlfragments = null;
            	
        if ( aDataBean.properties && aDataBean.properties.length)
        {
        	this._initializeProperties(aDataBean.properties);            	
        }        
	 }

     // Inserito
	 ,_initializeProperties: function(anArrayOfPropsDataBean)
	 {		 
		 var propertiesLookupMap = {};
		 
		 for(var i = 0; i < anArrayOfPropsDataBean.length; i++)
		 {
		     var propertyAdapter = new org.r3.db.cms.cardproperty.CardPropertyDTOAdapter(anArrayOfPropsDataBean[i]);
		     propertiesLookupMap[propertyAdapter.dataBean.propertyid] = propertyAdapter;
		     
		     if (!this.properties)
		           this.properties = [ propertyAdapter ];
		     else  this.properties.push(propertyAdapter);
		     
		     if (propertyAdapter.isImage())
		     {
		    	 if (!this.listof_image)
		    		   this.listof_image = [ propertyAdapter ];
		    	 else  this.listof_image.push(propertyAdapter);
		    	 
		    	 if (propertyAdapter.dataBean.propertyrole == 'cms_card_icon')
		    	 {
		    		 this.cardicon = propertyAdapter;
		    	 }
		    	 
		    	 if (propertyAdapter.dataBean.propertyrole == 'cms_card_image')
		    	 {
		    		 this.cardimage = propertyAdapter;
		    	 }
		     }
		     
		     if (propertyAdapter.isDocument())
		     {
		    	 if (!this.listof_document)
		    		 this.listof_document = [ propertyAdapter ];
		    	 else  this.listof_document.push(propertyAdapter);
		     }
		     
		     if (propertyAdapter.isFile())
		     {
		    	 if (!this.listof_file)
		    		 this.listof_file = [ propertyAdapter ];
		    	 else  this.listof_file.push(propertyAdapter);		    	 
		     }

		     if (propertyAdapter.isHtmlfragment())
		     {
		    	 if (propertyAdapter.dataBean.propertyrole == 'cms_htmlexe')
		    	 {
			    	 if (!this.listof_executablehtmlfragments)
			    		   this.listof_executablehtmlfragments = [ propertyAdapter ];
			    	 else  this.listof_executablehtmlfragments.push(propertyAdapter);		    	 
		    	    	 
		    	 }
		    	 else
		    	 {
			    	 if (!this.listof_htmlfragments)
			    		 this.listof_htmlfragments = [ propertyAdapter ];
			    	 else  this.listof_htmlfragments.push(propertyAdapter);		    	 		    		 
		    	 }
		     }

		     if (propertyAdapter.isLink())
		     {		    	 
		    	 if (!this.listof_link)
		    		 this.listof_link = [ propertyAdapter ];
		    	 else  this.listof_link.push(propertyAdapter);
		    	 
		    	 if (propertyAdapter.dataBean.refpropertyid)
		    	 {
			    	 if (!this.listof_iconlink)
			    		 this.listof_iconlink = [ propertyAdapter ];
			    	 else  this.listof_iconlink.push(propertyAdapter);
		    	 }
		    	 else
		    	 {
			    	 if (!this.listof_textlink)
			    		 this.listof_textlink = [ propertyAdapter ];
			    	 else  this.listof_textlink.push(propertyAdapter);		    		 
		    	 }
		     }		 
		 }
		 
		 if (this.listof_iconlink)
		 {
		     for(var k = 0; k < this.listof_iconlink.length; k++)
		     {
		    	 var prop = this.listof_iconlink[k];
		    	 if (prop.dataBean.refpropertyid)
		    	 {
		    		 var referredProperty = propertiesLookupMap[prop.dataBean.refpropertyid];
		    		 if (!referredProperty)
		    		    console.log("ReferredProperty NOT found " + prop.dataBean.refpropertyid);
		    		 else
		    		 {
		    			 prop.dataBean.imageurl =  referredProperty.dataBean.imageurl;
		    			 prop.dataBean.imageheight =  referredProperty.dataBean.imageheight;
		    			 prop.dataBean.imagewidth =  referredProperty.dataBean.imagewidth;

		    			 prop.dataBean.iconurl =  referredProperty.dataBean.iconurl;
		    			 prop.dataBean.iconheight =  referredProperty.dataBean.iconheight;
		    			 prop.dataBean.iconwidth =  referredProperty.dataBean.iconwidth;		    		 
		    		 }		    		 
		    	 }
		     }
		 }
	 }
    
  ,compareTo: function(anItemId)
   {
   	   if (!this.dtokey)
   	       return -99;
   	       
   	   if (this.dtokey < anItemId)
   	       return -1;
   	   else if (this.dtokey > anItemId)
   	   	   return  1;
   	   	   
   	   return 0;
   }
   
});
