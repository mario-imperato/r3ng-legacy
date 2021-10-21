//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.system.outmailspoolerrecipient");

org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDTO(aDataBean));
	 },
	 
	 getRecordStatusAsSemaphore: function()
	 {		 
		 var semaphoreColor = 'gray';

		 if (this.dataBean.recstatus && this.dataBean.recstatus == 'sys_recact')
			 semaphoreColor = 'gray';
		 		 
		 if (this.dataBean.recstatus && this.dataBean.recstatus == 'sys_recerr')
			 semaphoreColor = 'red';
		 
		 if (this.dataBean.recstatus && this.dataBean.recstatus == 'sys_recprocessed')
			 semaphoreColor = 'green';
		 
		 if (this.dataBean.recstatus && this.dataBean.recstatus == 'sys_recblock')
			 semaphoreColor = 'black';
		 
    	 return $.r3Utils.formatSemaphore(semaphoreColor);		    	 
	 }
	 
 
});

