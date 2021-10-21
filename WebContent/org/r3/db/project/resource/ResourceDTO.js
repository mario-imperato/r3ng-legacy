//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.project.resource");

org.r3.db.project.resource.ResourceDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_resource";
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
        this.ssn = aDataBean.ssn || null;
        this.sex = aDataBean.sex || null;
        this.birthdate = aDataBean.birthdate || null;
        this.birthtown = aDataBean.birthtown || null;
        this.birthdistrict = aDataBean.birthdistrict || null;
        this.resourcecardid = aDataBean.resourcecardid || null;
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
