//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.cms.category");

org.r3.db.cms.category.CategoryDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_category";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.site = aDataBean.site || null;
        this.categoryid = aDataBean.categoryid || null;
        this.categorymode = aDataBean.categorymode || null;
        this.categorydescr = aDataBean.categorydescr || null;
        this.previewtmpl = aDataBean.previewtmpl || null;
        this.fulltmpl = aDataBean.fulltmpl || null;
 
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
