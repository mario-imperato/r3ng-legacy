//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.appcrewmemberview");

org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewSummaryDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewSummaryDTO(aDataBean));
	 },
	 
	 getCrewSize: function()
	 {
	       return this.dataBean.crewSize || '0';	 
	 },
	 
	 getCrewValid: function()
	 {
		 return this.dataBean.crewValid || '0';
	 },
	 
	 getCrewExpired: function()
	 {
		 return this.dataBean.crewExpired || '0';
	 },
	 
	 getCrewError: function()
	 {
		 return this.dataBean.crewError || '0';
	 },
	 
	 getCrewUnknown: function()
	 {
		 return this.dataBean.crewUnknown || '0';
	 },
	 
	 getCrewDeleted: function()
	 {
		 return this.dataBean.crewDeleted || '0'; 
	 },
	 
	 _getCrewStatus: function()
	 {
    	 var status = 'NK';
    	 if (!this.dataBean.crewSize ||  this.dataBean.crewExpired || this.dataBean.crewError)
    		 status = 'KO';
    	 else if (this.dataBean.crewSize && this.dataBean.crewValid && this.dataBean.crewSize == this.dataBean.crewValid)
    		 status = 'OK';
		 
    	 return status;
	 },
	 
	 getCrewStatus: function()
     {
    	 var t = 'Da verif.';
    	 switch(this._getCrewStatus())
    	 {
    	 case 'KO': 
    		 t = "NON Valida";
    		 break;
    	 case 'KN': 
    		 break;
    	 case 'OK': 
    		 t = "OK";
    		 break;
    	 }

    	 return t;
     },
	 
     getCrewStatusAsSemaphore: function()
     {
    	 var semaphoreColor = 'gray';
    	 switch(this._getCrewStatus())
    	 {
    	 case 'KO': 
    		 semaphoreColor = "red";
    		 break;
    	 case 'NK': 
    		 break;
    	 case 'OK': 
    		 semaphoreColor = "green";
    		 break;
    	 }
    	 
    	 return $.r3Utils.formatSemaphore(semaphoreColor);
     },
     
     getCrewStatusAsTableContextualClass: function()
     {
    	 var bootstrapContextualClass = '';
    	 switch(this._getCrewStatus())
    	 {
    	 case 'KO': 
    		 bootstrapContextualClass = "danger";
    		 break;
    	 case 'NK': 
    		 break;
    	 case 'OK': 
    		 bootstrapContextualClass = "success";
    		 break;
    	 }
    	 
    	 return bootstrapContextualClass;
     }     


});

