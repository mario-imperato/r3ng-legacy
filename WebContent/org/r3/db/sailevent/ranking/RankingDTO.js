//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.ranking");

org.r3.db.sailevent.ranking.RankingDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
	 	 	 this.dtrowclass   = "grade_ranking";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
        this.eventid = aDataBean.eventid || null;
        this.rankid = aDataBean.rankid || null;
        this.rankinggroup = aDataBean.rankinggroup || null;
        this.ranktitle = aDataBean.ranktitle || null;
        this.ranktype = aDataBean.ranktype || null;
        this.championship = aDataBean.championship || null;
        this.racegroup = aDataBean.racegroup || null;
        this.raceclass = aDataBean.raceclass || null;
        this.rating = aDataBean.rating || null;
        this.racefilepattern = aDataBean.racefilepattern || null;
        this.overallfilepattern = aDataBean.overallfilepattern || null;
        this.rankordering = aDataBean.rankordering || null;
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
