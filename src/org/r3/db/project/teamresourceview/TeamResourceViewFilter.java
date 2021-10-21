//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.teamresourceview;

import java.util.ArrayList;
import java.util.List;

public class TeamResourceViewFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public TeamResourceViewFilter() 
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

    public TeamResourceViewCriteria or() 
    {
        TeamResourceViewCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public TeamResourceViewCriteria createCriteria() 
    {
        TeamResourceViewCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected TeamResourceViewCriteria createCriteriaInternal() 
    {
        TeamResourceViewCriteria criteria = new TeamResourceViewCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class TeamResourceViewCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public TeamResourceViewCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (TeamResourceViewCriteria) this;
        }
        
        public TeamResourceViewCriteria andTeamidIsNull() {
            addCriterion("teamid is null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamidIsNotNull() {
            addCriterion("teamid is not null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamid =", value, "teamid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamid <>", value, "teamid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("teamid >", value, "teamid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamid >=", value, "teamid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("teamid <", value, "teamid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamid <=", value, "teamid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamidLike(java.lang.String value) {
            if (value != null)
              addCriterion("teamid like ", value, "teamid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("teamid not like ", value, "teamid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("teamid in ", value, "teamid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("teamid not in ", value, "teamid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("teamid between ", value1, value2, "teamid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("teamid not between ", value1, value2, "teamid");
            return (TeamResourceViewCriteria) this;
        }
        
        public TeamResourceViewCriteria andTeamdescrIsNull() {
            addCriterion("teamdescr is null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamdescrIsNotNull() {
            addCriterion("teamdescr is not null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamdescrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamdescr =", value, "teamdescr");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamdescrNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamdescr <>", value, "teamdescr");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamdescrGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("teamdescr >", value, "teamdescr");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamdescrGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamdescr >=", value, "teamdescr");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamdescrLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("teamdescr <", value, "teamdescr");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamdescrLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamdescr <=", value, "teamdescr");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamdescrLike(java.lang.String value) {
            if (value != null)
              addCriterion("teamdescr like ", value, "teamdescr");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamdescrNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("teamdescr not like ", value, "teamdescr");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamdescrIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("teamdescr in ", value, "teamdescr");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamdescrNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("teamdescr not in ", value, "teamdescr");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamdescrBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("teamdescr between ", value1, value2, "teamdescr");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamdescrNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("teamdescr not between ", value1, value2, "teamdescr");
            return (TeamResourceViewCriteria) this;
        }
        
        public TeamResourceViewCriteria andPeriodindexIsNull() {
            addCriterion("periodindex is null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPeriodindexIsNotNull() {
            addCriterion("periodindex is not null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPeriodindexEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodindex =", value, "periodindex");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPeriodindexNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodindex <>", value, "periodindex");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPeriodindexGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodindex >", value, "periodindex");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPeriodindexGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodindex >=", value, "periodindex");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPeriodindexLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodindex <", value, "periodindex");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPeriodindexLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodindex <=", value, "periodindex");
            return (TeamResourceViewCriteria) this;
        }

        
        public TeamResourceViewCriteria andPeriodtypeIsNull() {
            addCriterion("periodtype is null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPeriodtypeIsNotNull() {
            addCriterion("periodtype is not null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPeriodtypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("periodtype =", value, "periodtype");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPeriodtypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("periodtype <>", value, "periodtype");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPeriodtypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("periodtype >", value, "periodtype");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPeriodtypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("periodtype >=", value, "periodtype");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPeriodtypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("periodtype <", value, "periodtype");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPeriodtypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("periodtype <=", value, "periodtype");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPeriodtypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("periodtype like ", value, "periodtype");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPeriodtypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("periodtype not like ", value, "periodtype");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPeriodtypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("periodtype in ", value, "periodtype");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPeriodtypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("periodtype not in ", value, "periodtype");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPeriodtypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("periodtype between ", value1, value2, "periodtype");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPeriodtypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("periodtype not between ", value1, value2, "periodtype");
            return (TeamResourceViewCriteria) this;
        }
        
        public TeamResourceViewCriteria andTeamstatusIsNull() {
            addCriterion("teamstatus is null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamstatusIsNotNull() {
            addCriterion("teamstatus is not null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamstatus =", value, "teamstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamstatus <>", value, "teamstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("teamstatus >", value, "teamstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamstatus >=", value, "teamstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("teamstatus <", value, "teamstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamstatus <=", value, "teamstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("teamstatus like ", value, "teamstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("teamstatus not like ", value, "teamstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("teamstatus in ", value, "teamstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("teamstatus not in ", value, "teamstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("teamstatus between ", value1, value2, "teamstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andTeamstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("teamstatus not between ", value1, value2, "teamstatus");
            return (TeamResourceViewCriteria) this;
        }
        
        public TeamResourceViewCriteria andResourceidIsNull() {
            addCriterion("resourceid is null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourceidIsNotNull() {
            addCriterion("resourceid is not null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourceidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid =", value, "resourceid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourceidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid <>", value, "resourceid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourceidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid >", value, "resourceid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourceidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid >=", value, "resourceid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourceidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid <", value, "resourceid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourceidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid <=", value, "resourceid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourceidLike(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid like ", value, "resourceid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourceidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid not like ", value, "resourceid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourceidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("resourceid in ", value, "resourceid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourceidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("resourceid not in ", value, "resourceid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourceidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("resourceid between ", value1, value2, "resourceid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourceidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("resourceid not between ", value1, value2, "resourceid");
            return (TeamResourceViewCriteria) this;
        }
        
        public TeamResourceViewCriteria andResourcedescrIsNull() {
            addCriterion("resourcedescr is null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourcedescrIsNotNull() {
            addCriterion("resourcedescr is not null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourcedescrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedescr =", value, "resourcedescr");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourcedescrNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedescr <>", value, "resourcedescr");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourcedescrGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedescr >", value, "resourcedescr");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourcedescrGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedescr >=", value, "resourcedescr");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourcedescrLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedescr <", value, "resourcedescr");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourcedescrLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedescr <=", value, "resourcedescr");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourcedescrLike(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedescr like ", value, "resourcedescr");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourcedescrNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedescr not like ", value, "resourcedescr");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourcedescrIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("resourcedescr in ", value, "resourcedescr");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourcedescrNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("resourcedescr not in ", value, "resourcedescr");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourcedescrBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("resourcedescr between ", value1, value2, "resourcedescr");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourcedescrNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("resourcedescr not between ", value1, value2, "resourcedescr");
            return (TeamResourceViewCriteria) this;
        }
        
        public TeamResourceViewCriteria andProfileidIsNull() {
            addCriterion("profileid is null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andProfileidIsNotNull() {
            addCriterion("profileid is not null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andProfileidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid =", value, "profileid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andProfileidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid <>", value, "profileid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andProfileidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("profileid >", value, "profileid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andProfileidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid >=", value, "profileid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andProfileidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("profileid <", value, "profileid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andProfileidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid <=", value, "profileid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andProfileidLike(java.lang.String value) {
            if (value != null)
              addCriterion("profileid like ", value, "profileid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andProfileidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("profileid not like ", value, "profileid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andProfileidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("profileid in ", value, "profileid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andProfileidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("profileid not in ", value, "profileid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andProfileidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("profileid between ", value1, value2, "profileid");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andProfileidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("profileid not between ", value1, value2, "profileid");
            return (TeamResourceViewCriteria) this;
        }
        
        public TeamResourceViewCriteria andEvalueunitIsNull() {
            addCriterion("evalueunit is null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andEvalueunitIsNotNull() {
            addCriterion("evalueunit is not null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andEvalueunitEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit =", value, "evalueunit");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andEvalueunitNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit <>", value, "evalueunit");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andEvalueunitGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit >", value, "evalueunit");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andEvalueunitGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit >=", value, "evalueunit");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andEvalueunitLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit <", value, "evalueunit");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andEvalueunitLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit <=", value, "evalueunit");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andEvalueunitLike(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit like ", value, "evalueunit");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andEvalueunitNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit not like ", value, "evalueunit");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andEvalueunitIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("evalueunit in ", value, "evalueunit");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andEvalueunitNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("evalueunit not in ", value, "evalueunit");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andEvalueunitBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("evalueunit between ", value1, value2, "evalueunit");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andEvalueunitNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("evalueunit not between ", value1, value2, "evalueunit");
            return (TeamResourceViewCriteria) this;
        }
        
        public TeamResourceViewCriteria andPriceIsNull() {
            addCriterion("price is null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPriceEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("price =", value, "price");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPriceNotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("price <>", value, "price");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPriceGreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("price >", value, "price");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPriceGreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("price >=", value, "price");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPriceLessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("price <", value, "price");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andPriceLessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("price <=", value, "price");
            return (TeamResourceViewCriteria) this;
        }

        
        public TeamResourceViewCriteria andCostIsNull() {
            addCriterion("cost is null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andCostIsNotNull() {
            addCriterion("cost is not null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andCostEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("cost =", value, "cost");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andCostNotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("cost <>", value, "cost");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andCostGreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("cost >", value, "cost");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andCostGreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("cost >=", value, "cost");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andCostLessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("cost <", value, "cost");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andCostLessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("cost <=", value, "cost");
            return (TeamResourceViewCriteria) this;
        }

        
        public TeamResourceViewCriteria andResourcedefstatusIsNull() {
            addCriterion("resourcedefstatus is null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourcedefstatusIsNotNull() {
            addCriterion("resourcedefstatus is not null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourcedefstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedefstatus =", value, "resourcedefstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourcedefstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedefstatus <>", value, "resourcedefstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourcedefstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedefstatus >", value, "resourcedefstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourcedefstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedefstatus >=", value, "resourcedefstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourcedefstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedefstatus <", value, "resourcedefstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourcedefstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedefstatus <=", value, "resourcedefstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourcedefstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedefstatus like ", value, "resourcedefstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourcedefstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedefstatus not like ", value, "resourcedefstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourcedefstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("resourcedefstatus in ", value, "resourcedefstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourcedefstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("resourcedefstatus not in ", value, "resourcedefstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourcedefstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("resourcedefstatus between ", value1, value2, "resourcedefstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andResourcedefstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("resourcedefstatus not between ", value1, value2, "resourcedefstatus");
            return (TeamResourceViewCriteria) this;
        }
        
        public TeamResourceViewCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (TeamResourceViewCriteria) this;
        }
        public TeamResourceViewCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (TeamResourceViewCriteria) this;
        }
    }
    
}

