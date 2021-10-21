//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.group;

public class GroupCriteria extends GroupFilter.GroupCriteriaBase{

	public GroupCriteria andCardidEqualTo(String aSite, String aCardid)
	{
		addSubSelectCriterion("groupid in (select groupid from r3_cmscardgroup where site = '" + aSite + "' and cardid = ", aCardid, ")", "groupid");		
		return (GroupCriteria)this;
	}
}
