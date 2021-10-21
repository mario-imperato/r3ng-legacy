//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.address;

import java.util.ArrayList;
import java.util.List;

public class AddressFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public AddressFilter() 
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

    public AddressCriteria or() 
    {
        AddressCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public AddressCriteria createCriteria() 
    {
        AddressCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected AddressCriteria createCriteriaInternal() 
    {
        AddressCriteria criteria = new AddressCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class AddressCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public AddressCriteria andAddressidIsNull() {
            addCriterion("addressid is null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddressidIsNotNull() {
            addCriterion("addressid is not null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddressidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("addressid =", value, "addressid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddressidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("addressid <>", value, "addressid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddressidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("addressid >", value, "addressid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddressidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("addressid >=", value, "addressid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddressidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("addressid <", value, "addressid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddressidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("addressid <=", value, "addressid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddressidLike(java.lang.String value) {
            if (value != null)
              addCriterion("addressid like ", value, "addressid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddressidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("addressid not like ", value, "addressid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddressidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("addressid in ", value, "addressid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddressidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("addressid not in ", value, "addressid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddressidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("addressid between ", value1, value2, "addressid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddressidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("addressid not between ", value1, value2, "addressid");
            return (AddressCriteria) this;
        }
        
        public AddressCriteria andEntityidIsNull() {
            addCriterion("entityid is null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andEntityidIsNotNull() {
            addCriterion("entityid is not null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andEntityidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("entityid =", value, "entityid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andEntityidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("entityid <>", value, "entityid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andEntityidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("entityid >", value, "entityid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andEntityidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("entityid >=", value, "entityid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andEntityidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("entityid <", value, "entityid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andEntityidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("entityid <=", value, "entityid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andEntityidLike(java.lang.String value) {
            if (value != null)
              addCriterion("entityid like ", value, "entityid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andEntityidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("entityid not like ", value, "entityid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andEntityidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("entityid in ", value, "entityid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andEntityidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("entityid not in ", value, "entityid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andEntityidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("entityid between ", value1, value2, "entityid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andEntityidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("entityid not between ", value1, value2, "entityid");
            return (AddressCriteria) this;
        }
        
        public AddressCriteria andCountryidIsNull() {
            addCriterion("countryid is null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andCountryidIsNotNull() {
            addCriterion("countryid is not null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andCountryidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("countryid =", value, "countryid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andCountryidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("countryid <>", value, "countryid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andCountryidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("countryid >", value, "countryid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andCountryidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("countryid >=", value, "countryid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andCountryidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("countryid <", value, "countryid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andCountryidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("countryid <=", value, "countryid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andCountryidLike(java.lang.String value) {
            if (value != null)
              addCriterion("countryid like ", value, "countryid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andCountryidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("countryid not like ", value, "countryid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andCountryidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("countryid in ", value, "countryid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andCountryidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("countryid not in ", value, "countryid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andCountryidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("countryid between ", value1, value2, "countryid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andCountryidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("countryid not between ", value1, value2, "countryid");
            return (AddressCriteria) this;
        }
        
        public AddressCriteria andOwneridIsNull() {
            addCriterion("ownerid is null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andOwneridIsNotNull() {
            addCriterion("ownerid is not null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andOwneridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownerid =", value, "ownerid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andOwneridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownerid <>", value, "ownerid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andOwneridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("ownerid >", value, "ownerid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andOwneridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownerid >=", value, "ownerid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andOwneridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("ownerid <", value, "ownerid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andOwneridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownerid <=", value, "ownerid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andOwneridLike(java.lang.String value) {
            if (value != null)
              addCriterion("ownerid like ", value, "ownerid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andOwneridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("ownerid not like ", value, "ownerid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andOwneridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("ownerid in ", value, "ownerid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andOwneridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("ownerid not in ", value, "ownerid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andOwneridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ownerid between ", value1, value2, "ownerid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andOwneridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ownerid not between ", value1, value2, "ownerid");
            return (AddressCriteria) this;
        }
        
        public AddressCriteria andAddresstypeidIsNull() {
            addCriterion("addresstypeid is null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddresstypeidIsNotNull() {
            addCriterion("addresstypeid is not null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddresstypeidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("addresstypeid =", value, "addresstypeid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddresstypeidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("addresstypeid <>", value, "addresstypeid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddresstypeidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("addresstypeid >", value, "addresstypeid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddresstypeidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("addresstypeid >=", value, "addresstypeid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddresstypeidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("addresstypeid <", value, "addresstypeid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddresstypeidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("addresstypeid <=", value, "addresstypeid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddresstypeidLike(java.lang.String value) {
            if (value != null)
              addCriterion("addresstypeid like ", value, "addresstypeid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddresstypeidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("addresstypeid not like ", value, "addresstypeid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddresstypeidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("addresstypeid in ", value, "addresstypeid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddresstypeidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("addresstypeid not in ", value, "addresstypeid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddresstypeidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("addresstypeid between ", value1, value2, "addresstypeid");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddresstypeidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("addresstypeid not between ", value1, value2, "addresstypeid");
            return (AddressCriteria) this;
        }
        
        public AddressCriteria andStateIsNull() {
            addCriterion("state is null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andStateEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("state =", value, "state");
            return (AddressCriteria) this;
        }
        public AddressCriteria andStateNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("state <>", value, "state");
            return (AddressCriteria) this;
        }
        public AddressCriteria andStateGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("state >", value, "state");
            return (AddressCriteria) this;
        }
        public AddressCriteria andStateGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("state >=", value, "state");
            return (AddressCriteria) this;
        }
        public AddressCriteria andStateLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("state <", value, "state");
            return (AddressCriteria) this;
        }
        public AddressCriteria andStateLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("state <=", value, "state");
            return (AddressCriteria) this;
        }
        public AddressCriteria andStateLike(java.lang.String value) {
            if (value != null)
              addCriterion("state like ", value, "state");
            return (AddressCriteria) this;
        }
        public AddressCriteria andStateNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("state not like ", value, "state");
            return (AddressCriteria) this;
        }
        public AddressCriteria andStateIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("state in ", value, "state");
            return (AddressCriteria) this;
        }
        public AddressCriteria andStateNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("state not in ", value, "state");
            return (AddressCriteria) this;
        }
        public AddressCriteria andStateBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("state between ", value1, value2, "state");
            return (AddressCriteria) this;
        }
        public AddressCriteria andStateNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("state not between ", value1, value2, "state");
            return (AddressCriteria) this;
        }
        
        public AddressCriteria andCityIsNull() {
            addCriterion("city is null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andCityEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("city =", value, "city");
            return (AddressCriteria) this;
        }
        public AddressCriteria andCityNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("city <>", value, "city");
            return (AddressCriteria) this;
        }
        public AddressCriteria andCityGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("city >", value, "city");
            return (AddressCriteria) this;
        }
        public AddressCriteria andCityGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("city >=", value, "city");
            return (AddressCriteria) this;
        }
        public AddressCriteria andCityLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("city <", value, "city");
            return (AddressCriteria) this;
        }
        public AddressCriteria andCityLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("city <=", value, "city");
            return (AddressCriteria) this;
        }
        public AddressCriteria andCityLike(java.lang.String value) {
            if (value != null)
              addCriterion("city like ", value, "city");
            return (AddressCriteria) this;
        }
        public AddressCriteria andCityNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("city not like ", value, "city");
            return (AddressCriteria) this;
        }
        public AddressCriteria andCityIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("city in ", value, "city");
            return (AddressCriteria) this;
        }
        public AddressCriteria andCityNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("city not in ", value, "city");
            return (AddressCriteria) this;
        }
        public AddressCriteria andCityBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("city between ", value1, value2, "city");
            return (AddressCriteria) this;
        }
        public AddressCriteria andCityNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("city not between ", value1, value2, "city");
            return (AddressCriteria) this;
        }
        
        public AddressCriteria andZipcodeIsNull() {
            addCriterion("zipcode is null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andZipcodeIsNotNull() {
            addCriterion("zipcode is not null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andZipcodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode =", value, "zipcode");
            return (AddressCriteria) this;
        }
        public AddressCriteria andZipcodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode <>", value, "zipcode");
            return (AddressCriteria) this;
        }
        public AddressCriteria andZipcodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode >", value, "zipcode");
            return (AddressCriteria) this;
        }
        public AddressCriteria andZipcodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode >=", value, "zipcode");
            return (AddressCriteria) this;
        }
        public AddressCriteria andZipcodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode <", value, "zipcode");
            return (AddressCriteria) this;
        }
        public AddressCriteria andZipcodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode <=", value, "zipcode");
            return (AddressCriteria) this;
        }
        public AddressCriteria andZipcodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode like ", value, "zipcode");
            return (AddressCriteria) this;
        }
        public AddressCriteria andZipcodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode not like ", value, "zipcode");
            return (AddressCriteria) this;
        }
        public AddressCriteria andZipcodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("zipcode in ", value, "zipcode");
            return (AddressCriteria) this;
        }
        public AddressCriteria andZipcodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("zipcode not in ", value, "zipcode");
            return (AddressCriteria) this;
        }
        public AddressCriteria andZipcodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("zipcode between ", value1, value2, "zipcode");
            return (AddressCriteria) this;
        }
        public AddressCriteria andZipcodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("zipcode not between ", value1, value2, "zipcode");
            return (AddressCriteria) this;
        }
        
        public AddressCriteria andAddressIsNull() {
            addCriterion("address is null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddressEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("address =", value, "address");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddressNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("address <>", value, "address");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddressGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("address >", value, "address");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddressGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("address >=", value, "address");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddressLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("address <", value, "address");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddressLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("address <=", value, "address");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddressLike(java.lang.String value) {
            if (value != null)
              addCriterion("address like ", value, "address");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddressNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("address not like ", value, "address");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddressIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("address in ", value, "address");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddressNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("address not in ", value, "address");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddressBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("address between ", value1, value2, "address");
            return (AddressCriteria) this;
        }
        public AddressCriteria andAddressNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("address not between ", value1, value2, "address");
            return (AddressCriteria) this;
        }
        
        public AddressCriteria andPhonecode1IsNull() {
            addCriterion("phonecode1 is null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhonecode1IsNotNull() {
            addCriterion("phonecode1 is not null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhonecode1EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phonecode1 =", value, "phonecode1");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhonecode1NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phonecode1 <>", value, "phonecode1");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhonecode1GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("phonecode1 >", value, "phonecode1");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhonecode1GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phonecode1 >=", value, "phonecode1");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhonecode1LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("phonecode1 <", value, "phonecode1");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhonecode1LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phonecode1 <=", value, "phonecode1");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhonecode1Like(java.lang.String value) {
            if (value != null)
              addCriterion("phonecode1 like ", value, "phonecode1");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhonecode1NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("phonecode1 not like ", value, "phonecode1");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhonecode1In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("phonecode1 in ", value, "phonecode1");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhonecode1NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("phonecode1 not in ", value, "phonecode1");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhonecode1Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("phonecode1 between ", value1, value2, "phonecode1");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhonecode1NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("phonecode1 not between ", value1, value2, "phonecode1");
            return (AddressCriteria) this;
        }
        
        public AddressCriteria andPhonecode2IsNull() {
            addCriterion("phonecode2 is null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhonecode2IsNotNull() {
            addCriterion("phonecode2 is not null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhonecode2EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phonecode2 =", value, "phonecode2");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhonecode2NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phonecode2 <>", value, "phonecode2");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhonecode2GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("phonecode2 >", value, "phonecode2");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhonecode2GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phonecode2 >=", value, "phonecode2");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhonecode2LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("phonecode2 <", value, "phonecode2");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhonecode2LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phonecode2 <=", value, "phonecode2");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhonecode2Like(java.lang.String value) {
            if (value != null)
              addCriterion("phonecode2 like ", value, "phonecode2");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhonecode2NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("phonecode2 not like ", value, "phonecode2");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhonecode2In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("phonecode2 in ", value, "phonecode2");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhonecode2NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("phonecode2 not in ", value, "phonecode2");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhonecode2Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("phonecode2 between ", value1, value2, "phonecode2");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhonecode2NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("phonecode2 not between ", value1, value2, "phonecode2");
            return (AddressCriteria) this;
        }
        
        public AddressCriteria andPhone1IsNull() {
            addCriterion("phone1 is null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhone1IsNotNull() {
            addCriterion("phone1 is not null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhone1EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phone1 =", value, "phone1");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhone1NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phone1 <>", value, "phone1");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhone1GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("phone1 >", value, "phone1");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhone1GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phone1 >=", value, "phone1");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhone1LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("phone1 <", value, "phone1");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhone1LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phone1 <=", value, "phone1");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhone1Like(java.lang.String value) {
            if (value != null)
              addCriterion("phone1 like ", value, "phone1");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhone1NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("phone1 not like ", value, "phone1");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhone1In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("phone1 in ", value, "phone1");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhone1NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("phone1 not in ", value, "phone1");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhone1Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("phone1 between ", value1, value2, "phone1");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhone1NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("phone1 not between ", value1, value2, "phone1");
            return (AddressCriteria) this;
        }
        
        public AddressCriteria andPhone2IsNull() {
            addCriterion("phone2 is null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhone2IsNotNull() {
            addCriterion("phone2 is not null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhone2EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phone2 =", value, "phone2");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhone2NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phone2 <>", value, "phone2");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhone2GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("phone2 >", value, "phone2");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhone2GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phone2 >=", value, "phone2");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhone2LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("phone2 <", value, "phone2");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhone2LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phone2 <=", value, "phone2");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhone2Like(java.lang.String value) {
            if (value != null)
              addCriterion("phone2 like ", value, "phone2");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhone2NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("phone2 not like ", value, "phone2");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhone2In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("phone2 in ", value, "phone2");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhone2NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("phone2 not in ", value, "phone2");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhone2Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("phone2 between ", value1, value2, "phone2");
            return (AddressCriteria) this;
        }
        public AddressCriteria andPhone2NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("phone2 not between ", value1, value2, "phone2");
            return (AddressCriteria) this;
        }
        
        public AddressCriteria andWebsiteIsNull() {
            addCriterion("website is null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andWebsiteIsNotNull() {
            addCriterion("website is not null");
            return (AddressCriteria) this;
        }
        public AddressCriteria andWebsiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("website =", value, "website");
            return (AddressCriteria) this;
        }
        public AddressCriteria andWebsiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("website <>", value, "website");
            return (AddressCriteria) this;
        }
        public AddressCriteria andWebsiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("website >", value, "website");
            return (AddressCriteria) this;
        }
        public AddressCriteria andWebsiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("website >=", value, "website");
            return (AddressCriteria) this;
        }
        public AddressCriteria andWebsiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("website <", value, "website");
            return (AddressCriteria) this;
        }
        public AddressCriteria andWebsiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("website <=", value, "website");
            return (AddressCriteria) this;
        }
        public AddressCriteria andWebsiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("website like ", value, "website");
            return (AddressCriteria) this;
        }
        public AddressCriteria andWebsiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("website not like ", value, "website");
            return (AddressCriteria) this;
        }
        public AddressCriteria andWebsiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("website in ", value, "website");
            return (AddressCriteria) this;
        }
        public AddressCriteria andWebsiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("website not in ", value, "website");
            return (AddressCriteria) this;
        }
        public AddressCriteria andWebsiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("website between ", value1, value2, "website");
            return (AddressCriteria) this;
        }
        public AddressCriteria andWebsiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("website not between ", value1, value2, "website");
            return (AddressCriteria) this;
        }
    }
    
}

