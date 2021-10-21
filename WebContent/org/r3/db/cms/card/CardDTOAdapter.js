//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.cms.card");

org.r3.db.cms.card.CardDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	 this._super(new org.r3.db.cms.card.CardDTO(aDataBean));
	 },
	 
	 isValidityRuleDate: function()
	 {
		 if (this.dataBean.validityrule && this.dataBean.validityrule == 'date')
			 return true;
		 
		 return false;
	 },
	 
	 isValidityRuleAlways: function()
	 {
		 if (this.dataBean.validityrule && this.dataBean.validityrule == 'always')
			 return true;
		 
		 return false;
	 },
	 
	 isValidityRuleNever: function()
	 {
		 if (this.dataBean.validityrule && this.dataBean.validityrule == 'never')
			 return true;
		 
		 return false;
	 },
	 
	 getValidityAsSemaphore: function()
	 {
		 var semaphoreColor = 'gray';

		 if (this.isValidityRuleAlways())
			 semaphoreColor = 'green';
		 
		 if (this.isValidityRuleNever())
			 semaphoreColor = 'red';
		 
		 if (this.isValidityRuleDate())
			 semaphoreColor = 'yellow';
		
    	 return $.r3Utils.formatSemaphore(semaphoreColor);		 
	 },
	 
	 getRefdate: function()
	 {
		return $.r3Utils.formatDataDataBeanField(this.dataBean.refdate);
	 },
	 
	 getValidfrom: function()
	 {
		return $.r3Utils.formatDataDataBeanField(this.dataBean.validfrom);
	 },

	 getValidto: function()
	 {
		return $.r3Utils.formatDataDataBeanField(this.dataBean.validto);
	 },
	 
	 getCategorydescr: function()
	 {
		 return $.r3Utils.formatLUTDataBeanField('LUT_CMS_Category', this.dataBean.categoryid);
	 },
	 
	 getCardgroupsAsCSV: function()
	 {
		 if (this.dataBean.groups && this.dataBean.groups.getNumberOfItems() > 0)
		 {
			 var csvResult = null;			 
			 var visitor = 
			 {				
				processItem: function(anItem)
				{
					
					 if (!csvResult)
						 csvResult = '';
					 else if (csvResult.length > 0)
				    	      csvResult = csvResult + ',';
				     
				     csvResult = csvResult + anItem.dataBean.groupid;
					
					return true;
				}
			 };
			 
			 this.dataBean.groups.visit(visitor);
			 return csvResult;
		 }
		 
		 return null;
	 },
	 
	 getCardgroupsAsArray: function()
	 {
		 if (this.dataBean.groups && this.dataBean.groups.getNumberOfItems() > 0)
		 {
			 var csvResult = [];			 
			 var visitor = 
			 {				
				processItem: function(anItem)
				{
				     csvResult.push(anItem.dataBean.groupid);					
					return true;
				}
			 };
			 
			 this.dataBean.groups.visit(visitor);
			 return csvResult;
		 }
		 
		 return null;
	 },
	 
	 getChannelsAsCSV: function()
	 {
		 if (this.dataBean.channels && this.dataBean.channels.getNumberOfItems() > 0)
		 {
			 var csvResult = null;			 
			 var visitor = 
			 {				
				processItem: function(anItem)
				{
					
					 if (!csvResult)
						 csvResult = '';
					 else if (csvResult.length > 0)
				    	      csvResult = csvResult + ',';
				     
				     csvResult = csvResult + anItem.dataBean.channelid;
					
					return true;
				}
			 };
			 
			 this.dataBean.channels.visit(visitor);
			 return csvResult;
		 }
		 
		 return null;
	 }
	  
});

