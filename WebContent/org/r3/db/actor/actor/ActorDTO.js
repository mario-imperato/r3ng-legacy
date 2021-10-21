//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.actor.actor");

org.r3.db.actor.actor.ActorDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_actor";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.eventid = aDataBean.eventid || null;
        this.actorid = aDataBean.actorid || null;
        this.userid = aDataBean.userid || null;
        this.firstname = aDataBean.firstname || null;
        this.lastname = aDataBean.lastname || null;
        this.phone = aDataBean.phone || null;
        this.cellphone = aDataBean.cellphone || null;
        this.email = aDataBean.email || null;
        this.address = aDataBean.address || null;
        this.town = aDataBean.town || null;
        this.zipcode = aDataBean.zipcode || null;
        this.contactgroup = aDataBean.contactgroup || null;
        this.recstatus = aDataBean.recstatus || null;
        this.rectimestamp = aDataBean.rectimestamp || null;

        // Inserito
        if ( aDataBean.groups)
        {
        	this.groups =  new org.r3.db.DTOTableAdapter(aDataBean.groups, 
    				function(aRowDataBean) { return new org.r3.db.actor.group.ActorGroupDTOAdapter(aRowDataBean); });            	
        }        
        else this.groups = null;
        
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
