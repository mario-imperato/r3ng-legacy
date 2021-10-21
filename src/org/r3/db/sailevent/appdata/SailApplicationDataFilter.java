//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.appdata;

import java.util.ArrayList;
import java.util.List;

public class SailApplicationDataFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public SailApplicationDataFilter() 
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

    public SailApplicationDataCriteria or() 
    {
        SailApplicationDataCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public SailApplicationDataCriteria createCriteria() 
    {
        SailApplicationDataCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected SailApplicationDataCriteria createCriteriaInternal() 
    {
        SailApplicationDataCriteria criteria = new SailApplicationDataCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class SailApplicationDataCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public SailApplicationDataCriteria andEventidIsNull() {
            addCriterion("eventid is null");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andEventidIsNotNull() {
            addCriterion("eventid is not null");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andEventidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid =", value, "eventid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andEventidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <>", value, "eventid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andEventidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >", value, "eventid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andEventidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >=", value, "eventid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andEventidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <", value, "eventid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andEventidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <=", value, "eventid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andEventidLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid like ", value, "eventid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andEventidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid not like ", value, "eventid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andEventidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("eventid in ", value, "eventid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andEventidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("eventid not in ", value, "eventid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andEventidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid between ", value1, value2, "eventid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andEventidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid not between ", value1, value2, "eventid");
            return (SailApplicationDataCriteria) this;
        }
        
        public SailApplicationDataCriteria andApplicationidIsNull() {
            addCriterion("applicationid is null");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andApplicationidIsNotNull() {
            addCriterion("applicationid is not null");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andApplicationidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid =", value, "applicationid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andApplicationidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid <>", value, "applicationid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andApplicationidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid >", value, "applicationid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andApplicationidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid >=", value, "applicationid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andApplicationidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid <", value, "applicationid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andApplicationidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid <=", value, "applicationid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andApplicationidLike(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid like ", value, "applicationid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andApplicationidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid not like ", value, "applicationid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andApplicationidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("applicationid in ", value, "applicationid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andApplicationidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("applicationid not in ", value, "applicationid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andApplicationidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("applicationid between ", value1, value2, "applicationid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andApplicationidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("applicationid not between ", value1, value2, "applicationid");
            return (SailApplicationDataCriteria) this;
        }
        
        public SailApplicationDataCriteria andSectionidIsNull() {
            addCriterion("sectionid is null");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andSectionidIsNotNull() {
            addCriterion("sectionid is not null");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andSectionidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sectionid =", value, "sectionid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andSectionidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sectionid <>", value, "sectionid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andSectionidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("sectionid >", value, "sectionid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andSectionidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sectionid >=", value, "sectionid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andSectionidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("sectionid <", value, "sectionid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andSectionidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sectionid <=", value, "sectionid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andSectionidLike(java.lang.String value) {
            if (value != null)
              addCriterion("sectionid like ", value, "sectionid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andSectionidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("sectionid not like ", value, "sectionid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andSectionidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("sectionid in ", value, "sectionid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andSectionidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("sectionid not in ", value, "sectionid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andSectionidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("sectionid between ", value1, value2, "sectionid");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andSectionidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("sectionid not between ", value1, value2, "sectionid");
            return (SailApplicationDataCriteria) this;
        }
        
        public SailApplicationDataCriteria andParamnameIsNull() {
            addCriterion("paramname is null");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andParamnameIsNotNull() {
            addCriterion("paramname is not null");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andParamnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("paramname =", value, "paramname");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andParamnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("paramname <>", value, "paramname");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andParamnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("paramname >", value, "paramname");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andParamnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("paramname >=", value, "paramname");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andParamnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("paramname <", value, "paramname");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andParamnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("paramname <=", value, "paramname");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andParamnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("paramname like ", value, "paramname");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andParamnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("paramname not like ", value, "paramname");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andParamnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("paramname in ", value, "paramname");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andParamnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("paramname not in ", value, "paramname");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andParamnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("paramname between ", value1, value2, "paramname");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andParamnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("paramname not between ", value1, value2, "paramname");
            return (SailApplicationDataCriteria) this;
        }
        
        public SailApplicationDataCriteria andParamvalueIsNull() {
            addCriterion("paramvalue is null");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andParamvalueIsNotNull() {
            addCriterion("paramvalue is not null");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andParamvalueEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("paramvalue =", value, "paramvalue");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andParamvalueNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("paramvalue <>", value, "paramvalue");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andParamvalueGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("paramvalue >", value, "paramvalue");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andParamvalueGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("paramvalue >=", value, "paramvalue");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andParamvalueLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("paramvalue <", value, "paramvalue");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andParamvalueLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("paramvalue <=", value, "paramvalue");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andParamvalueLike(java.lang.String value) {
            if (value != null)
              addCriterion("paramvalue like ", value, "paramvalue");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andParamvalueNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("paramvalue not like ", value, "paramvalue");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andParamvalueIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("paramvalue in ", value, "paramvalue");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andParamvalueNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("paramvalue not in ", value, "paramvalue");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andParamvalueBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("paramvalue between ", value1, value2, "paramvalue");
            return (SailApplicationDataCriteria) this;
        }
        public SailApplicationDataCriteria andParamvalueNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("paramvalue not between ", value1, value2, "paramvalue");
            return (SailApplicationDataCriteria) this;
        }
    }
    
}

