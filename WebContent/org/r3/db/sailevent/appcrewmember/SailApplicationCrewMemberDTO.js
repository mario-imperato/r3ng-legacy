//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.appcrewmember");

org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_sailapplicationcrewmember";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.crewmemberid = aDataBean.crewmemberid || null;
        this.eventid = aDataBean.eventid || null;
        this.applicationid = aDataBean.applicationid || null;
        this.cardnumber = aDataBean.cardnumber || null;
        this.crewmembername = aDataBean.crewmembername || null;
        this.weight = aDataBean.weight || null;
        this.crewmemberrolecode = aDataBean.crewmemberrolecode || null;
        this.memberstatuscode = aDataBean.memberstatuscode || null;
        this.createtimestamp = aDataBean.createtimestamp || null;
        this.deletetimestamp = aDataBean.deletetimestamp || null;
        this.checkcardnumber = aDataBean.checkcardnumber || null;
        this.checkcardnumber_ts = aDataBean.checkcardnumber_ts || null;
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
