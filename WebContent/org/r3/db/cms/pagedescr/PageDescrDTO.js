//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.cms.pagedescr");

org.r3.db.cms.pagedescr.PageDescrDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_pagedescr";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.site = aDataBean.site || null;
        this.pageid = aDataBean.pageid || null;
        this.languagecode = aDataBean.languagecode || null;
        this.pagetitle = aDataBean.pagetitle || null;
        this.summary = aDataBean.summary || null;
        this.textbody = aDataBean.textbody || null;
        this.recstatus = aDataBean.recstatus || null;
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
