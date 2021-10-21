//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.project.teamresource");

org.r3.db.project.teamresource.TeamResourceDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_teamresource";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.site = aDataBean.site || null;
        this.teamid = aDataBean.teamid || null;
        this.resourceid = aDataBean.resourceid || null;
        this.profileid = aDataBean.profileid || null;
        this.evalueunit = aDataBean.evalueunit || null;
        this.price = aDataBean.price || null;
        this.cost = aDataBean.cost || null;
        this.resourcedefstatus = aDataBean.resourcedefstatus || null;
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
