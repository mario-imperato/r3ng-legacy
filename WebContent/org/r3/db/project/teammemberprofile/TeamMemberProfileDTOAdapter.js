//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.project.teammemberprofile");

org.r3.db.project.teammemberprofile.TeamMemberProfileDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.project.teammemberprofile.TeamMemberProfileDTO(aDataBean));
	 },
	 
	 getSkillprofile: function()
	 {
		 return $.r3Utils.formatLUTDataBeanField('GET_classifier_skillprofile', this.dataBean.skillprofile);
	 },

	 getSkillambit: function()
	 {
		 return $.r3Utils.formatLUTDataBeanField('GET_classifier_skillambit', this.dataBean.skillambit);
	 },
	 
	 getProfiledescr: function()
	 {
		 var s = this.getSkillprofile() + " " + this.getSkillambit();
		 return s;
	 }
 
});

