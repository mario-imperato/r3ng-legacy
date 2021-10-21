//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.siteproperty;

import java.util.ArrayList;
import java.util.List;

public class SitePropertyFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public SitePropertyFilter() 
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

    public SitePropertyCriteria or() 
    {
        SitePropertyCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public SitePropertyCriteria createCriteria() 
    {
        SitePropertyCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected SitePropertyCriteria createCriteriaInternal() 
    {
        SitePropertyCriteria criteria = new SitePropertyCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class SitePropertyCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public SitePropertyCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (SitePropertyCriteria) this;
        }
        
        public SitePropertyCriteria andPropertyscopeIsNull() {
            addCriterion("propertyscope is null");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertyscopeIsNotNull() {
            addCriterion("propertyscope is not null");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertyscopeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyscope =", value, "propertyscope");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertyscopeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyscope <>", value, "propertyscope");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertyscopeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyscope >", value, "propertyscope");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertyscopeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyscope >=", value, "propertyscope");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertyscopeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyscope <", value, "propertyscope");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertyscopeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyscope <=", value, "propertyscope");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertyscopeLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyscope like ", value, "propertyscope");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertyscopeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyscope not like ", value, "propertyscope");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertyscopeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("propertyscope in ", value, "propertyscope");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertyscopeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("propertyscope not in ", value, "propertyscope");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertyscopeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyscope between ", value1, value2, "propertyscope");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertyscopeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyscope not between ", value1, value2, "propertyscope");
            return (SitePropertyCriteria) this;
        }
        
        public SitePropertyCriteria andPropertykeyIsNull() {
            addCriterion("propertykey is null");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertykeyIsNotNull() {
            addCriterion("propertykey is not null");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertykeyEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertykey =", value, "propertykey");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertykeyNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertykey <>", value, "propertykey");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertykeyGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertykey >", value, "propertykey");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertykeyGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertykey >=", value, "propertykey");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertykeyLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertykey <", value, "propertykey");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertykeyLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertykey <=", value, "propertykey");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertykeyLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertykey like ", value, "propertykey");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertykeyNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertykey not like ", value, "propertykey");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertykeyIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("propertykey in ", value, "propertykey");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertykeyNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("propertykey not in ", value, "propertykey");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertykeyBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertykey between ", value1, value2, "propertykey");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertykeyNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertykey not between ", value1, value2, "propertykey");
            return (SitePropertyCriteria) this;
        }
        
        public SitePropertyCriteria andPropertyvalueIsNull() {
            addCriterion("propertyvalue is null");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertyvalueIsNotNull() {
            addCriterion("propertyvalue is not null");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertyvalueEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue =", value, "propertyvalue");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertyvalueNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue <>", value, "propertyvalue");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertyvalueGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue >", value, "propertyvalue");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertyvalueGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue >=", value, "propertyvalue");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertyvalueLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue <", value, "propertyvalue");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertyvalueLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue <=", value, "propertyvalue");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertyvalueLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue like ", value, "propertyvalue");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertyvalueNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue not like ", value, "propertyvalue");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertyvalueIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("propertyvalue in ", value, "propertyvalue");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertyvalueNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("propertyvalue not in ", value, "propertyvalue");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertyvalueBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyvalue between ", value1, value2, "propertyvalue");
            return (SitePropertyCriteria) this;
        }
        public SitePropertyCriteria andPropertyvalueNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyvalue not between ", value1, value2, "propertyvalue");
            return (SitePropertyCriteria) this;
        }
    }
    
}

