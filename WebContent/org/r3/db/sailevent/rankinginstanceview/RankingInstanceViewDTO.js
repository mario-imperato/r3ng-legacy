//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.rankinginstanceview");

org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_rankinginstanceview";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.eventid = aDataBean.eventid || null;
        this.rankid = aDataBean.rankid || null;
        this.ranktype = aDataBean.ranktype || null;
        this.ranktitle = aDataBean.ranktitle || null;
        this.racegroup = aDataBean.racegroup || null;
        this.raceclass = aDataBean.raceclass || null;
        this.rankrateorg = aDataBean.rankrateorg || null;
        this.instanceid = aDataBean.instanceid || null;
        this.instancetype = aDataBean.instancetype || null;
        this.racenumber = aDataBean.racenumber || null;
        this.racedate = aDataBean.racedate || null;
        this.racetime = aDataBean.racetime || null;
        this.racedistance = aDataBean.racedistance || null;
        this.racerating = aDataBean.racerating || null;
        this.racefiledmsurl = aDataBean.racefiledmsurl || null;
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
