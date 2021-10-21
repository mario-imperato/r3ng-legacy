//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.appcrewmemberview");

org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewSummaryDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_sailapplicationcrewmemberview";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.eventid = aDataBean.eventid || null;
        this.applicationid = aDataBean.applicationid || null;
        this.sailnumber = aDataBean.sailnumber || null;
        this.yachtname = aDataBean.yachtname || null; 
        
        this.crewSize = 0;
        this.crewValid = 0;
        this.crewExpired = 0;
        this.crewError = 0;
        this.crewUnknown = 0;
        this.crewDeleted = 0;
        
        if (aDataBean.listOfCrewMembers && aDataBean.listOfCrewMembers.length > 0)
        {
        	var dataInfo = { aaData: aDataBean.listOfCrewMembers, iTotalRecords: aDataBean.listOfCrewMembers.length };
        	this.listOfCrewMembers = 	
                new org.r3.db.DTOTableAdapter(dataInfo, 
        				function(aRowDataBean) { return new org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewDTOAdapter(aRowDataBean); });          
        	
        	for(var j = 0; j < aDataBean.listOfCrewMembers.length; j++)
        	{
        		var theItem = aDataBean.listOfCrewMembers[j];
        		if (theItem.recstatus && theItem.recstatus == 'sys_recact')
                    this.crewSize++;

        		if (theItem.recstatus && theItem.recstatus == 'sys_recdeleted')
       			{
        			this.crewDeleted++;
        			continue ;
       			}
                    
        		if (theItem.cardnumberstatuscode && theItem.cardnumberstatuscode == 'fiv_cn_valid')
                    this.crewValid++;

        		if (theItem.cardnumberstatuscode && theItem.cardnumberstatuscode == 'fiv_cn_expired')
                    this.crewExpired++;

        		if (theItem.cardnumberstatuscode && theItem.cardnumberstatuscode == 'fiv_cn_unknown')
                    this.crewUnknown++;

        		if (theItem.cardnumberstatuscode && theItem.cardnumberstatuscode == 'fiv_cn_notexist')
                    this.crewError++;                       	    	
        	}
        }
        else this.listOfCrewMembers = null;
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
