/**
 * 
 */

jQuery.r3Utils.namespace("org.r3.db.wbs.wbsactor");

org.r3.db.wbs.wbsactor.WBSActorDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.wbs.wbsactor.WBSActorDTO(aDataBean));
	 },
	 
	 isManager: function(aWbsId)
	 {
		 return hasRole('manager', aWbsId);			 
	 },
	 
	 isCoach: function(aWbsId)
	 {
		 return hasRole('coach', aWbsId);			 
	 },
	 
	 isSponsor: function()
	 {
		 return hasRole('sponsor');			 
	 },
	 
	 isUser: function(aWbsId)
	 {
		 return hasRole('user', aWbsId);			 
	 },
	 
	 hasRole: function(aRole_or_arrayOfROles, aWbsId)
	 {
		 if (this.dataBean.actorrole && (!this.dataBean.wbsid || this.dataBean.wbsid == aWbsId))
		 {
			 if ($.isArray(aRole_or_arrayOfROles))
		   	 {
		   		 if (aRole_or_arrayOfROles.indexOf(this.dataBean.actorrole) >= 0) 
		   			 return true;
		   	 }
			 else
			 {
				 if (this.dataBean.actorrole == aRole_or_arrayOfROles)
					 return true;
			 }
		 }
		 
		 return false;
	 }

 
});