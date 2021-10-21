//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.actor.actor;

import org.r3.db.utils.SQLStringUtils;
import org.r3.db.utils.SQLStringUtils.LikeMode;

public class ActorCriteria extends ActorFilter.ActorCriteriaBase{

	public ActorCriteria andActorInGroup(String aSite, String groupid)
	{
		addSubSelectCriterion("actorid in (select actorid from r3_relactorgroup where eventid = '" + aSite + "' and groupid = ", groupid, ")", "actorid");		
		return (ActorCriteria)this;
		
	}

	public ActorCriteria andActorNotInGroup(String aSite, String groupid)
	{
		addSubSelectCriterion("actorid not in (select actorid from r3_relactorgroup where eventid = '" + aSite + "' and groupid = ", groupid, ")", "actorid");		
		return (ActorCriteria)this;				
	}

	private static final String NAME_OR_EMAIL_LIKE = 
			"(firstname like '%%%s' or lastname like '%%%s' or email like '%%%s')";	
	
	public ActorCriteria andMailOrNameLike(String s)
	{
		if (s != null && s.length() > 0)
		{
			s = SQLStringUtils.escapeSingleQuotes(s);
		    s = SQLStringUtils.getStringForLikeMode(s, LikeMode.FullLike);		
		    addCriterion(String.format(NAME_OR_EMAIL_LIKE, s, s, s));
		}
		
		return (ActorCriteria)this;				
	}
	
	public ActorCriteria andActorInGroup(String aSite, String[] listOfGroups)
	{
		if (listOfGroups == null || listOfGroups.length == 0)
			return (ActorCriteria)this;			
		
		StringBuilder  stb = new StringBuilder();
		
		boolean isEmpty = true;
		for(String s : listOfGroups)
		{
			if (!isEmpty)
				stb.append(",");
			
			isEmpty = false;
			stb.append("'").append(s).append("'");
		}
		
		addCriterion("actorid in (select actorid from r3_relactorgroup where eventid = '" + aSite + "' and groupid in (" + stb.toString() + "))");		
		return (ActorCriteria)this;						
	}
}
