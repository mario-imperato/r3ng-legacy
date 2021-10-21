//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.openregattas.openregattasview;

import java.util.ArrayList;
import java.util.List;

public class OpenRegattasViewFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public OpenRegattasViewFilter() 
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

    public OpenRegattasViewCriteria or() 
    {
        OpenRegattasViewCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public OpenRegattasViewCriteria createCriteria() 
    {
        OpenRegattasViewCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected OpenRegattasViewCriteria createCriteriaInternal() 
    {
        OpenRegattasViewCriteria criteria = new OpenRegattasViewCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class OpenRegattasViewCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public OpenRegattasViewCriteria andRegattaidIsNull() {
            addCriterion("regattaid is null");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andRegattaidIsNotNull() {
            addCriterion("regattaid is not null");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andRegattaidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("regattaid =", value, "regattaid");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andRegattaidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("regattaid <>", value, "regattaid");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andRegattaidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("regattaid >", value, "regattaid");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andRegattaidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("regattaid >=", value, "regattaid");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andRegattaidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("regattaid <", value, "regattaid");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andRegattaidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("regattaid <=", value, "regattaid");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andRegattaidLike(java.lang.String value) {
            if (value != null)
              addCriterion("regattaid like ", value, "regattaid");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andRegattaidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("regattaid not like ", value, "regattaid");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andRegattaidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("regattaid in ", value, "regattaid");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andRegattaidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("regattaid not in ", value, "regattaid");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andRegattaidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("regattaid between ", value1, value2, "regattaid");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andRegattaidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("regattaid not between ", value1, value2, "regattaid");
            return (OpenRegattasViewCriteria) this;
        }
        
        public OpenRegattasViewCriteria andTitleIsNull() {
            addCriterion("title is null");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andTitleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("title =", value, "title");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andTitleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("title <>", value, "title");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andTitleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("title >", value, "title");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andTitleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("title >=", value, "title");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andTitleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("title <", value, "title");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andTitleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("title <=", value, "title");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andTitleLike(java.lang.String value) {
            if (value != null)
              addCriterion("title like ", value, "title");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andTitleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("title not like ", value, "title");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andTitleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("title in ", value, "title");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andTitleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("title not in ", value, "title");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andTitleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("title between ", value1, value2, "title");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andTitleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("title not between ", value1, value2, "title");
            return (OpenRegattasViewCriteria) this;
        }
        
        public OpenRegattasViewCriteria andLanguagesIsNull() {
            addCriterion("languages is null");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andLanguagesIsNotNull() {
            addCriterion("languages is not null");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andLanguagesEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languages =", value, "languages");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andLanguagesNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languages <>", value, "languages");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andLanguagesGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("languages >", value, "languages");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andLanguagesGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languages >=", value, "languages");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andLanguagesLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("languages <", value, "languages");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andLanguagesLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languages <=", value, "languages");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andLanguagesLike(java.lang.String value) {
            if (value != null)
              addCriterion("languages like ", value, "languages");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andLanguagesNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("languages not like ", value, "languages");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andLanguagesIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("languages in ", value, "languages");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andLanguagesNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("languages not in ", value, "languages");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andLanguagesBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("languages between ", value1, value2, "languages");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andLanguagesNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("languages not between ", value1, value2, "languages");
            return (OpenRegattasViewCriteria) this;
        }
        
        public OpenRegattasViewCriteria andDomainIsNull() {
            addCriterion("domain is null");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andDomainIsNotNull() {
            addCriterion("domain is not null");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andDomainEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("domain =", value, "domain");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andDomainNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("domain <>", value, "domain");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andDomainGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("domain >", value, "domain");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andDomainGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("domain >=", value, "domain");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andDomainLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("domain <", value, "domain");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andDomainLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("domain <=", value, "domain");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andDomainLike(java.lang.String value) {
            if (value != null)
              addCriterion("domain like ", value, "domain");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andDomainNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("domain not like ", value, "domain");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andDomainIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("domain in ", value, "domain");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andDomainNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("domain not in ", value, "domain");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andDomainBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("domain between ", value1, value2, "domain");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andDomainNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("domain not between ", value1, value2, "domain");
            return (OpenRegattasViewCriteria) this;
        }
        
        public OpenRegattasViewCriteria andIconIsNull() {
            addCriterion("icon is null");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andIconIsNotNull() {
            addCriterion("icon is not null");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andIconEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("icon =", value, "icon");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andIconNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("icon <>", value, "icon");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andIconGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("icon >", value, "icon");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andIconGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("icon >=", value, "icon");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andIconLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("icon <", value, "icon");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andIconLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("icon <=", value, "icon");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andIconLike(java.lang.String value) {
            if (value != null)
              addCriterion("icon like ", value, "icon");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andIconNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("icon not like ", value, "icon");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andIconIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("icon in ", value, "icon");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andIconNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("icon not in ", value, "icon");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andIconBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("icon between ", value1, value2, "icon");
            return (OpenRegattasViewCriteria) this;
        }
        public OpenRegattasViewCriteria andIconNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("icon not between ", value1, value2, "icon");
            return (OpenRegattasViewCriteria) this;
        }
    }
    
}

