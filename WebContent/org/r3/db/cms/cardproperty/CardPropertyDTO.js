//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.cms.cardproperty");

org.r3.db.cms.cardproperty.CardPropertyDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_cardproperty";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.propertyid = aDataBean.propertyid || null;
        this.site = aDataBean.site || null;
        this.cardid = aDataBean.cardid || null;
        this.languagecode = aDataBean.languagecode || null;
        this.propertyrole = aDataBean.propertyrole || null;
        this.propertytypecode = aDataBean.propertytypecode || null;
        this.propertyname = aDataBean.propertyname || null;
        this.propertyvalue = aDataBean.propertyvalue || null;
        this.propertysize = aDataBean.propertysize || null;
        this.refpropertyid = aDataBean.refpropertyid || null;
        this.contenttype = aDataBean.contenttype || null;
        this.imageurl = aDataBean.imageurl || null;
        this.imageheight = aDataBean.imageheight || null;
        this.imagewidth = aDataBean.imagewidth || null;
        this.iconurl = aDataBean.iconurl || null;
        this.iconwidth = aDataBean.iconwidth || null;
        this.iconheight = aDataBean.iconheight || null;
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
