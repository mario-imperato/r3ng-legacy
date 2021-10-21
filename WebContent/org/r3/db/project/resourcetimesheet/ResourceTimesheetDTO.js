//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.project.resourcetimesheet");

org.r3.db.project.resourcetimesheet.ResourceTimesheetDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_resourcetimesheet";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.tsentryid = aDataBean.tsentryid || null;
        this.caleveday = aDataBean.caleveday || null;
        this.site = aDataBean.site || null;
        this.teamid = aDataBean.teamid || null;
        this.resourceid = aDataBean.resourceid || null;
        this.uniteffort = aDataBean.uniteffort || null;
        this.ordeffort = aDataBean.ordeffort || null;
        this.exteffort = aDataBean.exteffort || null;
        this.oncalleffort = aDataBean.oncalleffort || null;
        this.tseuserid = aDataBean.tseuserid || null;
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
