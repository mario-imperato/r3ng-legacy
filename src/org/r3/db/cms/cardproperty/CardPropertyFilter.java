//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardproperty;

import java.util.ArrayList;
import java.util.List;

public class CardPropertyFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public CardPropertyFilter() 
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

    public CardPropertyCriteria or() 
    {
        CardPropertyCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public CardPropertyCriteria createCriteria() 
    {
        CardPropertyCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected CardPropertyCriteria createCriteriaInternal() 
    {
        CardPropertyCriteria criteria = new CardPropertyCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class CardPropertyCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public CardPropertyCriteria andPropertyidIsNull() {
            addCriterion("propertyid is null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyidIsNotNull() {
            addCriterion("propertyid is not null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyid =", value, "propertyid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyid <>", value, "propertyid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyid >", value, "propertyid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyid >=", value, "propertyid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyid <", value, "propertyid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyid <=", value, "propertyid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyidLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyid like ", value, "propertyid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyid not like ", value, "propertyid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("propertyid in ", value, "propertyid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("propertyid not in ", value, "propertyid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyid between ", value1, value2, "propertyid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyid not between ", value1, value2, "propertyid");
            return (CardPropertyCriteria) this;
        }
        
        public CardPropertyCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (CardPropertyCriteria) this;
        }
        
        public CardPropertyCriteria andCardidIsNull() {
            addCriterion("cardid is null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andCardidIsNotNull() {
            addCriterion("cardid is not null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andCardidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid =", value, "cardid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andCardidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <>", value, "cardid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andCardidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardid >", value, "cardid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andCardidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid >=", value, "cardid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andCardidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <", value, "cardid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andCardidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <=", value, "cardid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andCardidLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardid like ", value, "cardid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andCardidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardid not like ", value, "cardid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andCardidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("cardid in ", value, "cardid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andCardidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("cardid not in ", value, "cardid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andCardidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardid between ", value1, value2, "cardid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andCardidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardid not between ", value1, value2, "cardid");
            return (CardPropertyCriteria) this;
        }
        
        public CardPropertyCriteria andLanguagecodeIsNull() {
            addCriterion("languagecode is null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andLanguagecodeIsNotNull() {
            addCriterion("languagecode is not null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andLanguagecodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode =", value, "languagecode");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andLanguagecodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode <>", value, "languagecode");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andLanguagecodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode >", value, "languagecode");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andLanguagecodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode >=", value, "languagecode");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andLanguagecodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode <", value, "languagecode");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andLanguagecodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode <=", value, "languagecode");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andLanguagecodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode like ", value, "languagecode");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andLanguagecodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode not like ", value, "languagecode");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andLanguagecodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("languagecode in ", value, "languagecode");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andLanguagecodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("languagecode not in ", value, "languagecode");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andLanguagecodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("languagecode between ", value1, value2, "languagecode");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andLanguagecodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("languagecode not between ", value1, value2, "languagecode");
            return (CardPropertyCriteria) this;
        }
        
        public CardPropertyCriteria andPropertyroleIsNull() {
            addCriterion("propertyrole is null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyroleIsNotNull() {
            addCriterion("propertyrole is not null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyroleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole =", value, "propertyrole");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyroleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole <>", value, "propertyrole");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyroleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole >", value, "propertyrole");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyroleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole >=", value, "propertyrole");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyroleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole <", value, "propertyrole");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyroleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole <=", value, "propertyrole");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyroleLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole like ", value, "propertyrole");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyroleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole not like ", value, "propertyrole");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyroleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("propertyrole in ", value, "propertyrole");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyroleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("propertyrole not in ", value, "propertyrole");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyroleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyrole between ", value1, value2, "propertyrole");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyroleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyrole not between ", value1, value2, "propertyrole");
            return (CardPropertyCriteria) this;
        }
        
        public CardPropertyCriteria andPropertytypecodeIsNull() {
            addCriterion("propertytypecode is null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertytypecodeIsNotNull() {
            addCriterion("propertytypecode is not null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertytypecodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertytypecode =", value, "propertytypecode");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertytypecodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertytypecode <>", value, "propertytypecode");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertytypecodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertytypecode >", value, "propertytypecode");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertytypecodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertytypecode >=", value, "propertytypecode");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertytypecodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertytypecode <", value, "propertytypecode");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertytypecodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertytypecode <=", value, "propertytypecode");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertytypecodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertytypecode like ", value, "propertytypecode");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertytypecodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertytypecode not like ", value, "propertytypecode");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertytypecodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("propertytypecode in ", value, "propertytypecode");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertytypecodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("propertytypecode not in ", value, "propertytypecode");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertytypecodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertytypecode between ", value1, value2, "propertytypecode");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertytypecodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertytypecode not between ", value1, value2, "propertytypecode");
            return (CardPropertyCriteria) this;
        }
        
        public CardPropertyCriteria andPropertynameIsNull() {
            addCriterion("propertyname is null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertynameIsNotNull() {
            addCriterion("propertyname is not null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertynameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname =", value, "propertyname");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertynameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname <>", value, "propertyname");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertynameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname >", value, "propertyname");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertynameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname >=", value, "propertyname");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertynameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname <", value, "propertyname");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertynameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname <=", value, "propertyname");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertynameLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname like ", value, "propertyname");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertynameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname not like ", value, "propertyname");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertynameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("propertyname in ", value, "propertyname");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertynameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("propertyname not in ", value, "propertyname");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertynameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyname between ", value1, value2, "propertyname");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertynameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyname not between ", value1, value2, "propertyname");
            return (CardPropertyCriteria) this;
        }
        
        public CardPropertyCriteria andPropertyvalueIsNull() {
            addCriterion("propertyvalue is null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyvalueIsNotNull() {
            addCriterion("propertyvalue is not null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyvalueEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue =", value, "propertyvalue");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyvalueNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue <>", value, "propertyvalue");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyvalueGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue >", value, "propertyvalue");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyvalueGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue >=", value, "propertyvalue");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyvalueLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue <", value, "propertyvalue");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyvalueLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue <=", value, "propertyvalue");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyvalueLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue like ", value, "propertyvalue");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyvalueNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue not like ", value, "propertyvalue");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyvalueIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("propertyvalue in ", value, "propertyvalue");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyvalueNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("propertyvalue not in ", value, "propertyvalue");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyvalueBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyvalue between ", value1, value2, "propertyvalue");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertyvalueNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyvalue not between ", value1, value2, "propertyvalue");
            return (CardPropertyCriteria) this;
        }
        
        public CardPropertyCriteria andPropertysizeIsNull() {
            addCriterion("propertysize is null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertysizeIsNotNull() {
            addCriterion("propertysize is not null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertysizeEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("propertysize =", value, "propertysize");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertysizeNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("propertysize <>", value, "propertysize");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertysizeGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("propertysize >", value, "propertysize");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertysizeGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("propertysize >=", value, "propertysize");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertysizeLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("propertysize <", value, "propertysize");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andPropertysizeLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("propertysize <=", value, "propertysize");
            return (CardPropertyCriteria) this;
        }

        
        public CardPropertyCriteria andRefpropertyidIsNull() {
            addCriterion("refpropertyid is null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRefpropertyidIsNotNull() {
            addCriterion("refpropertyid is not null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRefpropertyidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("refpropertyid =", value, "refpropertyid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRefpropertyidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("refpropertyid <>", value, "refpropertyid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRefpropertyidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("refpropertyid >", value, "refpropertyid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRefpropertyidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("refpropertyid >=", value, "refpropertyid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRefpropertyidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("refpropertyid <", value, "refpropertyid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRefpropertyidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("refpropertyid <=", value, "refpropertyid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRefpropertyidLike(java.lang.String value) {
            if (value != null)
              addCriterion("refpropertyid like ", value, "refpropertyid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRefpropertyidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("refpropertyid not like ", value, "refpropertyid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRefpropertyidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("refpropertyid in ", value, "refpropertyid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRefpropertyidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("refpropertyid not in ", value, "refpropertyid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRefpropertyidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("refpropertyid between ", value1, value2, "refpropertyid");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRefpropertyidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("refpropertyid not between ", value1, value2, "refpropertyid");
            return (CardPropertyCriteria) this;
        }
        
        public CardPropertyCriteria andContenttypeIsNull() {
            addCriterion("contenttype is null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andContenttypeIsNotNull() {
            addCriterion("contenttype is not null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andContenttypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype =", value, "contenttype");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andContenttypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype <>", value, "contenttype");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andContenttypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype >", value, "contenttype");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andContenttypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype >=", value, "contenttype");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andContenttypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype <", value, "contenttype");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andContenttypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype <=", value, "contenttype");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andContenttypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype like ", value, "contenttype");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andContenttypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype not like ", value, "contenttype");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andContenttypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("contenttype in ", value, "contenttype");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andContenttypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("contenttype not in ", value, "contenttype");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andContenttypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("contenttype between ", value1, value2, "contenttype");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andContenttypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("contenttype not between ", value1, value2, "contenttype");
            return (CardPropertyCriteria) this;
        }
        
        public CardPropertyCriteria andImageurlIsNull() {
            addCriterion("imageurl is null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImageurlIsNotNull() {
            addCriterion("imageurl is not null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImageurlEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("imageurl =", value, "imageurl");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImageurlNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("imageurl <>", value, "imageurl");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImageurlGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("imageurl >", value, "imageurl");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImageurlGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("imageurl >=", value, "imageurl");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImageurlLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("imageurl <", value, "imageurl");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImageurlLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("imageurl <=", value, "imageurl");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImageurlLike(java.lang.String value) {
            if (value != null)
              addCriterion("imageurl like ", value, "imageurl");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImageurlNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("imageurl not like ", value, "imageurl");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImageurlIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("imageurl in ", value, "imageurl");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImageurlNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("imageurl not in ", value, "imageurl");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImageurlBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("imageurl between ", value1, value2, "imageurl");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImageurlNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("imageurl not between ", value1, value2, "imageurl");
            return (CardPropertyCriteria) this;
        }
        
        public CardPropertyCriteria andImageheightIsNull() {
            addCriterion("imageheight is null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImageheightIsNotNull() {
            addCriterion("imageheight is not null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImageheightEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("imageheight =", value, "imageheight");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImageheightNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("imageheight <>", value, "imageheight");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImageheightGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("imageheight >", value, "imageheight");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImageheightGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("imageheight >=", value, "imageheight");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImageheightLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("imageheight <", value, "imageheight");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImageheightLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("imageheight <=", value, "imageheight");
            return (CardPropertyCriteria) this;
        }

        
        public CardPropertyCriteria andImagewidthIsNull() {
            addCriterion("imagewidth is null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImagewidthIsNotNull() {
            addCriterion("imagewidth is not null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImagewidthEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("imagewidth =", value, "imagewidth");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImagewidthNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("imagewidth <>", value, "imagewidth");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImagewidthGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("imagewidth >", value, "imagewidth");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImagewidthGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("imagewidth >=", value, "imagewidth");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImagewidthLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("imagewidth <", value, "imagewidth");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andImagewidthLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("imagewidth <=", value, "imagewidth");
            return (CardPropertyCriteria) this;
        }

        
        public CardPropertyCriteria andIconurlIsNull() {
            addCriterion("iconurl is null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconurlIsNotNull() {
            addCriterion("iconurl is not null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconurlEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("iconurl =", value, "iconurl");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconurlNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("iconurl <>", value, "iconurl");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconurlGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("iconurl >", value, "iconurl");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconurlGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("iconurl >=", value, "iconurl");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconurlLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("iconurl <", value, "iconurl");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconurlLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("iconurl <=", value, "iconurl");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconurlLike(java.lang.String value) {
            if (value != null)
              addCriterion("iconurl like ", value, "iconurl");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconurlNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("iconurl not like ", value, "iconurl");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconurlIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("iconurl in ", value, "iconurl");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconurlNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("iconurl not in ", value, "iconurl");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconurlBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("iconurl between ", value1, value2, "iconurl");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconurlNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("iconurl not between ", value1, value2, "iconurl");
            return (CardPropertyCriteria) this;
        }
        
        public CardPropertyCriteria andIconwidthIsNull() {
            addCriterion("iconwidth is null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconwidthIsNotNull() {
            addCriterion("iconwidth is not null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconwidthEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconwidth =", value, "iconwidth");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconwidthNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconwidth <>", value, "iconwidth");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconwidthGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconwidth >", value, "iconwidth");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconwidthGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconwidth >=", value, "iconwidth");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconwidthLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconwidth <", value, "iconwidth");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconwidthLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconwidth <=", value, "iconwidth");
            return (CardPropertyCriteria) this;
        }

        
        public CardPropertyCriteria andIconheightIsNull() {
            addCriterion("iconheight is null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconheightIsNotNull() {
            addCriterion("iconheight is not null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconheightEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconheight =", value, "iconheight");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconheightNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconheight <>", value, "iconheight");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconheightGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconheight >", value, "iconheight");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconheightGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconheight >=", value, "iconheight");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconheightLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconheight <", value, "iconheight");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andIconheightLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconheight <=", value, "iconheight");
            return (CardPropertyCriteria) this;
        }

        
        public CardPropertyCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (CardPropertyCriteria) this;
        }
        
        public CardPropertyCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (CardPropertyCriteria) this;
        }
        public CardPropertyCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (CardPropertyCriteria) this;
        }

    }
    
}

