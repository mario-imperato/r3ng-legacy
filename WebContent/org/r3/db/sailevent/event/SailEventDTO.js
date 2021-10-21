//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.event");

org.r3.db.sailevent.event.SailEventDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_sailevent";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.eventid = aDataBean.eventid || null;
        this.eventtitle = aDataBean.eventtitle || null;
        this.eventdescr = aDataBean.eventdescr || null;
        this.eventgroup = aDataBean.eventgroup || null;
        this.eventstatus = aDataBean.eventstatus || null;
        this.applicationstatus = aDataBean.applicationstatus || null;
 
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
