//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.project.wbsnodeteammemberprofileview");

org.r3.db.project.wbsnodeteammemberprofileview.WBSNodeTeamMemberProfileViewDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.project.wbsnodeteammemberprofileview.WBSNodeTeamMemberProfileViewDTO(aDataBean));
	 }
 
});

