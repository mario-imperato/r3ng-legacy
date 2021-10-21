//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.fivmember;

import java.util.ArrayList;
import java.util.List;

public class FIVMemberFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public FIVMemberFilter() 
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

    public FIVMemberCriteria or() 
    {
        FIVMemberCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public FIVMemberCriteria createCriteria() 
    {
        FIVMemberCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected FIVMemberCriteria createCriteriaInternal() 
    {
        FIVMemberCriteria criteria = new FIVMemberCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class FIVMemberCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public FIVMemberCriteria andCardnumberIsNull() {
            addCriterion("cardnumber is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardnumberIsNotNull() {
            addCriterion("cardnumber is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardnumberEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardnumber =", value, "cardnumber");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardnumberNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardnumber <>", value, "cardnumber");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardnumberGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardnumber >", value, "cardnumber");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardnumberGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardnumber >=", value, "cardnumber");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardnumberLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardnumber <", value, "cardnumber");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardnumberLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardnumber <=", value, "cardnumber");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardnumberLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardnumber like ", value, "cardnumber");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardnumberNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardnumber not like ", value, "cardnumber");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardnumberIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("cardnumber in ", value, "cardnumber");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardnumberNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("cardnumber not in ", value, "cardnumber");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardnumberBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardnumber between ", value1, value2, "cardnumber");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardnumberNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardnumber not between ", value1, value2, "cardnumber");
            return (FIVMemberCriteria) this;
        }
        
        public FIVMemberCriteria andCardnumberstatuscodeIsNull() {
            addCriterion("cardnumberstatuscode is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardnumberstatuscodeIsNotNull() {
            addCriterion("cardnumberstatuscode is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardnumberstatuscodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardnumberstatuscode =", value, "cardnumberstatuscode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardnumberstatuscodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardnumberstatuscode <>", value, "cardnumberstatuscode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardnumberstatuscodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardnumberstatuscode >", value, "cardnumberstatuscode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardnumberstatuscodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardnumberstatuscode >=", value, "cardnumberstatuscode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardnumberstatuscodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardnumberstatuscode <", value, "cardnumberstatuscode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardnumberstatuscodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardnumberstatuscode <=", value, "cardnumberstatuscode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardnumberstatuscodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardnumberstatuscode like ", value, "cardnumberstatuscode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardnumberstatuscodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardnumberstatuscode not like ", value, "cardnumberstatuscode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardnumberstatuscodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("cardnumberstatuscode in ", value, "cardnumberstatuscode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardnumberstatuscodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("cardnumberstatuscode not in ", value, "cardnumberstatuscode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardnumberstatuscodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardnumberstatuscode between ", value1, value2, "cardnumberstatuscode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardnumberstatuscodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardnumberstatuscode not between ", value1, value2, "cardnumberstatuscode");
            return (FIVMemberCriteria) this;
        }
        
        public FIVMemberCriteria andCardholdernameIsNull() {
            addCriterion("cardholdername is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardholdernameIsNotNull() {
            addCriterion("cardholdername is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardholdernameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardholdername =", value, "cardholdername");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardholdernameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardholdername <>", value, "cardholdername");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardholdernameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardholdername >", value, "cardholdername");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardholdernameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardholdername >=", value, "cardholdername");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardholdernameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardholdername <", value, "cardholdername");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardholdernameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardholdername <=", value, "cardholdername");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardholdernameLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardholdername like ", value, "cardholdername");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardholdernameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardholdername not like ", value, "cardholdername");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardholdernameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("cardholdername in ", value, "cardholdername");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardholdernameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("cardholdername not in ", value, "cardholdername");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardholdernameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardholdername between ", value1, value2, "cardholdername");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardholdernameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardholdername not between ", value1, value2, "cardholdername");
            return (FIVMemberCriteria) this;
        }
        
        public FIVMemberCriteria andCardholderlastnameIsNull() {
            addCriterion("cardholderlastname is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardholderlastnameIsNotNull() {
            addCriterion("cardholderlastname is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardholderlastnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardholderlastname =", value, "cardholderlastname");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardholderlastnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardholderlastname <>", value, "cardholderlastname");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardholderlastnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardholderlastname >", value, "cardholderlastname");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardholderlastnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardholderlastname >=", value, "cardholderlastname");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardholderlastnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardholderlastname <", value, "cardholderlastname");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardholderlastnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardholderlastname <=", value, "cardholderlastname");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardholderlastnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardholderlastname like ", value, "cardholderlastname");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardholderlastnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardholderlastname not like ", value, "cardholderlastname");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardholderlastnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("cardholderlastname in ", value, "cardholderlastname");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardholderlastnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("cardholderlastname not in ", value, "cardholderlastname");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardholderlastnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardholderlastname between ", value1, value2, "cardholderlastname");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardholderlastnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardholderlastname not between ", value1, value2, "cardholderlastname");
            return (FIVMemberCriteria) this;
        }
        
        public FIVMemberCriteria andMedexamexpirationdateIsNull() {
            addCriterion("medexamexpirationdate is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMedexamexpirationdateIsNotNull() {
            addCriterion("medexamexpirationdate is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMedexamexpirationdateEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("medexamexpirationdate =", value, "medexamexpirationdate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMedexamexpirationdateNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("medexamexpirationdate <>", value, "medexamexpirationdate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMedexamexpirationdateGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("medexamexpirationdate >", value, "medexamexpirationdate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMedexamexpirationdateGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("medexamexpirationdate >=", value, "medexamexpirationdate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMedexamexpirationdateLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("medexamexpirationdate <", value, "medexamexpirationdate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMedexamexpirationdateLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("medexamexpirationdate <=", value, "medexamexpirationdate");
            return (FIVMemberCriteria) this;
        }

        
        public FIVMemberCriteria andMedexamtypecodeIsNull() {
            addCriterion("medexamtypecode is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMedexamtypecodeIsNotNull() {
            addCriterion("medexamtypecode is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMedexamtypecodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("medexamtypecode =", value, "medexamtypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMedexamtypecodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("medexamtypecode <>", value, "medexamtypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMedexamtypecodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("medexamtypecode >", value, "medexamtypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMedexamtypecodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("medexamtypecode >=", value, "medexamtypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMedexamtypecodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("medexamtypecode <", value, "medexamtypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMedexamtypecodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("medexamtypecode <=", value, "medexamtypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMedexamtypecodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("medexamtypecode like ", value, "medexamtypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMedexamtypecodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("medexamtypecode not like ", value, "medexamtypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMedexamtypecodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("medexamtypecode in ", value, "medexamtypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMedexamtypecodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("medexamtypecode not in ", value, "medexamtypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMedexamtypecodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("medexamtypecode between ", value1, value2, "medexamtypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMedexamtypecodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("medexamtypecode not between ", value1, value2, "medexamtypecode");
            return (FIVMemberCriteria) this;
        }
        
        public FIVMemberCriteria andCardexpirationdateIsNull() {
            addCriterion("cardexpirationdate is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardexpirationdateIsNotNull() {
            addCriterion("cardexpirationdate is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardexpirationdateEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("cardexpirationdate =", value, "cardexpirationdate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardexpirationdateNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("cardexpirationdate <>", value, "cardexpirationdate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardexpirationdateGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("cardexpirationdate >", value, "cardexpirationdate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardexpirationdateGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("cardexpirationdate >=", value, "cardexpirationdate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardexpirationdateLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("cardexpirationdate <", value, "cardexpirationdate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCardexpirationdateLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("cardexpirationdate <=", value, "cardexpirationdate");
            return (FIVMemberCriteria) this;
        }

        
        public FIVMemberCriteria andBirthdateIsNull() {
            addCriterion("birthdate is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthdateIsNotNull() {
            addCriterion("birthdate is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthdateEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("birthdate =", value, "birthdate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthdateNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("birthdate <>", value, "birthdate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthdateGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("birthdate >", value, "birthdate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthdateGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("birthdate >=", value, "birthdate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthdateLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("birthdate <", value, "birthdate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthdateLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("birthdate <=", value, "birthdate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthdateLike(java.lang.String value) {
            if (value != null)
              addCriterion("birthdate like ", value, "birthdate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthdateNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("birthdate not like ", value, "birthdate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthdateIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("birthdate in ", value, "birthdate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthdateNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("birthdate not in ", value, "birthdate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthdateBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("birthdate between ", value1, value2, "birthdate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthdateNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("birthdate not between ", value1, value2, "birthdate");
            return (FIVMemberCriteria) this;
        }
        
        public FIVMemberCriteria andSexIsNull() {
            addCriterion("sex is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSexEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sex =", value, "sex");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSexNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sex <>", value, "sex");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSexGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("sex >", value, "sex");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSexGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sex >=", value, "sex");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSexLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("sex <", value, "sex");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSexLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sex <=", value, "sex");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSexLike(java.lang.String value) {
            if (value != null)
              addCriterion("sex like ", value, "sex");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSexNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("sex not like ", value, "sex");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSexIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("sex in ", value, "sex");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSexNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("sex not in ", value, "sex");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSexBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("sex between ", value1, value2, "sex");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSexNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("sex not between ", value1, value2, "sex");
            return (FIVMemberCriteria) this;
        }
        
        public FIVMemberCriteria andBirthplaceIsNull() {
            addCriterion("birthplace is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthplaceIsNotNull() {
            addCriterion("birthplace is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthplaceEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("birthplace =", value, "birthplace");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthplaceNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("birthplace <>", value, "birthplace");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthplaceGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("birthplace >", value, "birthplace");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthplaceGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("birthplace >=", value, "birthplace");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthplaceLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("birthplace <", value, "birthplace");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthplaceLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("birthplace <=", value, "birthplace");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthplaceLike(java.lang.String value) {
            if (value != null)
              addCriterion("birthplace like ", value, "birthplace");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthplaceNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("birthplace not like ", value, "birthplace");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthplaceIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("birthplace in ", value, "birthplace");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthplaceNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("birthplace not in ", value, "birthplace");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthplaceBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("birthplace between ", value1, value2, "birthplace");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthplaceNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("birthplace not between ", value1, value2, "birthplace");
            return (FIVMemberCriteria) this;
        }
        
        public FIVMemberCriteria andBirthdistrictIsNull() {
            addCriterion("birthdistrict is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthdistrictIsNotNull() {
            addCriterion("birthdistrict is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthdistrictEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("birthdistrict =", value, "birthdistrict");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthdistrictNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("birthdistrict <>", value, "birthdistrict");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthdistrictGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("birthdistrict >", value, "birthdistrict");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthdistrictGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("birthdistrict >=", value, "birthdistrict");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthdistrictLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("birthdistrict <", value, "birthdistrict");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthdistrictLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("birthdistrict <=", value, "birthdistrict");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthdistrictLike(java.lang.String value) {
            if (value != null)
              addCriterion("birthdistrict like ", value, "birthdistrict");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthdistrictNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("birthdistrict not like ", value, "birthdistrict");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthdistrictIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("birthdistrict in ", value, "birthdistrict");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthdistrictNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("birthdistrict not in ", value, "birthdistrict");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthdistrictBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("birthdistrict between ", value1, value2, "birthdistrict");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andBirthdistrictNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("birthdistrict not between ", value1, value2, "birthdistrict");
            return (FIVMemberCriteria) this;
        }
        
        public FIVMemberCriteria andSsnIsNull() {
            addCriterion("ssn is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSsnIsNotNull() {
            addCriterion("ssn is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSsnEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ssn =", value, "ssn");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSsnNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ssn <>", value, "ssn");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSsnGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("ssn >", value, "ssn");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSsnGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ssn >=", value, "ssn");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSsnLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("ssn <", value, "ssn");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSsnLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ssn <=", value, "ssn");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSsnLike(java.lang.String value) {
            if (value != null)
              addCriterion("ssn like ", value, "ssn");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSsnNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("ssn not like ", value, "ssn");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSsnIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("ssn in ", value, "ssn");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSsnNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("ssn not in ", value, "ssn");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSsnBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ssn between ", value1, value2, "ssn");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSsnNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ssn not between ", value1, value2, "ssn");
            return (FIVMemberCriteria) this;
        }
        
        public FIVMemberCriteria andAddressIsNull() {
            addCriterion("address is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andAddressEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("address =", value, "address");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andAddressNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("address <>", value, "address");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andAddressGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("address >", value, "address");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andAddressGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("address >=", value, "address");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andAddressLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("address <", value, "address");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andAddressLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("address <=", value, "address");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andAddressLike(java.lang.String value) {
            if (value != null)
              addCriterion("address like ", value, "address");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andAddressNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("address not like ", value, "address");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andAddressIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("address in ", value, "address");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andAddressNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("address not in ", value, "address");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andAddressBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("address between ", value1, value2, "address");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andAddressNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("address not between ", value1, value2, "address");
            return (FIVMemberCriteria) this;
        }
        
        public FIVMemberCriteria andStreetnumberIsNull() {
            addCriterion("streetnumber is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andStreetnumberIsNotNull() {
            addCriterion("streetnumber is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andStreetnumberEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("streetnumber =", value, "streetnumber");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andStreetnumberNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("streetnumber <>", value, "streetnumber");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andStreetnumberGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("streetnumber >", value, "streetnumber");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andStreetnumberGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("streetnumber >=", value, "streetnumber");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andStreetnumberLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("streetnumber <", value, "streetnumber");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andStreetnumberLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("streetnumber <=", value, "streetnumber");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andStreetnumberLike(java.lang.String value) {
            if (value != null)
              addCriterion("streetnumber like ", value, "streetnumber");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andStreetnumberNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("streetnumber not like ", value, "streetnumber");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andStreetnumberIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("streetnumber in ", value, "streetnumber");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andStreetnumberNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("streetnumber not in ", value, "streetnumber");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andStreetnumberBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("streetnumber between ", value1, value2, "streetnumber");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andStreetnumberNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("streetnumber not between ", value1, value2, "streetnumber");
            return (FIVMemberCriteria) this;
        }
        
        public FIVMemberCriteria andCityIsNull() {
            addCriterion("city is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCityEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("city =", value, "city");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCityNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("city <>", value, "city");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCityGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("city >", value, "city");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCityGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("city >=", value, "city");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCityLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("city <", value, "city");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCityLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("city <=", value, "city");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCityLike(java.lang.String value) {
            if (value != null)
              addCriterion("city like ", value, "city");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCityNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("city not like ", value, "city");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCityIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("city in ", value, "city");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCityNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("city not in ", value, "city");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCityBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("city between ", value1, value2, "city");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCityNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("city not between ", value1, value2, "city");
            return (FIVMemberCriteria) this;
        }
        
        public FIVMemberCriteria andZipcodeIsNull() {
            addCriterion("zipcode is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andZipcodeIsNotNull() {
            addCriterion("zipcode is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andZipcodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode =", value, "zipcode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andZipcodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode <>", value, "zipcode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andZipcodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode >", value, "zipcode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andZipcodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode >=", value, "zipcode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andZipcodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode <", value, "zipcode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andZipcodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode <=", value, "zipcode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andZipcodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode like ", value, "zipcode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andZipcodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode not like ", value, "zipcode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andZipcodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("zipcode in ", value, "zipcode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andZipcodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("zipcode not in ", value, "zipcode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andZipcodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("zipcode between ", value1, value2, "zipcode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andZipcodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("zipcode not between ", value1, value2, "zipcode");
            return (FIVMemberCriteria) this;
        }
        
        public FIVMemberCriteria andDistrictIsNull() {
            addCriterion("district is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andDistrictIsNotNull() {
            addCriterion("district is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andDistrictEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("district =", value, "district");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andDistrictNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("district <>", value, "district");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andDistrictGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("district >", value, "district");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andDistrictGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("district >=", value, "district");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andDistrictLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("district <", value, "district");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andDistrictLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("district <=", value, "district");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andDistrictLike(java.lang.String value) {
            if (value != null)
              addCriterion("district like ", value, "district");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andDistrictNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("district not like ", value, "district");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andDistrictIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("district in ", value, "district");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andDistrictNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("district not in ", value, "district");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andDistrictBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("district between ", value1, value2, "district");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andDistrictNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("district not between ", value1, value2, "district");
            return (FIVMemberCriteria) this;
        }
        
        public FIVMemberCriteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andPhoneEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phone =", value, "phone");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andPhoneNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phone <>", value, "phone");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andPhoneGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("phone >", value, "phone");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andPhoneGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phone >=", value, "phone");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andPhoneLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("phone <", value, "phone");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andPhoneLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phone <=", value, "phone");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andPhoneLike(java.lang.String value) {
            if (value != null)
              addCriterion("phone like ", value, "phone");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andPhoneNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("phone not like ", value, "phone");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andPhoneIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("phone in ", value, "phone");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andPhoneNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("phone not in ", value, "phone");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andPhoneBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("phone between ", value1, value2, "phone");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andPhoneNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("phone not between ", value1, value2, "phone");
            return (FIVMemberCriteria) this;
        }
        
        public FIVMemberCriteria andCellularIsNull() {
            addCriterion("cellular is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCellularIsNotNull() {
            addCriterion("cellular is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCellularEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cellular =", value, "cellular");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCellularNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cellular <>", value, "cellular");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCellularGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("cellular >", value, "cellular");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCellularGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cellular >=", value, "cellular");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCellularLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("cellular <", value, "cellular");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCellularLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cellular <=", value, "cellular");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCellularLike(java.lang.String value) {
            if (value != null)
              addCriterion("cellular like ", value, "cellular");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCellularNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("cellular not like ", value, "cellular");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCellularIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("cellular in ", value, "cellular");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCellularNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("cellular not in ", value, "cellular");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCellularBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cellular between ", value1, value2, "cellular");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCellularNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cellular not between ", value1, value2, "cellular");
            return (FIVMemberCriteria) this;
        }
        
        public FIVMemberCriteria andFaxIsNull() {
            addCriterion("fax is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andFaxIsNotNull() {
            addCriterion("fax is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andFaxEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fax =", value, "fax");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andFaxNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fax <>", value, "fax");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andFaxGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("fax >", value, "fax");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andFaxGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fax >=", value, "fax");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andFaxLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("fax <", value, "fax");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andFaxLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fax <=", value, "fax");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andFaxLike(java.lang.String value) {
            if (value != null)
              addCriterion("fax like ", value, "fax");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andFaxNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("fax not like ", value, "fax");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andFaxIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("fax in ", value, "fax");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andFaxNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("fax not in ", value, "fax");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andFaxBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("fax between ", value1, value2, "fax");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andFaxNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("fax not between ", value1, value2, "fax");
            return (FIVMemberCriteria) this;
        }
        
        public FIVMemberCriteria andEmailIsNull() {
            addCriterion("email is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andEmailEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("email =", value, "email");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andEmailNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("email <>", value, "email");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andEmailGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("email >", value, "email");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andEmailGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("email >=", value, "email");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andEmailLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("email <", value, "email");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andEmailLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("email <=", value, "email");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andEmailLike(java.lang.String value) {
            if (value != null)
              addCriterion("email like ", value, "email");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andEmailNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("email not like ", value, "email");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andEmailIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("email in ", value, "email");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andEmailNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("email not in ", value, "email");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andEmailBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("email between ", value1, value2, "email");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andEmailNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("email not between ", value1, value2, "email");
            return (FIVMemberCriteria) this;
        }
        
        public FIVMemberCriteria andRenewaldateIsNull() {
            addCriterion("renewaldate is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andRenewaldateIsNotNull() {
            addCriterion("renewaldate is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andRenewaldateEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("renewaldate =", value, "renewaldate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andRenewaldateNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("renewaldate <>", value, "renewaldate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andRenewaldateGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("renewaldate >", value, "renewaldate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andRenewaldateGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("renewaldate >=", value, "renewaldate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andRenewaldateLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("renewaldate <", value, "renewaldate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andRenewaldateLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("renewaldate <=", value, "renewaldate");
            return (FIVMemberCriteria) this;
        }

        
        public FIVMemberCriteria andYachtclubIsNull() {
            addCriterion("yachtclub is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andYachtclubIsNotNull() {
            addCriterion("yachtclub is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andYachtclubEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtclub =", value, "yachtclub");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andYachtclubNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtclub <>", value, "yachtclub");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andYachtclubGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("yachtclub >", value, "yachtclub");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andYachtclubGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtclub >=", value, "yachtclub");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andYachtclubLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("yachtclub <", value, "yachtclub");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andYachtclubLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtclub <=", value, "yachtclub");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andYachtclubLike(java.lang.String value) {
            if (value != null)
              addCriterion("yachtclub like ", value, "yachtclub");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andYachtclubNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("yachtclub not like ", value, "yachtclub");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andYachtclubIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("yachtclub in ", value, "yachtclub");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andYachtclubNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("yachtclub not in ", value, "yachtclub");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andYachtclubBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("yachtclub between ", value1, value2, "yachtclub");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andYachtclubNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("yachtclub not between ", value1, value2, "yachtclub");
            return (FIVMemberCriteria) this;
        }
        
        public FIVMemberCriteria andMembertypecodeIsNull() {
            addCriterion("membertypecode is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMembertypecodeIsNotNull() {
            addCriterion("membertypecode is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMembertypecodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("membertypecode =", value, "membertypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMembertypecodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("membertypecode <>", value, "membertypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMembertypecodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("membertypecode >", value, "membertypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMembertypecodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("membertypecode >=", value, "membertypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMembertypecodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("membertypecode <", value, "membertypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMembertypecodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("membertypecode <=", value, "membertypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMembertypecodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("membertypecode like ", value, "membertypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMembertypecodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("membertypecode not like ", value, "membertypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMembertypecodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("membertypecode in ", value, "membertypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMembertypecodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("membertypecode not in ", value, "membertypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMembertypecodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("membertypecode between ", value1, value2, "membertypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andMembertypecodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("membertypecode not between ", value1, value2, "membertypecode");
            return (FIVMemberCriteria) this;
        }
        
        public FIVMemberCriteria andActivitytypecodeIsNull() {
            addCriterion("activitytypecode is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andActivitytypecodeIsNotNull() {
            addCriterion("activitytypecode is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andActivitytypecodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("activitytypecode =", value, "activitytypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andActivitytypecodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("activitytypecode <>", value, "activitytypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andActivitytypecodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("activitytypecode >", value, "activitytypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andActivitytypecodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("activitytypecode >=", value, "activitytypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andActivitytypecodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("activitytypecode <", value, "activitytypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andActivitytypecodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("activitytypecode <=", value, "activitytypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andActivitytypecodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("activitytypecode like ", value, "activitytypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andActivitytypecodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("activitytypecode not like ", value, "activitytypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andActivitytypecodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("activitytypecode in ", value, "activitytypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andActivitytypecodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("activitytypecode not in ", value, "activitytypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andActivitytypecodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("activitytypecode between ", value1, value2, "activitytypecode");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andActivitytypecodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("activitytypecode not between ", value1, value2, "activitytypecode");
            return (FIVMemberCriteria) this;
        }
        
        public FIVMemberCriteria andSystemcheckdateIsNull() {
            addCriterion("systemcheckdate is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSystemcheckdateIsNotNull() {
            addCriterion("systemcheckdate is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSystemcheckdateEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("systemcheckdate =", value, "systemcheckdate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSystemcheckdateNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("systemcheckdate <>", value, "systemcheckdate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSystemcheckdateGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("systemcheckdate >", value, "systemcheckdate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSystemcheckdateGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("systemcheckdate >=", value, "systemcheckdate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSystemcheckdateLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("systemcheckdate <", value, "systemcheckdate");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andSystemcheckdateLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("systemcheckdate <=", value, "systemcheckdate");
            return (FIVMemberCriteria) this;
        }

        
        public FIVMemberCriteria andVerificationrequiredIsNull() {
            addCriterion("verificationrequired is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andVerificationrequiredIsNotNull() {
            addCriterion("verificationrequired is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andVerificationrequiredEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("verificationrequired =", value, "verificationrequired");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andVerificationrequiredNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("verificationrequired <>", value, "verificationrequired");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andVerificationrequiredGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("verificationrequired >", value, "verificationrequired");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andVerificationrequiredGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("verificationrequired >=", value, "verificationrequired");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andVerificationrequiredLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("verificationrequired <", value, "verificationrequired");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andVerificationrequiredLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("verificationrequired <=", value, "verificationrequired");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andVerificationrequiredLike(java.lang.String value) {
            if (value != null)
              addCriterion("verificationrequired like ", value, "verificationrequired");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andVerificationrequiredNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("verificationrequired not like ", value, "verificationrequired");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andVerificationrequiredIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("verificationrequired in ", value, "verificationrequired");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andVerificationrequiredNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("verificationrequired not in ", value, "verificationrequired");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andVerificationrequiredBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("verificationrequired between ", value1, value2, "verificationrequired");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andVerificationrequiredNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("verificationrequired not between ", value1, value2, "verificationrequired");
            return (FIVMemberCriteria) this;
        }
        
        public FIVMemberCriteria andCreatetimestampIsNull() {
            addCriterion("createtimestamp is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCreatetimestampIsNotNull() {
            addCriterion("createtimestamp is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCreatetimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("createtimestamp =", value, "createtimestamp");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCreatetimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("createtimestamp <>", value, "createtimestamp");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCreatetimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("createtimestamp >", value, "createtimestamp");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCreatetimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("createtimestamp >=", value, "createtimestamp");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCreatetimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("createtimestamp <", value, "createtimestamp");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andCreatetimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("createtimestamp <=", value, "createtimestamp");
            return (FIVMemberCriteria) this;
        }

        
        public FIVMemberCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (FIVMemberCriteria) this;
        }
        public FIVMemberCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (FIVMemberCriteria) this;
        }

    }
    
}

