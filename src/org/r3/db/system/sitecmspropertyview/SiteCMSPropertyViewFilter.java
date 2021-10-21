//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.sitecmspropertyview;

import java.util.ArrayList;
import java.util.List;

public class SiteCMSPropertyViewFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public SiteCMSPropertyViewFilter() 
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

    public SiteCMSPropertyViewCriteria or() 
    {
        SiteCMSPropertyViewCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public SiteCMSPropertyViewCriteria createCriteria() 
    {
        SiteCMSPropertyViewCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected SiteCMSPropertyViewCriteria createCriteriaInternal() 
    {
        SiteCMSPropertyViewCriteria criteria = new SiteCMSPropertyViewCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class SiteCMSPropertyViewCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public SiteCMSPropertyViewCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (SiteCMSPropertyViewCriteria) this;
        }
        
        public SiteCMSPropertyViewCriteria andCardidIsNull() {
            addCriterion("cardid is null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andCardidIsNotNull() {
            addCriterion("cardid is not null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andCardidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid =", value, "cardid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andCardidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <>", value, "cardid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andCardidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardid >", value, "cardid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andCardidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid >=", value, "cardid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andCardidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <", value, "cardid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andCardidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <=", value, "cardid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andCardidLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardid like ", value, "cardid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andCardidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardid not like ", value, "cardid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andCardidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("cardid in ", value, "cardid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andCardidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("cardid not in ", value, "cardid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andCardidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardid between ", value1, value2, "cardid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andCardidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardid not between ", value1, value2, "cardid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        
        public SiteCMSPropertyViewCriteria andPropertyidIsNull() {
            addCriterion("propertyid is null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyidIsNotNull() {
            addCriterion("propertyid is not null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyid =", value, "propertyid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyid <>", value, "propertyid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyid >", value, "propertyid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyid >=", value, "propertyid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyid <", value, "propertyid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyid <=", value, "propertyid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyidLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyid like ", value, "propertyid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyid not like ", value, "propertyid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("propertyid in ", value, "propertyid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("propertyid not in ", value, "propertyid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyid between ", value1, value2, "propertyid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyid not between ", value1, value2, "propertyid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        
        public SiteCMSPropertyViewCriteria andPropertyroleIsNull() {
            addCriterion("propertyrole is null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyroleIsNotNull() {
            addCriterion("propertyrole is not null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyroleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole =", value, "propertyrole");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyroleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole <>", value, "propertyrole");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyroleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole >", value, "propertyrole");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyroleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole >=", value, "propertyrole");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyroleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole <", value, "propertyrole");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyroleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole <=", value, "propertyrole");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyroleLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole like ", value, "propertyrole");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyroleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole not like ", value, "propertyrole");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyroleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("propertyrole in ", value, "propertyrole");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyroleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("propertyrole not in ", value, "propertyrole");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyroleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyrole between ", value1, value2, "propertyrole");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyroleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyrole not between ", value1, value2, "propertyrole");
            return (SiteCMSPropertyViewCriteria) this;
        }
        
        public SiteCMSPropertyViewCriteria andPropertytypecodeIsNull() {
            addCriterion("propertytypecode is null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertytypecodeIsNotNull() {
            addCriterion("propertytypecode is not null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertytypecodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertytypecode =", value, "propertytypecode");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertytypecodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertytypecode <>", value, "propertytypecode");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertytypecodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertytypecode >", value, "propertytypecode");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertytypecodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertytypecode >=", value, "propertytypecode");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertytypecodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertytypecode <", value, "propertytypecode");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertytypecodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertytypecode <=", value, "propertytypecode");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertytypecodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertytypecode like ", value, "propertytypecode");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertytypecodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertytypecode not like ", value, "propertytypecode");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertytypecodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("propertytypecode in ", value, "propertytypecode");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertytypecodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("propertytypecode not in ", value, "propertytypecode");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertytypecodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertytypecode between ", value1, value2, "propertytypecode");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertytypecodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertytypecode not between ", value1, value2, "propertytypecode");
            return (SiteCMSPropertyViewCriteria) this;
        }
        
        public SiteCMSPropertyViewCriteria andPropertynameIsNull() {
            addCriterion("propertyname is null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertynameIsNotNull() {
            addCriterion("propertyname is not null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertynameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname =", value, "propertyname");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertynameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname <>", value, "propertyname");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertynameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname >", value, "propertyname");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertynameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname >=", value, "propertyname");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertynameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname <", value, "propertyname");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertynameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname <=", value, "propertyname");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertynameLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname like ", value, "propertyname");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertynameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname not like ", value, "propertyname");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertynameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("propertyname in ", value, "propertyname");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertynameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("propertyname not in ", value, "propertyname");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertynameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyname between ", value1, value2, "propertyname");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertynameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyname not between ", value1, value2, "propertyname");
            return (SiteCMSPropertyViewCriteria) this;
        }
        
        public SiteCMSPropertyViewCriteria andPropertyvalueIsNull() {
            addCriterion("propertyvalue is null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyvalueIsNotNull() {
            addCriterion("propertyvalue is not null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyvalueEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue =", value, "propertyvalue");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyvalueNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue <>", value, "propertyvalue");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyvalueGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue >", value, "propertyvalue");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyvalueGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue >=", value, "propertyvalue");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyvalueLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue <", value, "propertyvalue");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyvalueLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue <=", value, "propertyvalue");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyvalueLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue like ", value, "propertyvalue");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyvalueNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue not like ", value, "propertyvalue");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyvalueIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("propertyvalue in ", value, "propertyvalue");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyvalueNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("propertyvalue not in ", value, "propertyvalue");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyvalueBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyvalue between ", value1, value2, "propertyvalue");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertyvalueNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyvalue not between ", value1, value2, "propertyvalue");
            return (SiteCMSPropertyViewCriteria) this;
        }
        
        public SiteCMSPropertyViewCriteria andPropertysizeIsNull() {
            addCriterion("propertysize is null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertysizeIsNotNull() {
            addCriterion("propertysize is not null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertysizeEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("propertysize =", value, "propertysize");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertysizeNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("propertysize <>", value, "propertysize");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertysizeGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("propertysize >", value, "propertysize");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertysizeGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("propertysize >=", value, "propertysize");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertysizeLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("propertysize <", value, "propertysize");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andPropertysizeLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("propertysize <=", value, "propertysize");
            return (SiteCMSPropertyViewCriteria) this;
        }

        
        public SiteCMSPropertyViewCriteria andRefpropertyidIsNull() {
            addCriterion("refpropertyid is null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andRefpropertyidIsNotNull() {
            addCriterion("refpropertyid is not null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andRefpropertyidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("refpropertyid =", value, "refpropertyid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andRefpropertyidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("refpropertyid <>", value, "refpropertyid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andRefpropertyidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("refpropertyid >", value, "refpropertyid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andRefpropertyidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("refpropertyid >=", value, "refpropertyid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andRefpropertyidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("refpropertyid <", value, "refpropertyid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andRefpropertyidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("refpropertyid <=", value, "refpropertyid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andRefpropertyidLike(java.lang.String value) {
            if (value != null)
              addCriterion("refpropertyid like ", value, "refpropertyid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andRefpropertyidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("refpropertyid not like ", value, "refpropertyid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andRefpropertyidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("refpropertyid in ", value, "refpropertyid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andRefpropertyidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("refpropertyid not in ", value, "refpropertyid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andRefpropertyidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("refpropertyid between ", value1, value2, "refpropertyid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andRefpropertyidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("refpropertyid not between ", value1, value2, "refpropertyid");
            return (SiteCMSPropertyViewCriteria) this;
        }
        
        public SiteCMSPropertyViewCriteria andContenttypeIsNull() {
            addCriterion("contenttype is null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andContenttypeIsNotNull() {
            addCriterion("contenttype is not null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andContenttypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype =", value, "contenttype");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andContenttypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype <>", value, "contenttype");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andContenttypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype >", value, "contenttype");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andContenttypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype >=", value, "contenttype");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andContenttypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype <", value, "contenttype");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andContenttypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype <=", value, "contenttype");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andContenttypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype like ", value, "contenttype");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andContenttypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype not like ", value, "contenttype");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andContenttypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("contenttype in ", value, "contenttype");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andContenttypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("contenttype not in ", value, "contenttype");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andContenttypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("contenttype between ", value1, value2, "contenttype");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andContenttypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("contenttype not between ", value1, value2, "contenttype");
            return (SiteCMSPropertyViewCriteria) this;
        }
        
        public SiteCMSPropertyViewCriteria andImageurlIsNull() {
            addCriterion("imageurl is null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImageurlIsNotNull() {
            addCriterion("imageurl is not null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImageurlEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("imageurl =", value, "imageurl");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImageurlNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("imageurl <>", value, "imageurl");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImageurlGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("imageurl >", value, "imageurl");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImageurlGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("imageurl >=", value, "imageurl");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImageurlLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("imageurl <", value, "imageurl");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImageurlLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("imageurl <=", value, "imageurl");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImageurlLike(java.lang.String value) {
            if (value != null)
              addCriterion("imageurl like ", value, "imageurl");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImageurlNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("imageurl not like ", value, "imageurl");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImageurlIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("imageurl in ", value, "imageurl");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImageurlNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("imageurl not in ", value, "imageurl");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImageurlBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("imageurl between ", value1, value2, "imageurl");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImageurlNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("imageurl not between ", value1, value2, "imageurl");
            return (SiteCMSPropertyViewCriteria) this;
        }
        
        public SiteCMSPropertyViewCriteria andImageheightIsNull() {
            addCriterion("imageheight is null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImageheightIsNotNull() {
            addCriterion("imageheight is not null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImageheightEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("imageheight =", value, "imageheight");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImageheightNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("imageheight <>", value, "imageheight");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImageheightGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("imageheight >", value, "imageheight");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImageheightGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("imageheight >=", value, "imageheight");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImageheightLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("imageheight <", value, "imageheight");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImageheightLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("imageheight <=", value, "imageheight");
            return (SiteCMSPropertyViewCriteria) this;
        }

        
        public SiteCMSPropertyViewCriteria andImagewidthIsNull() {
            addCriterion("imagewidth is null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImagewidthIsNotNull() {
            addCriterion("imagewidth is not null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImagewidthEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("imagewidth =", value, "imagewidth");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImagewidthNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("imagewidth <>", value, "imagewidth");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImagewidthGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("imagewidth >", value, "imagewidth");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImagewidthGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("imagewidth >=", value, "imagewidth");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImagewidthLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("imagewidth <", value, "imagewidth");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andImagewidthLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("imagewidth <=", value, "imagewidth");
            return (SiteCMSPropertyViewCriteria) this;
        }

        
        public SiteCMSPropertyViewCriteria andIconurlIsNull() {
            addCriterion("iconurl is null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconurlIsNotNull() {
            addCriterion("iconurl is not null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconurlEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("iconurl =", value, "iconurl");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconurlNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("iconurl <>", value, "iconurl");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconurlGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("iconurl >", value, "iconurl");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconurlGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("iconurl >=", value, "iconurl");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconurlLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("iconurl <", value, "iconurl");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconurlLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("iconurl <=", value, "iconurl");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconurlLike(java.lang.String value) {
            if (value != null)
              addCriterion("iconurl like ", value, "iconurl");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconurlNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("iconurl not like ", value, "iconurl");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconurlIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("iconurl in ", value, "iconurl");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconurlNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("iconurl not in ", value, "iconurl");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconurlBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("iconurl between ", value1, value2, "iconurl");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconurlNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("iconurl not between ", value1, value2, "iconurl");
            return (SiteCMSPropertyViewCriteria) this;
        }
        
        public SiteCMSPropertyViewCriteria andIconwidthIsNull() {
            addCriterion("iconwidth is null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconwidthIsNotNull() {
            addCriterion("iconwidth is not null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconwidthEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconwidth =", value, "iconwidth");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconwidthNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconwidth <>", value, "iconwidth");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconwidthGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconwidth >", value, "iconwidth");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconwidthGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconwidth >=", value, "iconwidth");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconwidthLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconwidth <", value, "iconwidth");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconwidthLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconwidth <=", value, "iconwidth");
            return (SiteCMSPropertyViewCriteria) this;
        }

        
        public SiteCMSPropertyViewCriteria andIconheightIsNull() {
            addCriterion("iconheight is null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconheightIsNotNull() {
            addCriterion("iconheight is not null");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconheightEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconheight =", value, "iconheight");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconheightNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconheight <>", value, "iconheight");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconheightGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconheight >", value, "iconheight");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconheightGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconheight >=", value, "iconheight");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconheightLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconheight <", value, "iconheight");
            return (SiteCMSPropertyViewCriteria) this;
        }
        public SiteCMSPropertyViewCriteria andIconheightLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconheight <=", value, "iconheight");
            return (SiteCMSPropertyViewCriteria) this;
        }

    }
    
}

