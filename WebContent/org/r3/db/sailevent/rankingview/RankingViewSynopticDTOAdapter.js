//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.rankingview");

org.r3.db.sailevent.rankingview.RankingViewSynopticDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.sailevent.rankingview.RankingViewSynopticDTO(aDataBean));
	 },
	 
	 getNumberOfInstances: function()
	 {
		 if (this.dataBean.listOfInstances && this.dataBean.listOfInstances.length > 0)
			 return this.dataBean.listOfInstances.length - (this.getOverallInstance() ? 1 : 0);
		 
		 return 0;
	 },
	 	 
	 getOverallInstance: function()
	 {
		 if (this.dataBean.listOfInstances && this.dataBean.listOfInstances.length > 0 && 
				 this.dataBean.listOfInstances[this.dataBean.listOfInstances.length - 1].isOverallInstance()) 
			 return this.dataBean.listOfInstances[this.dataBean.listOfInstances.length - 1];
			 		 
		 return null;		 		 		 
	 },
	 
     getSynopticItemData: function(maxNumberOfInstances)
     {
    	 var formattedInstances = [];
	     for(var i = 0; i < this.getNumberOfInstances(); i++)
	     {
	    	 formattedInstances.push({
	    		 "instanceid": this.dataBean.listOfInstances[i].dataBean.instanceid,
	    		 "racenumber": this.dataBean.listOfInstances[i].dataBean.racenumber,
	    		 "racedate": $.r3Utils.formatDataDataBeanField(this.dataBean.listOfInstances[i].dataBean.racedate),
	    		 "overall": false,
	    		 "linkIcon": null
	    	 });	 
	     }
	     
	     if (maxNumberOfInstances > this.getNumberOfInstances())
	     {
	    	 for(var i = 0; i < (maxNumberOfInstances - this.getNumberOfInstances()); i++)
	    	 {
    	    	 formattedInstances.push({
    	    		 "instanceid": 'empty',
    	    		 "racenumber": -1,
    	    		 "racedate": null,
    	    		 "overall": false,
    	    		 "linkIcon": null    	    		 
    	    	 }); 	     	    		 
	    	 }
	     }
	     
	     var overall = this.getOverallInstance();
	     var overallid = 'empty';
	     if (overall)
	     {
             overallid = overall.dataBean.instanceid;
	     }
	         
	     formattedInstances.push({
	    		 "instanceid": overallid,
	    		 "racenumber": 99,
	    		 "racedate": null,
	    		 "overall": true,
	    		 "linkIcon": org.r3.Constants.applicationContext + '/resources/img/sailevent/classifica.gif'
	     }); 	     	         	 

    	 
    	 return { "ranktitle": this.dataBean.ranktitle,  "instances": formattedInstances } ;
     }
});

