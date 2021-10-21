//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.project.teamresourceview");

org.r3.db.project.teamresourceview.TeamResourceViewDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.project.teamresourceview.TeamResourceViewDTO(aDataBean));
	 },
	 
	 getResourcedefstatusAsSemaphore: function()
	 {
		 var semaphoreColor = 'gray';

		 switch(this.dataBean.resourcedefstatus)
		 {
		 case 'complete':		
			 semaphoreColor = 'green';
			 break;
			 
		 case 'incomplete':
			 semaphoreColor = 'red';
			 break;			 		
		 }
		
    	 return $.r3Utils.formatSemaphore(semaphoreColor);		 
	 },
	 
	 getTeamstatusAsSemaphore: function()
	 {
		 var semaphoreColor = 'gray';

		 switch(this.dataBean.teamstatus)
		 {
		 case 'team_empty':			 
			 break;
			 
		 case 'team_building':
			 semaphoreColor = 'green';
			 break;
			 
		 case 'team_verifying':
			 semaphoreColor = 'orange';
			 break;
			 
		 case 'team_reporting':
			 semaphoreColor = 'red';				
			 break;
			 
		 case 'team_validating': 
			 semaphoreColor = 'blue';				
			 break;
			 
		 case 'team_close':
			 semaphoreColor = 'black';							
			 break;		 
		 }
		
    	 return $.r3Utils.formatSemaphore(semaphoreColor);		 
	 },
	 
	 getProfileDescr: function()
	 {
		 return $.r3Utils.formatLUTDataBeanField('GET_TeamMemberProfiles', this.dataBean.profileid);
	 }
 
});

