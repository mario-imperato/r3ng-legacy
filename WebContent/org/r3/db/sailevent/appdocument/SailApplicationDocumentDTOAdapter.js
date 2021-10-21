//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.appdocument");

org.r3.db.sailevent.appdocument.SailApplicationDocumentDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.sailevent.appdocument.SailApplicationDocumentDTO(aDataBean));
	 },
	 
	 getContenttypeAsIconCSSStyle: function()
	 {
		 if (this.dataBean.contenttype)
			 return 'icon_' + this.dataBean.contenttype.replace('/', '_');
		 
		 return 'icon_file';
	 },
	 
	 getDocumenttypecode: function()
	 {
		 return $.r3Utils.formatLUTDataBeanField('GET_classifier_r3ea_doctype', this.dataBean.documenttypecode);
	 },
	 
	 getDocumentUrl: function()
	 {
		 if (this.dataBean.documenturl)
			 return $.r3Utils.formatDMSUrl4ClientAccess(this.dataBean.documenturl);
		
		 return null;
	 }
 
});

