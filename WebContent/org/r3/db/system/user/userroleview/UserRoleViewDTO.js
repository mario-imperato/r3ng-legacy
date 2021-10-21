//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.system.user.userroleview");

org.r3.db.system.user.userroleview.UserRoleViewDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_userroleview";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.site = aDataBean.site || null;
        this.userid = aDataBean.userid || null;
        this.roleid = aDataBean.roleid || null;
        this.roledescr = aDataBean.roledescr || null;
 
	 }
    
   
});
