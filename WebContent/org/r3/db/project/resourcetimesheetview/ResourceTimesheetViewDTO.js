//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.project.resourcetimesheetview");

org.r3.db.project.resourcetimesheetview.ResourceTimesheetViewDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_resourcetimesheetview";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.site = aDataBean.site || null;
        this.tsentryid = aDataBean.tsentryid || null;
        this.sitedomain = aDataBean.sitedomain || null;
        this.resourceid = aDataBean.resourceid || null;
        this.resourcedescr = aDataBean.resourcedescr || null;
        this.teamid = aDataBean.teamid || null;
        this.teamperiod = aDataBean.teamperiod || null;
        this.profileid = aDataBean.profileid || null;
        this.companyid = aDataBean.companyid || null;
        this.costcenter1 = aDataBean.costcenter1 || null;
        this.costcenter2 = aDataBean.costcenter2 || null;
        this.costcenter3 = aDataBean.costcenter3 || null;
        this.uniteffort = aDataBean.uniteffort || null;
        this.ordeffort = aDataBean.ordeffort || null;
        this.exteffort = aDataBean.exteffort || null;
        this.oncalleffort = aDataBean.oncalleffort || null;
        this.price = aDataBean.price || null;
        this.cost = aDataBean.cost || null;
        this.evalueunit = aDataBean.evalueunit || null;
        this.caldate = aDataBean.caldate || null;
        this.caleveday = aDataBean.caleveday || null;
        this.calevemonth = aDataBean.calevemonth || null;
        this.caleveweek = aDataBean.caleveweek || null;
        this.calevequarter = aDataBean.calevequarter || null;
        this.caleveyear = aDataBean.caleveyear || null;
        this.tseuserid = aDataBean.tseuserid || null;
 
	 }
    
   
});
