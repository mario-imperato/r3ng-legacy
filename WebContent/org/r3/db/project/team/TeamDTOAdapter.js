//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.project.team");

org.r3.db.project.team.TeamDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.project.team.TeamDTO(aDataBean));
	 },
	 
	 isOpen4Reporting: function()
	 {
		 return this.dataBean.teamstatus && this.dataBean.teamstatus == 'team_reporting';
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
	 
	 canBeModified: function()
	 {
		 var rc = false;
		 
		 switch(this.dataBean.teamstatus)
		 {
		 case 'team_empty':
			 rc = true;
			 break;
			 
		 case 'team_building':
			 rc = true;
			 break;
			 
		 case 'team_verifying':
			 if (org.r3.PageManager.userInfo.isInRole(org.r3.Constants.site, 'srvcauditor'))
				 rc = true;
			 break;
			 
		 case 'team_reporting':			
			 break;
			 
		 case 'team_validating': 
			 break;
			 
		 case 'team_close':
			 break;		 
		 }
		 
		 return rc;
	 },

	 getOnCompleteOKTask_InReportingTask: function()
	 {
		 if (this.dataBean.teamstatus == 'team_reporting' || this.dataBean.teamstatus == 'team_validating')
		 {
		      return this.getOnCompleteOKTask();	 
		 }
		 
		 return null;
	 },
	 
	 getOnCompleteOKTask: function()
	 {
		 var task = null;
		 switch(this.dataBean.teamstatus)
		 {
		 case 'team_empty':
			 break;
			 
		 case 'team_building':
			 if (org.r3.PageManager.userInfo.isInRole(org.r3.Constants.site, 'srvcmgr'))
			       task = 'team_verifying';
			 break;
			 
		 case 'team_verifying':
			 if (org.r3.PageManager.userInfo.isInRole(org.r3.Constants.site, 'srvcauditor'))
				 task = 'team_reporting';
			 break;
			 
		 case 'team_reporting':
			 if (org.r3.PageManager.userInfo.isInRole(org.r3.Constants.site, 'srvcmgr') || org.r3.PageManager.userInfo.isInRole(org.r3.Constants.site, 'srvcauditor'))
				 task = 'team_validating';
			 break;
			 
		 case 'team_validating':
			 if (org.r3.PageManager.userInfo.isInRole(org.r3.Constants.site, 'srvcauditor'))
				 task = 'team_close';			 
			 break;
			 
		 case 'team_close':
			 break;		 
		 }
		 
		 return task;
	 },

	 getOnCompleteKOTask_InReportingTask: function()
	 {
		 if (this.dataBean.teamstatus == 'team_reporting' || this.dataBean.teamstatus == 'team_validating')
		 {
		      return this.getOnCompleteKOTask();	 
		 }
		 
		 return null;
	 },

	 getOnCompleteKOTask: function()
	 {
		 var task = null;
		 switch(this.dataBean.teamstatus)
		 {
		 case 'team_empty':
			 break;
			 
		 case 'team_building':			
			 break;
			 
		 case 'team_verifying':
			 if (org.r3.PageManager.userInfo.isInRole(org.r3.Constants.site, 'srvcauditor'))
				 task = 'team_building';
			 break;
			 
		 case 'team_reporting':
			 if (org.r3.PageManager.userInfo.isInRole(org.r3.Constants.site, 'srvcauditor'))
				 task = 'team_building';
			 break;
			 
		 case 'team_validating':
			 if (org.r3.PageManager.userInfo.isInRole(org.r3.Constants.site, 'srvcauditor'))
				 task = 'team_reporting';			 
			 break;
			 
		 case 'team_close':
			 break;		 
		 }
		 
		 return task;
	 }

 
});

