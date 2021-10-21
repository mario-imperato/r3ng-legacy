//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.project.siteresourceview");

org.r3.db.project.siteresourceview.SiteResourceViewDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_siteresourceview";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.resourceid = aDataBean.resourceid || null;
        this.resourcetype = aDataBean.resourcetype || null;
        this.resourcedescr = aDataBean.resourcedescr || null;
        this.sitedomain = aDataBean.sitedomain || null;
        this.userid = aDataBean.userid || null;
        this.firstname = aDataBean.firstname || null;
        this.lastname = aDataBean.lastname || null;
        this.phone = aDataBean.phone || null;
        this.cellphone = aDataBean.cellphone || null;
        this.email = aDataBean.email || null;
        this.address = aDataBean.address || null;
        this.town = aDataBean.town || null;
        this.zipcode = aDataBean.zipcode || null;
        this.resourcecardid = aDataBean.resourcecardid || null;
        this.recstatus = aDataBean.recstatus || null;
        this.rectimestamp = aDataBean.rectimestamp || null;
        this.site = aDataBean.site || null;
        this.profileid = aDataBean.profileid || null;
        this.evalueunit = aDataBean.evalueunit || null;
        this.price = aDataBean.price || null;
        this.cost = aDataBean.cost || null;
        this.siterecstatus = aDataBean.siterecstatus || null;
 
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
