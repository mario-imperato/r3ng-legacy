//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.sailevent.rankinginstancedetail");

org.r3.db.sailevent.rankinginstancedetail.RankingInstanceDetailDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_rankinginstancedetail";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.rankentryid = aDataBean.rankentryid || null;
        this.eventid = aDataBean.eventid || null;
        this.instanceid = aDataBean.instanceid || null;
        this.applicationid = aDataBean.applicationid || null;
        this.pos = aDataBean.pos || null;
        this.sailnumber = aDataBean.sailnumber || null;
        this.yachtname = aDataBean.yachtname || null;
        this.owner = aDataBean.owner || null;
        this.club = aDataBean.club || null;
        this.model = aDataBean.model || null;
        this.racegroup = aDataBean.racegroup || null;
        this.division = aDataBean.division || null;
        this.timoniere = aDataBean.timoniere || null;
        this.arrivaldate = aDataBean.arrivaldate || null;
        this.realtime = aDataBean.realtime || null;
        this.drealtime = aDataBean.drealtime || null;
        this.correctedtime = aDataBean.correctedtime || null;
        this.annotation = aDataBean.annotation || null;
        this.perctempen = aDataBean.perctempen || null;        
        this.perctempen = aDataBean.perctempen || null;
        this.score = aDataBean.score || null;
        this.maxraces = aDataBean.maxraces || null;
        this.scorer01 = aDataBean.scorer01 || null;
        this.scorer02 = aDataBean.scorer02 || null;
        this.scorer03 = aDataBean.scorer03 || null;
        this.scorer04 = aDataBean.scorer04 || null;
        this.scorer05 = aDataBean.scorer05 || null;
        this.scorer06 = aDataBean.scorer06 || null;
        this.scorer07 = aDataBean.scorer07 || null;
        this.scorer08 = aDataBean.scorer08 || null;
        this.scorer09 = aDataBean.scorer09 || null;
        this.scorer10 = aDataBean.scorer10 || null;
        this.scorer11 = aDataBean.scorer11 || null;
        this.scorer12 = aDataBean.scorer12 || null;
        this.scorer13 = aDataBean.scorer13 || null;
        this.scorer14 = aDataBean.scorer14 || null;
        this.scorer15 = aDataBean.scorer15 || null;
        this.scorern01 = aDataBean.scorern01 || null;
        this.scorern02 = aDataBean.scorern02 || null;
        this.scorern03 = aDataBean.scorern03 || null;
        this.scorern04 = aDataBean.scorern04 || null;
        this.scorern05 = aDataBean.scorern05 || null;
        this.scorern06 = aDataBean.scorern06 || null;
        this.scorern07 = aDataBean.scorern07 || null;
        this.scorern08 = aDataBean.scorern08 || null;
        this.scorern09 = aDataBean.scorern09 || null;
        this.scorern10 = aDataBean.scorern10 || null;
        this.scorern11 = aDataBean.scorern11 || null;
        this.scorern12 = aDataBean.scorern12 || null;
        this.scorern13 = aDataBean.scorern13 || null;
        this.scorern14 = aDataBean.scorern14 || null;
        this.scorern15 = aDataBean.scorern15 || null;
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
