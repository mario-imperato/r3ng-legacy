//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.bbs.bbsthread");

org.r3.db.bbs.bbsthread.BBSThreadDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.bbs.bbsthread.BBSThreadDTO(aDataBean));
	 },
	 
	 getCreationdate: function()
	 {
		return $.r3Utils.formatTimestampDataBeanField(this.dataBean.creationdate);
	 },

	 getLastposttimestamp: function()
	 {
		return $.r3Utils.formatTimestampDataBeanField(this.dataBean.lastposttimestamp);
	 },
	 
	 getThreadProfile: function()
	 {
		 var p = new org.r3.db.bbs.bbsthread.BBSThreadDTO_Default_Profile();
		 
		 if (!this.dataBean.threadprofile)
			 return p;
		 		 
		 switch(this.dataBean.threadprofile)
		 {
		 case 'crewask':
			 p = new org.r3.db.bbs.bbsthread.BBSThreadDTO_CImbarco_Profile();
			 break;
		 case 'crewoffer':
			 p = new org.r3.db.bbs.bbsthread.BBSThreadDTO_OImbarco_Profile();
			 break;
		 }
		 
		 return p;
	 }

});

