//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.agenda.agendaentry");

org.r3.db.agenda.agendaentry.AgendaEntryDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_agendaentry";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.agendaentryid = aDataBean.agendaentryid || null;
        this.agendaid = aDataBean.agendaid || null;
        this.entrydescr = aDataBean.entrydescr || null;
        this.entrytype = aDataBean.entrytype || null;
        this.entrytyperefid = aDataBean.entrytyperefid || null;
        this.alldayflag = aDataBean.alldayflag || null;
        this.startdate = aDataBean.startdate || null;
        this.starttime = aDataBean.starttime || null;
        this.enddate = aDataBean.enddate || null;
        this.endtime = aDataBean.endtime || null;
 
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
