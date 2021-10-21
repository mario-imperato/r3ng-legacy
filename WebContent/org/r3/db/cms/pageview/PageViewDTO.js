//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.cms.pageview");

org.r3.db.cms.pageview.PageViewDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_pageview";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.site = aDataBean.site || null;
        this.pageid = aDataBean.pageid || null;
        this.languagecode = aDataBean.languagecode || null;
        this.pagetype = aDataBean.pagetype || null;
        this.pagetitle = aDataBean.pagetitle || null;
        this.summary = aDataBean.summary || null;
        this.pageicon1 = aDataBean.pageicon1 || null;
        this.pageicon2 = aDataBean.pageicon2 || null;
        this.pagelink = aDataBean.pagelink || null;
        this.pageorder = aDataBean.pageorder || null;
        this.visibility = aDataBean.visibility || null;
        this.pagestyle = aDataBean.pagestyle || null;
        this.forwardview = aDataBean.forwardview || null;
        this.onuserstatus = aDataBean.onuserstatus || null;
        this.permissions = aDataBean.permissions || null;
        this.viewoptions = aDataBean.viewoptions || null;
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
