//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.appeventlogview");

org.r3.db.sailevent.appeventlogview.SailApplicationEventLogViewDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_sailapplicationeventlogview";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.site = aDataBean.site || null;
        this.usecaseambit = aDataBean.usecaseambit || null;
        this.applicationid = aDataBean.applicationid || null;
        this.userid = aDataBean.userid || null;
        this.sailnumber = aDataBean.sailnumber || null;
        this.yachtname = aDataBean.yachtname || null;
        this.ownername = aDataBean.ownername || null;
        this.latest_ts = aDataBean.latest_ts || null;
        this.ev_general = aDataBean.ev_general || null;
        this.ev_general_ts = aDataBean.ev_general_ts || null;
        this.ev_document = aDataBean.ev_document || null;
        this.ev_doc_ts = aDataBean.ev_doc_ts || null;
        this.ev_crew = aDataBean.ev_crew || null;
        this.ev_crew_ts = aDataBean.ev_crew_ts || null;
        this.ev_commit = aDataBean.ev_commit || null;
        this.ev_commit_ts = aDataBean.ev_commit_ts || null;
 
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
