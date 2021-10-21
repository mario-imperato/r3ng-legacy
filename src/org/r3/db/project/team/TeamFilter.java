//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.team;

import java.util.ArrayList;
import java.util.List;

public class TeamFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public TeamFilter() 
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

    public TeamCriteria or() 
    {
        TeamCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public TeamCriteria createCriteria() 
    {
        TeamCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected TeamCriteria createCriteriaInternal() 
    {
        TeamCriteria criteria = new TeamCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class TeamCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public TeamCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (TeamCriteria) this;
        }
        public TeamCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (TeamCriteria) this;
        }
        public TeamCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (TeamCriteria) this;
        }
        public TeamCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (TeamCriteria) this;
        }
        public TeamCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (TeamCriteria) this;
        }
        public TeamCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (TeamCriteria) this;
        }
        public TeamCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (TeamCriteria) this;
        }
        public TeamCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (TeamCriteria) this;
        }
        public TeamCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (TeamCriteria) this;
        }
        public TeamCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (TeamCriteria) this;
        }
        public TeamCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (TeamCriteria) this;
        }
        public TeamCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (TeamCriteria) this;
        }
        public TeamCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (TeamCriteria) this;
        }
        public TeamCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (TeamCriteria) this;
        }
        
        public TeamCriteria andTeamidIsNull() {
            addCriterion("teamid is null");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamidIsNotNull() {
            addCriterion("teamid is not null");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamid =", value, "teamid");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamid <>", value, "teamid");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("teamid >", value, "teamid");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamid >=", value, "teamid");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("teamid <", value, "teamid");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamid <=", value, "teamid");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamidLike(java.lang.String value) {
            if (value != null)
              addCriterion("teamid like ", value, "teamid");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("teamid not like ", value, "teamid");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("teamid in ", value, "teamid");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("teamid not in ", value, "teamid");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("teamid between ", value1, value2, "teamid");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("teamid not between ", value1, value2, "teamid");
            return (TeamCriteria) this;
        }
        
        public TeamCriteria andTeamdescrIsNull() {
            addCriterion("teamdescr is null");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamdescrIsNotNull() {
            addCriterion("teamdescr is not null");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamdescrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamdescr =", value, "teamdescr");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamdescrNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamdescr <>", value, "teamdescr");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamdescrGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("teamdescr >", value, "teamdescr");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamdescrGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamdescr >=", value, "teamdescr");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamdescrLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("teamdescr <", value, "teamdescr");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamdescrLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamdescr <=", value, "teamdescr");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamdescrLike(java.lang.String value) {
            if (value != null)
              addCriterion("teamdescr like ", value, "teamdescr");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamdescrNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("teamdescr not like ", value, "teamdescr");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamdescrIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("teamdescr in ", value, "teamdescr");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamdescrNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("teamdescr not in ", value, "teamdescr");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamdescrBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("teamdescr between ", value1, value2, "teamdescr");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamdescrNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("teamdescr not between ", value1, value2, "teamdescr");
            return (TeamCriteria) this;
        }
        
        public TeamCriteria andPeriodindexIsNull() {
            addCriterion("periodindex is null");
            return (TeamCriteria) this;
        }
        public TeamCriteria andPeriodindexIsNotNull() {
            addCriterion("periodindex is not null");
            return (TeamCriteria) this;
        }
        public TeamCriteria andPeriodindexEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodindex =", value, "periodindex");
            return (TeamCriteria) this;
        }
        public TeamCriteria andPeriodindexNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodindex <>", value, "periodindex");
            return (TeamCriteria) this;
        }
        public TeamCriteria andPeriodindexGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodindex >", value, "periodindex");
            return (TeamCriteria) this;
        }
        public TeamCriteria andPeriodindexGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodindex >=", value, "periodindex");
            return (TeamCriteria) this;
        }
        public TeamCriteria andPeriodindexLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodindex <", value, "periodindex");
            return (TeamCriteria) this;
        }
        public TeamCriteria andPeriodindexLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodindex <=", value, "periodindex");
            return (TeamCriteria) this;
        }

        
        public TeamCriteria andPeriodtypeIsNull() {
            addCriterion("periodtype is null");
            return (TeamCriteria) this;
        }
        public TeamCriteria andPeriodtypeIsNotNull() {
            addCriterion("periodtype is not null");
            return (TeamCriteria) this;
        }
        public TeamCriteria andPeriodtypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("periodtype =", value, "periodtype");
            return (TeamCriteria) this;
        }
        public TeamCriteria andPeriodtypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("periodtype <>", value, "periodtype");
            return (TeamCriteria) this;
        }
        public TeamCriteria andPeriodtypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("periodtype >", value, "periodtype");
            return (TeamCriteria) this;
        }
        public TeamCriteria andPeriodtypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("periodtype >=", value, "periodtype");
            return (TeamCriteria) this;
        }
        public TeamCriteria andPeriodtypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("periodtype <", value, "periodtype");
            return (TeamCriteria) this;
        }
        public TeamCriteria andPeriodtypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("periodtype <=", value, "periodtype");
            return (TeamCriteria) this;
        }
        public TeamCriteria andPeriodtypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("periodtype like ", value, "periodtype");
            return (TeamCriteria) this;
        }
        public TeamCriteria andPeriodtypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("periodtype not like ", value, "periodtype");
            return (TeamCriteria) this;
        }
        public TeamCriteria andPeriodtypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("periodtype in ", value, "periodtype");
            return (TeamCriteria) this;
        }
        public TeamCriteria andPeriodtypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("periodtype not in ", value, "periodtype");
            return (TeamCriteria) this;
        }
        public TeamCriteria andPeriodtypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("periodtype between ", value1, value2, "periodtype");
            return (TeamCriteria) this;
        }
        public TeamCriteria andPeriodtypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("periodtype not between ", value1, value2, "periodtype");
            return (TeamCriteria) this;
        }
        
        public TeamCriteria andTeamstatusIsNull() {
            addCriterion("teamstatus is null");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamstatusIsNotNull() {
            addCriterion("teamstatus is not null");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamstatus =", value, "teamstatus");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamstatus <>", value, "teamstatus");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("teamstatus >", value, "teamstatus");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamstatus >=", value, "teamstatus");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("teamstatus <", value, "teamstatus");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamstatus <=", value, "teamstatus");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("teamstatus like ", value, "teamstatus");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("teamstatus not like ", value, "teamstatus");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("teamstatus in ", value, "teamstatus");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("teamstatus not in ", value, "teamstatus");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("teamstatus between ", value1, value2, "teamstatus");
            return (TeamCriteria) this;
        }
        public TeamCriteria andTeamstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("teamstatus not between ", value1, value2, "teamstatus");
            return (TeamCriteria) this;
        }
    }
    
}

