//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.system.siteportletcfg");

org.r3.db.system.siteportletcfg.SitePortletConfigDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_siteportletconfig";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.site = aDataBean.site || null;
        this.pageid = aDataBean.pageid || null;
        this.positionid = aDataBean.positionid || null;
        this.jsclassname = aDataBean.jsclassname || null;
        this.cssclassname = aDataBean.cssclassname || null;
        this.datacardid = aDataBean.datacardid || null;
        this.dataoptions = aDataBean.dataoptions || null;
        this.dataonuserstatus = aDataBean.dataonuserstatus || null;
 
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
