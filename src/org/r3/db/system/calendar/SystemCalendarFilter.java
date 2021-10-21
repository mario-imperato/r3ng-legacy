//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.calendar;

import java.util.ArrayList;
import java.util.List;

public class SystemCalendarFilter{
    protected String orderByClause;
    protected String  groupByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public SystemCalendarFilter() 
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

    public SystemCalendarCriteria or() 
    {
        SystemCalendarCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public SystemCalendarCriteria createCriteria() 
    {
        SystemCalendarCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected SystemCalendarCriteria createCriteriaInternal() 
    {
        SystemCalendarCriteria criteria = new SystemCalendarCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class SystemCalendarCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public SystemCalendarCriteria andSitedomainIsNull() {
            addCriterion("sitedomain is null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andSitedomainIsNotNull() {
            addCriterion("sitedomain is not null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andSitedomainEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sitedomain =", value, "sitedomain");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andSitedomainNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sitedomain <>", value, "sitedomain");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andSitedomainGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("sitedomain >", value, "sitedomain");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andSitedomainGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sitedomain >=", value, "sitedomain");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andSitedomainLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("sitedomain <", value, "sitedomain");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andSitedomainLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sitedomain <=", value, "sitedomain");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andSitedomainLike(java.lang.String value) {
            if (value != null)
              addCriterion("sitedomain like ", value, "sitedomain");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andSitedomainNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("sitedomain not like ", value, "sitedomain");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andSitedomainIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("sitedomain in ", value, "sitedomain");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andSitedomainNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("sitedomain not in ", value, "sitedomain");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andSitedomainBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("sitedomain between ", value1, value2, "sitedomain");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andSitedomainNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("sitedomain not between ", value1, value2, "sitedomain");
            return (SystemCalendarCriteria) this;
        }
        
        public SystemCalendarCriteria andCalendaridIsNull() {
            addCriterion("calendarid is null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalendaridIsNotNull() {
            addCriterion("calendarid is not null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalendaridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("calendarid =", value, "calendarid");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalendaridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("calendarid <>", value, "calendarid");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalendaridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("calendarid >", value, "calendarid");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalendaridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("calendarid >=", value, "calendarid");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalendaridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("calendarid <", value, "calendarid");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalendaridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("calendarid <=", value, "calendarid");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalendaridLike(java.lang.String value) {
            if (value != null)
              addCriterion("calendarid like ", value, "calendarid");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalendaridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("calendarid not like ", value, "calendarid");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalendaridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("calendarid in ", value, "calendarid");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalendaridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("calendarid not in ", value, "calendarid");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalendaridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("calendarid between ", value1, value2, "calendarid");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalendaridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("calendarid not between ", value1, value2, "calendarid");
            return (SystemCalendarCriteria) this;
        }
        
        public SystemCalendarCriteria andCaldateIsNull() {
            addCriterion("caldate is null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaldateIsNotNull() {
            addCriterion("caldate is not null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaldateEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("caldate =", value, "caldate");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaldateNotEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("caldate <>", value, "caldate");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaldateGreaterThan(java.sql.Date value) {
            if (value != null)
              addCriterion("caldate >", value, "caldate");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaldateGreaterThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("caldate >=", value, "caldate");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaldateLessThan(java.sql.Date value) {
            if (value != null)
              addCriterion("caldate <", value, "caldate");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaldateLessThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("caldate <=", value, "caldate");
            return (SystemCalendarCriteria) this;
        }

        
        public SystemCalendarCriteria andCalevedayIsNull() {
            addCriterion("caleveday is null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalevedayIsNotNull() {
            addCriterion("caleveday is not null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalevedayEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveday =", value, "caleveday");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalevedayNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveday <>", value, "caleveday");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalevedayGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveday >", value, "caleveday");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalevedayGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveday >=", value, "caleveday");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalevedayLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveday <", value, "caleveday");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalevedayLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveday <=", value, "caleveday");
            return (SystemCalendarCriteria) this;
        }

        
        public SystemCalendarCriteria andCaleveworkdayIsNull() {
            addCriterion("caleveworkday is null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaleveworkdayIsNotNull() {
            addCriterion("caleveworkday is not null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaleveworkdayEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveworkday =", value, "caleveworkday");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaleveworkdayNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveworkday <>", value, "caleveworkday");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaleveworkdayGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveworkday >", value, "caleveworkday");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaleveworkdayGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveworkday >=", value, "caleveworkday");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaleveworkdayLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveworkday <", value, "caleveworkday");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaleveworkdayLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveworkday <=", value, "caleveworkday");
            return (SystemCalendarCriteria) this;
        }

        
        public SystemCalendarCriteria andCaldayIsNull() {
            addCriterion("calday is null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaldayIsNotNull() {
            addCriterion("calday is not null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaldayEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calday =", value, "calday");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaldayNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calday <>", value, "calday");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaldayGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("calday >", value, "calday");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaldayGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calday >=", value, "calday");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaldayLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("calday <", value, "calday");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaldayLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calday <=", value, "calday");
            return (SystemCalendarCriteria) this;
        }

        
        public SystemCalendarCriteria andCalmonthIsNull() {
            addCriterion("calmonth is null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalmonthIsNotNull() {
            addCriterion("calmonth is not null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalmonthEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calmonth =", value, "calmonth");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalmonthNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calmonth <>", value, "calmonth");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalmonthGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("calmonth >", value, "calmonth");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalmonthGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calmonth >=", value, "calmonth");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalmonthLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("calmonth <", value, "calmonth");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalmonthLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calmonth <=", value, "calmonth");
            return (SystemCalendarCriteria) this;
        }

        
        public SystemCalendarCriteria andCalyearIsNull() {
            addCriterion("calyear is null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalyearIsNotNull() {
            addCriterion("calyear is not null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalyearEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calyear =", value, "calyear");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalyearNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calyear <>", value, "calyear");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalyearGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("calyear >", value, "calyear");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalyearGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calyear >=", value, "calyear");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalyearLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("calyear <", value, "calyear");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalyearLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calyear <=", value, "calyear");
            return (SystemCalendarCriteria) this;
        }

        
        public SystemCalendarCriteria andCalweekIsNull() {
            addCriterion("calweek is null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalweekIsNotNull() {
            addCriterion("calweek is not null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalweekEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calweek =", value, "calweek");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalweekNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calweek <>", value, "calweek");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalweekGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("calweek >", value, "calweek");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalweekGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calweek >=", value, "calweek");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalweekLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("calweek <", value, "calweek");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalweekLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calweek <=", value, "calweek");
            return (SystemCalendarCriteria) this;
        }

        
        public SystemCalendarCriteria andCalquarterIsNull() {
            addCriterion("calquarter is null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalquarterIsNotNull() {
            addCriterion("calquarter is not null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalquarterEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calquarter =", value, "calquarter");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalquarterNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calquarter <>", value, "calquarter");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalquarterGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("calquarter >", value, "calquarter");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalquarterGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calquarter >=", value, "calquarter");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalquarterLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("calquarter <", value, "calquarter");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalquarterLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calquarter <=", value, "calquarter");
            return (SystemCalendarCriteria) this;
        }

        
        public SystemCalendarCriteria andCalydayIsNull() {
            addCriterion("calyday is null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalydayIsNotNull() {
            addCriterion("calyday is not null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalydayEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calyday =", value, "calyday");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalydayNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calyday <>", value, "calyday");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalydayGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("calyday >", value, "calyday");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalydayGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calyday >=", value, "calyday");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalydayLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("calyday <", value, "calyday");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalydayLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calyday <=", value, "calyday");
            return (SystemCalendarCriteria) this;
        }

        
        public SystemCalendarCriteria andCalwdayIsNull() {
            addCriterion("calwday is null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalwdayIsNotNull() {
            addCriterion("calwday is not null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalwdayEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calwday =", value, "calwday");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalwdayNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calwday <>", value, "calwday");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalwdayGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("calwday >", value, "calwday");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalwdayGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calwday >=", value, "calwday");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalwdayLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("calwday <", value, "calwday");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalwdayLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calwday <=", value, "calwday");
            return (SystemCalendarCriteria) this;
        }

        
        public SystemCalendarCriteria andCalevemonthIsNull() {
            addCriterion("calevemonth is null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalevemonthIsNotNull() {
            addCriterion("calevemonth is not null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalevemonthEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calevemonth =", value, "calevemonth");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalevemonthNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calevemonth <>", value, "calevemonth");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalevemonthGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("calevemonth >", value, "calevemonth");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalevemonthGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calevemonth >=", value, "calevemonth");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalevemonthLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("calevemonth <", value, "calevemonth");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalevemonthLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calevemonth <=", value, "calevemonth");
            return (SystemCalendarCriteria) this;
        }

        
        public SystemCalendarCriteria andCaleveweekIsNull() {
            addCriterion("caleveweek is null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaleveweekIsNotNull() {
            addCriterion("caleveweek is not null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaleveweekEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveweek =", value, "caleveweek");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaleveweekNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveweek <>", value, "caleveweek");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaleveweekGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveweek >", value, "caleveweek");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaleveweekGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveweek >=", value, "caleveweek");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaleveweekLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveweek <", value, "caleveweek");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaleveweekLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveweek <=", value, "caleveweek");
            return (SystemCalendarCriteria) this;
        }

        
        public SystemCalendarCriteria andCalevequarterIsNull() {
            addCriterion("calevequarter is null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalevequarterIsNotNull() {
            addCriterion("calevequarter is not null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalevequarterEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calevequarter =", value, "calevequarter");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalevequarterNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calevequarter <>", value, "calevequarter");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalevequarterGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("calevequarter >", value, "calevequarter");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalevequarterGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calevequarter >=", value, "calevequarter");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalevequarterLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("calevequarter <", value, "calevequarter");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalevequarterLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("calevequarter <=", value, "calevequarter");
            return (SystemCalendarCriteria) this;
        }

        
        public SystemCalendarCriteria andCaleveyearIsNull() {
            addCriterion("caleveyear is null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaleveyearIsNotNull() {
            addCriterion("caleveyear is not null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaleveyearEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveyear =", value, "caleveyear");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaleveyearNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveyear <>", value, "caleveyear");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaleveyearGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveyear >", value, "caleveyear");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaleveyearGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveyear >=", value, "caleveyear");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaleveyearLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveyear <", value, "caleveyear");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCaleveyearLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("caleveyear <=", value, "caleveyear");
            return (SystemCalendarCriteria) this;
        }

        
        public SystemCalendarCriteria andCalentrytypeIsNull() {
            addCriterion("calentrytype is null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalentrytypeIsNotNull() {
            addCriterion("calentrytype is not null");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalentrytypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("calentrytype =", value, "calentrytype");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalentrytypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("calentrytype <>", value, "calentrytype");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalentrytypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("calentrytype >", value, "calentrytype");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalentrytypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("calentrytype >=", value, "calentrytype");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalentrytypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("calentrytype <", value, "calentrytype");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalentrytypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("calentrytype <=", value, "calentrytype");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalentrytypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("calentrytype like ", value, "calentrytype");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalentrytypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("calentrytype not like ", value, "calentrytype");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalentrytypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("calentrytype in ", value, "calentrytype");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalentrytypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("calentrytype not in ", value, "calentrytype");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalentrytypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("calentrytype between ", value1, value2, "calentrytype");
            return (SystemCalendarCriteria) this;
        }
        public SystemCalendarCriteria andCalentrytypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("calentrytype not between ", value1, value2, "calentrytype");
            return (SystemCalendarCriteria) this;
        }
    }
    
}

