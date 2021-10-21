//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.project.wbsnodeteammemberprofileview");

org.r3.db.project.wbsnodeteammemberprofileview.WBSNodeTeamMemberProfileViewDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_wbsnodeteammemberprofileview";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.profileid = aDataBean.profileid || null;
        this.wbsnodeid = aDataBean.wbsnodeid || null;
        this.effort = aDataBean.effort || null;
        this.uniteffort = aDataBean.uniteffort || null;
        this.recstatus = aDataBean.recstatus || null;
        this.site = aDataBean.site || null;
        this.wbsid = aDataBean.wbsid || null;
        this.nodetype = aDataBean.nodetype || null;
        this.nodeorder = aDataBean.nodeorder || null;
        this.nodesect = aDataBean.nodesect || null;
        this.nodename = aDataBean.nodename || null;
        this.nodestatus = aDataBean.nodestatus || null;
 
	 }
    
   
});
