//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.system.user.user");

org.r3.db.system.user.user.UserDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_user";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.userid = aDataBean.userid || null;
        this.nickname = aDataBean.nickname || null;
        this.password = aDataBean.password || null;
        this.firstname = aDataBean.firstname || null;
        this.lastname = aDataBean.lastname || null;
        this.companyid = aDataBean.companyid || null;
        this.email = aDataBean.email || null;
        this.usertype = aDataBean.usertype || null;
        this.avatarrole = aDataBean.avatarrole || null;
        this.parentuserid = aDataBean.parentuserid || null;
        this.userphoto = aDataBean.userphoto || null;
        this.lastlogin = aDataBean.lastlogin || null;
        this.numberoflogins = aDataBean.numberoflogins || null;
        this.userconsent = aDataBean.userconsent || null;
        this.fbuserid = aDataBean.fbuserid || null;
        this.recstatus = aDataBean.recstatus || null;
        this.rectimestamp = aDataBean.rectimestamp || null;
 
		// Inserito
		this.sitepermissions = aDataBean.sitePermissions || null;
		this.actorid = aDataBean.actorid || null; 
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
