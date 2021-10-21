//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.appcrewmemberview");

org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewDTO(aDataBean));
	 },

	 isActive: function()
	 {
	     return this.dataBean && this.dataBean.recstatus == 'sys_recact';	 
	 },
	 
	 getCrewmemberrolecode: function()
	 {
		 return $.r3Utils.formatLUTDataBeanField('GET_classifier_r3ea_crewrole', this.dataBean.crewmemberrolecode);
	 },

	 getMemberstatuscode: function()
	 {
		 return $.r3Utils.formatLUTDataBeanField('GET_classifier_r3ea_crewstatus', this.dataBean.memberstatuscode);
	 },
	 	 
	 getCardnumberstatuscode: function()
	 {
		 return $.r3Utils.formatLUTDataBeanField('GET_classifier_fivcardstatus', this.dataBean.cardnumberstatuscode);
	 },
	 
	 isAnExistingCardNumber: function()
	 {
	   	if (this.dataBean && this.dataBean.cardnumberstatuscode && this.dataBean.cardnumberstatuscode != 'fiv_cn_unknown'  && this.dataBean.cardnumberstatuscode != 'fiv_cn_notexist')
	    	return true;
	    	
	    	return false;
	 },
	 
     getMemberInfo: function()
     {
    	 var s = '';
    	     		     	 
    	 if (this.isAnExistingCardNumber())
    	 {
    	     s = s + this.dataBean.cardholdername + ' ' + this.dataBean.cardholderlastname; 
    	     if (!$.r3Utils.stringContains(this.dataBean.crewmembername, this.dataBean.cardholdername) ||  !$.r3Utils.stringContains(this.dataBean.crewmembername, this.dataBean.cardholderlastname))
    	    	 s = s + "<br />(" + this.dataBean.crewmembername + ") ";
    	    	 		
    	     // s =  s + '<br />' + this.dataBean.yachtclub;
    	 }
    	 else
    	 {
    		 s += this.dataBean.crewmembername;
    	 }
    	 
    	 return s;
     },
     
     getCardnumberstatuscodeAsSemaphore: function()
     {
    	 var semaphoreColor = 'gray';
    	 switch(this.dataBean.cardnumberstatuscode)
    	 {
    	 case 'fiv_cn_valid': 
    		 semaphoreColor = 'green';
    		 break;

    	 case 'fiv_cn_expired':
    	 case 'fiv_cn_notexist': 
    		 semaphoreColor = 'red';
    		 break;

    	 }
    	 return $.r3Utils.formatSemaphore(semaphoreColor);
     },
     
     getRectimestamp: function()
     {
    	 return $.r3Utils.formatTimestampDataBeanField(this.dataBean.rectimestamp);
     },
     
     getMedexamexpirationdate: function()
     {
    	 return $.r3Utils.formatTimestampDataBeanField(this.dataBean.medexamexpirationdate, true);
     },
     
     getRenewaldate: function()
     {
    	 return $.r3Utils.formatTimestampDataBeanField(this.dataBean.renewaldate, true);
     },
     
     getSystemcheckdate: function()
     {
    	 return $.r3Utils.formatTimestampDataBeanField(this.dataBean.systemcheckdate);
     },
     
     getCheckcardnumber_ts: function()
     {
    	 return $.r3Utils.formatTimestampDataBeanField(this.dataBean.checkcardnumber_ts);
     },
     
     getCheckcardnumberAsSemaphore: function()
     {
    	 if (this.dataBean.checkcardnumber && this.dataBean.checkcardnumber == 'btrue')
    	       return $.r3Utils.deprecatedFormatSemaphore('redo');
    	 
    	 return null;
     },
     
     getNumcoviddocsAsSemaphore: function()
     {
    	 var semaphoreColor = 'gray';
    	 if (this.dataBean.numcoviddocs && this.dataBean.numcoviddocs > 0)
    	 {    	 
    		 semaphoreColor = 'green';
    	 }
    	 return $.r3Utils.formatSemaphore(semaphoreColor);
     }

});

