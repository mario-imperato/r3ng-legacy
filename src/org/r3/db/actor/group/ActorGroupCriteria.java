//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.actor.group;

public class ActorGroupCriteria extends ActorGroupFilter.ActorGroupCriteriaBase{

	public ActorGroupCriteria andActoridEqualTo(String aSite, String actorId)
	{
		addSubSelectCriterion("groupid in (select groupid from r3_relactorgroup where eventid = '" + aSite + "' and actorid = ", actorId, ")", "groupid");
		return (ActorGroupCriteria) this;
		
	}
}
