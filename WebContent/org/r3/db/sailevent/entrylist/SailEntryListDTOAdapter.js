//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.entrylist");

org.r3.db.sailevent.entrylist.SailEntryListDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.sailevent.entrylist.SailEntryListDTO(aDataBean));
	 },
	 
	 getBoatIconUrl: function()
	 {
		 if (this.hasBoatImage())
			 return $.r3Utils.formatDMSUrl4ClientAccess(this.dataBean.boaticonurl);
			 
		 return org.r3.Constants.getDefaultBoatIcon();
	 },
	 
	 getBoatImageUrl: function()
	 {
		 if (this.hasBoatImage())
			 return $.r3Utils.formatDMSUrl4ClientAccess(this.dataBean.boatimageurl);
			 
		 return null;
	 },
	 
	 hasBoatImage: function()
	 {
		 return this.dataBean.boaticonurl;
	 },

	 getBoatIconMarginTop: function()
	 {
		 if (this.hasBoatImage())
		 {
			 return Math.floor((org.r3.Constants.boatIconMaxHeight - this.dataBean.boaticonheight) / 2)  || '0';			 
		 }
		 else  return Math.floor((org.r3.Constants.boatIconMaxHeight - org.r3.Constants.defaultBoatIconHeight) / 2)  || '0';
	 },
	 
	 getBoatIconLayoutType: function()
	 {
		 if (this.hasBoatImage())
		 {
			 return (this.dataBean.boaticonwidth - this.dataBean.boaticonheight) > 0 ? 'landscape' : 'portrait';			 
		 }
		 
		 null;
	 },
	 
	 getRacegroup: function()
     {
		 return $.r3Utils.formatLUTDataBeanField('GET_classifier_r3ea_boatgroup', this.dataBean.racegroup);
	 },
	 
	 getRaceclass: function()
	 {
		 return $.r3Utils.formatLUTDataBeanField('GET_classifier_r3ea_raceclass', this.dataBean.raceclass);
	 },
	 
	 getEscapedYachtTitle: function()
	 {
		 var t = this.dataBean.sailnumber + ' - ' + $.r3Utils.format4HtmlConsumption(this.dataBean.yachtname);
		 return t;
	 }
	 
});

