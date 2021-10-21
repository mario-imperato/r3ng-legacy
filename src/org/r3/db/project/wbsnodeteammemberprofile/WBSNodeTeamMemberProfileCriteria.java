//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.wbsnodeteammemberprofile;


public class WBSNodeTeamMemberProfileCriteria extends WBSNodeTeamMemberProfileFilter.WBSNodeTeamMemberProfileCriteriaBase
{
	private static final String BELONGS_2_WBSID = "wbsnodeid in (select wbsnodeid from r3_wbsnode where site = '%s' and wbsid = '%s')";

	public WBSNodeTeamMemberProfileCriteria andWbsidEqualTo(String aSite, String aWbsId) 
	{
		if (aWbsId != null)
		{
			String q = String.format(BELONGS_2_WBSID, aSite, aWbsId);
			addCriterion(q);
		}

		return (WBSNodeTeamMemberProfileCriteria) this;

	}
	
}
