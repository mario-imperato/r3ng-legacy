//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.system.classifier");

org.r3.db.system.classifier.ClassifierDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_classifier";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.site = aDataBean.site || null;
        this.clsid = aDataBean.clsid || null;
        this.clsdescr = aDataBean.clsdescr || null;
        this.clstypecode = aDataBean.clstypecode || null;
        this.clsambitcode = aDataBean.clsambitcode || null;
        this.cacheinterval = aDataBean.cacheinterval || null;
        this.etag = aDataBean.etag || null;
        this.rectimestamp = aDataBean.rectimestamp || null;
 
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
