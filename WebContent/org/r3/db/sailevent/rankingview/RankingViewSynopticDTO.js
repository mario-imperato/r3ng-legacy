//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.rankingview");

org.r3.db.sailevent.rankingview.RankingViewSynopticDTO = Class.extend(
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
 
        // L'oggetto RankingViewDTO viene utilizzato anche per modellare l'oggetto RankingViewSynopticDTO
        if (aDataBean.listOfInstances)
        {
            this.listOfInstances = 	[];
            for(var k = 0; k < aDataBean.listOfInstances.length; k++)
            {
            	this.listOfInstances.push(new org.r3.db.sailevent.rankingview.RankingViewDTOAdapter(aDataBean.listOfInstances[k]));            	
            }
        }
        else 
        	this.listOfInstances = null;
        
        this.formattedInstances = null;        
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
