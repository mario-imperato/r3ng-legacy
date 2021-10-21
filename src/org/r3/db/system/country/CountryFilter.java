//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.country;

import java.util.ArrayList;
import java.util.List;

public class CountryFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public CountryFilter() 
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

    public CountryCriteria or() 
    {
        CountryCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public CountryCriteria createCriteria() 
    {
        CountryCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected CountryCriteria createCriteriaInternal() 
    {
        CountryCriteria criteria = new CountryCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class CountryCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public CountryCriteria andIso3166_a3IsNull() {
            addCriterion("iso3166_a3 is null");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_a3IsNotNull() {
            addCriterion("iso3166_a3 is not null");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_a3EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("iso3166_a3 =", value, "iso3166_a3");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_a3NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("iso3166_a3 <>", value, "iso3166_a3");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_a3GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("iso3166_a3 >", value, "iso3166_a3");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_a3GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("iso3166_a3 >=", value, "iso3166_a3");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_a3LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("iso3166_a3 <", value, "iso3166_a3");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_a3LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("iso3166_a3 <=", value, "iso3166_a3");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_a3Like(java.lang.String value) {
            if (value != null)
              addCriterion("iso3166_a3 like ", value, "iso3166_a3");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_a3NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("iso3166_a3 not like ", value, "iso3166_a3");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_a3In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("iso3166_a3 in ", value, "iso3166_a3");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_a3NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("iso3166_a3 not in ", value, "iso3166_a3");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_a3Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("iso3166_a3 between ", value1, value2, "iso3166_a3");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_a3NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("iso3166_a3 not between ", value1, value2, "iso3166_a3");
            return (CountryCriteria) this;
        }
        
        public CountryCriteria andIso3166_a2IsNull() {
            addCriterion("iso3166_a2 is null");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_a2IsNotNull() {
            addCriterion("iso3166_a2 is not null");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_a2EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("iso3166_a2 =", value, "iso3166_a2");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_a2NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("iso3166_a2 <>", value, "iso3166_a2");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_a2GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("iso3166_a2 >", value, "iso3166_a2");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_a2GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("iso3166_a2 >=", value, "iso3166_a2");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_a2LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("iso3166_a2 <", value, "iso3166_a2");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_a2LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("iso3166_a2 <=", value, "iso3166_a2");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_a2Like(java.lang.String value) {
            if (value != null)
              addCriterion("iso3166_a2 like ", value, "iso3166_a2");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_a2NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("iso3166_a2 not like ", value, "iso3166_a2");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_a2In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("iso3166_a2 in ", value, "iso3166_a2");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_a2NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("iso3166_a2 not in ", value, "iso3166_a2");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_a2Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("iso3166_a2 between ", value1, value2, "iso3166_a2");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_a2NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("iso3166_a2 not between ", value1, value2, "iso3166_a2");
            return (CountryCriteria) this;
        }
        
        public CountryCriteria andIso3166_numIsNull() {
            addCriterion("iso3166_num is null");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_numIsNotNull() {
            addCriterion("iso3166_num is not null");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_numEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iso3166_num =", value, "iso3166_num");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_numNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iso3166_num <>", value, "iso3166_num");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_numGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("iso3166_num >", value, "iso3166_num");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_numGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iso3166_num >=", value, "iso3166_num");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_numLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("iso3166_num <", value, "iso3166_num");
            return (CountryCriteria) this;
        }
        public CountryCriteria andIso3166_numLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iso3166_num <=", value, "iso3166_num");
            return (CountryCriteria) this;
        }

        
        public CountryCriteria andCountrynameIsNull() {
            addCriterion("countryname is null");
            return (CountryCriteria) this;
        }
        public CountryCriteria andCountrynameIsNotNull() {
            addCriterion("countryname is not null");
            return (CountryCriteria) this;
        }
        public CountryCriteria andCountrynameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("countryname =", value, "countryname");
            return (CountryCriteria) this;
        }
        public CountryCriteria andCountrynameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("countryname <>", value, "countryname");
            return (CountryCriteria) this;
        }
        public CountryCriteria andCountrynameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("countryname >", value, "countryname");
            return (CountryCriteria) this;
        }
        public CountryCriteria andCountrynameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("countryname >=", value, "countryname");
            return (CountryCriteria) this;
        }
        public CountryCriteria andCountrynameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("countryname <", value, "countryname");
            return (CountryCriteria) this;
        }
        public CountryCriteria andCountrynameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("countryname <=", value, "countryname");
            return (CountryCriteria) this;
        }
        public CountryCriteria andCountrynameLike(java.lang.String value) {
            if (value != null)
              addCriterion("countryname like ", value, "countryname");
            return (CountryCriteria) this;
        }
        public CountryCriteria andCountrynameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("countryname not like ", value, "countryname");
            return (CountryCriteria) this;
        }
        public CountryCriteria andCountrynameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("countryname in ", value, "countryname");
            return (CountryCriteria) this;
        }
        public CountryCriteria andCountrynameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("countryname not in ", value, "countryname");
            return (CountryCriteria) this;
        }
        public CountryCriteria andCountrynameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("countryname between ", value1, value2, "countryname");
            return (CountryCriteria) this;
        }
        public CountryCriteria andCountrynameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("countryname not between ", value1, value2, "countryname");
            return (CountryCriteria) this;
        }
    }
    
}

