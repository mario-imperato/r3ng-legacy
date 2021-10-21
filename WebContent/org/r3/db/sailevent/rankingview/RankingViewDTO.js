//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.rankingview");

org.r3.db.sailevent.rankingview.RankingViewDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_rankingview";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.eventid = aDataBean.eventid || null;
        this.rankid = aDataBean.rankid || null;
        this.rankinggroup = aDataBean.rankinggroup || null;
        this.ranktitle = aDataBean.ranktitle || null;
        this.racegroup = aDataBean.racegroup || null;
        this.raceclass = aDataBean.raceclass || null;
        this.rankordering = aDataBean.rankordering || null;
        this.instanceid = aDataBean.instanceid || null;
        this.instancetype = aDataBean.instancetype || null;
        this.racenumber = aDataBean.racenumber || null;
        this.racefiledmsurl = aDataBean.racefiledmsurl || null;
        this.racedate = aDataBean.racedate || null;
 
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
