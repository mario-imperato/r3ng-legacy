//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.system.smsqueue");

org.r3.db.system.smsqueue.SMSQueueDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.system.smsqueue.SMSQueueDTO(aDataBean));
	 },
	 
	 getRecstatus: function()
	 {
		 return $.r3Utils.formatLUTDataBeanField('GET_classifier_sys_recstatus', this.dataBean.recstatus);
	 },
	 
	 getRectimestamp: function()
	 {
		 return $.r3Utils.formatTimestampDataBeanField(this.dataBean.rectimestamp);		 
	 },

	 getGtwayresponsecodeAsSemaphore: function()
	 {
		if (this.dataBean.recstatus)
	    {
			if (this.dataBean.recstatus == 'sys_recact')
				return $.r3Utils.formatSemaphore('gray');
			
			if (this.dataBean.gtwayresponsecode && this.dataBean.gtwayresponsecode == 'OK')
				return $.r3Utils.formatSemaphore('green');
		}
		
		return $.r3Utils.formatSemaphore('red');
	 },
	 
	 getSmsinfo: function()
	 {
		 var m = this.dataBean.smstext;
		 
		 if (m && m.length > 30)
			 m = m.substring(0, 30) + '...';
		 
		 if (this.dataBean.gtwayresponsereason)
		 {
			 if (!m)
				  m = this.dataBean.gtwayresponsereason;
			 else m = m + '<br />' + this.dataBean.gtwayresponsereason;	 
		 }
		 		 
		 return m;
	 }

});

