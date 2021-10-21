//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.resourcetimesheetview;

import java.util.ArrayList;
import java.util.List;

public class ResourceTimesheetViewFilter{
    protected String orderByClause;
    protected String  groupByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public ResourceTimesheetViewFilter() 
    {
        oredCriteria = new ArrayList<org.r3.db.utils.Criteria>();
        limitFetch = 0;
        groupByClause = null;
    }
    
    public String getGroupByClause()
	  {
	  	return groupByClause;
	  }
    
	  public void setGroupByClause(String groupByClause)
	  {
	  	this.groupByClause = groupByClause;
	  }
	
	  public boolean isGroupBy(String aColumnName)
	  {
	  	return groupByClause != null && groupByClause.indexOf(aColumnName) >= 0;
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

    public ResourceTimesheetViewCriteria or() 
    {
        ResourceTimesheetViewCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public ResourceTimesheetViewCriteria createCriteria() 
    {
        ResourceTimesheetViewCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected ResourceTimesheetViewCriteria createCriteriaInternal() 
    {
        ResourceTimesheetViewCriteria criteria = new ResourceTimesheetViewCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class ResourceTimesheetViewCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public ResourceTimesheetViewCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (ResourceTimesheetViewCriteria) this;
        }
        
        public ResourceTimesheetViewCriteria andTsentryidIsNull() {
            addCriterion("tsentryid is null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTsentryidIsNotNull() {
            addCriterion("tsentryid is not null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTsentryidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("tsentryid =", value, "tsentryid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTsentryidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("tsentryid <>", value, "tsentryid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTsentryidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("tsentryid >", value, "tsentryid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTsentryidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("tsentryid >=", value, "tsentryid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTsentryidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("tsentryid <", value, "tsentryid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTsentryidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("tsentryid <=", value, "tsentryid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTsentryidLike(java.lang.String value) {
            if (value != null)
              addCriterion("tsentryid like ", value, "tsentryid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTsentryidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("tsentryid not like ", value, "tsentryid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTsentryidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("tsentryid in ", value, "tsentryid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTsentryidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("tsentryid not in ", value, "tsentryid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTsentryidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("tsentryid between ", value1, value2, "tsentryid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTsentryidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("tsentryid not between ", value1, value2, "tsentryid");
            return (ResourceTimesheetViewCriteria) this;
        }
        
        public ResourceTimesheetViewCriteria andSitedomainIsNull() {
            addCriterion("sitedomain is null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andSitedomainIsNotNull() {
            addCriterion("sitedomain is not null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andSitedomainEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sitedomain =", value, "sitedomain");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andSitedomainNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sitedomain <>", value, "sitedomain");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andSitedomainGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("sitedomain >", value, "sitedomain");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andSitedomainGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sitedomain >=", value, "sitedomain");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andSitedomainLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("sitedomain <", value, "sitedomain");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andSitedomainLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sitedomain <=", value, "sitedomain");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andSitedomainLike(java.lang.String value) {
            if (value != null)
              addCriterion("sitedomain like ", value, "sitedomain");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andSitedomainNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("sitedomain not like ", value, "sitedomain");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andSitedomainIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("sitedomain in ", value, "sitedomain");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andSitedomainNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("sitedomain not in ", value, "sitedomain");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andSitedomainBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("sitedomain between ", value1, value2, "sitedomain");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andSitedomainNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("sitedomain not between ", value1, value2, "sitedomain");
            return (ResourceTimesheetViewCriteria) this;
        }
        
        public ResourceTimesheetViewCriteria andResourceidIsNull() {
            addCriterion("resourceid is null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andResourceidIsNotNull() {
            addCriterion("resourceid is not null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andResourceidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid =", value, "resourceid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andResourceidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid <>", value, "resourceid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andResourceidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid >", value, "resourceid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andResourceidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid >=", value, "resourceid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andResourceidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid <", value, "resourceid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andResourceidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid <=", value, "resourceid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andResourceidLike(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid like ", value, "resourceid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andResourceidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid not like ", value, "resourceid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andResourceidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("resourceid in ", value, "resourceid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andResourceidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("resourceid not in ", value, "resourceid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andResourceidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("resourceid between ", value1, value2, "resourceid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andResourceidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("resourceid not between ", value1, value2, "resourceid");
            return (ResourceTimesheetViewCriteria) this;
        }
        
        public ResourceTimesheetViewCriteria andResourcedescrIsNull() {
            addCriterion("resourcedescr is null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andResourcedescrIsNotNull() {
            addCriterion("resourcedescr is not null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andResourcedescrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedescr =", value, "resourcedescr");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andResourcedescrNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedescr <>", value, "resourcedescr");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andResourcedescrGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedescr >", value, "resourcedescr");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andResourcedescrGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedescr >=", value, "resourcedescr");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andResourcedescrLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedescr <", value, "resourcedescr");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andResourcedescrLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedescr <=", value, "resourcedescr");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andResourcedescrLike(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedescr like ", value, "resourcedescr");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andResourcedescrNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedescr not like ", value, "resourcedescr");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andResourcedescrIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("resourcedescr in ", value, "resourcedescr");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andResourcedescrNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("resourcedescr not in ", value, "resourcedescr");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andResourcedescrBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("resourcedescr between ", value1, value2, "resourcedescr");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andResourcedescrNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("resourcedescr not between ", value1, value2, "resourcedescr");
            return (ResourceTimesheetViewCriteria) this;
        }
        
        public ResourceTimesheetViewCriteria andTeamidIsNull() {
            addCriterion("teamid is null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTeamidIsNotNull() {
            addCriterion("teamid is not null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTeamidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamid =", value, "teamid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTeamidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamid <>", value, "teamid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTeamidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("teamid >", value, "teamid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTeamidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamid >=", value, "teamid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTeamidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("teamid <", value, "teamid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTeamidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamid <=", value, "teamid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTeamidLike(java.lang.String value) {
            if (value != null)
              addCriterion("teamid like ", value, "teamid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTeamidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("teamid not like ", value, "teamid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTeamidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("teamid in ", value, "teamid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTeamidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("teamid not in ", value, "teamid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTeamidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("teamid between ", value1, value2, "teamid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTeamidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("teamid not between ", value1, value2, "teamid");
            return (ResourceTimesheetViewCriteria) this;
        }
        
        public ResourceTimesheetViewCriteria andTeamperiodIsNull() {
            addCriterion("teamperiod is null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTeamperiodIsNotNull() {
            addCriterion("teamperiod is not null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTeamperiodEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("teamperiod =", value, "teamperiod");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTeamperiodNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("teamperiod <>", value, "teamperiod");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTeamperiodGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("teamperiod >", value, "teamperiod");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTeamperiodGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("teamperiod >=", value, "teamperiod");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTeamperiodLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("teamperiod <", value, "teamperiod");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTeamperiodLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("teamperiod <=", value, "teamperiod");
            return (ResourceTimesheetViewCriteria) this;
        }

        
        public ResourceTimesheetViewCriteria andProfileidIsNull() {
            addCriterion("profileid is null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andProfileidIsNotNull() {
            addCriterion("profileid is not null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andProfileidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid =", value, "profileid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andProfileidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid <>", value, "profileid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andProfileidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("profileid >", value, "profileid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andProfileidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid >=", value, "profileid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andProfileidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("profileid <", value, "profileid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andProfileidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid <=", value, "profileid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andProfileidLike(java.lang.String value) {
            if (value != null)
              addCriterion("profileid like ", value, "profileid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andProfileidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("profileid not like ", value, "profileid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andProfileidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("profileid in ", value, "profileid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andProfileidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("profileid not in ", value, "profileid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andProfileidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("profileid between ", value1, value2, "profileid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andProfileidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("profileid not between ", value1, value2, "profileid");
            return (ResourceTimesheetViewCriteria) this;
        }
        
        public ResourceTimesheetViewCriteria andCompanyidIsNull() {
            addCriterion("companyid is null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCompanyidIsNotNull() {
            addCriterion("companyid is not null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCompanyidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("companyid =", value, "companyid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCompanyidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("companyid <>", value, "companyid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCompanyidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("companyid >", value, "companyid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCompanyidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("companyid >=", value, "companyid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCompanyidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("companyid <", value, "companyid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCompanyidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("companyid <=", value, "companyid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCompanyidLike(java.lang.String value) {
            if (value != null)
              addCriterion("companyid like ", value, "companyid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCompanyidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("companyid not like ", value, "companyid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCompanyidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("companyid in ", value, "companyid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCompanyidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("companyid not in ", value, "companyid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCompanyidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("companyid between ", value1, value2, "companyid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCompanyidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("companyid not between ", value1, value2, "companyid");
            return (ResourceTimesheetViewCriteria) this;
        }
        
        public ResourceTimesheetViewCriteria andCostcenter1IsNull() {
            addCriterion("costcenter1 is null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter1IsNotNull() {
            addCriterion("costcenter1 is not null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter1EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("costcenter1 =", value, "costcenter1");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter1NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("costcenter1 <>", value, "costcenter1");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter1GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("costcenter1 >", value, "costcenter1");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter1GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("costcenter1 >=", value, "costcenter1");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter1LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("costcenter1 <", value, "costcenter1");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter1LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("costcenter1 <=", value, "costcenter1");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter1Like(java.lang.String value) {
            if (value != null)
              addCriterion("costcenter1 like ", value, "costcenter1");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter1NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("costcenter1 not like ", value, "costcenter1");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter1In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("costcenter1 in ", value, "costcenter1");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter1NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("costcenter1 not in ", value, "costcenter1");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter1Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("costcenter1 between ", value1, value2, "costcenter1");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter1NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("costcenter1 not between ", value1, value2, "costcenter1");
            return (ResourceTimesheetViewCriteria) this;
        }
        
        public ResourceTimesheetViewCriteria andCostcenter2IsNull() {
            addCriterion("costcenter2 is null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter2IsNotNull() {
            addCriterion("costcenter2 is not null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter2EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("costcenter2 =", value, "costcenter2");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter2NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("costcenter2 <>", value, "costcenter2");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter2GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("costcenter2 >", value, "costcenter2");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter2GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("costcenter2 >=", value, "costcenter2");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter2LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("costcenter2 <", value, "costcenter2");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter2LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("costcenter2 <=", value, "costcenter2");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter2Like(java.lang.String value) {
            if (value != null)
              addCriterion("costcenter2 like ", value, "costcenter2");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter2NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("costcenter2 not like ", value, "costcenter2");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter2In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("costcenter2 in ", value, "costcenter2");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter2NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("costcenter2 not in ", value, "costcenter2");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter2Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("costcenter2 between ", value1, value2, "costcenter2");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter2NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("costcenter2 not between ", value1, value2, "costcenter2");
            return (ResourceTimesheetViewCriteria) this;
        }
        
        public ResourceTimesheetViewCriteria andCostcenter3IsNull() {
            addCriterion("costcenter3 is null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter3IsNotNull() {
            addCriterion("costcenter3 is not null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter3EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("costcenter3 =", value, "costcenter3");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter3NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("costcenter3 <>", value, "costcenter3");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter3GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("costcenter3 >", value, "costcenter3");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter3GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("costcenter3 >=", value, "costcenter3");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter3LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("costcenter3 <", value, "costcenter3");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter3LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("costcenter3 <=", value, "costcenter3");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter3Like(java.lang.String value) {
            if (value != null)
              addCriterion("costcenter3 like ", value, "costcenter3");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter3NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("costcenter3 not like ", value, "costcenter3");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter3In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("costcenter3 in ", value, "costcenter3");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter3NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("costcenter3 not in ", value, "costcenter3");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter3Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("costcenter3 between ", value1, value2, "costcenter3");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostcenter3NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("costcenter3 not between ", value1, value2, "costcenter3");
            return (ResourceTimesheetViewCriteria) this;
        }
        
        public ResourceTimesheetViewCriteria andUniteffortIsNull() {
            addCriterion("uniteffort is null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andUniteffortIsNotNull() {
            addCriterion("uniteffort is not null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andUniteffortEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort =", value, "uniteffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andUniteffortNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort <>", value, "uniteffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andUniteffortGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort >", value, "uniteffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andUniteffortGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort >=", value, "uniteffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andUniteffortLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort <", value, "uniteffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andUniteffortLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort <=", value, "uniteffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andUniteffortLike(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort like ", value, "uniteffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andUniteffortNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort not like ", value, "uniteffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andUniteffortIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("uniteffort in ", value, "uniteffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andUniteffortNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("uniteffort not in ", value, "uniteffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andUniteffortBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("uniteffort between ", value1, value2, "uniteffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andUniteffortNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("uniteffort not between ", value1, value2, "uniteffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        
        public ResourceTimesheetViewCriteria andOrdeffortIsNull() {
            addCriterion("ordeffort is null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andOrdeffortIsNotNull() {
            addCriterion("ordeffort is not null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andOrdeffortEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("ordeffort =", value, "ordeffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andOrdeffortNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("ordeffort <>", value, "ordeffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andOrdeffortGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("ordeffort >", value, "ordeffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andOrdeffortGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("ordeffort >=", value, "ordeffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andOrdeffortLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("ordeffort <", value, "ordeffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andOrdeffortLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("ordeffort <=", value, "ordeffort");
            return (ResourceTimesheetViewCriteria) this;
        }

        
        public ResourceTimesheetViewCriteria andExteffortIsNull() {
            addCriterion("exteffort is null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andExteffortIsNotNull() {
            addCriterion("exteffort is not null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andExteffortEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("exteffort =", value, "exteffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andExteffortNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("exteffort <>", value, "exteffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andExteffortGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("exteffort >", value, "exteffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andExteffortGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("exteffort >=", value, "exteffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andExteffortLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("exteffort <", value, "exteffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andExteffortLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("exteffort <=", value, "exteffort");
            return (ResourceTimesheetViewCriteria) this;
        }

        
        public ResourceTimesheetViewCriteria andOncalleffortIsNull() {
            addCriterion("oncalleffort is null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andOncalleffortIsNotNull() {
            addCriterion("oncalleffort is not null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andOncalleffortEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("oncalleffort =", value, "oncalleffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andOncalleffortNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("oncalleffort <>", value, "oncalleffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andOncalleffortGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("oncalleffort >", value, "oncalleffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andOncalleffortGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("oncalleffort >=", value, "oncalleffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andOncalleffortLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("oncalleffort <", value, "oncalleffort");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andOncalleffortLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("oncalleffort <=", value, "oncalleffort");
            return (ResourceTimesheetViewCriteria) this;
        }

        
        public ResourceTimesheetViewCriteria andPriceIsNull() {
            addCriterion("price is null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andPriceEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("price =", value, "price");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andPriceNotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("price <>", value, "price");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andPriceGreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("price >", value, "price");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andPriceGreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("price >=", value, "price");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andPriceLessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("price <", value, "price");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andPriceLessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("price <=", value, "price");
            return (ResourceTimesheetViewCriteria) this;
        }

        
        public ResourceTimesheetViewCriteria andCostIsNull() {
            addCriterion("cost is null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostIsNotNull() {
            addCriterion("cost is not null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("cost =", value, "cost");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostNotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("cost <>", value, "cost");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostGreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("cost >", value, "cost");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostGreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("cost >=", value, "cost");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostLessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("cost <", value, "cost");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCostLessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("cost <=", value, "cost");
            return (ResourceTimesheetViewCriteria) this;
        }

        
        public ResourceTimesheetViewCriteria andEvalueunitIsNull() {
            addCriterion("evalueunit is null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andEvalueunitIsNotNull() {
            addCriterion("evalueunit is not null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andEvalueunitEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit =", value, "evalueunit");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andEvalueunitNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit <>", value, "evalueunit");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andEvalueunitGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit >", value, "evalueunit");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andEvalueunitGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit >=", value, "evalueunit");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andEvalueunitLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit <", value, "evalueunit");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andEvalueunitLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit <=", value, "evalueunit");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andEvalueunitLike(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit like ", value, "evalueunit");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andEvalueunitNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit not like ", value, "evalueunit");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andEvalueunitIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("evalueunit in ", value, "evalueunit");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andEvalueunitNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("evalueunit not in ", value, "evalueunit");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andEvalueunitBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("evalueunit between ", value1, value2, "evalueunit");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andEvalueunitNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("evalueunit not between ", value1, value2, "evalueunit");
            return (ResourceTimesheetViewCriteria) this;
        }
        
        public ResourceTimesheetViewCriteria andCaldateIsNull() {
            addCriterion("caldate is null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCaldateIsNotNull() {
            addCriterion("caldate is not null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCaldateEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("caldate =", value, "caldate");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCaldateNotEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("caldate <>", value, "caldate");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCaldateGreaterThan(java.sql.Date value) {
            if (value != null)
              addCriterion("caldate >", value, "caldate");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCaldateGreaterThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("caldate >=", value, "caldate");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCaldateLessThan(java.sql.Date value) {
            if (value != null)
              addCriterion("caldate <", value, "caldate");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCaldateLessThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("caldate <=", value, "caldate");
            return (ResourceTimesheetViewCriteria) this;
        }

        
        public ResourceTimesheetViewCriteria andCalevedayIsNull() {
            addCriterion("caleveday is null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCalevedayIsNotNull() {
            addCriterion("caleveday is not null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCalevedayEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveday =", value, "caleveday");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCalevedayNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveday <>", value, "caleveday");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCalevedayGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveday >", value, "caleveday");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCalevedayGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveday >=", value, "caleveday");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCalevedayLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveday <", value, "caleveday");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCalevedayLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveday <=", value, "caleveday");
            return (ResourceTimesheetViewCriteria) this;
        }

        
        public ResourceTimesheetViewCriteria andCalevemonthIsNull() {
            addCriterion("calevemonth is null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCalevemonthIsNotNull() {
            addCriterion("calevemonth is not null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCalevemonthEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calevemonth =", value, "calevemonth");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCalevemonthNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calevemonth <>", value, "calevemonth");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCalevemonthGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("calevemonth >", value, "calevemonth");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCalevemonthGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calevemonth >=", value, "calevemonth");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCalevemonthLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("calevemonth <", value, "calevemonth");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCalevemonthLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calevemonth <=", value, "calevemonth");
            return (ResourceTimesheetViewCriteria) this;
        }

        
        public ResourceTimesheetViewCriteria andCaleveweekIsNull() {
            addCriterion("caleveweek is null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCaleveweekIsNotNull() {
            addCriterion("caleveweek is not null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCaleveweekEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveweek =", value, "caleveweek");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCaleveweekNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveweek <>", value, "caleveweek");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCaleveweekGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveweek >", value, "caleveweek");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCaleveweekGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveweek >=", value, "caleveweek");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCaleveweekLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveweek <", value, "caleveweek");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCaleveweekLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveweek <=", value, "caleveweek");
            return (ResourceTimesheetViewCriteria) this;
        }

        
        public ResourceTimesheetViewCriteria andCalevequarterIsNull() {
            addCriterion("calevequarter is null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCalevequarterIsNotNull() {
            addCriterion("calevequarter is not null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCalevequarterEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calevequarter =", value, "calevequarter");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCalevequarterNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calevequarter <>", value, "calevequarter");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCalevequarterGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("calevequarter >", value, "calevequarter");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCalevequarterGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calevequarter >=", value, "calevequarter");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCalevequarterLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("calevequarter <", value, "calevequarter");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCalevequarterLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calevequarter <=", value, "calevequarter");
            return (ResourceTimesheetViewCriteria) this;
        }

        
        public ResourceTimesheetViewCriteria andCaleveyearIsNull() {
            addCriterion("caleveyear is null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCaleveyearIsNotNull() {
            addCriterion("caleveyear is not null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCaleveyearEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveyear =", value, "caleveyear");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCaleveyearNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveyear <>", value, "caleveyear");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCaleveyearGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveyear >", value, "caleveyear");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCaleveyearGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveyear >=", value, "caleveyear");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCaleveyearLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveyear <", value, "caleveyear");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andCaleveyearLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveyear <=", value, "caleveyear");
            return (ResourceTimesheetViewCriteria) this;
        }

        
        public ResourceTimesheetViewCriteria andTseuseridIsNull() {
            addCriterion("tseuserid is null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTseuseridIsNotNull() {
            addCriterion("tseuserid is not null");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTseuseridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("tseuserid =", value, "tseuserid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTseuseridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("tseuserid <>", value, "tseuserid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTseuseridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("tseuserid >", value, "tseuserid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTseuseridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("tseuserid >=", value, "tseuserid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTseuseridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("tseuserid <", value, "tseuserid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTseuseridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("tseuserid <=", value, "tseuserid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTseuseridLike(java.lang.String value) {
            if (value != null)
              addCriterion("tseuserid like ", value, "tseuserid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTseuseridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("tseuserid not like ", value, "tseuserid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTseuseridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("tseuserid in ", value, "tseuserid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTseuseridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("tseuserid not in ", value, "tseuserid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTseuseridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("tseuserid between ", value1, value2, "tseuserid");
            return (ResourceTimesheetViewCriteria) this;
        }
        public ResourceTimesheetViewCriteria andTseuseridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("tseuserid not between ", value1, value2, "tseuserid");
            return (ResourceTimesheetViewCriteria) this;
        }
    }
    
}

