//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.user.user;

public class UserCriteria extends UserFilter.UserCriteriaBase
{
	private static final String USER_IN_ACTOR_GROUP = 
		"userid in (select userid from r3_actor a left join r3_relactorgroup r on a.eventid = r.eventid and a.actorid = r.actorid where a.eventid = '%s' and r.groupid = '%s')";		

	public UserCriteria andUserInActorGroup(String aSite, String aGroupid)
	{
		String q = String.format(USER_IN_ACTOR_GROUP, aSite, aGroupid);
		addCriterion(q);
		
		return (UserCriteria)this;
		
	}

	private static final String LOGINCONTACT_MISSING = 
			"userid not in (select userid from r3_actor where eventid = '%s' and userid is not null)";		

	private static final String LOGINCONTACT_PRESENT = 
			"userid in (select userid from r3_actor where eventid = '%s' and userid is not null)";	
	
	private static final String HASROLE = 
			"userid in (select userid from r3_userrole where site = '%s' and roleid = '%s')";	
	
	public UserCriteria andHasNotLogincontact(String aSite)
	{
   		String q = String.format(LOGINCONTACT_MISSING, aSite);
   		addCriterion(q);        		 

 		return (UserCriteria)this;         
	}

	public UserCriteria andHasLogincontact(String aSite)
	{
   		String q = String.format(LOGINCONTACT_PRESENT, aSite);
   		addCriterion(q);        		 

 		return (UserCriteria)this;         
	}

	
	public UserCriteria andUserHasRole(String targetSite, String aRoleId)
	{
		String q = String.format(HASROLE, targetSite, aRoleId);
   		addCriterion(q);        		 

 		return (UserCriteria)this;        		
	}

}
