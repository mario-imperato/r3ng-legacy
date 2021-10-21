//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.device;

import java.util.ArrayList;
import java.util.List;

public class DMSDeviceFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public DMSDeviceFilter() 
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

    public DMSDeviceCriteria or() 
    {
        DMSDeviceCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public DMSDeviceCriteria createCriteria() 
    {
        DMSDeviceCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected DMSDeviceCriteria createCriteriaInternal() 
    {
        DMSDeviceCriteria criteria = new DMSDeviceCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class DMSDeviceCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public DMSDeviceCriteria andDeviceidIsNull() {
            addCriterion("deviceid is null");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDeviceidIsNotNull() {
            addCriterion("deviceid is not null");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDeviceidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("deviceid =", value, "deviceid");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDeviceidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("deviceid <>", value, "deviceid");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDeviceidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("deviceid >", value, "deviceid");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDeviceidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("deviceid >=", value, "deviceid");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDeviceidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("deviceid <", value, "deviceid");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDeviceidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("deviceid <=", value, "deviceid");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDeviceidLike(java.lang.String value) {
            if (value != null)
              addCriterion("deviceid like ", value, "deviceid");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDeviceidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("deviceid not like ", value, "deviceid");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDeviceidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("deviceid in ", value, "deviceid");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDeviceidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("deviceid not in ", value, "deviceid");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDeviceidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("deviceid between ", value1, value2, "deviceid");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDeviceidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("deviceid not between ", value1, value2, "deviceid");
            return (DMSDeviceCriteria) this;
        }
        
        public DMSDeviceCriteria andDevicenameIsNull() {
            addCriterion("devicename is null");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDevicenameIsNotNull() {
            addCriterion("devicename is not null");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDevicenameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("devicename =", value, "devicename");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDevicenameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("devicename <>", value, "devicename");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDevicenameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("devicename >", value, "devicename");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDevicenameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("devicename >=", value, "devicename");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDevicenameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("devicename <", value, "devicename");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDevicenameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("devicename <=", value, "devicename");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDevicenameLike(java.lang.String value) {
            if (value != null)
              addCriterion("devicename like ", value, "devicename");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDevicenameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("devicename not like ", value, "devicename");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDevicenameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("devicename in ", value, "devicename");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDevicenameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("devicename not in ", value, "devicename");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDevicenameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("devicename between ", value1, value2, "devicename");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDevicenameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("devicename not between ", value1, value2, "devicename");
            return (DMSDeviceCriteria) this;
        }
        
        public DMSDeviceCriteria andDevicetypeIsNull() {
            addCriterion("devicetype is null");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDevicetypeIsNotNull() {
            addCriterion("devicetype is not null");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDevicetypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("devicetype =", value, "devicetype");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDevicetypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("devicetype <>", value, "devicetype");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDevicetypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("devicetype >", value, "devicetype");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDevicetypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("devicetype >=", value, "devicetype");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDevicetypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("devicetype <", value, "devicetype");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDevicetypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("devicetype <=", value, "devicetype");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDevicetypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("devicetype like ", value, "devicetype");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDevicetypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("devicetype not like ", value, "devicetype");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDevicetypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("devicetype in ", value, "devicetype");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDevicetypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("devicetype not in ", value, "devicetype");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDevicetypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("devicetype between ", value1, value2, "devicetype");
            return (DMSDeviceCriteria) this;
        }
        public DMSDeviceCriteria andDevicetypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("devicetype not between ", value1, value2, "devicetype");
            return (DMSDeviceCriteria) this;
        }
    }
    
}

