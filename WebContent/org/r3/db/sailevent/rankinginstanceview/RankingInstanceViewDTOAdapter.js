//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.rankinginstanceview");

org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewDTO(aDataBean));
	 },
	 
	 getRacedate: function()
	 {
		 return $.r3Utils.formatDataDataBeanField(this.dataBean.racedate);
	 },
	 
	 getRacetime: function()
	 {
		 return this.dataBean.racetime;
	 },
	 
	 getRacegroup: function()
	 {
		 return $.r3Utils.formatLUTDataBeanField('GET_classifier_r3ea_boatgroup', this.dataBean.racegroup);		 
	 },
	 
	 getRaceclass: function()
	 {
		 return $.r3Utils.formatLUTDataBeanField('GET_classifier_r3ea_raceclass', this.dataBean.raceclass);		 		 
	 },
	 
	 isOverallInstance: function()
	 {
		 return this.dataBean && this.dataBean.instancetype && this.dataBean.instancetype == 'rank_overall';	
	 },
	 
     getRectimestamp: function()
     {
    	 return $.r3Utils.formatTimestampDataBeanField(this.dataBean.rectimestamp);
     },
     
     isRankType: function(aRankType)
     {
    	 return this.dataBean && this.dataBean.ranktype && this.dataBean.ranktype == aRankType;
     },
     
     isRankRateOrg: function(aRatingOrgType)
     {
    	 return this.dataBean && this.dataBean.rankrateorg && this.dataBean.rankrateorg == aRatingOrgType;
     }
     	 
 
});

