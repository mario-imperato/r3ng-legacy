//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.devicealias;

import java.util.ArrayList;
import java.util.List;

public class DMSDeviceAliasFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public DMSDeviceAliasFilter() 
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

    public DMSDeviceAliasCriteria or() 
    {
        DMSDeviceAliasCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public DMSDeviceAliasCriteria createCriteria() 
    {
        DMSDeviceAliasCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected DMSDeviceAliasCriteria createCriteriaInternal() 
    {
        DMSDeviceAliasCriteria criteria = new DMSDeviceAliasCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class DMSDeviceAliasCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public DMSDeviceAliasCriteria andDeviceidIsNull() {
            addCriterion("deviceid is null");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andDeviceidIsNotNull() {
            addCriterion("deviceid is not null");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andDeviceidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("deviceid =", value, "deviceid");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andDeviceidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("deviceid <>", value, "deviceid");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andDeviceidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("deviceid >", value, "deviceid");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andDeviceidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("deviceid >=", value, "deviceid");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andDeviceidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("deviceid <", value, "deviceid");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andDeviceidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("deviceid <=", value, "deviceid");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andDeviceidLike(java.lang.String value) {
            if (value != null)
              addCriterion("deviceid like ", value, "deviceid");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andDeviceidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("deviceid not like ", value, "deviceid");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andDeviceidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("deviceid in ", value, "deviceid");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andDeviceidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("deviceid not in ", value, "deviceid");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andDeviceidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("deviceid between ", value1, value2, "deviceid");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andDeviceidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("deviceid not between ", value1, value2, "deviceid");
            return (DMSDeviceAliasCriteria) this;
        }
        
        public DMSDeviceAliasCriteria andClientidIsNull() {
            addCriterion("clientid is null");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andClientidIsNotNull() {
            addCriterion("clientid is not null");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andClientidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clientid =", value, "clientid");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andClientidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clientid <>", value, "clientid");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andClientidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("clientid >", value, "clientid");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andClientidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clientid >=", value, "clientid");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andClientidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("clientid <", value, "clientid");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andClientidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clientid <=", value, "clientid");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andClientidLike(java.lang.String value) {
            if (value != null)
              addCriterion("clientid like ", value, "clientid");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andClientidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("clientid not like ", value, "clientid");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andClientidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("clientid in ", value, "clientid");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andClientidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("clientid not in ", value, "clientid");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andClientidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("clientid between ", value1, value2, "clientid");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andClientidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("clientid not between ", value1, value2, "clientid");
            return (DMSDeviceAliasCriteria) this;
        }
        
        public DMSDeviceAliasCriteria andDevicephysicalnameIsNull() {
            addCriterion("devicephysicalname is null");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andDevicephysicalnameIsNotNull() {
            addCriterion("devicephysicalname is not null");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andDevicephysicalnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("devicephysicalname =", value, "devicephysicalname");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andDevicephysicalnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("devicephysicalname <>", value, "devicephysicalname");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andDevicephysicalnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("devicephysicalname >", value, "devicephysicalname");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andDevicephysicalnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("devicephysicalname >=", value, "devicephysicalname");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andDevicephysicalnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("devicephysicalname <", value, "devicephysicalname");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andDevicephysicalnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("devicephysicalname <=", value, "devicephysicalname");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andDevicephysicalnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("devicephysicalname like ", value, "devicephysicalname");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andDevicephysicalnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("devicephysicalname not like ", value, "devicephysicalname");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andDevicephysicalnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("devicephysicalname in ", value, "devicephysicalname");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andDevicephysicalnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("devicephysicalname not in ", value, "devicephysicalname");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andDevicephysicalnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("devicephysicalname between ", value1, value2, "devicephysicalname");
            return (DMSDeviceAliasCriteria) this;
        }
        public DMSDeviceAliasCriteria andDevicephysicalnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("devicephysicalname not between ", value1, value2, "devicephysicalname");
            return (DMSDeviceAliasCriteria) this;
        }
    }
    
}

