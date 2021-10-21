//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.calendarperiod;

import java.util.ArrayList;
import java.util.List;

public class SystemCalendarPeriodFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public SystemCalendarPeriodFilter() 
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

    public SystemCalendarPeriodCriteria or() 
    {
        SystemCalendarPeriodCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public SystemCalendarPeriodCriteria createCriteria() 
    {
        SystemCalendarPeriodCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected SystemCalendarPeriodCriteria createCriteriaInternal() 
    {
        SystemCalendarPeriodCriteria criteria = new SystemCalendarPeriodCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class SystemCalendarPeriodCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public SystemCalendarPeriodCriteria andPeriodindexIsNull() {
            addCriterion("periodindex is null");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodindexIsNotNull() {
            addCriterion("periodindex is not null");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodindexEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodindex =", value, "periodindex");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodindexNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodindex <>", value, "periodindex");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodindexGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodindex >", value, "periodindex");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodindexGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodindex >=", value, "periodindex");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodindexLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodindex <", value, "periodindex");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodindexLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodindex <=", value, "periodindex");
            return (SystemCalendarPeriodCriteria) this;
        }

        
        public SystemCalendarPeriodCriteria andPeriodtypeIsNull() {
            addCriterion("periodtype is null");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodtypeIsNotNull() {
            addCriterion("periodtype is not null");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodtypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("periodtype =", value, "periodtype");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodtypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("periodtype <>", value, "periodtype");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodtypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("periodtype >", value, "periodtype");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodtypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("periodtype >=", value, "periodtype");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodtypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("periodtype <", value, "periodtype");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodtypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("periodtype <=", value, "periodtype");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodtypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("periodtype like ", value, "periodtype");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodtypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("periodtype not like ", value, "periodtype");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodtypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("periodtype in ", value, "periodtype");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodtypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("periodtype not in ", value, "periodtype");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodtypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("periodtype between ", value1, value2, "periodtype");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodtypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("periodtype not between ", value1, value2, "periodtype");
            return (SystemCalendarPeriodCriteria) this;
        }
        
        public SystemCalendarPeriodCriteria andPeriodstartIsNull() {
            addCriterion("periodstart is null");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodstartIsNotNull() {
            addCriterion("periodstart is not null");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodstartEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("periodstart =", value, "periodstart");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodstartNotEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("periodstart <>", value, "periodstart");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodstartGreaterThan(java.sql.Date value) {
            if (value != null)
              addCriterion("periodstart >", value, "periodstart");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodstartGreaterThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("periodstart >=", value, "periodstart");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodstartLessThan(java.sql.Date value) {
            if (value != null)
              addCriterion("periodstart <", value, "periodstart");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodstartLessThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("periodstart <=", value, "periodstart");
            return (SystemCalendarPeriodCriteria) this;
        }

        
        public SystemCalendarPeriodCriteria andPeriodendIsNull() {
            addCriterion("periodend is null");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodendIsNotNull() {
            addCriterion("periodend is not null");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodendEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("periodend =", value, "periodend");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodendNotEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("periodend <>", value, "periodend");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodendGreaterThan(java.sql.Date value) {
            if (value != null)
              addCriterion("periodend >", value, "periodend");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodendGreaterThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("periodend >=", value, "periodend");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodendLessThan(java.sql.Date value) {
            if (value != null)
              addCriterion("periodend <", value, "periodend");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodendLessThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("periodend <=", value, "periodend");
            return (SystemCalendarPeriodCriteria) this;
        }

        
        public SystemCalendarPeriodCriteria andPeriodyearIsNull() {
            addCriterion("periodyear is null");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodyearIsNotNull() {
            addCriterion("periodyear is not null");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodyearEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodyear =", value, "periodyear");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodyearNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodyear <>", value, "periodyear");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodyearGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodyear >", value, "periodyear");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodyearGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodyear >=", value, "periodyear");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodyearLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodyear <", value, "periodyear");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodyearLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodyear <=", value, "periodyear");
            return (SystemCalendarPeriodCriteria) this;
        }

        
        public SystemCalendarPeriodCriteria andPeriodyindexIsNull() {
            addCriterion("periodyindex is null");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodyindexIsNotNull() {
            addCriterion("periodyindex is not null");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodyindexEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodyindex =", value, "periodyindex");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodyindexNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodyindex <>", value, "periodyindex");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodyindexGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodyindex >", value, "periodyindex");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodyindexGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodyindex >=", value, "periodyindex");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodyindexLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodyindex <", value, "periodyindex");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPeriodyindexLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("periodyindex <=", value, "periodyindex");
            return (SystemCalendarPeriodCriteria) this;
        }

        
        public SystemCalendarPeriodCriteria andPerioddescrIsNull() {
            addCriterion("perioddescr is null");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPerioddescrIsNotNull() {
            addCriterion("perioddescr is not null");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPerioddescrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("perioddescr =", value, "perioddescr");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPerioddescrNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("perioddescr <>", value, "perioddescr");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPerioddescrGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("perioddescr >", value, "perioddescr");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPerioddescrGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("perioddescr >=", value, "perioddescr");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPerioddescrLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("perioddescr <", value, "perioddescr");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPerioddescrLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("perioddescr <=", value, "perioddescr");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPerioddescrLike(java.lang.String value) {
            if (value != null)
              addCriterion("perioddescr like ", value, "perioddescr");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPerioddescrNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("perioddescr not like ", value, "perioddescr");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPerioddescrIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("perioddescr in ", value, "perioddescr");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPerioddescrNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("perioddescr not in ", value, "perioddescr");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPerioddescrBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("perioddescr between ", value1, value2, "perioddescr");
            return (SystemCalendarPeriodCriteria) this;
        }
        public SystemCalendarPeriodCriteria andPerioddescrNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("perioddescr not between ", value1, value2, "perioddescr");
            return (SystemCalendarPeriodCriteria) this;
        }
    }
    
}

