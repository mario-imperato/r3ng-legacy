//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.resourcetimesheet;

import java.util.ArrayList;
import java.util.List;

public class ResourceTimesheetFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public ResourceTimesheetFilter() 
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

    public ResourceTimesheetCriteria or() 
    {
        ResourceTimesheetCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public ResourceTimesheetCriteria createCriteria() 
    {
        ResourceTimesheetCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected ResourceTimesheetCriteria createCriteriaInternal() 
    {
        ResourceTimesheetCriteria criteria = new ResourceTimesheetCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class ResourceTimesheetCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public ResourceTimesheetCriteria andTsentryidIsNull() {
            addCriterion("tsentryid is null");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTsentryidIsNotNull() {
            addCriterion("tsentryid is not null");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTsentryidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("tsentryid =", value, "tsentryid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTsentryidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("tsentryid <>", value, "tsentryid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTsentryidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("tsentryid >", value, "tsentryid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTsentryidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("tsentryid >=", value, "tsentryid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTsentryidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("tsentryid <", value, "tsentryid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTsentryidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("tsentryid <=", value, "tsentryid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTsentryidLike(java.lang.String value) {
            if (value != null)
              addCriterion("tsentryid like ", value, "tsentryid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTsentryidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("tsentryid not like ", value, "tsentryid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTsentryidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("tsentryid in ", value, "tsentryid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTsentryidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("tsentryid not in ", value, "tsentryid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTsentryidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("tsentryid between ", value1, value2, "tsentryid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTsentryidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("tsentryid not between ", value1, value2, "tsentryid");
            return (ResourceTimesheetCriteria) this;
        }
        
        public ResourceTimesheetCriteria andCalevedayIsNull() {
            addCriterion("caleveday is null");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andCalevedayIsNotNull() {
            addCriterion("caleveday is not null");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andCalevedayEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveday =", value, "caleveday");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andCalevedayNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveday <>", value, "caleveday");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andCalevedayGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveday >", value, "caleveday");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andCalevedayGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveday >=", value, "caleveday");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andCalevedayLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveday <", value, "caleveday");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andCalevedayLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveday <=", value, "caleveday");
            return (ResourceTimesheetCriteria) this;
        }

        
        public ResourceTimesheetCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (ResourceTimesheetCriteria) this;
        }
        
        public ResourceTimesheetCriteria andTeamidIsNull() {
            addCriterion("teamid is null");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTeamidIsNotNull() {
            addCriterion("teamid is not null");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTeamidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamid =", value, "teamid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTeamidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamid <>", value, "teamid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTeamidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("teamid >", value, "teamid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTeamidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamid >=", value, "teamid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTeamidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("teamid <", value, "teamid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTeamidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamid <=", value, "teamid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTeamidLike(java.lang.String value) {
            if (value != null)
              addCriterion("teamid like ", value, "teamid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTeamidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("teamid not like ", value, "teamid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTeamidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("teamid in ", value, "teamid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTeamidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("teamid not in ", value, "teamid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTeamidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("teamid between ", value1, value2, "teamid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTeamidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("teamid not between ", value1, value2, "teamid");
            return (ResourceTimesheetCriteria) this;
        }
        
        public ResourceTimesheetCriteria andResourceidIsNull() {
            addCriterion("resourceid is null");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andResourceidIsNotNull() {
            addCriterion("resourceid is not null");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andResourceidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid =", value, "resourceid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andResourceidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid <>", value, "resourceid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andResourceidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid >", value, "resourceid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andResourceidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid >=", value, "resourceid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andResourceidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid <", value, "resourceid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andResourceidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid <=", value, "resourceid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andResourceidLike(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid like ", value, "resourceid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andResourceidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid not like ", value, "resourceid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andResourceidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("resourceid in ", value, "resourceid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andResourceidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("resourceid not in ", value, "resourceid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andResourceidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("resourceid between ", value1, value2, "resourceid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andResourceidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("resourceid not between ", value1, value2, "resourceid");
            return (ResourceTimesheetCriteria) this;
        }
        
        public ResourceTimesheetCriteria andUniteffortIsNull() {
            addCriterion("uniteffort is null");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andUniteffortIsNotNull() {
            addCriterion("uniteffort is not null");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andUniteffortEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort =", value, "uniteffort");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andUniteffortNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort <>", value, "uniteffort");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andUniteffortGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort >", value, "uniteffort");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andUniteffortGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort >=", value, "uniteffort");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andUniteffortLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort <", value, "uniteffort");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andUniteffortLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort <=", value, "uniteffort");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andUniteffortLike(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort like ", value, "uniteffort");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andUniteffortNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort not like ", value, "uniteffort");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andUniteffortIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("uniteffort in ", value, "uniteffort");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andUniteffortNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("uniteffort not in ", value, "uniteffort");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andUniteffortBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("uniteffort between ", value1, value2, "uniteffort");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andUniteffortNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("uniteffort not between ", value1, value2, "uniteffort");
            return (ResourceTimesheetCriteria) this;
        }
        
        public ResourceTimesheetCriteria andOrdeffortIsNull() {
            addCriterion("ordeffort is null");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andOrdeffortIsNotNull() {
            addCriterion("ordeffort is not null");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andOrdeffortEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("ordeffort =", value, "ordeffort");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andOrdeffortNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("ordeffort <>", value, "ordeffort");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andOrdeffortGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("ordeffort >", value, "ordeffort");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andOrdeffortGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("ordeffort >=", value, "ordeffort");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andOrdeffortLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("ordeffort <", value, "ordeffort");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andOrdeffortLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("ordeffort <=", value, "ordeffort");
            return (ResourceTimesheetCriteria) this;
        }

        
        public ResourceTimesheetCriteria andExteffortIsNull() {
            addCriterion("exteffort is null");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andExteffortIsNotNull() {
            addCriterion("exteffort is not null");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andExteffortEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("exteffort =", value, "exteffort");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andExteffortNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("exteffort <>", value, "exteffort");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andExteffortGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("exteffort >", value, "exteffort");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andExteffortGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("exteffort >=", value, "exteffort");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andExteffortLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("exteffort <", value, "exteffort");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andExteffortLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("exteffort <=", value, "exteffort");
            return (ResourceTimesheetCriteria) this;
        }

        
        public ResourceTimesheetCriteria andOncalleffortIsNull() {
            addCriterion("oncalleffort is null");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andOncalleffortIsNotNull() {
            addCriterion("oncalleffort is not null");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andOncalleffortEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("oncalleffort =", value, "oncalleffort");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andOncalleffortNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("oncalleffort <>", value, "oncalleffort");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andOncalleffortGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("oncalleffort >", value, "oncalleffort");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andOncalleffortGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("oncalleffort >=", value, "oncalleffort");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andOncalleffortLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("oncalleffort <", value, "oncalleffort");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andOncalleffortLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("oncalleffort <=", value, "oncalleffort");
            return (ResourceTimesheetCriteria) this;
        }

        
        public ResourceTimesheetCriteria andTseuseridIsNull() {
            addCriterion("tseuserid is null");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTseuseridIsNotNull() {
            addCriterion("tseuserid is not null");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTseuseridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("tseuserid =", value, "tseuserid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTseuseridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("tseuserid <>", value, "tseuserid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTseuseridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("tseuserid >", value, "tseuserid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTseuseridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("tseuserid >=", value, "tseuserid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTseuseridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("tseuserid <", value, "tseuserid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTseuseridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("tseuserid <=", value, "tseuserid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTseuseridLike(java.lang.String value) {
            if (value != null)
              addCriterion("tseuserid like ", value, "tseuserid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTseuseridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("tseuserid not like ", value, "tseuserid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTseuseridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("tseuserid in ", value, "tseuserid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTseuseridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("tseuserid not in ", value, "tseuserid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTseuseridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("tseuserid between ", value1, value2, "tseuserid");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andTseuseridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("tseuserid not between ", value1, value2, "tseuserid");
            return (ResourceTimesheetCriteria) this;
        }
        
        public ResourceTimesheetCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (ResourceTimesheetCriteria) this;
        }
        
        public ResourceTimesheetCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (ResourceTimesheetCriteria) this;
        }
        public ResourceTimesheetCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (ResourceTimesheetCriteria) this;
        }

    }
    
}

