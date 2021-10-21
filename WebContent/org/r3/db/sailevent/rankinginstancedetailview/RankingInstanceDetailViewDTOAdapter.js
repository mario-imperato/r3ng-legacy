//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.rankinginstancedetailview");

org.r3.db.sailevent.rankinginstancedetailview.RankingInstanceDetailViewDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.sailevent.rankinginstancedetailview.RankingInstanceDetailViewDTO(aDataBean));
	 },
	 
	 getArrivaldate: function()
	 {
		 return $.r3Utils.formatTimestampDataBeanFieldAsTime(this.dataBean.arrivaldate);
	 },
	 
	 getRealtime: function()
	 {
		 return $.r3Utils.formatSecondsToElapsedTime(this.dataBean.realtime);
	 },

	 getDrealtime: function()
	 {		 
		 return $.r3Utils.formatSecondsToElapsedTime(this.dataBean.drealtime);
	 },
	 
	 getCorrectedtime: function()
	 {		 
		 return $.r3Utils.formatSecondsToElapsedTime(this.dataBean.correctedtime);
	 }

});

