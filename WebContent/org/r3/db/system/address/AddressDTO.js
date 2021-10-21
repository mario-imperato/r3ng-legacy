//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.system.address");

org.r3.db.system.address.AddressDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_address";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.addressid = aDataBean.addressid || null;
        this.entityid = aDataBean.entityid || null;
        this.countryid = aDataBean.countryid || null;
        this.ownerid = aDataBean.ownerid || null;
        this.addresstypeid = aDataBean.addresstypeid || null;
        this.state = aDataBean.state || null;
        this.city = aDataBean.city || null;
        this.zipcode = aDataBean.zipcode || null;
        this.address = aDataBean.address || null;
        this.phonecode1 = aDataBean.phonecode1 || null;
        this.phonecode2 = aDataBean.phonecode2 || null;
        this.phone1 = aDataBean.phone1 || null;
        this.phone2 = aDataBean.phone2 || null;
        this.website = aDataBean.website || null;
 
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
