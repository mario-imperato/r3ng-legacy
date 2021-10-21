//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.ranking");

org.r3.db.sailevent.ranking.RankingDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.sailevent.ranking.RankingDTO(aDataBean));
	 },
	 
	 getRating: function()
	 {
		 return $.r3Utils.formatLUTDataBeanField('GET_classifier_rank_rating', this.dataBean.rating);
	 },
	 
	 getRacegroup: function()
	 {
		 return $.r3Utils.formatLUTDataBeanField('GET_classifier_r3ea_boatgroup', this.dataBean.racegroup);		 
	 },
	 
	 getRaceclass: function()
	 {
		 return $.r3Utils.formatLUTDataBeanField('GET_classifier_r3ea_raceclass', this.dataBean.raceclass);		 		 
	 },
	 
	 getRankinggroup: function()
	 {
		 return $.r3Utils.formatLUTDataBeanField('GET_classifier_r3ea_sinott', this.dataBean.rankinggroup);		 
	 }
 
});

