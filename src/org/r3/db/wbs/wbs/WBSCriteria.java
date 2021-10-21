//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.wbs.wbs;

public class WBSCriteria extends WBSFilter.WBSCriteriaBase
{
	
	private static final String ASSIGNEE_EQUALTO = 
			"wbsid in (select wbsid from r3_wbsnode where site = '%s' and assignedto = '%s')";		

	public WBSCriteria andAssigneeEqualTo(String aSite, String anAssignee)
	{
		if (anAssignee != null)
		{
			String q = String.format(ASSIGNEE_EQUALTO, aSite, anAssignee);
			addCriterion(q);
		}
		
		return (WBSCriteria)this;
		
	}
}
