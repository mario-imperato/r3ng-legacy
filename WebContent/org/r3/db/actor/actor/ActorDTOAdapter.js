//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.actor.actor");

org.r3.db.actor.actor.ActorDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.actor.actor.ActorDTO(aDataBean));
	 },

	 getSystemgroupsDescr: function()	 
	 {
		 if (this.dataBean.groups && this.dataBean.groups.getNumberOfItems() > 0)
		 {
			 var textResult = null;			 
			 var visitor = 
			 {				
				processItem: function(anItem)
				{
					if (anItem.dataBean.groupnature == 'system')
					{
						 if (!textResult)
							 textResult = '';
						 else if (textResult.length > 0)
					    	      textResult = textResult + '<br />';
					     
					     textResult = textResult + anItem.dataBean.grouptitle;
					}
					
					return true;
				}
			 };
			 
			 this.dataBean.groups.visit(visitor);
			 return textResult;
		 }
		 
		 return null;		 
	 },
	 
	 getNONSystemgroupsAsCSV: function()
	 {
		 if (this.dataBean.groups && this.dataBean.groups.getNumberOfItems() > 0)
		 {
			 var csvResult = null;			 
			 var visitor = 
			 {				
				processItem: function(anItem)
				{
					if (anItem.dataBean.groupnature == 'user' || anItem.dataBean.groupnature == 'app')
					{
						 if (!csvResult)
							 csvResult = '';
						 else if (csvResult.length > 0)
					    	      csvResult = csvResult + ',';
					     
					     csvResult = csvResult + anItem.dataBean.groupid;
					}
					
					return true;
				}
			 };
			 
			 this.dataBean.groups.visit(visitor);
			 return csvResult;
		 }
		 
		 return null;
	 },
	 
	 isLocked: function()
	 {
		 return this.dataBean.recstatus && this.dataBean.recstatus == 'sys_recblock';
	 }
 
});

