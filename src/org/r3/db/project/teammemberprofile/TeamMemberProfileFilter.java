//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.teammemberprofile;

import java.util.ArrayList;
import java.util.List;

public class TeamMemberProfileFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public TeamMemberProfileFilter() 
    {
        oredCriteria = new ArrayList<org.r3.db.utils.Criteria>();
        limitFetch = 0;
    }
    
    public void setOrderByClause(String orderByClause) 
    {
        this.orderByClause = orderByClause;
    }
    
    public String getOrderByClause() 
    {
        return orderByClause;
    }

    public int getLimitFetch()
  	{
		   return limitFetch;
	  }

	  public void setLimitFetch(int limitFetch)
	  {
		  this.limitFetch = limitFetch;
	  }

    public void setDistinct(boolean distinct) 
    {
        this.distinct = distinct;
    }

    public boolean isDistinct() 
    {
        return distinct;
    }

    public List<org.r3.db.utils.Criteria> getOredCriteria() 
    {
        return oredCriteria;
    }

    public void or(org.r3.db.utils.Criteria criteria) 
    {
        oredCriteria.add(criteria);
    }

    public TeamMemberProfileCriteria or() 
    {
        TeamMemberProfileCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public TeamMemberProfileCriteria createCriteria() 
    {
        TeamMemberProfileCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected TeamMemberProfileCriteria createCriteriaInternal() 
    {
        TeamMemberProfileCriteria criteria = new TeamMemberProfileCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class TeamMemberProfileCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public TeamMemberProfileCriteria andProfileidIsNull() {
            addCriterion("profileid is null");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andProfileidIsNotNull() {
            addCriterion("profileid is not null");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andProfileidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid =", value, "profileid");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andProfileidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid <>", value, "profileid");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andProfileidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("profileid >", value, "profileid");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andProfileidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid >=", value, "profileid");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andProfileidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("profileid <", value, "profileid");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andProfileidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid <=", value, "profileid");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andProfileidLike(java.lang.String value) {
            if (value != null)
              addCriterion("profileid like ", value, "profileid");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andProfileidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("profileid not like ", value, "profileid");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andProfileidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("profileid in ", value, "profileid");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andProfileidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("profileid not in ", value, "profileid");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andProfileidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("profileid between ", value1, value2, "profileid");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andProfileidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("profileid not between ", value1, value2, "profileid");
            return (TeamMemberProfileCriteria) this;
        }
        
        public TeamMemberProfileCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (TeamMemberProfileCriteria) this;
        }
        
        public TeamMemberProfileCriteria andTeamidIsNull() {
            addCriterion("teamid is null");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andTeamidIsNotNull() {
            addCriterion("teamid is not null");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andTeamidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamid =", value, "teamid");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andTeamidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamid <>", value, "teamid");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andTeamidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("teamid >", value, "teamid");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andTeamidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamid >=", value, "teamid");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andTeamidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("teamid <", value, "teamid");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andTeamidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamid <=", value, "teamid");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andTeamidLike(java.lang.String value) {
            if (value != null)
              addCriterion("teamid like ", value, "teamid");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andTeamidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("teamid not like ", value, "teamid");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andTeamidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("teamid in ", value, "teamid");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andTeamidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("teamid not in ", value, "teamid");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andTeamidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("teamid between ", value1, value2, "teamid");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andTeamidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("teamid not between ", value1, value2, "teamid");
            return (TeamMemberProfileCriteria) this;
        }
        
        public TeamMemberProfileCriteria andProfiledescrIsNull() {
            addCriterion("profiledescr is null");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andProfiledescrIsNotNull() {
            addCriterion("profiledescr is not null");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andProfiledescrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profiledescr =", value, "profiledescr");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andProfiledescrNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profiledescr <>", value, "profiledescr");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andProfiledescrGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("profiledescr >", value, "profiledescr");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andProfiledescrGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profiledescr >=", value, "profiledescr");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andProfiledescrLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("profiledescr <", value, "profiledescr");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andProfiledescrLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profiledescr <=", value, "profiledescr");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andProfiledescrLike(java.lang.String value) {
            if (value != null)
              addCriterion("profiledescr like ", value, "profiledescr");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andProfiledescrNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("profiledescr not like ", value, "profiledescr");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andProfiledescrIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("profiledescr in ", value, "profiledescr");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andProfiledescrNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("profiledescr not in ", value, "profiledescr");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andProfiledescrBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("profiledescr between ", value1, value2, "profiledescr");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andProfiledescrNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("profiledescr not between ", value1, value2, "profiledescr");
            return (TeamMemberProfileCriteria) this;
        }
        
        public TeamMemberProfileCriteria andSkillprofileIsNull() {
            addCriterion("skillprofile is null");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSkillprofileIsNotNull() {
            addCriterion("skillprofile is not null");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSkillprofileEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("skillprofile =", value, "skillprofile");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSkillprofileNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("skillprofile <>", value, "skillprofile");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSkillprofileGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("skillprofile >", value, "skillprofile");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSkillprofileGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("skillprofile >=", value, "skillprofile");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSkillprofileLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("skillprofile <", value, "skillprofile");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSkillprofileLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("skillprofile <=", value, "skillprofile");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSkillprofileLike(java.lang.String value) {
            if (value != null)
              addCriterion("skillprofile like ", value, "skillprofile");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSkillprofileNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("skillprofile not like ", value, "skillprofile");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSkillprofileIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("skillprofile in ", value, "skillprofile");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSkillprofileNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("skillprofile not in ", value, "skillprofile");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSkillprofileBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("skillprofile between ", value1, value2, "skillprofile");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSkillprofileNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("skillprofile not between ", value1, value2, "skillprofile");
            return (TeamMemberProfileCriteria) this;
        }
        
        public TeamMemberProfileCriteria andSkillambitIsNull() {
            addCriterion("skillambit is null");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSkillambitIsNotNull() {
            addCriterion("skillambit is not null");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSkillambitEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("skillambit =", value, "skillambit");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSkillambitNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("skillambit <>", value, "skillambit");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSkillambitGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("skillambit >", value, "skillambit");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSkillambitGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("skillambit >=", value, "skillambit");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSkillambitLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("skillambit <", value, "skillambit");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSkillambitLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("skillambit <=", value, "skillambit");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSkillambitLike(java.lang.String value) {
            if (value != null)
              addCriterion("skillambit like ", value, "skillambit");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSkillambitNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("skillambit not like ", value, "skillambit");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSkillambitIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("skillambit in ", value, "skillambit");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSkillambitNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("skillambit not in ", value, "skillambit");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSkillambitBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("skillambit between ", value1, value2, "skillambit");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andSkillambitNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("skillambit not between ", value1, value2, "skillambit");
            return (TeamMemberProfileCriteria) this;
        }
        
        public TeamMemberProfileCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (TeamMemberProfileCriteria) this;
        }
        
        public TeamMemberProfileCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (TeamMemberProfileCriteria) this;
        }
        public TeamMemberProfileCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (TeamMemberProfileCriteria) this;
        }

    }
    
}

