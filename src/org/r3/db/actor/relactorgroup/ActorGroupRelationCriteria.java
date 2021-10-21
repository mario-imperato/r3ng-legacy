//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.actor.relactorgroup;
import org.r3.db.actor.group.ActorGroupDTO.GroupNature;

public class ActorGroupRelationCriteria extends ActorGroupRelationFilter.ActorGroupRelationCriteriaBase{

	public ActorGroupRelationCriteria andGroupnatureEqualTo(GroupNature aGroupNature)
	{
		addSubSelectCriterion("groupid in (select groupid from r3_actorgroup where groupnature = ", aGroupNature.toString(), ")", "groupid");
		return (ActorGroupRelationCriteria) this;
		
	}

	public ActorGroupRelationCriteria andGrouptypeEqualTo(String aGroupType)
	{
		addSubSelectCriterion("groupid in (select groupid from r3_actorgroup where grouptype = ", aGroupType, ")", "groupid");
		return (ActorGroupRelationCriteria) this;		
	}
}
