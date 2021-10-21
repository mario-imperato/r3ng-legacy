//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.system.outmailspooler");

org.r3.db.system.outmailspooler.OutMailSpoolerDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.system.outmailspooler.OutMailSpoolerDTO(aDataBean));
	 },
	 
	 getRecstatus: function()
	 {
		 return $.r3Utils.formatLUTDataBeanField('GET_classifier_sys_recstatus', this.dataBean.recstatus);
	 },
	 
	 getRectimestamp: function()
	 {
		 return $.r3Utils.formatTimestampDataBeanField(this.dataBean.rectimestamp);		 
	 },
	 
	 getMsgtext: function()
	 {
		 var t = this.dataBean.msgtext;
		 if (t)
		 {
			 var s = org.r3.Constants.getDMSPublicCardFolderUrl('OUTMAIL'); 
			 t = t.replace('cid:', s);
		 }
		 return t;
	 },
	 
	 getMsgmode: function()
	 {
		 var s = "UNKOWN";
		 
		 if (this.dataBean.msgmode)
		 {
			 switch(this.dataBean.msgmode)
			 {
			 case 'msg_regular':
				 s = org.r3.db.system.outmailspooler.message.msgmode_msg_regular;
				 break;

			 case 'msg_undisclosed':
				 s = org.r3.db.system.outmailspooler.message.msgmode_msg_undisclosed;
				 break;

			 }
			 
		 }
		 
		 return s;
	 }
	 
 
});

