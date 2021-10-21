//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.project.teamresourceview");

org.r3.db.project.teamresourceview.TeamResourceViewDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_teamresourceview";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.site = aDataBean.site || null;
        this.teamid = aDataBean.teamid || null;
        this.teamdescr = aDataBean.teamdescr || null;
        this.periodindex = aDataBean.periodindex || null;
        this.periodtype = aDataBean.periodtype || null;
        this.teamstatus = aDataBean.teamstatus || null;
        this.resourceid = aDataBean.resourceid || null;
        this.resourcedescr = aDataBean.resourcedescr || null;
        this.profileid = aDataBean.profileid || null;
        this.evalueunit = aDataBean.evalueunit || null;
        this.price = aDataBean.price || null;
        this.cost = aDataBean.cost || null;
        this.resourcedefstatus = aDataBean.resourcedefstatus || null;
        this.recstatus = aDataBean.recstatus || null;
 
	 }
    
   
});
