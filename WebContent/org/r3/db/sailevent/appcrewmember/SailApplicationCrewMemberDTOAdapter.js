//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.appcrewmember");

org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTO(aDataBean));
	 },
	 
	 getCrewmemberrolecode: function()
	 {
		 return $.r3Utils.formatLUTDataBeanField('GET_classifier_r3ea_crewrole', this.dataBean.crewmemberrolecode);
	 },
	 
	 getMemberstatuscode: function()
	 {
		 return $.r3Utils.formatLUTDataBeanField('GET_classifier_r3ea_crewstatus', this.dataBean.memberstatuscode);
	 }
 
});

