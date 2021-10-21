//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.cms.cardchannelview");

org.r3.db.cms.cardchannelview.CardChannelViewDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.cms.cardchannelview.CardChannelViewDTO(aDataBean));
	 },
	 
	 getChannelidDescr: function()
	 {
		 return $.r3Utils.formatLUTDataBeanField('LUT_CMS_Channels', this.dataBean.channelid);
	 },
	 
	 getSiteDescr: function()
	 {
		 return $.r3Utils.formatLUTDataBeanField("LUT_Site", this.dataBean.site);
	 }
 
});

